package com.crazybunqnq.wallpaper.event;

import lombok.Data;
import lombok.Getter;

import java.util.EventObject;

/**
 * @version 2017/9/21.
 * @auther CrazyBunQnQ
 */
@Getter
public class ValueChangeEvent extends EventObject {
    private Object source;
    private String value;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     *
     * @throws IllegalArgumentException if source is null.
     */
    public ValueChangeEvent(Object source, String value) {
        super(source);
        this.source = source;
        this.value = value;
    }
}
