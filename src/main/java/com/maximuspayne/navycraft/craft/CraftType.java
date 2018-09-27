package com.maximuspayne.navycraft.craft;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.maximuspayne.aimcannon.OneCannon;
import com.maximuspayne.aimcannon.Weapon;
import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.PermissionInterface;

/*
 * NavyCraft plugin by Maximuspayne
 *
 * You are free to modify it for your own server
 * or use part of the code for your own plugins.
 */
public class CraftType {
	public static List<Attribute> attributes = new ArrayList<Attribute>();
	
	public static List<Attribute> getAttributes() {
		return attributes;
	}
	
	public static FileConfiguration CraftConfig;
	public static File CraftFile;

	public static ArrayList<CraftType> craftTypes = new ArrayList<CraftType>();

	public CraftType(String name) {
		this.name = name;
		
		String[] bob = NavyCraft.instance.getConfig().getString("StructureBlocks").split(",");
		short[] juan = new short[bob.length + 1];
		for(int i = 0; i < bob.length; i++)
			juan[i] = Short.parseShort(bob[i]);
		structureBlocks = juan;
		
		if(NavyCraft.instance.getConfig().getString("ForbiddenBlocks") != "null") {
			bob = NavyCraft.instance.getConfig().getString("ForbiddenBlocks").split(",");
			juan = new short[bob.length];
			for(int i = 0; i < bob.length; i++) {
				try {
					juan[i] = Short.parseShort(bob[i]);
				}
				catch (Exception ex){
				}
			}
			if(juan != null && juan.length > 0 && juan[0] != 0)
				forbiddenBlocks = juan;
		}
	}

	public static CraftType getCraftType(String name) {

		for (CraftType type : craftTypes) {
			if (getAttribute("name").equalsIgnoreCase(name))
				return type;
		}

		return null;
	}

	public String getCommand() {
		return "/" + getAttribute("name").toLowerCase();
	}

	public Boolean canUse(Player player){
		if(PermissionInterface.CheckPerm(player, "navycraft." + getAttribute("name").toLowerCase()))
			return true;
		else
			return false;
	}
	// set the attributes of the craft type
	private static void setAttribute(CraftType craftType, String attribute, String value) {
		CraftType.getAttributes().add(new Attribute(attribute, value));
	}

	public static String getString(String attribute) {
		for (Attribute a : attributes) {
			if (a.name.equalsIgnoreCase(attribute)) {
				return a.svalue;
			}
		}
		return null;
	}
	public static short[] getShort(String attribute) {
		for (Attribute a : attributes) {
			if (a.name.equalsIgnoreCase(attribute)) {
				return a.shvalue;
			}
		}
		return null;
	}
	public static int getInt(String attribute) {
		for (Attribute a : attributes) {
			if (a.name.equalsIgnoreCase(attribute)) {
				return a.ivalue;
			}
		}
		return 0;
	}
	public static boolean getBoolean(String attribute) {
		for (Attribute a : attributes) {
			if (a.name.equalsIgnoreCase(attribute)) {
				return a.bvalue;
			}
		}
		return false;
	}
	
