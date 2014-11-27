package com.arrosage.chengxiaojun.arrosageplante.Model;

import java.util.Date;

/**
 * Created by CHENG Xiaojun on 26/11/14.
 * This class is to presente Plante object
 */


public class Plante {

    private int id;
    private String latin_name;
    private String usuel_name;
    private Date create_Time;
    private Date last_Watering_Time;
    private Date next_Watering_Time;
    /*

        whether is wateringed
     */
    private int is_watringed;
    /**
     * this plante is in which room
     */
    private String room;

    /**
     * the frequency of watering, for exemple 1 means the plante should be watered each day
     */
    private int watering_Frequency;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }

    public String getUsuel_name() {
        return usuel_name;
    }

    public void setUsuel_name(String usuel_name) {
        this.usuel_name = usuel_name;
    }

    public Date getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(Date create_Time) {
        this.create_Time = create_Time;
    }

    public Date getLast_Watering_Time() {
        return last_Watering_Time;
    }


    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setLast_Watering_Time(Date last_Watering_Time) {
        this.last_Watering_Time = last_Watering_Time;
    }

    public int getWatering_Frequency() {
        return watering_Frequency;
    }

    public void setWatering_Frequency(int watering_Frequency) {
        this.watering_Frequency = watering_Frequency;
    }

    public int getIs_watringed() {
        return is_watringed;
    }

    public void setIs_watringed(int is_watringed) {
        this.is_watringed = is_watringed;
    }

    public Date getNext_Watering_Time() {
        return next_Watering_Time;
    }

    public void setNext_Watering_Time(Date next_Watering_Time) {
        this.next_Watering_Time = next_Watering_Time;
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", latin_name='" + latin_name + '\'' +
                ", usuel_name='" + usuel_name + '\'' +
                ", create_Time=" + create_Time +
                ", last_Watering_Time=" + last_Watering_Time +
                ", next_Watering_Time=" + next_Watering_Time +
                ", is_watringed=" + is_watringed +
                ", room='" + room + '\'' +
                ", watering_Frequency=" + watering_Frequency +
                '}';
    }
}
