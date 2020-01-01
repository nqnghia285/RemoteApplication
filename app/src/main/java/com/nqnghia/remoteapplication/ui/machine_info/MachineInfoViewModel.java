package com.nqnghia.remoteapplication.ui.machine_info;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MachineInfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MachineInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is machine info fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}