package domain;

public class EncryptionFacade {
    private static EncryptionFacade instance;
    private static EncryptingMethod method;
    private static EncryptingContext context;

    public static EncryptionFacade getInstance() {
        if (instance == null) {
            instance = new EncryptionFacade();
        }
        return instance;
    }

    public String encrypt(String text) {
        return method.encrypt(text);
    }

    public String decrypt(String text) {
        return method.decrypt(text);
    }

    public void addAlgorithm(EncryptingMethod method) {
    }
}