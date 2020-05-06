package mxc.sdk.rabbit.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 消费者注解，用来监听消费消息
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MqListener {
    /**
     * 交换机
     *
     * @return
     */
    String exchange();

    /**
     * 队列
     *
     * @return
     */
    String queue();

    /**
     * 路由key
     *
     * @return
     */
    String routingKey() default "#";

    /**
     * 是否开启消费者并发自动扩展，默认关闭
     *
     * @return
     */
    boolean enableConsumerAutoExpand() default false;

    /**
     * 初始并发消费者数量，默认1
     *
     * @return
     */
    int concurrentConsumers() default 1;

    /**
     * 最大并发消费者数量，默认10
     *
     * @return
     */
    int maxConcurrentConsumers() default 10;

    /**
     * 启动新消费者之间的时间间隔，默认2秒
     *
     * @return
     */
    int startConsumerMinInterval() default 2000;
}
