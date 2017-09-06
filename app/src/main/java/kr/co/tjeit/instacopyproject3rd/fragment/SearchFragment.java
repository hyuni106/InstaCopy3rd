package kr.co.tjeit.instacopyproject3rd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.SearchAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Place;

/**
 * Created by the on 2017-09-06.
 */

public class SearchFragment extends Fragment {

    SearchAdapter mAdapter;
    List<Place> searchList = new ArrayList<>();
    private ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;
    private android.widget.ImageView backBtn;
    private android.widget.EditText searchEdt;
    private android.widget.TabWidget tabs;
    private LinearLayout tab1;
    private LinearLayout tab2;
    private LinearLayout tab3;
    private LinearLayout tab4;
    private android.widget.FrameLayout tabcontent;
    private android.widget.TabHost tabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_item, container, false);
        this.tabHost = (TabHost) v.findViewById(R.id.tabHost);
        this.tabcontent = (FrameLayout) v.findViewById(android.R.id.tabcontent);
        this.tab4 = (LinearLayout) v.findViewById(R.id.tab4);
        this.tab3 = (LinearLayout) v.findViewById(R.id.tab3);
        this.tab2 = (LinearLayout) v.findViewById(R.id.tab2);
        this.tab1 = (LinearLayout) v.findViewById(R.id.tab1);
        this.tabs = (TabWidget) v.findViewById(android.R.id.tabs);
        this.searchEdt = (EditText) v.findViewById(R.id.searchEdt);
        this.backBtn = (ImageView) v.findViewById(R.id.backBtn);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setValuse() {
        mAdapter = new SearchAdapter(getActivity(), searchList);
//        TODO - 메인화면에서 search 아이콘 클릭시 뻥하고 터짐..
//        userListView.setAdapter(mAdapter);

    }

    private void setupEvents() {

    }


}
