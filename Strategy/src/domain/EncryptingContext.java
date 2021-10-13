package domain;

public class EncryptingContext {
    private String tekst;
    private EncryptingMethod coding;

    public EncryptingContext(){

    }

    public void setText(String tekst){
        if (tekst == null || tekst.trim().isEmpty()){
            throw new IllegalArgumentException("Tekst mag niet leeg zijn");
        }
        this.tekst = tekst;
    }

    public String getText(){
        return this.tekst;
    }

    public void setCoding(EncryptingMethod method){
        if (method == null){
            throw new IllegalArgumentException("U moet een encryptie uitkiezen");
        }
        this.coding = method;
    }

    public EncryptingMethod getMethod(){
        return this.coding;
    }

    public String performEncryption(){
        return this.getMethod().encrypt(this.getText());
    }

    public String performDecryption(){
        return this.getMethod().decrypt(this.getText());
    }
}
