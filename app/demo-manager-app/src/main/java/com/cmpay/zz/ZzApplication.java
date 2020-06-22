package com.cmpay.zz;

import com.cmpay.lemon.common.LemonFramework;
import com.cmpay.lemon.framework.LemonBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;

@LemonBootApplication(exclude = {RabbitAutoConfiguration.class}, value = {"com.cmpay.zz"})
public class ZzApplication {
    public static void main(String[] args) {
        LemonFramework.run(ZzApplication.class, args);
    }
}