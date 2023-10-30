package com.snake.game;

import javax.swing.*;
import java.awt.*;

/**
 * @author : zxm
 * @date: 2023/10/30 - 10 - 30 - 19:26
 * @Description: com.snake.game
 * @version: 1.0
 */
public class StartGame {
    public static void main(String[] args) {
        //创建一个窗体
        JFrame jf = new JFrame();
        //窗体标题
        jf.setTitle("贪吃蛇");
        //设置窗体弹出的坐标，对应窗体的宽和高
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-800)/2,(height-800)/2,800,800);
        //设置窗体大小不可调节
        jf.setResizable(false);
        //关闭窗口的同时，关闭程序
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建面板
        GamePanel gp = new GamePanel();
        jf.add(gp);
        //默认隐藏窗体,相关设置结束后，再显现
        jf.setVisible(true);
    }
}
