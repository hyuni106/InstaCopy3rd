package kr.co.tjeit.instacopyproject3rd.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.SearchTagsAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Tag;

/**
 * Created by the on 2017-09-05.
 */

public class SearchTagsFragment extends Fragment {
    private ListView tagListView;
    SearchTagsAdapter mAdapter;
    List<Tag> tagList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_tags, container, false);
        this.tagListView = (ListView) v.findViewById(R.id.tagListView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        mAdapter = new SearchTagsAdapter(getActivity(), tagList);
        tagListView.setAdapter(mAdapter);
    }

    private void setupEvents() {

    }
}
