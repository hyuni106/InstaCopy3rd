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
import kr.co.tjeit.instacopyproject3rd.adapter.SearchTagsAdapter;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-05.
 */

public class SearchTopFragment extends Fragment {
    private ListView userListView;
    private ListView resentSearchListView;

    List<User> recommendUserList = new ArrayList<>();

    SearchPeopleAdapter searchPeopleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_top, container, false);
        this.resentSearchListView = (ListView) v.findViewById(R.id.resentSearchListView);
        this.userListView = (ListView) v.findViewById(R.id.userListView);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValues();
    }

    private void setValues() {
        searchPeopleAdapter = new SearchPeopleAdapter(getActivity(), recommendUserList);
        userListView.setAdapter(searchPeopleAdapter);
    }

    private void setupEvents() {

    }
}
