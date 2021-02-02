package com.example.courscesiandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DemoRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView ourRecyclerView;
    private RecyclerView.Adapter ourAdapter;
    private RecyclerView.LayoutManager ourLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_recycler_view);
        ourRecyclerView = (RecyclerView) findViewById(R.id.demo_recycler);
        ourLayoutManager = new LinearLayoutManager(this);
        ourRecyclerView.setLayoutManager(ourLayoutManager);
        List<Personne> liste = new ArrayList<>();
        liste.add(new Personne("toto", "tata"));
        liste.add(new Personne("minet", "titi"));
        ourAdapter = new PersonneAdapter(liste, (v) -> {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Click personne");
            alertDialog.setMessage("Personne n°" +  String.valueOf(v.getTag()));
            alertDialog.show();
        });
        ourRecyclerView.setAdapter(ourAdapter);
    }
}


class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.PersonneViewHolder> {
    private List<Personne> listePersonnes;

    private View.OnClickListener clickButton;

    PersonneAdapter(List<Personne> listePersonnes, View.OnClickListener click) {
        this.listePersonnes = listePersonnes;
        this.clickButton = click;
    }

    @NonNull
    @Override
    public PersonneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.personne_element,parent, false);
        return new PersonneViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonneViewHolder holder, int position) {
        Personne p = listePersonnes.get(position);
        holder.txtNom.setText(p.nom);
        holder.txtPrenom.setText(p.prenom);
        holder.btnPersonne.setTag(position);
        holder.btnPersonne.setOnClickListener(clickButton);
    }

    @Override
    public int getItemCount() {
        return listePersonnes.size();
    }

    static class PersonneViewHolder extends RecyclerView.ViewHolder {
        protected TextView txtNom;
        protected TextView txtPrenom;
        protected Button btnPersonne;
        public PersonneViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNom = (TextView) itemView.findViewById(R.id.personne_nom);
            txtPrenom = (TextView) itemView.findViewById(R.id.personne_prenom);
            btnPersonne = (Button) itemView.findViewById(R.id.personne_button);
        }
    }
}

class Personne {
    public String nom;
    public String prenom;

    public Personne(String n, String p) {
        nom = n;
        prenom = p;
    }
}