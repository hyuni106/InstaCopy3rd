package kr.co.tjeit.instacopyproject3rd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kr.co.tjeit.instacopyproject3rd.data.Post;

public class NewsfeedDetailView extends BaseActivity {

    Post mPost = null;
    private final static String BASE_URL = "http://52.78.126.147/";

    private android.widget.ImageView profileImg;
    private android.widget.TextView writerNickNameTxt;
    private android.widget.ImageView postImg;
    private android.widget.ImageView likeImg;
    private android.widget.ImageView replyBtnImg;
    private android.widget.ImageView messengersendbutton;
    private android.widget.ImageView mySaveImg;
    private android.widget.TextView contentTxt;
    private android.widget.Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed_detail_view);
        mPost = (Post) getIntent().getSerializableExtra("뉴스피드");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void setValues() {

        writerNickNameTxt.setText(mPost.getWriterData().getUserId());

        if (!mPost.getImageURL().equals("null")) {
            Glide.with(mContext).load(BASE_URL + mPost.getImageURL()).into(postImg);
            postImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            postImg.setImageResource(R.mipmap.ic_launcher);
        }


        contentTxt.setText(mPost.getContent());


    }

    @Override
    public void bindViews() {
        this.closeBtn = (Button) findViewById(R.id.closeBtn);
        this.contentTxt = (TextView) findViewById(R.id.contentTxt);
        this.mySaveImg = (ImageView) findViewById(R.id.mySaveImg);
        this.messengersendbutton = (ImageView) findViewById(R.id.messenger_send_button);
        this.replyBtnImg = (ImageView) findViewById(R.id.replyBtnImg);
        this.likeImg = (ImageView) findViewById(R.id.likeImg);
        this.postImg = (ImageView) findViewById(R.id.postImg);
        this.writerNickNameTxt = (TextView) findViewById(R.id.writerNickNameTxt);
        this.profileImg = (ImageView) findViewById(R.id.profileImg);

    }
}
