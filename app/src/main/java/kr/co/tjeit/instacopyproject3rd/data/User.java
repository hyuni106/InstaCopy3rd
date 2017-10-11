package kr.co.tjeit.instacopyproject3rd.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class User implements Serializable {

    private int id;
    private String userId;
    private String name;
    private String profileImgURL;
    private String profileComment;

    List<User> followers = new ArrayList<>();
    List<User> followings = new ArrayList<>();

    public User() {
    }

    public User(int id, String userId, String name, String profileImgURL, String profileComment) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.profileImgURL = profileImgURL;
        this.profileComment = profileComment;
    }

    public static User getUserFromJson(JSONObject json) {
        User tmp = new User();

        try {
            tmp.setId(json.getInt("id"));
            tmp.setUserId(json.getString("userId"));
            tmp.setName(json.getString("name"));
            tmp.setProfileImgURL(json.getJSONObject("profileImgURL").getString("url"));
            tmp.setProfileComment(json.getString("profileComment"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tmp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public String getProfileComment() {
        return profileComment;
    }

    public void setProfileComment(String profileComment) {
        this.profileComment = profileComment;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<User> getFollowings() {
        return followings;
    }

    public void setFollowings(List<User> followings) {
        this.followings = followings;
    }
}
