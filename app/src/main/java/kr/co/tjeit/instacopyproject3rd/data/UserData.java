package kr.co.tjeit.instacopyproject3rd.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class UserData implements Serializable {

    private int userId;
    private String name;
    private String nickName;
    private String profileImgURL;

    List<UserData> followers = new ArrayList<>();

    List<UserData> followings = new ArrayList<>();

    public UserData() {
    }

    public UserData(int userId, String name, String nickName, String profileImgURL) {
        this.userId = userId;
        this.name = name;
        this.nickName = nickName;
        this.profileImgURL = profileImgURL;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public List<UserData> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserData> followers) {
        this.followers = followers;
    }

    public List<UserData> getFollowings() {
        return followings;
    }

    public void setFollowings(List<UserData> followings) {
        this.followings = followings;
    }
}
