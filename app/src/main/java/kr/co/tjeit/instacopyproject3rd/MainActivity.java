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
    private ListView writeListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();

    }



    @Override
    public void setupEvents() {


        View.OnClickListener imageBtnView = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v.getId() == R.id.newsfeedBtn) {


                    newsfeedLayout.setVisibility(View.VISIBLE);
                    searchLayout.setVisibility(View.GONE);
                    writeLayout.setVisibility(View.GONE);
                    notifyLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.GONE);


                    newsfeedBtn.setImageResource(R.drawable.newsfeed_on);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.searchBtn) {

                    titleFramLayout.setVisibility(View.GONE); // 검색화면의 경우 상단에 프레임레이아웃 사라짐 (실질적으로 이 프레임 레이아웃은 뉴스피드 페이지에서만 나옴(main))
                    newsfeedLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.VISIBLE);
                    writeLayout.setVisibility(View.GONE);
                    notifyLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.GONE);

                    newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
                    searchBtn.setImageResource(R.drawable.search_on);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.writeBtn) {

                    titleFramLayout.setVisibility(View.GONE);
                    newsfeedLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.GONE);
                    writeLayout.setVisibility(View.VISIBLE);
                    notifyLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.GONE);

                    newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.notifyBtn) {

                    titleFramLayout.setVisibility(View.GONE);
                    newsfeedLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.GONE);
                    writeLayout.setVisibility(View.GONE);
                    notifyLayout.setVisibility(View.VISIBLE);
                    myProfileLayout.setVisibility(View.GONE);

                    newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_on);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.myprofileBtn) {

                    titleFramLayout.setVisibility(View.GONE);
                    newsfeedLayout.setVisibility(View.GONE);
                    searchLayout.setVisibility(View.GONE);
                    writeLayout.setVisibility(View.GONE);
                    notifyLayout.setVisibility(View.GONE);
                    myProfileLayout.setVisibility(View.VISIBLE);

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
        this.writeLayout = (LinearLayout) findViewById(R.id.writeLayout);
        this.writeListView = (ListView) findViewById(R.id.writeListView);
        this.titleFramLayout = (FrameLayout) findViewById(R.id.titleFramLayout);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);

    }
}


