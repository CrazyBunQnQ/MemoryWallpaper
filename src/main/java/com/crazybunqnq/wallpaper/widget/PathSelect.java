package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
public class PathSelect extends BaseWidget {
    public PathSelect(String title, String value, boolean isFile) {
        panel.setMaximumSize(Constant.LABLE_DIMENSION_14);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(title + ": ");

        JTextField textField = new JTextField(value);
        this.value = value;

        JButton button = new JButton("浏览");
        button.setMaximumSize(Constant.LABLE_DIMENSION_2);
        textField.setMaximumSize(new Dimension(panel.getSize().width - label.getSize().width, 24));

        initListener();
        button.addActionListener((ActionListener) listener);

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.setVisible(true);
    }

    @Override
    protected void initListener() {
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    }
}
