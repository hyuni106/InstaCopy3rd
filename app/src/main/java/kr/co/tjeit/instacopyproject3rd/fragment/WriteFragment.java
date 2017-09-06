package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.WriteAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by the on 2017-09-06.
 */

public class WriteFragment extends Fragment {

    WriteAdapter mAdapter;
    List<Post> postList = new ArrayList<>();
    private LinearLayout tab1;
    private LinearLayout tab2;
    private LinearLayout tab3;
    private FrameLayout tabcontent;
    private TabWidget tabs;
    private TabHost tabHost;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_item, container, false);
        this.tabHost = (TabHost) v.findViewById(R.id.tabHost);
        this.tabs = (TabWidget) v.findViewById(android.R.id.tabs);
        this.tabcontent = (FrameLayout) v.findViewById(android.R.id.tabcontent);
        this.tab3 = (LinearLayout) v.findViewById(R.id.tab3);
        this.tab2 = (LinearLayout) v.findViewById(R.id.tab2);
        this.tab1 = (LinearLayout) v.findViewById(R.id.tab1);


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
        TabHost.TabSpec ts1 = tabHost.newTabSpec("tab1").setIndicator("갤러리");
        ts1.setContent(R.id.tab1);
        tabHost.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("tab2").setIndicator("사진");
        ts2.setContent(R.id.tab2);
        tabHost.addTab(ts2);

        TabHost.TabSpec ts3 = tabHost.newTabSpec("tab3").setIndicator("동영상");
        ts3.setContent(R.id.tab3);
        tabHost.addTab(ts3);

    }

    private void setValuse() {
        mAdapter = new WriteAdapter(getActivity(), postList);
//        TODO - 메인화면에서 search 아이콘 클릭시 뻥하고 터짐..
//        userListView.setAdapter(mAdapter);

    }

    private void setupEvents() {




    }
}
