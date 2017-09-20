package com.crazybunqnq.wallpaper.widget;

import javax.swing.*;
import java.util.EventListener;

/**
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
public abstract class BaseWidget {
    protected JPanel panel = new JPanel();
    protected String value;
    protected EventListener listener;

    protected abstract void initListener();

    public String getValue() {
        return value;
    }

    public JPanel getPanel() {
        return panel;
    }
}
