package com.example.courscesiandroid.viewHolders;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.courscesiandroid.R;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    public TextView getTxtFirstName() {
        return txtFirstName;
    }

    public void setTxtFirstName(TextView txtFirstName) {
        this.txtFirstName = txtFirstName;
    }

    public TextView getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(TextView txtLastName) {
        this.txtLastName = txtLastName;
    }

    private TextView txtFirstName;
    private TextView txtLastName;
    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        txtFirstName = (TextView) itemView.findViewById(R.id.contact_firstName);
        txtLastName = (TextView) itemView.findViewById(R.id.contact_lastName);
    }
}
