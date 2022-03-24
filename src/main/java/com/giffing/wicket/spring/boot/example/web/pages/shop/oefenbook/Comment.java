package com.giffing.wicket.spring.boot.example.web.pages.shop.oefenbook;

import org.apache.wicket.util.io.IClusterable;
import java.util.Date;


public class Comment implements IClusterable {
    private String text;
    private Date date = new Date();

    public Comment() {
    }

    public Comment(final Comment comment) {
        this.text = comment.text;
        this.date = comment.date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString() {
        return "[Comment date = " + date + ", text = " + text + "]";
    }
}