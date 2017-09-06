package kr.co.tjeit.instacopyproject3rd;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.adapter.NewsfeedAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;

// 힝..

public class MainActivity extends BaseActivity {

    List<Post> postingDataList = new ArrayList<>();
    NewsfeedAdapter mNewsfeedAdapter;
    private android.widget.Button logoutBtn;
    private android.widget.ImageView titleImg;
    private android.widget.ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;
    private android.widget.LinearLayout activityLayout;
    private android.widget.ListView myPostListView;
    private android.widget.LinearLayout myProfileLayout;
    private ListView myNotiListView;
    private ImageView newsfeedBtn;
    private ImageView searchBtn;
    private ImageView writeBtn;
    private ImageView followBtn;
    private ImageView myprofileBtn;
    private LinearLayout writeLayout;
    private ImageView notifyBtn;
    private ImageView backBtn;
    private android.widget.EditText searchEdt;
    private android.widget.TabWidget tabs;
    private LinearLayout tab1;
    private LinearLayout tab2;
    private LinearLayout tab3;
    private LinearLayout tab4;
    private android.widget.FrameLayout tabcontent;
    private android.widget.TabHost tabHost;
    private LinearLayout searchLayout;
    private LinearLayout notifyLayout;
    private FrameLayout titleFramLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        makeTabHost();
        setupEvents();
        setValues();

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


    @Override
    public void setupEvents() {


        View.OnClickListener imageBtnView = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.newsfeedBtn) {


                    newsfeedLayout.setVisibility(View.VISIBLE);
                    searchLayout.setVisibility(View.GONE);


                    newsfeedBtn.setImageResource(R.drawable.newsfeed_on);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.searchBtn) {

                    titleFramLayout.setVisibility(View.GONE);
                    newsfeedLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);

                    newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
                    searchBtn.setImageResource(R.drawable.search_on);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.writeBtn) {

                    newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.notifyBtn) {

                    newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_on);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.myprofileBtn) {

                    newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_on);

                }


            }
        };

        newsfeedBtn.setOnClickListener(imageBtnView);
        searchBtn.setOnClickListener(imageBtnView);
        writeBtn.setOnClickListener(imageBtnView);
        notifyBtn.setOnClickListener(imageBtnView);
        myprofileBtn.setOnClickListener(imageBtnView);


    }

    @Override
    public void setValues() {
        mNewsfeedAdapter = new NewsfeedAdapter(mContext, postingDataList);
        newsfeedListView.setAdapter(mNewsfeedAdapter);
    }

    @Override
    public void bindViews() {
        this.myprofileBtn = (ImageView) findViewById(R.id.myprofileBtn);
        this.notifyBtn = (ImageView) findViewById(R.id.notifyBtn);
        this.writeBtn = (ImageView) findViewById(R.id.writeBtn);
        this.searchBtn = (ImageView) findViewById(R.id.searchBtn);
        this.newsfeedBtn = (ImageView) findViewById(R.id.newsfeedBtn);
        this.myProfileLayout = (LinearLayout) findViewById(R.id.myProfileLayout);
        this.myPostListView = (ListView) findViewById(R.id.myPostListView);
        this.notifyLayout = (LinearLayout) findViewById(R.id.notifyLayout);
        this.myNotiListView = (ListView) findViewById(R.id.myNotiListView);
        this.searchLayout = (LinearLayout) findViewById(R.id.searchLayout);
        this.tabHost = (TabHost) findViewById(R.id.tabHost);
        this.tabcontent = (FrameLayout) findViewById(android.R.id.tabcontent);
        this.tab4 = (LinearLayout) findViewById(R.id.tab4);
        this.tab3 = (LinearLayout) findViewById(R.id.tab3);
        this.tab2 = (LinearLayout) findViewById(R.id.tab2);
        this.tab1 = (LinearLayout) findViewById(R.id.tab1);
        this.tabs = (TabWidget) findViewById(android.R.id.tabs);
        this.searchEdt = (EditText) findViewById(R.id.searchEdt);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.newsfeedListView = (ListView) findViewById(R.id.newsfeedListView);
        this.titleFramLayout = (FrameLayout) findViewById(R.id.titleFramLayout);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);

    }
}


