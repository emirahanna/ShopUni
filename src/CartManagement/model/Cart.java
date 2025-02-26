package CartManagement.model;

import java.util.ArrayList;
import ProductManagement.model.Product;

public class Cart {
    private String userID;
    private ArrayList<Product> cartContent;

    public void addProduct(Product p){}
    public void removeProduct(Product p){}
    public void emptyCart(){}
    public void buyCart(){}
    public int  displayTotalPrice(){
        return -1;
    }
}
