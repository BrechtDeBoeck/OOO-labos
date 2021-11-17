package domain;

import java.lang.reflect.Constructor;

public class SimpleFactory {
    public EncryptingContext createContext(String tekst,Characters type) throws ClassNotFoundException {
        EncryptingContext encryptingContext = new EncryptingContext();
        EncryptingMethod encryptingMethod = null;



        if (type.equals(Characters.CAESAR)) {
            encryptingMethod = new CaesarMethod();
        } else if (type.equals(Characters.SPIEGEL)) {
            encryptingMethod = new MirroredMethod();
        } else if (type.equals(Characters.RANDOM)) {
            encryptingMethod = new RandomCypherAdapter(new RandomCypher());
        }
        encryptingContext.setText(tekst);
        encryptingContext.setCoding(encryptingMethod);
        return encryptingContext;
    }
}
