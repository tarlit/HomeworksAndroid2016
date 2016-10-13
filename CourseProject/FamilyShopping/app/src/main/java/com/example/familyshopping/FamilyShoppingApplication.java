package com.example.familyshopping;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Includes one-time initialization of Farebase
 */

public class FamilyShoppingApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
