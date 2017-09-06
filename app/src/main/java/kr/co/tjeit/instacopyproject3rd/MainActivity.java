package kr.co.tjeit.instacopyproject3rd;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

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


                    newsfeedBtn.setImageResource(R.drawable.newsfeed_on);
                    searchBtn.setImageResource(R.drawable.search_off);
                    writeBtn.setImageResource(R.drawable.write);
                    notifyBtn.setImageResource(R.drawable.notify_off);
                    myprofileBtn.setImageResource(R.drawable.profile_off);

                } else if (v.getId() == R.id.searchBtn) {

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
        this.writeLayout = (LinearLayout) findViewById(R.id.writeLayout);
        this.myNotiListView = (ListView) findViewById(R.id.myNotiListView);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.newsfeedListView = (ListView) findViewById(R.id.newsfeedListView);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);

    }
}


