package com.edu.coupon.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class IdUtils {
    private final String strings[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
                                        "w","x","y","z","1","2","3","4"};

    //雪花算法 ： snowflake
    @Async("getAsyncExecutor")
    //分库分表：(第七位+第八位)*第九位/3 作为放库的依据
    public Future<String> getId(String id){
        StringBuilder finalId = new StringBuilder("");
        StringBuilder stringBuilder = new StringBuilder(id);
        //取传过来的商铺id的前3位和后3位
        String pre = stringBuilder.substring(0, 3);
        String post = stringBuilder.substring(stringBuilder.length() - 4);
        Random random = new Random();
        int i = random.nextInt(10);
        int j = random.nextInt(10);
        int k = random.nextInt(10);
        //将strings数组转为流，再转为list集合
        List<String> collect = Stream.of(strings).collect(Collectors.toList());
        //随机排列
        Collections.shuffle(collect);
        //将集合转为字符串
        String collect1 = collect.stream().collect(Collectors.joining());
        finalId.append(pre).append(post).append(i).append(j).append(k).append(collect1);
        return new AsyncResult<>(finalId.toString());
    }

    public String getIdNoAsync(String id){
        StringBuilder finalId = new StringBuilder("");
        StringBuilder stringBuilder = new StringBuilder(id);
        //比如要取前三位后三位
        String substring = stringBuilder.substring(0, 3);
        String substring1 = stringBuilder.substring(stringBuilder.length() - 4);
        //前六位  第七位+第八位*第九位/3 作为放库的依据
        Random random = new Random();
        int i = random.nextInt(10);
        int j = random.nextInt(10);
        int k = random.nextInt(10);
        List<String> collect = Stream.of(strings).collect(Collectors.toList());
        Collections.shuffle(collect);
        String collect1 = collect.stream().collect(Collectors.joining());
        finalId.append(substring).append(substring1).append(i).append(j).append(k).append(collect1);
        return finalId.toString();
    }
}
