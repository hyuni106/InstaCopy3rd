package kr.co.tjeit.instacopyproject3rd.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class PostingData implements Serializable {

    private int postingId;
    private String imageURL;
    private String content;

    private UserData writerData;

    private List<UserData> likeUsers = new ArrayList<>();
    private List<ReplyData> replies = new ArrayList<>();
    private List<String> hashTags = new ArrayList<>();

    public PostingData() {
    }

    public PostingData(int postingId, String imageURL, String content, UserData writerData) {
        this.postingId = postingId;
        this.imageURL = imageURL;
        this.content = content;
        this.writerData = writerData;
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

    public UserData getWriterData() {
        return writerData;
    }

    public void setWriterData(UserData writerData) {
        this.writerData = writerData;
    }

    public List<UserData> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(List<UserData> likeUsers) {
        this.likeUsers = likeUsers;
    }

    public List<String> getHashTags() {
        return hashTags;
    }

    public void setHashTags(List<String> hashTags) {
        this.hashTags = hashTags;
    }

    public List<ReplyData> getReplies() {
        return replies;
    }

    public void setReplies(List<ReplyData> replies) {
        this.replies = replies;
    }
}










