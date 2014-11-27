package com.arrosage.chengxiaojun.arrosageplante.Outil;

import android.util.Log;

import com.arrosage.chengxiaojun.arrosageplante.Model.Plante;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This is a outil for calculating the watering status for a plante
 * Created by CHENG Xiaojun on 27/11/14.
 */
public class WateringOutil {
    /**
     * calculate watering status
     *
     * @param plante
     * @return 1 means ok,don't need to watering, 0 means need watring, 2 means need to watering this day, or -1 means error
     */
    public int getWateringStatus(Plante plante) {
        int status = -1;
        Date now_time = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(plante.getLast_Watering_Time());


        cal.add(Calendar.DATE, plante.getWatering_Frequency());
        Date next_watering_day = cal.getTime();
        //Log.i("mys","next watring day "+ date_to_string(next_watering_day));

        //compare between next watering day and today
        long different_days = getTwoDateDifference(new Date(), plante.getNext_Watering_Time());
        Log.i("myactivity", "different day  : " + Long.toString(different_days));
        if (different_days == 0) {
            //today we need to watering
            return 2;
        }

        if (different_days < 0) {
            //we don't need to watering today
            return 0;
        }
        if (different_days > 0) {
            //we havn't watring for days
            return 1;
        }

        return status;
    }

    /**
     * get the difference between two day
     * @param beginDate
     * @param endDate
     * @return
     */
    public long getTwoDateDifference(Date beginDate, Date endDate) {
        //Date d1 = df.parse("2004-03-26 13:31:40");
        //Date d2 = df.parse("2004-01-02 11:30:24");
        long diff = endDate.getTime() - beginDate.getTime();

        return diff / (1000 * 60 * 60 * 24);


    }

    public String date_to_string(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String reportDate = df.format(date);
        return reportDate;
    }
}
