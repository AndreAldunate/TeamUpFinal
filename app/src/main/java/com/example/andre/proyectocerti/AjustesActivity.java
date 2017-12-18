package com.example.andre.proyectocerti;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class AjustesActivity extends AppCompatActivity {
    private Spinner spinner;
    private TextView escogerTextView;
    private CheckBox codCheckBox;
    private CheckBox fortniteCheckBox;
    private CheckBox overwatchCheckBox;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        context = this;
        escogerTextView = (TextView) findViewById(R.id.escogerTextView);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        escogerTextView.setText( " MOSTRAR: " + prefs.getString("MOSTRARID", "-----"));
        codCheckBox= (CheckBox) findViewById(R.id.codCheckBox);

        codCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(codCheckBox.isChecked()){
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("CODNOTIFICATIONS", "true");
                    editor.apply();
                }else{
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("CODNOTIFICATIONS", "false");
                    editor.apply();
                }
            }
        });
        fortniteCheckBox = (CheckBox) findViewById(R.id.fortniteCheckBox);
        fortniteCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fortniteCheckBox.isChecked()){
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("FORTNITENOTIFICATIONS", "true");
                    editor.apply();
                }else{
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("FORTNITENOTIFICATIONS", "false");
                    editor.apply();
                }
            }
        });
        overwatchCheckBox = (CheckBox) findViewById(R.id.overwatchCheckBox);
        overwatchCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(overwatchCheckBox.isChecked()){
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("OVERWATCHNOTIFICATIONS", "true");
                    editor.apply();
                }else{
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("OVERWATCHNOTIFICATIONS", "false");
                    editor.apply();
                }
            }
        });
        setCheckBoxes();
    }

    private void setCheckBoxes() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if(prefs.getString("CODNOTIFICATIONS", "-----").equals("true")){
            codCheckBox.setChecked(true);
        }else{
            codCheckBox.setChecked(false);
        }
        if(prefs.getString("FORTNITENOTIFICATIONS", "-----").equals("true")){
            fortniteCheckBox.setChecked(true);
        }else{
            fortniteCheckBox.setChecked(false);
        }
        if(prefs.getString("OVERWATCHNOTIFICATIONS", "-----").equals("true")){
            overwatchCheckBox.setChecked(true);
        }else{
            overwatchCheckBox.setChecked(false);
        }
    }
}

