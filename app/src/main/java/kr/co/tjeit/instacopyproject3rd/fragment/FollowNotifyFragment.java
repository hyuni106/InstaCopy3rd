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
import kr.co.tjeit.instacopyproject3rd.adapter.FollowNotifyAdatper;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by suhyu on 2017-09-06.
 */

public class FollowNotifyFragment extends Fragment {
    FollowNotifyAdatper followNotifyAdatper;
    List<Post> followerLikePost = new ArrayList<>();
    private android.widget.ListView followerNotiListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_follow_notify, container, false);
        this.followerNotiListView = (ListView) v.findViewById(R.id.followerNotiListView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        followNotifyAdatper = new FollowNotifyAdatper(getActivity(), followerLikePost);
        followerNotiListView.setAdapter(followNotifyAdatper);
    }

    private void setupEvents() {

    }
}
