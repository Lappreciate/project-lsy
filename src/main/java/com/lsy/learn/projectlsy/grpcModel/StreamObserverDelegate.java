package com.lsy.learn.projectlsy.grpcModel;

import com.google.protobuf.Message;
import com.mico.provider.grpc.api.common.RspHead;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : yuguo
 * @date: 2021/12/6 6:00 下午
 */
@Slf4j
public class StreamObserverDelegate<ReqT extends Message, RespT extends Message> implements StreamObserver<RespT> {

    private final StreamObserver<RespT> originResponseObserver;
    private final RespT respT;

    public StreamObserverDelegate(StreamObserver<RespT> originResponseObserver, RespT respT) {
        this.respT = respT;
        Assert.notNull(originResponseObserver, "originResponseObserver must not null!");
        this.originResponseObserver = originResponseObserver;
    }

    @Override
    public void onNext(RespT value) {
        this.originResponseObserver.onNext(value);
    }

    @Override
    public void onError(Throwable throwable) {
        try {
            RspHead rspHead = null;
            // 业务异常


            // 创建build
            Class<? extends Message> aClass = respT.getClass();
            Method newBuilder = aClass.getMethod("newBuilder");
            Object object = newBuilder.invoke(null);

            // 设置返回值
            Class<?> buildClass = object.getClass();
            Method setRspHead = buildClass.getMethod("setRspHead", RspHead.class);
            setRspHead.invoke(object, rspHead);

            // 获取build()方法并执行
            Method newBuilderBuilder = buildClass.getMethod("build");
            //noinspection ConfusingArgumentToVarargsMethod
            Object rspHeadResult = newBuilderBuilder.invoke(object, null);
            //noinspection unchecked
            this.onNext((RespT) rspHeadResult);
            this.onCompleted();
        } catch (Exception e) {
            log.info("onError exception.case:{}", e.getMessage(), e);
            this.onNext(respT);
            this.onCompleted();
        }
    }

    @Override
    public void onCompleted() {
        originResponseObserver.onCompleted();
    }

    /**
     * 执行业务 自动异常处理
     */
    public void executeWithException(Function<ReqT, RespT> function, ReqT request) {
        try {
            RespT response = function.apply(request);
            this.onNext(response);
            this.onCompleted();
        } catch (Throwable e) {
            this.onError(e);
        }
    }

    /**
     * 执行业务 自动异常处理
     */
    public void executeWithException(Supplier<RespT> supplier) {
        try {
            RespT response = supplier.get();
            this.onNext(response);
            this.onCompleted();
        } catch (Throwable e) {
            log.info("grpc exception.case:{}", e.getMessage(), e);
            this.onError(e);
        }
    }
}
