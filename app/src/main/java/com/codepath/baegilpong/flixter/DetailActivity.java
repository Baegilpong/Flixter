package com.codepath.baegilpong.flixter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.codepath.baegilpong.flixter.models.Movie;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tvOverview;
    TextView tvLanguage;
    TextView tvDate;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvTitle = findViewById(R.id.tvTitle);
        tvOverview = findViewById(R.id.tvOverview);
        tvLanguage = findViewById(R.id.tvLanguage);
        tvDate = findViewById(R.id.tvDate);
        ratingBar = findViewById(R.id.ratingBar);



        Movie movie = Parcels.unwrap((getIntent().getParcelableExtra("movie")));
        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        tvLanguage.setText(movie.getLanguage());
        tvDate.setText(movie.getDate());
        ratingBar.setRating((float) movie.getRating());
    }
}