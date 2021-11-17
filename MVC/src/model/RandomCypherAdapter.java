package model;

public class RandomCypherAdapter implements EncryptingMethod {
    RandomCypher randomCypher;

    public RandomCypherAdapter(RandomCypher randomCypher){
        this.randomCypher = randomCypher;
    }

    @Override
    public String encrypt(String tekst) {
        String result = "";
        char[] message = tekst.toLowerCase().toCharArray();
        char[] encryption = this.randomCypher.encypher(message);
        for (char character: encryption){
            result += character;
        }
        return result;
    }

    @Override
    public String decrypt(String tekst) {
        String result = "";
        char[] message = tekst.toLowerCase().toCharArray();
        char[] decryption = this.randomCypher.decypher(message);
        for (char character: decryption){
            result += character;
        }
        return result;
    }
}
