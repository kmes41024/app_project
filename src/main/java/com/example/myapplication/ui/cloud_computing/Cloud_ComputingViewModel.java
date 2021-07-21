package com.example.myapplication.ui.cloud_computing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Cloud_ComputingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Cloud_ComputingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Cloud_Computing fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}