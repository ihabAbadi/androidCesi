package com.example.courscesiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.courscesiandroid.services.ContactService;

public class FormContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_contact);
    }


    public void confirmContact(View v) {
        String fistName = ((TextView)findViewById(R.id.form_firstname)).getText().toString();
        String lastname = ((TextView)findViewById(R.id.form_lastname)).getText().toString();
        String phone = ((TextView)findViewById(R.id.form_phone)).getText().toString();
        String mail = ((TextView)findViewById(R.id.form_mail)).getText().toString();
        ContactService.getInstance().addContact(fistName, lastname, phone, mail);
        setResult(1);
        finish();
    }
}