package project;

import java.util.Scanner;
public class NetworkOps implements INetworkOps{
    private final Scanner scan = new Scanner(System.in);
    private final ICpu cpu;
    private INetworkOps networkOps;
    public NetworkOps() {
        cpu = new Cpu();
    }
    public String getData() {
        return scan.next();
    }
    public void message(String msg){
        System.out.println(msg);
    }
    public String getInput(){
        return scan.next();
    }
    @Override
    public void startCooler() {
        cpu.sendOpen();
    }
    @Override
    public void shutdownCooler() {
        cpu.sendShutdown();
    }
    @Override
    public void sendThermometerData(){
        cpu.sendReadThermals();
    }
}
