import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitMQConsumer {
    private static final String exchange_name = "exchange_demo";
    private static final String routing_key = "routing_key";
    private static final String queue_name = "queue_demo";
    private static final String ip_address = "47.110.157.232";
    private static final int port = 5672;
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[]{
                new Address(ip_address, port)
        };
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPassword(password);
        factory.setUsername(username);
        //warning
        Connection connection = factory.newConnection(addresses);
        final Channel channel = connection.createChannel();
        channel.basicQos(64);
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("recv message:" + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(queue_name, consumer);
        TimeUnit.SECONDS.sleep(10);
        //channel.close();
        //connection.close();

    }
}
