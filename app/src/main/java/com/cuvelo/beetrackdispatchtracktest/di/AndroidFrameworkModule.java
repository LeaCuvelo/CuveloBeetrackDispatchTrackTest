package com.cuvelo.beetrackdispatchtracktest.di;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AndroidFrameworkModule {

    private final String BTC_SHARED_PREFERENCES_NAME = "BTC_ADDRESS_SHARED_PREFERENCE";

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(@ApplicationContext  Context context){
        return context.getSharedPreferences(BTC_SHARED_PREFERENCES_NAME, MODE_PRIVATE);
    }

}
