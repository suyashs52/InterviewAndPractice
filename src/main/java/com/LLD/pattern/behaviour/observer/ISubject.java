package com.LLD.pattern.behaviour.observer;

public interface ISubject {
    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObservers();
}
