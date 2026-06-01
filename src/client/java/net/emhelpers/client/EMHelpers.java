package net.emhelpers.client;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import net.emhelpers.client.hud.layout.HudLayoutConfig;
import net.minecraft.util.Identifier;
import org.jspecify.annotations.Nullable;

public final class EMHelpers {
	private static String modId = "emhelpers";
	private static Supplier<@Nullable HudLayoutConfig> hudConfigSupplier = () -> null;
	private static BooleanSupplier hideHudSupplier = () -> false;

	private EMHelpers() {
	}

	public static void configure(String modId, Supplier<@Nullable HudLayoutConfig> hudConfigSupplier) {
		configure(modId, hudConfigSupplier, () -> false);
	}

	public static void configure(
		String modId,
		Supplier<@Nullable HudLayoutConfig> hudConfigSupplier,
		BooleanSupplier hideHudSupplier
	) {
		EMHelpers.modId = Objects.requireNonNull(modId, "modId");
		EMHelpers.hudConfigSupplier = Objects.requireNonNull(hudConfigSupplier, "hudConfigSupplier");
		EMHelpers.hideHudSupplier = Objects.requireNonNull(hideHudSupplier, "hideHudSupplier");
	}

	public static Identifier id(String path) {
		return Identifier.of(modId, path);
	}

	public static @Nullable HudLayoutConfig hudConfig() {
		return hudConfigSupplier.get();
	}

	public static boolean shouldHideHud() {
		return hideHudSupplier.getAsBoolean();
	}
}
