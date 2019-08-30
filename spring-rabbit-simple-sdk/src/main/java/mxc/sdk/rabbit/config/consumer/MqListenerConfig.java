package mxc.sdk.rabbit.config.consumer;

import org.springframework.context.annotation.Bean;

/**
 * @Description: 功能描述
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
public class MqListenerConfig {

    @Bean
    public MqListenerAnnotationProcessor mqListenerAnnotationProcessor() {
        return new MqListenerAnnotationProcessor();
    }
}
