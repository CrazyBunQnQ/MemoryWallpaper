package com.crazybunqnq.wallpaper.view;

import com.crazybunqnq.wallpaper.Constant;
import com.crazybunqnq.wallpaper.event.ValueChangeEvent;
import com.crazybunqnq.wallpaper.exception.FilePathException;
import com.crazybunqnq.wallpaper.listenter.ValueChangeListener;
import com.crazybunqnq.wallpaper.widget.PathSelect;
import com.crazybunqnq.wallpaper.widget.RealTimeImage;
import com.crazybunqnq.wallpaper.widget.SimpleSlider;
import com.crazybunqnq.wallpaper.widget.TextFiled;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

import javax.swing.*;
import java.awt.*;

/**
 * @version 2017/9/16.
 * @auther CrazyBunQnQ
 */
@Log4j
@Getter
public class MainView {
    private static String imgPath;
    private static String docPath;
    private static String outPath;
    private static String outName;
    private static String outFullPath;
    private static int titleSize;
    private static int contentSize;
    private static int colWidth;
    private static int maxHeight;
    private static int startX;
    private static int startY;

    private static RealTimeImage realTimePreview = new RealTimeImage();

    private MainView() {

    }

    public static void createGUI() throws FilePathException {
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
        //TODO 预览
        frame.setVisible(true);
    }

    private static JPanel createSettingPanel() throws FilePathException {
        JPanel setting = new JPanel();
        setting.setPreferredSize(Constant.SETTING_DIMENSION);

        //原图路径
        PathSelect imgSelect = new PathSelect("原图路径", Constant.DEFAULT_PATH, Constant.imgFilter);
        imgSelect.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                imgPath = imgSelect.getValue();
            }
        });
        JPanel imgPanel = imgSelect.getPanel();

        //文档路径
        PathSelect docSelect = new PathSelect("文档路径", Constant.DEFAULT_PATH, Constant.textFilter);
        docSelect.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                docPath = docSelect.getValue();
            }
        });
        JPanel docPanel = docSelect.getPanel();

        //输出设置
        PathSelect outputSelect = new PathSelect("输出目录", Constant.DEFAULT_PATH);
        outputSelect.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                outPath = outputSelect.getValue();
            }
        });
        JPanel outputPanel = outputSelect.getPanel();

        TextFiled nameTF = new TextFiled("文件名称", "output.jpg");
        nameTF.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                System.out.println("输出文件夹名称：" + nameTF.getValue());
                outName = nameTF.getValue();
            }
        });
        JPanel fileNamePanel = nameTF.getPanel();

        SimpleSlider titleSlider = new SimpleSlider("标题大小", 10, 100, 20, true);
        titleSlider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                titleSize = Integer.parseInt(titleSlider.getValue());
            }
        });
        JPanel titlePanel = titleSlider.getPanel();

        SimpleSlider contentSlider = new SimpleSlider("内容大小", 5, 50, 10, true);
        titleSlider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                contentSize = Integer.parseInt(contentSlider.getValue());
            }
        });
        JPanel contentPanel = contentSlider.getPanel();

        SimpleSlider colWidthSlider = new SimpleSlider("列宽", 100, 1920, 600, true);
        titleSlider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                colWidth = Integer.parseInt(colWidthSlider.getValue());
            }
        });
        JPanel colWidthPanel = colWidthSlider.getPanel();

        SimpleSlider heightSlider = new SimpleSlider("高度", 100, 1280, 700, true);
        titleSlider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                maxHeight = Integer.parseInt(heightSlider.getValue());
            }
        });
        JPanel heightPanel = heightSlider.getPanel();

        SimpleSlider xSlider = new SimpleSlider("水平位置", 0, Constant.SCREEN_WIDTH - 100, 50, false);
        xSlider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                //TODO 水平实时变动事件
                startX = Integer.parseInt(xSlider.getValue());
            }
        });
        JPanel xPanel = xSlider.getPanel();

        SimpleSlider ySlider = new SimpleSlider("竖直位置", 0, Constant.SCREEN_HEIGHT - 100, 50, false);
        ySlider.addValueChangeListener(new ValueChangeListener() {
            @Override
            public void valueChangeEvent(ValueChangeEvent vcEvent) {
                //TODO 竖直实时变动事件
                startY = Integer.parseInt(ySlider.getValue());
            }
        });
        JPanel yPanel = ySlider.getPanel();


        JButton justDoIt = new JButton("立即制作！");

//        JFileChooser fileChooser = new JFileChooser();

        setting.setLayout(new BoxLayout(setting, BoxLayout.Y_AXIS));

        setting.add(imgPanel);
        setting.add(docPanel);
        setting.add(outputPanel);
        setting.add(fileNamePanel);
        setting.add(titlePanel);
        setting.add(contentPanel);
        setting.add(colWidthPanel);
        setting.add(heightPanel);
        setting.add(xPanel);
        setting.add(yPanel);

        setting.add(justDoIt);

//        setting.add(fileChooser);

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
        ImageIcon imageIcon = new ImageIcon(imgPath == null || "".equals(imgPath) ? Constant.DEFAULT_PATH : imgPath);
        int imgWidth = imageIcon.getIconWidth();
        int imgHeight = imageIcon.getIconHeight();
        System.out.println("图片分辨率为 " + imgWidth + " x " + imgHeight);
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
