module paxsdk {
	requires static lombok;
	requires protobuf.java.util;
	requires protobuf.java;
	requires crypto;
	requires jakarta.cdi;
	requires com.fasterxml.jackson.annotation;
	requires com.fasterxml.jackson.databind;
	requires proto.google.common.protos;
	requires io.grpc;
	requires io.grpc.stub;
	requires io.grpc.protobuf;
	requires com.google.common;
	requires java.net.http;
	requires org.bitcoinj.core;
	requires org.bouncycastle.provider;
	// Exporting packages
	exports org.unigrid.pax.sdk.cosmos;
	exports org.unigrid.pax.sdk.cosmos.model;
	exports gridnode.gridnode.v1;
	exports cosmos.auth.v1beta1;
	exports cosmos.bank.v1beta1;
	exports cosmos.base.v1beta1;
	exports cosmos.crypto.multisig;
	exports cosmos.crypto.multisig.v1beta1;
	exports cosmos.distribution.v1beta1;
	exports cosmos.tx.v1beta1;
	exports cosmos.base.abci.v1beta1;
	exports cosmos.gov.v1beta1;
	exports cosmos.staking.v1beta1;
	exports cosmos.crypto.secp256k1;
	exports ibc.lightclients.tendermint.v1;	
}
