package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;
import com.crazybunqnq.wallpaper.listenter.ValueChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
public class TextFiled extends BaseWidget {
    public TextFiled(String title, String value) {
        panel.setMaximumSize(Constant.LABLE_DIMENSION_14);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(title + ": ");

        JTextField textField = new JTextField(value);
        this.value = value;

        textField.setMaximumSize(new Dimension(panel.getSize().width - label.getSize().width, 24));

        initListener();
        textField.addActionListener((ActionListener) listener);


        panel.add(label);
        panel.add(textField);
        panel.setVisible(true);
    }

    protected void initListener() {
    }

    @Override
    public void addValueChangeListener(ValueChangeListener vcListener) {

    }
}
