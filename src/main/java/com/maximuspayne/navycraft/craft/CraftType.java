package com.maximuspayne.navycraft.craft;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.PermissionInterface;

/*
 * NavyCraft plugin by Maximuspayne
 *
 * You are free to modify it for your own server
 * or use part of the code for your own plugins.
 */
public class CraftType {
	
	public static FileConfiguration CraftConfig;
	public static File CraftFile;
	
	
	public String name = "";
	public String driveCommand = "drive";

	public int minBlocks = 9;
	public int maxBlocks = 500;
	public int maxSpeed = 4;
	public int discount = 0;
	
	public boolean adminBuild=false;

	public int digBlockId = 0;		//the type of block needed to make the vehicle able to drill through terrain
	public double digBlockPercent = 0;
	public int digBlockDurability = 0;
	
	public int HelmControllerItem = 0;

	public boolean canFly = false;
	public boolean canNavigate = false;
	public boolean canDive = false;
	public boolean canDig = false;
	public boolean obeysGravity = false;
	public boolean isTerrestrial = false;
	
	
	public boolean doesCruise = false;
	public boolean canZamboni = false;
	public int maxEngineSpeed = 4;
	public int maxForwardGear = 2;
	public int maxReverseGear = -2;
	public int turnRadius = 4;
	public int maxSurfaceSpeed = 4;
	public int maxSubmergedSpeed = 3;

	public short[] structureBlocks = null; // blocks that can make the structure of the craft
	public short[] extendedBlocks = null;		//structureblocks only for this craft type 
	public short[] restrictedBlocks = null;	//structureblocks to be exlcuded from this craft type 
	public short[] forbiddenBlocks = null;		//blocks that are not allowed whatsoever on this craft

	public static ArrayList<CraftType> craftTypes = new ArrayList<CraftType>();
	
