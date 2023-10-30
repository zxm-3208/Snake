package com.snake.game;

import javax.swing.*;
import java.net.URL;

/**
 * @author : zxm
 * @date: 2023/10/30 - 10 - 30 - 17:33
 * @Description: com.snake.game
 * @version: 1.0
 */
public class Images {
    // 将图片路径封装为一个对象
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    // 将图片封装为一个对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);
    public static URL downURL = Images.class.getResource("/images/down.png");
    // 将图片封装为一个对象
    public static ImageIcon downImg = new ImageIcon(downURL);
    public static URL foodURL = Images.class.getResource("/images/food.png");
    // 将图片封装为一个对象
    public static ImageIcon foodImg = new ImageIcon(foodURL);
    public static URL headerURL = Images.class.getResource("/images/header.png");
    // 将图片封装为一个对象
    public static ImageIcon headerImg = new ImageIcon(headerURL);
    public static URL leftURL = Images.class.getResource("/images/left.png");
    // 将图片封装为一个对象
    public static ImageIcon leftImg = new ImageIcon(leftURL);
    public static URL rightURL = Images.class.getResource("/images/right.png");
    // 将图片封装为一个对象
    public static ImageIcon rightImg = new ImageIcon(rightURL);
    public static URL upURL = Images.class.getResource("/images/up.png");
    // 将图片封装为一个对象
    public static ImageIcon upImg = new ImageIcon(upURL);
}
