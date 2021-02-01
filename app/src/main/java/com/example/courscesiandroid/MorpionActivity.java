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
                if(nb == 9) {
                    changeStateButton(false);
                }
            }
        }
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
        return false;
    }

}