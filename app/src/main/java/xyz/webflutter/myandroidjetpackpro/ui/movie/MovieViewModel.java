package xyz.webflutter.myandroidjetpackpro.ui.movie;

import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class MovieViewModel extends ViewModel {

    public List<MovieModels> getMovies(){
        return DummyData.generateDataMovies();
    }
}