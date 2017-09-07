package kr.co.tjeit.instacopyproject3rd.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject3rd.BaseActivity;
import kr.co.tjeit.instacopyproject3rd.R;

public class SignUpCheckActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.ImageView checkImg;
    private android.widget.Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_check);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = getIntent().getStringExtra("name");
                String pw = getIntent().getStringExtra("pw");
                ServerUtil.sign_up(mContext, idEdt.getText().toString(), pw, name, new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.nextBtn = (Button) findViewById(R.id.nextBtn);
        this.checkImg = (ImageView) findViewById(R.id.checkImg);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
