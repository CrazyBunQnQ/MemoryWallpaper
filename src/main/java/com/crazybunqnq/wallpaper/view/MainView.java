package com.crazybunqnq.wallpaper.view;

import com.crazybunqnq.wallpaper.Constant;
import com.crazybunqnq.wallpaper.widget.SizeSlider;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
@Data
@Log4j
public class MainView {
    private static String imgPath = "";

    private MainView() {

    }

    public static void createGUI() {
        //多个浏览器使用 GraphicsDevice
        /*GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();*/
        JFrame frame = new JFrame(Constant.APP_NAME);
        frame.setSize(Constant.APP_WIDTH, Constant.APP_HEIGHT);
        frame.setLocation((Constant.SCREEN_WIDTH - Constant.APP_WIDTH) / 2, (Constant.SCREEN_HEIGHT - Constant.APP_HEIGHT) / 2);
//        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(createSettingPanel());
        frame.add(initRightPanel());
        /*Container panel = frame.getContentPane();
        panel.setLayout(new FlowLayout());
        panel.add()*/

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

    private static JPanel createSettingPanel() {
        JPanel setting = new JPanel();
        setting.setPreferredSize(Constant.SETTING_DIMENSION);

        //原图路径
        JPanel imgPanel = new JPanel();
        imgPanel.setLayout(new FlowLayout());
        JLabel textLable1 = new JLabel("原图路径:");
        textLable1.setPreferredSize(Constant.LABLE_DIMENSION_4);
        imgPanel.add(textLable1);
        JTextField imgPathText = new JTextField();
        imgPathText.setPreferredSize(Constant.LABLE_DIMENSION_10);
        imgPanel.add(imgPathText);
        JButton imgButton = new JButton("浏览");
        imgButton.setPreferredSize(Constant.LABLE_DIMENSION_2);
        imgPanel.add(imgButton);

        //文档路径
        JPanel docPanel = new JPanel();
        docPanel.setLayout(new FlowLayout());
        JLabel textLable2 = new JLabel("文本路径:");
        textLable2.setPreferredSize(Constant.LABLE_DIMENSION_4);
        docPanel.add(textLable2);
        JTextField docPathText = new JTextField();
        docPathText.setPreferredSize(Constant.LABLE_DIMENSION_10);
        docPanel.add(docPathText);
        JButton docButton = new JButton("浏览");
        docButton.setPreferredSize(Constant.LABLE_DIMENSION_2);
        docPanel.add(docButton);

        //输出设置
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout());
        JLabel textLable3 = new JLabel("输出目录:");
        textLable3.setPreferredSize(Constant.LABLE_DIMENSION_4);
        outputPanel.add(textLable3);
        JTextField outputPathText = new JTextField();
        outputPathText.setPreferredSize(Constant.LABLE_DIMENSION_10);
        outputPanel.add(outputPathText);
        JButton outButton = new JButton("浏览");
        outButton.setPreferredSize(Constant.LABLE_DIMENSION_2);
        outputPanel.add(outButton);
        JPanel fileNamePanel = new JPanel();
        fileNamePanel.setLayout(new FlowLayout());
        JLabel textLable4 = new JLabel("文件名:");
        textLable4.setPreferredSize(Constant.LABLE_DIMENSION_4);
        fileNamePanel.add(textLable4);
        JTextField outputNameText = new JTextField();
        outputNameText.setPreferredSize(Constant.LABLE_DIMENSION_12);
        outputNameText.setText("output.jpg");
        fileNamePanel.add(outputNameText);

        SizeSlider titleSlider = new SizeSlider("标题大小");
        JPanel titlePanel = titleSlider.getMainWin();


        setting.setLayout(new BoxLayout(setting, BoxLayout.Y_AXIS));
        setting.add(imgPanel);
        setting.add(docPanel);
        setting.add(outputPanel);
        setting.add(fileNamePanel);
        setting.add(titlePanel);

//        setting.add()
        return setting;
    }

    private static JPanel initRightPanel() {
        JPanel right = new JPanel();
//        right.setSize(500, 440);
        right.setPreferredSize(Constant.RIGHT_DIMENSION);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        JLabel text = new JLabel("实时预览");
        text.setPreferredSize(Constant.LABLE_DIMENSION_4);
        text.setHorizontalTextPosition(SwingConstants.LEFT);
        text.setVerticalTextPosition(SwingConstants.CENTER);

        right.add(text);
        right.add(createPreviewPanel());
        return right;
    }

    private static JPanel createPreviewPanel() {
        JPanel preview = new JPanel(new CardLayout());
        preview.setLocation(0, 0);
        ImageIcon imageIcon = new ImageIcon("".equals(imgPath) ? Constant.DEFAULT_PATH : imgPath);
        int imgWidth = imageIcon.getIconWidth();
        int imgHeight = imageIcon.getIconHeight();
        System.out.println(imgWidth + "*" + imgHeight);
        float aspectRatio = (float) imgWidth / (float) imgHeight;
        int previewHeight = (int) (Constant.PREVIEW_WIDTH / aspectRatio);
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(Constant.PREVIEW_WIDTH, previewHeight, Image.SCALE_DEFAULT));
        preview.setPreferredSize(new Dimension(Constant.PREVIEW_WIDTH + 20, previewHeight + 20));

        JLabel backgroundImg = new JLabel(imageIcon);
        preview.add(backgroundImg);
        return preview;
    }

    private static JPanel createFontPanel(String name) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.X_AXIS));
        JLabel nameLable = new JLabel(name + "大小");
        JSlider jSlider = new JSlider();
        return jPanel;
    }
}
