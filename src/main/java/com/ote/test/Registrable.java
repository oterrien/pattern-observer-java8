package com.ote.test;

import java.util.function.Consumer;

/**
 * Created by Olivier on 05/06/2016.
 */
public interface Registrable<T extends Observable> {

    String getKey();

    Consumer<T> getOnUpdate();
}
