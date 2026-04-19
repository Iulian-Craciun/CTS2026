interface OldSMSService {
    void sendText(String phoneNumber, String message);
}

class ConcreteOldSMSService implements OldSMSService {
    public void sendText(String phoneNumber, String message) {
        System.out.println("Old SMS Service -> Trimit catre " + phoneNumber + ": " + message);
    }
}

class SMSAdapter implements Notification {
    private OldSMSService oldService;
    private String phoneNumber;

    public SMSAdapter(OldSMSService oldService, String phoneNumber) {
        this.oldService = oldService;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        oldService.sendText(phoneNumber, "Notificare automata din sistem.");
    }
}

public class Adapter {
    public static void main(String[] args) {
        OldSMSService oldService = new ConcreteOldSMSService();

        Notification adapted = new SMSAdapter(oldService, "0712345678");
        adapted.send();

        NotificationFactory factory = new NotificationFactory();
        Notification email = factory.createNotification("EMAIL");
        email.send();
    }
}