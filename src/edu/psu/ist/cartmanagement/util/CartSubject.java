package edu.psu.ist.cartmanagement.util;

public interface CartSubject {
    void addObserver(CartObserver observer);
    void removeObserver(CartObserver observer);
    void notifyObservers();
}
