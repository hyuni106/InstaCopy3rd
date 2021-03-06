package kr.co.tjeit.instacopyproject3rd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.data.Post;

/**
 * Created by the on 2017-09-06.
 */

public class GridPictureAdapter extends ArrayAdapter<Post> {
    Context mContext;
    List<Post> mList;
    LayoutInflater inf;

    public GridPictureAdapter(Context context, List<Post> list) {
        super(context, R.layout.list_mypic, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if ( row == null) {
            row = inf.inflate(R.layout.list_mypic, null);
        }

        return row;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
