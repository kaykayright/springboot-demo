package com.kaykayking.common.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:43 上午 2022/8/17.
 * @Modified By:
 */

import lombok.val;

import java.util.Calendar;

/**
 * todo
 *
 * @author hk
 * @version Id: DateTools.java, v 0.1 2022/8/17 10:43 上午 Exp $$
 */
public class DateTools {


    public static int getSecondsNextEarlyMorning(){

        val cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR,1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.MILLISECOND,0);
        return Math.toIntExact((cal.getTimeInMillis() - System.currentTimeMillis()) / 1000 / 60 /60);

    }

    public static void main(String[] args) {

        System.out.println(DateTools.getSecondsNextEarlyMorning());


    }


}