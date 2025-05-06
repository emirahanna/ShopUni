package edu.psu.ist.cartmanagement.util;

public interface Subject {
    void addObserver(CartObserver observer);
    void removeObserver(CartObserver observer);
    void notifyObservers();
}