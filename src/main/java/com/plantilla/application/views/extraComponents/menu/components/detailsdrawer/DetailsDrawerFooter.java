package com.plantilla.application.views.extraComponents.menu.components.detailsdrawer;

import com.plantilla.application.views.extraComponents.menu.components.FlexBoxLayoutMod;
import com.plantilla.application.views.extraComponents.menu.size.Horizontal;
import com.plantilla.application.views.extraComponents.menu.size.Right;
import com.plantilla.application.views.extraComponents.menu.size.Vertical;
import com.plantilla.application.views.extraComponents.menu.util.LumoStyles;
import com.plantilla.application.views.extraComponents.menu.util.UIUtilsMod;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.shared.Registration;

public class DetailsDrawerFooter extends FlexBoxLayoutMod {

	private Button save;
	private Button cancel;

	public DetailsDrawerFooter() {
		setBackgroundColor(LumoStyles.Color.Contrast._5);
		setPadding(Horizontal.RESPONSIVE_L, Vertical.S);
		setSpacing(Right.S);
		setWidthFull();

		save = UIUtilsMod.createPrimaryButton("Save");
		cancel = UIUtilsMod.createTertiaryButton("Cancel");
		add(save, cancel);
	}

	public Registration addSaveListener(
			ComponentEventListener<ClickEvent<Button>> listener) {
		return save.addClickListener(listener);
	}

	public Registration addCancelListener(
			ComponentEventListener<ClickEvent<Button>> listener) {
		return cancel.addClickListener(listener);
	}

}
