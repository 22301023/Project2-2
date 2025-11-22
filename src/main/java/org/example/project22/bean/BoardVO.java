package org.example.project22.bean;

import java.util.Date;

public class BoardVO {
    private int id;
    private String name;
    private String title;
    private String content;
    private String category;
    private Date regdate;
    private String check;

    public BoardVO() {
    }

    public BoardVO(String name, String title, String content, String category, String check) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.category = category;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }




}
