package domain;

public class SimpleFactory {


    public EncryptingMethod createEncription(Enum type) {
        EncryptingMethod encryptingMethod = null;

        if (type.equals(Characters.CAESAR)) {
            encryptingMethod = new CaesarMethod();
        } else if (type.equals(Characters.SPIEGEL)) {
            encryptingMethod = new MirroredMethod();
        } else if (type.equals(Characters.RANDOM)) {
            encryptingMethod = new RandomCypherAdapter(new RandomCypher());
        }
        return encryptingMethod;
    }
}
