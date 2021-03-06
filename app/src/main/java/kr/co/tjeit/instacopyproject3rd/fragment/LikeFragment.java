package kr.co.tjeit.instacopyproject3rd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.FollowingAdapter;
import kr.co.tjeit.instacopyproject3rd.adapter.MyPostNotifyAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Like;

/**
 * Created by the on 2017-09-05.
 */

public class LikeFragment extends Fragment {

    ListView followingListView;
    ListView myPostListView;

    FollowingAdapter followingAdapter;
    MyPostNotifyAdapter myPostNotifyAdapter;
    List<Like> likeList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_like, container, false);
        followingListView = (ListView) v.findViewById(R.id.followingListView);
        myPostListView = (ListView) v.findViewById(R.id.myPostListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        followingAdapter = new FollowingAdapter(getActivity(), likeList);
        followingListView.setAdapter(followingAdapter);
    }

    private void setupEvents() {

    }
}
