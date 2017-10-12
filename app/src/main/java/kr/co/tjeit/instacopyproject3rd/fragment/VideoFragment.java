package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.Intent;
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

import kr.co.tjeit.instacopyproject3rd.R;

/**
 * Created by the on 2017-10-12.
 */

public class VideoFragment extends Fragment {
    private ImageView postImg;
    private EditText postWriteEdt;
    private Button okBtn;

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
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(intent);
            }
        });
    }
}
