package mxc.sdk.rabbit.bean;

import java.io.Serializable;

/**
 * @Description: 功能描述
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
public class BaseMqMessage implements Serializable {

    /**
     * 路由
     */
    private String exchange;

    /**
     * 消息路由key
     */
    private String routingKey;

    /**
     * 消息时间类型
     */
    private String eventType;

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }
}
