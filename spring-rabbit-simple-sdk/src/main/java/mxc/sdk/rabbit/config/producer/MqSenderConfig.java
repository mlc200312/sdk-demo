package mxc.sdk.rabbit.config.producer;

import org.springframework.context.annotation.Bean;

/**
 * @Description: 功能描述
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
public class MqSenderConfig {

    @Bean
    public MqSenderAspect mqSenderAspect() {
        return new MqSenderAspect();
    }
}
