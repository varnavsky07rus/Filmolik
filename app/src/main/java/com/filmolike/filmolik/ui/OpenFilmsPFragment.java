package com.filmolike.filmolik.ui;


import static com.filmolike.filmolik.ui.home.Parsers.UnOfficial.connectedPagesFilm;
import static com.filmolike.filmolik.ui.home.Parsers.UnOfficial.getKpId;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.filmolike.filmolik.databinding.FragmentOpenFpBinding;
import com.filmolike.filmolik.ui.home.Adapters.ADialogFilm;
import com.filmolike.filmolik.ui.home.HomeFragment;
import com.filmolike.filmolik.ui.home.Parsers.CDNP;
import com.filmolike.filmolik.ui.home.Parsers.UnOfficial;
import com.google.android.material.chip.Chip;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;


public class OpenFilmsPFragment extends Fragment {
    private Chip chipClose;
    private TextView nameRu, description, year;
    private ImageView posterImageView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ProgressBar progressBar;
    private FragmentOpenFpBinding binding;
    private Button filmView_btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenFpBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        nameRu = binding.nameRu;
        description = binding.description;
        year = binding.year;
        posterImageView = binding.posterImageView;
        progressBar = binding.progressBar;
        filmView_btn = binding.filmViewBtn;
        chipClose = binding.chipClose;


        progressBar.setVisibility(View.GONE);
        PageFConnect pageFConnect = new PageFConnect(); // подключение к Unofficial
        pageFConnect.execute();


        CdnConnect cdnConnect = new CdnConnect();       // парсинг ссылок на фильм CDN
        cdnConnect.execute();



        chipClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CDNP.translaterFilm.clear();
                cdnConnect.cancel(true);
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(HomeFragment.getOpenFilms()).commit();
                HomeFragment.getmContainers().animate().translationY(HomeFragment.getmContainers().getWidth() / 30).setListener(null);
            }
        });


        return root;
    }

    private class PageFConnect extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            connectedPagesFilm();
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            nameRu.setText(UnOfficial.getNameRU());
            description.setText(UnOfficial.getDescription());
            year.setText(UnOfficial.getYearP());
            Picasso.get().load(UnOfficial.getPosterUrl()).into(posterImageView);
        }
    }

    private class CdnConnect extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            // сначала подключаемся
            CDNP cdnp = new CDNP(getKpId());

            // если не получилось то переподключимся
            int i = 0;
            while (CDNP.statusReconnect == false && i < 10) {
                Log.w("cdn", "цикл переподключения.");
                CDNP cdnp2 = new CDNP(getKpId());
                i++;
                // задержка
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressBar.setProgress(i);
            }

            return null;
        }


        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            progressBar.setVisibility(View.GONE);
            filmView_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ADialogFilm.create(getContext());
                }
            });


        }
    }


}