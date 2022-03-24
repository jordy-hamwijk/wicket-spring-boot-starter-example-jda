package com.giffing.wicket.spring.boot.example.web.pages.shop;

import com.giffing.wicket.spring.boot.example.model.Cheese;
import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.value.ValueMap;

import java.util.ArrayList;
import java.util.List;

public class CheeseShop extends BasePage {
    private static final long serialVersionUID = 1L;
    private static List<Cheese> soorten = new ArrayList<>();

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
    public static class CheeseForm extends Form<ValueMap> {
        public CheeseForm(final String id) {
            // Construct form with no validation listener
            super(id, new CompoundPropertyModel<>(new ValueMap()));

            // this is just to make the unit test happy
            setMarkupId("soortKaas");

            TextField<String> field = new TextField<>("soortKaas");
            add(field);
        }

        @Override
        public void onSubmit() {
            //hier maak je een nieuwe lege kaas aan
            ValueMap values = getModelObject();
            soorten.add(new Cheese((String) values.get("soortKaas"), (String) values.get( "Belgie"), (Integer) values.get(11)));
            setResponsePage(CheeseShop.class);
        }
    }
}
// Stap 1  extra knop verwijderen
// Stap 2 Wicket id juist beneomen alle velden
// Stap 3 Feedback panel toevoegen , als je op de op onSubmit drukt dat de info text word weergeven wordt. Zie voorbeeld Login.java
// Stap 4 Clean code
// Stap 5 Als je tekst invoert en op de knop drukt, dit moet worden weergeven in de info feedback field.
// Stap 6 Nieuwe kaas toevoegen aan de lijst met ingevoerde tekst.
//TODO Stap 7 Nieuwe kaas toevoegen door middel van een (AjaxSubmit)






