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
        makeTabHost();
        setupEvents();
        setValuse();
    }

    private void makeTabHost() {
        // 탭호스트를 사용하기 위해서는 반드시 setup을 먼저 진행해야함
        tabHost.setup();

        // 탭에 들어가는 버튼(tabspec)을 생성하는 작업
        // 구별자(tab1), 표시(지역) 세팅
        TabHost.TabSpec ts1 = tabHost.newTabSpec("tab1").setIndicator("인기 검색 결과");
        ts1.setContent(R.id.tab1);
        tabHost.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("tab2").setIndicator("사람");
        ts2.setContent(R.id.tab2);
        tabHost.addTab(ts2);

        TabHost.TabSpec ts3 = tabHost.newTabSpec("tab3").setIndicator("태그");
        ts3.setContent(R.id.tab3);
        tabHost.addTab(ts3);

        TabHost.TabSpec ts4 = tabHost.newTabSpec("tab4").setIndicator("장소");
        ts4.setContent(R.id.tab4);
        tabHost.addTab(ts4);
    }

    private void setValuse() {

    }

    private void setupEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                searchEdt.setText("");
                switch (tabId) {
                    case "tab1":
                        searchEdt.setHint("검색");
                        break;
                    case "tab2":
                        searchEdt.setHint("사람 검색");
                        break;
                    case "tab3":
                        searchEdt.setHint("해시태그 검색");
                        break;
                    case "tab4":
                        searchEdt.setHint("장소 검색");
                        break;
                }
            }
        });
    }
}
