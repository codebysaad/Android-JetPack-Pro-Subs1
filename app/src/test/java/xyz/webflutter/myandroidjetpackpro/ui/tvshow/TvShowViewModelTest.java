package xyz.webflutter.myandroidjetpackpro.ui.tvshow;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TvShowViewModelTest {
    private TvShowViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new TvShowViewModel();
    }

    @Test
    public void getTvShow() {
        List<TvShowModels> entities = viewModel.getTvShow();
        assertNotNull(entities);
        assertEquals(10, entities.size());
    }
}