	public static void setupCraftConfig() {
		if (!NavyCraft.instance.getDataFolder().exists()) {
			NavyCraft.instance.getDataFolder().mkdir();
		}
		CraftFile = new File(NavyCraft.instance.getDataFolder() + File.separator , "types.yml");
		CraftConfig = YamlConfiguration.loadConfiguration(CraftFile);
		
		if (!CraftFile.exists()) {
			try {
				CraftConfig.createSection("Types");
				//Ship
				CraftConfig.set("Types.ship.structureBlocks", "4,5,14,15,16,17,19,20,21,22,23,24,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,164,165,166,167,168,169,170,172,173,174,179,183,184,185,186,187,188,189,190,191,192,251,0");
				CraftConfig.set("Types.ship.forbiddenBlocks", "29,33,416");
				CraftConfig.set("Types.ship.driveCommand", "sail");
				CraftConfig.set("Types.ship.canNavigate", "true");
				CraftConfig.set("Types.ship.minBlocks", "20");
				CraftConfig.set("Types.ship.maxBlocks", "50000");
				CraftConfig.set("Types.ship.maxSpeed", "6");
				CraftConfig.set("Types.ship.doesCruise", "true");
				CraftConfig.set("Types.ship.maxEngineSpeed", "8");
				CraftConfig.set("Types.ship.maxFowardGear", "2");
				CraftConfig.set("Types.ship.maxReverseGear", "-2");
				//Freeship
				CraftConfig.set("Types.freeship.structureBlocks", "4,5,14,15,16,17,19,20,21,22,23,24,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,164,165,166,167,168,169,170,172,173,174,179,183,184,185,186,187,188,189,190,191,192,251,0");
				CraftConfig.set("Types.freeship.forbiddenBlocks", "29,33,416");
				CraftConfig.set("Types.freeship.driveCommand", "sail");
				CraftConfig.set("Types.freeship.canNavigate", "true");
				CraftConfig.set("Types.freeship.minBlocks", "20");
				CraftConfig.set("Types.freeship.maxBlocks", "50000");
				CraftConfig.set("Types.freeship.maxSpeed", "6");
				CraftConfig.set("Types.freeship.doesCruise", "true");
				CraftConfig.set("Types.freeship.maxEngineSpeed", "8");
				CraftConfig.set("Types.freeship.maxFowardGear", "2");
				CraftConfig.set("Types.freeship.maxReverseGear", "-2");
				CraftConfig.set("Types.freeship.discount", "100");
				CraftConfig.set("Types.freeship.adminBuild", "true");
				//Submarine
				CraftConfig.set("Types.submarine.structureBlocks", "4,5,14,15,16,17,19,20,21,22,23,24,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,164,165,166,167,168,169,170,172,173,174,179,183,184,185,186,187,188,189,190,191,192,251,0");
				CraftConfig.set("Types.submarine.forbiddenBlocks", "29,33,416");
				CraftConfig.set("Types.submarine.driveCommand", "dive");
				CraftConfig.set("Types.submarine.canNavigate", "true");
				CraftConfig.set("Types.submarine.minBlocks", "20");
				CraftConfig.set("Types.submarine.maxBlocks", "50000");
				CraftConfig.set("Types.submarine.maxSpeed", "3");
				CraftConfig.set("Types.submarine.doesCruise", "true");
				CraftConfig.set("Types.submarine.maxEngineSpeed", "6");
				CraftConfig.set("Types.submarine.maxSubmergedSpeed", "3");
				CraftConfig.set("Types.submarine.maxFowardGear", "2");
				CraftConfig.set("Types.submarine.maxReverseGear", "-2");
				//Aircraft
				CraftConfig.set("Types.aircraft.structureBlocks", "4,5,14,15,16,17,20,21,22,23,24,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,164,165,166,167,168,169,170,172,173,174,179,183,184,185,186,187,188,189,190,191,192,0");
				CraftConfig.set("Types.aircraft.forbiddenBlocks", "29,33,251,416");
				CraftConfig.set("Types.aircraft.driveCommand", "pilot");
				CraftConfig.set("Types.aircraft.canFly", "true");
				CraftConfig.set("Types.aircraft.minBlocks", "20");
				CraftConfig.set("Types.aircraft.maxBlocks", "20000");
				CraftConfig.set("Types.aircraft.maxSpeed", "20");
				CraftConfig.set("Types.aircraft.doesCruise", "true");
				CraftConfig.set("Types.aircraft.maxEngineSpeed", "8");
				CraftConfig.set("Types.aircraft.maxFowardGear", "3");
				CraftConfig.set("Types.aircraft.maxReverseGear", "-2");
				
				CraftConfig.set("Types.helicopter.structureBlocks", "4,5,14,15,16,17,20,21,22,23,24,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,164,165,166,167,168,169,170,172,173,174,183,184,185,186,187,188,189,190,191,192,0");
				CraftConfig.set("Types.helicopter.forbiddenBlocks", "29,33,251,416");
				CraftConfig.set("Types.helicopter.driveCommand", "pilot");
				CraftConfig.set("Types.helicopter.canFly", "true");
				CraftConfig.set("Types.helicopter.minBlocks", "20");
				CraftConfig.set("Types.helicopter.maxBlocks", "20000");
				CraftConfig.set("Types.helicopter.maxSpeed", "5");
				CraftConfig.set("Types.helicopter.doesCruise", "false");
				CraftConfig.set("Types.helicopter.maxFowardGear", "3");
				CraftConfig.set("Types.helicopter.maxReverseGear", "-2");
				
				CraftConfig.set("Types.tank.structureBlocks", "4,5,14,15,16,17,20,21,22,23,24,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,164,165,166,167,168,169,170,172,173,174,179,183,184,185,186,187,188,189,190,191,192,251,0");
				CraftConfig.set("Types.tank.forbiddenBlocks", "29,33,416");
				CraftConfig.set("Types.tank.driveCommand", "drive");
				CraftConfig.set("Types.tank.canNavigate", "false");
				CraftConfig.set("Types.tank.isTerrestrial", "true");
				CraftConfig.set("Types.tank.obeysGravity", "true");
				CraftConfig.set("Types.tank.minBlocks", "20");
				CraftConfig.set("Types.tank.maxBlocks", "10000");
				CraftConfig.set("Types.tank.maxSpeed", "3");
				CraftConfig.set("Types.tank.doesCruise", "true");
				CraftConfig.set("Types.tank.maxEngineSpeed", "5");
				CraftConfig.set("Types.tank.maxFowardGear", "3");
				CraftConfig.set("Types.tank.maxReverseGear", "-2");

				CraftConfig.save(CraftFile);
			} catch(IOException e) {
				System.out.println("Could not create the types.yml file!");
			}
		}
		loadTypes();
	}
	
	public static void reloadCraftConfig() {
		CraftConfig = YamlConfiguration.loadConfiguration(CraftFile);
	}

	public static void loadTypes() {
		List<String> list = new ArrayList<String>(CraftConfig.getConfigurationSection("Types").getKeys(false));
		int size = list.size();
		craftTypes.clear();

		if (size == 0) return;
		for (String name : list) {
			System.out.println("Found Type: " + name);
				CraftType craftType = new CraftType(name);
				
				craftType.HelmControllerItem = Integer.parseInt(NavyCraft.instance.getConfig().getString("HelmID"));

					List<String> info = new ArrayList<String>(CraftConfig.getConfigurationSection("Types." + name).getKeys(false));
					int s = info.size();

					if (s == 0) return;
					
					for (String attribute : info) {
							setAttribute(craftType, attribute, CraftConfig.getString("Types." + name + "." + attribute));
							System.out.println("Setting Attribute for " + craftType.name + " " + attribute + " " + CraftConfig.getString("Types." + name + "." + attribute));
					}

				craftTypes.add(craftType);
		}
	}
}
