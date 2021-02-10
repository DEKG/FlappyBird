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

    private static AudioStream fly;
    private static AudioStream crash;
    private static AudioStream score;

    public static void playCrash() {
        try {
            InputStream crashIn = new FileInputStream(Constant.MUSIC_CRASH);
            crash = new AudioStream(crashIn);
        } catch (IOException ignored) {
        }
        AudioPlayer.player.start(crash);
    }

    public static void playScore() {
        try {
            InputStream scoreIn = new FileInputStream(Constant.MUSIC_SCORE);
            score = new AudioStream(scoreIn);
        } catch (IOException ignored) {
        }
        AudioPlayer.player.start(score);
    }
}
