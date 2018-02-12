package com.maximuspayne.navycraft.listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.maximuspayne.navycraft.NavyCraft;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.EmptyClipboardException;
import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import ru.tehkode.permissions.bukkit.PermissionsEx;

// Written by Solmex, Bits of code used from Maximuspayne - NavyCraft-Shipyard
@SuppressWarnings("deprecation")
public class NavyCraft_FileListener implements Listener {
	
	private static NavyCraft plugin;
	public WorldGuardPlugin wgp;
	public static PermissionsEx pex;
	public WorldEditPlugin wep;
	
	public NavyCraft_FileListener(NavyCraft p) {
		plugin = p;
	}

	public static void loadSHIP1Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "SHIP1";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (p != player.getName()) {
						player.sendMessage(ChatColor.RED + "You don't have permission to load this plot!");
							return;
						}

						if (!NavyCraft.playerSHIP1Schematics.containsKey(p)) {
							NavyCraft.playerSHIP1Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerSHIP1Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	public static void loadSHIP2Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "SHIP2";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (p != player.getName()) {
						player.sendMessage(ChatColor.RED + "You don't have permission to load this plot!");
							return;
						}

						if (!NavyCraft.playerSHIP2Schematics.containsKey(p)) {
							NavyCraft.playerSHIP2Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerSHIP2Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	public static void loadSHIP3Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "SHIP3";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (p != player.getName()) {
						player.sendMessage(ChatColor.RED + "You don't have permission to load this plot!");
							return;
						}

						if (!NavyCraft.playerSHIP3Schematics.containsKey(p)) {
							NavyCraft.playerSHIP3Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerSHIP3Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	public static void loadSHIP4Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "SHIP4";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (p != player.getName()) {
						player.sendMessage(ChatColor.RED + "You don't have permission to load this plot!");
							return;
						}

						if (!NavyCraft.playerSHIP4Schematics.containsKey(p)) {
							NavyCraft.playerSHIP4Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerSHIP4Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}

	public static void loadSHIP5Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "SHIP5";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (p != player.getName()) {
						player.sendMessage(ChatColor.RED + "You don't have permission to load this plot!");
							return;
						}

						if (!NavyCraft.playerSHIP5Schematics.containsKey(p)) {
							NavyCraft.playerSHIP5Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerSHIP5Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	public static void loadHANGAR1Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "HANGAR1";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (p != player.getName()) {
						player.sendMessage(ChatColor.RED + "You don't have permission to load this plot!");
							return;
						}

						if (!NavyCraft.playerHANGAR1Schematics.containsKey(p)) {
							NavyCraft.playerHANGAR1Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerHANGAR1Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	public static void loadHANGAR2Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "HANGAR2";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (!NavyCraft.playerHANGAR2Schematics.containsKey(p)) {
							NavyCraft.playerHANGAR2Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerHANGAR2Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	public static void loadTANK1Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "TANK1";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (!NavyCraft.playerTANK1Schematics.containsKey(p)) {
							NavyCraft.playerTANK1Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerTANK1Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	public static void loadTANK2Schematics(Player player) {
		int maxId = maxId(player);
		String lotStr = "TANK2";

String files = plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId;
	    File file = new File (plugin.getDataFolder() + "/schematics/" + player + "-" + lotStr + "-" + maxId);
	    	String[] parts = files.split("-");
	    	String p = parts[0]; // player
	    	if (!NavyCraft.playerTANK2Schematics.containsKey(p)) {
							NavyCraft.playerTANK2Schematics.put(p, new ArrayList<File>());
							NavyCraft.playerTANK2Schematics.get(p).add(file);
							NavyCraft.playerSchematicIndex.put(file, maxId);
						}

					}
	
	public static void loadSchematics(Player player) {
		for (String s : NavyCraft.playerSHIP1Schematics.keySet()) {
			NavyCraft.playerSHIP1Schematics.get(s).clear();
		}
		NavyCraft.playerSHIP1Schematics.clear();
		for (String s : NavyCraft.playerSHIP2Schematics.keySet()) {
			NavyCraft.playerSHIP2Schematics.get(s).clear();
		}
		NavyCraft.playerSHIP2Schematics.clear();
		for (String s : NavyCraft.playerSHIP3Schematics.keySet()) {
			NavyCraft.playerSHIP3Schematics.get(s).clear();
		}
		NavyCraft.playerSHIP3Schematics.clear();
		for (String s : NavyCraft.playerSHIP4Schematics.keySet()) {
			NavyCraft.playerSHIP4Schematics.get(s).clear();
		}
		NavyCraft.playerSHIP4Schematics.clear();
		for (String s : NavyCraft.playerSHIP5Schematics.keySet()) {
			NavyCraft.playerSHIP5Schematics.get(s).clear();
		}
		NavyCraft.playerSHIP5Schematics.clear();
		for (String s : NavyCraft.playerHANGAR1Schematics.keySet()) {
			NavyCraft.playerHANGAR1Schematics.get(s).clear();
		}
		NavyCraft.playerHANGAR1Schematics.clear();
		for (String s : NavyCraft.playerHANGAR2Schematics.keySet()) {
			NavyCraft.playerHANGAR2Schematics.get(s).clear();
		}
		NavyCraft.playerHANGAR2Schematics.clear();
		for (String s : NavyCraft.playerTANK1Schematics.keySet()) {
			NavyCraft.playerTANK1Schematics.get(s).clear();
		}
		NavyCraft.playerTANK1Schematics.clear();
		for (String s : NavyCraft.playerTANK2Schematics.keySet()) {
			NavyCraft.playerTANK2Schematics.get(s).clear();
		}
		NavyCraft.playerTANK2Schematics.clear();
		for (String s : NavyCraft.playerSHIP1Schematics.keySet()) {
			NavyCraft.playerSHIP1Schematics.get(s).clear();
		}
		loadSHIP1Schematics(player);
		loadSHIP2Schematics(player);
		loadSHIP3Schematics(player);
		loadSHIP4Schematics(player);
		loadSHIP5Schematics(player);
		loadHANGAR1Schematics(player);
		loadHANGAR2Schematics(player);
		loadTANK1Schematics(player);
		loadTANK2Schematics(player);
	}
	
	public static void saveSchematic(Player player, String lotStr) {
		int maxID = 0;
	
        File dir = new File(plugin.getDataFolder(), "/schematics/");
        if (!dir.exists())
            dir.mkdirs();
        File f = new File(plugin.getDataFolder(), "/schematics/" + player + "-" + lotStr + "-" + maxID);
        	try {
			 WorldEditPlugin wep = (WorldEditPlugin) NavyCraft.instance.getServer().getPluginManager().getPlugin("WorldEdit");
			    WorldEdit we = wep.getWorldEdit();

			    LocalPlayer localPlayer = wep.wrapPlayer(player);
			    LocalSession localSession = we.getSession(localPlayer);
			    ClipboardHolder selection = localSession.getClipboard();
			    EditSession editSession = localSession.createEditSession(localPlayer);

			    Vector min = selection.getClipboard().getMinimumPoint();
			    Vector max = selection.getClipboard().getMaximumPoint();

			    editSession.enableQueue();
			    CuboidClipboard clipboard = new CuboidClipboard(max.subtract(min).add(new Vector(1, 1, 1)), min);
			    clipboard.copy(editSession);
					SchematicFormat.MCEDIT.save(clipboard, f);
			        editSession.flushQueue();
				} catch (DataException | IOException | EmptyClipboardException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }
	
	public static int maxId(Player player) {
		int foundHighest = -1;
		if (NavyCraft.playerSHIP1Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerSHIP1Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerSHIP2Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerSHIP2Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerSHIP3Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerSHIP3Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerSHIP4Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerSHIP4Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerSHIP5Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerSHIP5Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerHANGAR1Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerHANGAR1Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerHANGAR2Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerHANGAR2Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerTANK1Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerTANK1Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerTANK2Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerTANK2Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerMAP1Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerMAP1Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerMAP2Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerMAP2Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerMAP3Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerMAP3Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerMAP4Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerMAP4Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		if (NavyCraft.playerMAP5Schematics.containsKey(player.getName())) {
			for (File s : NavyCraft.playerMAP5Schematics.get(player.getName())) {
				if (foundHighest < NavyCraft.playerSchematicIndex.get(s)) {
					foundHighest = NavyCraft.playerSchematicIndex.get(s);
				}
			}
		}
		return foundHighest;
	}
	
}
