package mxc.sdk.rabbit.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import mxc.sdk.rabbit.config.MqConnectionConfig;
import mxc.sdk.rabbit.config.producer.AsyncTaskExecutorConfig;
import mxc.sdk.rabbit.config.producer.MqProducerConfig;
import mxc.sdk.rabbit.config.producer.MqSenderConfig;
import org.springframework.context.annotation.Import;

/**
 * @Description: 项目使用rabbitmq的生产者开关注解，初始化Mq基础连接配置和RabbitTemplate实例
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({MqConnectionConfig.class, AsyncTaskExecutorConfig.class, MqProducerConfig.class, MqSenderConfig.class})
@Documented
public @interface EnableMqProducer {
}