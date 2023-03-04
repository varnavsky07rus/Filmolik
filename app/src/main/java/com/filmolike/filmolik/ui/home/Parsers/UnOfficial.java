package com.filmolike.filmolik.ui.home.Parsers;

import android.util.Log;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnOfficial {
    private static final String API_KEY = "920aaf6a-9f64-46f7-bda7-209fb1069440";

    public static ArrayList<String> getNameRu() {
        return nameRu;
    }

    public static ArrayList<String> getYear() {
        return year;
    }

    public static ArrayList<String> getFilmId() {
        return filmId;
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

    public static int getCountFilms() {
        return countFilms;
    }

    private static ArrayList<String> nameRu = new ArrayList<>();
    private static ArrayList<String> year = new ArrayList<>();
    private static ArrayList<String> filmId = new ArrayList<>();
    private static ArrayList<String> filmLength = new ArrayList<>();
    private static ArrayList<String> rating = new ArrayList<>();
    private static ArrayList<String> posterUrlPreview = new ArrayList<>();
    private static ArrayList<String> posterUr = new ArrayList<>();
    private static ArrayList<String> countries = new ArrayList<>();
    private static ArrayList<String> genres = new ArrayList<>();
    private static ArrayList<String> nameOriginalArray = new ArrayList<>();


    private static int countFilms;
    public static int pageNumber = 1;
    public static int pagesCount;
    public static void connectedPopular() {

        Log.i("unoff", "Создание массивов- OK");

        Map<String, String> headers = new HashMap<>();                  // заголовки запроса
        headers.put("X-API-KEY", API_KEY);
        headers.put("content-type", "application/json");
        URL url = null;
        String urlSite = "https://kinopoiskapiunofficial.tech/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS&page=" + pageNumber;
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
        Log.w("unoff", "Полученные данные ---> " + line);

        // закрываем БУФЕР и Соединение для освобождения ресурсов
        try {
            if (bufferedReader.ready() != true) {
                bufferedReader.close();
                myURLConnection.disconnect();
                Log.i("home", "P_CKP - Буффер и соединение - ЗАКРЫТЫ! - PKP");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(line);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("unoff", "Ошибка создания Json объкта из строки line");
        }
        try {
            pagesCount = Integer.parseInt(jsonObject.getString("pagesCount")) -15;
            countFilms = jsonObject.getJSONArray("films").length();
            Log.i("unoff", "колличество фильмо для парсинга - " + countFilms);
            for (int i = 0; i < countFilms; i++) {
                Log.i("unoff", "Старт цикла");
                nameRu.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("nameRu"));
                Log.i("unoff", "nameRu - OK");
                year.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("year"));
                Log.i("unoff", "year - OK");
                filmId.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("filmId"));
                Log.i("unoff", "filmId - OK");
                filmLength.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("filmLength"));
                Log.i("unoff", "filmLength - OK");
                rating.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("rating"));
                Log.i("unoff", "rating - OK");
                posterUrlPreview.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("posterUrlPreview"));
                Log.i("unoff", "posterUrlPreview - OK");
                posterUr.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("posterUrl"));
                Log.i("unoff", "posterUrl - OK");
                nameOriginalArray.add(jsonObject.getJSONArray("films").getJSONObject(i).getString("nameEn"));
                countries.add(jsonObject.getJSONArray("films").getJSONObject(i).getJSONArray("countries").getJSONObject(0).getString("country"));


                int countGenres = jsonObject.getJSONArray("films").getJSONObject(i).getJSONArray("genres").length();
                for (int b = 0; b < countGenres; b++) {
                    Log.i("unoff", "Старт цикла на перебор жанров - " + b);
                    genres.add(jsonObject.getJSONArray("films").getJSONObject(i).getJSONArray("genres").getJSONObject(b).getString("genre"));
                    if (b == countGenres) {
                        break;
                    }
                }
                if (i == countFilms) {
                    break;
                }
            }
            Log.i("unoff", "конец цикла. массив имен ---> " + nameRu);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    // =============================================================================================


    public static int ID_FILM;
    public static boolean STATUS_DOWNLOAD_PAGE;

    public static String getKpId() {
        return KP_ID;
    }

    public static String getNameRU() {
        return nameRU;
    }

    public static String getPosterUrl() {
        return posterUrl;
    }

    public static String getRatingKinopoisk() {
        return ratingKinopoisk;
    }

    public static String getRatingImdb() {
        return ratingImdb;
    }

    public static String getYearP() {
        return yearP;
    }

    public static String getDescription() {
        return description;
    }

    public static String getType() {
        return type;
    }

    public static String getNameOriginal() {
        return nameOriginal;
    }

    public static String KP_ID;
    public static String nameRU;
    public static String posterUrl;
    public static String ratingKinopoisk;
    public static String ratingImdb;
    public static String yearP;
    public static String description;
    public static String type;


    public static String nameOriginal;

    public static void connectedPagesFilm() {

        Log.i("unoff", "Создание массивов- OK");

        Map<String, String> headers = new HashMap<>();                  // заголовки запроса
        headers.put("X-API-KEY", API_KEY);
        headers.put("content-type", "application/json");
        URL url = null;
        String urlSite = "https://kinopoiskapiunofficial.tech/api/v2.2/films/" + filmId.get(ID_FILM);
        try {
            url = new URL(urlSite);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            STATUS_DOWNLOAD_PAGE = false;
        }                 // создаем ссылку на основе полученной строки urlSite


        HttpURLConnection myURLConnection = null;
        try {
            myURLConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            STATUS_DOWNLOAD_PAGE = false;
        }                           // настриваем подключение


        for (String headerKey : headers.keySet()) {                                                 // отправка заголовка
            myURLConnection.setRequestProperty(headerKey, headers.get(headerKey));
        }

        try {
            myURLConnection.connect();
        } catch (IOException e) {
            e.printStackTrace();
            STATUS_DOWNLOAD_PAGE = false;
        }                           // подключаемся


        // ПОЛУЧЕНИЕ И ЗАПИСЬ ОТВЕТА
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            STATUS_DOWNLOAD_PAGE = false;
        }
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            STATUS_DOWNLOAD_PAGE = false;
        }
        // отдаем строку Line парсеру Json
        Log.w("unoff", "Полученные данные ---> " + line);

        try {
            JSONObject job = new JSONObject(line);
            KP_ID = job.getString("kinopoiskId");
            nameRU = job.getString("nameRu");
            posterUrl = job.getString("posterUrl");
            ratingKinopoisk = job.getString("ratingKinopoisk");
            ratingImdb = job.getString("ratingImdb");
            yearP = job.getString("year");
            description = job.getString("description");
            type = job.getString("type");
            nameOriginal = job.getString("nameOriginal");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        // закрываем БУФЕР и Соединение для освобождения ресурсов
        try {
            if (bufferedReader.ready() != true) {
                bufferedReader.close();
                myURLConnection.disconnect();
                Log.i("home", "P_CKP - Буффер и соединение - ЗАКРЫТЫ! - PKP");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        STATUS_DOWNLOAD_PAGE = true;

    }

}
