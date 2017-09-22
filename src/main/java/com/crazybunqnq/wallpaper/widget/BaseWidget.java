package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.listenter.ValueChangeListener;

import javax.swing.*;

/**
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
public abstract class BaseWidget {
    protected JPanel panel = new JPanel();
    protected String value;
    protected ValueChangeListener listener;

//    protected abstract void initListener();

    public abstract void addValueChangeListener(ValueChangeListener vcListener);

    public String getValue() {
        return value;
    }

    public JPanel getPanel() {
        return panel;
    }
}
