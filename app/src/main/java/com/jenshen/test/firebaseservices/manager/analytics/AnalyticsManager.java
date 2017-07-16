package com.jenshen.test.firebaseservices.manager.analytics;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class AnalyticsManager implements IAnalyticsManager {

    private final FirebaseAnalytics firebaseAnalytics;

    public AnalyticsManager(FirebaseAnalytics firebaseAnalytics) {
        this.firebaseAnalytics = firebaseAnalytics;
    }

    @Override
    public void logEvent(String id, String name) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
