package kr.co.tjeit.instacopyproject3rd.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class Post implements Serializable {

    private int postingId;
    private String imageURL;
    private String content;
    private Calendar createdAt;

    private User writerData;

    private List<Reply> replies = new ArrayList<>();
    private List<User> likeUser = new ArrayList<>();

    public Post() {
    }

    public Post(int i, String tempURL, String s, Calendar instance) {
    }

    public static Post getPostFromJson(JSONObject json) {
        Post tmp = new Post();

        try {
            tmp.setPostingId(json.getInt("id"));
            tmp.setImageURL(json.getJSONObject("imageURL").getString("url"));
            tmp.setContent(json.getString("content"));
            User writeUser = User.getUserFromJson(json.getJSONObject("user"));
            tmp.setWriterData(writeUser);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tmp;
    }

    public int getPostingId() {
        return postingId;
    }

    public void setPostingId(int postingId) {
        this.postingId = postingId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public User getWriterData() {
        return writerData;
    }

    public void setWriterData(User writerData) {
        this.writerData = writerData;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<User> getLikeUser() {
        return likeUser;
    }

    public void setLikeUser(List<User> likeUser) {
        this.likeUser = likeUser;
    }
}










