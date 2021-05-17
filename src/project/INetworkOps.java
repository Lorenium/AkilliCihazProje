package project;

public interface INetworkOps {
    String getData();
    String getInput();
    void sendThermometerData();
    void startCooler();
    void shutdownCooler();
    void message(String msg);
}
