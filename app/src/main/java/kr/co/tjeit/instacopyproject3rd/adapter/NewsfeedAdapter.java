package kr.co.tjeit.instacopyproject3rd.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.data.Post;


/**
 * Created by user on 2017-08-17.
 */

public class NewsfeedAdapter extends ArrayAdapter<Post> {
    Context mContext;
    List<Post> mList;
    LayoutInflater inf;

    private final static String BASE_URL = "http://52.78.126.147/";

    public NewsfeedAdapter(Context context, List<Post> list) {
        super(context, R.layout.newsfeed_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if ( row == null) {
            row = inf.inflate(R.layout.newsfeed_list_item, null);
        }

        Post data = mList.get(position);

        ImageView profileImg = (ImageView) row.findViewById(R.id.profileImg);
        ImageView postImg = (ImageView) row.findViewById(R.id.postImg);
        TextView writerNickNameTxt = (TextView) row.findViewById(R.id.writerNickNameTxt);
        TextView contentTxt = (TextView) row.findViewById(R.id.contentTxt);

        if (!data.getWriterData().getProfileImgURL().equals("null")) {
            Glide.with(mContext).load(BASE_URL + data.getWriterData().getProfileImgURL()).into(profileImg);
        } else {
            profileImg.setImageResource(R.mipmap.ic_launcher_round);
        }

        if (!data.getImageURL().equals("null")) {
            Glide.with(mContext).load(BASE_URL + data.getImageURL()).into(postImg);
            postImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            postImg.setImageResource(R.mipmap.ic_launcher);
        }

        writerNickNameTxt.setText(data.getWriterData().getUserId());
        contentTxt.setText(data.getContent());

        return row;
    }
}
