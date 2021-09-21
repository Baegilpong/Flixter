package com.codepath.baegilpong.flixter.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    String language;
    String date;
    double rating;

    // empty constructor needed by the Parceler library
    public Movie() { }

    public Movie(JSONObject jsonObject) throws JSONException {
        movieId = jsonObject.getInt("id");
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        language = jsonObject.getString("original_language");
        date = jsonObject.getString("release_date");
        rating = jsonObject.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public int getMovieId() { return movieId; }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    // Used ISO Language Code Table (http://www.lingoes.net/en/translator/langcode.htm)
    // Implemented the common ones that MAY appear
    // Would like to implement a way that automatically does the ISO code from MovieDB to their respective languages
    public String getLanguage() {
        if (language.equals("en"))
            language = "English";
        if (language.equals("es"))
            language = "Spanish";
        if (language.equals("jp"))
            language = "Japanese";
        if (language.equals("fr"))
            language = "French";
        if (language.equals("ar"))
            language = "Arabic";
        if (language.equals("de"))
            language = "German";
        if (language.equals("cn"))
            language = "Chinese";

        return "Original Language: " + language; }

    public String getDate() { return date; }

    public double getRating() { return rating; }


}
