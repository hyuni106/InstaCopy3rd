package kr.co.tjeit.instacopyproject3rd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.instacopyproject3rd.NewsfeedDetailView;
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
        getPost();
    }

    private void setValuse() {
        mAdapter = new NewsfeedAdapter(getContext(), GlobalData.postingList);
        newsfeedListView.setAdapter(mAdapter);
    }

    private void setupEvents() {
        swipelayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPost();
                swipelayout.setRefreshing(false);
            }
        });

        newsfeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NewsfeedDetailView.class);
                intent.putExtra("뉴스피드", GlobalData.postingList.get(position));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        getPost();
    }

    public void getPost() {
        ServerUtil.get_all_posts(getActivity(), new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {
                try {
                    GlobalData.postingList.clear();
                    JSONArray posts = json.getJSONArray("posts");
                    for (int i = posts.length() - 1; i >= 0; i--) {
                        Post tmp = Post.getPostFromJson(posts.getJSONObject(i));
                        GlobalData.postingList.add(tmp);
                    }
                    mAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
