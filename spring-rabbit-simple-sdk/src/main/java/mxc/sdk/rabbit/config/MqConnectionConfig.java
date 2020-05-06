package mxc.sdk.rabbit.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * @Description: 功能描述
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
public class MqConnectionConfig {

    @Autowired
    private Environment environment;

    /**
     * rabbit mq 连接配置
     *
     * @return
     */
    @Bean
    public ConnectionFactory mqConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(environment.getRequiredProperty("spring.rabbitmq.host"));
        connectionFactory.setPort(environment.getProperty("spring.rabbitmq.port", Integer.class));
        connectionFactory.setUsername(environment.getRequiredProperty("spring.rabbitmq.username"));
        connectionFactory.setPassword(environment.getRequiredProperty("spring.rabbitmq.password"));
        connectionFactory.setVirtualHost(environment.getRequiredProperty("spring.rabbitmq.virtual-host"));
        connectionFactory.setPublisherReturns(true);
        return connectionFactory;
    }
}
