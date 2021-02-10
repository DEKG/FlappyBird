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
    public static final String BG_IMG_PATH = "FlappyBird/resources/img/background.png";

    // 小鸟图片
    public static final String[][] BIRDS_IMG_PATH = {
            {"FlappyBird/resources/img/0.png", "FlappyBird/resources/img/1.png", "FlappyBird/resources/img/2.png", "FlappyBird/resources/img/3.png",
                    "FlappyBird/resources/img/4.png", "FlappyBird/resources/img/5.png", "FlappyBird/resources/img/6.png", "FlappyBird/resources/img/7.png"},
            {"FlappyBird/resources/img/up.png", "FlappyBird/resources/img/up.png", "FlappyBird/resources/img/up.png", "FlappyBird/resources/img/up.png",
                    "FlappyBird/resources/img/up.png", "FlappyBird/resources/img/up.png", "FlappyBird/resources/img/up.png", "FlappyBird/resources/img/up.png"},
            {"FlappyBird/resources/img/down_0.png", "FlappyBird/resources/img/down_1.png", "FlappyBird/resources/img/down_2.png",
                    "FlappyBird/resources/img/down_3.png", "FlappyBird/resources/img/down_4.png", "FlappyBird/resources/img/down_5.png",
                    "FlappyBird/resources/img/down_6.png", "FlappyBird/resources/img/down_7.png"},
            {"FlappyBird/resources/img/dead.png", "FlappyBird/resources/img/dead.png", "FlappyBird/resources/img/dead.png", "FlappyBird/resources/img/dead.png",
                    "FlappyBird/resources/img/dead.png", "FlappyBird/resources/img/dead.png", "FlappyBird/resources/img/dead.png",
                    "FlappyBird/resources/img/dead.png",}};

    // 分数文件路径
    public static final String SCORE_FILE_PATH = "FlappyBird/resources/score";

    //音乐资源路径
    //分数
    public static final String MUSIC_SCORE = "FlappyBird/resources/wav/score.wav";
    //失败
    public static final String MUSIC_CRASH = "FlappyBird/resources/wav/crash.wav";
    /**
     * 游戏速度(水管及背景层的移动速度)
     */
    public static final int GAME_SPEED = 4;

    /**
     * 游戏背景色
     */
    public static final Color BG_COLOR = new Color(0x4bc4cf);

    // 游戏刷新率
    public static final int FPS = 1000 / 30;
}
