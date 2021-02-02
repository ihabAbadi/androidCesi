package com.example.courscesiandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        ((TextView)findViewById(R.id.display_nom)).setText(nom);
        (findViewById(R.id.go_back)).setOnClickListener((v)-> {
            setResult(1);
            finish();
        });
    }
}
