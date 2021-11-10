package domain;

import java.util.*;

public class Bank implements Subject {
    private HashMap<Event, List<Observer>> observers;
    private LinkedHashMap<Integer, Rekening> rekeningen;
    private Event event;

    public Bank(){
        this.observers = new HashMap<>();
        observers.put(Event.OPEN, new ArrayList<>());
        observers.put(Event.DEPOSIT, new ArrayList<>());
        observers.put(Event.WITHDRAWAL, new ArrayList<>());
        this.rekeningen = new LinkedHashMap<>();
    }

    private void setEvent(Event event){
        this.event = event;
    }

    private Event getEvent(){
        return this.event;
    }

    public void addRekening(Rekening rekening){
        rekeningen.put(rekening.getNr(), rekening);
        setEvent(Event.OPEN);
        this.notifyObservers();
    }

    public void deposit(int rekeningNr, double bedrag){
        Rekening rekening = getRekening(rekeningNr);
        rekeningen.remove(rekeningNr);

        rekeningen.put(rekeningNr, new Rekening(rekening.getSaldo() + bedrag, rekeningNr));
        setEvent(Event.DEPOSIT);
        this.notifyObservers();
    }

    public void withdrawal(int rekeningNr, double bedrag){
        Rekening rekening = getRekening(rekeningNr);
        rekeningen.remove(rekeningNr);

        rekeningen.put(rekeningNr, new Rekening(rekening.getSaldo() - bedrag, rekeningNr));
        setEvent(Event.WITHDRAWAL);
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
    public void attach(Observer o, Event event) {
        switch(event){
            case ALL:
                for (Event e: Event.values()){
                    if (e != Event.ALL){
                        observers.get(e).add(o);
                    }
                }
                break;
            default:
                observers.get(event).add(o);
        }
    }

    @Override
    public void detach(Observer o) {
        for (Event e: Event.values()){
            observers.get(e).remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observers.get(event)){
            o.update(getNewestRekening().getValue(), event);
        }
    }
}
