package kr.co.tjeit.instacopyproject3rd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.GreedPictureAdapter;
import kr.co.tjeit.instacopyproject3rd.adapter.NewsfeedAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by the on 2017-09-06.
 */

public class MyprofileFragment extends Fragment {

    private ImageView userProfileImg;
    private TextView userNameTxt;
    private TextView uploadCountTxt;
    private TextView followerTxt;
    private TextView followingTxt;
    private Button ProfileBtn;
    private ImageView tab1Btn;
    private ImageView tab2Btn;
    private ImageView tab3Btn;
    private ImageView tab4Btn;
    private ListView myPicherListView;
    private LinearLayout tab1Layout;
    private ListView myPicNewsfeedListView;
    private LinearLayout tab2Layout;

    List<Post> myPostList = new ArrayList<>();
    NewsfeedAdapter newsfeedAdapter;
    GreedPictureAdapter greedPictureAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myprofile, container, false);
        this.tab2Layout = (LinearLayout) v.findViewById(R.id.tab2Layout);
        this.myPicNewsfeedListView = (ListView) v.findViewById(R.id.myPicNewsfeedListView);
        this.tab1Layout = (LinearLayout) v.findViewById(R.id.tab1Layout);
        this.myPicherListView = (ListView) v.findViewById(R.id.myPicherListView);
        this.tab4Btn = (ImageView) v.findViewById(R.id.tab4Btn);
        this.tab3Btn = (ImageView) v.findViewById(R.id.tab3Btn);
        this.tab2Btn = (ImageView) v.findViewById(R.id.tab2Btn);
        this.tab1Btn = (ImageView) v.findViewById(R.id.tab1Btn);
        this.ProfileBtn = (Button) v.findViewById(R.id.ProfileBtn);
        this.followingTxt = (TextView) v.findViewById(R.id.followingTxt);
        this.followerTxt = (TextView) v.findViewById(R.id.followerTxt);
        this.uploadCountTxt = (TextView) v.findViewById(R.id.uploadCountTxt);
        this.userNameTxt = (TextView) v.findViewById(R.id.userNameTxt);
        this.userProfileImg = (ImageView) v.findViewById(R.id.userProfileImg);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setValuse() {
        greedPictureAdapter = new GreedPictureAdapter(getActivity(), myPostList);
        myPicherListView.setAdapter(greedPictureAdapter);

        newsfeedAdapter = new NewsfeedAdapter(getActivity(), myPostList);
        myPicNewsfeedListView.setAdapter(newsfeedAdapter);
    }

    public void settingVisible() {
        tab1Layout.setVisibility(View.INVISIBLE);
        tab2Layout.setVisibility(View.INVISIBLE);
    }

    private void setupEvents() {
        View.OnClickListener tabClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingVisible();
                if (v.getId() == R.id.tab1Btn) {
                    tab1Layout.setVisibility(View.VISIBLE);
                } else if (v.getId() == R.id.tab2Btn) {
                    tab2Layout.setVisibility(View.VISIBLE);
                }
            }
        };

        tab1Btn.setOnClickListener(tabClick);
        tab2Btn.setOnClickListener(tabClick);
    }

}
