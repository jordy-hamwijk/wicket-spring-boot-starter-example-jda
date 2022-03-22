package com.giffing.wicket.spring.boot.example.web.pages.shop.oefenbook;

import org.apache.wicket.util.io.IClusterable;

import java.util.Date;


/**
 * Simple "POJO" bean for guestbook comments.
 *
 * @author Jonathan Locke
 */
public class Comment implements IClusterable {
    private String text;
    private Date date = new Date();

    /**
     * Constructor
     */
    public Comment() {
    }

    /**
     * Copy constructor
     *
     * @param comment The comment to copy
     */
    public Comment(final Comment comment) {
        this.text = comment.text;
        this.date = comment.date;
    }

    /**
     * @return Returns the text.
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text to set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return Returns the date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "[Comment date = " + date + ", text = " + text + "]";
    }
}