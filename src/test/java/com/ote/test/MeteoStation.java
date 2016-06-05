package com.ote.test;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Olivier on 05/06/2016.
 */
public class MeteoStation implements Observable<MeteoStation> {

    private String weather;

    private final GenericObservable<MeteoStation> delegate;

    public MeteoStation() {
        this.delegate = new GenericObservable<>(this, true);
    }

    @Override
    public void notifyObservers() {
        delegate.notifyObservers();
    }

    @Override
    public void register(Registrable<MeteoStation> registrable) {
        delegate.register(registrable);
    }

    @Override
    public void unregister(Registrable<MeteoStation> registrable) {
        delegate.unregister(registrable);
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
        this.notifyObservers();
    }
}
