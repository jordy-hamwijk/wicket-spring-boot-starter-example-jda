package com.giffing.wicket.spring.boot.example.web.pages.shop;

import com.giffing.wicket.spring.boot.example.model.Cheese;
import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import java.util.Arrays;
import java.util.List;

public class CheeseShop extends BasePage {
    private static final long serialVersionUID = 1L;

    //string word een list van kazen (List<Cheese>)
    private final List<Cheese> soorten = Arrays.asList(
            new Cheese("Jonge belegen", "Nederland", 10),
            new Cheese("Oude Kaas", "Nederland", 111));


    public CheeseShop() {
        WebMarkupContainer datacontainer = new WebMarkupContainer("data");
        datacontainer.setOutputMarkupId(true);
        add(datacontainer);

        ListView<Cheese> listview = new ListView<Cheese>("items", soorten) {
            @Override
            protected void populateItem(ListItem<Cheese> item) {


                item.add(new Label("soort", item.getModelObject().getSoortKaas()));
                item.add(new Label("land", item.getModelObject().getLandHerkomst()));
                item.add(new Label("gewicht", new PropertyModel<>(item.getModel(), "gewicht")));

            }
        };

        datacontainer.add(listview);

        Form<Cheese> form = new Form<>("form");
        add(form);
        form.setModel(new CompoundPropertyModel<>(new Cheese()));
        form.add(new FeedbackPanel("feedback"));

        TextField<Cheese> field = new TextField<>("soortKaas");

        Button button = new Button("button") {
            @Override
            public void onSubmit() {

                info(field.getModelObject() + "Not found");
            }
        };
        form.add(button, field);


        // Stap 1  extra knop verwijderen
        // Stap 2 Wicket id juist beneomen alle velden
        // Stap 3 Feedback panel toevoegen , als je op de op onSubmit drukt dat de info text word weergeven wordt. Zie voorbeeld Login.java
        // Stap 4 Clean code
        // Stap 5 Als je tekst invoert en op de knop drukt, dit moet worden weergeven in de info feedback field.
        //TODO Stap 6 Nieuwe kaas toevoegen aan de lijst met ingevoerde tekst. (AjaxSubmit)
    }


}


