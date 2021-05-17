package project;

public class Observer  implements IObserver{
    public void update(String mesaj) {
        System.out.println("Sub'a gelen mesaj->" + mesaj);
    }
}
