class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

interface Notification {
    void send();
}

class EmailNotification implements Notification {
    public void send() { System.out.println("Trimit Email..."); }
}

class SMSNotification implements Notification {
    public void send() { System.out.println("Trimit SMS..."); }
}

class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) return new EmailNotification();
        if (type.equalsIgnoreCase("SMS")) return new SMSNotification();
        return null;
    }
}

public class FactorySingletonDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        NotificationFactory factory = new NotificationFactory();

        logger.log("Programul a pornit.");

        Notification n1 = factory.createNotification("EMAIL");
        n1.send();

        Notification n2 = factory.createNotification("SMS");
        n2.send();

        logger.log("Toate notificarile au fost trimise.");
    }
}