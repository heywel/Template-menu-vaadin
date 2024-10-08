package com.plantilla.application.views.extraComponents.menu.components.navigation.tab;

import com.plantilla.application.views.extraComponents.menu.util.FontSize;
import com.plantilla.application.views.extraComponents.menu.util.UIUtilsMod;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;

public class ClosableNaviTab extends NaviTab {

	private final Button close;

	public ClosableNaviTab(String label,
	                       Class<? extends Component> navigationTarget) {
		super(label, navigationTarget);
		getElement().setAttribute("closable", true);

		close = UIUtilsMod.createButton(VaadinIcon.CLOSE, ButtonVariant.LUMO_TERTIARY_INLINE);
		// ButtonVariant.LUMO_SMALL isn't small enough.
		UIUtilsMod.setFontSize(FontSize.XXS, close);
		add(close);
	}

	public Button getCloseButton() {
		return close;
	}
}
