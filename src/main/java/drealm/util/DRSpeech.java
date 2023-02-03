package drealm.util;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.zip.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.input.BOMInputStream;

import com.google.common.base.Charsets;

import cpw.mods.fml.common.*;
import drealm.DwarvenRealm;

public class DRSpeech {
	public static void onInit() {
		HashMap<String, BufferedReader> speechBankNamesAndReaders = new HashMap<>();
		ZipFile zip = null;
		try {
			ModContainer mc = DwarvenRealm.getModContainer();
			if (mc.getSource().isFile()) {
				zip = new ZipFile(mc.getSource());
				Enumeration<? extends ZipEntry> entries = zip.entries();
				while (entries.hasMoreElements()) {
					ZipEntry entry = entries.nextElement();
					String s = entry.getName();
					String path = "assets/drealm/speech/";
					if (!s.startsWith("assets/drealm/speech/") || !s.endsWith(".txt")) {
						continue;
					}
					s = s.substring(path.length());
					int i = s.indexOf(".txt");
					try {
						s = s.substring(0, i);
						BufferedReader reader = new BufferedReader(new InputStreamReader(new BOMInputStream(zip.getInputStream(entry)), Charsets.UTF_8.name()));
						speechBankNamesAndReaders.put(s, reader);
					} catch (Exception e) {
						FMLLog.severe("Failed to load Dwarven Realm speech bank " + s + "from zip file");
						e.printStackTrace();
					}
				}
			} else {
				File speechBankDir = new File(DwarvenRealm.class.getResource("/assets/drealm/speech/").toURI());
				Collection<File> subfiles = FileUtils.listFiles(speechBankDir, null, true);
				for (File subfile : subfiles) {
					String s = subfile.getPath();
					s = s.substring(speechBankDir.getPath().length() + 1);
					int i = (s = s.replace(File.separator, "/")).indexOf(".txt");
					if (i < 0) {
						FMLLog.severe("Failed to load Dwarven Realm speech bank " + s + " from MCP folder; speech bank files must be in .txt format");
						continue;
					}
					try {
						s = s.substring(0, i);
						BufferedReader reader = new BufferedReader(new InputStreamReader(new BOMInputStream(new FileInputStream(subfile)), Charsets.UTF_8.name()));
						speechBankNamesAndReaders.put(s, reader);
					} catch (Exception e) {
						FMLLog.severe("Failed to load Dwarven Realm speech bank " + s + " from MCP folder");
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			FMLLog.severe("Failed to load Dwarven Realm speech banks");
			e.printStackTrace();
		}
		for (Entry<String, BufferedReader> speechBankName : speechBankNamesAndReaders.entrySet()) {
			BufferedReader reader = speechBankName.getValue();
			try {
				String line;
				ArrayList<String> speeches = new ArrayList<>();
				ArrayList<String> allLines = new ArrayList<>();
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
					DRCommander.addSpeechBank(speechBankName.getKey(), random, speeches);
				} else {
					DRCommander.addSpeechBank(speechBankName.getKey(), random, allLines);
				}
			} catch (Exception e) {
				FMLLog.severe("Failed to load Dwarven Realm speech bank " + speechBankName.getKey());
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

