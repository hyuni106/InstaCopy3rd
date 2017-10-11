package kr.co.tjeit.instacopyproject3rd.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.data.User;

/**
 * Created by the on 2017-09-05.
 */

public class SearchPeopleAdapter extends ArrayAdapter<User> {
    Context mContext;
    List<User> mList;
    LayoutInflater inf;

    public SearchPeopleAdapter(Context context, List<User> list) {
        super(context, R.layout.people_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.people_list_item, null);
        }

        User data = mList.get(position);

        TextView userIdTxt = (TextView) row.findViewById(R.id.userIdTxt);
        TextView userNameTxt = (TextView) row.findViewById(R.id.userNameTxt);

        userIdTxt.setText(data.getUserId());
        userNameTxt.setText(data.getName());

        return row;
    }
}
