package com.edu.coupon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

@Component
public class CouponCodeUtil {
    @Autowired
    private IdUtils idUtils;
    @Autowired
    private Executor getAsyncExecutor;

    public List<String> generateCode(int count,String id){
        CopyOnWriteArrayList<String> objects = new CopyOnWriteArrayList<>();
        int halfCount = count/2;
        CompletableFuture<Void> arrayListCompletableFuture = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < halfCount; i++) {
                objects.add(idUtils.getIdNoAsync(id));
            }
        }, getAsyncExecutor);
        CompletableFuture<Void> arrayListCompletableFuture1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < count-halfCount; i++) {
                objects.add(idUtils.getIdNoAsync(id));
            }
        }, getAsyncExecutor);
        CompletableFuture.allOf(arrayListCompletableFuture,arrayListCompletableFuture1).join();
        return objects;
    }

}
