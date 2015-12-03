package com.superzanti.serversync;

import java.util.Arrays;
import java.util.List;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ServerSyncConfig {
	protected static Configuration config;
	protected static String SERVER_IP;
	protected static int SERVER_PORT;
	protected static int MINECRAFT_PORT;
	protected static String SECURE_CHECK;
	protected static String SECURE_CHECKMODS;
	protected static String SECURE_RECURSIVE;
	protected static String SECURE_CHECKSUM;
	protected static String SECURE_UPDATE;
	protected static String SECURE_EXISTS;
	protected static String SECURE_EXIT;
	public static List<String> IGNORE_LIST;
	public static int BUTTON_ID;
	public static String LAST_UPDATE;
	
	/**
	 * Loads/Initializes config parameters from serversync.cfg
	 * @param PreEvent forge pre-initialization event
	 */
	public static void init(FMLPreInitializationEvent PreEvent) {
		config = new Configuration(PreEvent.getSuggestedConfigurationFile());
		config.load();

		SERVER_IP = config.getString("SERVER_IP", "ServerConnection", "127.0.0.1", "The IP address of the server");
		SERVER_PORT = config.getInt("SERVER_PORT", "ServerConnection", 38067, 1, 49151,
				"The port that your server will be serving on");
		MINECRAFT_PORT = config.getInt("MINECRAFT_PORT", "ServerConnection", 25565, 1, 49151,
				"The port in which the minecraft server is running, not the serversync port");

		SECURE_CHECK = config.getString("SECURE_CHECK", "ServerEncryption", "0ba4439ee9a46d9d9f14c60f88f45f87",
				"The check command security key phrase");
		SECURE_CHECKMODS = config.getString("SECURE_CHECKMODS", "ServerEncryption", "3dd3152ae3e427aa2817df12570ea708",
				"The check-mods command security key phrase");
		SECURE_RECURSIVE = config.getString("SECURE_RECURSIVE", "ServerEncryption", "f8e45531a3ea3d5c1247b004985175a4",
				"The recursive command security key phrase");
		SECURE_CHECKSUM = config.getString("SECURE_CHECKSUM", "ServerEncryption", "226190d94b21d1b0c7b1a42d855e419d",
				"The checksum command security key phrase");
		SECURE_UPDATE = config.getString("SECURE_UPDATE", "ServerEncryption", "3ac340832f29c11538fbe2d6f75e8bcc",
				"The update command security key phrase");
		SECURE_EXISTS = config.getString("SECURE_EXISTS", "ServerEncryption", "e087923eb5dd1310f5f25ddd5ae5b580",
				"The exists command security key phrase");
		SECURE_EXIT = config.getString("SECURE_EXIT", "ServerEncryption", "f24f62eeb789199b9b2e467df3b1876b",
				"The exit command security key phrase");

		String[] defaultList = { "./mods/CustomMainMenu-MC1.7.10-1.5.jar", "./config/CustomMainMenu/mainmenu.json",
				"./config/forge.cfg", "./config/forgeChunkLoading.cfg", "./config/splash.properties" };
		// String[] ignoreList = config.getStringList("IGNORE_LIST",
		// "IgnoredFiles", defaultList, "These files are ignored by
		// serversync");

		Property ignoreList = config.get("IgnoredFiles", "IGNORE_LIST", defaultList,
				"These files are ignored by serversync. DO NOT IGNORE serversync.cfg");
		IGNORE_LIST = Arrays.asList(ignoreList.getStringList());

		BUTTON_ID = config.getInt("ButtonID", "GUI", 6001, 0, 2147483647,
				"The ID of the button that connects to the server and updates");

		LAST_UPDATE = config.getString("LAST_UPDATE", "StorageVariables", "20150608_000500",
				"DO NOT EDIT THIS LINE UNLESS YOU KNOW WHAT YOU ARE DOING! (If you are a server feel free to change it as much as you want to update your clients)");

		// loading the configuration from its file
		config.save();
	}
}