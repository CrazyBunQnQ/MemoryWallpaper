package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.beans.PropertyChangeListener;

/**
 * 含有标题的滑动条
 * <br/>
 * 可通过 getPanel() 获取 Panel
 *
 * @version 2017/9/19.
 * @auther CrazyBunQnQ
 */
public class SimpleSlider extends BaseWidget {
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
    public SimpleSlider(String title, int min, int max, Integer value, boolean showValue) {
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
    protected void initListener() {
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
