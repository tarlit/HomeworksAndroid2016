package com.example.lectsqlite;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Contacts> mAdapterContacts;

    public class ViewHolder extends RecyclerView.ViewHolder {

        int position;
        TextView idText;
        TextView nameText;
        TextView emailText;

        public ViewHolder(View itemView) {
            super(itemView);

            idText = (TextView) itemView.findViewById(R.id.idText);
            nameText = (TextView) itemView.findViewById(R.id.nameText);
            emailText = (TextView) itemView.findViewById(R.id.emailText);
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public Adapter(ArrayList<Contacts> allContacts) {
        this.mAdapterContacts = allContacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (holder != null) {
            Contacts contact = this.mAdapterContacts.get(position);

            holder.idText.setText(String.valueOf(contact.get_id()));
            holder.nameText.setText((contact.get_name()));
            holder.emailText.setText(contact.get_email());

            holder.setPosition(position);
        }
    }

    @Override
    public int getItemCount() {
        return this.mAdapterContacts.size();
    }


}
