package com.giffing.wicket.spring.boot.example.web.pages.shop;

import com.giffing.wicket.spring.boot.example.model.Cheese;
import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

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

        ListView<Cheese> listview = new ListView<Cheese>("rows", soorten) {
            @Override
            protected void populateItem(ListItem<Cheese> item) {

                item.add(new Label("soort", item.getModelObject().getSoortKaas()));
            }
        };

        datacontainer.add(listview);

        datacontainer.setVersioned(false);
    }
}

