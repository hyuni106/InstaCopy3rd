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


        final Post data = mList.get(position);
//        final PostingData data = mList.get(position);

        TextView writerNickNameTxt = (TextView) row.findViewById(R.id.writerNickNameTxt);
        TextView contentTxt = (TextView) row.findViewById(R.id.contentTxt);
        ImageView replyBtnImg = (ImageView) row.findViewById(R.id.replyBtnImg);


        return row;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
