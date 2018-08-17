package com.maximuspayne.navycraft.listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import com.maximuspayne.navycraft.ConfigManager;
import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.PermissionInterface;
import com.maximuspayne.shipyard.Plot;

@SuppressWarnings("deprecation")
public class NavyCraft_FileListener implements Listener {
	
	public NavyCraft_FileListener(NavyCraft p) {
	}

	public static void loadSignData() {
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		int size = list.size();
		NavyCraft.playerSigns.clear();
		if (size == 0) return;
		for (String num : list) {
			if (ConfigManager.syData.getString("Signs." + num + ".isClaimed").equalsIgnoreCase("true")) {
				String type = ConfigManager.syData.getString("Signs." + num + ".type");
				World world = NavyCraft.instance.getServer().getWorld(ConfigManager.syData.getString("Signs." + num + "." + "world"));
				int x = ConfigManager.syData.getInt("Signs." + num + ".x");
				int y = ConfigManager.syData.getInt("Signs." + num + ".y");
				int z = ConfigManager.syData.getInt("Signs." + num + ".z");
				int id = ConfigManager.syData.getInt("Signs." + num + ".id");
				String UUID = ConfigManager.syData.getString("Signs." + num + ".uuid");
				Block selectSignBlock = world.getBlockAt(x, y, z);
				if (selectSignBlock.getTypeId() == 63) {
				Sign selectSign = (Sign) selectSignBlock.getState();
				Plot plot = new Plot(type, selectSign);
				if (!NavyCraft.playerSigns.containsKey(UUID)) {
					NavyCraft.playerSigns.put(UUID, new ArrayList<Plot>());
					NavyCraft.playerSigns.get(UUID).add(plot);
					NavyCraft.playerSignIndex.put(selectSign, id);
				} else {
					NavyCraft.playerSigns.get(UUID).add(plot);
					NavyCraft.playerSignIndex.put(selectSign, id);
				}
			}
		}
	}
}

	public static Block findSignOpen(String type) {
		Block selectSignBlock = null;
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		if (list.size() == 0) return selectSignBlock;
		for (String num : list) {
			if (ConfigManager.syData.getString("Signs." + num + ".isClaimed").equalsIgnoreCase("false")) {
				String ptype = ConfigManager.syData.getString("Signs." + num + "." + "type");
				World world = NavyCraft.instance.getServer().getWorld(ConfigManager.syData.getString("Signs." + num + "." + "world"));
				int x = ConfigManager.syData.getInt("Signs." + num + "." + "x");
				int y = ConfigManager.syData.getInt("Signs." + num + "." + "y");
				int z = ConfigManager.syData.getInt("Signs." + num + "." + "z");
				if (type.equalsIgnoreCase(ptype)) {
					selectSignBlock = world.getBlockAt(x, y, z);
					if (selectSignBlock.getTypeId() == 63) {
					break;
					}
				}
			}
		}
		return selectSignBlock;
	}

	public static void saveClaimedSign(String uuid, String type, String world, int x, int y, int z, int id) {
		NavyCraft.instance.DebugMessage("UUID =" + uuid, 3);
		Block selectSignBlock = NavyCraft.instance.getServer().getWorld(world).getBlockAt(x, y, z);
		if (selectSignBlock.getTypeId() == 63) {
		Location loc = new Location(NavyCraft.instance.getServer().getWorld(world), x, y, z);
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		if (list.size() != 0) {
			for (String num : list) {
				int x1 = ConfigManager.syData.getInt("Signs." + num + "." + "x");
				int y1 = ConfigManager.syData.getInt("Signs." + num + "." + "y");
				int z1 = ConfigManager.syData.getInt("Signs." + num + "." + "z");
				String world1 = ConfigManager.syData.getString("Signs." + num + "." + "world");
				Location loc1 = new Location(NavyCraft.instance.getServer().getWorld(world1), x1, y1, z1);
				if (loc.equals(loc1)) {
					ConfigManager.syData.set("Signs." + num + "." + "type", type.toUpperCase());
					ConfigManager.syData.set("Signs." + num + "." + "world", world);
					ConfigManager.syData.set("Signs." + num + "." + "x", x);
					ConfigManager.syData.set("Signs." + num + "." + "y", y);
					ConfigManager.syData.set("Signs." + num + "." + "z", z);
					ConfigManager.syData.set("Signs." + num + "." + "isClaimed", true);
					ConfigManager.syData.set("Signs." + num + "." + "uuid", uuid);
					ConfigManager.syData.set("Signs." + num + "." + "id", id);
					break;
				}
			}
			ConfigManager.savesyData();
		}
	}
}
	
	public static void saveUnclaimedSign(String type, String world, int x, int y, int z) {
		Block selectSignBlock = NavyCraft.instance.getServer().getWorld(world).getBlockAt(x, y, z);
		if (selectSignBlock.getTypeId() == 63) {
		Location loc = new Location(NavyCraft.instance.getServer().getWorld(world), x, y, z);
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		if (list.size() != 0) {
		for (String num : list) {
			int x1 = ConfigManager.syData.getInt("Signs." + num + "." + "x");
			int y1 = ConfigManager.syData.getInt("Signs." + num + "." + "y");
			int z1 = ConfigManager.syData.getInt("Signs." + num + "." + "z");
			String world1 = ConfigManager.syData.getString("Signs." + num + "." + "world");
			Location loc1 = new Location(NavyCraft.instance.getServer().getWorld(world1), x1, y1, z1);
			if (loc.equals(loc1)) {
				ConfigManager.syData.set("Signs." + num + "." + "type", type.toUpperCase());
				ConfigManager.syData.set("Signs." + num + "." + "world", world);
				ConfigManager.syData.set("Signs." + num + "." + "x", x);
				ConfigManager.syData.set("Signs." + num + "." + "y", y);
				ConfigManager.syData.set("Signs." + num + "." + "z", z);
				ConfigManager.syData.set("Signs." + num + "." + "isClaimed", false);
				ConfigManager.syData.set("Signs." + num + "." + "uuid", null);
				ConfigManager.syData.set("Signs." + num + "." + "id", null);
				ConfigManager.syData.set("Signs." + num + "." + "members", null);
				break;
			}
		}
			ConfigManager.savesyData();
		}
	}
}
	
