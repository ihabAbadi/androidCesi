package com.example.courscesiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private int scorePlayer = 0;
    private int scoreComputer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ((TextView)findViewById(R.id.game_player)).setText(getIntent().getStringExtra("nom"));
        (findViewById(R.id.end_game)).setOnClickListener((v)-> {
            Intent intent = new Intent();
            intent.putExtra("scoreComputer", String.valueOf(scoreComputer));
            intent.putExtra("scorePlayer", String.valueOf(scorePlayer));
            setResult(1, intent);
            finish();
        });
    }

    public void playerChoice(View v) {
        String valTag = (String) v.getTag();
        int valGame = Integer.parseInt(valTag);
        int valComputer = computerChoice();
        ((TextView)findViewById(R.id.computer_choice)).setText(convertToStringVal(valComputer));
        ((TextView)findViewById(R.id.player_choice)).setText(convertToStringVal(valGame));
        testWin(valGame,valComputer);
    }

    private void testWin(int player, int computer) {
        if(player == 1) {
            if(computer == 2){
                scoreComputer++;
            }
            else if(computer == 3) {
                scorePlayer++;
            }
        }
        else if(player == 2) {
            if(computer == 1) {
                scorePlayer++;
            }
            else if(computer == 3) {
                scoreComputer++;
            }
        }
        else if(player == 3) {
            if(computer == 1) {
                scoreComputer++;
            }
            else if(computer == 2) {
                scorePlayer++;
            }
        }
        ((TextView)findViewById(R.id.computer_score)).setText(String.valueOf(scoreComputer));
        ((TextView)findViewById(R.id.player_score)).setText(String.valueOf(scorePlayer));
    }

    private int computerChoice() {
        return (int)((Math.random() * 3) + 1);
    }

    private String convertToStringVal(int val) {
        switch (val) {
            case 1:
                return "Pierre";

            case 2:
                return "Feuille";

            case 3:
                return "Ciseau";

            default:
                return null;

        }
    }
}