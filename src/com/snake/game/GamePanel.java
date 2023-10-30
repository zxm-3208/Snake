package com.snake.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * @author : zxm
 * @date: 2023/10/30 - 10 - 30 - 19:33
 * @Description: com.snake.game
 * @version: 1.0
 */
public class GamePanel extends JPanel {
    //定义两个数组
    //一个数组，存储蛇的x轴坐标
    //一个数组，存储蛇的y轴坐标
    int[] snakeX = new int[500];
    int[] snakeY = new int[500];
    //蛇的长度
    int length;
    //蛇的行走方向
    String direction;
    //游戏状态
    boolean isStart = false;    //false暂停，true开始
    //加入一个定时器
    Timer timer;
    //食物的坐标
    int foodX;
    int foodY;
    //定义一个积分
    int scope;
    //蛇的生存状态
    boolean isDie = false;

    public void init(){
        length = 3;
        //初始化蛇头坐标；
        snakeX[0] = 175;
        snakeY[0] = 275;
        //初始化第一节身子坐标
        snakeX[1] = 150;
        snakeY[1] = 275;
        //初始化第二节身子坐标
        snakeX[2] = 125;
        snakeY[2] = 275;
        //初始化蛇头的方向
        direction = "R";
        //食物的坐标
        foodX = 300;
        foodY = 200;
        scope = 0;
    }

    public GamePanel(){
        init();
        //将焦点定位在当前操作的面板上:
        this.setFocusable(true);
        //加入监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {    //监听键盘按下的操作
                super.keyPressed(e);
                int keycode = e.getKeyCode();
                if(keycode==KeyEvent.VK_SPACE){            //监听空格
                    if(isDie){
                        init();
                        isDie=false;
                    }
                    else {
                        isStart = !isStart;
                        repaint();
                    }
                }
                else if(keycode==KeyEvent.VK_UP&&direction!="D"){           //监听上
                    direction="U";
                }
                else if(keycode==KeyEvent.VK_DOWN&&direction!="U"){           //监听下
                    direction="D";
                }
                else if(keycode==KeyEvent.VK_LEFT&&direction!="R"){           //监听左
                    direction="L";
                }
                else if(keycode==KeyEvent.VK_RIGHT&&direction!="L"){           //监听右
                    direction="R";
                }

            }
        });
        //对定时器进行初始化操作
        timer = new Timer(100, new ActionListener() {
            /*
            * ActionListener是事件监听
            * 相当于每100ms监听一下你是否发生了一个动作
            * 具体的动作方式actionPerformed*/
            @Override
            public void actionPerformed(ActionEvent e) {
                //判断状态
                if(isStart&&isDie==false) {
                    //动身子
                    for(int i=length-1;i>0;i--){
                        snakeX[i]=snakeX[i-1];
                        snakeY[i]=snakeY[i-1];
                    }
                    //动头
                    if("R".equals(direction)){
                        snakeX[0] += 25;
                    }
                    if("L".equals(direction)){
                        snakeX[0] -= 25;
                    }
                    if("U".equals(direction)){
                        snakeY[0] -= 25;
                    }
                    if("D".equals(direction)){
                        snakeY[0] += 25;
                    }

                    //防止蛇超出边界
                    if(snakeX[0]>750){
                        isDie=true;
//                        snakeX[0]=25;
                    }
                    else if(snakeX[0]<25){
                        isDie=true;
//                        snakeX[0]=750;
                    }
                    else if(snakeY[0]<75){
//                        snakeY[0]=725;
                        isDie=true;
                    }
                    else if(snakeY[0]>725){
//                        snakeY[0]=75;
                        isDie=true;
                    }
                    //检测食物碰撞的动作
                    if(snakeX[0] == foodX&&snakeY[0] == foodY){
                        scope++;
                        length++;
                        foodX=(int)(Math.random()*30+1)*25; //[25,750]
                        foodY=(int)(Math.random()*27+3)*25; //[75,725]
                    }
                    //死亡判定
                    for(int i=1;i<length;i++){
                        if(snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]){
                            isDie = true;
                        }
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }

    // 该方法为图形版本的main方法
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //背景颜色
        this.setBackground(new Color(87, 175, 127));
        //头部图片
        Images.headerImg.paintIcon(this,g,10,10);
        g.setColor(new Color(215, 166, 98));
        g.setFont(new Font("微软雅黑",Font.BOLD,25));
        g.drawString("贪吃蛇游戏",340,42);
        //调节画笔颜色
        g.setColor(new Color(181, 210, 171));
        //画一个矩形
        g.fillRect(10,70,770,670);

        //画小蛇
        //画蛇头
        if("R".equals(direction)) {
            Images.rightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        else if("L".equals(direction)) {
            Images.leftImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        else if("U".equals(direction)) {
            Images.upImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        else if("D".equals(direction)) {
            Images.downImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        //画身子
        for(int i=1;i<length;i++) {
            Images.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //如果游戏是暂停的，界面中间就应该有一句提示语：
        if(isStart == false){
            //画一个文字：
            g.setColor(new Color(111,100,255));
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //画文字
            g.drawString("点击空格开始游戏",250,250);
        }
        //画食物
        Images.foodImg.paintIcon(this,g,foodX,foodY);
        //画积分
        g.setColor(new Color(192, 189, 238));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("得分："+scope,620,40);
        //画死亡状态
        if(isDie){
            g.setColor(new Color(224, 60, 52));
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            g.drawString("小蛇死亡，游戏停止，按下空格重新开始游戏",200,330);
        }
    }
}
