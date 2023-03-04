package com.filmolike.filmolik.ui.dashboard.parsers;

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
import java.net.URL;

public class ParsCDN {
    public static void setId(String id) {
        ParsCDN.id = id;
    }

    private static String id;
    private String getIframeSrc;

    public boolean isDataAPI() {
        return dataAPI;
    }

    public boolean dataAPI;

    public void firstConnect() {

        String urlSite = "https://videocdn.tv/api/tv-series?api_token=Fm4PitEIcN1zUvxT92jer99ybYFf9yHj&ordering=id&direction&kinopoisk_id=" + id;
        Log.i("cdnSerial", "Старт подключения. url - " + urlSite);
        URL url = null;
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
            JSONObject jsonObject = new JSONObject(line);
            int quantData = jsonObject.getJSONArray("data").length();
            Log.i("cdnSerial", "есть ли данные в Json - " + quantData);

            if (quantData == 0) {
                dataAPI = false;    // нет данных на сервере
            } else {
                dataAPI = true;     // есть данные на сервере
                getIframeSrc = jsonObject.getJSONArray("data").getJSONObject(0).getString("iframe_src");    // getIframeSrc ---> //53.annacdn.cc/elIrHPVlNWOa/movie/5874
                getJsonHTML();
            }
            //нужно не забыть закрыть соединение и буфер



        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("cdnSerial", "P_Kp2_PagesFilmView - Error URL CDN2");
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("cdnSerial", "P_Kp2_PagesFilmView - Error API/URL CDN2");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("cdnSerial", "Ошибка создания Json файла");
        }


    }

    private Document doc = null;

    public static String getJson_str() {
        return json_str;
    }
    private static String json_str;

    public void getJsonHTML() {
        try {
            Log.i("cdnSerial", "поключение к iframe_src - https:" + getIframeSrc);
            doc = Jsoup.connect("https:" + getIframeSrc + "?load=3").get();
            Element element = doc.getElementById("downloadFiles");
            String EscapeEncode = StringEscapeUtils.unescapeJson(element.attr("value"));
            json_str = EscapeEncode;
            Log.i("cdnSerial", "Успешно!" + json_str);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("cdnSerial", "Ошибка подключения к iframe_src");
        }
    }


}
