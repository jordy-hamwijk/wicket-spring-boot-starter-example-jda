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
import org.apache.wicket.model.IModel;
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
        Form<Void> form = new Form<>("forms");

        add(form);
        ListView<Cheese> listview = new ListView<Cheese>("items", soorten) {
            @Override
            protected void populateItem(ListItem<Cheese> item) {

                item.add(new Label("soort", item.getModelObject().getSoortKaas()));
                item.add(new Label("land", item.getModelObject().getLandHerkomst()));
                item.add(new Label("gewicht", new PropertyModel<>(item.getModel(), "gewicht")));
            }

            //
        };

        datacontainer.add(listview);

        datacontainer.setVersioned(false);
        //TODO Stap 3 Clean up code
        final IModel<Cheese> soorten = new IModel<Cheese>() {
            public String getValue() {
                return value;
            }

            @Override
            public Cheese getObject() {
                return null;
            }

            private String value;

        };
        Button button1 = new Button("button1") {
            @Override
            public void onSubmit() {
                info("button1.onSubmit executed");
            }
        };
        form.add(button1);
        final TextField<Cheese> field = new TextField<Cheese>("ac", soorten) {
            //TODO Stap 1 Textfield logica toevoegen
            //TODO Stap 2 onSubmit logica toevoegen
        };
        form.add(field);

    }
}


