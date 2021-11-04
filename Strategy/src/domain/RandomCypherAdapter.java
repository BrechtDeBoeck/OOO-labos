package domain;

public class RandomCypherAdapter implements EncryptingMethod {
    RandomCypher randomCypher;

    public RandomCypherAdapter(RandomCypher randomCypher){
        this.randomCypher = randomCypher;
    }

    @Override
    public String encrypt(String tekst) {
        char[] message = tekst.toCharArray();
        char[] result = this.randomCypher.encypher(message);
        return result.toString();
    }

    @Override
    public String decrypt(String tekst) {
        char[] message = tekst.toCharArray();
        char[] result = this.randomCypher.decypher(message);
        return result.toString();
    }
}
