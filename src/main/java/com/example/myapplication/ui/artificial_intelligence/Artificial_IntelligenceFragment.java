package com.example.myapplication.ui.artificial_intelligence;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DetailActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.Post;
import com.example.myapplication.PostExisted;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Artificial_IntelligenceFragment extends Fragment {

    private  Artificial_IntelligenceViewModel  artificial_intelligenceViewModel;
    private RecyclerView recycler_view;
    private Button btnAdd;
    private MyAdapter adapter;

    private ArrayList<Post> mData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        artificial_intelligenceViewModel =
                ViewModelProviders.of(this).get(Artificial_IntelligenceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_artificial_intelligence, container, false);

        Resources res = getResources();
        String[] title = getResources().getStringArray(R.array.title);
        String[] start = res.getStringArray(R.array.startdate);
        String[] end = res.getStringArray(R.array.enddate);
        String[] place = res.getStringArray(R.array.place);
        String[] sub = res.getStringArray(R.array.subdeadline);
        String[] noti = res.getStringArray(R.array.notificationdue);
        String[] Final = res.getStringArray(R.array.finalVersiondue);
        String[] c1 = res.getStringArray(R.array.category1);
        String[] c2 = res.getStringArray(R.array.category2);
        String[] c3 = res.getStringArray(R.array.category3);
        String[] link = res.getStringArray(R.array.link);
        String[] icon = res.getStringArray(R.array.icon);

        PostExisted posts = new PostExisted(title, start, end, place, sub, noti, Final, c1, c2, c3, link, icon, "Artificial Intelligence");
        mData = posts.getself();
//

        return root;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 連結元件
        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view);


        // 設置RecyclerView為列表型態
        recycler_view.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // 設置格線

        // 將資料交給adapter
        adapter = new MyAdapter(mData);
////
//        // 設置adapter給recycler_view
        recycler_view.setAdapter(adapter);



    }


}