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
import kr.co.tjeit.instacopyproject3rd.adapter.SearchPeopleAdapter;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-05.
 */

public class SearchPeopleFragment extends Fragment {
    private android.widget.ListView userListView;
    SearchPeopleAdapter mAdapter;
    List<User> userList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_people, container, false);
        this.userListView = (ListView) v.findViewById(R.id.userListView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setValuse() {
        mAdapter = new SearchPeopleAdapter(getActivity(), userList);
//        TODO - 메인화면에서 search 아이콘 클릭시 뻥하고 터짐..
//        userListView.setAdapter(mAdapter);

    }

    private void setupEvents() {

    }
}
