//package com.lsy.learn.projectlsy.grpcServer.serviceImpl;
//
//import com.lsy.learn.projectlsy.SearchServiceGrpc;
//import com.lsy.learn.projectlsy.Test;
//import com.lsy.learn.projectlsy.grpcModel.StreamObserverDelegate;
//import io.grpc.stub.StreamObserver;
//import lombok.extern.slf4j.Slf4j;
//import net.devh.boot.grpc.server.service.GrpcService;
//
//@Slf4j
//@GrpcService
//public class GrpcInterfaceTestImpl extends SearchServiceGrpc.SearchServiceImplBase {
//
//    @Override
//    public void search(Test request,
//                       StreamObserver<Test> responseObserver) {
//
//        StreamObserverDelegate<Test, Test> streamObserverDelegate =
//                new StreamObserverDelegate<>(responseObserver, Test.newBuilder().build());
//        streamObserverDelegate.executeWithException(() ->
//                Test.newBuilder()
//                        .setQuery("hahahaha")
//                        .build()
//        );
//    }
//
//}
