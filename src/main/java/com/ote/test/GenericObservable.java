package com.ote.test;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by Olivier on 05/06/2016.
 */
public final class GenericObservable<T extends Observable> implements Observable<T> {

    private final Collection<Registrable<T>> observers = new ArrayList<>();

    private final T observable;

    private final boolean isNotificationAsynchronous;

    public GenericObservable(T observable) {
        this(observable, false);
    }

    public GenericObservable(T observable, boolean isNotificationAsynchronous) {
        this.observable = observable;
        this.isNotificationAsynchronous=isNotificationAsynchronous;
    }

    @Override
    public void notifyObservers() {

        stream().forEach(reg -> reg.getOnUpdate().accept(observable));
    }

    private Stream<Registrable<T>> stream(){
        return isNotificationAsynchronous ? observers.parallelStream() : observers.stream();
    }

    @Override
    public void register(Registrable<T> registrable) {
        observers.add(registrable);
    }

    @Override
    public void unregister(Registrable<T> registrable) {
        observers.removeIf(reg -> reg.getKey().equals(registrable.getKey()));
    }
}
