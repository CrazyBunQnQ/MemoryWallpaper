package com.crazybunqnq.wallpaper.util;

import lombok.extern.log4j.Log4j;

import java.awt.*;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
@Log4j
public class ScreenUtil {
    private static Dimension screenSize;

    static {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    private ScreenUtil() {

    }

    public static int getScreenWidth() {
        return screenSize.width;
    }

    public static int getScreenHeight() {
        return screenSize.height;
    }
}
