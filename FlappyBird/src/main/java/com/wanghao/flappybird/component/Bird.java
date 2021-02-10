package com.wanghao.flappybird.component;


import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.wanghao.flappybird.app.Game;
import com.wanghao.flappybird.util.Constant;
import com.wanghao.flappybird.util.GameUtil;
import com.wanghao.flappybird.util.MusicUtil;

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
    private final GameOverAnimation gameOverAnimation;

    public static int BIRD_WIDTH;
    public static int BIRD_HEIGHT;

    //在构造器中对资源初始化
    public Bird() {
        //计分器
        counter = ScoreCounter.getInstance();
        gameOverAnimation = new GameOverAnimation();

        //读取小鸟图片资源
        birdImages = new BufferedImage[STATE_COUNT][IMG_COUNT];
        for (int j = 0; j < STATE_COUNT; j++) {
            for (int i = 0; i < IMG_COUNT; i++) {
                birdImages[j][i] = GameUtil.loadBufferedImage(Constant.BIRDS_IMG_PATH[j][i]);
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
        movement();
        //图片资源索引
        int state_index = Math.min(state, BIRD_DEAD_FAIL);
        //小鸟中心点计算
        int halfImgWidth = birdImages[state_index][0].getWidth() >> 1;
        int halfImgHeight = birdImages[state_index][0].getHeight() >> 1;
        if (velocity > 0) {
            image = birdImages[BIRD_UP][0];
        }
        //x坐标位于窗口1/4处，y坐标位于窗口中心
        g.drawImage(image, x - halfImgWidth, y - halfImgHeight, null);

//        if (state == BIRD_DEAD) {
//            gameOverAnimation.draw(g, this);
//        } else if (state != BIRD_DEAD_FAIL) {
//            drawScore(g);
//        }
    }

    // players speed on flapping
    public static final int ACC_FLAP = 14;
    // players downward acceleration
    public static final double ACC_Y = 2;
    // max vel along Y, max descend speed
    public static final int MAX_VEL_Y = 15;
    // bird's velocity along Y, default same as playerFlapped
    private int velocity = 0;
    private final int BOTTOM_BOUNDARY = Constant.FRAME_HEIGHT - GameBackground.GROUND_HEIGHT - (BIRD_HEIGHT / 2);

    //小鸟的飞行逻辑
    private void movement() {
//翅膀状态，实现小鸟振翅飞行
        wingState++;
        image = birdImages[Math.min(state, BIRD_DEAD_FAIL)][wingState / 10 % IMG_COUNT];
        if (state == BIRD_FAIL || state == BIRD_DEAD_FAIL) {
            freeFall();
            if (birdCollisionRect.y > BOTTOM_BOUNDARY) {
                if (state == BIRD_FAIL) {
                    MusicUtil.playCrash();
                }
                die();
            }
        }
    }

    private void freeFall() {
        if (velocity < MAX_VEL_Y) {
            velocity -= ACC_Y;
        }
        y = Math.min((y - velocity), BOTTOM_BOUNDARY);
        birdCollisionRect.y = birdCollisionRect.y - velocity;
    }

    private void die() {
        counter.saveScore();
        state = BIRD_DEAD;
        Game.setGameState(Game.STATE_OVER);
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
