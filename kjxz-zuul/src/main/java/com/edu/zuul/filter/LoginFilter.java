package com.edu.zuul.filter;

import com.edu.global.kafka.KafkaReceiver;
import com.edu.global.kafka.KafkaSender;
import com.edu.global.sevice.MailService;
import com.edu.global.util.RedisUtils;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoginFilter extends AbstractPreZuulFilter {
    @Autowired
    private MailService mailService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private KafkaSender kafkaSender;
    @Autowired
    private KafkaReceiver kafkaReceiver;

    @Value("${name}")
    private String name;

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("redis:"+redisUtils.get("a"));
        log.info("获得kafka对象:{}",kafkaSender);
        kafkaSender.sendMessage("test01","thank you, kafka is Ok");

        log.info("获得mail对象：{}",mailService);
        log.info("登录的filter,git中的name：{}",name);
        return fail(601,"登录失败");//
    }

}
