package project;

import java.util.Random;

public class Thermometer implements IThermometer{
    Random rand = new Random();
    private static Thermometer instance;
    private final ISubject messenger;
    public Thermometer(ISubject msnger){
        this.messenger =msnger;
    }
    public static Thermometer getInstance(ISubject msnger){
        if(instance==null){
            instance=new Thermometer(msnger);
        }
        return instance;
    }
    public void addSubs(IObserver sub){
        messenger.attach(sub);
    }
    public void readThermalData() {
        int rand_int = rand.nextInt(100);
        System.out.println("Sicaklik degeri olculuyor...");
        SmartCoolingDevice.freeze(500);
        System.out.print("Olculen Sicaklik : ");
        System.out.println(rand_int);
    }
}
