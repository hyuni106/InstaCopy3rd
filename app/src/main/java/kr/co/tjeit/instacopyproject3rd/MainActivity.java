package kr.co.tjeit.instacopyproject3rd;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

import kr.co.tjeit.instacopyproject3rd.fragment.MyprofileFragment;
import kr.co.tjeit.instacopyproject3rd.fragment.NewsfeedFragment;
import kr.co.tjeit.instacopyproject3rd.fragment.NotifyFragment;
import kr.co.tjeit.instacopyproject3rd.fragment.SearchFragment;
import kr.co.tjeit.instacopyproject3rd.fragment.WriteFragment;

public class MainActivity extends BaseActivity {

    private static final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    //    binding에 필요한 변수
    private android.widget.ImageView titleImg;
    private android.widget.FrameLayout titleFramLayout;
    private android.support.v4.view.ViewPager mainViewPager;
    private android.widget.ImageView newsfeedBtn;
    private android.widget.ImageView searchBtn;
    private android.widget.ImageView writeBtn;
    private android.widget.ImageView notifyBtn;
    private android.widget.ImageView myprofileBtn;
    private FrameLayout fragFrame;
    private ImageView cameraBtn;
    private ImageView messengerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    PermissionListener permissionlistener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(mContext, "권한 허가", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(mContext, "권한 거부\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
        }


    };



    @Override
    public void onBackPressed() {

        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(mContext, "한 번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void setupEvents() {

        

//       메인 상단 왼쪽 카메카 버튼 클릭시 카메라 열림 기능
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        View.OnClickListener fragView = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initIcon();
//                하단 탭 클릭에 따른 화면 전환
                switch (v.getId()) {
                    case R.id.newsfeedBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new NewsfeedFragment())
                                .commit();
                        newsfeedBtn.setImageResource(R.drawable.newsfeed_on);
                        break;
                    case R.id.searchBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new SearchFragment())
                                .commit();
                        searchBtn.setImageResource(R.drawable.search_on);
                        break;
                    case R.id.writeBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new WriteFragment())
                                .commit();
                        break;
                    case R.id.notifyBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new NotifyFragment())
                                .commit();
                        notifyBtn.setImageResource(R.drawable.notify_on);
                        break;
                    case R.id.myprofileBtn:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragFrame, new MyprofileFragment())
                                .commit();
                        myprofileBtn.setImageResource(R.drawable.myprofile_fill);
                        break;

                }
                // writeBtn 이 눌렸을 경우에만 최상단 프레임레이아웃 감춰줌
                if (v.getId() == writeBtn.getId()) {
                    titleFramLayout.setVisibility(View.GONE);
                }
                else {
                    titleFramLayout.setVisibility(View.VISIBLE);
                }
            }
        };

        newsfeedBtn.setOnClickListener(fragView);
        searchBtn.setOnClickListener(fragView);
        writeBtn.setOnClickListener(fragView);
        notifyBtn.setOnClickListener(fragView);
        myprofileBtn.setOnClickListener(fragView);

    }

    public void initIcon() {
        newsfeedBtn.setImageResource(R.drawable.newsfeed_off);
        searchBtn.setImageResource(R.drawable.search_off);
        notifyBtn.setImageResource(R.drawable.notify_off);
        myprofileBtn.setImageResource(R.drawable.myprofile_empty);
    }

    @Override
    public void setValues() {
//        앱 실행 시 Newsfeed Fragment 화면 보여지게 설정
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragFrame, new NewsfeedFragment())
                .commit();

        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setRationaleMessage("구글 로그인을 하기 위해서는 주소록 접근 권한이 필요해요")
                .setDeniedMessage("왜 거부하셨어요...\n하지만 [설정] > [권한] 에서 권한을 허용할 수 있어요.")
                .setPermissions(Manifest.permission.READ_CONTACTS)
                .check();


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
        this.messengerBtn = (ImageView) findViewById(R.id.messengerBtn);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);
        this.cameraBtn = (ImageView) findViewById(R.id.cameraBtn);
    }
}


