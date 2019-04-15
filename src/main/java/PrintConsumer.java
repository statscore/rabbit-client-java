import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;

public class PrintConsumer extends DefaultConsumer {

    public PrintConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] body)
            throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println("NEW MESSAGE RECEIVED:");
        System.out.println(message);
        System.out.println();

        Channel channel = this.getChannel();
        channel.basicAck(envelope.getDeliveryTag(), false);
    }
}
