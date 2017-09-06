package kr.co.tjeit.instacopyproject3rd.adapter;

import android.content.Context;
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
import kr.co.tjeit.instacopyproject3rd.data.Like;

/**
 * Created by the on 2017-09-05.
 */

public class FollowingAdapter extends ArrayAdapter<Like> {

    Context mContext;
    List<Like> mList;
    LayoutInflater inf;

    public FollowingAdapter(Context context, List<Like> list) {
        super(context, R.layout.following_fragment_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            // 거의 반드시 딱 한줄만 if문 안에 들어옴.
            row = inf.inflate(R.layout.following_fragment_list_item, null);
        }

        Like data = mList.get(position);

        ImageView roundImg = (ImageView) row.findViewById(R.id.roundImg);
        ImageView photoImg = (ImageView) row.findViewById(R.id.photoImg);
        TextView userLikeTxt = (TextView) row.findViewById(R.id.userLikeTxt);


        return row;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
