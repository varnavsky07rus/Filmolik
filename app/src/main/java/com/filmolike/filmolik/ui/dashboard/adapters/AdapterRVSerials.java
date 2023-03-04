package com.filmolike.filmolik.ui.dashboard.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.filmolike.filmolik.R;
import com.filmolike.filmolik.ui.dashboard.parsers.PSerial_Unoff;
import com.squareup.picasso.Picasso;

public class AdapterRVSerials extends RecyclerView.Adapter<com.filmolike.filmolik.ui.dashboard.adapters.AdapterRVSerials.MyViewHolder> {

    @Override
    public int getItemCount() {
        // здесь берется размер исходя из массива названий имен лежащий в P_KP
        int i = PSerial_Unoff.getNameRu().size(); // нужно указывать колличество по колличеству имен сериалов
        return i;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // привязка шаблона
        Log.i("home", "AdapterRecyclerView_home - Привязка шаблона");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if(PSerial_Unoff.getNameRu().get(position).equals("null")){
            holder.nameRu_textView.setText(PSerial_Unoff.getNameOriginalArray().get(position));
        }else{
            holder.nameRu_textView.setText(PSerial_Unoff.getNameRu().get(position));
        }

        holder.countryFilm_textView.setText(PSerial_Unoff.getCountries().get(position).replaceAll("[\\[\\]]", ""));
        holder.idFilm_textView.setText(PSerial_Unoff.getSerialId().get(position));
        holder.yearFilm_textView.setText(PSerial_Unoff.getYear().get(position));
        holder.ratingFilm_textView.setText(PSerial_Unoff.getRating().get(position));
        Picasso.get().load(PSerial_Unoff.getPosterUrlPreview().get(position)).into(holder.previewPoster_imageView);
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

