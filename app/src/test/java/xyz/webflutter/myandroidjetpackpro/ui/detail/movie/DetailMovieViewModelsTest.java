package xyz.webflutter.myandroidjetpackpro.ui.detail.movie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;

import static org.junit.Assert.*;

public class DetailMovieViewModelsTest {
    private DetailMovieViewModels viewModels;
    private MovieModels models;

    @Before
    public void setUp() {
        viewModels = new DetailMovieViewModels();
        models = (new MovieModels("1", "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-27", "bOGkgRGdhrBYJSLpXaxhXVstddV.jpg"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getDetailMovies() {
        viewModels.setId(models.getId());
        MovieModels entity = viewModels.getDetailMovies();
        assertNotNull(entity);
        assertEquals(models.getId(), entity.getId());
        assertEquals(models.getTitle(), entity.getTitle());
        assertEquals(models.getOverview(), entity.getOverview());
        assertEquals(models.getRelease_date(), entity.getRelease_date());
        assertEquals(models.getPoster_path(), entity.getPoster_path());
    }

    @Test
    public void getDetailMovie() {
        viewModels.setId(models.getId());
        List<MovieModels> entity = viewModels.getDetailMovie();
        assertNotNull(entity);
        assertEquals(10,entity.size());
    }
}