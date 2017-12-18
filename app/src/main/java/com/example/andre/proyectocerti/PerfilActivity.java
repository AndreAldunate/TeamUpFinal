package com.example.andre.proyectocerti;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {

    private Context context;
    private TextView psTextView;
    private TextView xboxTextView;
    private TextView steamTextView;
    private ImageView fotoImageView;
    private Button actFotoButton;
    private Button actPsButton;
    private Button actContrasenatoButton;
    private Button actXboxButton;
    private Button actSteamButton;
    private EditText oldPEditText;
    private EditText newPEditText;
    private EditText psEditText;
    private EditText xboxPEditText;
    private EditText steamPEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        setContentView(R.layout.activity_perfil);
        psTextView = (TextView) findViewById(R.id.psidTextView);
        xboxTextView = (TextView)findViewById(R.id.xboxidTextView);
        steamTextView = (TextView)findViewById(R.id.steamidTextView);
        fotoImageView = (ImageView) findViewById(R.id.fotoImageView);
        actFotoButton = (Button) findViewById(R.id.cambiarFotoButton);
       actFotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload();
            }
        });
        actPsButton = (Button)findViewById(R.id.actPsButton);
        actPsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarPSid();
            }
        }) ;
        actXboxButton = (Button)findViewById(R.id.actXboxButton);
        actXboxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarXboxid();
            }
        });
        actSteamButton = (Button)findViewById(R.id.actSteamButton);
        actSteamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actualizarSteamid();
            }
        });
        actContrasenatoButton =(Button) findViewById(R.id.cambiarButton);
       actContrasenatoButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               actualizarContrasena();
           }
       });
        oldPEditText = (EditText) findViewById(R.id.oldEditText);
        newPEditText = (EditText)findViewById(R.id.newEditText);
        psEditText = (EditText)findViewById(R.id.psEditText);
        xboxPEditText = (EditText)findViewById(R.id.xboxEditText);
        steamPEditText =(EditText) findViewById(R.id.steamEditText);
        super.onCreate(savedInstanceState);
        showDataFromPreferences();

    }

    private void actualizarContrasena() {
    }

    private void actualizarSteamid() {
        String id = steamPEditText.getText().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("STEAMID",id);
        editor.apply();
        Toast.makeText(context,"Datos actualizados",Toast.LENGTH_SHORT).show();
    }

    private void actualizarXboxid() {
        String id = xboxPEditText.getText().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("XBOXID",id);
        editor.apply();
        Toast.makeText(context,"Datos actualizados",Toast.LENGTH_SHORT).show();
    }

    private void actualizarPSid() {
        String id = psEditText.getText().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("PSID",id);
        editor.apply();
        Toast.makeText(context,"Datos actualizados",Toast.LENGTH_SHORT).show();
    }

    private void upload() {

    }

    private void showDataFromPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

            psTextView.setText(prefs.getString("PSID", "-----"));
            xboxTextView.setText(prefs.getString("XBOXID", "-----"));
            steamTextView.setText(prefs.getString("STEAMID", "-----"));

    }
}
