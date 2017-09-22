package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;
import com.crazybunqnq.wallpaper.event.ValueChangeEvent;
import com.crazybunqnq.wallpaper.listenter.ValueChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import java.beans.PropertyChangeListener;

/**
 * @version 2017/9/19.
 * @auther CrazyBunQnQ
 */
public class SizeSlider extends BaseWidget {
    protected EventListenerList listenerList = new EventListenerList();
    private JLabel showVal;
    private ChangeListener sliderListener;

    /**
     * 滑动条
     *
     * @param title     标题
     * @param min       最小时
     * @param max       最大值
     * @param value     初始值
     * @param showValue 是否显示值
     */
    public SizeSlider(String title, int min, int max, Integer value, boolean showValue) {
        PropertyChangeListener textListener;
        panel.setMaximumSize(Constant.LABLE_DIMENSION_14);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JSlider jSlider = new JSlider();
        jSlider.setMinimum(min);
        jSlider.setMaximum(max);
        if (value != null) {
            if (value > max) {
                value = max;
            }
            if (value < min) {
                value = min;
            }
            jSlider.setValue(value);
            this.value = value + "";
        } else {
            this.value = min + "";
        }
        showVal = new JLabel(jSlider.getValue() + "");
        showVal.setPreferredSize(Constant.LABLE_DIMENSION_1);

        initListener();

        jSlider.addChangeListener(sliderListener);

        panel.add(new JLabel(title + "："));
        panel.add(jSlider);
        if (showValue) {
            panel.add(showVal);
        }
        panel.setVisible(true);
    }

    @Override
    public void addValueChangeListener(ValueChangeListener vcListener) {
        listenerList.add(ValueChangeListener.class, vcListener);
    }

    public void removeValueChangeListener(ValueChangeListener vcListener) {
        listenerList.remove(ValueChangeListener.class, vcListener);
    }

    private void notifyValueChangeListener(ValueChangeEvent vcEvent) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ValueChangeListener.class) {
                if (vcEvent == null) {
                    vcEvent = new ValueChangeEvent(this,value);
                }
                ((ValueChangeListener) listeners[i + 1]).valueChangeEvent(vcEvent);
            }
        }
    }

    public void setValue(String value) {
        boolean bool = false;
        if (value == null && this.value != null) bool = true;
        else if (value != null && this.value == null) bool = true;
        else if (!this.value.equals(value)) bool = true;
        this.value = value;
        //如果改变则执行事件
        if (bool) notifyValueChangeListener(new ValueChangeEvent(this, this.value));
    }

    /*@Override
    public String getValue() {
        this.value = showVal.getText();
        return value;
    }*/

    private void initListener() {
        sliderListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                setValue(source.getValue() + "");
                showVal.setText(value);
            }
        };
    }
}
