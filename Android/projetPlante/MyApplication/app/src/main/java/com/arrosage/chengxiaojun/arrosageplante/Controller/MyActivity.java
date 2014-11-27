package com.arrosage.chengxiaojun.arrosageplante.Controller;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.arrosage.chengxiaojun.arrosageplante.Model.BD;
import com.arrosage.chengxiaojun.arrosageplante.Model.Plante;
import com.arrosage.chengxiaojun.arrosageplante.R;

import java.util.ArrayList;


public class MyActivity extends ActionBarActivity {

    private BD bd;
    private ListView listView;
    private Cursor cursor;
    private MySimpleAdapter mySimpleAdapter;
    private ArrayList<Plante> planteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //ImageView image = (ImageView)findViewById(R.id.imageView);
        //image.setImageResource(R.drawable.yes);

        listView = (ListView)findViewById(R.id.listView);
        bd = new BD(this);
        planteList = new ArrayList<Plante>();


    }

    protected void onStart(){
        super.onStart();
        cursor = bd.getCursor();
        planteList = bd.getPlantes();
        mySimpleAdapter = new MySimpleAdapter(this,cursor,planteList);
        listView.setAdapter(mySimpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                Plante plante = planteList.get(position);
                start_plante_detail_information_Activity(plante);
            }

        });

    }

    public void start_plante_detail_information_Activity(Plante plante){
        Intent intention = new Intent(this,PlanteDetailInformationActivity.class );
        intention.putExtra("id", plante.getId());
        startActivity(intention);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
    public void create_plante(View view){
        startActivity(new Intent(this, PlanteDetailInformationActivity.class));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
