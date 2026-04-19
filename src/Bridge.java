interface NotificationSender {
    void sendNotification(String deviceName, String message);
}

class PushNotification implements NotificationSender {
    public void sendNotification(String deviceName, String message) {
        System.out.println("Push pe " + deviceName + ": " + message);
    }
}

class EmailAlert implements NotificationSender {
    public void sendNotification(String deviceName, String message) {
        System.out.println("Email pentru " + deviceName + ": " + message);
    }
}

abstract class Device {
    protected NotificationSender sender;

    public Device(NotificationSender sender) {
        this.sender = sender;
    }

    public abstract void alert(String message);
}

class SmartPhoneDevice extends Device {
    private String model;

    public SmartPhoneDevice(String model, NotificationSender sender) {
        super(sender);
        this.model = model;
    }

    @Override
    public void alert(String message) {
        sender.sendNotification("SmartPhone [" + model + "]", message);
    }
}

class TabletDevice extends Device {
    private String brand;

    public TabletDevice(String brand, NotificationSender sender) {
        super(sender);
        this.brand = brand;
    }

    @Override
    public void alert(String message) {
        sender.sendNotification("Tablet [" + brand + "]", message);
    }
}

public class Bridge {
    public static void main(String[] args) {
        Device d1 = new SmartPhoneDevice("Samsung S24", new PushNotification());
        Device d2 = new SmartPhoneDevice("iPhone SE", new EmailAlert());
        Device d3 = new TabletDevice("iPad", new PushNotification());
        Device d4 = new TabletDevice("Lenovo Tab", new EmailAlert());

        d1.alert("Baterie scazuta!");
        d2.alert("Baterie scazuta!");
        d3.alert("Update disponibil.");
        d4.alert("Update disponibil.");
    }
}