package project;

public class Main {
    public static void main(String[] args)
    {
        Builder builder = new Builder.HelperBuilder().version("v0.1").build();
        System.out.println(builder);
        SmartCoolingDevice smartCoolingDevice= new SmartCoolingDevice();
        smartCoolingDevice.login();
    }
}