package Direct;

import HelloWorld.RabbitMQConnection;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerB {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnection.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("logs_direct", "direct");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, "logs_direct", "info");
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerA routing_key='info'" + new String(body));
            }
        });
    }
}
