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
import kr.co.tjeit.instacopyproject3rd.adapter.MyprofileAdapter;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-06.
 */

public class MyprofileFragment extends Fragment {
    MyprofileAdapter mAdapter;
    List<User> postList = new ArrayList<>();
    private ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;
    private ListView myprofileListView;
    private android.widget.ImageView userProfileImg;
    private android.widget.TextView userNameTxt;
    private android.widget.TextView uploadCountTxt;
    private android.widget.TextView followerTxt;
    private android.widget.TextView followingTxt;
    private android.widget.Button ProfileBtn;
    private android.widget.ImageView tab1Btn;
    private android.widget.ImageView tab2Btn;
    private android.widget.ImageView tab3Btn;
    private android.widget.ImageView tab4Btn;
    private ListView myPicherListView;
    private android.widget.LinearLayout tab1Layout;
    private android.widget.ImageView myProfileMiniImg;
    private android.widget.ImageView seeMoreBtn;
    private android.widget.ImageView myUploadImg;
    private android.widget.ImageView likeImg;
    private android.widget.ImageView replyBtnImg;
    private android.widget.ImageView messengersendbutton;
    private android.widget.ImageView mySaveImg;
    private android.widget.TextView contentTxt;
    private android.widget.LinearLayout tab2Layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myprofile, container, false);
        this.tab2Layout = (LinearLayout) v.findViewById(R.id.tab2Layout);
        this.contentTxt = (TextView) v.findViewById(R.id.contentTxt);
        this.mySaveImg = (ImageView) v.findViewById(R.id.mySaveImg);
        this.messengersendbutton = (ImageView) v.findViewById(R.id.messenger_send_button);
        this.replyBtnImg = (ImageView) v.findViewById(R.id.replyBtnImg);
        this.likeImg = (ImageView) v.findViewById(R.id.likeImg);
        this.myUploadImg = (ImageView) v.findViewById(R.id.myUploadImg);
        this.seeMoreBtn = (ImageView) v.findViewById(R.id.seeMoreBtn);
        this.myProfileMiniImg = (ImageView) v.findViewById(R.id.myProfileMiniImg);
//        this.tab1Layout = (LinearLayout) v.findViewById(R.id.tab1Layout);
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
        mAdapter = new MyprofileAdapter(getActivity(), postList);
        myPicherListView.setAdapter(mAdapter);

    }

    private void setupEvents() {

        View.OnClickListener imageSetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.tab1Btn) {

                    myPicherListView.setVisibility(View.VISIBLE);

                } else if (v.getId() == R.id.tab2Btn) {


                } else if (v.getId() == R.id.tab3Btn) {


                }
            }
        };


    }

}
