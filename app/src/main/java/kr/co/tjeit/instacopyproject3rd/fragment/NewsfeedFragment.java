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
import kr.co.tjeit.instacopyproject3rd.adapter.NewsfeedAdapter;
import kr.co.tjeit.instacopyproject3rd.adapter.SearchPeopleAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-06.
 */

public class NewsfeedFragment extends Fragment {

    NewsfeedAdapter mAdapter;
    List<Post> postList = new ArrayList<>();
    private ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newsfeed_item, container, false);
        this.newsfeedListView = (ListView) v.findViewById(R.id.newsfeedListView);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setValuse() {
        mAdapter = new NewsfeedAdapter(getActivity(), postList);
//        TODO - 메인화면에서 search 아이콘 클릭시 뻥하고 터짐..
//        userListView.setAdapter(mAdapter);

    }

    private void setupEvents() {

    }

}
