package com.arrosage.chengxiaojun.arrosageplante.Controller;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arrosage.chengxiaojun.arrosageplante.Model.Plante;
import com.arrosage.chengxiaojun.arrosageplante.Outil.WateringOutil;
import com.arrosage.chengxiaojun.arrosageplante.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CHENG Xiaojun on 26/11/14.
 */
public class MySimpleAdapter extends BaseAdapter{
    private Context mContext;
    Cursor cursor;
    WateringOutil outil;
    private ArrayList<Plante> plantes;

    public MySimpleAdapter(Context context,Cursor cur, ArrayList<Plante> plantes_list)
    {
        super();
        mContext=context;
        cursor=cur;
        outil = new WateringOutil();
        plantes = new ArrayList<Plante>();
        plantes = plantes_list;
    }


    public int getCount()
    {
        // return the number of records in cursor
        return cursor.getCount();
    }

    // getView method is called for each item of ListView
    public View getView(int position,  View view, ViewGroup parent)
    {
        // inflate the layout for each item of listView
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.cell, null);

        // move the cursor to required position
        cursor.moveToPosition(position);

        // fetch the sender latin_name and usuel_name from cursor
        String latin_name=cursor.getString(cursor.getColumnIndex("latin_name"));
        String usuel_name=cursor.getString(cursor.getColumnIndex("usuel_name"));

        // get the reference of textViews and ImageView
        TextView textViewFirstLine=(TextView)view.findViewById(R.id.firstLine);
        //TextView textViewSecondLine=(TextView)view.findViewById(R.id.secondLine);
        ImageView imageView = (ImageView)view.findViewById(R.id.icon);

        textViewFirstLine.setText(latin_name);

        int this_plante_status;
        Plante this_plante = plantes.get(position);
        this_plante_status = outil.getWateringStatus(this_plante);
        Log.i("activity","positon : "+ position + "  status: "+this_plante_status );


        Log.i("activity","plante last watring time  : "+ date_to_string(this_plante.getLast_Watering_Time()));


        switch (this_plante_status){
            case 1:
                imageView.setImageResource(R.drawable.yes);
                break;
            case 2:
                imageView.setImageResource(R.drawable.attention);
                break;
            case 0:
                imageView.setImageResource(R.drawable.no);
                break;
            default:
                imageView.setImageResource(R.drawable.no);
                break;
        }


        //textViewSecondLine.setText(usuel_name);
        //textViewSecondLine.setText("asdasd");

        return view;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public String date_to_string(Date date){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");


// Using DateFormat format method we can create a string
// representation of a date with the defined format.
        String reportDate = df.format(date);

// Print what date is today!
      return reportDate;
    }
}
