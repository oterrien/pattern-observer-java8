package com.ote.test;

import lombok.Getter;

import java.util.function.Consumer;

/**
 * Created by Olivier on 05/06/2016.
 */
public class WaterPump implements Registrable<MeteoStation> {

    private static int count = 0;

    @Getter
    private final String key;

    public WaterPump() {
        count++;
        this.key = "WaterPump#" + count;
    }

    @Override
    public Consumer<MeteoStation> getOnUpdate() {
        return this::onUpdate;
    }

    private void onUpdate(MeteoStation meteoStation) {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (meteoStation.getWeather().equals("raining")) {
            System.out.println(getKey() + " might be started");
        } else {
            System.out.println(getKey() + " is awaiting");
        }
    }


}
