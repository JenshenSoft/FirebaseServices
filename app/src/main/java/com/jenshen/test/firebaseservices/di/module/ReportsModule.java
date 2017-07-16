package com.jenshen.test.firebaseservices.di.module;

import com.jenshen.test.firebaseservices.manager.reports.IReportsManager;
import com.jenshen.test.firebaseservices.manager.reports.ReportsManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ReportsModule {


    @Singleton
    @Provides
    IReportsManager provideReportsManager() {
        return new ReportsManager();
    }
}
