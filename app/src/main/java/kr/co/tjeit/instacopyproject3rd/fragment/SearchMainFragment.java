package kr.co.tjeit.instacopyproject3rd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import kr.co.tjeit.instacopyproject3rd.MainActivity;
import kr.co.tjeit.instacopyproject3rd.R;

/**
 * Created by the on 2017-10-13.
 */

public class SearchMainFragment extends Fragment {

    public static SearchMainFragment frag;
    private android.widget.ImageView backBtn;
    private android.widget.EditText searchEdt;
    private LinearLayout searchEdtLayout;
    private ImageView searchBtnImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_main_item, container, false);
        this.searchBtnImg = (ImageView) v.findViewById(R.id.searchBtnImg);
        this.searchEdtLayout = (LinearLayout) v.findViewById(R.id.searchEdtLayout);
        this.searchEdt = (EditText) v.findViewById(R.id.searchEdt);
        frag = this;
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
        searchBtnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout searchMainLayout = (LinearLayout) MainActivity.act.findViewById(R.id.searchMainLayout);
                LinearLayout searchLayout = (LinearLayout) MainActivity.act.findViewById(R.id.searchLayout);
                searchMainLayout.setVisibility(View.GONE);
                searchLayout.setVisibility(View.VISIBLE);
            }
        });

        searchEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                LinearLayout searchMainLayout = (LinearLayout) MainActivity.act.findViewById(R.id.searchMainLayout);
                LinearLayout searchLayout = (LinearLayout) MainActivity.act.findViewById(R.id.searchLayout);
                searchMainLayout.setVisibility(View.GONE);
                searchLayout.setVisibility(View.VISIBLE);
            }
        });

    }
}
