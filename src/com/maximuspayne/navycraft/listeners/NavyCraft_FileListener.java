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

import com.maximuspayne.navycraft.NavyCraft;

@SuppressWarnings("deprecation")
public class NavyCraft_FileListener implements Listener {

	public NavyCraft_FileListener(NavyCraft p) {
	}
	
	public static void loadShipyardData() {
		File shipyarddata = new File(
		NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
		File.separator + "shipyarddata");
		File f = new File(shipyarddata, File.separator + "signs.yml");
		FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
		
		// When the file is created for the first time...
		if (!f.exists()) {
			try {
				syData.createSection("Signs");
				
				syData.save(f);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
	}
}
	public static void loadShipyardConfig() {
		File shipyarddata = new File(
		NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
		File.separator + "shipyarddata");
		File c = new File(shipyarddata, File.separator + "config.yml");
		FileConfiguration syConfig = YamlConfiguration.loadConfiguration(c);
		if (!c.exists()) {
			try {
				syConfig.set("SHIP1World", "Shipyard");
				syConfig.set("SHIP1SX", 601);
				syConfig.set("SHIP1EX", 1567);
				syConfig.set("SHIP1WX", 14);
				syConfig.set("SHIP1Y", 64);
				syConfig.set("SHIP1SZ", -408);
				syConfig.set("SHIP1EZ", -852);
				syConfig.set("SHIP1WZ", 37);
				syConfig.set("SHIP2World", "Shipyard");
				syConfig.set("SHIP2SX", 601);
				syConfig.set("SHIP2EX", 1421);
				syConfig.set("SHIP2WX", 10);
				syConfig.set("SHIP2Y", 64);
				syConfig.set("SHIP2SZ", -356);
				syConfig.set("SHIP2EZ", -148);
				syConfig.set("SHIP2WZ", 52);
				syConfig.set("SHIP3World", "Shipyard");
				syConfig.set("SHIP3SX", 549);
				syConfig.set("SHIP3EX", 21);
				syConfig.set("SHIP3WX", 12);
				syConfig.set("SHIP3Y", 64);
				syConfig.set("SHIP3SZ", -329);
				syConfig.set("SHIP3EZ", -92);
				syConfig.set("SHIP3WZ", 79);
				syConfig.set("SHIP4World", "Shipyard");
				syConfig.set("SHIP4SX", 543);
				syConfig.set("SHIP4EX", 21);
				syConfig.set("SHIP4WX", 18);
				syConfig.set("SHIP4Y", 64);
				syConfig.set("SHIP4SZ", -408);
				syConfig.set("SHIP4EZ", -600);
				syConfig.set("SHIP4WZ", 64);
				syConfig.set("SHIP5World", "Shipyard");
				syConfig.set("SHIP5SX", 656);
				syConfig.set("SHIP5EX", 1426);
				syConfig.set("SHIP5WX", 18);
				syConfig.set("SHIP5Y", 64);
				syConfig.set("SHIP5SZ", 142);
				syConfig.set("SHIP5EZ", 37);
				syConfig.set("SHIP5WZ", 105);
				syConfig.set("HANGAR1World", "Shipyard");
				syConfig.set("HANGAR1SX", 553);
				syConfig.set("HANGAR1EX", -137);
				syConfig.set("HANGAR1WX", 23);
				syConfig.set("HANGAR1Y", 65);
				syConfig.set("HANGAR1SZ", -766);
				syConfig.set("HANGAR1EZ", -1191);
				syConfig.set("HANGAR1WZ", 25);
				syConfig.set("HANGAR2World", "Shipyard");
				syConfig.set("HANGAR2SX", -99);
				syConfig.set("HANGAR2EX", -1177);
				syConfig.set("HANGAR2WX", 49);
				syConfig.set("HANGAR2Y", 65);
				syConfig.set("HANGAR2SZ", 67);
				syConfig.set("HANGAR2EZ", -117);
				syConfig.set("HANGAR2WZ", 46);
				syConfig.set("TANK1World", "Shipyard");
				syConfig.set("TANK1SX", 602);
				syConfig.set("TANK1EX", 926);
				syConfig.set("TANK1WX", 18);
				syConfig.set("TANK1Y", 65);
				syConfig.set("TANK1SZ", -953);
				syConfig.set("TANK1EZ", -1385);
				syConfig.set("TANK1WZ", 24);
				syConfig.set("TANK2World", "Shipyard");
				syConfig.set("TANK2SX", 960);
				syConfig.set("TANK2EX", 1436);
				syConfig.set("TANK2WX", 34);
				syConfig.set("TANK2Y", 65);
				syConfig.set("TANK2SZ", -920);
				syConfig.set("TANK2EZ", -1361);
				syConfig.set("TANK2WZ", 44);
				
				syConfig.save(c);
			} catch (IOException exception) {
				exception.printStackTrace();
		}
	}
}

	public static void loadSignData() {
		File shipyarddata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "shipyarddata");
		File f = new File(shipyarddata, File.separator + "signs.yml");
		FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
		List<String> list = new ArrayList<String>(syData.getConfigurationSection("Signs").getKeys(false));
		int size = list.size();
		for (String s : NavyCraft.playerSHIP1Signs.keySet()) {
			NavyCraft.playerSHIP1Signs.get(s).clear();
		}
		NavyCraft.playerSHIP1Signs.clear();
		for (String s : NavyCraft.playerSHIP2Signs.keySet()) {
			NavyCraft.playerSHIP2Signs.get(s).clear();
		}
		NavyCraft.playerSHIP2Signs.clear();
		for (String s : NavyCraft.playerSHIP3Signs.keySet()) {
			NavyCraft.playerSHIP3Signs.get(s).clear();
		}
		NavyCraft.playerSHIP3Signs.clear();
		for (String s : NavyCraft.playerSHIP4Signs.keySet()) {
			NavyCraft.playerSHIP4Signs.get(s).clear();
		}
		NavyCraft.playerSHIP4Signs.clear();
		for (String s : NavyCraft.playerSHIP5Signs.keySet()) {
			NavyCraft.playerSHIP5Signs.get(s).clear();
		}
		NavyCraft.playerSHIP5Signs.clear();
		for (String s : NavyCraft.playerHANGAR1Signs.keySet()) {
			NavyCraft.playerHANGAR1Signs.get(s).clear();
		}
		NavyCraft.playerHANGAR1Signs.clear();
		for (String s : NavyCraft.playerHANGAR2Signs.keySet()) {
			NavyCraft.playerHANGAR2Signs.get(s).clear();
		}
		NavyCraft.playerHANGAR2Signs.clear();
		for (String s : NavyCraft.playerTANK1Signs.keySet()) {
			NavyCraft.playerTANK1Signs.get(s).clear();
		}
		NavyCraft.playerTANK1Signs.clear();
		for (String s : NavyCraft.playerTANK2Signs.keySet()) {
			NavyCraft.playerTANK2Signs.get(s).clear();
		}
		NavyCraft.playerTANK2Signs.clear();
		for (String s : NavyCraft.playerSHIP1Signs.keySet()) {
			NavyCraft.playerSHIP1Signs.get(s).clear();
		}
		NavyCraft.playerMAP1Signs.clear();
		for (String s : NavyCraft.playerMAP2Signs.keySet()) {
			NavyCraft.playerMAP2Signs.get(s).clear();
		}
		NavyCraft.playerMAP2Signs.clear();
		for (String s : NavyCraft.playerMAP3Signs.keySet()) {
			NavyCraft.playerMAP3Signs.get(s).clear();
		}
		NavyCraft.playerMAP3Signs.clear();
		for (String s : NavyCraft.playerMAP4Signs.keySet()) {
			NavyCraft.playerMAP4Signs.get(s).clear();
		}
		NavyCraft.playerMAP4Signs.clear();
		for (String s : NavyCraft.playerMAP5Signs.keySet()) {
			NavyCraft.playerMAP5Signs.get(s).clear();
		}
		NavyCraft.playerMAP5Signs.clear();
		if (size == 0) return;
		for (String num : list) {
			if (syData.getString("Signs." + num + ".isClaimed").equalsIgnoreCase("true")) {
				String type = syData.getString("Signs." + num + ".type");
				World world = NavyCraft.instance.getServer().getWorld(syData.getString("Signs." + num + "." + "world"));
				int x = syData.getInt("Signs." + num + ".x");
				int y = syData.getInt("Signs." + num + ".y");
				int z = syData.getInt("Signs." + num + ".z");
				int id = syData.getInt("Signs." + num + ".id");
				String playerName = syData.getString("Signs." + num + ".playerName");
				Block selectSignBlock = world.getBlockAt(x, y, z);
				if (selectSignBlock.getTypeId() == 63) {
				Sign selectSign = (Sign) selectSignBlock.getState();
				if (type.equalsIgnoreCase("SHIP1")) {
					if (!NavyCraft.playerSHIP1Signs.containsKey(playerName)) {
						NavyCraft.playerSHIP1Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerSHIP1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerSHIP1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("SHIP2")) {
					if (!NavyCraft.playerSHIP2Signs.containsKey(playerName)) {
						NavyCraft.playerSHIP2Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerSHIP2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerSHIP2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("SHIP3")) {
					if (!NavyCraft.playerSHIP3Signs.containsKey(playerName)) {
						NavyCraft.playerSHIP3Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerSHIP3Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerSHIP3Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("SHIP4")) {
					if (!NavyCraft.playerSHIP4Signs.containsKey(playerName)) {
						NavyCraft.playerSHIP4Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerSHIP4Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerSHIP4Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("SHIP5")) {
					if (!NavyCraft.playerSHIP5Signs.containsKey(playerName)) {
						NavyCraft.playerSHIP5Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerSHIP5Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerSHIP5Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("HANGAR1")) {
					if (!NavyCraft.playerHANGAR1Signs.containsKey(playerName)) {
						NavyCraft.playerHANGAR1Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerHANGAR1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerHANGAR1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("HANGAR2")) {
					if (!NavyCraft.playerHANGAR2Signs.containsKey(playerName)) {
						NavyCraft.playerHANGAR2Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerHANGAR2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerHANGAR2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("TANK1")) {
					if (!NavyCraft.playerTANK1Signs.containsKey(playerName)) {
						NavyCraft.playerTANK1Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerTANK1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerTANK1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("TANK2")) {
					if (!NavyCraft.playerTANK2Signs.containsKey(playerName)) {
						NavyCraft.playerTANK2Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerTANK2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerTANK2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("MAP1")) {
					if (!NavyCraft.playerMAP1Signs.containsKey(playerName)) {
						NavyCraft.playerMAP1Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerMAP1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerMAP1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("MAP2")) {
					if (!NavyCraft.playerMAP2Signs.containsKey(playerName)) {
						NavyCraft.playerMAP2Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerMAP2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerMAP2Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("MAP3")) {
					if (!NavyCraft.playerMAP3Signs.containsKey(playerName)) {
						NavyCraft.playerMAP3Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerMAP3Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerMAP3Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("MAP4")) {
					if (!NavyCraft.playerMAP4Signs.containsKey(playerName)) {
						NavyCraft.playerMAP4Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerMAP4Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerMAP4Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
				if (type.equalsIgnoreCase("MAP5")) {
					if (!NavyCraft.playerMAP5Signs.containsKey(playerName)) {
						NavyCraft.playerMAP5Signs.put(playerName, new ArrayList<Sign>());
						NavyCraft.playerMAP5Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					} else {
						NavyCraft.playerMAP5Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, id);
						
					}
				}
			}
		}
	}
}

	public static Block findSignOpen(String type) {
		File shipyarddata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "shipyarddata");
		File f = new File(shipyarddata, File.separator + "signs.yml");
		FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
		Block selectSignBlock = null;
		List<String> list = new ArrayList<String>(syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
			if (syData.getString("Signs." + num + ".isClaimed").equalsIgnoreCase("false")) {
				String ptype = syData.getString("Signs." + num + "." + "type");
				World world = NavyCraft.instance.getServer().getWorld(syData.getString("Signs." + num + "." + "world"));
				int x = syData.getInt("Signs." + num + "." + "x");
				int y = syData.getInt("Signs." + num + "." + "y");
				int z = syData.getInt("Signs." + num + "." + "z");
				if (type.equalsIgnoreCase("SHIP1")) {
					if (ptype.equalsIgnoreCase("SHIP1")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("SHIP2")) {
					if (ptype.equalsIgnoreCase("SHIP2")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("SHIP3")) {
					if (ptype.equalsIgnoreCase("SHIP3")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("SHIP4")) {
					if (ptype.equalsIgnoreCase("SHIP4")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("SHIP5")) {
					if (ptype.equalsIgnoreCase("SHIP5")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("HANGAR1")) {
					if (ptype.equalsIgnoreCase("HANGAR1")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("HANGAR2")) {
					if (ptype.equalsIgnoreCase("HANGAR2")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("TANK1")) {
					if (ptype.equalsIgnoreCase("TANK1")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("TANK2")) {
					if (ptype.equalsIgnoreCase("TANK2")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("MAP1")) {
					if (ptype.equalsIgnoreCase("MAP1")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("MAP2")) {
					if (ptype.equalsIgnoreCase("MAP2")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("MAP3")) {
					if (ptype.equalsIgnoreCase("MAP3")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("MAP4")) {
					if (ptype.equalsIgnoreCase("MAP4")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
				if (type.equalsIgnoreCase("MAP5")) {
					if (ptype.equalsIgnoreCase("MAP5")) {
						selectSignBlock = world.getBlockAt(x, y, z);
						if (selectSignBlock.getTypeId() == 63) {
						break;
						}
					}
				}
			}
		}
		return selectSignBlock;
	}

	public static void saveClaimedSign(String player, String type, String world, int x, int y, int z, int id) {
		Block selectSignBlock = NavyCraft.instance.getServer().getWorld(world).getBlockAt(x, y, z);
		if (selectSignBlock.getTypeId() == 63) {
		File shipyarddata = new File( NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
		File f = new File(shipyarddata, File.separator + "signs.yml");
		FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
		Location loc = new Location(NavyCraft.instance.getServer().getWorld(world), x, y, z);
		List<String> list = new ArrayList<String>(syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
			int x1 = syData.getInt("Signs." + num + "." + "x");
			int y1 = syData.getInt("Signs." + num + "." + "y");
			int z1 = syData.getInt("Signs." + num + "." + "z");
			String world1 = syData.getString("Signs." + num + "." + "world");
			Location loc1 = new Location(NavyCraft.instance.getServer().getWorld(world1), x1, y1, z1);
			if (loc.equals(loc1)) {
				syData.set("Signs." + num + "." + "type", type.toUpperCase());
				syData.set("Signs." + num + "." + "world", world);
				syData.set("Signs." + num + "." + "x", x);
				syData.set("Signs." + num + "." + "y", y);
				syData.set("Signs." + num + "." + "z", z);
				syData.set("Signs." + num + "." + "isClaimed", true);
				syData.set("Signs." + num + "." + "playerName", player);
				syData.set("Signs." + num + "." + "id", id);
				break;
			}
		}
		try {
			syData.save(f);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("SIGN NOT LOADED");
			return;
		}
	}
}
	
	public static void saveUnclaimedSign(String type, String world, int x, int y, int z) {
		Block selectSignBlock = NavyCraft.instance.getServer().getWorld(world).getBlockAt(x, y, z);
		if (selectSignBlock.getTypeId() == 63) {
		File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),File.separator + "shipyarddata");
		File f = new File(shipyarddata, File.separator + "signs.yml");
		FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
		Location loc = new Location(NavyCraft.instance.getServer().getWorld(world), x, y, z);
		List<String> list = new ArrayList<String>(syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
			int x1 = syData.getInt("Signs." + num + "." + "x");
			int y1 = syData.getInt("Signs." + num + "." + "y");
			int z1 = syData.getInt("Signs." + num + "." + "z");
			String world1 = syData.getString("Signs." + num + "." + "world");
			Location loc1 = new Location(NavyCraft.instance.getServer().getWorld(world1), x1, y1, z1);
			if (loc.equals(loc1)) {
				syData.set("Signs." + num + "." + "type", type.toUpperCase());
				syData.set("Signs." + num + "." + "world", world);
				syData.set("Signs." + num + "." + "x", x);
				syData.set("Signs." + num + "." + "y", y);
				syData.set("Signs." + num + "." + "z", z);
				syData.set("Signs." + num + "." + "isClaimed", false);
				syData.set("Signs." + num + "." + "playerName", null);
				syData.set("Signs." + num + "." + "id", null);
				break;
			}
		}
		try {
			syData.save(f);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("SIGN NOT LOADED");
			return;
		}
	}
}
	
	public static void saveSign(String type, String world, int x, int y, int z) {
		File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),File.separator + "shipyarddata");
		File f = new File(shipyarddata, File.separator + "signs.yml");
		FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
		List<String> list = new ArrayList<String>(syData.getConfigurationSection("Signs").getKeys(false));
		int size = list.size();
		syData.set("Signs." + String.valueOf(size + 1) + "." + "type", type.toUpperCase());
		syData.set("Signs." + String.valueOf(size + 1) + "." + "world", world);
		syData.set("Signs." + String.valueOf(size + 1) + "." + "x", x);
		syData.set("Signs." + String.valueOf(size + 1) + "." + "y", y);
		syData.set("Signs." + String.valueOf(size + 1) + "." + "z", z);
		syData.set("Signs." + String.valueOf(size + 1) + "." + "isClaimed", false);
		try {
			syData.save(f);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("SIGN NOT LOADED");
		}
}
	
	public static boolean checkSign(int x, int y, int z, World world) {
		File shipyarddata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "shipyarddata");
		File f = new File(shipyarddata, File.separator + "signs.yml");
		FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
		List<String> list = new ArrayList<String>(syData.getConfigurationSection("Signs").getKeys(false));
		for (String num : list) {
				World world1 = NavyCraft.instance.getServer().getWorld(syData.getString("Signs." + num + "." + "world"));
				int x1 = syData.getInt("Signs." + num + "." + "x");
				int y1 = syData.getInt("Signs." + num + "." + "y");
				int z1 = syData.getInt("Signs." + num + "." + "z");
				Location loc1 = new Location(world1, x1, y1, z1);
				Location loc = new Location(world, x, y, z);
				if (loc.equals(loc1)) {
					return true;
				}
		}
		return false;
	}
	
	public static void loadPlayerData(String player) {
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + player + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		
		// When the player file is created for the first time...
		if (!f.exists()) {
			try {
				
				playerData.createSection(player);
				playerData.set(player + ".exp", 0);
				playerData.set(player + ".SHIP1", 0);
				playerData.set(player + ".SHIP2", 0);
				playerData.set(player + ".SHIP3", 0);
				playerData.set(player + ".SHIP4", 0);
				playerData.set(player + ".SHIP5", 0);
				playerData.set(player + ".HANGAR1", 0);
				playerData.set(player + ".HANGAR2", 0);
				playerData.set(player + ".TANK1", 0);
				playerData.set(player + ".TANK2", 0);
				playerData.set(player + ".MAP1", 0);
				playerData.set(player + ".MAP2", 0);
				playerData.set(player + ".MAP3", 0);
				playerData.set(player + ".MAP4", 0);
				playerData.set(player + ".MAP5", 0);
				playerData.set(player + ".wepvolume", 100.0);
				playerData.set(player + ".engvolume", 100.0);
				playerData.set(player + ".othervolume", 100.0);
				
				playerData.save(f);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		// Put all the hashmaps to file data
		loadExperience(player);
		loadVolume(player);
	}

	public static void loadExperience(String player) {
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + player + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		NavyCraft.playerExp.clear();
		NavyCraft.playerExp.put(player, Integer.valueOf(playerData.get(player + ".exp").toString()));
	}
	
	public static void saveExperience(String player) {
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + player + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		playerData.set(player + ".exp", Integer.valueOf(NavyCraft.playerExp.get(player).toString()));
		try {
			playerData.save(f);
		} catch (IOException e) {
			loadPlayerData(player);
		}
	}
	
	public static void loadVolume(String player) {
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + player + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		NavyCraft.playerEngineVolumes.clear();
		NavyCraft.playerEngineVolumes.put(NavyCraft.instance.getServer().getPlayer(player),
				Float.valueOf(playerData.get(player + ".engvolume").toString()));
		NavyCraft.playerWeaponVolumes.clear();
		NavyCraft.playerWeaponVolumes.put(NavyCraft.instance.getServer().getPlayer(player),
				Float.valueOf(playerData.get(player + ".wepvolume").toString()));
		NavyCraft.playerOtherVolumes.clear();
		NavyCraft.playerOtherVolumes.put(NavyCraft.instance.getServer().getPlayer(player),
				Float.valueOf(playerData.get(player + ".othervolume").toString()));
	}
	
	public static void saveVolume(String player) {
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + player + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		playerData.set(player + ".wepvolume",
				NavyCraft.playerWeaponVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
		playerData.set(player + ".engvolume",
				NavyCraft.playerEngineVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
		playerData.set(player + ".othervolume",
				NavyCraft.playerOtherVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
		try {
			playerData.save(f);
		} catch (IOException e) {
			loadPlayerData(player);
		}
	}
	
	public static void loadRewardsFile(String player) {
		File userdata = new File(
				NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(),
				File.separator + "userdata");
		File f = new File(userdata, File.separator + player + ".yml");
		FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
		if (playerData.getInt(player + ".SHIP1") > 0) {
			if (NavyCraft.playerSHIP1Rewards.containsKey(player)) {
				NavyCraft.playerSHIP1Rewards.put(player, NavyCraft.playerSHIP1Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".SHIP1").toString()));
			} else {
				NavyCraft.playerSHIP1Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".SHIP2") > 0) {
			if (NavyCraft.playerSHIP2Rewards.containsKey(player)) {
				NavyCraft.playerSHIP2Rewards.put(player, NavyCraft.playerSHIP2Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".SHIP2").toString()));
			} else {
				NavyCraft.playerSHIP2Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".SHIP3") > 0) {
			if (NavyCraft.playerSHIP3Rewards.containsKey(player)) {
				NavyCraft.playerSHIP3Rewards.put(player, NavyCraft.playerSHIP3Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".SHIP3").toString()));
			} else {
				NavyCraft.playerSHIP3Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".SHIP4") > 0) {
			if (NavyCraft.playerSHIP4Rewards.containsKey(player)) {
				NavyCraft.playerSHIP4Rewards.put(player, NavyCraft.playerSHIP4Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".SHIP4").toString()));
			} else {
				NavyCraft.playerSHIP4Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".SHIP5") > 0) {
			if (NavyCraft.playerSHIP5Rewards.containsKey(player)) {
				NavyCraft.playerSHIP5Rewards.put(player, NavyCraft.playerSHIP5Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".SHIP5").toString()));
			} else {
				NavyCraft.playerSHIP5Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".HANGAR1") > 0) {
			if (NavyCraft.playerHANGAR1Rewards.containsKey(player)) {
				NavyCraft.playerHANGAR1Rewards.put(player, NavyCraft.playerHANGAR1Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".HANGAR1").toString()));
			} else {
				NavyCraft.playerHANGAR1Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".HANGAR2") > 0) {
			if (NavyCraft.playerHANGAR2Rewards.containsKey(player)) {
				NavyCraft.playerHANGAR2Rewards.put(player, NavyCraft.playerHANGAR2Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".HANGAR2").toString()));
			} else {
				NavyCraft.playerHANGAR2Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".TANK1") > 0) {
			if (NavyCraft.playerTANK1Rewards.containsKey(player)) {
				NavyCraft.playerTANK1Rewards.put(player, NavyCraft.playerTANK1Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".TANK1").toString()));
			} else {
				NavyCraft.playerTANK1Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".TANK2") > 0) {
			if (NavyCraft.playerTANK2Rewards.containsKey(player)) {
				NavyCraft.playerTANK2Rewards.put(player, NavyCraft.playerTANK2Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".TANK2").toString()));
			} else {
				NavyCraft.playerTANK2Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".MAP1") > 0) {
			if (NavyCraft.playerMAP1Rewards.containsKey(player)) {
				NavyCraft.playerMAP1Rewards.put(player, NavyCraft.playerMAP1Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".MAP1").toString()));
			} else {
				NavyCraft.playerMAP1Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".MAP2") > 0) {
			if (NavyCraft.playerMAP2Rewards.containsKey(player)) {
				NavyCraft.playerMAP2Rewards.put(player, NavyCraft.playerMAP2Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".MAP2").toString()));
			} else {
				NavyCraft.playerMAP2Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".MAP3") > 0) {
			if (NavyCraft.playerMAP3Rewards.containsKey(player)) {
				NavyCraft.playerMAP3Rewards.put(player, NavyCraft.playerMAP3Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".MAP3").toString()));
			} else {
				NavyCraft.playerMAP3Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".MAP4") > 0) {
			if (NavyCraft.playerMAP4Rewards.containsKey(player)) {
				NavyCraft.playerMAP4Rewards.put(player, NavyCraft.playerMAP4Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".MAP4").toString()));
			} else {
				NavyCraft.playerMAP4Rewards.put(player, 1);
			}
		} else if (playerData.getInt(player + ".MAP5") > 0) {
			if (NavyCraft.playerMAP5Rewards.containsKey(player)) {
				NavyCraft.playerMAP5Rewards.put(player, NavyCraft.playerMAP5Rewards.get(player)
						+ Integer.valueOf(playerData.get(player + ".MAP5").toString()));
			} else {
				NavyCraft.playerMAP5Rewards.put(player, 1);
			}
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
			playerData.set(player + "." + type.toUpperCase(), Integer.valueOf(playerData.get(player + "." + type.toUpperCase()).toString()) + newRewNum);
			try {
				playerData.save(f);
			} catch (IOException e) {
				loadPlayerData(player);
			}
			return;
		}
	}

}
