package mxc.sdk.rabbit.config.producer;

import mxc.sdk.rabbit.converter.MqMessageConverter;
import mxc.sdk.rabbit.service.AsyncMqSendService;
import mxc.sdk.rabbit.service.MqSendService;
import mxc.sdk.rabbit.service.RabbitMqService;
import mxc.sdk.rabbit.strategy.RabbitMqReturnCallback;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Description: 功能描述
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
@EnableAsync
public class MqProducerConfig {
    /**
     * 定义rabbitTemplate
     *
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory mqConnectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(mqConnectionFactory);
        rabbitTemplate.setMessageConverter(new MqMessageConverter());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitMqReturnCallback());
        return rabbitTemplate;
    }

    @Bean
    public RabbitMqService rabbitMqService(RabbitTemplate rabbitTemplate) {
        return new RabbitMqService(rabbitTemplate);
    }

    @Bean
    public MqSendService mqSendService(RabbitMqService rabbitMqService) {
        return new MqSendService(rabbitMqService);
    }

    @Bean
    public AsyncMqSendService asyncMqSendService(RabbitMqService rabbitMqService) {
        return new AsyncMqSendService(rabbitMqService);
    }
}
