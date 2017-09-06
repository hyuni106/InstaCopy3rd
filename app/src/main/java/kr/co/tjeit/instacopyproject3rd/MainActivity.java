package kr.co.tjeit.instacopyproject3rd;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import kr.co.tjeit.instacopyproject3rd.fragment.MyprofileFragment;
import kr.co.tjeit.instacopyproject3rd.fragment.NewsfeedFragment;
import kr.co.tjeit.instacopyproject3rd.fragment.NotifyFragment;
import kr.co.tjeit.instacopyproject3rd.fragment.SearchFragment;

// 힝..

public class MainActivity extends BaseActivity {

    private android.widget.ImageView titleImg;
    private android.widget.FrameLayout titleFramLayout;
    private android.support.v4.view.ViewPager mainViewPager;
    private android.widget.ImageView newsfeedBtn;
    private android.widget.ImageView searchBtn;
    private android.widget.ImageView writeBtn;
    private android.widget.ImageView notifyBtn;
    private android.widget.ImageView myprofileBtn;
    private FrameLayout fragFrame;

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
        View.OnClickListener fragView = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.newsfeedBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new NewsfeedFragment())
                                .commit();
                        break;
                    case R.id.searchBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new SearchFragment())
                                .commit();
                        break;
                    case R.id.notifyBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new NotifyFragment())
                                .commit();
                        break;
                    case R.id.myprofileBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new MyprofileFragment())
                                .commit();
                        break;
                }
            }
        };

        newsfeedBtn.setOnClickListener(fragView);
        searchBtn.setOnClickListener(fragView);
        notifyBtn.setOnClickListener(fragView);
        myprofileBtn.setOnClickListener(fragView);

    }

    @Override
    public void setValues() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragFrame, new NewsfeedFragment())
                .commit();
    }

    @Override
    public void bindViews() {
        this.myprofileBtn = (ImageView) findViewById(R.id.myprofileBtn);
        this.notifyBtn = (ImageView) findViewById(R.id.notifyBtn);
        this.writeBtn = (ImageView) findViewById(R.id.writeBtn);
        this.searchBtn = (ImageView) findViewById(R.id.searchBtn);
        this.newsfeedBtn = (ImageView) findViewById(R.id.newsfeedBtn);
        this.fragFrame = (FrameLayout) findViewById(R.id.fragFrame);
        this.titleFramLayout = (FrameLayout) findViewById(R.id.titleFramLayout);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);
    }
}


