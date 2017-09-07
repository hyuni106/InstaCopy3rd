package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.MainActivity;
import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.WriteAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;
import kr.co.tjeit.instacopyproject3rd.util.ContextUtil;
import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ziO on 2017-09-06.
 */

public class WritePostFragment extends android.support.v4.app.Fragment {

    WriteAdapter mAdapter;
    List<Post> postList = new ArrayList<>();
    private android.widget.ListView galleryListView;
    private android.widget.EditText postWriteEdt;
    private android.widget.Button okBtn;
    private android.widget.ImageView postImg;

    final int REQ_FOR_GALLERY = 1;

    Bitmap myBitmap;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_post_item, container, false);
        this.postImg = (ImageView) v.findViewById(R.id.postImg);
        this.okBtn = (Button) v.findViewById(R.id.okBtn);
        this.postWriteEdt = (EditText) v.findViewById(R.id.postWriteEdt);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }


    private void setValuse() {
        mAdapter = new WriteAdapter(getActivity(), postList);
//        galleryListView.setAdapter(mAdapter);

    }

    private void setupEvents() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerUtil.make_post(getActivity(), ContextUtil.getUserData(getActivity()).getId() + "", postWriteEdt.getText().toString(), myBitmap,
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    if (json.getBoolean("result")) {
                                        Toast.makeText(getActivity(), json.getString("message"), Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getActivity(), MainActivity.class);
                                        startActivity(intent);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
            }
        });

        postImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQ_FOR_GALLERY);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_FOR_GALLERY) {
            if (resultCode == RESULT_OK) {
//                서버에 프로필 사진 전송, 후처리.
//                사진 전송 => Bitmap 따서 서버에 보낸다.

//                1. Bitmap 얻어오기
                Uri uri = data.getData();
//                갤러리를 통해 받아온것? 선택된 사진이 어디에 있는지 위치 정보.

//                경로를 찾아가서 해당 사진 파일을 Bitmap으로 받아와야함.
//                MediaStore 클래스가 사진 파일 => 비트맵으로 변환해서 가져옴.

//                try : 한번 시도해봐. try 내부는 언제 에러가 터질지 모르는 부분. (예외 발생 가능 지점)
                try {
//                uri 통해서 사진파일로 찾아감.
//                사진파일 있으면, 비트맵으로 변환. (변환을 해주는 객체 : getContentResolver())
//                그냥 이 문장만 쓰면 에러가 남. 왜? 예외처리 필요.
                    myBitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);

                    postImg.setImageBitmap(myBitmap);
                    postImg.setScaleType(ImageView.ScaleType.CENTER_CROP);

                } catch (IOException e) {
//                    예외가 실제로 발생하면 대처하는 부분 : catch
//                    앱이 죽지 않고 실행상태를 유지하도록 대처하는 부분.

                    Toast.makeText(getActivity(), "사진을 불러오는 중에 에러가 발생했습니다.", Toast.LENGTH_SHORT).show();

//                    어떤 예외가 발생했는지 로그로 기록.
                    e.printStackTrace();
                }

            }
        }
    }
}
