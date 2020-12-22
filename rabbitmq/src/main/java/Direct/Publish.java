package Direct;

import HelloWorld.RabbitMQConnection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publish {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_direct", "direct");
        String routing_key = "info";
        channel.basicPublish("logs_direct", routing_key, MessageProperties.PERSISTENT_TEXT_PLAIN, routing_key.getBytes());
        System.out.println("消息发送成功");
        channel.close();
        connection.close();
    }
}