	public static void saveSign(String type, String world, int x, int y, int z) {
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		int size = list.size();
		ConfigManager.syData.set("Signs." + String.valueOf(size + 1) + "." + "type", type.toUpperCase());
		ConfigManager.syData.set("Signs." + String.valueOf(size + 1) + "." + "world", world);
		ConfigManager.syData.set("Signs." + String.valueOf(size + 1) + "." + "x", x);
		ConfigManager.syData.set("Signs." + String.valueOf(size + 1) + "." + "y", y);
		ConfigManager.syData.set("Signs." + String.valueOf(size + 1) + "." + "z", z);
		ConfigManager.syData.set("Signs." + String.valueOf(size + 1) + "." + "isClaimed", false);
		ConfigManager.savesyData();
}
	
	public static boolean checkSign(int x, int y, int z, World world) {
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
				World world1 = NavyCraft.instance.getServer().getWorld(ConfigManager.syData.getString("Signs." + num + "." + "world"));
				int x1 = ConfigManager.syData.getInt("Signs." + num + "." + "x");
				int y1 = ConfigManager.syData.getInt("Signs." + num + "." + "y");
				int z1 = ConfigManager.syData.getInt("Signs." + num + "." + "z");
				Location loc1 = new Location(world1, x1, y1, z1);
				Location loc = new Location(world, x, y, z);
				if (loc.equals(loc1)) {
					return true;
				}
		}
		return false;
	}
	
	public static String getSign(int x, int y, int z, World world) {
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
				World world1 = NavyCraft.instance.getServer().getWorld(ConfigManager.syData.getString("Signs." + num + "." + "world"));
				int x1 = ConfigManager.syData.getInt("Signs." + num + "." + "x");
				int y1 = ConfigManager.syData.getInt("Signs." + num + "." + "y");
				int z1 = ConfigManager.syData.getInt("Signs." + num + "." + "z");
				Location loc1 = new Location(world1, x1, y1, z1);
				Location loc = new Location(world, x, y, z);
				if (loc.equals(loc1)) {
					return num;
				}
		}
		return null;
	}
	
	public static void updateSign(String uuid, String type, int x, int y, int z, World world, int id) {
		NavyCraft.instance.DebugMessage("UUID =" + uuid, 3);
		Block selectSignBlock = world.getBlockAt(x, y, z);
		if (selectSignBlock.getTypeId() == 63) {
		Location loc = new Location(world, x, y, z);
		List<String> list = new ArrayList<String>(ConfigManager.syData.getConfigurationSection("Signs").getKeys(false));
		if (list.size() != 0) {
			for (String num : list) {
				int x1 = ConfigManager.syData.getInt("Signs." + num + "." + "x");
				int y1 = ConfigManager.syData.getInt("Signs." + num + "." + "y");
				int z1 = ConfigManager.syData.getInt("Signs." + num + "." + "z");
				String world1 = ConfigManager.syData.getString("Signs." + num + "." + "world");
				Location loc1 = new Location(NavyCraft.instance.getServer().getWorld(world1), x1, y1, z1);
				if (loc.equals(loc1)) {
					ConfigManager.syData.set("Signs." + num + "." + "type", type.toUpperCase());
					ConfigManager.syData.set("Signs." + num + "." + "world", world.getName());
					ConfigManager.syData.set("Signs." + num + "." + "x", x);
					ConfigManager.syData.set("Signs." + num + "." + "y", y);
					ConfigManager.syData.set("Signs." + num + "." + "z", z);
					ConfigManager.syData.set("Signs." + num + "." + "isClaimed", true);
					ConfigManager.syData.set("Signs." + num + "." + "uuid", uuid);
					ConfigManager.syData.set("Signs." + num + "." + "id", id);
					break;
				}
			}
			ConfigManager.savesyData();
		}
	}
}
	
	public static void loadPlayerData(String player) {
		String UUID = PermissionInterface.getUUIDfromPlayer(player);
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + UUID + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		
		// When the player file is created for the first time...
		if (!f.exists()) {
			try {
				playerData.set("exp", 0);
				
				playerData.save(f);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		// Put all the file data to hashmaps
		loadExperience(player);
	}

	public static void loadExperience(String player) {
		String UUID = PermissionInterface.getUUIDfromPlayer(player);
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + UUID + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		NavyCraft.playerExp.put(player, playerData.getInt("exp"));
	}
	
	public static void saveExperience(String player) {
		String UUID = PermissionInterface.getUUIDfromPlayer(player);
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + UUID + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		if (NavyCraft.playerExp.containsKey(player)) {
		playerData.set("exp", NavyCraft.playerExp.get(player));
		}
		try {
			playerData.save(f);
		} catch (IOException e) {
			loadPlayerData(player);
		}
	}

}