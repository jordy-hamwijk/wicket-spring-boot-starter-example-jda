package com.giffing.wicket.spring.boot.example.web.pages.shop;

import com.giffing.wicket.spring.boot.example.model.Cheese;
import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheeseShop extends BasePage {
    private static final long serialVersionUID = 1L;
    private static List<Cheese> soorten = new ArrayList<>();
    private boolean linkVisible = true;

    public CheeseShop() {
        WebMarkupContainer datacontainer = new WebMarkupContainer("data");
        datacontainer.setOutputMarkupId(true);
        add(datacontainer);

        ListView<Cheese> listview = new ListView<>("items", soorten) {
            @Override
            protected void populateItem(ListItem<Cheese> item) {


                item.add(new Label("soort", item.getModelObject().getSoortKaas()));
                item.add(new Label("land", item.getModelObject().getLandHerkomst()));
                item.add(new Label("gewicht", new PropertyModel<>(item.getModel(), "gewicht")));


            }
        };
        datacontainer.add(listview);
        add(new CheeseForm("form"));
    }


    public class CheeseForm extends Form<ValueMap> {

        public CheeseForm(final String id) {

            // Construct form with no validation listener
            super(id, new CompoundPropertyModel<>(new ValueMap()));

            // this is just to make the unit test happy
            setMarkupId("soortKaas");
            setMarkupId("landHerkomst");
            setMarkupId("gewicht");

            TextField<String> soortKaas = new TextField<>("soortKaas");
            TextField<String> landHerkomst = new TextField<>("landHerkomst");
            TextField<Integer> gewichtKaas = new TextField<>("gewichtKaas");

            add(soortKaas, landHerkomst, gewichtKaas);

            add(new AjaxFallbackLink<Void>("ajaxback") {
                @Override
                public void onClick(Optional<AjaxRequestTarget> targetOptional) {
                    setResponsePage(getPage());

                }
            });

            add(new AjaxButton("cancel", this) {
                @Override
                public void onSubmit(AjaxRequestTarget target) {
                    onCancelTodo(target);

                }

                @Override
                protected void onError(AjaxRequestTarget target) {
                }
            });
            //Edit button
            add(new AjaxButton("edit", this) {
                @Override
                public void onSubmit(AjaxRequestTarget target) {
                    onCancelTodo(target);
                }

                @Override
                protected void onError(AjaxRequestTarget target) {
                }
            });
            //Delete button
            add(new AjaxButton("delete", this) {
                @Override
                public void onSubmit(AjaxRequestTarget target) {

                }

                @Override
                protected void onError(AjaxRequestTarget target) {
                }
            });

        }


        @Override
        public void onSubmit() {
            FeedbackPanel feedbackPanel = new FeedbackPanel("feedback");
            add(feedbackPanel);

            // Add a form with an onSubmit implementation that sets a message
            add(new Form<Void>("form") {
                @Override
                protected void onSubmit() {

                    error("the form was submitted!");
                }

//            ValueMap values = getModelObject();
//
//            soorten.add(new Cheese((String) values.get("soortKaas"), (String) values.get("landHerkomst"), values.getInt("gewichtKaas")));
//            //hier maak je een nieuwe lege kaas aan
//            setResponsePage(CheeseShop.class);

            });
        }

        void onCancelTodo(AjaxRequestTarget target) {
            // toggle the visibility
            linkVisible = true;

            // repaint the panel.
            target.add(this);
        }

    }
}







