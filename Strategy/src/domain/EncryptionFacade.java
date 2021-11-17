package domain;

public class EncryptionFacade {
    private static EncryptingContext context;
    private static SimpleFactory factory;

    public String encrypt(String text, String method) {
        Characters md = Characters.valueOf(method);
        EncryptingContext em = factory.createContext(text, md);
        return em.performEncryption();
    }

    public String decrypt(String text, String method) {
        Characters md = Characters.valueOf(method);
        EncryptingContext em = factory.createContext(text, md);
        return em.performDecryption();
    }
}