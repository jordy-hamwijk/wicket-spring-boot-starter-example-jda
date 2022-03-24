package com.giffing.wicket.spring.boot.example.web.pages.shop.TodoItem;

import org.apache.wicket.util.io.IClusterable;

public class TodoItem implements IClusterable {
    private static final long serialVersionUID = 1L;

    /**
     * Is the item done?
     */
    private boolean checked;

    /**
     * Description of the item.
     */
    private String text;

    /**
     * Constructor.
     */
    public TodoItem() {
    }

    /**
     * Copy constructor.
     *
     * @param item the item to copy the values from.
     */
    public TodoItem(TodoItem item) {
        text = item.text;
    }

    /**
     * @return Returns the checked property.
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * Sets the checked property.
     *
     * @param checked The checked property to set.
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * Gets the description of the item.
     *
     * @return Returns the text.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the description of the item.
     *
     * @param text The text to set.
     */
    public void setText(String text) {
        this.text = text;
    }
}