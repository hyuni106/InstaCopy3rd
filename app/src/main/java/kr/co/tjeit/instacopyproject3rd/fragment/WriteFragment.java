package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
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
    private android.support.design.widget.TabLayout mTab;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_item, container, false);
//        binding
        this.mainViewPager = (ViewPager) v.findViewById(R.id.mainViewPager);
        this.titleFramLayout = (FrameLayout) v.findViewById(R.id.titleFramLayout);
        this.menuTxt = (TextView) v.findViewById(R.id.menuTxt);
        this.mTab = (TabLayout) v.findViewById(R.id.mTab);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setupEvents() {
        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    menuTxt.setText("갤러리");
                } else if (position == 1) {
                    menuTxt.setText("사진");
//                    카메라 화면 실행
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(intent, 1);
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
        mTab.setupWithViewPager(mainViewPager);
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
                return new CameraFragment();
            else {
                return new VideoFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "갤러리";
                case 1:
                    return "사진";
                case 2:
                    return "동영상";
                default:
                    return null;
            }
        }
    }

}
