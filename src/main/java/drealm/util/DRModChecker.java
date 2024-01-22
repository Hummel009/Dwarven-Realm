package drealm.util;

public class DRModChecker {
	private static int hasNEI = -1;
	private static int hasGuiContainer = -1;

	private DRModChecker() {
	}

	public static boolean hasGuiContainer() {
		if (hasGuiContainer == -1) {
			try {
				Class.forName("net.minecraft.client.gui.inventory.GuiContainer");
				hasGuiContainer = 1;
			} catch (ClassNotFoundException e) {
				hasGuiContainer = 0;
			}
		}
		return hasGuiContainer == 1;
	}

	public static boolean hasNEI() {
		if (hasNEI == -1) {
			try {
				Class.forName("codechicken.nei.api.API");
				hasNEI = 1;
			} catch (ClassNotFoundException e) {
				hasNEI = 0;
			}
		}
		return hasNEI == 1;
	}
}
