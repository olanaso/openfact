package org.openfact.services.managers;

import org.openfact.cluster.ClusterEvent;
import org.openfact.cluster.ClusterListener;
import org.openfact.cluster.ClusterProvider;
import org.openfact.cluster.ExecutionResult;
import org.openfact.common.util.Time;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OpenfactSessionTask;
import org.openfact.services.ServicesLogger;
import org.openfact.timer.TimerProvider;


import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Callable;


public class UsersSyncManager {

    private static final String FEDERATION_TASK_KEY = "federation";

    protected static final ServicesLogger logger = ServicesLogger.ROOT_LOGGER;

    /**
     * Check federationProviderModel of all realms and possibly start periodic sync for them
     *
     * @param sessionFactory
     * @param timer
     */
    public void bootstrapPeriodic(final OpenfactSessionFactory sessionFactory, final TimerProvider timer) {
        /*OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                List<RealmModel> realms = session.realms().getRealms();
                for (final RealmModel realm : realms) {
                    List<UserFederationProviderModel> federationProviders = realm.getUserFederationProviders();
                    for (final UserFederationProviderModel fedProvider : federationProviders) {
                        refreshPeriodicSyncForProvider(sessionFactory, timer, fedProvider, realm.getId());
                    }
                }

                ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
                clusterProvider.registerListener(FEDERATION_TASK_KEY, new UserFederationClusterListener(sessionFactory));
            }
        });*/
    }


    private class Holder {
        //ExecutionResult<UserFederationSyncResult> result;
    }

    //public UserFederationSyncResult syncAllUsers(final OpenfactSessionFactory sessionFactory, final String realmId, final UserFederationProviderModel fedProvider) {
        //final Holder holder = new Holder();

        // Ensure not executed concurrently on this or any other cluster node
        /*OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
                // shared key for "full" and "changed" . Improve if needed
                String taskKey = fedProvider.getId() + "::sync";

                // 30 seconds minimal timeout for now
                int timeout = Math.max(30, fedProvider.getFullSyncPeriod());
                holder.result = clusterProvider.executeIfNotExecuted(taskKey, timeout, new Callable<UserFederationSyncResult>() {

                    @Override
                    public UserFederationSyncResult call() throws Exception {
                        final UserFederationProviderFactory fedProviderFactory = (UserFederationProviderFactory) sessionFactory.getProviderFactory(UserFederationProvider.class, fedProvider.getProviderName());
                        updateLastSyncInterval(sessionFactory, fedProvider, realmId);
                        return fedProviderFactory.syncAllUsers(sessionFactory, realmId, fedProvider);
                    }

                });
            }

        });

        if (holder.result == null || !holder.result.isExecuted()) {
            logger.debugf("syncAllUsers for federation provider %s was ignored as it's already in progress", fedProvider.getDisplayName());
            return UserFederationSyncResult.ignored();
        } else {
            return holder.result.getResult();
        }*/
    //}

    //public UserFederationSyncResult syncChangedUsers(final OpenfactSessionFactory sessionFactory, final String realmId, final UserFederationProviderModel fedProvider) {
        //final Holder holder = new Holder();

        // Ensure not executed concurrently on this or any other cluster node
        /*OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {

            @Override
            public void run(OpenfactSession session) {
                ClusterProvider clusterProvider = session.getProvider(ClusterProvider.class);
                // shared key for "full" and "changed" . Improve if needed
                String taskKey = fedProvider.getId() + "::sync";

                // 30 seconds minimal timeout for now
                int timeout = Math.max(30, fedProvider.getChangedSyncPeriod());
                holder.result = clusterProvider.executeIfNotExecuted(taskKey, timeout, new Callable<UserFederationSyncResult>() {

                    @Override
                    public UserFederationSyncResult call() throws Exception {
                        final UserFederationProviderFactory fedProviderFactory = (UserFederationProviderFactory) sessionFactory.getProviderFactory(UserFederationProvider.class, fedProvider.getProviderName());

                        // See when we did last sync.
                        int oldLastSync = fedProvider.getLastSync();
                        updateLastSyncInterval(sessionFactory, fedProvider, realmId);
                        return fedProviderFactory.syncChangedUsers(sessionFactory, realmId, fedProvider, Time.toDate(oldLastSync));
                    }

                });
            }

        });

        if (holder.result == null || !holder.result.isExecuted()) {
            logger.debugf("syncChangedUsers for federation provider %s was ignored as it's already in progress", fedProvider.getDisplayName());
            return UserFederationSyncResult.ignored();
        } else {
            return holder.result.getResult();
        }*/
    //}


    // Ensure all cluster nodes are notified
//    public void notifyToRefreshPeriodicSync(OpenfactSession session, RealmModel realm, UserFederationProviderModel federationProvider, boolean removed) {
//        FederationProviderClusterEvent event = FederationProviderClusterEvent.createEvent(removed, realm.getId(), federationProvider);
//        session.getProvider(ClusterProvider.class).notify(FEDERATION_TASK_KEY, event);
//    }


