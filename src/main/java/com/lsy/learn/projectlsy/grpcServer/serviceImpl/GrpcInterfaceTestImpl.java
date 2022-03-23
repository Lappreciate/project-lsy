package com.lsy.learn.projectlsy.grpcServer.serviceImpl;

import com.lsy.learn.projectlsy.grpcServer.service.GrpcInterfaceTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GrpcInterfaceTestImpl implements GrpcInterfaceTest {

    @Override
    public void test(){
        log.error("aaaaa");
    }
}
