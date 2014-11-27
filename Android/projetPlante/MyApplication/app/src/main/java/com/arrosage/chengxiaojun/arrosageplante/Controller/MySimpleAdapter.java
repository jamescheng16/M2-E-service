package com.arrosage.chengxiaojun.arrosageplante.Controller;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.arrosage.chengxiaojun.arrosageplante.R;

/**
 * Created by CHENG Xiaojun on 26/11/14.
 */
public class MySimpleAdapter extends BaseAdapter{
    private Context mContext;
    Cursor cursor;

    public MySimpleAdapter(Context context,Cursor cur)
    {
        super();
        mContext=context;
        cursor=cur;

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

        // get the reference of textViews
        TextView textViewFirstLine=(TextView)view.findViewById(R.id.firstLine);
        //TextView textViewSecondLine=(TextView)view.findViewById(R.id.secondLine);


        textViewFirstLine.setText(usuel_name);
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
}
