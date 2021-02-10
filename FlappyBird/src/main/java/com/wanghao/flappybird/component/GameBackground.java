package com.wanghao.flappybird.component;

import com.wanghao.flappybird.util.Constant;
import com.wanghao.flappybird.util.GameUtil;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * 游戏背景类，实现游戏背景的绘制
 *
 * @author wanghao
 */
public class GameBackground {

    // 背景图片
    private static final BufferedImage BACKGROUND_IMG;

    //背景层的速度
    private final int speed;
    // 背景层的坐标
    private int layerX;

    public static final int GROUND_HEIGHT;

    static {
        BACKGROUND_IMG = GameUtil.loadBufferedImage(Constant.BG_IMG_PATH);
        assert BACKGROUND_IMG != null;
        GROUND_HEIGHT = BACKGROUND_IMG.getHeight() / 2;
    }

    /**
     * 在构造器中初始化
     */
    public GameBackground() {
        this.speed = Constant.GAME_SPEED;
        this.layerX = 0;
    }

    /**
     * 绘制方法
     *
     * @param g
     * @param bird
     */
    public void draw(Graphics g, Bird bird) {
        //绘制背景色
        g.setColor(Constant.BG_COLOR);
        g.fillRect(0, 0, Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);

        //获得背景图片的尺寸
        int imgWidth = BACKGROUND_IMG.getWidth();
        int imgHeight = BACKGROUND_IMG.getHeight();

        //根据窗口宽度得到图片的绘制次数
        int count = Constant.FRAME_WIDTH / imgWidth + 2;
        for (int i = 0; i < count; i++) {
            g.drawImage(BACKGROUND_IMG, imgWidth * i - layerX, Constant.FRAME_HEIGHT - imgHeight, null);
        }

        //小鸟死亡则不再绘制
        if (bird.isDead()) {
            return;
        }
        movement();
    }

    /**
     * 背景层的运动逻辑
     */
    private void movement() {
        layerX += speed;
        if (layerX > BACKGROUND_IMG.getWidth()) {
            layerX = 0;
        }
    }
}
