package com.example.courscesiandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.courscesiandroid.services.UserService;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getPreferenceLogin()){
           redirect();
        }
        setContentView(R.layout.activity_login);
    }

    public void connect(View v) {
        String login = ((EditText)findViewById(R.id.login)).getText().toString();
        String passsword = ((EditText)findViewById(R.id.password)).getText().toString();
        if(UserService.getInstance().login(login, passsword)){
            savePreference();
            redirect();
        }
        else {
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setMessage("Erreur connexion");
            alert.show();
        }
    }

    private void savePreference() {
        //Stockage des données dans un objet de type sharedPreferences
        SharedPreferences shared = getSharedPreferences("ourApplication", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putBoolean("login", true);
        editor.commit();
    }

    private boolean getPreferenceLogin() {
        SharedPreferences shared = getSharedPreferences("ourApplication", MODE_PRIVATE);
        Boolean test = shared.getBoolean("login", false);
        return test;
    }

    private void redirect() {
        Intent i = new Intent(this, ContactsActivity.class);
        startActivity(i);
        finish();
    }
}