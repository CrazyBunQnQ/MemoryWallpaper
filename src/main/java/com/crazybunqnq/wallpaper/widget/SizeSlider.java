package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.beans.PropertyChangeListener;

/**
 * @version 2017/9/19.
 * @auther CrazyBunQnQ
 */
@Log4j
public class SizeSlider extends BaseWidget {
    private JLabel showVal;

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
        ChangeListener sliderListener;
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

        jSlider.addChangeListener((ChangeListener) listener);

        panel.add(new JLabel(title + "："));
        panel.add(jSlider);
        if (showValue) {
            panel.add(showVal);
        }
        panel.setVisible(true);
    }


    @Override
    protected void initListener() {
        listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //取出滑动条的值，并在文本中显示出来
                JSlider source = (JSlider) e.getSource();
                value = source.getValue() + "";
                showVal.setText("" + value);
            }
        };
    }
}
