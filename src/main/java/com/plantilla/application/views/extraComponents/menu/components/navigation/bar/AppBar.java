package com.plantilla.application.views.extraComponents.menu.components.navigation.bar;

import com.plantilla.application.views.extraComponents.menu.util.LumoStyles;
import com.plantilla.application.views.extraComponents.menu.util.UIUtilsMod;
import com.plantilla.application.views.HomeView;
import com.plantilla.application.views.MainView;
import com.plantilla.application.views.extraComponents.menu.components.FlexBoxLayoutMod;
import com.plantilla.application.views.extraComponents.menu.components.navigation.tab.NaviTab;
import com.plantilla.application.views.extraComponents.menu.components.navigation.tab.NaviTabs;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;
//import com.kiroule.vaadin.businessapp.ui.views.Payments;

import java.util.ArrayList;
import java.util.Optional;

@CssImport("./styles/components/app-bar.css")
public class AppBar extends Header {

	private String CLASS_NAME = "app-bar";

	private FlexBoxLayoutMod container;

	private Button menuIcon;
	private Button contextIcon;

	private H1 title;
	private FlexBoxLayoutMod actionItems;
	private Image avatar;

	private FlexBoxLayoutMod tabContainer;
	private NaviTabs tabs;
	private ArrayList<Registration> tabSelectionListeners;
	private Button addTab;

	private TextField search;
	private Registration searchRegistration;

	public enum NaviMode {
		MENU, CONTEXTUAL
	}

	public AppBar(String title, NaviTab... tabs) {
		setClassName(CLASS_NAME);

		initMenuIcon();
		initContextIcon();
		initTitle(title);
		initSearch();
		initAvatar();
		initActionItems();
		initContainer();
		initTabs(tabs);
	}

	public void setNaviMode(NaviMode mode) {
		if (mode.equals(NaviMode.MENU)) {
			menuIcon.setVisible(true);
			contextIcon.setVisible(false);
		} else {
			menuIcon.setVisible(false);
			contextIcon.setVisible(true);
		}
	}

	private void initMenuIcon() {
		menuIcon = UIUtilsMod.createTertiaryInlineButton(VaadinIcon.MENU);
		menuIcon.addClassName(CLASS_NAME + "__navi-icon");
		menuIcon.addClickListener(e -> MainView.get().getNaviDrawer().toggle());
		UIUtilsMod.setAriaLabel("Menu", menuIcon);
		UIUtilsMod.setLineHeight("1", menuIcon);
	}

	private void initContextIcon() {
		contextIcon = UIUtilsMod
				.createTertiaryInlineButton(VaadinIcon.ARROW_LEFT);
		contextIcon.addClassNames(CLASS_NAME + "__context-icon");
		contextIcon.setVisible(false);
		UIUtilsMod.setAriaLabel("Back", contextIcon);
		UIUtilsMod.setLineHeight("1", contextIcon);
	}

	private void initTitle(String title) {
		this.title = new H1(title);
		this.title.setClassName(CLASS_NAME + "__title");
	}

	private void initSearch() {
		search = new TextField();
		search.setPlaceholder("Search");
		search.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
		search.setVisible(false);
	}

	private void initAvatar() {
		avatar = new Image();
		avatar.setClassName(CLASS_NAME + "__avatar");
		avatar.setSrc(UIUtilsMod.IMG_PATH + "avatar.webp");
		avatar.setAlt("User menu");

		ContextMenu contextMenu = new ContextMenu(avatar);
		contextMenu.setOpenOnClick(true);
		contextMenu.addItem("Settings",
				e -> Notification.show("Not implemented yet.", 3000,
						Notification.Position.BOTTOM_CENTER));
		contextMenu.addItem("Log Out",
				e -> Notification.show("Not implemented yet.", 3000,
						Notification.Position.BOTTOM_CENTER));
	}

	private void initActionItems() {
		actionItems = new FlexBoxLayoutMod();
		actionItems.addClassName(CLASS_NAME + "__action-items");
		actionItems.setVisible(false);
	}

	private void initContainer() {
		container = new FlexBoxLayoutMod(menuIcon, contextIcon, this.title, search,
				actionItems, avatar);
		container.addClassName(CLASS_NAME + "__container");
		container.setAlignItems(FlexComponent.Alignment.CENTER);
		container.setFlexGrow(1, search);
		add(container);
	}

	private void initTabs(NaviTab... tabs) {
		addTab = UIUtilsMod.createSmallButton(VaadinIcon.PLUS);
		addTab.addClickListener(e -> this.tabs
				.setSelectedTab(addClosableNaviTab("New Tab", HomeView.class)));
		addTab.setVisible(false);

		this.tabs = tabs.length > 0 ? new NaviTabs(tabs) : new NaviTabs();
		this.tabs.setClassName(CLASS_NAME + "__tabs");
		this.tabs.setVisible(false);
		for (NaviTab tab : tabs) {
			configureTab(tab);
		}

		this.tabSelectionListeners = new ArrayList<>();

		tabContainer = new FlexBoxLayoutMod(this.tabs, addTab);
		tabContainer.addClassName(CLASS_NAME + "__tab-container");
		tabContainer.setAlignItems(FlexComponent.Alignment.CENTER);
		add(tabContainer);
	}

