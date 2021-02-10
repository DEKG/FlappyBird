package com.wanghao.flappybird.component;


import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.wanghao.flappybird.app.Game;
import com.wanghao.flappybird.util.Constant;
import com.wanghao.flappybird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

/**
 * 小鸟类，实现小鸟的绘制与飞行逻辑
 *
 * @author wanghao
 */
public class Bird {
    // 图片数量
    public static final int IMG_COUNT = 8;
    //状态数
    public static final int STATE_COUNT = 4;
    //小鸟图片数组对象
    private final BufferedImage[][] birdImages;
    //小鸟的坐标
    private final int x;
    private int y;
    //翅膀状态
    private int wingState;
    //实时的小鸟图片
    private BufferedImage image;
    //小鸟的状态
    private int state;
    public static final int BIRD_NORMAL = 0;
    public static final int BIRD_UP = 1;
    public static final int BIRD_FAIL = 2;
    public static final int BIRD_DEAD_FAIL = 3;
    public static final int BIRD_DEAD = 4;

    //碰撞矩形
    private final Rectangle birdCollisionRect;
    //补偿碰撞矩形宽高的参数
    public static final int RECT_DESCALE = 2;

    //计分器
    private final ScoreCounter counter;

    public static int BIRD_WIDTH;
    public static int BIRD_HEIGHT;

    //在构造器中对资源初始化
    public Bird() {
        //计分器
        counter = ScoreCounter.getInstance();

        //读取小鸟图片资源
        birdImages = new BufferedImage[STATE_COUNT][IMG_COUNT];
        for (int j = 0; j < STATE_COUNT; j++) {
            for (int i = 0; i < IMG_COUNT; i++) {
                birdImages[j][i] = GameUtil.loadBufferedImage(Constant.BIRDS_IMG_PATH[j][i])
            }
        }

        assert birdImages[0][0] != null;
        BIRD_WIDTH = birdImages[0][0].getWidth();
        BIRD_HEIGHT = birdImages[0][0].getHeight();

        //初始化小鸟的坐标
        x = Constant.FRAME_WIDTH >> 2;
        y = Constant.FRAME_HEIGHT >> 1;

        //初始化碰撞矩形
        int rectX = x - BIRD_WIDTH / 2;
        int rectY = y - BIRD_HEIGHT / 2;
        //碰撞矩形的坐标与小鸟相同
        birdCollisionRect = new Rectangle(rectX + RECT_DESCALE, rectY + RECT_DESCALE * 2, BIRD_WIDTH - RECT_DESCALE * 3, BIRD_WIDTH - RECT_DESCALE * 4);
    }

    /**
     * 绘制方法
     *
     * @param g
     */
    public void draw(Graphics g) {

    }

    /**
     * 判断小鸟是否死亡
     *
     * @return
     */
    public boolean isDead() {
        return state == BIRD_DEAD_FAIL || state == BIRD_DEAD;
    }
}
