package com.plantilla.application.views.extraComponents.menu.util.css;

public enum PointerEventsMod {

	AUTO("auto"), NONE("none");

	private String value;

	PointerEventsMod(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
