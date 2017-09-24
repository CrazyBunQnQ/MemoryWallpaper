package com.crazybunqnq.wallpaper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文本信息类
 * <br/>
 * 记录文本内容和各种类型的文本行数，用来计算文本区域大小
 *
 * @version 2017/9/23.
 * @auther CrazyBunQnQ
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MDInfo {
    /**
     * 需要写入背景图的文本内容
     */
    private StringBuffer text;
    //TODO 拆分标题行数为各种标题行数，抽取类
    /**
     * 标题行数
     */
    private int titleLines;
    /**
     * 内容行数
     */
    private int contentLines;
    /**
     * 代码行数
     */
    private int codeLines;
    /**
     * 引用行数
     */
    private int quoteLines;
}
