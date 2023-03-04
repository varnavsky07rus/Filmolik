package com.filmolike.filmolik.ui.home.Adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.filmolike.filmolik.R;
import com.filmolike.filmolik.ui.home.Parsers.UnOfficial;
import com.squareup.picasso.Picasso;

public class Adapter_RV_Home extends RecyclerView.Adapter<Adapter_RV_Home.MyViewHolder> {

    @Override
    public int getItemCount() {
        // здесь берется размер исходя из массива названий имен лежащий в P_KP
        int i = UnOfficial.getNameRu().size();
        return i;
    }

    @NonNull
    @Override
    public Adapter_RV_Home.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // привязка шаблона
        Log.i("home", "AdapterRecyclerView_home - Привязка шаблона");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_RV_Home.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Picasso.get().load(UnOfficial.getPosterUrlPreview().get(position)).resize(350, 500).centerCrop().into(holder.previewPoster_imageView);
        if (UnOfficial.getNameRu().get(position).equals("null")){
            holder.nameRu_textView.setText(UnOfficial.getNameOriginalArray().get(position));
        }else {
            holder.nameRu_textView.setText(UnOfficial.getNameRu().get(position));
        }

        holder.countryFilm_textView.setText(UnOfficial.getCountries().get(position));
        holder.idFilm_textView.setText(UnOfficial.getFilmId().get(position));
        if (UnOfficial.getRating().get(position).equals("null")){
            holder.ratingFilm_textView.setText("0.0");
        }else {
            holder.ratingFilm_textView.setText(UnOfficial.getRating().get(position));
        }
        holder.yearFilm_textView.setText(UnOfficial.getYear().get(position));
        holder.numberItems.setText(String.valueOf(position + 1));
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameRu_textView, yearFilm_textView, countryFilm_textView, ratingFilm_textView, idFilm_textView, numberItems;
        ImageView previewPoster_imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameRu_textView = itemView.findViewById(R.id.nameRu_textView);
            yearFilm_textView = itemView.findViewById(R.id.yearFilm_textView);
            countryFilm_textView = itemView.findViewById(R.id.countryFilm_textView);
            ratingFilm_textView = itemView.findViewById(R.id.ratingFilm_textView);
            idFilm_textView = itemView.findViewById(R.id.idFilm_textView);
            previewPoster_imageView = itemView.findViewById(R.id.previewPoster_imageView);
            numberItems = itemView.findViewById(R.id.numberItems);

        }
    }
}
