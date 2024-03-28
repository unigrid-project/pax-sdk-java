package org.unigrid.pax.sdk.cosmos.service;

public class UnigridServiceFactory {

	public static UnigridService createService() {
		GrpcService grpcService = new GrpcService();
		return new UnigridService(grpcService);
	}
}
