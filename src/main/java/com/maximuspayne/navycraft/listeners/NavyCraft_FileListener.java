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
	private static ConfigManager cfgm;
	
	public NavyCraft_FileListener(NavyCraft p) {
	}

	public static void loadSignData() {
		List<String> list = new ArrayList<String>(cfgm.syData.getConfigurationSection("Signs").getKeys(false));
		int size = list.size();
		NavyCraft.playerSigns.clear();
		if (size == 0) return;
		for (String num : list) {
			if (cfgm.syData.getString("Signs." + num + ".isClaimed").equalsIgnoreCase("true")) {
				String type = cfgm.syData.getString("Signs." + num + ".type");
				World world = NavyCraft.instance.getServer().getWorld(cfgm.syData.getString("Signs." + num + "." + "world"));
				int x = cfgm.syData.getInt("Signs." + num + ".x");
				int y = cfgm.syData.getInt("Signs." + num + ".y");
				int z = cfgm.syData.getInt("Signs." + num + ".z");
				int id = cfgm.syData.getInt("Signs." + num + ".id");
				String UUID = cfgm.syData.getString("Signs." + num + ".uuid");
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
		List<String> list = new ArrayList<String>(cfgm.syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
			if (cfgm.syData.getString("Signs." + num + ".isClaimed").equalsIgnoreCase("false")) {
				String ptype = cfgm.syData.getString("Signs." + num + "." + "type");
				World world = NavyCraft.instance.getServer().getWorld(cfgm.syData.getString("Signs." + num + "." + "world"));
				int x = cfgm.syData.getInt("Signs." + num + "." + "x");
				int y = cfgm.syData.getInt("Signs." + num + "." + "y");
				int z = cfgm.syData.getInt("Signs." + num + "." + "z");
				if (type == ptype) {
					selectSignBlock = world.getBlockAt(x, y, z);
					if (selectSignBlock.getTypeId() == 63) {
					break;
					}
				}
			}
		}
		return selectSignBlock;
	}

	public static void saveClaimedSign(String player, String type, String world, int x, int y, int z, int id) {
		Block selectSignBlock = NavyCraft.instance.getServer().getWorld(world).getBlockAt(x, y, z);
		if (selectSignBlock.getTypeId() == 63) {
		Location loc = new Location(NavyCraft.instance.getServer().getWorld(world), x, y, z);
		String UUID = PermissionInterface.getUUIDfromPlayer(player);
		List<String> list = new ArrayList<String>(cfgm.syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
			int x1 = cfgm.syData.getInt("Signs." + num + "." + "x");
			int y1 = cfgm.syData.getInt("Signs." + num + "." + "y");
			int z1 = cfgm.syData.getInt("Signs." + num + "." + "z");
			String world1 = cfgm.syData.getString("Signs." + num + "." + "world");
			Location loc1 = new Location(NavyCraft.instance.getServer().getWorld(world1), x1, y1, z1);
			if (loc.equals(loc1)) {
				cfgm.syData.set("Signs." + num + "." + "type", type.toUpperCase());
				cfgm.syData.set("Signs." + num + "." + "world", world);
				cfgm.syData.set("Signs." + num + "." + "x", x);
				cfgm.syData.set("Signs." + num + "." + "y", y);
				cfgm.syData.set("Signs." + num + "." + "z", z);
				cfgm.syData.set("Signs." + num + "." + "isClaimed", true);
				cfgm.syData.set("Signs." + num + "." + "uuid", UUID);
				cfgm.syData.set("Signs." + num + "." + "id", id);
				break;
			}
		}
		cfgm.savesyData();
	}
}
	
	public static void saveUnclaimedSign(String type, String world, int x, int y, int z) {
		Block selectSignBlock = NavyCraft.instance.getServer().getWorld(world).getBlockAt(x, y, z);
		if (selectSignBlock.getTypeId() == 63) {
		Location loc = new Location(NavyCraft.instance.getServer().getWorld(world), x, y, z);
		List<String> list = new ArrayList<String>(cfgm.syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
			int x1 = cfgm.syData.getInt("Signs." + num + "." + "x");
			int y1 = cfgm.syData.getInt("Signs." + num + "." + "y");
			int z1 = cfgm.syData.getInt("Signs." + num + "." + "z");
			String world1 = cfgm.syData.getString("Signs." + num + "." + "world");
			Location loc1 = new Location(NavyCraft.instance.getServer().getWorld(world1), x1, y1, z1);
			if (loc.equals(loc1)) {
				cfgm.syData.set("Signs." + num + "." + "type", type.toUpperCase());
				cfgm.syData.set("Signs." + num + "." + "world", world);
				cfgm.syData.set("Signs." + num + "." + "x", x);
				cfgm.syData.set("Signs." + num + "." + "y", y);
				cfgm.syData.set("Signs." + num + "." + "z", z);
				cfgm.syData.set("Signs." + num + "." + "isClaimed", false);
				cfgm.syData.set("Signs." + num + "." + "uuid", null);
				cfgm.syData.set("Signs." + num + "." + "id", null);
				break;
			}
		}
		cfgm.savesyData();
	}
}
	
	public static void saveSign(String type, String world, int x, int y, int z) {
		List<String> list = new ArrayList<String>(cfgm.syData.getConfigurationSection("Signs").getKeys(false));
		int size = list.size();
		cfgm.syData.set("Signs." + String.valueOf(size + 1) + "." + "type", type.toUpperCase());
		cfgm.syData.set("Signs." + String.valueOf(size + 1) + "." + "world", world);
		cfgm.syData.set("Signs." + String.valueOf(size + 1) + "." + "x", x);
		cfgm.syData.set("Signs." + String.valueOf(size + 1) + "." + "y", y);
		cfgm.syData.set("Signs." + String.valueOf(size + 1) + "." + "z", z);
		cfgm.syData.set("Signs." + String.valueOf(size + 1) + "." + "isClaimed", false);
		cfgm.savesyData();
}
	
	public static boolean checkSign(int x, int y, int z, World world) {
		List<String> list = new ArrayList<String>(cfgm.syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
				World world1 = NavyCraft.instance.getServer().getWorld(cfgm.syData.getString("Signs." + num + "." + "world"));
				int x1 = cfgm.syData.getInt("Signs." + num + "." + "x");
				int y1 = cfgm.syData.getInt("Signs." + num + "." + "y");
				int z1 = cfgm.syData.getInt("Signs." + num + "." + "z");
				Location loc1 = new Location(world1, x1, y1, z1);
				Location loc = new Location(world, x, y, z);
				if (loc.equals(loc1)) {
					return true;
				}
		}
		return false;
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
				playerData.set("SHIP1", 0);
				playerData.set("SHIP2", 0);
				playerData.set("SHIP3", 0);
				playerData.set("SHIP4", 0);
				playerData.set("SHIP5", 0);
				playerData.set("HANGAR1", 0);
				playerData.set("HANGAR2", 0);
				playerData.set("TANK1", 0);
				playerData.set("TANK2", 0);
				playerData.set("MAP1", 0);
				playerData.set("MAP2", 0);
				playerData.set("MAP3", 0);
				playerData.set("MAP4", 0);
				playerData.set("MAP5", 0);
				playerData.set("wepvolume", 5.0);
				playerData.set("engvolume", 5.0);
				playerData.set("othervolume", 5.0);
				
				playerData.save(f);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		// Put all the file data to hashmaps
		loadExperience(player);
		loadVolume(player);
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
	
	public static void loadVolume(String player) {
		String UUID = PermissionInterface.getUUIDfromPlayer(player);
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + UUID + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		NavyCraft.playerEngineVolumes.put(NavyCraft.instance.getServer().getPlayer(player),Float.valueOf(playerData.get("engvolume").toString()));
		NavyCraft.playerWeaponVolumes.put(NavyCraft.instance.getServer().getPlayer(player),Float.valueOf(playerData.get("wepvolume").toString()));
		NavyCraft.playerOtherVolumes.put(NavyCraft.instance.getServer().getPlayer(player),Float.valueOf(playerData.get("othervolume").toString()));
		NavyCraft.instance.DebugMessage("Engine V:" + NavyCraft.playerEngineVolumes.get(NavyCraft.instance.getServer().getPlayer(player)).toString(), 3);
		NavyCraft.instance.DebugMessage("Weapon V:" + NavyCraft.playerWeaponVolumes.get(NavyCraft.instance.getServer().getPlayer(player)).toString(), 3);
		NavyCraft.instance.DebugMessage("Other V:" + NavyCraft.playerOtherVolumes.get(NavyCraft.instance.getServer().getPlayer(player)).toString(), 3);
	}
	
	public static void saveVolume(String player) {
		String UUID = PermissionInterface.getUUIDfromPlayer(player);
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + UUID + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		if (NavyCraft.playerWeaponVolumes.containsKey(NavyCraft.instance.getServer().getPlayer(player))) {
		playerData.set("wepvolume",NavyCraft.playerWeaponVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
		}
		if (NavyCraft.playerEngineVolumes.containsKey(NavyCraft.instance.getServer().getPlayer(player))) {
		playerData.set("engvolume",NavyCraft.playerEngineVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
		}
		if (NavyCraft.playerOtherVolumes.containsKey(NavyCraft.instance.getServer().getPlayer(player))) {
		playerData.set("othervolume",NavyCraft.playerOtherVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
		}
		try {
			playerData.save(f);
		} catch (IOException e) {
			loadPlayerData(player);
		}
	}
	
	public static void loadRewardsFile(String player) {
		String UUID = PermissionInterface.getUUIDfromPlayer(player);
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + UUID + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		
		if (playerData.getInt("SHIP1") > 0) {
			if (NavyCraft.playerSHIP1Rewards.containsKey(UUID)) {
				NavyCraft.playerSHIP1Rewards.put(UUID, NavyCraft.playerSHIP1Rewards.get(UUID) + playerData.getInt("SHIP1"));
			} else {
				NavyCraft.playerSHIP1Rewards.put(UUID, playerData.getInt("SHIP1"));
			}
		}
		if (playerData.getInt("SHIP2") > 0) {
			if (NavyCraft.playerSHIP2Rewards.containsKey(UUID)) {
				NavyCraft.playerSHIP2Rewards.put(UUID, NavyCraft.playerSHIP2Rewards.get(UUID) + playerData.getInt("SHIP2"));
			} else {
				NavyCraft.playerSHIP2Rewards.put(UUID, playerData.getInt("SHIP2"));
			}
		}
		if (playerData.getInt("SHIP3") > 0) {
			if (NavyCraft.playerSHIP3Rewards.containsKey(UUID)) {
				NavyCraft.playerSHIP3Rewards.put(UUID, NavyCraft.playerSHIP3Rewards.get(UUID) + playerData.getInt("SHIP3"));
			} else {
				NavyCraft.playerSHIP3Rewards.put(UUID, playerData.getInt("SHIP3"));
			}
		}
		if (playerData.getInt("SHIP4") > 0) {
			if (NavyCraft.playerSHIP4Rewards.containsKey(UUID)) {
				NavyCraft.playerSHIP4Rewards.put(UUID, NavyCraft.playerSHIP4Rewards.get(UUID) + playerData.getInt("SHIP4"));
			} else {
				NavyCraft.playerSHIP4Rewards.put(UUID, playerData.getInt("SHIP4"));
			}
		}
		if (playerData.getInt("SHIP5") > 0) {
			if (NavyCraft.playerSHIP5Rewards.containsKey(UUID)) {
				NavyCraft.playerSHIP5Rewards.put(UUID, NavyCraft.playerSHIP5Rewards.get(UUID) + playerData.getInt("SHIP5"));
			} else {
				NavyCraft.playerSHIP5Rewards.put(UUID, playerData.getInt("SHIP5"));
			}
		}
		if (playerData.getInt("HANGAR1") > 0) {
			if (NavyCraft.playerHANGAR1Rewards.containsKey(UUID)) {
				NavyCraft.playerHANGAR1Rewards.put(UUID, NavyCraft.playerHANGAR1Rewards.get(UUID) + playerData.getInt("HANGAR1"));
			} else {
				NavyCraft.playerHANGAR1Rewards.put(UUID, playerData.getInt("HANGAR1"));
			}
		}
		if (playerData.getInt("HANGAR2") > 0) {
			if (NavyCraft.playerHANGAR2Rewards.containsKey(UUID)) {
				NavyCraft.playerHANGAR2Rewards.put(UUID, NavyCraft.playerHANGAR2Rewards.get(UUID) + playerData.getInt("HANGAR2"));
			} else {
				NavyCraft.playerHANGAR2Rewards.put(UUID, playerData.getInt("HANGAR2"));
			}
		}
		if (playerData.getInt("TANK1") > 0) {
			if (NavyCraft.playerTANK1Rewards.containsKey(UUID)) {
				NavyCraft.playerTANK1Rewards.put(UUID, NavyCraft.playerTANK1Rewards.get(UUID) + playerData.getInt("TANK1"));
			} else {
				NavyCraft.playerTANK1Rewards.put(UUID, playerData.getInt("TANK1"));
			}
		}
		if (playerData.getInt("TANK2") > 0) {
			if (NavyCraft.playerTANK2Rewards.containsKey(UUID)) {
				NavyCraft.playerTANK2Rewards.put(UUID, NavyCraft.playerTANK2Rewards.get(UUID) + playerData.getInt("TANK2"));
			} else {
				NavyCraft.playerTANK2Rewards.put(UUID, playerData.getInt("TANK2"));
			}
		}
		if (playerData.getInt("MAP1") > 0) {
			if (NavyCraft.playerMAP1Rewards.containsKey(UUID)) {
				NavyCraft.playerMAP1Rewards.put(UUID, NavyCraft.playerMAP1Rewards.get(UUID) + playerData.getInt("MAP1"));
			} else {
				NavyCraft.playerMAP1Rewards.put(UUID, playerData.getInt("MAP1"));
			}
		}
		if (playerData.getInt("MAP2") > 0) {
			if (NavyCraft.playerMAP2Rewards.containsKey(UUID)) {
				NavyCraft.playerMAP2Rewards.put(UUID, NavyCraft.playerMAP2Rewards.get(UUID) + playerData.getInt("MAP2"));
			} else {
				NavyCraft.playerMAP2Rewards.put(UUID, playerData.getInt("MAP2"));
			}
		}
		if (playerData.getInt("MAP3") > 0) {
			if (NavyCraft.playerMAP3Rewards.containsKey(UUID)) {
				NavyCraft.playerMAP3Rewards.put(UUID, NavyCraft.playerMAP3Rewards.get(UUID) + playerData.getInt("MAP3"));
			} else {
				NavyCraft.playerMAP3Rewards.put(UUID, playerData.getInt("MAP3"));
			}
		}
		if (playerData.getInt("MAP4") > 0) {
			if (NavyCraft.playerMAP4Rewards.containsKey(UUID)) {
				NavyCraft.playerMAP4Rewards.put(UUID, NavyCraft.playerMAP4Rewards.get(UUID) + playerData.getInt("MAP4"));
			} else {
				NavyCraft.playerMAP4Rewards.put(UUID, playerData.getInt("MAP4"));
			}
		}
		if (playerData.getInt("MAP5") > 0) {
			if (NavyCraft.playerMAP5Rewards.containsKey(UUID)) {
				NavyCraft.playerMAP5Rewards.put(UUID, NavyCraft.playerMAP5Rewards.get(UUID) + playerData.getInt("MAP5"));
			} else {
				NavyCraft.playerMAP5Rewards.put(UUID, playerData.getInt("MAP5"));
			}
		}
		try {
			playerData.save(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public static void saveRewardsFile(String player, String type, int newRewNum) {
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + player + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		if (type != null) {
			playerData.set(type.toUpperCase(), Integer.valueOf(playerData.get(type.toUpperCase()).toString()) + newRewNum);
			try {
				playerData.save(f);
			} catch (IOException e) {
				loadPlayerData(player);
			}
			return;
		}
	}

}