package net.emhelpers.client.hud.layout;

import net.emhelpers.client.hud.editor.HudLayoutEditorScreen;
import net.emhelpers.client.hud.editor.HudLayoutEditorOverlay;
import net.minecraft.client.MinecraftClient;
import org.jspecify.annotations.Nullable;

public final class HudLayoutEditorContext {
	private HudLayoutEditorContext() {
	}

	public static boolean isActive(@Nullable MinecraftClient client) {
		return client != null && (client.currentScreen instanceof HudLayoutEditorScreen || HudLayoutEditorOverlay.isActive());
	}

	public static void beginVanillaHudDim() {
		HudLayoutEditorVanillaDim.begin();
	}

	public static void endVanillaHudDim() {
		HudLayoutEditorVanillaDim.end();
	}
}
