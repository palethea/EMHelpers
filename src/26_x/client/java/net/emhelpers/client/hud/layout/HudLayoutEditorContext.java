package net.emhelpers.client.hud.layout;

import net.emhelpers.client.hud.editor.HudLayoutEditorScreen;
import net.emhelpers.client.hud.editor.HudLayoutEditorOverlay;
import net.minecraft.client.Minecraft;
import org.jspecify.annotations.Nullable;

public final class HudLayoutEditorContext {
	private HudLayoutEditorContext() {
	}

	public static boolean isActive(@Nullable Minecraft client) {
		return client != null && (client.screen instanceof HudLayoutEditorScreen || HudLayoutEditorOverlay.isActive());
	}

	public static void beginVanillaHudDim() {
		HudLayoutEditorVanillaDim.begin();
	}

	public static void endVanillaHudDim() {
		HudLayoutEditorVanillaDim.end();
	}
}
