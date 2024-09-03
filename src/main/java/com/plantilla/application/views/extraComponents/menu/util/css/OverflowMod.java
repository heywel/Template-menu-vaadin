package com.plantilla.application.views.extraComponents.menu.util.css;

public enum OverflowMod {

	AUTO("auto"), HIDDEN("hidden"), SCROLL("scroll"), VISIBLE("visible");

	private String value;

	OverflowMod(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
