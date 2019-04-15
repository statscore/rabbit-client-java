import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.concurrent.TimeoutException;

public class RabbitMqClient {

    public static void main(String[] argv) {
        try {
            ConnectionParameters params = new ConnectionParameters(argv);
            ConnectionFactory factory = new ConnectionFactory();

            factory.setHost(params.getHostName());
            factory.setVirtualHost(params.getVirtualHost());
            factory.setUsername(params.getUserName());
            factory.setPassword(params.getPassword());

            Connection conn = factory.newConnection();
            Channel channel = conn.createChannel();
            PrintConsumer printConsumer = new PrintConsumer(channel);

            channel.basicConsume(params.getQueue(), printConsumer);
        } catch (IOException | TimeoutException | InvalidParameterException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
