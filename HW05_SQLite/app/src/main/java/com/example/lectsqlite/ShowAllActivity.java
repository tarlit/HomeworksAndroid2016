package com.example.lectsqlite;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ShowAllActivity extends AppCompatActivity {

    private RecyclerView allContactsView;
    private RecyclerView.LayoutManager layoutManager;

    private DBManager dbManager;
    private Adapter adapter;
    public final Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_contacts_layout);

        allContactsView = (RecyclerView) findViewById(R.id.allContacts);

        dbManager = new DBManager(ctx);
        adapter = new Adapter(dbManager.getAllContacts());
        layoutManager = new LinearLayoutManager(ctx);

        allContactsView.setLayoutManager(layoutManager);
        allContactsView.setAdapter(adapter);
    }
}
