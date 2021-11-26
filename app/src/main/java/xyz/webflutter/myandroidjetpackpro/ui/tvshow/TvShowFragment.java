package xyz.webflutter.myandroidjetpackpro.ui.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import xyz.webflutter.myandroidjetpackpro.R;
import xyz.webflutter.myandroidjetpackpro.adapter.TvShowAdapter;

public class TvShowFragment extends Fragment {

    private RecyclerView rvTvShow;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tv_show, container, false);
        rvTvShow = root.findViewById(R.id.rv_tv_show);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getActivity() != null){
            TvShowViewModel tvShowViewModel = ViewModelProviders.of(this).get(TvShowViewModel.class);
            List<TvShowModels> tvModels = tvShowViewModel.getTvShow();
            TvShowAdapter adapter = new TvShowAdapter(getActivity());
            adapter.setTvShow(tvModels);
            rvTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            rvTvShow.setHasFixedSize(true);
            rvTvShow.setAdapter(adapter);
        }
    }
}