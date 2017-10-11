package kr.co.tjeit.instacopyproject3rd;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;

public class SignUpActivity extends BaseActivity {

//    binding에 필요한 변수
    private EditText idEdt;
    private EditText passwordEdt;
    private android.widget.ImageView checkImg;
    private EditText nameEdt;
    private TextView nextTxt;
    private ImageView idCheckImg;
    private android.widget.Button idCheckBtn;

    boolean isIdDupl = false;

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
        idCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.check_dupl_id(mContext, idEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            if (json.getBoolean("result")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setTitle("중복 확인");
                                builder.setMessage("이미 사용중인 아이디 입니다.");
                                builder.setPositiveButton("확인", null);
                                builder.show();
                            }
                            else {
                                Toast.makeText(mContext, "사용해도 좋은 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                isIdDupl = true;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        nextTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (!isIdDupl) {
                    Toast.makeText(mContext, "아이디 중복확인을 해주세요.", Toast.LENGTH_SHORT).show();
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

        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                아이디 입력 값이 변경될 경우 검사 값 false로 설정
                isIdDupl = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

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
        this.idCheckBtn = (Button) findViewById(R.id.idCheckBtn);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
    }
}
