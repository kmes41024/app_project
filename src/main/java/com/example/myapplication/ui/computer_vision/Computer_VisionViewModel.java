package com.example.myapplication.ui.computer_vision;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Computer_VisionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Computer_VisionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}