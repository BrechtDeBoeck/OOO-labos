package model;

import java.util.ArrayList;

public class EncryptingFacade implements Subject {
    private static EncryptingContext context;
    private static SimpleFactory factory = new SimpleFactory();
    private ArrayList<Observer> observers = new ArrayList<>();

    public void encrypt(String text, String method) {
        Characters md = Characters.valueOf(method);
        EncryptingContext em = factory.createContext(text, md);
        String encrypted = em.performEncryption();
        notifyObservers(encrypted);
    }

    public void decrypt(String text, String method) {
        Characters md = Characters.valueOf(method);
        EncryptingContext em = factory.createContext(text, md);
        String decrypted = em.performDecryption();
        notifyObservers(decrypted);
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
    public void notifyObservers(String codedText){
        for (Observer obs: observers){
            obs.update(this.context, codedText);
        }
    }
}
