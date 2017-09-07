package kr.co.tjeit.instacopyproject3rd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;

//dd
public class SignUpActivity extends BaseActivity {

    final int REQ_FOR_GALLERY = 1;

    private EditText idEdt;
    private EditText passwordEdt;
    private android.widget.ImageView checkImg;
    private EditText nameEdt;
    private TextView nextTxt;

    boolean isDupl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
//        TODO - 아이디 중복확인 필요
        nextTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (idEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (passwordEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (!(idEdt.getText().toString().equals("")) && !(passwordEdt.getText().toString().equals("")) && !(nameEdt.getText().toString().equals(""))) {
                    ServerUtil.sign_up(mContext, idEdt.getText().toString(), passwordEdt.getText().toString(), nameEdt.getText().toString(),
                            new ServerUtil.JsonResponseHandler() {
                                @Override
                                public void onResponse(JSONObject json) {
                                    try {
                                        if (json.getBoolean("result")) {
                                            Toast.makeText(mContext, json.getString("message"), Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(mContext, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                }
            }
        });

        checkImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDupl = true;
                ServerUtil.check_dupl_id(mContext, idEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (!json.getBoolean("result")) {
                                Toast.makeText(mContext, "사용가능", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(mContext, "중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                isDupl = false;
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.nextTxt = (TextView) findViewById(R.id.nextTxt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.checkImg = (ImageView) findViewById(R.id.checkImg);
        this.passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
