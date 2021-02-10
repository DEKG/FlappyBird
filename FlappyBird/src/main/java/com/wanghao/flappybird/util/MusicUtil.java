package com.wanghao.flappybird.util;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.*;

/**
 * 音乐工具类
 *
 * @author wanghao
 */
public class MusicUtil {

    private static AudioStream score;

    public static void playScore() {
        try {
            InputStream scoreIn = new FileInputStream(Constant.MUSIC_SCORE);
            score = new AudioStream(scoreIn);
        } catch (IOException e) {
        }
        AudioPlayer.player.start(score);
    }
}
