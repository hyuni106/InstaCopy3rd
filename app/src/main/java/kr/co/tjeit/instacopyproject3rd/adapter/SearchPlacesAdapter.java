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
import kr.co.tjeit.instacopyproject3rd.data.Place;

/**
 * Created by the on 2017-09-05.
 */

public class SearchPlacesAdapter extends ArrayAdapter<Place>{
    Context mContext;
    List<Place> mList;
    LayoutInflater inf;

    public SearchPlacesAdapter(Context context, List<Place> list) {
        super(context, R.layout.places_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.places_list_item, null);
        }

        return row;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
