package kr.co.tjeit.instacopyproject3rd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.adapter.NewsfeedAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;
import kr.co.tjeit.instacopyproject3rd.data.User;

public class MainActivity extends BaseActivity {

    List<Post> postingDataList = new ArrayList<>();
    NewsfeedAdapter mNewsfeedAdapter;
    private android.widget.ImageView titleImg;
    private android.widget.ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;
    private android.widget.LinearLayout activityLayout;
    private android.widget.ListView myPostListView;
    private android.widget.LinearLayout myProfileLayout;
    private android.widget.ImageView tabBtn1;
    private android.widget.ImageView tabBtn2;
    private android.widget.ImageView tabBtn3;
    private android.widget.ImageView tabBtn4;
    private android.widget.ImageView tabBtn5;


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


    }

    @Override
    public void setValues() {
        mNewsfeedAdapter = new NewsfeedAdapter(mContext, postingDataList);
        newsfeedListView.setAdapter(mNewsfeedAdapter);
    }

    @Override
    public void bindViews() {
        this.tabBtn5 = (ImageView) findViewById(R.id.tabBtn5);
        this.tabBtn4 = (ImageView) findViewById(R.id.tabBtn4);
        this.tabBtn3 = (ImageView) findViewById(R.id.tabBtn3);
        this.tabBtn2 = (ImageView) findViewById(R.id.tabBtn2);
        this.tabBtn1 = (ImageView) findViewById(R.id.tabBtn1);
        this.myProfileLayout = (LinearLayout) findViewById(R.id.myProfileLayout);
        this.myPostListView = (ListView) findViewById(R.id.myPostListView);
        this.activityLayout = (LinearLayout) findViewById(R.id.activityLayout);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.newsfeedListView = (ListView) findViewById(R.id.newsfeedListView);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);
    }
}


