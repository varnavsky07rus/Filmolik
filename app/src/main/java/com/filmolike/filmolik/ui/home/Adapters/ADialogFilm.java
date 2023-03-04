package com.filmolike.filmolik.ui.home.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.filmolike.filmolik.ui.home.Parsers.CDNP;
import com.filmolike.filmolik.ui.player.PlayerActivity;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

public class ADialogFilm {

    public static void create(Context context){
        // создаем массив из уже готова списка из CDNP
        String[] translater = CDNP.translaterFilm.toArray(new String[0]);
        // здесь создаем по ходу дела уже лист преобраззуя в массив
        ArrayList<String> qualities = new ArrayList<>();
        // получаем json для создания и парсинга по ходу дела



        AlertDialog.Builder builderAlert = new AlertDialog.Builder(context);
        builderAlert.setTitle("Озвучки").setItems(translater, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int posTrans) {
                switch(posTrans) {
                    case 0:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(0).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(0).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                        switch (posQuality){
                                            case 0:
                                                // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                                try {
                                                    String urlJson = CDNP.getObject().
                                                            getJSONArray("download").
                                                            getJSONObject(0).
                                                            getJSONArray("qualities").
                                                            getJSONObject(0).getString("route");
                                                    String urlServer = Jsoup.connect(urlJson).get().toString();
                                                    Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                    String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                    //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                    Intent myIntent = new Intent(context, PlayerActivity.class);
                                                    myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                    context.startActivity(myIntent);
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 1:
                                                // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                                try {
                                                    String urlJson = CDNP.getObject().
                                                            getJSONArray("download").
                                                            getJSONObject(1).
                                                            getJSONArray("qualities").
                                                            getJSONObject(1).getString("route");
                                                    String urlServer = Jsoup.connect(urlJson).get().toString();
                                                    Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                    String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                    String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                    Intent myIntent = new Intent(context, PlayerActivity.class);
                                                    myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                    context.startActivity(myIntent);
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 2:
                                                // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                                try {
                                                    String urlJson = CDNP.getObject().
                                                            getJSONArray("download").
                                                            getJSONObject(2).
                                                            getJSONArray("qualities").
                                                            getJSONObject(2).getString("route");
                                                    String urlServer = Jsoup.connect(urlJson).get().toString();
                                                    Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                    String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                    String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                    Intent myIntent = new Intent(context, PlayerActivity.class);
                                                    myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                    context.startActivity(myIntent);
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 3:
                                                // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                                try {
                                                    String urlJson = CDNP.getObject().
                                                            getJSONArray("download").
                                                            getJSONObject(3).
                                                            getJSONArray("qualities").
                                                            getJSONObject(3).getString("route");
                                                    String urlServer = Jsoup.connect(urlJson).get().toString();
                                                    Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                    String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                    String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                    Intent myIntent = new Intent(context, PlayerActivity.class);
                                                    myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                    context.startActivity(myIntent);
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                        }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        break;

                    case 1:

                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(1).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(1).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        break;

                    case 2:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(2).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(2).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 3:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(3).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(3).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 4:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(4).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(4).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 5:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(5).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(5).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 6:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(6).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(6).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 7:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(7).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(7).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 8:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(8).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(8).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 9:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(9).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(9).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 10:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(10).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(10).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 11:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(11).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(11).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 12:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(12).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(12).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 13:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(13).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(13).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 14:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(14).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(14).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;


                    case 15:
                        try {
                            int quantQuality_1 = CDNP.getObject().getJSONArray("download").getJSONObject(15).getJSONArray("qualities").length();
                            for(int i = 0; i < quantQuality_1; i++){
                                qualities.add(CDNP.getObject().
                                        getJSONArray("download").
                                        getJSONObject(15).
                                        getJSONArray("qualities").
                                        getJSONObject(i).
                                        getString("quality"));
                            }
                            String[] qualitiesMass = qualities.toArray(new String[0]);
                            builderAlert.setItems(qualitiesMass, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int posQuality) {
                                    switch (posQuality){
                                        case 0:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(0).
                                                        getJSONArray("qualities").
                                                        getJSONObject(0).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(44, urlServer.length() - 18);
                                                //String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", trimScrap); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 1:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(1).
                                                        getJSONArray("qualities").
                                                        getJSONObject(1).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 2:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(2).
                                                        getJSONArray("qualities").
                                                        getJSONObject(2).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                        case 3:
                                            // тут необходимо получить ссылку на фильм данного качества и открыть в плеере
                                            try {
                                                String urlJson = CDNP.getObject().
                                                        getJSONArray("download").
                                                        getJSONObject(3).
                                                        getJSONArray("qualities").
                                                        getJSONObject(3).getString("route");
                                                String urlServer = Jsoup.connect(urlJson).get().toString();
                                                Log.i("Adialog", "прямая ссылка на фильм - " + urlServer);
                                                String trimScrap = urlServer.substring(43, urlServer.length() - 18);
                                                String LineUrl = StringEscapeUtils.unescapeJson(trimScrap);



                                                Intent myIntent = new Intent(context, PlayerActivity.class);
                                                myIntent.putExtra("VP", LineUrl); //Optional parameters
                                                context.startActivity(myIntent);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            break;
                                    }
                                }
                            }).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }).show();
    }



}
