package com.plantilla.application.views.extraComponents.menu.util.css;

public enum TextAlignMod {

	CENTER("center"),
	JUSTIFY("justify"),
	LEFT("left"),
	RIGHT("right");

	private String value;

	TextAlignMod(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
