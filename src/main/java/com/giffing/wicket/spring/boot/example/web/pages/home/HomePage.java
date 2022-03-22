package com.giffing.wicket.spring.boot.example.web.pages.home;


import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.giffing.wicket.spring.boot.example.web.pages.BasePage;
import com.giffing.wicket.spring.boot.example.web.pages.customers.CustomerListPage;
import com.giffing.wicket.spring.boot.example.web.pages.shop.CheeseShop;
import com.giffing.wicket.spring.boot.example.web.pages.shop.oefenbook.GuestBook;
import com.giffing.wicket.spring.boot.example.web.pages.websocket.ChatPage;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.wicketstuff.annotation.mount.MountPath;

@WicketHomePage
@MountPath("home")
@AuthorizeInstantiation("USER")
public class HomePage extends BasePage {

	public HomePage() {
		add(new BookmarkablePageLink<String>("customersLink", CustomerListPage.class));
		add(new BookmarkablePageLink<String>("chatLink", ChatPage.class));
		add(new BookmarkablePageLink<String>("KaasShop", CheeseShop.class));
		add(new BookmarkablePageLink<String>("KaasBoek", GuestBook.class));
	}
}
