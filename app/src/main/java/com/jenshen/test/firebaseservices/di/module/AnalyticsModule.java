package com.jenshen.test.firebaseservices.di.module;

import android.content.Context;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.jenshen.test.firebaseservices.manager.analytics.AnalyticsManager;
import com.jenshen.test.firebaseservices.manager.analytics.IAnalyticsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AnalyticsModule {

    @Singleton
    @Provides
    FirebaseAnalytics provideAnalytics(Context context) {
        return FirebaseAnalytics.getInstance(context);
    }

    @Singleton
    @Provides
    IAnalyticsManager provideAnalyticsManager(FirebaseAnalytics analytics) {
        return new AnalyticsManager(analytics);
    }
}
