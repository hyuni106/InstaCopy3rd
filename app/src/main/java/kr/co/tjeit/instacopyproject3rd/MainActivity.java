package kr.co.tjeit.instacopyproject3rd;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kr.co.tjeit.instacopyproject3rd.data.Post;
import kr.co.tjeit.instacopyproject3rd.util.GlobalData;
import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;

public class MainActivity extends BaseActivity {
    public static MainActivity act;

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
    private android.widget.LinearLayout newsfeedLayout;
    private android.widget.LinearLayout searchLayout;
    private android.widget.LinearLayout writeLayout;
    private android.widget.LinearLayout notifyLayout;
    private android.widget.LinearLayout myProfileLayout;
    private ListView newsfeedListView;

    private boolean pmOk = false;
    private LinearLayout searchMainLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        act = this;
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

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            Toast.makeText(mContext, "한 번 더 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void setupEvents() {

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
                initLayout();
//                하단 탭 클릭에 따른 화면 전환
                switch (v.getId()) {
                    case R.id.newsfeedBtn:
                            newsfeedLayout.setVisibility(View.VISIBLE);
                            newsfeedBtn.setImageResource(R.drawable.newsfeed_on);
                        break;
                    case R.id.searchBtn:
                        searchMainLayout.setVisibility(View.VISIBLE);
                        searchBtn.setImageResource(R.drawable.search_on);
                        break;
                    case R.id.writeBtn:
                        writeLayout.setVisibility(View.VISIBLE);
                        break;
                    case R.id.notifyBtn:
                        notifyLayout.setVisibility(View.VISIBLE);
                        notifyBtn.setImageResource(R.drawable.notify_on);
                        break;
                    case R.id.myprofileBtn:
                        myProfileLayout.setVisibility(View.VISIBLE);
                        myprofileBtn.setImageResource(R.drawable.myprofile_fill);
                        break;

                }
                // writeBtn 이 눌렸을 경우에만 최상단 프레임레이아웃 감춰줌
                if (v.getId() == writeBtn.getId()) {
                    titleFramLayout.setVisibility(View.GONE);
                } else {
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

    public void initLayout() {
        newsfeedLayout.setVisibility(View.GONE);
        searchMainLayout.setVisibility(View.GONE);
        searchLayout.setVisibility(View.GONE);
        writeLayout.setVisibility(View.GONE);
        notifyLayout.setVisibility(View.GONE);
        myProfileLayout.setVisibility(View.GONE);
    }

    @Override
    public void setValues() {

        if (pmOk = false) {
            PermissionListener permissionlistener = new PermissionListener() {
                @Override
                public void onPermissionGranted() {
                    Toast.makeText(MainActivity.this, "권한 허가", Toast.LENGTH_SHORT).show();
                    pmOk = true;
                }

                @Override
                public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                    Toast.makeText(MainActivity.this, "권한이 거부되었습니다.\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                    pmOk = false;
                }
            };

            TedPermission.with(mContext)
                    .setPermissionListener(permissionlistener)
                    .setDeniedMessage("카메라와 저장 폴더에 접근하려면 설정에서 접근 권한을 ON으로 설정해 주세요.")
                    .setPermissions(Manifest.permission.READ_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION)
                    .check();
        }

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
        this.myProfileLayout = (LinearLayout) findViewById(R.id.myProfileLayout);
        this.notifyLayout = (LinearLayout) findViewById(R.id.notifyLayout);
        this.writeLayout = (LinearLayout) findViewById(R.id.writeLayout);
        this.searchLayout = (LinearLayout) findViewById(R.id.searchLayout);
        this.searchMainLayout = (LinearLayout) findViewById(R.id.searchMainLayout);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.titleFramLayout = (FrameLayout) findViewById(R.id.titleFramLayout);
        this.messengerBtn = (ImageView) findViewById(R.id.messengerBtn);
        this.titleImg = (ImageView) findViewById(R.id.titleImg);
        this.cameraBtn = (ImageView) findViewById(R.id.cameraBtn);
    }
}


