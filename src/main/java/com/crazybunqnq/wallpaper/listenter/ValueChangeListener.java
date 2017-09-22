package com.crazybunqnq.wallpaper.listenter;

import com.crazybunqnq.wallpaper.event.ValueChangeEvent;

import java.util.EventListener;

/**
 * @version 2017/9/21.
 * @auther CrazyBunQnQ
 */
public interface ValueChangeListener extends EventListener {
    public void valueChangeEvent(ValueChangeEvent vcEvent);
}
