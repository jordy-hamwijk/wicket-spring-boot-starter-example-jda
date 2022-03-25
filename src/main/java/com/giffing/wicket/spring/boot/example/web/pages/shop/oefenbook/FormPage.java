package com.giffing.wicket.spring.boot.example.web.pages.shop.oefenbook;

import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;


public class FormPage extends BasePage {
    /**
     * Constructor
     */
    public FormPage() {
        // Add a FeedbackPanel for displaying our messages
        FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
        add(feedbackPanel);

        // Add a form with an onSubmit implementation that sets a message
        add(new Form<Void>("form") {
            @Override
            protected void onSubmit() {

                error("the form was submitted!");
            }

        });
    }


    /**
     * Override base method to provide an explanation
     */


}