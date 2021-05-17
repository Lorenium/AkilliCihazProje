package project;

public class Actuator implements IDIP {
    public void start() {
        System.out.println("Sogutucu aciliyor...");
        SmartCoolingDevice.freeze(500);
        System.out.println("Bu islem biraz zaman alabilir...");
        SmartCoolingDevice.freeze(500);
        System.out.println("Sogutucu basariyla acildi!");
    }

    public void shutdown() {
        System.out.println("Sogutucu kapatiliyor...");
        SmartCoolingDevice.freeze(500);
        System.out.println("Bu islem biraz zaman alabilir...");
        SmartCoolingDevice.freeze(500);
        System.out.println("Sogutucu basariyla kapatildi!");
    }
}
