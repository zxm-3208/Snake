package com.snake.game;

import java.net.URL;

/**
 * @author : zxm
 * @date: 2023/10/30 - 10 - 30 - 17:47
 * @Description: com.snake.game
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        URL bodyURL = Images.class.getResource("/images/body.png");
        System.out.println(bodyURL);
    }

}
