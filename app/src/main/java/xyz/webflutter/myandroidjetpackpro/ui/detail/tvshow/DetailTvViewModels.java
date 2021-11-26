package xyz.webflutter.myandroidjetpackpro.ui.detail.tvshow;

import androidx.lifecycle.ViewModel;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class DetailTvViewModels extends ViewModel {
    private TvShowModels models;
    private String id;

    TvShowModels getDetailTvShows(){
        for (int i = 0; i < DummyData.generateDataTvShow().size(); i++){
            TvShowModels mModels = DummyData.generateDataTvShow().get(i);
            if (mModels.getId().equals(id)){
                models = mModels;
            }
        }
        return models;
    }

    List<TvShowModels> getDetailTvShow(){
        return DummyData.generateDataTvShow();
    }

    public void setId (String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
