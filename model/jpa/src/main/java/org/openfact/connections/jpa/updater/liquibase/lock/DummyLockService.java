package org.openfact.connections.jpa.updater.liquibase.lock;

import liquibase.exception.DatabaseException;
import liquibase.exception.LockException;
import liquibase.lockservice.StandardLockService;

/**
 * Dummy lock service injected to Liquibase. Doesn't need to do anything as we already have a lock when Liquibase update is called.
 */
public class DummyLockService extends StandardLockService {

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void init() throws DatabaseException {
    }

    @Override
    public void waitForLock() throws LockException {
    }

    @Override
    public void releaseLock() throws LockException {
    }

}
