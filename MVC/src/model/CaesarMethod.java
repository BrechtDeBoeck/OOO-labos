package model;

public class CaesarMethod implements EncryptingMethod {
    public static final String REGULAR = "abcdefghijklmnopqrstuvwxyz";
    public static final String CAESAR = "xyzabcdefghijklmnopqrstuvw";

    @Override
    public String encrypt(String tekst) {
        String result = "";
        for (int i = 0; i != tekst.length(); i++){
            String nextChar = tekst.substring(i, i + 1).toLowerCase();
            if (REGULAR.contains(nextChar)) {
                for (int j = 0; j != REGULAR.length(); j++) {
                    if (nextChar.equals(REGULAR.substring(j, j + 1))) {
                        result += CAESAR.charAt(j);
                    }
                }
            } else {
                result += tekst.charAt(i);
            }
        }
        return result;
    }

    @Override
    public String decrypt(String tekst){
        String result = "";
        for (int i = 0; i != tekst.length(); i++){
            String nextChar = tekst.substring(i, i + 1).toLowerCase();
            if (CAESAR.contains(nextChar)) {
                for (int j = 0; j != CAESAR.length(); j++) {
                    if (nextChar.equals(CAESAR.substring(j, j + 1))) {
                        result += REGULAR.charAt(j);
                    }
                }
            } else {
                result += nextChar;
            }
        }
        return result;
    }
}
