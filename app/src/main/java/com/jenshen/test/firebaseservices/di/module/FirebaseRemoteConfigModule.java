package com.jenshen.test.firebaseservices.di.module;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.jenshen.test.firebaseservices.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseRemoteConfigModule {

    @Singleton
    @Provides
    FirebaseRemoteConfig provideFirebaseRemoteConfig(FirebaseRemoteConfigSettings settings) {
        FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
        instance.setConfigSettings(settings);
        instance.setDefaults(R.xml.remote_config_defaults);
        return instance;
    }

    @Singleton
    @Provides
    FirebaseRemoteConfigSettings provideFirebaseRemoteConfigSettings() {
        return new FirebaseRemoteConfigSettings.Builder()
                .build();
    }
}
