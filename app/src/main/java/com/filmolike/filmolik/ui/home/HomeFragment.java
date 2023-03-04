package com.filmolike.filmolik.ui.home;

import static com.filmolike.filmolik.ui.home.Parsers.UnOfficial.pagesCount;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.filmolike.filmolik.databinding.FragmentHomeBinding;
import com.filmolike.filmolik.ui.OpenFilmsPFragment;
import com.filmolike.filmolik.ui.home.Adapters.Adapter_RV_Home;
import com.filmolike.filmolik.ui.home.Parsers.UnOfficial;


public class HomeFragment<Val> extends Fragment {
    private FragmentHomeBinding binding;
    private static RecyclerView rv_home;
    private Adapter_RV_Home adapter;
    private UnOfficial uno;


    public static FrameLayout getmContainers() {
        return mContainers;
    }

    private static FrameLayout mContainers, fragment_open_fp_layout;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    public static OpenFilmsPFragment getOpenFilms() {
        return openFilms;
    }

    static OpenFilmsPFragment openFilms;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        Val policy = (Val) new ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy((ThreadPolicy) policy);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        fragment_open_fp_layout = binding.getRoot().findViewById(R.id.fragment_open_fp_layout);
        rv_home = binding.rvHome;
        uno = new UnOfficial();
        mContainers = binding.mContainers;
        Connected_Async async = new Connected_Async();
        async.execute();


        adapter = new Adapter_RV_Home();
        rv_home.setAdapter(adapter);
        rv_home.setLayoutManager(new LinearLayoutManager(getContext()));
        /** отслеживаем состояние RecyclerView если упираемся в потолок/подвал */
        rv_home.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!recyclerView.canScrollVertically(1) && dy > 0) {
                    // упираемся в подвал

                    if (uno.pageNumber < pagesCount) {
                        uno.pageNumber = ++uno.pageNumber;
                        Connected_Async async = new Connected_Async();
                        async.execute();
                        Log.i("unoff", "Подключение - " + uno.pageNumber);
                    }

                } else if (!recyclerView.canScrollVertically(-1) && dy < 0) {
                    // упираемся в потолок


                }
            }
        });


        /** отслеживание нажатий в RecyclerView, OnClick метод  */
        rv_home.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rv_home, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Одиночное нажатие
                UnOfficial.ID_FILM = position;

                manager = getFragmentManager();
                transaction = manager.beginTransaction();
                openFilms = new OpenFilmsPFragment();

                transaction.add(R.id.mContainers, openFilms).commit();
                mContainers.animate().translationY(mContainers.getMinimumHeight()).setListener(null);


            }

            @Override
            public void onLongItemClick(View view, int position) {
                // долгое нажатие
                Toast.makeText(getContext(), "Long Click", Toast.LENGTH_SHORT).show();
            }
        }));


        return root;
    }


    // Первоначальное подключение к сайту для получения списка фильмов
    private class Connected_Async extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected Integer doInBackground(Integer... integers) {
            uno.connectedPopular();
            publishProgress();
            return null;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            adapter.notifyDataSetChanged();

        }
    }

    /**
     * обработчик на RecyclerView. НЕ ИЗМЕНЯТЬ!!! И НЕ ТРОГАТЬ!!!
     */
    public static class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
        private OnItemClickListener mListener;

        public interface OnItemClickListener {

            public void onItemClick(View view, int position);

            public void onLongItemClick(View view, int position);

        }

        GestureDetector mGestureDetector;

        public RecyclerItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {

                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));

                return true;
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}