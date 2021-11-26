package xyz.webflutter.myandroidjetpackpro.ui.movie;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MovieViewModelTest {
    private MovieViewModel viewModel;

    @Before
    public void setUp(){
        viewModel = new MovieViewModel();
    }

    @Test
    public void getMovies() {
        List<MovieModels> entities = viewModel.getMovies();
        assertNotNull(entities);
        assertEquals(10, entities.size());
    }
}