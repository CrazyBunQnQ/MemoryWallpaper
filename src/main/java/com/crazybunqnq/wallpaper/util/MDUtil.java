package com.crazybunqnq.wallpaper.util;

import com.crazybunqnq.wallpaper.entity.MDInfo;
import lombok.extern.log4j.Log4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * MarkDown 工具
 *
 * @version 2017/9/23.
 * @auther CrazyBunQnQ
 */
@Log4j
public class MDUtil {
    private MDUtil() {
    }

    /**
     * 从文本文件中获取文本信息
     *
     * @param md          文本文件
     * @param readTitle   是否读取标题
     * @param readContent 是否读取普通内容
     * @param readCode    是否读取代码
     * @param readQuote   是否读取引用
     *
     * @return
     *
     * @throws IOException
     */
    public static MDInfo getMDInfo(File md, boolean readTitle, boolean readContent, boolean readCode, boolean readQuote) throws IOException {
        long start = System.currentTimeMillis();
        int titleLines = 0;
        int contentLines = 0;
        int codeLines = 0;
        int quoteLines = 0;

        boolean isCode = false;

        StringBuffer sb = new StringBuffer();

        BufferedReader br = new BufferedReader(new FileReader(md));

        String text = null;

        while ((text = br.readLine()) != null) {
            String str = "";
            if (text.length() >= 3) {
                str = text.substring(0, 3);
            }
            if ("```".equals(str)) {
                isCode = !isCode;
                sb.append(text + "\n");
                continue;
            }
            if (isCode && readCode) {//记录代码和行数
                codeLines++;
                sb.append(text + "\n");
                continue;
            }
            if (!isCode && readTitle && text.indexOf(" ") >= 0) {//记录标题行数
                str = text.substring(0, text.indexOf(" "));
                switch (str) {
                    case "#":
                    case "##":
                    case "###":
                    case "####":
                    case "#####":
                    case "######":
                        titleLines++;
                        sb.append(text + "\n");
                        continue;
                    default:

                }
            }
            if (readContent && !isCode) {//记录内容和行数
                contentLines++;
                sb.append(text + "\n");
                continue;
            }
            if (readQuote && !isCode) {
                //TODO 记录引用和行数
            }
        }

        log.info("\n\n\n" + sb.toString() +
                "文本内容如上所示。\n" +
                "文本信息：标题 " + titleLines + " 行，内容 " + contentLines + " 行，代码 " + codeLines + " 行，引用 " + quoteLines + " 行\n" +
                "用时 " + (System.currentTimeMillis() - start) + " 毫秒。");
        return new MDInfo(sb, titleLines, contentLines, codeLines, quoteLines);
    }
}

class MDTitle {
}