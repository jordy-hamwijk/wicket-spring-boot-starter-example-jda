package com.giffing.wicket.spring.boot.example.web.pages.shop;

import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import java.util.Arrays;

public class CheeseShop extends BasePage {
    private static final long serialVersionUID = 1L;

    private static String Cheese = String.valueOf(11);
    private static String Cheese2 = String.valueOf(20);

    //string word een list van kazen (List<Cheese>)
    private static final String[] soorten = {"Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2,
            "Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2,
            "Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2,
            "Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2,
            "Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2,
            "Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2,
            "Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2,
            "Jonge belegen, Goudse", "€" + Cheese + "," + Cheese2};


    public CheeseShop() {
        WebMarkupContainer datacontainer = new WebMarkupContainer("data");
        datacontainer.setOutputMarkupId(true);
        add(datacontainer);

        ListView<String> listview = new ListView<String>("rows", Arrays.asList(soorten)) {
            @Override
            protected void populateItem(ListItem<String> item) {
                item.add(new Label("soort", item.getModelObject()));
            }
        };

        datacontainer.add(listview);

        datacontainer.setVersioned(false);
    }
}

