package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.event.ValueChangeEvent;
import com.crazybunqnq.wallpaper.listenter.ValueChangeListener;

import javax.swing.*;
import javax.swing.event.EventListenerList;

/**
 * 自定义控件基类
 * <br/>
 * 通过 getPanel() 获取控件
 * <br/>
 * 通过 addValueChangeListener() 添加监听器
 *
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
public abstract class BaseWidget {
    protected EventListenerList listenerList = new EventListenerList();
    protected JPanel panel = new JPanel();
    /**
     * 控件的值
     */
    protected String value;
    /**
     * 监听 value 值变化的监听器
     */
    protected ValueChangeListener listener;

    /**
     * 初始化自身独有的监听器(不是 ValueChangeListener)
     */
    protected abstract void initListener();

    /**
     * 添加 value 属性变化的监听器
     *
     * @param vcListener
     */
    public void addValueChangeListener(ValueChangeListener vcListener) {
        listenerList.add(ValueChangeListener.class, vcListener);
    }

    /**
     * 移除 value 属性变化的监听器
     *
     * @param vcListener
     */
    public void removeValueChangeListener(ValueChangeListener vcListener) {
        listenerList.remove(ValueChangeListener.class, vcListener);
    }

    /**
     * 参考 JSlider 的 fireStateChanged 方法
     *
     * @param vcEvent
     */
    protected void fireStateChanged(ValueChangeEvent vcEvent) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ValueChangeListener.class) {
                if (vcEvent == null) {
                    vcEvent = new ValueChangeEvent(this, value);
                }
                ((ValueChangeListener) listeners[i + 1]).valueChangeEvent(vcEvent);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getValue() {
        return value;
    }

    /**
     * 设置 value 值，同时将新的值通知给 ValueChangeListener
     *
     * @param value
     */
    public void setValue(String value) {
        boolean bool = false;
        if (value == null && this.value != null) bool = true;
        else if (value != null && this.value == null) bool = true;
        else if (!this.value.equals(value)) bool = true;
        this.value = value;
        //如果改变则执行事件
        if (bool) fireStateChanged(new ValueChangeEvent(this, this.value));
    }

}
