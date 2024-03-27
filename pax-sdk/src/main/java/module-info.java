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
}
