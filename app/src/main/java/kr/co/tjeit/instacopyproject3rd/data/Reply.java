package kr.co.tjeit.instacopyproject3rd.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class Reply implements Serializable {

    private int replyId;
    private String content;
    private Calendar createdAt;

    private User writerData;
    private Post replyPost;

    private List<User> likeUser = new ArrayList<>();

    public Reply() {
    }

    public Reply(int replyId, String content, Calendar createdAt) {
        this.replyId = replyId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
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

    public Post getReplyPost() {
        return replyPost;
    }

    public void setReplyPost(Post replyPost) {
        this.replyPost = replyPost;
    }

    public List<User> getLikeUser() {
        return likeUser;
    }

    public void setLikeUser(List<User> likeUser) {
        this.likeUser = likeUser;
    }
}









