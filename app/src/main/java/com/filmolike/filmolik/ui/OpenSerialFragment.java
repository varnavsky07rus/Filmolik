package com.filmolike.filmolik.ui;

import static com.filmolike.filmolik.ui.dashboard.parsers.PSerial_Unoff.conPageSerial;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.filmolike.filmolik.databinding.FragmentOpenSerialBinding;
import com.filmolike.filmolik.ui.dashboard.DashboardFragment;
import com.filmolike.filmolik.ui.dashboard.parsers.PSerial_Unoff;
import com.filmolike.filmolik.ui.dashboard.parsers.ParsCDN;
import com.google.android.exoplayer2.util.Log;
import com.google.android.material.chip.Chip;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;


public class OpenSerialFragment extends Fragment {
    FragmentOpenSerialBinding binding;
    private Chip chipClose;
    private TextView nameRu, description, year;
    private ImageView posterImageView;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ProgressBar progressBar;
    private Spinner spinner_seasons, spinner_series, spinner_translate;
    private CardView cardView_serial;
    private Button warn_btn;

    private ArrayAdapter adapterSeasons, adapterSeries, adapterTranslate;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenSerialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        nameRu = binding.nameRu;
        description = binding.description;
        year = binding.year;
        posterImageView = binding.posterImageView;
        progressBar = binding.progressBar;
        chipClose = binding.chipClose;
        cardView_serial = binding.cardViewSerial;
        warn_btn = binding.warnBtn;
        spinner_seasons = binding.spinnerSeasons;
        spinner_series = binding.spinnerSeries;
        spinner_translate = binding.spinnerTranslate;



        RunFragment runFragment = new RunFragment();
        runFragment.execute();

        ConnectCDN connectCDN = new ConnectCDN();
        connectCDN.execute();






        chipClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.remove(DashboardFragment.getOpenPage()).commit();
            }
        });

        return root;
    }


    private class RunFragment extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... integers) {
            conPageSerial();
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            try {
                JSONObject json = new JSONObject(PSerial_Unoff.getLine());
                nameRu.setText(json.getString("nameRu"));
                description.setText(json.getString("description"));
                year.setText(json.getString("year"));
                Picasso.get().load(json.getString("posterUrl")).into(posterImageView);


            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("pageSerial", "Ошибка создания Json");
            }
        }
    }


    private class ConnectCDN extends AsyncTask<Void, Void, Void> {
        private ParsCDN parsCDN;

        @Override
        protected Void doInBackground(Void... voids) {
            parsCDN = new ParsCDN();
            parsCDN.firstConnect();
            int i = 0;

            if (parsCDN.isDataAPI()) {
                while (!parsCDN.isDataAPI() && i < 7) {
                    parsCDN.getJsonHTML();
                    Log.i("cdnSerial", "status - " + parsCDN.isDataAPI());
                    ++i;
                    progressBar.setProgress(i);

                }
            }
            publishProgress();

            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressBar.setVisibility(View.GONE);
            if (parsCDN.dataAPI) {
                // данные поступили
                cardView_serial.setVisibility(View.VISIBLE);


            } else {
                // данных нет
                warn_btn.setVisibility(View.VISIBLE);

            }

        }
    }

}