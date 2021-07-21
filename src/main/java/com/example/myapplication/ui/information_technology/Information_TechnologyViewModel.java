package com.example.myapplication.ui.information_technology;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Information_TechnologyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Information_TechnologyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}