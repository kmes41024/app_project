package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ui.login.user_author;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Post> mData;

    public MyAdapter(List<Post> data) {

        mData = data;
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // 宣告元件
        private ImageButton btnFavorite;
        private ImageButton btnShare;
        private TextView txtTitle;
        private TextView txtStartdata;
        private TextView txtEnddate;
        private TextView txtMethod;
        private TextView txtState;
        private TextView txtSubdeadline;
        private TextView txtCategory1;
        private TextView txtCategory2;
        private TextView txtCategory3;
        private ImageView iconView;

        ViewHolder(View itemView) {
            super(itemView);
            btnFavorite = (ImageButton) itemView.findViewById(R.id.btn_favorite);
            btnShare = (ImageButton) itemView.findViewById(R.id.btn_share);
            txtTitle = (TextView) itemView.findViewById(R.id.item_title);
            txtStartdata = (TextView) itemView.findViewById(R.id.item_starttime);
            txtEnddate = (TextView) itemView.findViewById(R.id.item_endtime);
            txtMethod = (TextView) itemView.findViewById(R.id.item_method);
            txtSubdeadline = (TextView) itemView.findViewById(R.id.item_subdeadline);
            txtCategory1 = (TextView) itemView.findViewById(R.id.c1);
            txtCategory2 = (TextView) itemView.findViewById(R.id.c2);
            txtCategory3 = (TextView) itemView.findViewById(R.id.c3);
            iconView = (ImageView) itemView.findViewById(R.id.image);

            btnFavorite.setTag(R.drawable.ic_favorite);

            // 點擊項目時
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "click " +getAdapterPosition(),Toast.LENGTH_SHORT).show();



                }
            });
            btnFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if ((Integer)btnFavorite.getTag() == R.drawable.ic_favorite_chosen){
                        btnFavorite.setImageResource(R.drawable.ic_favorite);
                        btnFavorite.setTag(R.drawable.ic_favorite);
						
                        Toast.makeText(view.getContext(),
                                "Remove " + txtTitle.getText() + " from your favorite !!", Toast.LENGTH_SHORT).show();
                    }
                    else{

                        btnFavorite.setImageResource(R.drawable.ic_favorite_chosen);
                        btnFavorite.setTag(R.drawable.ic_favorite_chosen);

                        Toast.makeText(view.getContext(),
						"Add " + txtTitle.getText() + " to your favorite !!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            btnShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            "click share" +getAdapterPosition(),Toast.LENGTH_SHORT).show();
                }
			}
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 設置txtItem要顯示的內容
        holder.txtTitle.setText(mData.get(position).getTitle());
        holder.txtStartdata.setText(mData.get(position).getStartdata());
        holder.txtEnddate.setText(mData.get(position).getEnddate());
        holder.txtMethod.setText(mData.get(position).getPlace());
        holder.txtSubdeadline.setText(mData.get(position).getSubdeadline());

        if(mData.get(position).getIcon().equals("1"))
            holder.iconView.setImageResource(R.drawable.img1);
        else if(mData.get(position).getIcon().equals("2"))
            holder.iconView.setImageResource(R.drawable.img2);
        else if(mData.get(position).getIcon().equals("3"))
            holder.iconView.setImageResource(R.drawable.img3);
        else if(mData.get(position).getIcon().equals("4"))
            holder.iconView.setImageResource(R.drawable.img4);
        else if(mData.get(position).getIcon().equals("5"))
            holder.iconView.setImageResource(R.drawable.img5);
        else if(mData.get(position).getIcon().equals("6"))
            holder.iconView.setImageResource(R.drawable.img6);
        else if(mData.get(position).getIcon().equals("7"))
            holder.iconView.setImageResource(R.drawable.img7);
        else if(mData.get(position).getIcon().equals("8"))
            holder.iconView.setImageResource(R.drawable.img8);
        else if(mData.get(position).getIcon().equals("9"))
            holder.iconView.setImageResource(R.drawable.img9);
        else if(mData.get(position).getIcon().equals("10"))
            holder.iconView.setImageResource(R.drawable.img10);

        if(mData.get(position).getCategory1().equals("NaN"))
            holder.txtCategory1.setVisibility(View.INVISIBLE);
        else{
            holder.txtCategory1.setVisibility(View.VISIBLE);
            holder.txtCategory1.setText(mData.get(position).getCategory1());
        }

        if(mData.get(position).getCategory2().equals("NaN"))
            holder.txtCategory2.setVisibility(View.INVISIBLE);
        else{
            holder.txtCategory2.setVisibility(View.VISIBLE);
            holder.txtCategory2.setText(mData.get(position).getCategory2());
        }


        if(mData.get(position).getCategory3().equals("NaN"))
            holder.txtCategory3.setVisibility(View.INVISIBLE);
        else{
            holder.txtCategory3.setVisibility(View.VISIBLE);
            holder.txtCategory3.setText(mData.get(position).getCategory3());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}