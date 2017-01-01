package me.anwarshahriar.databindingexplore;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import me.anwarshahriar.databindingexplore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Movie> movieList = getMovies();
        MovieAdapter adapter = new MovieAdapter(movieList);
        binding.rvMovies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvMovies.setAdapter(adapter);
    }


    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        Movie residentEvil = new Movie(
                "Resident Evil: The Final Chapter",
                2017,
                "Paul W.S. Anderson",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTc0Mzc2OTQ0Ml5BMl5BanBnXkFtZTgwOTQ5MjE4MDI@._V1._SY209_CR0,0,140,209_.jpg"
        );
        Movie johnWick = new Movie(
                "John Wick: Chapter 2",
                2017,
                "Chad Stahelski",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzc4MTkwOF5BMl5BanBnXkFtZTgwOTE5MDcyMDI@._V1._SY209_CR3,0,140,209_.jpg"
        );
        Movie ghostInTheShell = new Movie(
                "Ghost in the Shell",
                2017,
                "Rupert Sanders",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BNzQ0NDcwMDA4Ml5BMl5BanBnXkFtZTgwNDg4OTg1MDI@._V1._SY209_CR0,0,140,209_.jpg"
        );
        Movie piratesOfTheCaribbean = new Movie(
                "Pirates of the Caribbean: Dead Men Tell No Tales",
                2017,
                "Joachim Rønning, Espen Sandberg",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BNDY3MDY4MDc3MV5BMl5BanBnXkFtZTgwMTU0MzEyMDI@._V1._SY209_CR3,0,140,209_.jpg"
        );
        Movie cars = new Movie(
                "Cars 3",
                2017,
                "Michael Bay",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2NDM4OTAxMF5BMl5BanBnXkFtZTgwOTU4NTM3MDI@._V1._SY209_CR0,0,140,209_.jpg"
        );

        movies.add(residentEvil);
        movies.add(johnWick);
        movies.add(ghostInTheShell);
        movies.add(piratesOfTheCaribbean);
        movies.add(cars);

        return movies;
    }
}
