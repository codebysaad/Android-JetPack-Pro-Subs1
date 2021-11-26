package xyz.webflutter.myandroidjetpackpro.ui.detail.tvshow;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowViewModel;

import static org.junit.Assert.*;

public class DetailTvViewModelsTest {
    private DetailTvViewModels viewModels;
    private TvShowModels models;

    @Before
    public void setUp() {
        viewModels = new DetailTvViewModels();
        models = (new TvShowModels("1", "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012-10-10","dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg"));
    }

    @Test
    public void getDetailTvShows() {
        viewModels.setId(models.getId());
        TvShowModels entity = viewModels.getDetailTvShows();
        assertNotNull(entity);
        assertEquals(models.getId(), entity.getId());
        assertEquals(models.getName(), entity.getName());
        assertEquals(models.getOverview(), entity.getOverview());
        assertEquals(models.getFirst_air_date(), entity.getFirst_air_date());
        assertEquals(models.getBackdrop_path(), entity.getBackdrop_path());
    }

    @Test
    public void getDetailTvShow() {
        viewModels.setId(models.getId());
        List<TvShowModels> entity = viewModels.getDetailTvShow();
        assertNotNull(entity);
        assertEquals(10,entity.size());
    }
}