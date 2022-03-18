package com.giffing.wicket.spring.boot.example.web.pages.shop;

import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;

import java.util.Arrays;

public class CheeseShop extends BasePage {


    private static String Cheese = String.valueOf(11);
    private static String Cheese2 = String.valueOf(20);
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

        PageableListView<String> listview = new PageableListView<String>("rows", Arrays.asList(soorten), 10) {
            @Override
            protected void populateItem(ListItem<String> item) {
                item.add(new Label("soorten", item.getModelObject()));
            }
        };

        datacontainer.add(listview);
        datacontainer.add(new AjaxPagingNavigator("navigator", listview));
        datacontainer.setVersioned(false);
    }
}

