package kr.co.tjeit.instacopyproject3rd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject3rd.data.Post;
import kr.co.tjeit.instacopyproject3rd.data.User;
import kr.co.tjeit.instacopyproject3rd.util.ContextUtil;
import kr.co.tjeit.instacopyproject3rd.util.GlobalData;
import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;

public class LoginActivity extends BaseActivity {

    CallbackManager cm; // 페이스북 콜백매니저
    //    binding 필요한 변수
    private com.facebook.login.widget.LoginButton fbLoginBtn;
    private android.widget.Button loginBtn;
    private android.widget.TextView signupTxt;
    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private TextView reLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 페이스북 로그인 후 앱종료 하고나면 자동으로 로그아웃하게
        LoginManager.getInstance().logOut();
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEdt.getText().toString().equals("")) {
//                    아이디가 입력되지 않았을 경우
                    Toast.makeText(mContext, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (pwEdt.getText().toString().equals("")) {
//                    비밀번호가 입력되지 않았을 경우
                    Toast.makeText(mContext, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (!(idEdt.getText().toString().equals("")) && !(pwEdt.getText().toString().equals(""))) {
//                    로그인을 위한 서버 통신
                    ServerUtil.sign_in(mContext, idEdt.getText().toString(), pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                        @Override
                        public void onResponse(JSONObject json) {
                            try {
                                if (json.getBoolean("result")) {
                                    JSONObject user = json.getJSONObject("user");
                                    JSONObject imgURL = user.getJSONObject("profileImgURL");
                                    User loginUser = new User(user.getInt("id"), user.getString("userId"), user.getString("name"), imgURL.getString("url"), user.getString("profileComment"));
                                    ContextUtil.setLoginUser(mContext, loginUser);
                                    Intent intent = new Intent(mContext, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(mContext, json.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });

        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SignUpActivity.class);
                startActivity(intent);
            }
        });

        reLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://help.instagram.com/"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        cm.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void setValues() {
        ServerUtil.get_all_posts(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    GlobalData.postingList.clear();
                    JSONArray posts = json.getJSONArray("posts");
                    for (int i = posts.length() - 1; i >= 0; i--) {
                        Post tmp = Post.getPostFromJson(posts.getJSONObject(i));
                        GlobalData.postingList.add(tmp);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        cm = CallbackManager.Factory.create();

//        페이스북 버튼 이벤트
        fbLoginBtn.registerCallback(cm, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // 페이스북 로그인에 성공했을 경우 메인화면으로
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                finish();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

//        현재 프로필 추적
        ProfileTracker pt = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {

            }
        };
    }

    @Override
    public void bindViews() {
        this.signupTxt = (TextView) findViewById(R.id.signupTxt);
        this.fbLoginBtn = (LoginButton) findViewById(R.id.fbLoginBtn);
        this.reLoginBtn = (TextView) findViewById(R.id.reLoginBtn);
        this.loginBtn = (Button) findViewById(R.id.loginBtn);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}