package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instacopyproject3rd.MainActivity;
import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.WriteAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by ziO on 2017-09-06.
 */

public class WritePostFragment extends android.support.v4.app.Fragment {

    WriteAdapter mAdapter;
    List<Post> postList = new ArrayList<>();
    private android.widget.ListView galleryListView;
    private android.widget.EditText postWriteEdt;
    private android.widget.Button okBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_write_post_item, container, false);
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
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
