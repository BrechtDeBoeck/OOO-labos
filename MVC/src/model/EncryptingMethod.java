package model;

public interface EncryptingMethod {
    String encrypt(String tekst);

    String decrypt(String tekst);
}
