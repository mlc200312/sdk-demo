package mxc.sdk.rabbit.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.util.StringUtils;

/**
 * @Description: 功能描述
 * @Author: Mr.Min
 * @Date: 2019-08-29
 **/
public class BindingObject {

    public static final String DEFAULT_ROUTING_KEY = "#";

    private String defaultRoutingKey = DEFAULT_ROUTING_KEY;

    /**
     * 队列列表
     */
    private List<Queue> queues = new ArrayList<Queue>();
    /**
     * 绑定列表
     */
    private List<Binding> bindings = new ArrayList<Binding>();

    /**
     * NoArgsConstructor
     */
    public BindingObject() {
    }

    /**
     * AllArgsConstructor
     *
     * @param defaultRoutingKey
     * @param queues
     * @param bindings
     */
    public BindingObject(String defaultRoutingKey, List<Queue> queues, List<Binding> bindings) {
        this.defaultRoutingKey = defaultRoutingKey;
        this.queues = queues;
        this.bindings = bindings;
    }

    public String getDefaultRoutingKey() {
        return defaultRoutingKey;
    }

    public void setDefaultRoutingKey(String defaultRoutingKey) {
        this.defaultRoutingKey = defaultRoutingKey;
    }

    public List<Queue> getQueues() {
        return queues;
    }

    public void setQueues(List<Queue> queues) {
        this.queues = queues;
    }

    public List<Binding> getBindings() {
        return bindings;
    }

    public void setBindings(List<Binding> bindings) {
        this.bindings = bindings;
    }

    public void addBinding(String queueName, String exchange) {
        this.addBinding(queueName, exchange, null);
    }

    public void addBinding(String queueName, String exchange, String routingKey) {
        this.addBinding(queueName, exchange, routingKey, null);
    }

    public void addBinding(String queueName, String exchange, String routingKey, Map<String, Object> arguments) {
        if (StringUtils.isEmpty(queueName)) {
            throw new RuntimeException("invalid queueName:" + queueName);
        }

        if (StringUtils.isEmpty(exchange)) {
            throw new RuntimeException("invalid exchange:" + exchange);
        }

        String realRoutingKey = routingKey;
        if (StringUtils.isEmpty(realRoutingKey)) {
            realRoutingKey = this.defaultRoutingKey;
        }
        this.addQueue(queueName);
        this.addBinding(new Binding(queueName, Binding.DestinationType.QUEUE, exchange, realRoutingKey, arguments));
    }

    private void addBinding(Binding binding) {
        bindings.add(binding);
    }

    private void addQueue(String queueName) {
        queues.add(new Queue(queueName));
    }
}
