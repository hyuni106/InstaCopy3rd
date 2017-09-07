package kr.co.tjeit.instacopyproject3rd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import kr.co.tjeit.instacopyproject3rd.util.SignUpCheckActivity;

//dd
public class SignUpActivity extends BaseActivity {

    private android.widget.TextView nextTxt;
    private de.hdodenhof.circleimageview.CircleImageView signUpImg;
    private android.widget.EditText nameEdt;
    private android.widget.EditText passwordEdt;

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
        nextTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nameEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else if (passwordEdt.getText().toString().equals("")) {
                    Toast.makeText(mContext, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (!(nameEdt.getText().toString().equals("")) && !(passwordEdt.getText().toString().equals(""))) {
                    Intent intent = new Intent(mContext, SignUpCheckActivity.class);
                    intent.putExtra("name", nameEdt.getText().toString());
                    intent.putExtra("pw", passwordEdt.getText().toString());
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.signUpImg = (CircleImageView) findViewById(R.id.signUpImg);
        this.nextTxt = (TextView) findViewById(R.id.nextTxt);
    }
}
