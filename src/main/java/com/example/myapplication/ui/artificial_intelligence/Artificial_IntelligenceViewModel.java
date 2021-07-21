package com.example.myapplication.ui.artificial_intelligence;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Artificial_IntelligenceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Artificial_IntelligenceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is artificial_intelligence  fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}