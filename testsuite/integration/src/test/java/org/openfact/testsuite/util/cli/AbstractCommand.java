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

package org.openfact.testsuite.util.cli;

import java.util.List;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.models.utils.OpenfactModelUtils;

/**
 * @author <a href="mailto:mposolda@sistcoop.com">Marek Posolda</a>
 */
public abstract class AbstractCommand {

    protected final Logger log = Logger.getLogger(this.getClass().getName());

    protected List<String> args;
    protected OpenfactSessionFactory sessionFactory;

    public void injectProperties(List<String> args, TestsuiteCLI cli, OpenfactSessionFactory sessionFactory) {
        this.args = args;
        this.sessionFactory = sessionFactory;
    }

    public void runCommand() {
        try {
            OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

                @Override
                public void run(OpenfactSession session) {
                    doRunCommand(session);
                }

            });
        } catch (HandledException handled) {
            // Fine to ignore. Was handled already
        } catch (RuntimeException e) {
            log.error("Error occured during command. ", e);
        }
    }

    public abstract String getName();
    protected abstract void doRunCommand(OpenfactSession session);

    protected String getArg(int index) {
        try {
            return args.get(index);
        } catch (IndexOutOfBoundsException ex) {
            log.errorf("Usage: %s", printUsage());
            throw new HandledException();
        }
    }

    protected Integer getIntArg(int index) {
        String str = getArg(index);
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nex) {
            log.errorf("Usage: %s", printUsage());
            throw new HandledException();
        }
    }

    public String printUsage() {
        return getName();
    }

    public static class HandledException extends RuntimeException {
    }

}
