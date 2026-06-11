package net.emhelpers.client.gui.widget;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import net.emhelpers.client.util.EMHelpersTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public final class ConfigToggleButton {
	public static final int DEFAULT_WIDTH = 200;

	private ConfigToggleButton() {
	}

	public static ButtonWidget create(Text label, BooleanSupplier getter, Consumer<Boolean> setter) {
		return ButtonWidget.builder(message(label, getter), button -> {
			setter.accept(!getter.getAsBoolean());
			button.setMessage(message(label, getter));
		}).width(DEFAULT_WIDTH).build();
	}

	public static ButtonWidget create(String labelKey, BooleanSupplier getter, Consumer<Boolean> setter) {
		return create(Text.translatable(labelKey), getter, setter);
	}

	private static Text message(Text label, BooleanSupplier getter) {
		Text state = Text.translatable(getter.getAsBoolean() ? EMHelpersTexts.optionOn() : EMHelpersTexts.optionOff());
		return Text.translatable(EMHelpersTexts.optionToggle(), label, state);
	}
}
