package com.crazybunqnq.wallpaper;

import com.crazybunqnq.wallpaper.util.ScreenUtil;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
public class Constant {
    public final static String APP_NAME = "Memory Wallpaper";
    public final static int SCREEN_WIDTH = ScreenUtil.getScreenWidth();
    public final static int SCREEN_HEIGHT = ScreenUtil.getScreenHeight();

    static {
        System.out.println("设备分辨率为 " + SCREEN_WIDTH + " x " + SCREEN_HEIGHT);
    }
}
