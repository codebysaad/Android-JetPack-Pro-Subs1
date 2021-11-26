package xyz.webflutter.myandroidjetpackpro.ui.detail.tvshow;

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
import xyz.webflutter.myandroidjetpackpro.adapter.TvShowAdapter;
import xyz.webflutter.myandroidjetpackpro.ui.tvshow.TvShowModels;
import xyz.webflutter.myandroidjetpackpro.utils.DummyData;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_ID = "EXTRA_ID_TV_SHOW";
    private TextView title, releaseDate, overview;
    private ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv_show );
        Toolbar toolbar = findViewById(R.id.toolbar_tv_show);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        title = findViewById(R.id.title_movie_detail);
        releaseDate = findViewById(R.id.release_date);
        overview = findViewById(R.id.overview_movie_detail);
        ivPoster = findViewById(R.id.image_poster);
        DetailTvViewModels viewModels = ViewModelProviders.of(this).get(DetailTvViewModels.class);
        TvShowAdapter adapter = new TvShowAdapter(this);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String id = bundle.getString(EXTRA_ID);
            if (id != null){
                viewModels.setId(id);
                List<TvShowModels> models = viewModels.getDetailTvShow();
                adapter.setTvShow(models);
                initializePopulate(String.valueOf(viewModels.getId()));
            }
        }
    }
    private void initializePopulate(String id){
        TvShowModels models = DummyData.getTvShow(id);
        assert models != null;
        Glide.with(getApplicationContext())
                .load(DummyData.baseImageUrl + models.getBackdrop_path())
                .error(R.drawable.ic_broken_image_black)
                .into(ivPoster);
        title.setText(models.getName());
        releaseDate.setText(models.getFirst_air_date());
        overview.setText(models.getOverview());
    }
}
