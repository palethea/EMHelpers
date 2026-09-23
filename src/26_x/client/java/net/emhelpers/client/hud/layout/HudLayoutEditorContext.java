package net.emhelpers.client.hud.layout;

import net.emhelpers.client.hud.editor.HudLayoutEditorScreen;
import net.emhelpers.client.hud.editor.HudLayoutEditorOverlay;
import net.emhelpers.client.compat.MinecraftClientCompat;
import net.minecraft.client.Minecraft;
import org.jspecify.annotations.Nullable;

public final class HudLayoutEditorContext {
	private HudLayoutEditorContext() {
	}

	public static boolean isActive(@Nullable Minecraft client) {
		return client != null && (MinecraftClientCompat.screen(client) instanceof HudLayoutEditorScreen || HudLayoutEditorOverlay.isActive());
	}

	public static void beginVanillaHudDim() {
		HudLayoutEditorVanillaDim.begin();
	}

	public static void endVanillaHudDim() {
		HudLayoutEditorVanillaDim.end();
	}
}
