package com.arrosage.chengxiaojun.arrosageplante.Outil;

import android.util.Log;

import com.arrosage.chengxiaojun.arrosageplante.Model.Plante;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jamesRMBP on 27/11/14.
 */
public class WateringOutil {
    /**
     * get watering status
     * @param plante
     * @return 1 means ok,don't need to watering, 0 means need watring, 2 means need to watering this day, or -1 means error
     */
    public int getWateringStatus(Plante plante){
        int status = -1;
        Date now_time = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(plante.getLast_Watering_Time());
        //cal.setTime(new Date());
        cal.add(Calendar.DATE,plante.getWatering_Frequency());
        Date next_watering_day = cal.getTime();


        int different_days = getTwoDateDifference(now_time,next_watering_day);
        Log.i("myactivity", "different day  : " + Integer.toString(different_days));
        if(different_days == 0){
            return 2;
        }
        if (different_days < 0){
            return 0;
        }
        if(different_days > 0 ){
            return 1;
        }

        return status;
    }

    public int getTwoDateDifference(Date beginDate, Date endDate){
        //Date d1 = df.parse("2004-03-26 13:31:40");
        //Date d2 = df.parse("2004-01-02 11:30:24");
        long diff = endDate.getTime() - beginDate.getTime();

        int days = (int) diff / (1000 * 60 * 60 * 24);
        return days;

    }
}
