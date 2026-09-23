package net.emhelpers.client.compat;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;

public final class MinecraftClientCompat {
	private MinecraftClientCompat() {
	}

	public static Screen screen(Minecraft client) {
		Object screen = tryInvokeNoArgs(client.gui, "screen");
		if (screen instanceof Screen currentScreen) {
			return currentScreen;
		}
		Object fieldValue = tryGetField(client, "screen");
		return fieldValue instanceof Screen currentScreen ? currentScreen : null;
	}

	private static Object tryGetField(Object target, String fieldName) {
		Class<?> type = target.getClass();
		while (type != null) {
			try {
				Field field = type.getDeclaredField(fieldName);
				field.setAccessible(true);
				return field.get(target);
			} catch (NoSuchFieldException ignored) {
				type = type.getSuperclass();
			} catch (IllegalAccessException exception) {
				throw new IllegalStateException("Could not read field " + fieldName + " on " + target.getClass().getName(), exception);
			}
		}
		return null;
	}

	private static Object tryInvokeNoArgs(Object target, String methodName) {
		Method method = findMethod(target.getClass(), methodName, 0);
		return method == null ? null : invoke(target, method);
	}

	private static Method findMethod(Class<?> type, String methodName, int parameterCount) {
		Class<?> current = type;
		while (current != null) {
			for (Method method : current.getDeclaredMethods()) {
				if (method.getName().equals(methodName) && method.getParameterCount() == parameterCount) {
					method.setAccessible(true);
					return method;
				}
			}
			current = current.getSuperclass();
		}
		return null;
	}

	private static Object invoke(Object target, Method method, Object... args) {
		try {
			return method.invoke(target, args);
		} catch (IllegalAccessException exception) {
			throw new IllegalStateException("Could not invoke " + method.getName() + " on " + target.getClass().getName(), exception);
		} catch (InvocationTargetException exception) {
			Throwable cause = exception.getCause();
			if (cause instanceof RuntimeException runtimeException) {
				throw runtimeException;
			}
			if (cause instanceof Error error) {
				throw error;
			}
			throw new IllegalStateException("Could not invoke " + method.getName() + " on " + target.getClass().getName(), cause);
		}
	}
}
