package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 文件或文件夹选择器
 *
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
public class PathSelect extends BaseWidget {
    private ActionListener actionListener;
    private JTextField textField;
    private boolean isFile;

    /**
     * 创建一个路径选择类
     *
     * @param title  标题
     * @param value  值
     * @param isFile true: 选择文件；false 选择文件夹
     */
    public PathSelect(String title, String value, boolean isFile) {
        panel.setMaximumSize(Constant.LABLE_DIMENSION_14);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel label = new JLabel(title + ": ");

        textField = new JTextField(value);
        this.value = value;
        this.isFile = isFile;

        JButton button = new JButton("浏览");
        button.setMaximumSize(Constant.LABLE_DIMENSION_2);
        textField.setMaximumSize(new Dimension(panel.getSize().width - label.getSize().width, 24));

        initListener();
        button.addActionListener(actionListener);

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.setVisible(true);
    }

    @Override
    protected void initListener() {
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                if (isFile) {
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                } else {
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                }
                fc.showOpenDialog(null);
                File file = fc.getSelectedFile();
                if (file != null) {
                    String path = file.getAbsolutePath();
                    textField.setText(path);
                    setValue(path);
                }
            }
        };
    }
}
