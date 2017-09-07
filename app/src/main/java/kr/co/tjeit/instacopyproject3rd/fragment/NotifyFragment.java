package kr.co.tjeit.instacopyproject3rd.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.FollowNotifyAdatper;
import kr.co.tjeit.instacopyproject3rd.adapter.WriteAdapter;

/**
 * Created by the on 2017-09-06.
 */

public class NotifyFragment extends Fragment {



    private TextView followerTxt;
    private TextView followerSelectLine;
    private LinearLayout followerLayout;
    private TextView youTxt;
    private TextView youSelectLine;
    private LinearLayout youLayout;
    private android.support.v4.view.ViewPager mainViewPager;
    private LinearLayout notificationLayout;
    private android.widget.TabWidget tabs;
    private LinearLayout tab1;
    private LinearLayout tab2;
    private android.widget.FrameLayout tabcontent;
    private TabHost tabHost;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notify_item, container, false);
        this.tabHost = (TabHost) v.findViewById(R.id.tabHost);
        this.notificationLayout = (LinearLayout) v.findViewById(R.id.notificationLayout);
        this.mainViewPager = (ViewPager) v.findViewById(R.id.mainViewPager);
        this.tabcontent = (FrameLayout) v.findViewById(android.R.id.tabcontent);
        this.tab2 = (LinearLayout) v.findViewById(R.id.tab2);
        this.tab1 = (LinearLayout) v.findViewById(R.id.tab1);
        this.tabs = (TabWidget) v.findViewById(android.R.id.tabs);


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
        TabHost.TabSpec ts1 = tabHost.newTabSpec("tab1").setIndicator("FOLLOWERS");
        ts1.setContent(R.id.tab1);
        tabHost.addTab(ts1);

        TabHost.TabSpec ts2 = tabHost.newTabSpec("tab2").setIndicator("YOU");
        ts2.setContent(R.id.tab2);
        tabHost.addTab(ts2);


    }


    private void setValuse() {

        mainViewPager.setAdapter(new MyViewPagerAdapter(getChildFragmentManager()));
    }

    private void setupEvents() {


        View.OnClickListener pageChangeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pageNum = Integer.parseInt(v.getTag().toString());
                mainViewPager.setCurrentItem(pageNum);

            }
        };

        tab1.setOnClickListener(pageChangeListener);
        tab2.setOnClickListener(pageChangeListener);

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // 선택된 탭으로 이동
                tabHost.setCurrentTab(position);

            }
//
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {
        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FollowNotifyFragment();
            } else {
                return new MyPostNotifyFragment();
            }
        }
    }
}
