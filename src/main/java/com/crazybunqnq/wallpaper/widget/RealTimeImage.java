package com.crazybunqnq.wallpaper.widget;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;

/**
 * @version 2017/9/20.
 * @auther CrazyBunQnQ
 */
@Data
@Log4j
@AllArgsConstructor
public class RealTimeImage extends JPanel {
    private String imgPath;
    private String docPath;
    private String outputPath;
    private Font titleFont;
    private Font contentFont;
    private int colWidth;
    private int lineHeight;
    private int maxHeight;
    private Point start;


    public RealTimeImage() {
        super();
    }

    public void refresh() {

    }
}
