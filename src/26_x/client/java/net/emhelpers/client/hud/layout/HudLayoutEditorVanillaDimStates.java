package net.emhelpers.client.hud.layout;

import net.minecraft.client.renderer.state.gui.BlitRenderState;
import net.minecraft.client.renderer.state.gui.ColoredRectangleRenderState;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.state.gui.GuiTextRenderState;
import net.minecraft.client.renderer.state.gui.TiledBlitRenderState;
import org.jspecify.annotations.Nullable;

public final class HudLayoutEditorVanillaDimStates {
	private HudLayoutEditorVanillaDimStates() {
	}

	public static GuiElementRenderState dimSimple(@Nullable GuiElementRenderState state) {
		if (state == null || HudLayoutEditorVanillaDim.ACTIVE.get() == null) {
			return state;
		}

		if (state instanceof ColoredRectangleRenderState quad) {
			return new ColoredRectangleRenderState(
				quad.pipeline(),
				quad.textureSetup(),
				quad.pose(),
				quad.x0(),
				quad.y0(),
				quad.x1(),
				quad.y1(),
				HudLayoutEditorVanillaDim.dimColor(quad.col1()),
				HudLayoutEditorVanillaDim.dimColor(quad.col2()),
				quad.scissorArea()
			);
		}

		if (state instanceof BlitRenderState quad) {
			return new BlitRenderState(
				quad.pipeline(),
				quad.textureSetup(),
				quad.pose(),
				quad.x0(),
				quad.y0(),
				quad.x1(),
				quad.y1(),
				quad.u0(),
				quad.u1(),
				quad.v0(),
				quad.v1(),
				HudLayoutEditorVanillaDim.dimGuiColor(quad.color()),
				quad.scissorArea()
			);
		}

		if (state instanceof TiledBlitRenderState quad) {
			return new TiledBlitRenderState(
				quad.pipeline(),
				quad.textureSetup(),
				quad.pose(),
				quad.tileWidth(),
				quad.tileHeight(),
				quad.x0(),
				quad.y0(),
				quad.x1(),
				quad.y1(),
				quad.u0(),
				quad.u1(),
				quad.v0(),
				quad.v1(),
				HudLayoutEditorVanillaDim.dimGuiColor(quad.color()),
				quad.scissorArea(),
				quad.bounds()
			);
		}

		return state;
	}

	public static GuiTextRenderState dimText(@Nullable GuiTextRenderState state) {
		if (state == null || HudLayoutEditorVanillaDim.ACTIVE.get() == null) {
			return state;
		}

		return new GuiTextRenderState(
			state.font,
			state.text,
			state.pose,
			state.x,
			state.y,
			HudLayoutEditorVanillaDim.dimColor(state.color),
			HudLayoutEditorVanillaDim.dimColor(state.backgroundColor),
			state.dropShadow,
			false,
			state.scissor
		);
	}
}
