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
package org.openfact.services.scheduled;

import org.openfact.models.*;
import org.openfact.models.enums.RequiredAction;
import org.openfact.services.managers.CreditNoteManager;
import org.openfact.services.managers.DebitNoteManager;
import org.openfact.services.managers.InvoiceManager;
import org.openfact.ubl.SendEventModel;
import org.openfact.ubl.SendException;

import java.util.Iterator;
import java.util.List;

public class SendToThridPartyOrganizationScheduleTaskProvider implements OrganizationScheduleTaskProvider {

    public static final String JOB_NAME = "SENT_TO_THRID_PARTY";
    public static final int RETRY = 20;

    protected boolean isActive;

    public SendToThridPartyOrganizationScheduleTaskProvider(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public void close() {
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void run(OpenfactSession session, OrganizationModel organization) {
        // Start Job
        long startTime = System.currentTimeMillis();
        long readCount = 0;

        readCount += sendInvoices(session, organization);
        readCount += sendCreditNotes(session, organization);
        readCount += sendDebitNotes(session, organization);

        long endTime = System.currentTimeMillis();

        // Save Report
        JobReportModel jobReportModel = session.jobReports().createJobReport(organization, JOB_NAME);

        // Metrics
        jobReportModel.setStartTime(startTime);
        jobReportModel.setEndTime(endTime);
        jobReportModel.setDuration(endTime - startTime);
        jobReportModel.setReadCount(readCount);
    }

    private long sendInvoices(OpenfactSession session, OrganizationModel organization) {
        long readCount = 0;

        ScrollModel<List<InvoiceModel>> scroll = session.invoices().getInvoicesScroll(organization, 100, RequiredAction.SEND_TO_TRIRD_PARTY.toString());
        Iterator<List<InvoiceModel>> iterator = scroll.iterator();

        while (iterator.hasNext()) {
            List<InvoiceModel> invoices = iterator.next();

            readCount += invoices.size();

            invoices.stream()
                    .filter(p -> p.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY.toString()))
                    .filter(p -> p.getSendEvents().size() < RETRY)
                    .forEach(c -> {
                        InvoiceManager manager = new InvoiceManager(session);
                        try {
                            SendEventModel sendEvent = manager.sendToTrirdParty(organization, c);
                            if (sendEvent.getResult()) {
                                c.removeRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
                            }
                        } catch (SendException e) {
                            throw new JobException("error on execute job", e);
                        }
                    });
        }

        return readCount;
    }

    private long sendCreditNotes(OpenfactSession session, OrganizationModel organization) {
        long readCount = 0;

        ScrollModel<List<CreditNoteModel>> scroll = session.creditNotes().getCreditNotesScroll(organization, 100, RequiredAction.SEND_TO_TRIRD_PARTY.toString());
        Iterator<List<CreditNoteModel>> iterator = scroll.iterator();

        while (iterator.hasNext()) {
            List<CreditNoteModel> creditNotes = iterator.next();

            readCount += creditNotes.size();

            creditNotes.stream()
                    .filter(p -> p.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY))
                    .filter(p -> p.getSendEvents().size() < RETRY)
                    .forEach(c -> {
                        CreditNoteManager manager = new CreditNoteManager(session);
                        try {
                            SendEventModel sendEvent = manager.sendToTrirdParty(organization, c);
                            if (sendEvent.getResult()) {
                                c.removeRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
                            }
                        } catch (SendException e) {
                            throw new JobException("error on execute job", e);
                        }
                    });
        }

        return readCount;
    }

    private long sendDebitNotes(OpenfactSession session, OrganizationModel organization) {
        long readCount = 0;

        ScrollModel<List<DebitNoteModel>> scroll = session.debitNotes().getDebitNotesScroll(organization, 100, RequiredAction.SEND_TO_TRIRD_PARTY.toString());
        Iterator<List<DebitNoteModel>> iterator = scroll.iterator();

        while (iterator.hasNext()) {
            List<DebitNoteModel> debitNotes = iterator.next();

            readCount += debitNotes.size();

            debitNotes.stream()
                    .filter(p -> p.getRequiredActions().contains(RequiredAction.SEND_TO_TRIRD_PARTY))
                    .filter(p -> p.getSendEvents().size() < RETRY)
                    .forEach(c -> {
                        DebitNoteManager manager = new DebitNoteManager(session);
                        try {
                            SendEventModel sendEvent = manager.sendToTrirdParty(organization, c);
                            if (sendEvent.getResult()) {
                                c.removeRequiredAction(RequiredAction.SEND_TO_TRIRD_PARTY);
                            }
                        } catch (SendException e) {
                            throw new JobException("error on execute job", e);
                        }
                    });
        }

        return readCount;
    }

}