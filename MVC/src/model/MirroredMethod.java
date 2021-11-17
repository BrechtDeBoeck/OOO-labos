package model;

public class MirroredMethod implements EncryptingMethod {
    @Override
    public String encrypt(String tekst) {
        if (tekst.equals("")){
            return "";
        } else {
            String firstChar = tekst.substring(0, 1);
            String restOfTekst = tekst.substring(1);
            return encrypt(restOfTekst) + firstChar;
        }
    }

    @Override
    public String decrypt(String tekst){
        return encrypt(tekst);
    }
}
