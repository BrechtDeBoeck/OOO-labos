package model;

public interface Observer {
    void update(EncryptingContext context, String codedText);
}
