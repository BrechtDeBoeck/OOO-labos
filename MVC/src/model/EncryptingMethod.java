package domain;

public interface EncryptingMethod {
    String encrypt(String tekst);

    String decrypt(String tekst);
}
