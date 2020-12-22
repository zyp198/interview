import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitMqClient {
    private static final String exchange_name = "exchange_demo";
    private static final String routing_key = "routing_key";
    private static final String queue_name = "queue_demo";
    private static final String queue_test = "queue_test";
    private static final String ip_address = "47.110.157.232";
    private static final int port = 5672;
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) throws IOException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ip_address);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);
        Connection conn = null;
        try {
            conn = factory.newConnection();
            System.out.println("连接成功");
            Channel channel = conn.createChannel();
            //创建交换器
            channel.exchangeDeclare(exchange_name, "HelloWorld", true, false, null);
            //创建队列
            /**
             * 参数1 队列名 参数2 是否持久化队列 false表示不持久化 参数3 是否独占队列 true表示独占 ，参数5 额外附加参数
             */
            channel.queueDeclare(queue_name, true, false, false, null);
            channel.queueDeclare(queue_test, true, false, false, null);
            //将交换器与队列通过路由键绑定
            channel.queueBind(queue_name, exchange_name, routing_key);
            //发送一条持久化的消息 该条消息在rabbitmq重启之后仍然在队列中
            for (int i = 0; i < 10; i++) {
                String message = "Hello World " + i;
                channel.basicPublish(exchange_name, routing_key, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
                TimeUnit.SECONDS.sleep(1);
            }
            //关闭资源
            channel.close();
            conn.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            System.out.println("资源关闭");
        }

    }
}
