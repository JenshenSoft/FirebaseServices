package com.jenshen.test.firebaseservices.di.component;

import com.jenshen.test.firebaseservices.di.module.AnalyticsModule;
import com.jenshen.test.firebaseservices.di.module.AppModule;
import com.jenshen.test.firebaseservices.di.module.FirebaseRemoteConfigModule;
import com.jenshen.test.firebaseservices.di.module.ReportsModule;
import com.jenshen.test.firebaseservices.ui.ConfigActivity;
import com.jenshen.test.firebaseservices.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, AnalyticsModule.class, ReportsModule.class, FirebaseRemoteConfigModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    void inject(ConfigActivity configActivity);
}
