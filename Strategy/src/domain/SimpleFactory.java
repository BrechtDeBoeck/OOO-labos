package domain;

public class SimpleFactory {


    public EncryptingMethod createEncription(Enum type) {
        EncryptingMethod encryptingMethod = null;

        if (type.equals(Characters.CAESAR)) {
            encryptingMethod = new CaesarMethod();
        } else if (type.equals(Characters.REGULAR)) {
            encryptingMethod = new MirroredMethod();

        }
        return encryptingMethod;
    }


}
