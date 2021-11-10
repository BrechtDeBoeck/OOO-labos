package domain;

public enum Characters {
    CAESAR("Caesar"),
    SPIEGEL("Spiegel"),
    RANDOM("Random");

    private final String omschrijving;

    Characters(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getOmschrijving() {
        return omschrijving;
    }
}
