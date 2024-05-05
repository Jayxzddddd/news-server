package cn.smxy.newsserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class News {
    private Integer id;
    private String title;
    private String content;
    private Integer typeId;
    private String imagePath;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date publishDate;
    private NewsType newsType;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", publishDate=" + publishDate +
                ", newsType=" + newsType +
                '}';
    }
}
