package com.wanghao.flappybird.util;

import java.awt.*;

/**
 * @author wanghao
 */
public class Constant {

    /**
     * 窗口尺寸
     */
    public static final int FRAME_WIDTH = 420;
    public static final int FRAME_HEIGHT = 640;

    /**
     * 游戏标题
     */
    public static final String GAME_TITLE = "Flappy Bird";

    /**
     * 窗口位置
     */
    public static final int FRAME_X = 600;
    public static final int FRAME_Y = 100;

    // 图像资源路径
    /***
     * 背景图片
     */
    public static final String BG_IMG_PATH = "resources/img/background.png";

    // 小鸟图片
    public static final String[][] BIRDS_IMG_PATH = {
            {"resources/img/0.png", "resources/img/1.png", "resources/img/2.png", "resources/img/3.png",
                    "resources/img/4.png", "resources/img/5.png", "resources/img/6.png", "resources/img/7.png"},
            {"resources/img/up.png", "resources/img/up.png", "resources/img/up.png", "resources/img/up.png",
                    "resources/img/up.png", "resources/img/up.png", "resources/img/up.png", "resources/img/up.png"},
            {"resources/img/down_0.png", "resources/img/down_1.png", "resources/img/down_2.png",
                    "resources/img/down_3.png", "resources/img/down_4.png", "resources/img/down_5.png",
                    "resources/img/down_6.png", "resources/img/down_7.png"},
            {"resources/img/dead.png", "resources/img/dead.png", "resources/img/dead.png", "resources/img/dead.png",
                    "resources/img/dead.png", "resources/img/dead.png", "resources/img/dead.png",
                    "resources/img/dead.png",}};

    // 分数文件路径
    public static final String SCORE_FILE_PATH = "resources/score";

    //音乐资源路径
    //分数
    public static final String MUSIC_SCORE = "resources/wav/score.wav";
    /**
     * 游戏速度(水管及背景层的移动速度)
     */
    public static final int GAME_SPEED = 4;

    /**
     * 游戏背景色
     */
    public static final Color BG_COLOR = new Color(0x4bc4cf);

    // 游戏刷新率
    public static final int FPS = 1000 / 1;
}
