package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.WriteAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by the on 2017-09-06.
 */

public class WriteFragment extends Fragment {

//    binding에 필요한 변수
    private LinearLayout tab1;
    private LinearLayout tab2;
    private LinearLayout tab3;
    private FrameLayout tabcontent;
    private TabWidget tabs;
    private TabHost tabHost;
    private android.widget.TextView menuTxt;
    private FrameLayout titleFramLayout;
    private android.support.v4.view.ViewPager mainViewPager;

    WriteAdapter mAdapter;
    List<Post> postList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_item, container, false);
//        binding
        this.mainViewPager = (ViewPager) v.findViewById(R.id.mainViewPager);
        this.titleFramLayout = (FrameLayout) v.findViewById(R.id.titleFramLayout);
        this.menuTxt = (TextView) v.findViewById(R.id.menuTxt);
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


    private void setupEvents() {
//        탭의 태그를 받아와 ViewPager의 페이지 변경
        View.OnClickListener pageChangeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pageNum = Integer.parseInt(v.getTag().toString());
                mainViewPager.setCurrentItem(pageNum);

            }
        };

        tab1.setOnClickListener(pageChangeListener);
        tab2.setOnClickListener(pageChangeListener);
        tab3.setOnClickListener(pageChangeListener);

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                // 선택된 탭으로 이동
                tabHost.setCurrentTab(position);

                if (position == 0) {
                    menuTxt.setText("갤러리");
                } else if (position == 1) {
                    menuTxt.setText("사진");
//                    카메라 화면 실행
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                } else if (position == 2) {
                    menuTxt.setText("동영상");
//                    카메라 동영상 촬영 화면 실행
                    Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                    startActivity(intent);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setValuse() {
        mainViewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));

    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Fragment getItem(int position) {

            if (position == 0) {

                return new WritePostFragment();
            } else if (position == 1)
                return new MyprofileFragment();
            else {
                return new MyprofileFragment();
            }
        }
    }

}
