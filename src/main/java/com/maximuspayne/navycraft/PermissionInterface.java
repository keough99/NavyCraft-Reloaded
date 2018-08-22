package com.maximuspayne.navycraft;


import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.craft.CraftType;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.extent.clipboard.BlockArrayClipboard;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.function.mask.ExistingBlockMask;
import com.sk89q.worldedit.function.operation.ForwardExtentCopy;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldedit.world.registry.WorldData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

/**
 * Permissions support file to interface Nijikokun's Permissions plugin to NavyCraft
*/

public class PermissionInterface {
	public static NavyCraft plugin;
	//public static PermissionInfo Permissions = null;

	public static void setupPermissions(NavyCraft p) {
		plugin = p;
		PluginManager pm = NavyCraft.instance.getServer().getPluginManager();
		if(pm != null) {
			pm.addPermission(new Permission("navycraft.periscope.use"));
			pm.addPermission(new Permission("navycraft.aa-gun.use"));
			pm.addPermission(new Permission("navycraft.flak-gun.use"));
			pm.addPermission(new Permission("navycraft.periscope.create"));
			pm.addPermission(new Permission("navycraft.aa-gun.create"));
			pm.addPermission(new Permission("navycraft.flak-gun.create"));
			
			for (CraftType type : CraftType.craftTypes) 
			{
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
		if(pm != null) {
			pm.removePermission(new Permission("navycraft.periscope.use"));
			pm.removePermission(new Permission("navycraft.aa-gun.use"));
			pm.removePermission(new Permission("navycraft.flak-gun.use"));
			pm.removePermission(new Permission("navycraft.periscope.create"));
			pm.removePermission(new Permission("navycraft.aa-gun.create"));
			pm.removePermission(new Permission("navycraft.flak-gun.create"));
			
			for (CraftType type : CraftType.craftTypes) 
			{
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
	
	@SuppressWarnings("deprecation")
	public static String getUUIDfromPlayer(String player) {
		String UUID = NavyCraft.instance.getServer().getOfflinePlayer(player).getUniqueId().toString();
		return UUID;
		}
	
	public static boolean CheckPerm(Player player, String command) {		
		command = command.replace(" ", ".");
		NavyCraft.instance.DebugMessage("Checking if " + player.getName() + " can " + command, 3);
		
		
		    if( player.hasPermission(command) || player.isOp() ) 
		    {
		    	NavyCraft.instance.DebugMessage("Player has permissions: " + command, 3);
		    	NavyCraft.instance.DebugMessage("Player isop: " + 
		    			player.isOp(), 3);
		    	return true;
		    } else 
		    {
				player.sendMessage(ChatColor.RED + "You do not have permission to perform " + ChatColor.YELLOW + command);
				return false;
		    }
	}
	
	public static boolean CheckQuietPerm(Player player, String command) {		
		command = command.replace(" ", ".");
		NavyCraft.instance.DebugMessage("Checking if " + player.getName() + " can " + command, 3);
		
		
		    if( player.hasPermission(command) || player.isOp() ) 
		    {
		    	NavyCraft.instance.DebugMessage("Player has permissions: " + command, 3);
		    	NavyCraft.instance.DebugMessage("Player isop: " + 
		    			player.isOp(), 3);
		    	return true;
		    } else 
		    {
				//player.sendMessage("You do not have permission to perform " + command);
				return false;
		    }
	}
	
	public static boolean CheckEnabledWorld(Location loc) {
		if(!NavyCraft.instance.getConfig().getString("EnabledWorlds").equalsIgnoreCase("null")) {
			String[] worlds = NavyCraft.instance.getConfig().getString("EnabledWorlds").split(",");
			for(int i = 0; i < worlds.length; i++) {
				if( loc.getWorld().getName().equalsIgnoreCase(worlds[i]) )
				{
					return true;
				}
					
			}
			return false;
		}
		return true;
	}
	public static boolean CheckBattleWorld(Location loc) {
		if(!NavyCraft.instance.getConfig().getString("BattleWorld").equalsIgnoreCase("null")) {
			String[] worlds = NavyCraft.instance.getConfig().getString("BattleWorld").split(",");
			for(int i = 0; i < worlds.length; i++) {
				if( loc.getWorld().getName().equalsIgnoreCase(worlds[i]) )
				{
					return true;
				}
					
			}
			return false;
		}
		return true;
	}
	
	public static void loadSchem(String filename, int x, int y, int z, org.bukkit.World world) {
        File dataDirectory = new File (plugin.getDataFolder(), "saves");
        File file = new File(dataDirectory, filename); // The schematic file
        Vector to = new Vector(x, y, z); // Where you want to paste
        World weWorld = new BukkitWorld(world);
        WorldData worldData = weWorld.getWorldData();
        Clipboard clipboard;
        try {
            clipboard = ClipboardFormat.SCHEMATIC.getReader(new FileInputStream(file)).read(worldData);
            Extent source = clipboard;
            Extent destination = WorldEdit.getInstance().getEditSessionFactory().getEditSession(weWorld, -1);
            ForwardExtentCopy copy = new ForwardExtentCopy(source, clipboard.getRegion(), clipboard.getOrigin(), destination, to);
            copy.setSourceMask(new ExistingBlockMask(clipboard));
            Operations.completeLegacy(copy);
        } catch (IOException | WorldEditException e) {
            e.printStackTrace();
        }
}
	
	public static void saveSchem(String filename, int x1, int y1, int z1, int x2, int y2, int z2, org.bukkit.World world) {
        World weWorld = new BukkitWorld(world);
        WorldData worldData = weWorld.getWorldData();
        Vector pos1 = new Vector(x1, y1, z1); //First corner of your cuboid
        Vector pos2 = new Vector(x2, y2, z2); //Second corner fo your cuboid
        CuboidRegion cReg = new CuboidRegion(weWorld, pos1, pos2);
        File dataDirectory = new File (plugin.getDataFolder(), "saves");
        File file = new File(dataDirectory, filename + ".schematic"); // The schematic file
        try {
            BlockArrayClipboard clipboard = new BlockArrayClipboard(cReg);      
            Extent source = WorldEdit.getInstance().getEditSessionFactory().getEditSession(weWorld, -1);
            Extent destination = clipboard;
            ForwardExtentCopy copy = new ForwardExtentCopy(source, cReg, clipboard.getOrigin(), destination, pos1);
            copy.setSourceMask(new ExistingBlockMask(source));
            Operations.completeLegacy(copy);
            ClipboardFormat.SCHEMATIC.getWriter(new FileOutputStream(file)).write(clipboard, worldData);          
        } catch (IOException | MaxChangedBlocksException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}