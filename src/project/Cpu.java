package project;

public class Cpu implements ICpu{
    private final IThermometer thermometer;
    public Cpu(){
        this.thermometer = Thermometer.getInstance(new Messenger());
        this.thermometer.addSubs(new Observer());
    }

    public void sendOpen(){
        IDIP act =new Actuator();
        DIP dip = new DIP(act);
        dip.start();
    }

    public void sendShutdown(){
        IDIP act =new Actuator();
        DIP dip = new DIP(act);
        dip.shutdown();
    }

    public void sendReadThermals() {
        thermometer.readThermalData();
    }
}
