package domain;

public interface ProductState {
    String loanProduct(int days);
    String removeProduct();
    String returnProduct(boolean isBeschadigd);
    String repairProduct();
}
