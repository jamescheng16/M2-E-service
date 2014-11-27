package com.arrosage.chengxiaojun.arrosageplante.Controller;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.arrosage.chengxiaojun.arrosageplante.Model.BD;
import com.arrosage.chengxiaojun.arrosageplante.Model.Plante;
import com.arrosage.chengxiaojun.arrosageplante.R;

import java.util.Date;

public class PlanteDetailInformationActivity extends ActionBarActivity {
    /**
     * plante entity for this screen
     */
    private Plante plante;
    /**
     * all the editText variable
     */
    private EditText nom_usuel_et, nom_latin_et, frequency_et,room_et;
    /**
     * BD entity
     */
    private BD bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantedetailinformtaion);

        plante = new Plante();
        nom_usuel_et = (EditText)findViewById(R.id.nom_usuelEditText);
        nom_latin_et = (EditText)findViewById(R.id.nom_latinEditText);
        frequency_et = (EditText) findViewById(R.id.frequencyEditText);
        room_et = (EditText) findViewById(R.id.roomeditText);
        bd = new BD(this);

    }
    protected void onStart(){
        super.onStart();
        Bundle donnees = getIntent().getExtras();

        //if we get an id value from previous activity, we would display the information, otherwise we display the create plante page
        if(donnees != null){
            plante = bd.getPlante(donnees.getInt("id"));
            if(plante != null){
                nom_usuel_et.setText(plante.getUsuel_name());
                nom_latin_et.setText(plante.getLatin_name());
                frequency_et.setText(Integer.toString(plante.getWatering_Frequency()));
                room_et.setText(plante.getRoom());
            }
        }
    }

    /**
     * Save action, when we click on SAVE button
     * @param view
     */
    public void save(View view) {

            plante.setCreate_Time(new Date());
            plante.setLast_Watering_Time(new Date());
            plante.setUsuel_name(nom_usuel_et.getText().toString());
            plante.setLatin_name(nom_latin_et.getText().toString());
            plante.setWatering_Frequency(Integer.parseInt(frequency_et.getText().toString()));
            plante.setRoom(room_et.getText().toString());
            bd.ajouter(plante);
        /**
         * end this activity
         */
            finish();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_aplante, menu);
        return true;
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

    protected void onDestroy() {
        bd.fermeture();
        super.onDestroy();
    }
}
