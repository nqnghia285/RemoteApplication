package com.nqnghia.remoteapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class LocalService extends Service {

    private final LocalBinder mBinder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {
        //TODO
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //TODO
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //TODO
    }
}
