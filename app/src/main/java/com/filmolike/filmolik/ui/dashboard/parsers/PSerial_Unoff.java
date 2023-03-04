package com.filmolike.filmolik.ui.dashboard.parsers;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PSerial_Unoff {
    private static final String API_KEY = "920aaf6a-9f64-46f7-bda7-209fb1069440";
    private static int countSerial;

    public static void setPageNumber(int pageNumber) {
        PSerial_Unoff.pageNumber = pageNumber;
    }

    public static int getPageNumber() {
        return pageNumber;
    }

    private static int pageNumber = 1;


    public static ArrayList<String> getNameRu() {
        return nameRu;
    }

    public static ArrayList<String> getYear() {
        return year;
    }

    public static ArrayList<String> getSerialId() {
        return serialId;
    }

    public static ArrayList<String> getFilmLength() {
        return filmLength;
    }

    public static ArrayList<String> getRating() {
        return rating;
    }

    public static ArrayList<String> getPosterUrlPreview() {
        return posterUrlPreview;
    }

    public static ArrayList<String> getPosterUr() {
        return posterUr;
    }

    public static ArrayList<String> getCountries() {
        return countries;
    }

    public static ArrayList<String> getNameOriginalArray() {
        return nameOriginalArray;
    }

    public static ArrayList<String> getGenres() {
        return genres;
    }

    public static int getCountSerial() {
        return countSerial;
    }

    private static ArrayList<String> nameRu = new ArrayList<>();
    private static ArrayList<String> year = new ArrayList<>();
    private static ArrayList<String> serialId = new ArrayList<>();
    private static ArrayList<String> filmLength = new ArrayList<>();
    private static ArrayList<String> rating = new ArrayList<>();
    private static ArrayList<String> posterUrlPreview = new ArrayList<>();
    private static ArrayList<String> posterUr = new ArrayList<>();
    private static ArrayList<String> countries = new ArrayList<>();
    private static ArrayList<String> genres = new ArrayList<>();
    private static ArrayList<String> nameOriginalArray = new ArrayList<>();
    private static ArrayList<String> ratingImdb = new ArrayList<>();

    public static int getMaxPage() {
        return maxPage;
    }

    private static int maxPage;

    public static void conUnoSerial() {
        Map<String, String> headers = new HashMap<>();                  // заголовки запроса
        headers.put("X-API-KEY", API_KEY);
        headers.put("content-type", "application/json");
        URL url = null;
        String urlSite = "https://kinopoiskapiunofficial.tech/api/v2.2/films?order=RATING&type=TV_SERIES&ratingFrom=0&ratingTo=10&yearFrom=1000&yearTo=3000&page=" + pageNumber;



        try {
            url = new URL(urlSite);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }                 // создаем ссылку на основе полученной строки urlSite
        HttpURLConnection myURLConnection = null;
        try {
            myURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }                           // настриваем подключение
        for (String headerKey : headers.keySet()) {
            myURLConnection.setRequestProperty(headerKey, headers.get(headerKey));
        }                 // отправка заголовка
        try {
            myURLConnection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }                           // подключаемся
        // ПОЛУЧЕНИЕ И ЗАПИСЬ ОТВЕТА
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // отдаем строку Line парсеру Json
        Log.w("unoffSerial", "Полученные данные ---> " + line);

        JSONObject json = null;
        try {
            json = new JSONObject(line);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            int getItemsCount = json.getJSONArray("items").length();
            maxPage = Integer.parseInt(json.getString("totalPages")) - 2;
            for (int i = 0; i < getItemsCount; i++) {
                nameRu.add(json.getJSONArray("items").getJSONObject(i).getString("nameRu"));
                nameOriginalArray.add(json.getJSONArray("items").getJSONObject(i).getString("nameOriginal"));
                rating.add(json.getJSONArray("items").getJSONObject(i).getString("ratingKinopoisk"));
                ratingImdb.add(json.getJSONArray("items").getJSONObject(i).getString("ratingImdb"));
                posterUr.add(json.getJSONArray("items").getJSONObject(i).getString("posterUrl"));
                posterUrlPreview.add(json.getJSONArray("items").getJSONObject(i).getString("posterUrlPreview"));
                year.add(json.getJSONArray("items").getJSONObject(i).getString("year"));
                serialId.add(json.getJSONArray("items").getJSONObject(i).getString("kinopoiskId"));
                countries.add(json.getJSONArray("items").getJSONObject(i).getJSONArray("countries").getJSONObject(0).getString("country"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public static void setIdKp(int idKp) {
        ID_KP = idKp;
    }
    static int ID_KP;

    public static String getLine() {
        return line;
    }
    private static String line = null;


    public static void conPageSerial(){
        Map<String, String> headers = new HashMap<>();                  // заголовки запроса
        headers.put("X-API-KEY", API_KEY);
        headers.put("content-type", "application/json");
        URL url = null;
        String urlSerial = "https://kinopoiskapiunofficial.tech/api/v2.2/films/" + ID_KP;

        try {
            url = new URL(urlSerial);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }                 // создаем ссылку на основе полученной строки urlSite
        HttpURLConnection myURLConnection = null;
        try {
            myURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }                           // настриваем подключение
        for (String headerKey : headers.keySet()) {
            myURLConnection.setRequestProperty(headerKey, headers.get(headerKey));
        }                 // отправка заголовка
        try {
            myURLConnection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }                           // подключаемся
        // ПОЛУЧЕНИЕ И ЗАПИСЬ ОТВЕТА
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // отдаем строку Line парсеру Json
        Log.w("unoffSerial", "Полученные данные ---> " + line);



    }



}
