package com.plantilla.application.views.extraComponents.menu.components;

import com.plantilla.application.views.extraComponents.menu.util.FontSize;
import com.plantilla.application.views.extraComponents.menu.util.FontWeight;
import com.plantilla.application.views.extraComponents.menu.util.LumoStyles;
import com.plantilla.application.views.extraComponents.menu.util.UIUtilsMod;
import com.plantilla.application.views.extraComponents.menu.util.css.BorderRadius;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

public class Initials extends FlexBoxLayoutMod {

	private String CLASS_NAME = "initials";

	public Initials(String initials) {
		setAlignItems(FlexComponent.Alignment.CENTER);
		setBackgroundColor(LumoStyles.Color.Contrast._10);
		setBorderRadius(BorderRadius.L);
		setClassName(CLASS_NAME);
		UIUtilsMod.setFontSize(FontSize.S, this);
		UIUtilsMod.setFontWeight(FontWeight._600, this);
		setHeight(LumoStyles.Size.M);
		setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
		setWidth(LumoStyles.Size.M);

		add(initials);
	}

}
