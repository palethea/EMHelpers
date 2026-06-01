package net.emhelpers.client.hud.layout;

import net.emhelpers.client.util.EMHelpersTexts;

public enum HudLayoutMode {
	ANCHOR(EMHelpersTexts.HUD_LAYOUT_MODE_ANCHOR),
	CUSTOM(EMHelpersTexts.HUD_LAYOUT_MODE_CUSTOM);

	private final String labelKey;

	HudLayoutMode(String labelKey) {
		this.labelKey = labelKey;
	}

	public String labelKey() {
		return labelKey;
	}

	public HudLayoutMode next() {
		HudLayoutMode[] values = values();
		return values[(ordinal() + 1) % values.length];
	}

	public static HudLayoutMode fromName(String name) {
		if (name != null) {
			for (HudLayoutMode mode : values()) {
				if (mode.name().equals(name)) {
					return mode;
				}
			}
		}

		return ANCHOR;
	}
}
