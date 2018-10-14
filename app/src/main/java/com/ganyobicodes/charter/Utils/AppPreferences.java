package com.ganyobicodes.charter.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPreferences {

    Context context;
    SharedPreferences sharedPreferences;

    public AppPreferences(Context context, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }

    public boolean firstTimeUserCheck(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);


        return false;
    }


}
