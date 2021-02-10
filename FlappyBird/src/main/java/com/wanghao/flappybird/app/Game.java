package com.wanghao.flappybird.app;

import com.wanghao.flappybird.component.Bird;
import com.wanghao.flappybird.component.GameBackground;
import com.wanghao.flappybird.util.Constant;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.*;


/**
 * @author wanghao
 */
public class Game extends Frame {
    private static final long serialVersionUID = 1L;

    //游戏状态
    private static int gameState;
    // 游戏未开始
    public static final int GAME_READY = 0;
    // 游戏开始
    public static final int GAME_START = 1;
    // 游戏结束
    public static final int STATE_OVER = 2;

    private static ExecutorService executor = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory());
    //游戏背景对象
    private GameBackground background;
    //小鸟对象
    private Bird bird;

    /**
     * 游戏初始化
     */
    public Game() {
        // 初始化游戏窗口
        initFrame();
        // 窗口默认为不可见，设置为可见
        setVisible(true);
        // 初始化游戏对象
        initGame();
    }

    /**
     * 初始化游戏窗口
     */
    private void initFrame() {
        //设置窗口大小
        setSize(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        //设置窗口标题
        setTitle(Constant.GAME_TITLE);
        //窗口初始位置
        setLocation(Constant.FRAME_X, Constant.FRAME_Y);
        // 设置窗口大小不可变
        setResizable(false);
        //添加关闭窗口事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //  结束程序
                System.exit(0);
            }
        });
    }

    /**
     * 初始化游戏中的各个对象
     */
    private void initGame() {
        background = new GameBackground();
        bird = new Bird();
        setGameState(GAME_READY);

        //启动用于刷新窗口的线程
        executor.execute(() -> {
            while (true) {
                //通过调用repaint(),让JVM调用update()
                repaint();
                try {
                    Thread.sleep(Constant.FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private final BufferedImage bufImg = new BufferedImage(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT, BufferedImage.TYPE_4BYTE_ABGR);

    @Override
    public void update(Graphics g) {
        //获得图片画笔
        Graphics bufG = bufImg.getGraphics();

        //使用图片画笔将需要绘制的内容绘制到图片
        //背景层
        background.draw(bufG, bird);
        bird.draw(bufG);
        //一次性将图片绘制到屏幕上
        g.drawImage(bufImg, 0, 0, null);
    }

    public static void setGameState(int gameState) {
        Game.gameState = gameState;
    }
}
