package com.maximuspayne.navycraft.listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import com.maximuspayne.navycraft.NavyCraft;

@SuppressWarnings("deprecation")
public class NavyCraft_FileListener  implements Listener {
	
	private static NavyCraft plugin;
	
	public NavyCraft_FileListener(NavyCraft p) {
		plugin = p;
	}

	public static void loadShipyardData()
	{
		  File shipyardudata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
          File f1 = new File(shipyardudata, File.separator + "signu.yml");
          FileConfiguration syuData = YamlConfiguration.loadConfiguration(f1);
		  File shipyardcdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
          File f = new File(shipyardcdata, File.separator + "signc.yml");
          FileConfiguration sycData = YamlConfiguration.loadConfiguration(f);

          //When the file is created for the first time...
          if (!f.exists()) {
              try {

                  sycData.createSection("Signs");
                  sycData.createSection("Shipyard");
                  sycData.createSection("Amount");
                  sycData.set("Shipyard.Amount", 0);
                  
                  sycData.save(f);
              } catch (IOException exception) {
                  exception.printStackTrace();
              }
          }
          if (!f1.exists()) {
              try {

                  syuData.createSection("Signs");
                  syuData.createSection("Shipyard");
                  syuData.createSection("Amount");
                  syuData.set("Shipyard.Amount", 0);
                  
                  syuData.save(f1);
              } catch (IOException exception) {
                  exception.printStackTrace();
              }
          }
	}
	
	public static void loadSignData () {
		File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
        File f = new File(shipyarddata, File.separator + "signc.yml");
        FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
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
        if (syData.getString("Shipyard.Amount").equals("0")) {
        	return;
        }
        for (int num : syData.getIntegerList("Amount")) {
        	String type = syData.getString("Signs." + num + "." + "type");
        	World world = plugin.getServer().getWorld(syData.getString("Signs." + num + "." + "world"));
        	int x = syData.getInt("Signs." + num + "." + "x");
        	int y = syData.getInt("Signs." + num + "." + "y");
        	int z = syData.getInt("Signs." + num + "." + "z");
        	int id = syData.getInt("Signs." + num + ".id");
        	String playerName = syData.getString("Signs." + num + ".playerName");
			Block selectSignBlock = world.getBlockAt(x, y, z);
			Sign selectSign = (Sign) selectSignBlock.getState();
        	if (type.equalsIgnoreCase("SHIP1")) {
				if (!NavyCraft.playerSHIP1Signs.containsKey(playerName)) {
					NavyCraft.playerSHIP1Signs.put(playerName, new ArrayList<Sign>());
					NavyCraft.playerSHIP1Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
				} else {
					NavyCraft.playerSHIP1Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
        	}
        }
        	if (type.equalsIgnoreCase("SHIP2")) {
				if (!NavyCraft.playerSHIP2Signs.containsKey(playerName)) {
					NavyCraft.playerSHIP2Signs.put(playerName, new ArrayList<Sign>());
					NavyCraft.playerSHIP2Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
				} else {
					NavyCraft.playerSHIP2Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
        	}
        }
        	if (type.equalsIgnoreCase("SHIP3")) {
				if (!NavyCraft.playerSHIP3Signs.containsKey(playerName)) {
					NavyCraft.playerSHIP3Signs.put(playerName, new ArrayList<Sign>());
					NavyCraft.playerSHIP3Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
				} else {
					NavyCraft.playerSHIP3Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
        	}
        }
        	if (type.equalsIgnoreCase("SHIP4")) {
				if (!NavyCraft.playerSHIP4Signs.containsKey(playerName)) {
					NavyCraft.playerSHIP4Signs.put(playerName, new ArrayList<Sign>());
					NavyCraft.playerSHIP4Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
				} else {
					NavyCraft.playerSHIP4Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
        	}
        }
        	if (type.equalsIgnoreCase("SHIP5")) {
				if (!NavyCraft.playerSHIP5Signs.containsKey(playerName)) {
					NavyCraft.playerSHIP5Signs.put(playerName, new ArrayList<Sign>());
					NavyCraft.playerSHIP5Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
				} else {
					NavyCraft.playerSHIP5Signs.get(playerName).add(selectSign);
					NavyCraft.playerSignIndex.put(selectSign, id);
					System.out.println("LOADED PLOTS");
        	}
        }
	}
}
	
	public static Block findSignOpen (String type) {
		File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
        File f = new File(shipyarddata, File.separator + "signu.yml");
        FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
    	Block selectSignBlock = null;
        for (int num : syData.getIntegerList("Amount")) {
        String ptype = syData.getString("Signs." + num + "." + "type");
    	World world = plugin.getServer().getWorld(syData.getString("Signs." + num + "." + "world"));
    	int x = syData.getInt("Signs." + num + "." + "x");
    	int y = syData.getInt("Signs." + num + "." + "y");
    	int z = syData.getInt("Signs." + num + "." + "z");
    	if (type.equalsIgnoreCase("SHIP1")) {
    		if (ptype.equalsIgnoreCase("SHIP1")) {
			selectSignBlock = world.getBlockAt(x, y, z);
    	}
    }
    	if (type.equalsIgnoreCase("SHIP2")) {
    		
    	}
    	if (type.equalsIgnoreCase("SHIP3")) {
    		
    	}
    	if (type.equalsIgnoreCase("SHIP4")) {
    		
    	}
    	if (type.equalsIgnoreCase("SHIP5")) {
    		
    	  }
        }
	    return selectSignBlock;  
	}
	
