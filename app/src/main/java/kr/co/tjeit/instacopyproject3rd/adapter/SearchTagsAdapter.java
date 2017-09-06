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
import kr.co.tjeit.instacopyproject3rd.data.Tag;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-05.
 */

public class SearchTagsAdapter extends ArrayAdapter<Tag> {
    Context mContext;
    List<Tag> mList;
    LayoutInflater inf;

    public SearchTagsAdapter(Context context, List<Tag> list) {
        super(context, R.layout.tags_item_list, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.tags_item_list, null);
        }

        return row;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
