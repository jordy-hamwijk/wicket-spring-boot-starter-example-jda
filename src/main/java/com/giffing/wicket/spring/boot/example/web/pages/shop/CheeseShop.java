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
import org.apache.wicket.model.PropertyModel;

import java.util.Arrays;
import java.util.List;

public class CheeseShop extends BasePage {
    private static final long serialVersionUID = 1L;
    private StringBuilder values = new StringBuilder();

    //string word een list van kazen (List<Cheese>)
    private final List<Cheese> soorten = Arrays.asList(
            new Cheese("Jonge belegen", "Nederland", 10),
            new Cheese("Oude Kaas", "Nederland", 111));


    public CheeseShop() {
        WebMarkupContainer datacontainer = new WebMarkupContainer("data");
        datacontainer.setOutputMarkupId(true);
        add(datacontainer);
        Form<Void> form = new Form<>("form");

        add(form);
        ListView<Cheese> listview = new ListView<Cheese>("items", soorten) {
            @Override
            protected void populateItem(ListItem<Cheese> item) {


                item.add(new Label("soort", item.getModelObject().getSoortKaas()));
                item.add(new Label("land", item.getModelObject().getLandHerkomst()));
                item.add(new Label("gewicht", new PropertyModel<>(item.getModel(), "gewicht")));

            }
        };

        datacontainer.add(listview);

        datacontainer.setVersioned(false);
        final TextField<String> field = new TextField<>("textInput");


        Button button = new Button("button") {
            @Override
            public void onSubmit() {

                error("Login failed");

            }
        };
        form.add(button, field);


        // Stap 1  extra knop verwijderen
        // Stap 2 Wicket id juist beneomen alle velden
        //TODO Stap 3 Feedback panel toevoegen , als je op de op onSubmit drukt dat de info text word weergeven wordt. Zie voorbeeld Login.java
        //TODO Stap 4 Als je tekst invoert en op de knop drukt, dit moet worden weergeven in de info feedback field.
        //TODO Stap 5 Nieuwe kaas toevoegen aan de lijst met ingevoerde tekst. (AjaxSubmit)
    }
}


