package com.crazybunqnq.wallpaper.service;

import com.crazybunqnq.wallpaper.entity.TwoString;
import com.crazybunqnq.wallpaper.util.StringUtil;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
@Log4j
public class BaseService {
    @Test
    public void mainTest() throws IOException {
        String filePath = "/Users/baojunjie/Pictures/Wallpaper/LinuxCommonCommands.md";
        String imagePath = "/Users/baojunjie/Pictures/Wallpaper/Earth and Moon Black Kali.jpg";
        String outputPath = "/Users/baojunjie/Pictures/Wallpaper/output.jpg";
        String fontName = "Consolas";
        int colsSpace = 50;
        int lineHight = 36;
        int fontSzie = 30;
        int marginL = 300;
        int marginT = 100;
        int marginR = 100;
        int marginB = 100;
        float alpha = 0.3f;
        int x = marginL;
        int y = marginT;
        Font contentFont = new Font(fontName, Font.TRUETYPE_FONT, fontSzie);
        Font titleFont = new Font(fontName, Font.BOLD, 72);

        int curLine = 1;
        int curCol = 0;
        boolean write = false;
        boolean addSpace = false;
        File file = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(file));
        Image src = ImageIO.read(new File(imagePath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        int lineWidth = 850;
        int maxLine = (height - marginT - marginB) / lineHight;
        System.out.println("每行宽度：" + lineWidth + ", 最大行数：" + maxLine);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.drawImage(src, 0, 0, width, height, null);
        g.setColor(Color.black);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
        g.fillRect(marginL - 50, marginT - 20, lineWidth * 3 + 50, height - marginB - marginT);
        g.setColor(Color.white);


        String text = null;
        String strTmp = "";
        while ((text = br.readLine()) != null) {
            if (curLine >= maxLine) {
                curCol++;
                curLine = 1;
                x = marginL + curCol * lineWidth;
                System.out.println("完成第 " + (curCol) + " 列");
            }
            String str = "";
            if (text.length() >= 3) {
                str = text.substring(0, 3);
            }
            if ("```".equals(str)) {
                write = !write;
                curLine++;
                continue;
            }
            if (write) {//内容
                strTmp = text;
                do {
                    text = strTmp;
                    TwoString twoString = StringUtil.splitString(g, text, contentFont, lineWidth - colsSpace, true);
                    text = twoString.getFirstStr();
                    strTmp = twoString.getLastStr();
                    addSpace = strTmp.length() > 0;
                    if (addSpace) {
                        System.out.println("当前行过长，自动换行，本次输出：");
                        strTmp = "        " + strTmp;
                        System.out.println("\"" + text + "\"");
                    }
                    g.setFont(contentFont);
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1f));
                    // 在指定坐标绘制水印文字
                    g.drawString(text, x, y + lineHight * curLine);

                    curLine++;
                }
                while (!"".equals(strTmp));
            } else if ("## ".equals(str)) {//标题
                curLine += 2;
                text = text.substring(3);
                g.setFont(titleFont);
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1f));
                // 在指定坐标绘制水印文字
                g.drawString(text, x, y + lineHight * curLine);
                curLine++;
            }
        }
        g.dispose();
        ImageIO.write(image, "JPEG", new File(outputPath));// 输出到文件流
    }
}
