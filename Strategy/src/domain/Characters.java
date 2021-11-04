package domain;

public enum Characters {
    REGULAR("normal letters","abcdefghijklmnopqrstuvwxyz"),
    CAESAR("ceasar letters","xyzabcdefghijklmnopqrstuvw");

    private final String omschrijving;
    private final String regChars;

    Characters(String omschrijving, String regChars) {
        this.omschrijving = omschrijving;
        this.regChars = regChars;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getRegChars() {
        return regChars;
    }
}
