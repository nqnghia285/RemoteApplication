package com.nqnghia.remoteapplication.ui.machine_system;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MachineSystemViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MachineSystemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is machine system fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}