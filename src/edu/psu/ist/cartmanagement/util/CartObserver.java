package edu.psu.ist.cartmanagement.util;

import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.usermanagement.model.UserAccount;


public interface CartObserver {
    void update();
}

/* public interface Subject {
    void addObserver(CartObserver observer);
    void removeObserver(CartObserver observer);
    void notifyObservers();
} */

// we need to connect this to database -nicole

/* class Cart implements Subject {
  private List<CartObserver> observers = new ArrayList<>();
    private List<String> items = new ArrayList<>();

    @Override
    public void addObserver(CartObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(CartObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(CartObserver observer : observers) {
            observer.update();
        }
    }

    public void addItem(String item) {
        items.add(item);
        notifyObservers();
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getItemCount() {
        return items.size();
    }
} */

class User implements CartObserver {
    final UserAccount account;
    final CartManager cart;

    public User(UserAccount account, CartManager cart) {
        this.account = account;
        this.cart = cart;
        cart.addObserver(this);
    }

    @Override
    public void update() {
        account.setHasCartItems(true);
        System.out.println("Hello " + account.getUsername() + "! Your cart has items in it.");
    }
}
