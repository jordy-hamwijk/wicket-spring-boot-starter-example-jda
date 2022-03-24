package com.giffing.wicket.spring.boot.example.web.pages.shop.oefenbook;

import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.value.ValueMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class GuestBook extends BasePage {
    /**
     * A global list of all comments from all users across all sessions
     */

    private static final List<Comment> commentList = new ArrayList<>();
    /**
     * Constructor that is invoked when page is invoked without a session.
     */
    public GuestBook() {
        // Add comment form
        add(new CommentForm("commentForm"));

        // Add commentListView of existing comments
        add(new PropertyListView<Comment>("comments", commentList) {
            @Override
            public void populateItem(final ListItem<Comment> listItem) {
                listItem.add(new Label("date"));
                listItem.add(new MultiLineLabel("text"));
            }
        }).setVersioned(false);
    }

    /**
     * A form that allows a user to add a comment.
     */
    public static class CommentForm extends Form<ValueMap> {
        public CommentForm(final String id) {
            // Construct form with no validation listener
            super(id, new CompoundPropertyModel<>(new ValueMap()));

            // this is just to make the unit test happy
            setMarkupId("commentForm");

            // Add text entry widget
            add(new TextArea<String>("text").setType(String.class));

            // Add simple automated spam prevention measure.
            add(new TextField<String>("comment").setType(String.class));
        }

        /**
         * Show the resulting valid edit
         */
        @Override
        public void onSubmit() {
            ValueMap values = getModelObject();

            // check if the honey pot is filled
            if (StringUtils.isNotBlank((String) values.get("comment"))) {
                error("Caught a spammer!!!");
                return;
            }
            // Construct a copy of the edited comment
            Comment comment = new Comment();

            // Set date of comment to add
            comment.setDate(new Date());
            comment.setText((String) values.get("text"));
            commentList.add(0, comment);

            // Clear out the text component
            values.put("text", "");
            setResponsePage(GuestBook.class);
        }
    }
}
/**
 * }
 * <p>
 * <p>
 * //
 * <p>
 * //
 * //
 * ///**
 * // * A simple "guest book" example that allows visitors to the page to add a comment and see the
 * // * comments others have added.
 * // * <p>
 * // * For unit testing, added a parameter to clear the commentList.
 * // *
 * // * @author Jonathan Locke
 * // * @author Martijn Dashorst
 * //
 */
//public final class GuestBook extends BasePage {
//
//    /**
//     * A global list of all comments from all users across all sessions
//     */
//    private static final List<Comment> commentList = new ArrayList<>();
//
//    /**
//     * Constructor that is invoked when page is invoked without a session.
//     */
//    public GuestBook() {
//        // Add comment form
//        add(new CommentForm("commentForm"));
//
//        // Add commentListView of existing comments
//        add(new PropertyListView<Comment>("comments", commentList) {
//
//            @Override
//            protected void populateItem(ListItem listItem) {
//                listItem.add(new Label("date"));
//                listItem.add(new MultiLineLabel("text"));
//            }
//        }).setVersioned(false);
//
//    }
//
//
//    /**
//     * A form that allows a user to add a comment.
//     *
//     * @author Jonathan Locke
//     */
//    public static final class CommentForm extends Form<ValueMap> {
//        /**
//         * Constructor
//         *
//         * @param id The name of this component
//         */
//        public CommentForm(final String id) {
//            // Construct form with no validation listener
//            super(id, new CompoundPropertyModel<>(new ValueMap()));
//
//            // this is just to make the unit test happy
//            setMarkupId("commentForm");
//
//            // Add text entry widget
//            add(new TextArea<>("text").setType(String.class));
//
//            // Add simple automated spam prevention measure.
//            add(new TextField<>("comment").setType(String.class));
//        }
//
//        /**
//         * Show the resulting valid edit
//         */
//        @Override
//
//        public final void onSubmit() {
//            ValueMap values = getModelObject();
//
//            // check if the honey pot is filled
//            final String _comment = (String) values.get("comment");
//            if (_comment == null || _comment.isBlank()) {// Construct a copy of the edited comment
//                Comment comment = new Comment();
//
//                // Set date of comment to add
//                comment.setDate(new Date());
//                comment.setText((String) values.get("text"));
//                commentList.add(0, comment);
//
//                // Clear out the text component
//                values.put("text", "");
//            } else {
//                error("Caught a spammer!!!");
//                return;
//            }
//        }
//    }
//
//    /**
//     * Clears the comments.
//     */
//    public static void clear() {
//        commentList.clear();
//    }
//}