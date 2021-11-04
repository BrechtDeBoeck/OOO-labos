package domain;

public interface Subject {
    void attach(Observer o, Event event);
    void detach(Observer o);
    void notifyObservers();
}
