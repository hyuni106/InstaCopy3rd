package kr.co.tjeit.instacopyproject3rd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;
import kr.co.tjeit.instacopyproject3rd.util.SignUpCheckActivity;

//dd
public class SignUpActivity extends BaseActivity {

    final int REQ_FOR_GALLERY = 1;

    private android.widget.TextView nextTxt;
    private de.hdodenhof.circleimageview.CircleImageView signUpImg;
    private android.widget.EditText nameEdt;
    private android.widget.EditText passwordEdt;
    private CircleImageView profileImg;

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

        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQ_FOR_GALLERY);
            }
        });

        nextTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (passwordEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (!(nameEdt.getText().toString().equals("")) && !(passwordEdt.getText().toString().equals(""))) {
                    Intent intent = new Intent(mContext, SignUpCheckActivity.class);
                    startActivity(intent);
                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_FOR_GALLERY) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                Toast.makeText(mContext, "서버에 이미지파일 업로드 완료", Toast.LENGTH_SHORT).show();

//                try {
//                    final Bitmap myBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

////                    ServerUtil.updateProfilePhoto(mContext, "아이디", myBitmap, new ServerUtil.JsonResponseHandler() {
//                        @Override
//                        public void onResponse(JSONObject json) {
//                            Toast.makeText(mContext, "서버에 이미지파일 업로드 완료", Toast.LENGTH_SHORT).show();
//                            profileImg.setImageBitmap(myBitmap);
//
//                        }
//                    });
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.nextTxt = (TextView) findViewById(R.id.nextTxt);
        this.passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.profileImg = (CircleImageView) findViewById(R.id.profileImg);
    }
}
