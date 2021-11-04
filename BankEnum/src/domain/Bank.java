package domain;

import java.util.*;

public class Bank implements Subject {
    private List<Observer> openObservers;
    private List<Observer> depositObservers;
    private List<Observer> withdrawalObservers;
    private LinkedHashMap<Integer, Rekening> rekeningen;
    private Event event;

    public Bank(){
        this.openObservers = new ArrayList<>();
        this.depositObservers = new ArrayList<>();
        this.withdrawalObservers = new ArrayList<>();
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
            case OPEN:
                openObservers.add(o);
                break;
            case DEPOSIT:
                depositObservers.add(o);
                break;
            case WITHDRAWAL:
                withdrawalObservers.add(o);
                break;
            case ALL:
                openObservers.add(o);
                depositObservers.add(o);
                withdrawalObservers.add(o);
                break;
        }
    }

    @Override
    public void detach(Observer o) {
        openObservers.remove(o);
        depositObservers.remove(o);
        withdrawalObservers.remove(o);
    }

    @Override
    public void notifyObservers() {
        switch(event){
            case OPEN:
                for (Observer o: openObservers){
                    o.update(getNewestRekening().getValue(), event);
                }
                break;
            case DEPOSIT:
                for (Observer o: depositObservers){
                    o.update(getNewestRekening().getValue(), event);
                }
                break;
            case WITHDRAWAL:
                for (Observer o: withdrawalObservers){
                    o.update(getNewestRekening().getValue(), event);
                }
                break;
        }
    }
}
