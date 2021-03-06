package com.arrosage.chengxiaojun.arrosageplante.Controller;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arrosage.chengxiaojun.arrosageplante.Model.BD;
import com.arrosage.chengxiaojun.arrosageplante.Model.Plante;
import com.arrosage.chengxiaojun.arrosageplante.R;

import java.util.Calendar;
import java.util.Date;

public class PlanteDetailInformationActivity extends ActionBarActivity {
    /**
     * plante entity for this screen
     */
    private Plante plante;
    /**
     * all the editText variable
     */
    private EditText nom_usuel_et, nom_latin_et, frequency_et, room_et;
    private TextView status_tv;
    private Button save_bt, delete_bt,cancel_bt;
    /**
     * BD entity
     */
    private BD bd;

    /**
     * whether is create a new plante or update the information of the plante
     */
    private boolean is_create_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantedetailinformtaion);

        plante = new Plante();
        nom_usuel_et = (EditText) findViewById(R.id.nom_usuelEditText);
        nom_latin_et = (EditText) findViewById(R.id.nom_latinEditText);
        frequency_et = (EditText) findViewById(R.id.frequencyEditText);
        room_et = (EditText) findViewById(R.id.roomeditText);
        status_tv = (TextView) findViewById(R.id.statusTextView);
        save_bt = (Button)findViewById(R.id.saveButton);
        cancel_bt = (Button)findViewById(R.id.cancelbutton);
        delete_bt = (Button)findViewById(R.id.deletebutton);


        delete_bt.setVisibility(View.INVISIBLE);

        bd = new BD(this);

    }

    protected void onStart() {
        super.onStart();
        Bundle donnees = getIntent().getExtras();

        //if we get an id value from previous activity, we would display the information, otherwise we display the create plante page
        if (donnees != null) {
            plante = bd.getPlante(donnees.getInt("id"));
            if (plante != null) {
                nom_usuel_et.setText(plante.getUsuel_name());
                nom_latin_et.setText(plante.getLatin_name());
                frequency_et.setText(Integer.toString(plante.getWatering_Frequency()));
                room_et.setText(plante.getRoom());
            }
            is_create_mode = false;
            status_tv.setText("Mise à jours information");
            delete_bt.setVisibility(View.VISIBLE);

        } else {
            is_create_mode = true;
            status_tv.setText("Création de une plante");

        }


    }

    /**
     * create or update action action, when we click on SAVE button
     *
     * @param view
     */
    public void save(View view) {

        plante.setCreate_Time(new Date());

        plante.setUsuel_name(nom_usuel_et.getText().toString());
        plante.setLatin_name(nom_latin_et.getText().toString());
        /**
         * if frequency is not a numeric
         */
        if(!isNumeric(frequency_et.getText().toString())){
            Toast.makeText(getApplicationContext(), "Votre frequencé n'est pas un nombre",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         * if frequency is smaller then 1
         */
        if(Integer.parseInt(frequency_et.getText().toString()) < 1){
            Toast.makeText(getApplicationContext(), "Votre frequencé est moins que 1",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        plante.setWatering_Frequency(Integer.parseInt(frequency_et.getText().toString()));
        plante.setRoom(room_et.getText().toString());




        if (is_create_mode) {

            plante.setLast_Watering_Time(new Date());

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            //cal.setTime(new Date());

            cal.add(Calendar.DATE, plante.getWatering_Frequency());
            Date next_watering_day = cal.getTime();

            plante.setNext_Watering_Time(next_watering_day);
            plante.setIs_watringed(1);
            bd.ajouter(plante);
            Toast.makeText(getApplicationContext(), "Vous avez creé une plante",
                    Toast.LENGTH_SHORT).show();

        } else {

            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            //cal.setTime(new Date());

            cal.add(Calendar.DATE, plante.getWatering_Frequency());
            Date next_watering_day = cal.getTime();

            plante.setNext_Watering_Time(next_watering_day);

            bd.miseAJour(plante);
            Toast.makeText(getApplicationContext(), "Vous avez mise à jour l'information sur "+nom_usuel_et.getText().toString(),
                    Toast.LENGTH_SHORT).show();
        }
        /**
         * end this activity
         */
        finish();

    }

    public void delete(View view){
        bd.supprimer(plante.getId());
        Toast.makeText(getApplicationContext(), "Vous avez supprimé le plante  "+nom_usuel_et.getText().toString(),
                Toast.LENGTH_SHORT).show();
        finish();
    }
    public void cancel(View view){
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

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
