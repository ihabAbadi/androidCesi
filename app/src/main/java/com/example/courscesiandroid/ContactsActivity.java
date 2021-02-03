package com.example.courscesiandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.courscesiandroid.adapters.ContactAdapter;
import com.example.courscesiandroid.services.ContactService;
import com.squareup.picasso.Picasso;

public class ContactsActivity extends AppCompatActivity {
    private RecyclerView ourRecyclerView;
    private RecyclerView.Adapter ourAdapter;
    private RecyclerView.LayoutManager ourLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        ourRecyclerView = (RecyclerView) findViewById(R.id.contacts_recycler);
        ourLayoutManager = new LinearLayoutManager(this);
        ourRecyclerView.setLayoutManager(ourLayoutManager);
        ourAdapter = new ContactAdapter(ContactService.getInstance().getContacts(), (v)-> {
            int id = Integer.parseInt(v.getTag().toString());
            Intent intent = new Intent(this, ContactActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        });
        ourRecyclerView.setAdapter(ourAdapter);

        //Stockage des données dans un objet de type sharedPreferences
        SharedPreferences shared = getSharedPreferences("ourApplication", MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString("test", "dataTest");
        editor.commit();

        //Récupérer une image par url et l'afficher
        Picasso.get().load("https://picsum.photos/200/300").into((ImageView)findViewById(R.id.image_contact));
    }


    public void sendToForm(View v) {
        Intent intent = new Intent(this,FormContactActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1) {
            /*ourAdapter = new ContactAdapter(ContactService.getInstance().getContacts());
            ourRecyclerView.setAdapter(ourAdapter);*/
            ourAdapter.notifyDataSetChanged();
        }
    }
}