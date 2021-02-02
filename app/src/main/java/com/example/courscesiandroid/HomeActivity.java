package com.example.courscesiandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        (findViewById(R.id.go_to_morpion)).setOnClickListener((v) -> {
         //Navigation vers morpion
            Intent intent = new Intent(this,MorpionActivity.class);
            //startActivity(intent);
            startActivityForResult(intent, 1);
            //finish();
        });
        (findViewById(R.id.go_to_second)).setOnClickListener((v) -> {
            String nom = ((EditText)findViewById(R.id.edit_nom)).getText().toString();
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("nom", nom);
//            startActivity(intent);
            startActivityForResult(intent, 2);
            //finish();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}