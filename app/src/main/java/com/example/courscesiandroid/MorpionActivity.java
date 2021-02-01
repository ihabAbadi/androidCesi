package com.example.courscesiandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MorpionActivity extends AppCompatActivity {

    private boolean firstPlayer = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morpion);
        setEventClickOnView();
    }

    private void setEventClickOnView() {
        TableLayout layout = (TableLayout) findViewById(R.id.layout_morpion);
        for(int i=0; i < layout.getChildCount(); i++) {
            TableRow t = (TableRow) layout.getChildAt(i);
            for(int j=0; j < t.getChildCount(); j++) {
                TextView text = (TextView) t.getChildAt(j);
                text.setOnClickListener((v)-> onTextViewClick(v));
            }
        }
    }

    private void onTextViewClick(View v) {
        TextView text = (TextView) v;
        if(text.getText() == "") {
            String s = (firstPlayer) ? "X" : "O";
            firstPlayer = !firstPlayer;
            text.setText(s);
        }
    }
}