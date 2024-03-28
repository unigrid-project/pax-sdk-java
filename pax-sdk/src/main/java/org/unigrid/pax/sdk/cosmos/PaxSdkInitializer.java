package org.unigrid.pax.sdk.cosmos;

import jakarta.enterprise.context.ApplicationScoped;
import org.unigrid.pax.sdk.cosmos.service.GrpcService;
import org.unigrid.pax.sdk.cosmos.service.UnigridService;

@ApplicationScoped
public class PaxSdkInitializer {
    private static PaxSdkInitializer instance;
    private GrpcService grpcService;
    private UnigridService unigridService;

    private PaxSdkInitializer() {
        // Initialize GrpcService
        grpcService = new GrpcService();

        // Initialize UnigridService with the GrpcService instance
        unigridService = new UnigridService();
    }

    public static synchronized PaxSdkInitializer getInstance() {
        if (instance == null) {
            instance = new PaxSdkInitializer();
        }
        return instance;
    }

    public GrpcService getGrpcService() {
        return grpcService;
    }

    public UnigridService getUnigridService() {
        return unigridService;
    }
}