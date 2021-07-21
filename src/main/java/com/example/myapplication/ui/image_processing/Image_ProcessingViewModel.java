package com.example.myapplication.ui.image_processing;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Image_ProcessingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Image_ProcessingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}