package com.example.myapplication.ui.computer_science;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Computer_ScienceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Computer_ScienceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}