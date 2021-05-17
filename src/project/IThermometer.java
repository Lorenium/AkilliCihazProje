package project;

public interface IThermometer {
    void readThermalData();
    void addSubs(IObserver sub);
}
