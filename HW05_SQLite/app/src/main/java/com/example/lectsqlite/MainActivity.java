package com.example.lectsqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // private Button btnShow, btnAdd;
    private DBManager dbManager;

    public final Context ctx = this;
    public Intent showAllIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager= new DBManager(ctx);

        // btnShow = (Button) findViewById(R.id.showAll);
        // btnAdd = (Button) findViewById(R.id.add60Items);
    }

    public void add60Items(View v) {
        dbManager.add60Contacts();

        Toast.makeText(ctx, "New 60 contacts added!", Toast.LENGTH_LONG).show();
    }

    public void showAllItems(View v) {
        showAllIntent = new Intent(MainActivity.this, ShowAllActivity.class);

        startActivity(showAllIntent);
    }
}
