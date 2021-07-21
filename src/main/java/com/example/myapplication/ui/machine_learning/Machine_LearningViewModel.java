package com.example.myapplication.ui.machine_learning;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Machine_LearningViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Machine_LearningViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}