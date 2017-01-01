package me.anwarshahriar.databindingexplore;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.anwarshahriar.databindingexplore.databinding.MovieItemBinding;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieItemBinding binding = DataBindingUtil.inflate(
                                            LayoutInflater.from(parent.getContext()),
                                            R.layout.movie_item,
                                            parent,
                                            false);
        return new MovieViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie aMovie = movies.get(position);
        MovieItemBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setMovie(aMovie);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public MovieViewHolder(View itemView) {
            super(itemView);
        }
    }
}
