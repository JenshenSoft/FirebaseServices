package com.jenshen.test.firebaseservices.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jenshen.test.firebaseservices.R;
import com.jenshen.test.firebaseservices.app.App;
import com.jenshen.test.firebaseservices.manager.analytics.IAnalyticsManager;
import com.jenshen.test.firebaseservices.manager.reports.IReportsManager;
import com.jenshen.test.firebaseservices.util.LogHelper;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    IAnalyticsManager analyticsManager;
    @Inject
    IReportsManager reportsManager;
    @Inject
    LogHelper logHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getAppComponent().inject(this);

        reportsManager.log("Additional information here....");
        findViewById(R.id.logEvent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                analyticsManager.logEvent("Press Button Event", "User pressed on the button");
            }
        });
        findViewById(R.id.nonFatalError).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logHelper.e("My first Android non-fatal error");
            }
        });
        findViewById(R.id.killApp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throw new RuntimeException("OMG crash....again");
            }
        });
    }
}