	public boolean listenItem = true;
	public boolean listenAnimation, listenMovement = false;

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
			if (type.name.equalsIgnoreCase(name))
				return type;
		}

		return null;
	}

	public String getCommand() {
		return "/" + name.toLowerCase();
	}

	public Boolean canUse(Player player){
		if(PermissionInterface.CheckPerm(player, "navycraft." + name.toLowerCase()))
			return true;
		else
			return false;
	}

	private static void loadDefaultCraftTypes() {
		// if the default craft types are not loaded (first execution), then
		// load them
		if (CraftType.getCraftType("boat") == null)
			craftTypes.add(CraftType.getDefaultCraftType("boat"));
		if (CraftType.getCraftType("ship") == null)
			craftTypes.add(CraftType.getDefaultCraftType("ship"));
		if (CraftType.getCraftType("freeship") == null)
			craftTypes.add(CraftType.getDefaultCraftType("freeship"));
		if (CraftType.getCraftType("halfship") == null)
			craftTypes.add(CraftType.getDefaultCraftType("halfship"));
		if (CraftType.getCraftType("aircraft") == null)
			craftTypes.add(CraftType.getDefaultCraftType("aircraft"));
		if (CraftType.getCraftType("airship") == null)
			craftTypes.add(CraftType.getDefaultCraftType("airship"));
		if (CraftType.getCraftType("submarine") == null)
			craftTypes.add(CraftType.getDefaultCraftType("submarine"));
		if (CraftType.getCraftType("tank") == null)
			craftTypes.add(CraftType.getDefaultCraftType("tank"));
	}

	private static CraftType getDefaultCraftType(String name) {

		CraftType craftType = new CraftType(name);
		
		if (name.equalsIgnoreCase("ship")) {
			setAttribute(
					craftType,
					"structureBlocks",
					"4,5,14,15,16,17,19,20,21,22,23,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,"
					+ "57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,"
					+ "92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,"
					+ "133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,"
					+ "164,165,166,167,168,169,170,172,173,174,183,184,185,186,187,188,189,190,191,192,0");
			
			craftType.driveCommand = "sail";
			craftType.canNavigate = true;
			craftType.minBlocks = 50;
			craftType.maxBlocks = 18000;
			craftType.maxSpeed = 6;
			craftType.doesCruise = true;
			craftType.maxEngineSpeed = 8;
			craftType.maxForwardGear = 2;
			
		} else if (name.equalsIgnoreCase("freeship")) {
			setAttribute(
					craftType,
					"structureBlocks",
					"4,5,14,15,16,17,19,20,21,22,23,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,"
					+ "57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,"
					+ "92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,"
					+ "133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,"
					+ "164,165,166,167,168,169,170,172,173,174,183,184,185,186,187,188,189,190,191,192,0");
			
			craftType.driveCommand = "sail";
			craftType.canNavigate = true;
			craftType.minBlocks = 50;
			craftType.maxBlocks = 3000;
			craftType.maxSpeed = 6;
			craftType.doesCruise = true;
			craftType.maxEngineSpeed = 8;
			craftType.maxForwardGear = 3;
			craftType.discount = 100;
			craftType.adminBuild = true;
			
		} else if (name.equalsIgnoreCase("aircraft")) {
			setAttribute(
					craftType,
					"structureBlocks",
					"4,5,14,15,16,17,20,21,22,23,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,"
					+ "57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,"
					+ "92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,"
					+ "133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,160,162,163,"
					+ "164,165,166,167,168,169,170,172,173,174,183,184,185,186,187,188,189,190,191,192,0");
			craftType.driveCommand = "pilot";
			craftType.canFly = true;
			craftType.minBlocks = 20;
			craftType.maxBlocks = 18000;
			craftType.maxSpeed = 20;
			craftType.doesCruise = true;
			craftType.maxEngineSpeed = 8;
			craftType.maxForwardGear = 3;
			
		} else if (name.equalsIgnoreCase("helicopter")) {
			setAttribute(
					craftType,
					"structureBlocks",
					"4,5,14,15,16,17,20,21,22,23,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,"
					+ "57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,"
					+ "92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,"
					+ "133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,160,162,163,"
					+ "164,165,166,167,168,169,170,172,173,174,183,184,185,186,187,188,189,190,191,192,0");
			craftType.driveCommand = "pilot";
			craftType.canFly = true;
			craftType.minBlocks = 9;
			craftType.maxBlocks = 18000;
			craftType.maxSpeed = 5;
			craftType.doesCruise = false;
			craftType.maxForwardGear = 3;
			
		} else if (name.equalsIgnoreCase("submarine")) {
			setAttribute(
					craftType,
					"structureBlocks",
					"4,5,14,15,16,17,19,20,21,22,23,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,"
					+ "57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,"
					+ "92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,"
					+ "133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,"
					+ "164,165,166,167,168,169,170,172,173,174,183,184,185,186,187,188,189,190,191,192,0");
			
			craftType.driveCommand = "dive";
			craftType.canDive = true;
			craftType.minBlocks = 20;
			craftType.maxBlocks = 18000;
			craftType.maxSpeed = 3;
			craftType.doesCruise = true;
			craftType.maxEngineSpeed = 6;
			craftType.maxSubmergedSpeed = 3;
			craftType.maxForwardGear = 2;
		} else if (name.equalsIgnoreCase("tank")) {
		setAttribute(
				craftType,
				"structureBlocks",
				"4,5,14,15,16,17,20,21,22,23,25,26,27,28,30,35,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,"
				+ "57,58,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,79,80,81,82,84,85,86,87,88,89,91,"
				+ "92,93,94,95,96,98,101,102,106,107,108,109,112,113,114,118,121,123,124,125,126,129,131,132,"
				+ "133,134,135,136,139,143,144,147,148,149,150,151,152,153,154,155,156,157,158,159,160,162,163,"
				+ "164,165,166,167,168,169,170,172,173,174,183,184,185,186,187,188,189,190,191,192,0");
		
		craftType.driveCommand = "drive";
		craftType.canNavigate = false;
		craftType.isTerrestrial = true;
		craftType.obeysGravity = true;
		craftType.minBlocks = 10;
		craftType.maxBlocks = 2000;
		craftType.maxSpeed = 3;
		craftType.doesCruise = true;
		craftType.maxEngineSpeed = 4;
		craftType.maxForwardGear = 3;
		
	}

		return craftType;
	}

	// set the attributes of the craft type
	private static void setAttribute(CraftType craftType, String attribute,
			String value) {

		if (attribute.equalsIgnoreCase("driveCommand"))
			craftType.driveCommand = value;
		else if (attribute.equalsIgnoreCase("minBlocks"))
			craftType.minBlocks = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("maxBlocks"))
			craftType.maxBlocks = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("maxSpeed"))
			craftType.maxSpeed = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("discount"))
			craftType.discount = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("adminBuild"))
			craftType.adminBuild = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("digBlockId"))
			craftType.digBlockId = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("digBlockDurability"))
			craftType.digBlockDurability = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("canNavigate"))
			craftType.canNavigate = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("isTerrestrial"))
			craftType.isTerrestrial = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("canFly"))
			craftType.canFly = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("canDive"))
			craftType.canDive = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("canDig"))
			craftType.canDig = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("canZamboni"))
			craftType.canZamboni = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("obeysGravity"))
			craftType.obeysGravity = Boolean.parseBoolean(value);
		
		
		else if (attribute.equalsIgnoreCase("doesCruise"))
			craftType.doesCruise = Boolean.parseBoolean(value);
		
		else if (attribute.equalsIgnoreCase("maxEngineSpeed"))
		{
			craftType.maxEngineSpeed = Integer.parseInt(value);
			craftType.maxSurfaceSpeed = Integer.parseInt(value);
		}
		else if (attribute.equalsIgnoreCase("maxForwardGear"))
			craftType.maxForwardGear = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("maxReverseGear"))
			craftType.maxReverseGear = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("turnRadius"))
			craftType.turnRadius = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("maxSubmergedSpeed"))
			craftType.maxSubmergedSpeed = Integer.parseInt(value);	
		// else if(attribute.equalsIgnoreCase("iceBreaker"))
		// craftType.iceBreaker = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("HelmControllerItem"))
			craftType.HelmControllerItem = Integer.parseInt(value);
		else if (attribute.equalsIgnoreCase("listenItem"))
			craftType.listenItem = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("listenAnimation"))
			craftType.listenAnimation = Boolean.parseBoolean(value);
		else if (attribute.equalsIgnoreCase("listenMovement")){
			craftType.listenMovement = Boolean.parseBoolean(value);	
		}
		else if (attribute.equalsIgnoreCase("structureBlocks")) {
			String[] split = value.split(",");
			craftType.structureBlocks = new short[split.length];
			int i = 0;
			for (String blockId : split) {
				craftType.structureBlocks[i] = Short.parseShort(blockId);
				i++;
			}
		} else if (attribute.equalsIgnoreCase("restrictedBlocks")) {
			if(craftType.structureBlocks == null)
				return;
			
			ArrayList<Short> restrictedBlocks = new ArrayList<Short>();
			ArrayList<Short> newStructureBlocks = new ArrayList<Short>();

			String[] split = value.split(",");
			
			for(String s : split){
				try
				{
					restrictedBlocks.add(Short.parseShort(s));
				}
				catch (NumberFormatException ex) {
					System.out.println("Tried to remove invalid block ID " + s + 
							" from structureblocks of craft type " + craftType.name);
				}
			}
			for(Short i: craftType.structureBlocks)
				if(!restrictedBlocks.contains(i))
					newStructureBlocks.add(i);
			
			Short nsb[] = new Short[newStructureBlocks.size()];
			//craftType.structureBlocks = newStructureBlocks.toArray(short[]);
			newStructureBlocks.toArray(nsb);
			//I give up.
			//craftType.structureBlocks = nsb;
			
		} else if (attribute.equalsIgnoreCase("extendedBlocks")) {
			if(craftType.structureBlocks == null)
				return;
			
			String[] split = value.split(",");
			short[] newStructureBlocks = new short[craftType.structureBlocks.length + split.length];
			
			for(int i = 0; i < craftType.structureBlocks.length; i++) {
				newStructureBlocks[i] = craftType.structureBlocks[i];
			}
			
			int i = 0;
			for(String s : split) {
				try
				{
					newStructureBlocks[craftType.structureBlocks.length + i] = Short.parseShort(s);
				}
				catch (NumberFormatException ex) {
					System.out.println("Tried to add invalid block ID " + s + 
							" to structureblocks of craft type " + craftType.name);					
				}				
			}
			craftType.structureBlocks = newStructureBlocks;
		} else if (attribute.equalsIgnoreCase("forbiddenBlocks")) {			
			String[] split = value.split(",");
			craftType.forbiddenBlocks = new short[split.length];
			for (int i = 0; i < split.length; i++) {
				craftType.forbiddenBlocks[i] = Short.parseShort(split[i]);
			}			
		}
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
				
				CraftConfig.save(CraftFile);
			} catch(IOException e) {
				System.out.println("Could not create the types.yml file!");
			}
		}
	}
	
	public static FileConfiguration getCraftConfig () {
		return CraftConfig;
	}
	
	public static void saveCraftConfig() {
		try {
			CraftConfig.save(CraftFile);
		} catch (IOException e) {
			System.out.println("Could not save types.yml file");
		}
	}
	public static void reloadCraftConfig() {
		CraftConfig = YamlConfiguration.loadConfiguration(CraftFile);
	}

	public static void saveType(CraftType craftType, boolean force) {		
			String name = craftType.name;
			writeAttribute(name, "driveCommand", craftType.driveCommand,
					force);
			writeAttribute(name, "minBlocks", craftType.minBlocks, true);
			writeAttribute(name, "maxBlocks", craftType.maxBlocks, force);

			// list of blocks that make the structure of the craft
			if (craftType.structureBlocks != null) {
				String line = null;
				for (short blockId : craftType.structureBlocks) {

					line += blockId + ",";
				}
				writeAttribute(name, "structureBlocks", line.substring(0, line.length() - 1), force);
			}
			
			writeAttribute(name, "maxSpeed", craftType.maxSpeed, force);
			writeAttribute(name, "discount", craftType.discount, force);
			writeAttribute(name, "adminBuild", craftType.adminBuild, force);
			writeAttribute(name, "digBlockId", craftType.digBlockId, force);
			writeAttribute(name, "digBlockDurability", craftType.digBlockDurability, force);
			writeAttribute(name, "canNavigate", craftType.canNavigate, force);
			writeAttribute(name, "isTerrestrial", craftType.isTerrestrial, force);
			writeAttribute(name, "canFly", craftType.canFly, force);
			writeAttribute(name, "canDive", craftType.canDive, force);
			writeAttribute(name, "canDig", craftType.canDig, force);
			writeAttribute(name, "obeysGravity", craftType.obeysGravity, force);
			// writeAttribute(name, "iceBreaker", craftType.iceBreaker);
			writeAttribute(name, "doesCruise", craftType.doesCruise, force);
			writeAttribute(name, "maxEngineSpeed", craftType.maxEngineSpeed, force);
			writeAttribute(name, "maxSubmergedSpeed", craftType.maxSubmergedSpeed, force);
			writeAttribute(name, "maxForwardGear", craftType.maxForwardGear, force);
			writeAttribute(name, "maxReverseGear", craftType.maxReverseGear, force);
	}

	public static void saveTypes() {		
		for (CraftType craftType : craftTypes) {
			saveType(craftType, true);
		}
	}

	private static void writeAttribute(String name, String attribute, String value, boolean force){
		CraftConfig.set("Types." + name + "." + attribute, value);
		saveCraftConfig();
	}
	
	private static void writeAttribute(String name, String attribute, Boolean value, boolean force){
		CraftConfig.set("Types." + name + "." + attribute, value);
		saveCraftConfig();
	}
	
	private static void writeAttribute(String name, String attribute, int value, boolean force){
		CraftConfig.set("Types." + name + "." + attribute, value);
		saveCraftConfig();
	}

	public static void loadTypes() {
		List<String> list = new ArrayList<String>(CraftConfig.getConfigurationSection("Types").getKeys(false));
		int size = list.size();
		craftTypes.clear();

		if (size == 0) return;
		for (String name : list) {

				CraftType craftType = new CraftType(name);
				
				craftType.HelmControllerItem = Integer.parseInt(NavyCraft.instance.getConfig().getString("HelmID"));

					List<String> info = new ArrayList<String>(CraftConfig.getConfigurationSection("Types." + name).getKeys(false));
					int s = info.size();

					if (s == 0) return;
					for (String attribute : list) {
							setAttribute(craftType, attribute, CraftConfig.getString(attribute));
					}

				craftTypes.add(craftType);
		}

		if(NavyCraft.instance.getConfig().getString("WriteDefaultCraft").equalsIgnoreCase("true"))
			loadDefaultCraftTypes();
	}
}
