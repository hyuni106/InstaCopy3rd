package kr.co.tjeit.instacopyproject3rd.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by user on 2017-08-17.
 */

public class ReplyData implements Serializable {

    private int replyId;
    private String content;
    private Calendar createdAt;

    private UserData writerData;

    private List<UserData> likeUsers = new ArrayList<>();

    private int parentReplyId;

    public ReplyData() {
    }

    public ReplyData(int replyId, String content, Calendar createdAt, UserData writerData, int parentReplyId) {
        this.replyId = replyId;
        this.content = content;
        this.createdAt = createdAt;
        this.writerData = writerData;
        this.parentReplyId = parentReplyId;
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

    public int getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(int parentReplyId) {
        this.parentReplyId = parentReplyId;
    }
}









