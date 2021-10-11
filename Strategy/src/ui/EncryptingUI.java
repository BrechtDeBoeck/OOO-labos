package ui;

import domain.EncryptingContext;

public class EncryptingUI {
    private EncryptingContext context;

    public String encrypt(){
        return this.context.performEncryption();
    }

    public String decrypt(){
        return this.context.performDecryption();
    }
}
