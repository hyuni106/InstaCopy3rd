package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import kr.co.tjeit.instacopyproject3rd.MainActivity;
import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.util.ContextUtil;
import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;

import static android.app.Activity.RESULT_OK;

/**
 * Created by the on 2017-10-12.
 */

public class CameraFragment extends Fragment {
    private android.widget.ImageView postImg;
    private android.widget.EditText postWriteEdt;
    private android.widget.Button okBtn;

    final int REQ_FOR_CAMERA = 1;
    Bitmap myBitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_post_item, container, false);
        this.okBtn = (Button) v.findViewById(R.id.okBtn);
        this.postWriteEdt = (EditText) v.findViewById(R.id.postWriteEdt);
        this.postImg = (ImageView) v.findViewById(R.id.postImg);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }


    private void setValuse() {

    }

    private void setupEvents() {
        postImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                포스팅 정보를 서버에 보냄
                ServerUtil.make_post(getActivity(), ContextUtil.getUserData(getActivity()).getId() + "", postWriteEdt.getText().toString(), myBitmap,
                        new ServerUtil.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                try {
                                    if (json.getBoolean("result")) {
                                        Toast.makeText(getActivity(), json.getString("message"), Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getActivity(), MainActivity.class);
                                        startActivity(intent);
                                        getActivity().finish();
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_FOR_CAMERA) {
            if (resultCode == RESULT_OK && !data.equals(null)) {
//                Uri uri = data.getData();
                try {
                    myBitmap = (Bitmap)data.getExtras().get("data");
                    postImg.setImageBitmap(myBitmap);
                    postImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                uri 통해서 사진파일로 찾아가 비트맵으로 변환
//                    myBitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
//                    postImg.setImageBitmap(myBitmap);
//                    postImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "사진을 불러오는 중에 에러가 발생했습니다.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }
    }
}
