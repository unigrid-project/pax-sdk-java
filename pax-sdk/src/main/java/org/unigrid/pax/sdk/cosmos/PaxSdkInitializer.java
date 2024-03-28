package org.unigrid.pax.sdk.cosmos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.unigrid.pax.sdk.cosmos.service.GrpcService;
import org.unigrid.pax.sdk.cosmos.service.UnigridService;

@ApplicationScoped
public class PaxSdkInitializer {

    @Inject
    private GrpcService grpcService;

    @Inject
    private UnigridService unigridService;

    public GrpcService getGrpcService() {
        return grpcService;
    }

    public UnigridService getUnigridService() {
        return unigridService;
    }
}