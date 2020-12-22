package HelloWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQPub {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnection.getConnection();
        Channel channel = connection.createChannel();
        /**
         * 参数1 队列名 参数2 是否持久化队列 false表示不持久化 参数3 是否独占队列 true表示独占 ，参数5 额外附加参数
         */
        channel.queueDeclare("hello", false, false, false, null);
        String message = "hello world";
        channel.basicPublish("x", null, null, message.getBytes());
        channel.close();
        connection.close();

        /**
         * *匹配一个单词
         * #匹配多个单词
         */


    }
}
