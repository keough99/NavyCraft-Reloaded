package com.maximuspayne.navycraft.plugins;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.craft.CraftType;

/**
 * Permissions support file to interface Nijikokun's Permissions plugin to NavyCraft
 */

public class PermissionInterface {
	public static NavyCraft plugin;
	// public static PermissionInfo Permissions = null;
	
	public static void setupPermissions(NavyCraft p) {
		plugin = p;
		PluginManager pm = NavyCraft.instance.getServer().getPluginManager();
		if (pm != null) {
			pm.addPermission(new Permission("navycraft.periscope.use"));
			pm.addPermission(new Permission("navycraft.aa-gun.use"));
			pm.addPermission(new Permission("navycraft.flak-gun.use"));
			pm.addPermission(new Permission("navycraft.periscope.create"));
			pm.addPermission(new Permission("navycraft.aa-gun.create"));
			pm.addPermission(new Permission("navycraft.flak-gun.create"));

			for (CraftType type : CraftType.craftTypes) {
				pm.addPermission(new Permission("navycraft." + type.name + ".release"));
				pm.addPermission(new Permission("navycraft." + type.name + ".info"));
				pm.addPermission(new Permission("navycraft." + type.name + ".takeover"));
				pm.addPermission(new Permission("navycraft." + type.name + ".start"));
				pm.addPermission(new Permission("navycraft." + type.name + ".create"));
				pm.addPermission(new Permission("navycraft." + type.name + ".sink"));
				pm.addPermission(new Permission("navycraft." + type.name + ".remove"));
			}
		}
	}
	
	public static void removePermissions(NavyCraft p) {
		plugin = p;
		PluginManager pm = NavyCraft.instance.getServer().getPluginManager();
		if (pm != null) {
			pm.removePermission(new Permission("navycraft.periscope.use"));
			pm.removePermission(new Permission("navycraft.aa-gun.use"));
			pm.removePermission(new Permission("navycraft.flak-gun.use"));
			pm.removePermission(new Permission("navycraft.periscope.create"));
			pm.removePermission(new Permission("navycraft.aa-gun.create"));
			pm.removePermission(new Permission("navycraft.flak-gun.create"));

			for (CraftType type : CraftType.craftTypes) {
				pm.removePermission(new Permission("navycraft." + type.name + ".release"));
				pm.removePermission(new Permission("navycraft." + type.name + ".info"));
				pm.removePermission(new Permission("navycraft." + type.name + ".takeover"));
				pm.removePermission(new Permission("navycraft." + type.name + ".start"));
				pm.removePermission(new Permission("navycraft." + type.name + ".create"));
				pm.removePermission(new Permission("navycraft." + type.name + ".sink"));
				pm.removePermission(new Permission("navycraft." + type.name + ".remove"));
			}
		}
	}
	
	public static boolean CheckPerm(Player player, String command) {
		command = command.replace(" ", ".");
		NavyCraft.instance.DebugMessage("Checking if " + player.getName() + " can " + command, 3);
		
		if (player.hasPermission(command) || player.isOp()) {
			NavyCraft.instance.DebugMessage("Player has permissions: " + command, 3);
			NavyCraft.instance.DebugMessage("Player isop: " +
					player.isOp(), 3);
			return true;
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission to perform " + ChatColor.YELLOW + command);
			return false;
		}
	}

	public static boolean CheckQuietPerm(Player player, String command) {
		command = command.replace(" ", ".");
		NavyCraft.instance.DebugMessage("Checking if " + player.getName() + " can " + command, 3);
		
		if (player.hasPermission(command) || player.isOp()) {
			NavyCraft.instance.DebugMessage("Player has permissions: " + command, 3);
			NavyCraft.instance.DebugMessage("Player isop: " +
					player.isOp(), 3);
			return true;
		} else // player.sendMessage("You do not have permission to perform " + command);
			return false;
	}

	public static boolean CheckEnabledWorld(Location loc) {
		if (!plugin.getConfig().getString("EnabledWorlds").equalsIgnoreCase("null")) {
			String world = NavyCraft.instance.getConfig().getString("EnabledWorlds");
			if (loc.getWorld().getName().equalsIgnoreCase(world)) return true;	
		}
	return false;
}
	
	public static boolean CheckShipyardWorld(Location loc) {
		if (!plugin.getConfig().getString("ShipyardWorld").equalsIgnoreCase("null")) {
			String world = NavyCraft.instance.getConfig().getString("ShipyardWorld");
				if (loc.getWorld().getName().equalsIgnoreCase(world)) return true;	
			}
		return false;
	}
	
	public static boolean CheckBattleWorld(Location loc) {
		if (!plugin.getConfig().getString("BattleWorld").equalsIgnoreCase("null")) {
			String world = NavyCraft.instance.getConfig().getString("BattleWorld");
			if (loc.getWorld().getName().equalsIgnoreCase(world)) return true;	
		}
	return false;
}

public static World EnabledWorld() {
	if (!plugin.getConfig().getString("EnabledWorld").equalsIgnoreCase("null")) {
		World worlds = NavyCraft.instance.getServer().getWorld(NavyCraft.instance.getConfig().getString("EnabledWorld"));
		return worlds;	
		}
	return null;
}

public static World ShipyardWorld() {
	if (!plugin.getConfig().getString("ShipyardWorld").equalsIgnoreCase("null")) {
		World worlds = NavyCraft.instance.getServer().getWorld(NavyCraft.instance.getConfig().getString("ShipyardWorld"));
		return worlds;	
		}
	return null;
}

public static World BattleWorld() {
	if (!plugin.getConfig().getString("BattleWorld").equalsIgnoreCase("null")) {
		World worlds = NavyCraft.instance.getServer().getWorld(NavyCraft.instance.getConfig().getString("BattleWorld"));
		return worlds;	
		}
	return null;
}
}
