package com.example.courscesiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MorpionActivity extends AppCompatActivity {

    private boolean firstPlayer = true;
    private boolean start = false;
    private int nb = 0;
    private int nbWinX = 0;
    private int nbWinO = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morpion);
        setEventClickOnView();
        setEventClickStartButton();
    }

    private void setEventClickStartButton() {
        Button b = (Button) findViewById(R.id.start_morpion);
        b.setOnClickListener((v) -> startClick(v));
    }
    private void setEventClickOnView() {
        getAllTextView().forEach((e) -> e.setOnClickListener((v) -> onTextViewClick(v)));
    }

    private void changeStateButton(boolean state) {
        nb = 0;
        start = state;
        Button b = (Button) findViewById(R.id.start_morpion);
        b.setEnabled(!start);
    }

    private void startClick(View v) {
        changeStateButton(true);
        getAllTextView().forEach(e -> e.setText(""));
    }


    private void onTextViewClick(View v) {
        if(start) {
            TextView text = (TextView) v;
            if(text.getText() == "") {
                String s = (firstPlayer) ? "X" : "O";
                firstPlayer = !firstPlayer;
                text.setText(s);
                nb++;
                if(testWin(s)) {
                    if(s == "X")
                        nbWinX++;
                    else if(s == "O")
                        nbWinO++;
                    updateScore();
                    changeStateButton(false);
                }
                else if(nb == 9) {
                    changeStateButton(false);
                }
            }
        }
    }

    private void updateScore() {
        TextView scoreX = (TextView) findViewById(R.id.score_x);
        scoreX.setText(String.valueOf(nbWinX));
        TextView scoreO = (TextView) findViewById(R.id.score_o);
        scoreO.setText(String.valueOf(nbWinO));
    }

    private List<TextView> getAllTextView() {
        List<TextView> liste = new ArrayList<>();
        TableLayout layout = (TableLayout) findViewById(R.id.layout_morpion);
        for(int i=0; i < layout.getChildCount(); i++) {
            TableRow t = (TableRow) layout.getChildAt(i);
            for(int j=0; j < t.getChildCount(); j++) {
                TextView text = (TextView) t.getChildAt(j);
               liste.add(text);
            }
        }
        return liste;
    }

    private boolean testWin(String joueur) {
        return testWinX(joueur) || testWinDiag1(joueur) || testWinDiag2(joueur) || testWinY(joueur);
    }

    private boolean testWinX(String joueur) {
        //Vérification sur les lignes
        boolean win = false;
        TableLayout layout = (TableLayout) findViewById(R.id.layout_morpion);
        for(int i=0; i < layout.getChildCount(); i++) {
            TableRow t = (TableRow) layout.getChildAt(i);
            win = true;
            for(int j=0; j < t.getChildCount(); j++) {
                TextView text = (TextView) t.getChildAt(j);
                if(text.getText() != joueur)
                    win = false;
            }
            if(win)
                break;
        }
        return win;
    }

    private boolean testWinY(String joueur) {
        boolean win = false;

        for(int i=1; i <=3; i++) {
            List<String> val = new ArrayList<>();
            win = true;
            for(TextView t:getAllTextView()){
                String valTag = (String) t.getTag();
                String valI = String.valueOf(i);
                if(valTag.equals(valI)){
                    val.add(t.getText().toString());
                }
            }
            for(String s:val) {
                if(s != joueur) {
                    win = false;
                }
            }
        }
        return win;
    }

    private boolean testWinDiag1(String joueur) {
        boolean win = false;
        TableLayout layout = (TableLayout) findViewById(R.id.layout_morpion);
        for(int i=0; i < layout.getChildCount(); i++) {
            List<String> val = new ArrayList<>();
            win = true;
            TableRow t = (TableRow) layout.getChildAt(i);
            for(int j=0; j < t.getChildCount(); j++) {
                TextView text = (TextView) t.getChildAt(j);
                if(i == j)
                    val.add(text.getText().toString());
            }
            for(String s:val) {
                if(s != joueur) {
                    win = false;
                }
            }
        }
        return  win;
    }

    private boolean testWinDiag2(String joueur) {
        boolean win = false;
        TableLayout layout = (TableLayout) findViewById(R.id.layout_morpion);
        for(int i=0; i < layout.getChildCount(); i++) {
            List<String> val = new ArrayList<>();
            win = true;
            TableRow t = (TableRow) layout.getChildAt(i);
            for(int j=t.getChildCount()-1; j >= 0; j--) {
                TextView text = (TextView) t.getChildAt(j);
                if(i+j == 2)
                    val.add(text.getText().toString());
            }
            for(String s:val) {
                if(s != joueur) {
                    win = false;
                }
            }
        }
        return  win;
    }
}