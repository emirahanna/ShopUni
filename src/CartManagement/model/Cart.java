package CartManagement.model;

import java.util.ArrayList;
import ProductManagement.model.Product;

public class Cart {
    private String userID;
    private ArrayList<CartItem> cartContent;

    public void addItem(CartItem itm){}
    public void removeItem(CartItem itm){}
    public void emptyCart(){}
    public void buyCart(){}
    public int displayTotalPrice(){
        return -1;
    }
}
