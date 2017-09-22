package com.crazybunqnq.wallpaper.widget;

import com.crazybunqnq.wallpaper.Constant;
import com.crazybunqnq.wallpaper.exception.FilePathException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
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
    private FileFilter filter;

    private JLabel label;
    private JButton button;

    /**
     * 创建一个文件夹选择器
     *
     * @param title 标题
     * @param value 初始值
     */
    public PathSelect(String title, String value) throws FilePathException {
        File file = new File(value);
        if (file == null || !file.isFile()) {
            throw new FilePathException("文件路径错误");
        }
        init(title, value);
        initListener();
        button.addActionListener(actionListener);
    }


    /**
     * 创建一个文件选择类
     *
     * @param title  标题
     * @param value  初始值
     * @param filter 文件过滤器，限制文件类型
     */
    public PathSelect(String title, String value, FileFilter filter) throws FilePathException {
        File file = new File(value);
        if (file == null || !file.isFile()) {
            throw new FilePathException("文件路径错误");
        }
        init(title, value);
        this.isFile = true;
        this.filter = filter;
        initListener();
        button.addActionListener(actionListener);
    }

    @Override
    protected void initListener() {
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                if (isFile) {
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    if (filter != null) {
                        fc.setFileFilter(filter);
                    }
                } else {
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                }
                fc.setMultiSelectionEnabled(false);//只能选择一个
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

    protected void init(String title, String value) {
        panel.setMaximumSize(Constant.LABLE_DIMENSION_14);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        label = new JLabel(title + ": ");

        textField = new JTextField(value);
        this.value = value;

        button = new JButton("浏览");
        button.setMaximumSize(Constant.LABLE_DIMENSION_2);
        textField.setMaximumSize(new Dimension(panel.getSize().width - label.getSize().width, 24));

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.setVisible(true);
    }
}