	public static void saveClaimedSign (String player, String type, String world , int x, int y, int z, int id) {
			  File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
	          File f = new File(shipyarddata, File.separator + "signc.yml");
	          FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "type", type);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "world", world);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "x", x);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "y", y);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "z", z);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "playerName", player);
		      syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "id", id);
	          syData.set("Shipyard.Amount", syData.getInt("Shipyard.Amount") + 1);
	          List<Integer> list=syData.getIntegerList("Amount");
	          list.add(syData.getInt("Shipyard.Amount"));
	          syData.set("Amount", list);
	          try {
				syData.save(f);
			} catch (IOException e) {
				loadShipyardData();
			}
		}
	
	public static void saveUnclaimedSign (String type, String world, int x, int y , int z){
			  File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
	          File f = new File(shipyarddata, File.separator + "signu.yml");
	          FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "type", type);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "world", world);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "x", x);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "y", y);
	          syData.set("Signs." + String.valueOf(syData.getInt("Shipyard.Amount") + 1) + "." + "z", z);
	          syData.set("Shipyard.Amount", syData.getInt("Shipyard.Amount") + 1);
	          List<Integer> list=syData.getIntegerList("Amount");
	          list.add(syData.getInt("Shipyard.Amount"));
	          syData.set("Amount", list);
	          try {
				syData.save(f);
			} catch (IOException e) {
				loadShipyardData();
			}
	}

	public static void loadPlayerData(String player)
	{
		  File userdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "userdata");
          File f = new File(userdata, File.separator + player + ".yml");
          FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);

          //When the player file is created for the first time...
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
          //Put all the hashmaps to file data
          loadExperience(player);
          loadVolume(player);
	}
	
	public static void loadExperience(String player) {
		  File userdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "userdata");
          File f = new File(userdata, File.separator + player + ".yml");
          FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
    	NavyCraft.playerExp.clear();
		NavyCraft.playerExp.put(player, Integer.valueOf(playerData.get(player + ".exp").toString()));
	}
	
	
	public static void saveExperience(String player)
	{
		  File userdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "userdata");
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
		  File userdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "userdata");
        File f = new File(userdata, File.separator + player + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
  	    NavyCraft.playerEngineVolumes.clear();
		NavyCraft.playerEngineVolumes.put(NavyCraft.instance.getServer().getPlayer(player), Float.valueOf(playerData.get(player + ".engvolume").toString()));
  	    NavyCraft.playerWeaponVolumes.clear();
		NavyCraft.playerWeaponVolumes.put(NavyCraft.instance.getServer().getPlayer(player), Float.valueOf(playerData.get(player + ".wepvolume").toString()));
  	    NavyCraft.playerOtherVolumes.clear();
		NavyCraft.playerOtherVolumes.put(NavyCraft.instance.getServer().getPlayer(player), Float.valueOf(playerData.get(player + ".othervolume").toString()));
	}
	
	
	public static void saveVolume(String player)
	{
		  File userdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "userdata");
        File f = new File(userdata, File.separator + player + ".yml");
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
        playerData.set(player + ".wepvolume", NavyCraft.playerWeaponVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
        playerData.set(player + ".engvolume", NavyCraft.playerEngineVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
        playerData.set(player + ".othervolume", NavyCraft.playerOtherVolumes.get(NavyCraft.instance.getServer().getPlayer(player)));
        try {
			playerData.save(f);
		} catch (IOException e) {
			loadPlayerData(player);
		}
	}
	public static void loadRewardsFile(String player)
	{
		  File userdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "userdata");
          File f = new File(userdata, File.separator + player + ".yml");
          FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
  		NavyCraft.playerSHIP1Rewards.put(player, NavyCraft.playerSHIP1Rewards.get(player) + Integer.valueOf(playerData.get(player + ".SHIP1").toString()));
  		NavyCraft.playerSHIP2Rewards.put(player, NavyCraft.playerSHIP2Rewards.get(player) + Integer.valueOf(playerData.get(player + ".SHIP2").toString()));
  		NavyCraft.playerSHIP3Rewards.put(player, NavyCraft.playerSHIP3Rewards.get(player) + Integer.valueOf(playerData.get(player + ".SHIP3").toString()));
  		NavyCraft.playerSHIP4Rewards.put(player, NavyCraft.playerSHIP4Rewards.get(player) + Integer.valueOf(playerData.get(player + ".SHIP4").toString()));
  		NavyCraft.playerSHIP5Rewards.put(player, NavyCraft.playerSHIP5Rewards.get(player) + Integer.valueOf(playerData.get(player + ".SHIP5").toString()));
  		return;
	}
	
	public static void saveRewardsFile(String player, String type, int newRewNum) {
	   File userdata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "userdata");
       File f = new File(userdata, File.separator + player + ".yml");
       FileConfiguration playerData = YamlConfiguration.loadConfiguration(f);
       if (type != null) {
           playerData.set(player + "." + type, Integer.valueOf(playerData.get(player + "." + type).toString()) + newRewNum);
       try {
			playerData.save(f);
			return;
		} catch (IOException e) {
			loadPlayerData(player);
		}
       return;
	}
}
	
}
