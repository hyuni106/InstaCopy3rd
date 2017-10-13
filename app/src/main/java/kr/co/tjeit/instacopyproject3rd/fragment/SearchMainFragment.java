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

import kr.co.tjeit.instacopyproject3rd.R;

/**
 * Created by the on 2017-10-13.
 */

public class SearchMainFragment extends Fragment {

    public static SearchMainFragment frag;
    private android.widget.ImageView backBtn;
    private android.widget.EditText searchEdt;
    private LinearLayout searchLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_main_item, container, false);
        this.searchLayout = (LinearLayout) v.findViewById(R.id.searchLayout);
        this.searchEdt = (EditText) v.findViewById(R.id.searchEdt);
        this.backBtn = (ImageView) v.findViewById(R.id.backBtn);
        frag = this;

        this.searchLayout = (LinearLayout) v.findViewById(R.id.searchLayout);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupEvents();
        setValuse();

    }

    private void setValuse() {

//        searchLayout.requestFocus();
//        backBtn.requestFocus();
//        searchEdt.requestFocus();
//
//        searchLayout.setFocusableInTouchMode(true);
//        backBtn.setFocusableInTouchMode(true);
//        searchEdt.setFocusableInTouchMode(true);
//
//

    }

    private void setupEvents() {

        searchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchLayout.setVisibility(View.GONE);
                getFragmentManager().beginTransaction().replace(R.id.fragFrame, new SearchFragment()).commit();


            }
        });

        searchEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                getFragmentManager().beginTransaction().replace(R.id.fragFrame, new SearchFragment()).commit();
            }
        });

    }
}
