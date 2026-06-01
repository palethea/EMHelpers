package net.emhelpers.client.util;

import net.minecraft.text.Text;

public final class EMHelpersTexts {
	public static final String OPTION_ON = "emhelpers.option.on";
	public static final String OPTION_OFF = "emhelpers.option.off";
	public static final String OPTION_TOGGLE = "emhelpers.option.toggle";
	public static final String OPTION_VALUE = "emhelpers.option.value";

	public static final String SCREEN_HUD_LAYOUT_EDITOR = "emhelpers.screen.hud_layout_editor";
	public static final String HUD_LAYOUT_EDITOR_HINT = "emhelpers.hud.layout_editor.hint";
	public static final String HUD_LAYOUT_EDITOR_SAVE = "emhelpers.hud.layout_editor.save";
	public static final String HUD_LAYOUT_EDITOR_CANCEL = "emhelpers.hud.layout_editor.cancel";
	public static final String HUD_LAYOUT_EDITOR_RESET_ALL = "emhelpers.hud.layout_editor.reset_all";
	public static final String HUD_LAYOUT_MODE_ANCHOR = "emhelpers.hud.layout_mode.anchor";
	public static final String HUD_LAYOUT_MODE_CUSTOM = "emhelpers.hud.layout_mode.custom";

	public static final String HUD_ANCHOR_TOP_LEFT = "emhelpers.hud.anchor.top_left";
	public static final String HUD_ANCHOR_TOP_CENTER = "emhelpers.hud.anchor.top_center";
	public static final String HUD_ANCHOR_TOP_RIGHT = "emhelpers.hud.anchor.top_right";
	public static final String HUD_ANCHOR_BOTTOM_LEFT = "emhelpers.hud.anchor.bottom_left";
	public static final String HUD_ANCHOR_BOTTOM_CENTER = "emhelpers.hud.anchor.bottom_center";
	public static final String HUD_ANCHOR_BOTTOM_RIGHT = "emhelpers.hud.anchor.bottom_right";

	private EMHelpersTexts() {
	}

	public static Text toggleLabel(String optionKey) {
		return Text.translatable(optionKey);
	}
}
