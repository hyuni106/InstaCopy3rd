package kr.co.tjeit.instacopyproject3rd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject3rd.R;
import kr.co.tjeit.instacopyproject3rd.adapter.NewsfeedAdapter;
import kr.co.tjeit.instacopyproject3rd.data.Post;
import kr.co.tjeit.instacopyproject3rd.util.GlobalData;
import kr.co.tjeit.instacopyproject3rd.util.ServerUtil;

/**
 * Created by the on 2017-09-06.
 */

public class NewsfeedFragment extends Fragment {

    NewsfeedAdapter mAdapter;

    private ListView newsfeedListView;
    private android.support.v4.widget.SwipeRefreshLayout swipelayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_newsfeed_item, container, false);
        this.swipelayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_layout);
        this.newsfeedListView = (ListView) v.findViewById(R.id.newsfeedListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupEvents();
        setValuse();
    }

    private void setValuse() {
        mAdapter = new NewsfeedAdapter(getActivity(), GlobalData.postingList);
        newsfeedListView.setAdapter(mAdapter);
    }

    private void setupEvents() {
        swipelayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ServerUtil.get_all_posts(getContext(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        try {
                            GlobalData.postingList.clear();
                            JSONArray posts = json.getJSONArray("posts");
                            for (int i = posts.length()-1; i >= 0; i--) {
                                Post tmp = Post.getPostFromJson(posts.getJSONObject(i));
                                GlobalData.postingList.add(tmp);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

                swipelayout.setRefreshing(false);
            }
        });
    }

}
