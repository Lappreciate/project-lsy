package com.lsy.learn.projectlsy.grpcModel;

import com.mico.provider.grpc.api.common.RspHead;

/**
 * @author : yuguo
 * @date: 2021/12/20 9:12 下午
 */
public class RpcResult {

    /**
     * 成功
     *
     * @return
     */
    public static RspHead successRspHead() {
        return RspHead.newBuilder().setCode(0).setMessage("success").build();
    }

    /**
     * 失败
     *
     * @param code
     * @param message
     * @return
     */
    public static RspHead failRspHead(int code, String message) {
        return RspHead.newBuilder().setCode(code).setMessage(message == null || message.equals("") ? "fail" : message).build();
    }

}
