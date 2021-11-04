package domain;

public enum Event {
    OPEN("Rekening openen"), DEPOSIT("Storten"), WITHDRAWAL("Afhalen"), ALL();

    private String stringValue;

    private Event(String stringValue){
        this.stringValue = stringValue;
    }

    private Event(){

    }

    public String getStringValue() {
        return this.stringValue;
    }
}
