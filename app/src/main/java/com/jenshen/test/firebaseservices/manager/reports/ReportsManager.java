package com.jenshen.test.firebaseservices.manager.reports;


import com.google.firebase.crash.FirebaseCrash;

public class ReportsManager implements IReportsManager {

    @Override
    public void report(Exception e) {
        FirebaseCrash.report(e);
    }

    @Override
    public void log(String message) {
        FirebaseCrash.log(message);
    }
}
