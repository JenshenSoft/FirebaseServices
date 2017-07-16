package com.jenshen.test.firebaseservices.util;

import android.util.Log;

import com.jenshen.test.firebaseservices.manager.reports.IReportsManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LogHelper {

    private final IReportsManager reportsManager;

    @Inject
    public LogHelper(IReportsManager reportsManager) {
        this.reportsManager = reportsManager;
    }

    public void d(String message) {
        Log.d("Firebase App", message);
    }

    public void e(String message) {
        reportsManager.report(new Exception("My first Android non-fatal error"));
        Log.e("Firebase App", message);
    }
}
