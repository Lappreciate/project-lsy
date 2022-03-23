package com.lsy.learn.projectlsy.grpcCilent;

import com.lsy.learn.projectlsy.SearchServiceGrpc;
import com.lsy.learn.projectlsy.Test;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yanhui
 */
@Slf4j
@Service
public class TestServiceGrpcClient {


    private SearchServiceGrpc.SearchServiceBlockingStub searchServiceBlockingStub;

    @PostConstruct
    private void init() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 10000)//默认 9090
                .usePlaintext()
                .build();

        searchServiceBlockingStub = SearchServiceGrpc.newBlockingStub(channel);
    }


    public Map<String, Object> getGrpcTest() {

        Map<String, Object> map = new HashMap<>();
        Test search;
        try {
            Test testReq = Test.newBuilder().setQuery("query").build();
            search = searchServiceBlockingStub.search(testReq);

        } catch (Exception e) {
            map.put("errorMsg", e.getMessage());
            return map;
        }
        map.put("a", search.toString());
        return map;
    }

}
