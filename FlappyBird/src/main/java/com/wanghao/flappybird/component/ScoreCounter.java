package com.wanghao.flappybird.component;

import com.wanghao.flappybird.util.Constant;
import com.wanghao.flappybird.util.MusicUtil;

import java.io.*;

/**
 * 游戏计分器，使用静态内部类实现了单例模式
 *
 * @author wanghao
 */
public class ScoreCounter {

    private static class ScoreCounterHolder {
        public static final ScoreCounter scoreCounter = new ScoreCounter();
    }

    public static ScoreCounter getInstance() {
        return ScoreCounterHolder.scoreCounter;
    }

    //分数
    private long score = 0;
    //最高分数
    private long bestScore;

    private ScoreCounter() {
        bestScore = -1;
        try {
            loadBestScore();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 装载最高分数
     */
    private void loadBestScore() throws IOException {
        File file = new File(Constant.SCORE_FILE_PATH);
        if (file.exists()) {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            bestScore = dis.readLong();
            dis.close();
        }
    }

    public void saveScore() {
        bestScore = Math.max(bestScore, getCurrentScore());
        try {
            File file = new File(Constant.SCORE_FILE_PATH);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            dos.writeLong(bestScore);
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void score(Bird bird) {
        if (!bird.isDead()) {
            MusicUtil.playScore();
            score += 1;
        }
    }

    public long getBestScore() {
        return bestScore;
    }

    public long getCurrentScore() {
        return score;
    }

    public void reset() {
        score = 0;
    }
}
