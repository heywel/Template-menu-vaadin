package com.plantilla.application.views.extraComponents.menu.components;

import com.plantilla.application.views.extraComponents.menu.util.UIUtilsMod;
import com.plantilla.application.views.extraComponents.menu.util.css.lumo.BadgeColor;
import com.plantilla.application.views.extraComponents.menu.util.css.lumo.BadgeShape;
import com.plantilla.application.views.extraComponents.menu.util.css.lumo.BadgeSize;
import com.vaadin.flow.component.html.Span;

import java.util.StringJoiner;

public class Badge extends Span {

	public Badge(String text) {
		this(text, BadgeColor.NORMAL);
	}

	public Badge(String text, BadgeColor color) {
		super(text);
		UIUtilsMod.setTheme(color.getThemeName(), this);
	}

	public Badge(String text, BadgeColor color, BadgeSize size, BadgeShape shape) {
		super(text);
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(color.getThemeName());
		if (shape.equals(BadgeShape.PILL)) {
			joiner.add(shape.getThemeName());
		}
		if (size.equals(BadgeSize.S)) {
			joiner.add(size.getThemeName());
		}
		UIUtilsMod.setTheme(joiner.toString(), this);
	}

}
