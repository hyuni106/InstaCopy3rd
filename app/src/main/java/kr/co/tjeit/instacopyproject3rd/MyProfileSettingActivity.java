package kr.co.tjeit.instacopyproject3rd;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import kr.co.tjeit.instacopyproject3rd.util.ContextUtil;

public class MyProfileSettingActivity extends BaseActivity {

    private android.widget.EditText nameEdt;
    private android.widget.EditText nickNameEdt;
    private android.widget.Button editProfileBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_setting);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {


        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 불러온데이터를 변경해서 서버유틸로 넘겨주기
                Toast.makeText(mContext, "회원정보를 수정했습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.editProfileBtn = (Button) findViewById(R.id.editProfileBtn);
        this.nickNameEdt = (EditText) findViewById(R.id.nickNameEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
    }
}
