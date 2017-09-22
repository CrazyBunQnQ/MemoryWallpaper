package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 带有标签的输入框
 *
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
public class TextFiled extends BaseWidget {
    private DocumentListener documentListener;
    private JTextField textField;

    public TextFiled(String title, String value) {
        panel.setMaximumSize(Constant.LABLE_DIMENSION_14);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(title + ": ");

        textField = new JTextField(value);
        this.value = value;

//        textField.setMaximumSize(new Dimension(panel.getSize().width - label.getSize().width, 24));

        initListener();
        textField.getDocument().addDocumentListener(documentListener);

        panel.add(label);
        panel.add(textField);
        panel.setVisible(true);
    }

    @Override
    protected void initListener() {
        documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {//插入事件
                setValue(textField.getText().trim());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {//删除事件
                setValue(textField.getText().trim());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {//更改事件
                setValue(textField.getText().trim());
            }
        };
    }
}
