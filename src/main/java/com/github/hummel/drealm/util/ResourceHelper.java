package com.github.hummel.drealm.util;

import com.github.hummel.drealm.Config;
import com.github.hummel.drealm.Main;
import com.github.hummel.drealm.api.API;
import com.google.common.base.Charsets;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ModContainer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.BOMInputStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ResourceHelper {
	private static final String FAILED = "Failed to load Dwarven Realm speech bank ";

	private ResourceHelper() {
	}

	public static void loadSpeeechBanks() {
		Map<String, BufferedReader> speechBankNamesAndReaders = new HashMap<>();
		ZipFile zip = null;
		String addition = Config.enableRussian ? "rus/" : "eng/";
		try {
			ModContainer mc = API.getModContainer();
			if (mc.getSource().isFile()) {
				zip = new ZipFile(mc.getSource());
				Enumeration<? extends ZipEntry> entries = zip.entries();
				while (entries.hasMoreElements()) {
					ZipEntry entry = entries.nextElement();
					String s = entry.getName();
					if (!s.startsWith("assets/drealm/speech/" + addition) || !s.endsWith(".txt")) {
						continue;
					}
					String path = "assets/drealm/speech/" + addition;
					s = s.substring(path.length());
					int i = s.indexOf(".txt");
					try {
						s = s.substring(0, i);
						BufferedReader reader = new BufferedReader(new InputStreamReader(new BOMInputStream(zip.getInputStream(entry)), Charsets.UTF_8));
						speechBankNamesAndReaders.put(s, reader);
					} catch (Exception e) {
						FMLLog.severe(FAILED + s + "from zip file");
						e.printStackTrace();
					}
				}
			} else {
				File speechBankDir = new File(Main.class.getResource("/assets/drealm/speech/" + addition).toURI());
				Collection<File> subfiles = FileUtils.listFiles(speechBankDir, null, true);
				for (File subfile : subfiles) {
					String s = subfile.getPath();
					s = s.substring(speechBankDir.getPath().length() + 1);
					int i = (s = s.replace(File.separator, "/")).indexOf(".txt");
					if (i < 0) {
						FMLLog.severe(FAILED + s + " from MCP folder; speech bank files must be in .txt format");
						continue;
					}
					try {
						s = s.substring(0, i);
						BufferedReader reader = new BufferedReader(new InputStreamReader(new BOMInputStream(Files.newInputStream(subfile.toPath())), Charsets.UTF_8));
						speechBankNamesAndReaders.put(s, reader);
					} catch (Exception e) {
						FMLLog.severe(FAILED + s + " from MCP folder");
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			FMLLog.severe("Failed to load Dwarven Realm speech banks");
			e.printStackTrace();
		}
		for (Map.Entry<String, BufferedReader> speechBankName : speechBankNamesAndReaders.entrySet()) {
			BufferedReader reader = speechBankName.getValue();
			try {
				String line;
				List<String> speeches = new ArrayList<>();
				List<String> allLines = new ArrayList<>();
				boolean random = true;
				while ((line = reader.readLine()) != null) {
					if ("!RANDOM".equals(line)) {
						random = false;
					} else {
						speeches.add(line);
					}
					allLines.add(line);
				}
				reader.close();
				if (speeches.isEmpty()) {
					FMLLog.severe("Dwarven Realm speech bank " + speechBankName.getKey() + " is empty!");
					continue;
				}
				if (random) {
					API.addSpeechBank(speechBankName.getKey(), true, speeches);
				} else {
					API.addSpeechBank(speechBankName.getKey(), false, allLines);
				}
			} catch (Exception e) {
				FMLLog.severe(FAILED + speechBankName.getKey());
				e.printStackTrace();
			}
		}
		if (zip != null) {
			try {
				zip.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

