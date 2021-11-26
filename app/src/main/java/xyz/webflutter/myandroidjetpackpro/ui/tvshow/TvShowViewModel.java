package xyz.webflutter.myandroidjetpackpro.ui.tvshow;

import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class TvShowViewModel extends ViewModel {
    public List<TvShowModels> getTvShow(){
        return DummyData.generateDataTvShow();
    }
}