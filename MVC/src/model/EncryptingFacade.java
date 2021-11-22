package model;

import java.util.ArrayList;

public class EncryptingFacade implements Subject {
    private static EncryptingContext context;
    private static SimpleFactory factory = new SimpleFactory();
    private ArrayList<Observer> observers = new ArrayList<>();

    public String encrypt(String text, String method) {
        Characters md = Characters.valueOf(method);
        EncryptingContext em = factory.createContext(text, md);
        return em.performEncryption();
    }

    public String decrypt(String text, String method) {
        Characters md = Characters.valueOf(method);
        EncryptingContext em = factory.createContext(text, md);
        return em.performDecryption();
    }

    @Override
    public void attach(Observer o){
        observers.add(o);
    }

    @Override
    public void detach(Observer o){
        observers.remove(o);
    }

    @Override
    public void notifyObservers(){
        for (Observer obs: observers){
            obs.update(this.context);
        }
    }
}
