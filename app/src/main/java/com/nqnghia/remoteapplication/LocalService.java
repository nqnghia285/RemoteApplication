package com.nqnghia.remoteapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Ack;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class LocalService extends Service {
    private static final String TAG = "LocalService";
    private Socket mSocket;

    private final LocalBinder mBinder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public class LocalBinder extends Binder {

        public void initSocket(String ip, int port) {
            try {
                mSocket = IO.socket("http://" + ip +":" + port);
                new Thread(() -> mSocket.connect()).start();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        public void on(String event, Emitter.Listener listener) {
            if (mSocket != null) {
                mSocket.on(event, listener);
            } else {
                Log.w(TAG, "on: mSocket is null");
            }
        }

        public void off() {
            if (mSocket != null) {
                mSocket.off();
            } else {
                Log.w(TAG, "on: mSocket is null");
            }
        }

        public void off(String event) {
            if (mSocket != null) {
                mSocket.off(event);
            } else {
                Log.w(TAG, "on: mSocket is null");
            }
        }

        public void off(String event, Emitter.Listener listener) {
            if (mSocket != null) {
                mSocket.off(event, listener);
            } else {
                Log.w(TAG, "on: mSocket is null");
            }
        }

        public void emit(String event, Object... args) {
            if (mSocket != null) {
                mSocket.emit(event, args);
            } else {
                Log.w(TAG, "on: mSocket is null");
            }
        }

        public void emit(String event, Object[] args, Ack ack) {
            if (mSocket != null) {
                mSocket.emit(event, args, ack);
            } else {
                Log.w(TAG, "on: mSocket is null");
            }
        }

        public void close() {
            if (mSocket != null) {
                mSocket.close();
            } else {
                Log.w(TAG, "on: mSocket is null");
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //TODO
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
