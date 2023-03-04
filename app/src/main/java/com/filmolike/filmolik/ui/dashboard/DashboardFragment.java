package com.filmolike.filmolik.ui.dashboard;

import static com.filmolike.filmolik.ui.dashboard.parsers.PSerial_Unoff.conUnoSerial;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.filmolike.filmolik.R;
import com.filmolike.filmolik.databinding.FragmentDashboardBinding;
import com.filmolike.filmolik.ui.OpenSerialFragment;
import com.filmolike.filmolik.ui.dashboard.adapters.AdapterRVSerials;
import com.filmolike.filmolik.ui.dashboard.parsers.PSerial_Unoff;
import com.filmolike.filmolik.ui.dashboard.parsers.ParsCDN;
import com.filmolike.filmolik.ui.home.HomeFragment;


public class DashboardFragment extends Fragment {

    private RecyclerView recyclerViewSerials;
    private AdapterRVSerials adapter;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private static OpenSerialFragment openPage;
    public static OpenSerialFragment getOpenPage() {
        return openPage;
    }
    private FrameLayout mContainerSerial;

    private FragmentDashboardBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        recyclerViewSerials = binding.recyclerViewSerials;
        mContainerSerial = binding.mContainerSerial;

        ConnectUnoff connectUnoff = new ConnectUnoff();
        connectUnoff.execute();

        adapter = new AdapterRVSerials();
        recyclerViewSerials.setAdapter(adapter);
        recyclerViewSerials.setLayoutManager(new LinearLayoutManager(getContext()));


        /** отслеживаем состояние RecyclerView если упираемся в потолок/подвал */
        recyclerViewSerials.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    // упираемся в подвал

                    if (PSerial_Unoff.getPageNumber() < PSerial_Unoff.getMaxPage()) {
                        PSerial_Unoff.setPageNumber(PSerial_Unoff.getPageNumber() + 1);

                        ConnectUnoff connectUnoff = new ConnectUnoff();
                        connectUnoff.execute();

                        Log.i("unoffSerial", "Подключение - " + PSerial_Unoff.getPageNumber() + " максимальное колличество подключений - " + PSerial_Unoff.getMaxPage());

                    }
                } else if (!recyclerView.canScrollVertically(-1) && dy < 0) {
                    // упираемся в потолок


                }
            }
        });


        /** отслеживание нажатий в RecyclerView, OnClick метод  */
        recyclerViewSerials.addOnItemTouchListener(new HomeFragment.RecyclerItemClickListener(getContext(), recyclerViewSerials, new HomeFragment.RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Одиночное нажатие
                PSerial_Unoff.setIdKp(Integer.parseInt(PSerial_Unoff.getSerialId().get(position)));
                ParsCDN.setId(PSerial_Unoff.getSerialId().get(position));

                manager = getFragmentManager();
                transaction = manager.beginTransaction();
                openPage = new OpenSerialFragment();

                transaction.add(R.id.mContainerSerial, openPage).commit();
                mContainerSerial.animate().translationY(mContainerSerial.getMinimumHeight()).setListener(null);

            }

            @Override
            public void onLongItemClick(View view, int position) {
                // долгое нажатие
                Toast.makeText(getContext(), "Long Click", Toast.LENGTH_SHORT).show();
            }
        }));


        return root;
    }


    private class ConnectUnoff extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected Integer doInBackground(Integer... integers) {

            conUnoSerial();

            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            adapter.notifyDataSetChanged();

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}