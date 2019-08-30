package mxc.sdk.rabbit.service;

import mxc.sdk.rabbit.bean.BaseMqMessage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 功能描述
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
public class MqSendService {

    @Autowired
    private final RabbitMqService rabbitMqService;

    public MqSendService(RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    /**
     * mq消息发送入口
     *
     * @param mqMessage
     */
    public void sendMessage(BaseMqMessage mqMessage) {
        rabbitMqService.sendMessage(mqMessage);
    }

    /**
     * mq消息发送入口
     *
     * @param exchange
     * @param routingKey
     * @param message
     */
    public void sendMessage(String exchange, String routingKey, Object message) {
        rabbitMqService.sendMessage(exchange, routingKey, message);
    }
}
