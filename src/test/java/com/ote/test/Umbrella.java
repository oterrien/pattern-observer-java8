package com.ote.test;

import java.util.function.Consumer;

/**
 * Created by Olivier on 05/06/2016.
 */
public class Umbrella implements Registrable<MeteoStation> {

    private static int count = 0;

    public Umbrella() {
        count++;
    }

    @Override
    public String getKey() {
        return "Umbrella#"+count;
    }

    @Override
    public Consumer<MeteoStation> getOnUpdate() {
        return this::onUpdate;
    }

    private void onUpdate(MeteoStation meteoStation) {
        if (meteoStation.getWeather().equals("raining")) {
            System.out.println(getKey() + " might be opened");
        } else if (meteoStation.getWeather().equals("windy")) {
            System.out.println(getKey() + " might be closed");
        } else {
            System.out.println(getKey() + " is awaiting");
        }
    }


}
