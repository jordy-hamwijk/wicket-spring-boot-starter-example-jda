package com.giffing.wicket.spring.boot.example.web.pages.shop;

import com.giffing.wicket.spring.boot.example.model.Cheese;
import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.extensions.ajax.markup.html.autocomplete.AutoCompleteTextField;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.util.string.Strings;

import java.util.*;

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
        };

        datacontainer.add(listview);

        datacontainer.setVersioned(false);


        final IModel<String> model = new IModel<String>() {
            private String value = null;

            @Override
            public String getObject() {
                return value;
            }

            @Override
            public void setObject(String object) {
                value = object;

                values.append('\n');
                values.append(value);
            }
        };

        final AutoCompleteTextField<String> field = new AutoCompleteTextField<String>("ac", model) {
            @Override
            protected Iterator<String> getChoices(String input) {
                if (Strings.isEmpty(input)) {
                    return Collections.emptyIterator();
                }

                List<String> choices = new ArrayList<>(10);

                Locale[] locales = Locale.getAvailableLocales();

                for (final Locale locale : locales) {
                    final String country = locale.getDisplayCountry();

                    if (!choices.contains(country) && country.toUpperCase(Locale.ROOT).startsWith(input.toUpperCase(Locale.ROOT))) {
                        choices.add(country);
                        if (choices.size() == 10) {
                            break;
                        }
                    }
                }

                return choices.iterator();
            }
        };
        form.add(field);

        final MultiLineLabel label = new MultiLineLabel("history", new PropertyModel<String>(this,
                "values"));
        label.setOutputMarkupId(true);
        form.add(label);

        field.add(new AjaxFormSubmitBehavior(form, "change") {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                target.add(label);
            }

            @Override
            protected void onError(AjaxRequestTarget target) {
            }
        });
    }
}


