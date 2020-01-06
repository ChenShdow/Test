package com.edu.coupon.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureUtils<T> {
    public static<T> T get(Future<T> future){
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
