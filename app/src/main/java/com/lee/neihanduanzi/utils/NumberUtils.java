package com.lee.neihanduanzi.utils;

import java.text.DecimalFormat;

/**
 * Created by u on 2017/6/23.
 */

public class NumberUtils {


    /**
     * 将数字以千位转换
     *
     * @param count
     * @return
     */
    public static String numberToThousand(int count) {
        String num = null;
        if (count / 1000 > 0) {

            double thousand = (count / 1000.0);
            DecimalFormat df = new DecimalFormat("0.0k");
            num = df.format(thousand);
        } else {
            num = String.valueOf(count);
        }
        return num;
    }

    /**
     *  position 单位秒
     *  将position 转化为 00：55 格式
     * @param position
     * @return
     */
    public static String numberToPlayTime(int position) {
        StringBuilder duration = new StringBuilder();
        int seconds = (int) (position % 60);
        int mill = (int) (position / 60);
        if (mill < 10) {
            duration.append("0").append(mill);
        } else {
            duration.append(mill);
        }
        duration.append(":");
        if (seconds < 10) {
            duration.append("0").append(seconds);
        } else {
            duration.append(seconds);
        }
        return duration.toString();
    }
}
