package com.nqnghia.remoteapplication.ui.device_sensor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class DeviceSensorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DeviceSensorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is devices and sensors fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}