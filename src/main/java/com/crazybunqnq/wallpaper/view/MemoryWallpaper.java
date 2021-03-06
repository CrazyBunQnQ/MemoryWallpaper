package com.crazybunqnq.wallpaper.view;

import com.crazybunqnq.wallpaper.exception.FilePathException;
import lombok.*;
import lombok.extern.log4j.Log4j;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
@Data
@Log4j
public class MemoryWallpaper {
    public static void main(String[] args) throws FilePathException {
        MainView.createGUI();
    }
}
