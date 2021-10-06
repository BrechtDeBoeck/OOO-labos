package ui;

import domain.EncryptingContext;

public class EncryptingUI {
    private EncryptingContext context;

    public String encrypt(){
        return this.context.getMethod().encrypt(this.context.getText());
    }

    public String decrypt(){
        return this.context.getMethod().decrypt(this.context.getText());
    }
}