	/* === MENU ICON === */

	public Button getMenuIcon() {
		return menuIcon;
	}

	/* === CONTEXT ICON === */

	public Button getContextIcon() {
		return contextIcon;
	}

	public void setContextIcon(Icon icon) {
		contextIcon.setIcon(icon);
	}

	/* === TITLE === */

	public Optional<String> getTitle() {
		return Optional.ofNullable(this.title.getText());
	}

	public void setTitle(String title) {
		this.title.setText(title);
	}

	/* === ACTION ITEMS === */

	public Component addActionItem(Component component) {
		actionItems.add(component);
		updateActionItemsVisibility();
		return component;
	}

	public Button addActionItem(VaadinIcon icon) {
		Button button = UIUtilsMod.createButton(icon, ButtonVariant.LUMO_SMALL,
				ButtonVariant.LUMO_TERTIARY);
		addActionItem(button);
		return button;
	}

	public void removeAllActionItems() {
		actionItems.removeAll();
		updateActionItemsVisibility();
	}

	/* === AVATAR == */

	public Image getAvatar() {
		return avatar;
	}

	/* === TABS === */

	public void centerTabs() {
		tabs.addClassName(LumoStyles.Margin.Horizontal.AUTO);
	}

	private void configureTab(Tab tab) {
		tab.addClassName(CLASS_NAME + "__tab");
		updateTabsVisibility();
	}

	public Tab addTab(String text) {
		Tab tab = tabs.addTab(text);
		configureTab(tab);
		return tab;
	}

	public Tab addTab(String text,
	                  Class<? extends Component> navigationTarget) {
		Tab tab = tabs.addTab(text, navigationTarget);
		configureTab(tab);
		return tab;
	}

	public Tab addClosableNaviTab(String text,
	                              Class<? extends Component> navigationTarget) {
		Tab tab = tabs.addClosableTab(text, navigationTarget);
		configureTab(tab);
		return tab;
	}

	public Tab getSelectedTab() {
		return tabs.getSelectedTab();
	}

	public void setSelectedTab(Tab selectedTab) {
		tabs.setSelectedTab(selectedTab);
	}

	public void updateSelectedTab(String text,
	                              Class<? extends Component> navigationTarget) {
		tabs.updateSelectedTab(text, navigationTarget);
	}

	public void navigateToSelectedTab() {
		tabs.navigateToSelectedTab();
	}

	public void addTabSelectionListener(
			ComponentEventListener<Tabs.SelectedChangeEvent> listener) {
		Registration registration = tabs.addSelectedChangeListener(listener);
		tabSelectionListeners.add(registration);
	}

	public int getTabCount() {
		return tabs.getTabCount();
	}

	public void removeAllTabs() {
		tabSelectionListeners.forEach(registration -> registration.remove());
		tabSelectionListeners.clear();
		tabs.removeAll();
		updateTabsVisibility();
	}

	/* === ADD TAB BUTTON === */

	public void setAddTabVisible(boolean visible) {
		addTab.setVisible(visible);
	}

	/* === SEARCH === */

	public void searchModeOn() {
		menuIcon.setVisible(false);
		title.setVisible(false);
		actionItems.setVisible(false);
		tabContainer.setVisible(false);

		contextIcon.setIcon(new Icon(VaadinIcon.ARROW_BACKWARD));
		contextIcon.setVisible(true);
		searchRegistration = contextIcon
				.addClickListener(e -> searchModeOff());

		search.setVisible(true);
		search.focus();
	}

	public void addSearchListener(HasValue.ValueChangeListener listener) {
		search.addValueChangeListener(listener);
	}

	public void setSearchPlaceholder(String placeholder) {
		search.setPlaceholder(placeholder);
	}

	private void searchModeOff() {
		menuIcon.setVisible(true);
		title.setVisible(true);
		tabContainer.setVisible(true);

		updateActionItemsVisibility();
		updateTabsVisibility();

		contextIcon.setVisible(false);
		searchRegistration.remove();

		search.clear();
		search.setVisible(false);
	}

	/* === RESET === */

	public void reset() {
		title.setText("");
		setNaviMode(AppBar.NaviMode.MENU);
		removeAllActionItems();
		removeAllTabs();
	}

	/* === UPDATE VISIBILITY === */

	private void updateActionItemsVisibility() {
		actionItems.setVisible(actionItems.getComponentCount() > 0);
	}

	private void updateTabsVisibility() {
		tabs.setVisible(tabs.getComponentCount() > 0);
	}
}
