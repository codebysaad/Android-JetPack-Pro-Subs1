package xyz.webflutter.myandroidjetpackpro.ui.detail.movie;

import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class DetailMovieViewModels extends ViewModel {
    private MovieModels models;
    private String id;

    MovieModels getDetailMovies(){
        for (int i =0; i < DummyData.generateDataMovies().size();i++){
            MovieModels mModels = DummyData.generateDataMovies().get(i);
            if (mModels.getId().equals(id)){
                models = mModels;
            }
        }
        return models;
    }

    List<MovieModels> getDetailMovie(){
        return DummyData.generateDataMovies();
    }

    public void setId (String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
