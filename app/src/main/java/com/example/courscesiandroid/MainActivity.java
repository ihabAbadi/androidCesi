package com.example.courscesiandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ConstraintLayout c = new ConstraintLayout(this);
        /*Ajout largeur et hauteru du layout*/
        /*c.setMaxWidth();*/
        /*TextView text = new TextView(this);
        text.setText("Contenu du text");
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        c.addView(text, params);*/
        /*TextView text = new TextView(this);
        text.setText("Contenu Ajouté");

        RelativeLayout layout = findViewById(R.id.main_activity_relative_layout);
        layout.addView(text, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        Button b1 = (Button) findViewById(R.id.b1);*/
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                b.setText(b.getText()+" Added after click");
            }
        });*/
       /* b1.setOnClickListener((v) -> {
            Button b = (Button) v;
            b.setText(b.getText()+" Added after click");
        });*/
        setContentView(R.layout.activity_main);

    }


}