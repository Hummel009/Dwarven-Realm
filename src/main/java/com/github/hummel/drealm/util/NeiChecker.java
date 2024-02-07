package com.github.hummel.drealm.util;

public class NeiChecker {
	private static int hasNEI = -1;

	private NeiChecker() {
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
