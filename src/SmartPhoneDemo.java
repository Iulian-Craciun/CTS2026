class SmartPhone {
    private String model;
    private String procesor;
    private int ram;
    private int stocare;
    private boolean are5G;

    private SmartPhone(Builder builder) {
        this.model = builder.model;
        this.procesor = builder.procesor;
        this.ram = builder.ram;
        this.stocare = builder.stocare;
        this.are5G = builder.are5G;
    }

    @Override
    public String toString() {
        return "SmartPhone [Model=" + model + ", Procesor=" + procesor +
                ", RAM=" + ram + "GB, Stocare=" + stocare + "GB, 5G=" + are5G + "]";
    }

    public static class Builder {
        private String model;
        private String procesor;
        private int ram;
        private int stocare;
        private boolean are5G;

        public Builder(String model) {
            this.model = model;
        }

        public Builder setProcesor(String procesor) {
            this.procesor = procesor;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStocare(int stocare) {
            this.stocare = stocare;
            return this;
        }

        public Builder set5G(boolean are5G) {
            this.are5G = are5G;
            return this;
        }

        public SmartPhone build() {
            return new SmartPhone(this);
        }
    }
}

class PhoneFactory {
    public static SmartPhone createHighEndAndroid() {
        return new SmartPhone.Builder("Samsung S24 Ultra")
                .setProcesor("Snapdragon Gen 3")
                .setRam(12)
                .setStocare(512)
                .set5G(true)
                .build();
    }

    public static SmartPhone createBudgetiPhone() {
        return new SmartPhone.Builder("iPhone SE")
                .setProcesor("A15 Bionic")
                .setRam(4)
                .setStocare(64)
                .set5G(false)
                .build();
    }
}

public class SmartPhoneDemo {
    public static void main(String[] args) {
        SmartPhone premiumPhone = PhoneFactory.createHighEndAndroid();

        SmartPhone customPhone = new SmartPhone.Builder("Google Pixel Custom")
                .setProcesor("Tensor G3")
                .setRam(8)
                .set5G(true)
                .build();

        System.out.println(premiumPhone);
        System.out.println(customPhone);
    }
}

//FACTORY & BUILDER