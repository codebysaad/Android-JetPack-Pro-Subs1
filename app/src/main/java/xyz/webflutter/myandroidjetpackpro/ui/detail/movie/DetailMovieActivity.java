package xyz.webflutter.myandroidjetpackpro.ui.detail.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

import xyz.webflutter.myandroidjetpackpro.R;
import xyz.webflutter.myandroidjetpackpro.adapter.MovieAdapter;
import xyz.webflutter.myandroidjetpackpro.ui.movie.MovieModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_ID = "EXTRA_ID";
    private TextView title, releaseDate, overview;
    private ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = findViewById(R.id.toolbar_movie);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.title_movie_detail);
        releaseDate = findViewById(R.id.release_date);
        overview = findViewById(R.id.overview_movie_detail);
        ivPoster = findViewById(R.id.image_poster);
        DetailMovieViewModels viewModels = ViewModelProviders.of(this).get(DetailMovieViewModels.class);
        MovieAdapter adapter = new MovieAdapter(this);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String id = bundle.getString(EXTRA_ID);
            if (id != null){
                viewModels.setId(id);
                List<MovieModels> models = viewModels.getDetailMovie();
                adapter.setMovies(models);
                initializePopulate(String.valueOf(viewModels.getId()));
            }
        }
    }
    private void initializePopulate(String id){
        MovieModels models = DummyData.getMovies(id);
        assert models != null;
        Glide.with(getApplicationContext())
                .load(DummyData.baseImageUrl + models.getPoster_path())
                .error(R.drawable.ic_broken_image_black)
                .into(ivPoster);
        title.setText(models.getTitle());
        releaseDate.setText(models.getRelease_date());
        overview.setText(models.getOverview());
    }
}
