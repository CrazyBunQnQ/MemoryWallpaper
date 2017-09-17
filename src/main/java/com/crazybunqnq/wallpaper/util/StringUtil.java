package com.crazybunqnq.wallpaper.util;

import com.crazybunqnq.wallpaper.entity.TwoString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * @version 2017/9/17.
 * @auther CrazyBunQnQ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringUtil {
    /**
     * 根据指定宽度将字符串分割为两部分，用来设置自动换行
     *
     * @param g2d
     * @param str       待分割字符串
     * @param font      字体
     * @param width     最大宽度
     * @param brBySpace 是否根据空格换行
     *
     * @return
     */
    public static TwoString splitString(Graphics2D g2d, String str, Font font, int width, boolean brBySpace) {
        String first = "";
        String last = "";
        for (int i = str.length(); i > 0; i--) {
            first = str.substring(0, i);
            FontRenderContext frc = g2d.getFontRenderContext();
            Rectangle2D r2d = font.getStringBounds(first, frc);
            double stringWidth = r2d.getWidth();
            if (width > stringWidth && (brBySpace && (str.charAt(i - 1) == ' ' || i == str.length()))) {
                last = str.substring(i);
                break;
            }
        }
        return new TwoString(first, last);
    }
}
