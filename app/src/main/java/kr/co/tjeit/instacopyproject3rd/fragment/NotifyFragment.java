package kr.co.tjeit.instacopyproject3rd.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.FollowNotifyAdatper;
import kr.co.tjeit.instacopyproject3rd.adapter.MyPostNotifyAdapter;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notify_item, container, false);
        this.notificationLayout = (LinearLayout) v.findViewById(R.id.notificationLayout);
        this.mainViewPager = (ViewPager) v.findViewById(R.id.mainViewPager);
        this.youLayout = (LinearLayout) v.findViewById(R.id.youLayout);
        this.youSelectLine = (TextView) v.findViewById(R.id.youSelectLine);
        this.youTxt = (TextView) v.findViewById(R.id.youTxt);
        this.followerLayout = (LinearLayout) v.findViewById(R.id.followerLayout);
        this.followerSelectLine = (TextView) v.findViewById(R.id.followerSelectLine);
        this.followerTxt = (TextView) v.findViewById(R.id.followerTxt);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    @Override
    public void onResume() {
        super.onResume();
        setValuse();
    }

    private void setValuse() {
        mainViewPager.setAdapter(new MyViewPagerAdapter(getActivity().getSupportFragmentManager()));
        mainViewPager.setCurrentItem(1);
    }

    private void setupEvents() {
        youLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTxt.setTextColor(Color.parseColor("#125687"));
                followerTxt.setTextColor(Color.parseColor("#000000"));
                youSelectLine.setVisibility(View.VISIBLE);
                followerSelectLine.setVisibility(View.GONE);
                mainViewPager.setCurrentItem(1);
            }
        });

        followerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTxt.setTextColor(Color.parseColor("#000000"));
                followerTxt.setTextColor(Color.parseColor("#125687"));
                youSelectLine.setVisibility(View.GONE);
                followerSelectLine.setVisibility(View.VISIBLE);
                mainViewPager.setCurrentItem(0);
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
            if(position == 0) {
                return new FollowNotifyFragment();
            } else {
                return new MyPostNotifyFragment();
            }
        }
    }
}
