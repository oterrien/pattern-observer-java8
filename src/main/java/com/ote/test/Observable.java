package com.ote.test;

/**
 * Created by Olivier on 05/06/2016.
 */
public interface Observable<T extends Observable> {

    void notifyObservers();

    void register(Registrable<T> registrable);

    void unregister(Registrable<T> registrable);
}
