package kr.co.tjeit.instacopyproject3rd.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.SearchPlacesAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Place;

/**
 * Created by the on 2017-09-05.
 */

public class SearchPlacesFragment extends Fragment {
    private android.widget.LinearLayout nearPlaceLayout;
    private ListView placeListView;

    SearchPlacesAdapter mAdapter;
    List<Place> placeList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_places, container, false);
        this.placeListView = (ListView) v.findViewById(R.id.placeListView);
        this.nearPlaceLayout = (LinearLayout) v.findViewById(R.id.nearPlaceLayout);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setValuse() {
        mAdapter = new SearchPlacesAdapter(getActivity(), placeList);
        placeListView.setAdapter(mAdapter);
    }

    private void setupEvents() {

    }
}
