package com.example.familyshopping;

import android.app.Application;

import com.firebase.client.Firebase;
import com.firebase.client.Logger;

/**
 * Includes one-time initialization of Farebase
 */

public class FamilyShoppingApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

        Firebase.getDefaultConfig().setLogLevel(Logger.Level.DEBUG);
    }
}
