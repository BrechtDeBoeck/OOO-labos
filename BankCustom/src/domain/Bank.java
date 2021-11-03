package domain;

import java.util.*;

public class Bank implements Subject {
    private List<Observer> observers;
    private LinkedHashMap<Integer, Rekening> rekeningen;

    public Bank(){
        this.observers = new ArrayList<>();
        this.rekeningen = new LinkedHashMap<>();
    }

    public void addRekening(Rekening rekening){
        rekeningen.put(rekening.getNr(), rekening);
        this.notifyObservers();
    }

    public ArrayList<Rekening> getRekeningen(){
        ArrayList<Rekening> result = new ArrayList<>();
        Set<Map.Entry<Integer, Rekening>> rekeningSet = rekeningen.entrySet();
        for (Map.Entry<Integer, Rekening> rekeningEntry: rekeningSet){
            result.add(rekeningEntry.getValue());
        }
        return result;
    }

    public Rekening getRekening(int nr){
        return rekeningen.get(nr);
    }

    public int getAantalRekeningen(){
        return rekeningen.size();
    }

    public Map.Entry<Integer, Rekening> getNewestRekening(){
        List<Map.Entry<Integer, Rekening>> entryList = new ArrayList<Map.Entry<Integer, Rekening>>(rekeningen.entrySet());
        return entryList.get(entryList.size() - 1);
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers){
            o.update(getNewestRekening().getValue());
        }
    }
}
