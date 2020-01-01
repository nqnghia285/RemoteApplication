package com.nqnghia.remoteapplication.ui.humidity_temperature_chart;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class HumidityTemperatureViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HumidityTemperatureViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is machine info fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}