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
import android.widget.Toast;

import com.arrosage.chengxiaojun.arrosageplante.Model.BD;
import com.arrosage.chengxiaojun.arrosageplante.Model.Plante;
import com.arrosage.chengxiaojun.arrosageplante.R;

import java.util.ArrayList;

/**
 * main activity
 */
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


        /**
         * long click listener
         */
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           int index, long arg3) {

                watring_a_plante(planteList.get(index));

                Toast.makeText(getApplicationContext(), "Vous avez arrosagé  " + planteList.get(index).getUsuel_name(),
                        Toast.LENGTH_SHORT).show();

                cursor = bd.getCursor();
                planteList = bd.getPlantes();
                /**
                 * call update screen information methode
                 */
                mySimpleAdapter.update_icon(cursor,planteList);

                /**
                 * overwrite old adapter
                 */
                listView.setAdapter(mySimpleAdapter);

                return true;
            }
        });

    }

    public void watring_a_plante(Plante plante){
        bd.watering_a_plante(plante);
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
