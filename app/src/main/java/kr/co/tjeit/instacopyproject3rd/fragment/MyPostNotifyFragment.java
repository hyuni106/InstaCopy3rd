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
import kr.co.tjeit.instacopyproject3rd.adapter.MyPostNotifyAdapter;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by suhyu on 2017-09-06.
 */

public class MyPostNotifyFragment extends Fragment {

    private android.widget.ListView myPostNotiListView;
    MyPostNotifyAdapter myPostNotifyAdapter;
    List<User> followUser = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_post_notify, container, false);
        this.myPostNotiListView = (ListView) v.findViewById(R.id.myPostNotiListView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        myPostNotifyAdapter = new MyPostNotifyAdapter(getActivity(), followUser);
        myPostNotiListView.setAdapter(myPostNotifyAdapter);
    }

    private void setupEvents() {

    }
}
