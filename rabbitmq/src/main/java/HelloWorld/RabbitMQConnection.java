package HelloWorld;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQConnection {
    private static final String exchange_name = "exchange_demo";
    private static final String routing_key = "routing_key";
    private static final String queue_name = "queue_demo";
    private static final String queue_test = "queue_test";
    private static final String ip_address = "47.110.157.232";
    private static final int port = 5672;
    private static final String username = "root";
    private static final String password = "root";

    private RabbitMQConnection() {
    }

    private static RabbitMQConnection rabbitMQConnection;

    public static RabbitMQConnection getInstance() {
        if (rabbitMQConnection == null) {
            rabbitMQConnection = new RabbitMQConnection();
        }
        return rabbitMQConnection;
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ip_address);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        return factory.newConnection();
    }
   /* //创建Channel

    public static Channel getChannel() throws IOException, TimeoutException {
       Connection conn = RabbitMQConnection.getConnection();
       return conn.createChannel();
    }*/

}
