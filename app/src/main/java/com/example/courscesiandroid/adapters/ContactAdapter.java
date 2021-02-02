package com.example.courscesiandroid.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courscesiandroid.R;
import com.example.courscesiandroid.models.Contact;
import com.example.courscesiandroid.viewHolders.ContactViewHolder;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    List<Contact> contacts;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_element,parent, false);
        return new ContactViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact p = contacts.get(position);
        holder.getTxtFirstName().setText(p.getFirstName());
        holder.getTxtLastName().setText(p.getLastName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
