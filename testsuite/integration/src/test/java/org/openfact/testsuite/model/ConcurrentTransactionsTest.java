/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.testsuite.model;

import org.jboss.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openfact.models.*;
import org.openfact.models.utils.OpenfactModelUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class ConcurrentTransactionsTest extends AbstractModelTest {

    private static final Logger logger = Logger.getLogger(ConcurrentTransactionsTest.class);

    @Test
    public void persistClient() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        InvoiceModel invoice = session.invoices().addInvoice(organization, "F01-123");
        invoice.setDocumentCurrencyCode("PEN");

        String invoiceDBId = invoice.getId();

        final OpenfactSessionFactory sessionFactory = session.getOpenfactSessionFactory();
        commit();

        final CountDownLatch transactionsCounter = new CountDownLatch(2);
        final CountDownLatch readLatch = new CountDownLatch(1);
        final CountDownLatch updateLatch = new CountDownLatch(1);

        Thread thread1 = new Thread() {

            @Override
            public void run() {
                OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                    @Override
                    public void run(OpenfactSession session) {
                        try {
                            // Wait until transaction in both threads started
                            transactionsCounter.countDown();
                            logger.info("transaction1 started");
                            transactionsCounter.await();

                            // Read client
                            OrganizationModel organization = session.organizations().getOrganizationByName("original");
                            InvoiceModel invoice = session.invoices().getInvoiceByDocumentId(organization, "F01-123");
                            logger.info("transaction1: Read invoice finished");
                            readLatch.countDown();

                            // Wait until thread2 updates client and commits
                            updateLatch.await();
                            logger.info("transaction1: Going to read invoice again");

                            invoice = session.invoices().getInvoiceByDocumentId(organization, "F01-123");
                            logger.info("transaction1: document currency code: " + invoice.getDocumentCurrencyCode());
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                });
            }

        };

        Thread thread2 = new Thread() {

            @Override
            public void run() {
                OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                    @Override
                    public void run(OpenfactSession session) {
                        try {
                            // Wait until transaction in both threads started
                            transactionsCounter.countDown();
                            logger.info("transaction2 started");
                            transactionsCounter.await();


                            readLatch.await();
                            logger.info("transaction2: Going to update document currency code");

                            OrganizationModel organization = session.organizations().getOrganizationByName("original");
                            InvoiceModel invoice = session.invoices().getInvoiceByDocumentId(organization, "F01-123");
                            invoice.setDocumentCurrencyCode("new");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                });

                logger.info("transaction2: commited");
                updateLatch.countDown();
            }

        };

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        logger.info("after thread join");

        commit();

        session = organizationManager.getSession();

        organization = session.organizations().getOrganizationByName("original");
        InvoiceModel invoiceFromCache = session.invoices().getInvoiceById(organization, invoiceDBId);
        InvoiceModel invoiceFromDB = session.getProvider(InvoiceProvider.class).getInvoiceById(organization, invoiceDBId);

        logger.info("SECRET FROM DB : " + invoiceFromDB.getDocumentCurrencyCode());
        logger.info("SECRET FROM CACHE : " + invoiceFromCache.getDocumentCurrencyCode());

        Assert.assertEquals("new", invoiceFromDB.getDocumentCurrencyCode());
        Assert.assertEquals("new", invoiceFromCache.getDocumentCurrencyCode());
    }


    // KEYCLOAK-3296 , KEYCLOAK-3494
    @Test
    public void removeOrganizationAttribute() throws Exception {
        OrganizationModel organization = organizationManager.createOrganization("original");
        OpenfactSession session = organizationManager.getSession();

        InvoiceModel invoice1 = session.invoices().addInvoice(organization, "F01-12");
        invoice1.setSingleAttribute("foo", "val1");

        InvoiceModel invoice2 = session.invoices().addInvoice(organization, "F01-123");
        invoice2.setSingleAttribute("foo", "val2");

        final OpenfactSessionFactory sessionFactory = session.getOpenfactSessionFactory();
        commit();

        AtomicReference<Exception> reference = new AtomicReference<>();

        final CountDownLatch readAttrLatch = new CountDownLatch(2);

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                        @Override
                        public void run(OpenfactSession session) {
                            try {
                                // Read user attribute
                                OrganizationModel organization = session.organizations().getOrganizationByName("original");
                                InvoiceModel invoice1 = session.invoices().getInvoiceByDocumentId(organization, "F01-12");
                                String attrVal = invoice1.getFirstAttribute("foo");

                                InvoiceModel invoice2 = session.invoices().getInvoiceByDocumentId(organization, "F01-123");
                                String attrVal2 = invoice2.getFirstAttribute("foo");

                                // Wait until it's read in both threads
                                readAttrLatch.countDown();
                                readAttrLatch.await();

                                // KEYCLOAK-3296 : Remove user attribute in both threads
                                invoice1.removeAttribute("foo");

                                // KEYCLOAK-3494 : Set single attribute in both threads
                                invoice2.setSingleAttribute("foo", "bar");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }

                    });
                } catch (Exception e) {
                    reference.set(e);
                    throw new RuntimeException(e);
                } finally {
                    readAttrLatch.countDown();
                }
            }

        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        logger.info("removeInvoiceAttribute: after thread join");

        commit();

        if (reference.get() != null) {
            Assert.fail("Exception happened in some of threads. Details: " + reference.get().getMessage());
        }
    }

}
