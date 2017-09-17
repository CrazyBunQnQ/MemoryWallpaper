package com.crazybunqnq.wallpaper.view;

import com.crazybunqnq.wallpaper.Constant;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import javax.swing.*;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
@Data
@Log4j
public class MainView {
    private MainView() {

    }

    public static void createGUI() {
        //多个浏览器使用 GraphicsDevice
        /*GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();*/

        int width = 480;
        int height = 320;


        JFrame frame = new JFrame(Constant.APP_NAME);
        frame.setSize(width, height);
        frame.setLocation((Constant.SCREEN_WIDTH - width) / 2, (Constant.SCREEN_HEIGHT - height) / 2);
//        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //TODO 文字输入框
        //TODO 或 txt or md 文件
        //TODO 图片路径
        //TODO 显示图片
        //TODO 输出目录
        //TODO 预览
        //TODO DPI 设置
        //TODO 分辨率设置
        //TODO 字体
        frame.setVisible(true);
    }
}
