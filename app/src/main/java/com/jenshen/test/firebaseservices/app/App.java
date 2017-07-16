package com.jenshen.test.firebaseservices.app;

import android.app.Application;

import com.jenshen.test.firebaseservices.di.component.AppComponent;
import com.jenshen.test.firebaseservices.di.component.DaggerAppComponent;
import com.jenshen.test.firebaseservices.di.module.AppModule;


public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
