package kr.co.tjeit.instacopyproject3rd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
//dd
public class SignUpActivity extends BaseActivity {

    private android.widget.TextView nextTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.nextTxt = (TextView) findViewById(R.id.nextTxt);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        nextTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TODO - 합치고나서 실행
//                Intent intent = new Intent(mContext, UserNameMakeActivity.class);
//                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

    }
}
