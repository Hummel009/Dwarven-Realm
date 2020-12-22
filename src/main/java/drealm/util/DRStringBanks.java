package drealm.util;

import java.io.InputStream;
import java.util.*;

import lotr.common.util.LOTRLog;
import net.minecraft.util.ResourceLocation;

public class DRStringBanks {
	public static Map<String, String[]> loadStringBank(ResourceLocation res, String extension) {
		Map<String, InputStream> readers = DRResourceHelper.getInputStreams(res, extension);
		HashMap<String, String[]> stringBanks = new HashMap<>();
		for (Map.Entry<String, InputStream> entry : readers.entrySet()) {
			String name = entry.getKey();
			String[] lines = DRInputStreamUtils.getAsStringArray(entry.getValue(), false);
			if (lines.length == 0) {
				LOTRLog.logger.warn("String bank " + name + " from " + res);
				continue;
			}
			stringBanks.put(name, lines);
		}
		if (stringBanks.isEmpty()) {
			LOTRLog.logger.error("Found no string bank in " + res);
		} else {
			LOTRLog.logger.info("Loaded " + stringBanks.size() + " banks in " + res);
		}
		return stringBanks;
	}
}
