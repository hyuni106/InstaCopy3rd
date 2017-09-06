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
import kr.co.tjeit.instacopyproject3rd.adapter.WriteAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by ziO on 2017-09-06.
 */

public class WriteGalleryFragment extends Fragment {

    WriteAdapter mAdapter;
    List<Post> postList = new ArrayList<>();
    private android.widget.ListView galleryListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_gallery_item, container, false);
        this.galleryListView = (ListView) v.findViewById(R.id.galleryListView);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }


    private void setValuse() {
        mAdapter = new WriteAdapter(getActivity(), postList);
        galleryListView.setAdapter(mAdapter);

    }

    private void setupEvents() {

    }
}
