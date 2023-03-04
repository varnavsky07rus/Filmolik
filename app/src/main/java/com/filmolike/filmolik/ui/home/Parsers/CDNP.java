package com.filmolike.filmolik.ui.home.Parsers;

import android.util.Log;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class CDNP {


    public static int qnt_Data;
    public static String iframe_src;

    public CDNP(String KP_ID_FILM) {
        Log.i("cdn", "Старт конструктора 1");
        String urlSite = "https://videocdn.tv/api/movies?api_token=Fm4PitEIcN1zUvxT92jer99ybYFf9yHj&ordering=id&direction&kinopoisk_id=" + KP_ID_FILM;
        URL url = null;
        JSONObject jsonObject = null;
        try {
            url = new URL(urlSite);

            HttpURLConnection myURLConnection = null;
            myURLConnection = (HttpURLConnection) url.openConnection();
            myURLConnection.setRequestMethod("GET");
            myURLConnection.connect();

            //получение ответа
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            String line = bufferedReader.readLine();
            // нужно из полученного Json достать тег iframe_src
            jsonObject = new JSONObject(line);
            qnt_Data = jsonObject.getJSONArray("data").length();
            if (qnt_Data != 0) {
                iframe_src = jsonObject.getJSONArray("data").getJSONObject(0).getString("iframe_src");
            } else {
                Log.e("cdn", "Json файл пустой, нет данных ссылок, вероятно фильм не загружен на балансер");
            }

            Log.i("cdn", "Полученный iframe_src - " + iframe_src);


            /** ДАЛЕЕ НЕОБХОДИМО РАЗДЕЛИТЬ КОД ЧТО БЫ ПЕРЕПОДКЛЮЧЕНИЕ ОСУЩЕСТВЛЯЛОСЬ НЕ ПОЛНОСТЬЮ А ЛИШЬ НА ПОЛУЧЕНИЕ ВСЕХ ССЫЛОК ФИЛЬМА**/
            // ссылка хранится в iframe_src c помощью ее нужно подключаться далее

            reconnected();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("cdn", "ошибка создания ссылки на фильм ");
        } catch (ProtocolException e) {
            e.printStackTrace();
            Log.e("cdn", "ошибка создания параметров подключения");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("cdn", "ошибка подключения к CDN");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("cdn", "ошибка создания Json из базы CDN - Json ->  " + jsonObject);
        }
    }


    public static boolean statusReconnect;
    private static Document doc = null;

    public static JSONObject getObject() {
        return object;
    }
    static JSONObject object;
    public static void reconnected() {
        try {
            doc = Jsoup.connect("https:" + iframe_src + "?load=3").get();
            Element s = doc.getElementById("downloadFiles");
            String clearJSON = s.attr("value");
            String jsonStr = StringEscapeUtils.unescapeJson(clearJSON);
            Log.d("cdn", "reconnected result - " + jsonStr);
            statusReconnect = true;
            object = new JSONObject(jsonStr);

            createArrays(object);


        } catch (IOException e) {
            e.printStackTrace();
            Log.e("cdn", "Ошибка Jsoup парсинга CDN на предмет Json'а || вероятно защита от парсинга , необходимо переподключиться - ");
            statusReconnect = false;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    // films
    public static ArrayList<String> translaterFilm = new ArrayList<>();



    public static void createArrays(JSONObject json) {
        if (UnOfficial.getType().equals("FILM")) {
            try {
                int quantTranslaterFilm = json.getJSONArray("download").length();
                for (int i = 0; i < quantTranslaterFilm; i++) {
                    translaterFilm.add(json.getJSONArray("download").getJSONObject(i).getString("name"));

                }
                Log.i("cdn", "данные озвучек - " + translaterFilm);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {

        }
    }


}
