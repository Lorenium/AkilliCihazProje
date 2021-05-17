package project;

import java.util.ArrayList;
import java.util.List;

public class Messenger implements ISubject {
    private final List<IObserver> subs = new ArrayList<>();
    public void attach(IObserver sub) {
        subs.add(sub);
    }
    public void detach(IObserver sub) {
        subs.remove(sub);
    }
    public void notify(String msg) {
        for(IObserver sub: subs) {
            sub.update(msg);
        }
    }
}
