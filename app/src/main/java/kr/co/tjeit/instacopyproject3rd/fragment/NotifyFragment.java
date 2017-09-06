package kr.co.tjeit.instacopyproject3rd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.NotifyAdatper;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by the on 2017-09-06.
 */

public class NotifyFragment extends Fragment {

    NotifyAdatper mAdapter;
    List<Post> postList = new ArrayList<>();
    private ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;
    private ListView myNotiListView;
    private LinearLayout notifyLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notify_item, container, false);
        this.notifyLayout = (LinearLayout) v.findViewById(R.id.notifyLayout);
        this.myNotiListView = (ListView) v.findViewById(R.id.myNotiListView);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setValuse() {
        mAdapter = new NotifyAdatper(getActivity(), postList);
//        TODO - 메인화면에서 search 아이콘 클릭시 뻥하고 터짐..
//        userListView.setAdapter(mAdapter);

    }

    private void setupEvents() {

    }
}
