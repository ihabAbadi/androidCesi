package com.example.courscesiandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        (findViewById(R.id.go_to_game)).setOnClickListener((v) -> {
            String nom = ((EditText)findViewById(R.id.edit_nom)).getText().toString();
            Intent intent = new Intent(this,GameActivity.class);
            intent.putExtra("nom", nom);
//            startActivity(intent);
            startActivityForResult(intent, 3);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3) {
            if(resultCode == 1) {
                String scoreComputer = data.getStringExtra("scoreComputer");
                String playerComputer = data.getStringExtra("scorePlayer");
                ((TextView)findViewById(R.id.home_score_computer)).setText(scoreComputer);
                ((TextView)findViewById(R.id.home_score_player)).setText(playerComputer);
            }
        }
    }
}