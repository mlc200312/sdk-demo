package mxc.sdk.rabbit.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 生产者注解，用来生产发送消息
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MqSender {
    /**
     * 交换机
     *
     * @return
     */
    String exchange();

    /**
     * 路由key
     *
     * @return
     */
    String routingKey() default "#";

    /**
     * 是否异步发送
     *
     * @return
     */
    boolean isAsync() default false;
}
