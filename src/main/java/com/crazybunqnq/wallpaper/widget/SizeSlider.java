package com.crazybunqnq.wallpaper.widget;

import lombok.extern.log4j.Log4j;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @version 2017/9/19.
 * @auther CrazyBunQnQ
 */
@Log4j
public class SizeSlider {
    private int value;
    private JPanel mainWin = new JPanel();

    public SizeSlider(String title) {
        ChangeListener sliderListener;
        PropertyChangeListener textListener;
        mainWin.setLayout(new BoxLayout(mainWin, BoxLayout.X_AXIS));
        JSlider jSlider = new JSlider();
//        jSlider.setExtent(10);
        JTextField showVal = new JTextField();

        sliderListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                //取出滑动条的值，并在文本中显示出来
                JSlider source = (JSlider) event.getSource();
                value = source.getValue();
                showVal.setText("" + value);
            }
        };

        textListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                JTextField source = (JTextField) evt.getSource();
                String text = source.getText();
                jSlider.setValue("".equals(text) ? 10 : Integer.parseInt(source.getText()));
                value = jSlider.getValue();
            }
        };
        jSlider.addChangeListener(sliderListener);
        showVal.addPropertyChangeListener(textListener);

        mainWin.add(new JLabel(title + "："));
        mainWin.add(jSlider);
        mainWin.add(showVal);
        mainWin.setVisible(true);
    }

    public int getValue() {
        return value;
    }

    public JPanel getMainWin() {
        return mainWin;
    }
}
