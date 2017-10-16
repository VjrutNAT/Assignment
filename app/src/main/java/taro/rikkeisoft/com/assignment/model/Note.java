package taro.rikkeisoft.com.assignment.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by VjrutNAT on 10/14/2017.
 */

public class Note implements Serializable {

    public static final String ALARM = "ALARM_TIME";
    public static final String COLOR = "COLOR";
    public static final String CONTENT = "CONTENT";
    public static final String CREATE_ALARM = "CREATE_ALARM";
    public static final String ID = "ID";
    public static final String PICTURE = "PICTURE";
    public static final String TITLE = "TITLE";
    public static final long seriableVersionUID = 1;

    private String mTitle;
    private String mContent;
    private Date mAlarm;
    private Date mCreateAlarm;
    private String mColor;
    private long mId;
    private String mPicture;

    public Note(String title, String content, Date alarm, Date createAlarm, String color, long id, String picture) {
        this.mTitle = title;
        this.mContent = content;
        this.mAlarm = alarm;
        this.mCreateAlarm = createAlarm;
        this.mColor = color;
        this.mId = id;
        this.mPicture = picture;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

    public Date getAlarm() {
        return mAlarm;
    }

    public void setAlarm(Date mAlarm) {
        this.mAlarm = mAlarm;
    }

    public Date getCreateAlarm() {
        return mCreateAlarm;
    }

    public void setCreateAlarm(Date mCreateAlarm) {
        this.mCreateAlarm = mCreateAlarm;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String mColor) {
        this.mColor = mColor;
    }

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getPicture() {
        return mPicture;
    }

    public void setPicture(String mPicture) {
        this.mPicture = mPicture;
    }
}
