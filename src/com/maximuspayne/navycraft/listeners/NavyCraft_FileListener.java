package com.maximuspayne.navycraft.listeners;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.maximuspayne.navycraft.NavyCraft;

@SuppressWarnings("deprecation")
public class NavyCraft_FileListener {

	public static void loadShipyardData(String player)
	{
		  File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
          File f = new File(shipyarddata, File.separator + "signs.yml");
          FileConfiguration syData = YamlConfiguration.loadConfiguration(f);

          //When the file is created for the first time...
          if (!f.exists()) {
              try {

                  syData.createSection("SHIP1Signs");
                  syData.createSection("SHIP2Signs");
                  syData.createSection("SHIP3Signs");
                  syData.createSection("SHIP4Signs");
                  syData.createSection("SHIP5Signs");
                  syData.createSection("HANGAR1Signs");
                  syData.createSection("HANGAR2Signs");
                  syData.createSection("TANK1Signs");
                  syData.createSection("TANK2Signs");
                  syData.createSection("MAP1Signs");
                  syData.createSection("MAP2Signs");
                  syData.createSection("MAP3Signs");
                  syData.createSection("MAP4Signs");
                  syData.createSection("MAP5Signs");
                  
                  syData.save(f);
              } catch (IOException exception) {
                  exception.printStackTrace();
              }
          }
          //Put all the hashmaps to file data
          //loadShipyard();
	}
	
	public static void loadSignData (String player, String type) {
		
	}
	
	public static void saveSignData (String player, String type, int x, int y, int z, boolean claimed) {
			  File shipyarddata = new File(NavyCraft.instance.getServer().getPluginManager().getPlugin("NavyCraft").getDataFolder(), File.separator + "shipyarddata");
	          File f = new File(shipyarddata, File.separator + "signs.yml");
	          FileConfiguration syData = YamlConfiguration.loadConfiguration(f);
	          syData.set("SHIP1Signs.1", Integer.valueOf(NavyCraft.playerExp.get(player).toString()));
	          try {
				syData.save(f);
			} catch (IOException e) {
				loadPlayerData(player);
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
