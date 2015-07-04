package com.fin10.android.textdeliverer;

import android.app.Application;

public class TextDelivererApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.init("TextDeliverer");
    }
}
