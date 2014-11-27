package com.arrosage.chengxiaojun.arrosageplante.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/** BD Helper
 * Created by CHENG Xiaojun on 26/11/14.
 */
public class BD extends SQLiteOpenHelper {
    private SQLiteDatabase bd;

    private String table_name = "plantes";

    public BD(Context ctx) {
        super(ctx, "Plantes.bd", null, 1);
        bd = getWritableDatabase();
    }

    //
    public BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * private int id;
     private String latin_name;
     private String usuel_name;
     private Date create_Time;
     private Date last_Watering_Time;
     priavte int watering_Frequency;
     private String room;
     private int is_watered;
     private Date next_Watering_Time;
     * @param db
     */
    // create the table of plantes
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE plantes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "latin_name TEXT NOT NULL,"
                + "usuel_name TEXT NOT NULL,"
                + "create_Time DATE NOT NULL,"
                + "last_Watering_Time DATE NOT NULL,"
                +"watering_Frequency INTEGER NOT NULL,"
                +"room TEXT NOT NULL,"
                +"isWatered INTEGER NOT NULL,"
                + "next_Watering_Time DATE NOT NULL);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int ancienneVersion,
                          int nouvelleVersion) {
        db.execSQL("DROP TABLE plantes;");
        onCreate(db);
    }

    public void fermeture() {
        bd.close();
    }

    public long ajouter(Plante plante) {

        ContentValues valeurs = new ContentValues();

        // set the format to sql date time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        valeurs.put("latin_name", plante.getLatin_name());
        valeurs.put("usuel_name", plante.getUsuel_name());
        valeurs.put("create_Time", dateFormat.format(plante.getCreate_Time()));
        valeurs.put("last_Watering_Time", dateFormat.format(plante.getLast_Watering_Time()));
        valeurs.put("watering_Frequency", plante.getWatering_Frequency());
        valeurs.put("room", plante.getRoom());
        valeurs.put("isWatered",plante.getIs_watringed());
        valeurs.put("next_Watering_Time",dateFormat.format(plante.getNext_Watering_Time()));


        //insertion of valeur into the table
        return bd.insert("plantes", null, valeurs);
    }

    /**
     * Mise a jour information of a plante
     * @param plante
     * @return
     */
    public int miseAJour(Plante plante) {

        ContentValues valeurs = new ContentValues();

        // set the format to sql date time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        valeurs.put("latin_name", plante.getLatin_name());
        valeurs.put("usuel_name", plante.getUsuel_name());
        valeurs.put("create_Time", dateFormat.format(plante.getCreate_Time()));
        valeurs.put("last_Watering_Time", dateFormat.format(plante.getLast_Watering_Time()));
        valeurs.put("watering_Frequency", plante.getWatering_Frequency());
        valeurs.put("room", plante.getRoom());
        valeurs.put("isWatered",plante.getIs_watringed());
        valeurs.put("next_Watering_Time",dateFormat.format(plante.getNext_Watering_Time()));

        return bd.update("plantes", valeurs, "id = " + plante.getId(), null);
    }

    /**
     * paser curseur to plante
     * @param curseur
     * @return
     */
    public Plante curseurToPlante(Cursor curseur) {

        Plante plante = new Plante();

        plante.setId(curseur.getInt(0));
        plante.setLatin_name(curseur.getString(1));
        plante.setUsuel_name(curseur.getString(2));

        String create_time_string_value = curseur.getString(3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date createTime=new Date();

        try {
            createTime =  dateFormat.parse(create_time_string_value);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        plante.setCreate_Time(createTime);


        String last_Watering_Time = curseur.getString(4);

        Date lastWateringTime=new Date();

        try {
            lastWateringTime =  dateFormat.parse(last_Watering_Time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        plante.setLast_Watering_Time(lastWateringTime);
        plante.setWatering_Frequency(curseur.getInt(5));
        plante.setRoom(curseur.getString(6));
        plante.setIs_watringed(curseur.getInt(7));

        String nextWateringTime = curseur.getString(8);
        Date next_WateringTime = new Date();
        try{
            next_WateringTime = dateFormat.parse(nextWateringTime);
        }catch (ParseException e){

        }

        plante.setNext_Watering_Time(next_WateringTime);
        return plante;
    }

    /**
     * supprime a plante
     * @param id plant id
     * @return
     */
    public int supprimer(int id) {
        return bd.delete("plantes", "id = " + id, null);
    }
    public Plante getPlante(int id) {

        Cursor curseur = bd.query("plantes", null, "id = " + id, null, null,	null, null);

        if (curseur.getCount() == 0)
            return null;


        curseur.moveToFirst();

        return curseurToPlante(curseur);
    }

    /**
     * get plante liste
     * @return
     */
    public ArrayList<Plante> getPlantes(){
        ArrayList<Plante> liste_plantes = new ArrayList<Plante>();

        Cursor curseur = bd.query("plantes", null, null, null, null, null, "id",null);

        if (curseur.getCount() == 0)
            return liste_plantes;


        curseur.moveToFirst();
        do {
            liste_plantes.add(curseurToPlante(curseur));
        } while (curseur.moveToNext());

        curseur.close();

        return liste_plantes;
    }

    /**
     * get BD cursor
     * @return
     */
    public Cursor getCursor(){
        Cursor curseur = bd.query("plantes", null, null, null, null, null, "id",null);
        return curseur;
    }

    /**
     * watering a plante, change the information of a plante
     * @param plante to plante needs to be wateringed
     * @return
     */
    public int watering_a_plante(Plante plante) {

        ContentValues valeurs = new ContentValues();

        // set the format to sql date time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


        valeurs.put("latin_name", plante.getLatin_name());
        valeurs.put("usuel_name", plante.getUsuel_name());
        valeurs.put("create_Time", dateFormat.format(plante.getCreate_Time()));
        valeurs.put("last_Watering_Time", dateFormat.format(new Date()));
        valeurs.put("watering_Frequency", plante.getWatering_Frequency());
        valeurs.put("room", plante.getRoom());
        valeurs.put("isWatered",1);


        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //cal.setTime(new Date());

        cal.add(Calendar.DATE, plante.getWatering_Frequency());
        Date next_watering_day = cal.getTime();
        valeurs.put("next_Watering_Time", dateFormat.format(next_watering_day));
        return bd.update("plantes", valeurs, "id = " + plante.getId(), null);
    }


}