    // Executed once it receives notification that some UserFederationProvider was created or updated
//    protected void refreshPeriodicSyncForProvider(final OpenfactSessionFactory sessionFactory, TimerProvider timer, final UserFederationProviderModel fedProvider, final String realmId) {
//        logger.debugf("Going to refresh periodic sync for provider '%s' . Full sync period: %d , changed users sync period: %d",
//                fedProvider.getDisplayName(), fedProvider.getFullSyncPeriod(), fedProvider.getChangedSyncPeriod());
//
//        if (fedProvider.getFullSyncPeriod() > 0) {
//            // We want periodic full sync for this provider
//            timer.schedule(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        boolean shouldPerformSync = shouldPerformNewPeriodicSync(fedProvider.getLastSync(), fedProvider.getChangedSyncPeriod());
//                        if (shouldPerformSync) {
//                            syncAllUsers(sessionFactory, realmId, fedProvider);
//                        } else {
//                            logger.debugf("Ignored periodic full sync with federation provider %s due small time since last sync", fedProvider.getDisplayName());
//                        }
//                    } catch (Throwable t) {
//                        logger.errorDuringFullUserSync(t);
//                    }
//                }
//
//            }, fedProvider.getFullSyncPeriod() * 1000, fedProvider.getId() + "-FULL");
//        } else {
//            timer.cancelTask(fedProvider.getId() + "-FULL");
//        }
//
//        if (fedProvider.getChangedSyncPeriod() > 0) {
//            // We want periodic sync of just changed users for this provider
//            timer.schedule(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        boolean shouldPerformSync = shouldPerformNewPeriodicSync(fedProvider.getLastSync(), fedProvider.getChangedSyncPeriod());
//                        if (shouldPerformSync) {
//                            syncChangedUsers(sessionFactory, realmId, fedProvider);
//                        } else {
//                            logger.debugf("Ignored periodic changed-users sync with federation provider %s due small time since last sync", fedProvider.getDisplayName());
//                        }
//                    } catch (Throwable t) {
//                        logger.errorDuringChangedUserSync(t);
//                    }
//                }
//
//            }, fedProvider.getChangedSyncPeriod() * 1000, fedProvider.getId() + "-CHANGED");
//
//        } else {
//            timer.cancelTask(fedProvider.getId() + "-CHANGED");
//        }
//    }

    // Skip syncing if there is short time since last sync time.
    private boolean shouldPerformNewPeriodicSync(int lastSyncTime, int period) {
        if (lastSyncTime <= 0) {
            return true;
        }

        int currentTime = Time.currentTime();
        int timeSinceLastSync = currentTime - lastSyncTime;

        return (timeSinceLastSync * 2 > period);
    }

    // Executed once it receives notification that some UserFederationProvider was removed
//    protected void removePeriodicSyncForProvider(TimerProvider timer, UserFederationProviderModel fedProvider) {
//        logger.debugf("Removing periodic sync for provider %s", fedProvider.getDisplayName());
//        timer.cancelTask(fedProvider.getId() + "-FULL");
//        timer.cancelTask(fedProvider.getId() + "-CHANGED");
//    }

    // Update interval of last sync for given UserFederationProviderModel. Do it in separate transaction
//    private void updateLastSyncInterval(final OpenfactSessionFactory sessionFactory, final UserFederationProviderModel fedProvider, final String realmId) {
//        OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {
//
//            @Override
//            public void run(OpenfactSession session) {
//                RealmModel persistentRealm = session.realms().getRealm(realmId);
//                List<UserFederationProviderModel> persistentFedProviders = persistentRealm.getUserFederationProviders();
//                for (UserFederationProviderModel persistentFedProvider : persistentFedProviders) {
//                    if (fedProvider.getId().equals(persistentFedProvider.getId())) {
//                        // Update persistent provider in DB
//                        int lastSync = Time.currentTime();
//                        persistentFedProvider.setLastSync(lastSync);
//                        persistentRealm.updateUserFederationProvider(persistentFedProvider);
//
//                        // Update "cached" reference
//                        fedProvider.setLastSync(lastSync);
//                    }
//                }
//            }
//
//        });
//    }


//    private class UserFederationClusterListener implements ClusterListener {
//
//        private final OpenfactSessionFactory sessionFactory;
//
//        public UserFederationClusterListener(OpenfactSessionFactory sessionFactory) {
//            this.sessionFactory = sessionFactory;
//        }
//
//        @Override
//        public void run(ClusterEvent event) {
//            final FederationProviderClusterEvent fedEvent = (FederationProviderClusterEvent) event;
//            OpenfactModelUtils.runJobInTransaction(sessionFactory, new OpenfactSessionTask() {
//
//                @Override
//                public void run(OpenfactSession session) {
//                    TimerProvider timer = session.getProvider(TimerProvider.class);
//                    if (fedEvent.isRemoved()) {
//                        removePeriodicSyncForProvider(timer, fedEvent.getFederationProvider());
//                    } else {
//                        refreshPeriodicSyncForProvider(sessionFactory, timer, fedEvent.getFederationProvider(), fedEvent.getRealmId());
//                    }
//                }
//
//            });
//        }
//    }


    // Send to cluster during each update or remove of federationProvider, so all nodes can update sync periods
//    public static class FederationProviderClusterEvent implements ClusterEvent {
//
//        private boolean removed;
//        private String realmId;
//        private UserFederationProviderModel federationProvider;
//
//        public boolean isRemoved() {
//            return removed;
//        }
//
//        public void setRemoved(boolean removed) {
//            this.removed = removed;
//        }
//
//        public String getRealmId() {
//            return realmId;
//        }
//
//        public void setRealmId(String realmId) {
//            this.realmId = realmId;
//        }
//
//        public UserFederationProviderModel getFederationProvider() {
//            return federationProvider;
//        }
//
//        public void setFederationProvider(UserFederationProviderModel federationProvider) {
//            this.federationProvider = federationProvider;
//        }
//
//        public static FederationProviderClusterEvent createEvent(boolean removed, String realmId, UserFederationProviderModel fedProvider) {
//            FederationProviderClusterEvent notification = new FederationProviderClusterEvent();
//            notification.setRemoved(removed);
//            notification.setRealmId(realmId);
//            notification.setFederationProvider(fedProvider);
//            return notification;
//        }
//    }

}
