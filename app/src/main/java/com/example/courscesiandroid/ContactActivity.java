package com.example.courscesiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.courscesiandroid.models.Contact;
import com.example.courscesiandroid.services.ContactService;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        int id = getIntent().getIntExtra("id", 0);
        Contact contact = ContactService.getInstance().getContact(id);
        ((TextView)findViewById(R.id.contact_display_firstname)).setText(contact.getFirstName());
        ((TextView)findViewById(R.id.contact_display_lastname)).setText(contact.getLastName());
        ((TextView)findViewById(R.id.contact_display_phone)).setText(contact.getPhone());
        ((TextView)findViewById(R.id.contact_display_mail)).setText(contact.getMail());
        setTitle(contact.getFirstName());

        //Récupérer les données à partir d'un sharedPreferences
        SharedPreferences shared = getSharedPreferences("ourApplication", MODE_PRIVATE);
        String test = shared.getString("test", "");
    }
}