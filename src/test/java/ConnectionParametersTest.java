import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class ConnectionParametersTest {
    @Test
    public void createParams() {
        String[] paramsArray = new String[4];
        paramsArray[0] = "vhost";
        paramsArray[1] = "queue";
        paramsArray[2] = "user";
        paramsArray[3] = "pass";

        ConnectionParameters params = new ConnectionParameters(paramsArray);

        assertEquals(params.getHostName(), "queue.statscore.com");
        assertEquals(params.getVirtualHost(), paramsArray[0]);
        assertEquals(params.getQueue(), paramsArray[1]);
        assertEquals(params.getUserName(), paramsArray[2]);
        assertEquals(params.getPassword(), paramsArray[3]);
    }

    @Test(expected = InvalidParameterException.class)
    public void needsFourParams() {
        String[] paramsArray = new String[1];
        paramsArray[0] = "vhost";

        new ConnectionParameters(paramsArray);
    }
}