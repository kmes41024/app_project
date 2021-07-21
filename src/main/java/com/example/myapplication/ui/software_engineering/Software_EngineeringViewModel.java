package com.example.myapplication.ui.software_engineering;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Software_EngineeringViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Software_EngineeringViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}