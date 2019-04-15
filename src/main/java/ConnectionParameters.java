import java.security.InvalidParameterException;

class ConnectionParameters {
    private String HostName = "queue.statscore.com";
    private String Queue;
    private String VirtualHost;
    private String UserName;
    private String Password;

    ConnectionParameters(String[] runArguments) throws IllegalArgumentException {
        if (runArguments.length != 4) {
            throw new InvalidParameterException(
                    "Please provide 4 required parameters: {virtual_host} {queue_name} {user_name} {password}"
            );
        }
        VirtualHost = runArguments[0];
        Queue = runArguments[1];
        UserName = runArguments[2];
        Password = runArguments[3];
    }

    public String getHostName() {
        return HostName;
    }

    public String getQueue() {
        return Queue;
    }

    public String getVirtualHost() {
        return VirtualHost;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }
}
