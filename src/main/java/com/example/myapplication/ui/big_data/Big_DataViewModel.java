package com.example.myapplication.ui.big_data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Big_DataViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Big_DataViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is Business fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}