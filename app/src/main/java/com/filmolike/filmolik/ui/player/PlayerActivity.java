package com.filmolike.filmolik.ui.player;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.filmolike.filmolik.R;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.chip.Chip;

public class PlayerActivity extends AppCompatActivity {

    private SimpleExoPlayer player;
    public Chip chip_resize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        Window window = getWindow(); //скрыть шторку уведомлений
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN | WindowManager.LayoutParams.ALPHA_CHANGED);
        Log.i("Player", "1 Шторку скрыли и начинаем все остальное скрывать ");
        View decorView = getWindow().getDecorView(); //скрыть панель навигации
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);



        setContentView(R.layout.activity_player);
        String ssss = String.valueOf(getIntent().getSerializableExtra("VP"));
        Log.i("Player1", "2 приняли ссылку на фильм - " + ssss);


        Log.i("Player1", "4 начали поиск PlayerView - ");
        PlayerView playerView;
        playerView = findViewById(R.id.player_view);

        // открываем ссылку на фильм
        Uri[] uris = new Uri[1];
        uris[0] = Uri.parse("https://" + ssss);
        Log.i("Player1", "URL FILM - " + uris[0]);
        this.player = ExoPlayerFactory.newSimpleInstance(this);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "SORRY)))-t.me ---> @Alaka_ala"));
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uris[0]);
        playerView.setPlayer(player);
        player.prepare(videoSource);
        player.setPlayWhenReady(true);// Следует ли играть автоматически

        int[] count = {0};

        chip_resize = findViewById(R.id.chip_resize);
        chip_resize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (count[0]){
                    case 0:
                        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
                        Toast.makeText(PlayerActivity.this, "1 - 16:9", Toast.LENGTH_SHORT).show();
                        count[0] = 1;
                        break;
                    case 1:
                        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
                        Toast.makeText(PlayerActivity.this, "2 - Подогнать", Toast.LENGTH_SHORT).show();
                        count[0] = 2;
                        break;
                    case 2:
                        playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
                        Toast.makeText(PlayerActivity.this, "3 - Исходный размер", Toast.LENGTH_SHORT).show();
                        count[0] = 0;
                        break;
                }
            }
        });
        // обработчик что бы прятать кноки добавленные в макет
        playerView.setControllerVisibilityListener(new PlayerControlView.VisibilityListener() {
            @Override
            public void onVisibilityChange(int visibility) {
                if(!(visibility == 0)){
                    chip_resize.setVisibility(View.GONE);
                }else{
                    chip_resize.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    private AlertDialog alertErrorPlay() {
        Log.i("Player", "Создание аллерта");
        AlertDialog.Builder builder = new AlertDialog.Builder(PlayerActivity.this);
        builder.setTitle("Ошибка")
                .setMessage("Ошибка воспроизведения Фильма... \n" +
                        "Возможно некоректная ссылка на фильм или битый файл фильма. \n" +
                        "Попробуйте воспроизвести в другом качестве или в другой озвучке")
                .setIcon(R.drawable.ic_information)
                .setPositiveButton("))))))OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Закрываем диалоговое окно
                        onBackPressed();
                        dialog.cancel();
                    }
                });
        Log.i("Player", "все чотко");
        return builder.create();
    }







    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}