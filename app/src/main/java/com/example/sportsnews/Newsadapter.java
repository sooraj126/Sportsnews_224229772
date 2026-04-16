package com.example.sportsnews;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Newsadapter extends RecyclerView.Adapter<Newsadapter.NewsViewHolder> {

    private List<Newsitem> newsList;

    public interface OnItemClickListener {
        void onItemClick(Newsitem item);
    }

    private OnItemClickListener listener;


    public Newsadapter(List<Newsitem> newsList, OnItemClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Newsitem item = newsList.get(position);
        holder.txtTitle.setText(item.getTitle());
        holder.txtCategory.setText(item.getCategory());
        holder.imgNews.setImageResource(item.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(item);
            }
        });
    }





    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView txtTitle, txtCategory;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNews = itemView.findViewById(R.id.imgNews);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtCategory = itemView.findViewById(R.id.txtCategory);
        }
    }

    public void updateList(List<Newsitem> newList) {
        this.newsList = newList;
        notifyDataSetChanged();
    }

}