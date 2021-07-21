package com.example.myapplication.ui.data_mining;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Data_MiningViewModel  extends ViewModel {

    private MutableLiveData<String> mText;

    public Data_MiningViewModel () {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}