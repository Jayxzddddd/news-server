package cn.smxy.newsserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class MsBoard {
    private int id;
    private String  maker;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date nowtime;

    public MsBoard() {
    }

    public MsBoard(int id, String maker, String message, Date nowtime) {
        this.id = id;
        this.maker = maker;
        this.message = message;
        this.nowtime = nowtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getNowtime() {
        return nowtime;
    }

    public void setNowtime(Date nowtime) {
        this.nowtime = nowtime;
    }

    @Override
    public String toString() {
        return "MsBoard{" +
                "id=" + id +
                ", maker='" + maker + '\'' +
                ", message='" + message + '\'' +
                ", nowtime=" + nowtime +
                '}';
    }
}
