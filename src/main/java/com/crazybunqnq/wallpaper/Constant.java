package com.crazybunqnq.wallpaper;

import com.crazybunqnq.wallpaper.util.ScreenUtil;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
public class Constant {
    public final static String APP_NAME = "Memory Wallpaper";
    public final static int APP_WIDTH = 1000;
    public final static int APP_HEIGHT = 480;
    public final static int SCREEN_WIDTH = ScreenUtil.getScreenWidth();
    public final static int SCREEN_HEIGHT = ScreenUtil.getScreenHeight();
    public final static int PREVIEW_WIDTH = 580;

    public final static String DEFAULT_PATH = new File("doc/default.jpg").getAbsolutePath();

    public final static Dimension SETTING_DIMENSION = new Dimension(350, 400);
    public final static Dimension RIGHT_DIMENSION = new Dimension(600, 460);
    public final static Dimension LABLE_DIMENSION_1 = new Dimension(25, 24);
    public final static Dimension LABLE_DIMENSION_2 = new Dimension(50, 24);
    public final static Dimension LABLE_DIMENSION_4 = new Dimension(60, 24);
    public final static Dimension LABLE_DIMENSION_10 = new Dimension(200, 24);
    public final static Dimension LABLE_DIMENSION_12 = new Dimension(250, 24);
    public final static Dimension LABLE_DIMENSION_14 = new Dimension(300, 24);

    //TODO
    public final static FileFilter imgFilter = new FileNameExtensionFilter("图片文件", "jpg", "jpeg", "png", "bmp");

    //TODO
    public final static FileFilter textFilter = new FileNameExtensionFilter("文本文件", "txt", "md");

    static {
        System.out.println("设备分辨率为 " + SCREEN_WIDTH + " x " + SCREEN_HEIGHT);
    }
}
