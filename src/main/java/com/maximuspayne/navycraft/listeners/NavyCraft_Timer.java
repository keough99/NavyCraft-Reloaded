package com.maximuspayne.navycraft.listeners;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.maximuspayne.navycraft.ConfigManager;
import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.craft.Craft;
import com.maximuspayne.shipyard.PlotType;
import com.maximuspayne.shipyard.Shipyard;

import ru.tehkode.permissions.bukkit.PermissionsEx;

@SuppressWarnings("deprecation")
public class NavyCraft_Timer extends BukkitRunnable {
	
	public static ConfigManager cfgm;
	Plugin plugin;
	Timer timer;
	Craft craft;
	Player player;
	//public String state = "";
	public static HashMap<Player, NavyCraft_Timer> playerTimers = new HashMap<Player, NavyCraft_Timer>();
	public static HashMap<Craft, NavyCraft_Timer> takeoverTimers = new HashMap<Craft, NavyCraft_Timer>();
	public static HashMap<Craft, NavyCraft_Timer> abandonTimers = new HashMap<Craft, NavyCraft_Timer>();
	public static PermissionsEx pex;

	public NavyCraft_Timer(Plugin plug, int seconds, Craft vehicle, Player p, String state, boolean forward) {
		//toolkit = Toolkit.getDefaultToolkit();
		plugin = plug;
		this.craft = vehicle;
		this.player = p;
		timer = new Timer();
		if(state.equals("engineCheck"))
			timer.scheduleAtFixedRate(new EngineTask(), 1000, 1000);
		else if(state.equals("abandonCheck"))
			timer.scheduleAtFixedRate(new ReleaseTask(), seconds * 1000, 60000);
		else if(state.equals("takeoverCheck"))
			timer.scheduleAtFixedRate(new TakeoverTask(), seconds * 1000, 60000);
		else if(state.equals("takeoverCaptainCheck"))
			timer.scheduleAtFixedRate(new TakeoverCaptainTask(), seconds * 1000, 60000);
	}
	
	public void Destroy() {
		timer.cancel();
		craft = null;
	}
	
	class EngineTask extends TimerTask {
		public void run() {
			if(craft == null)
				timer.cancel();
			else
				craft.engineTick();
			return;
		}
	}

	class ReleaseTask extends TimerTask {
		public void run() {			
				if(craft != null && craft.isNameOnBoard.containsKey(player.getName()) ) {
					if( !craft.isNameOnBoard.get(player.getName()) )
						releaseCraftSync();
					
				}
				timer.cancel();
				return;
		}
	}
	
   public void releaseCraftSync()
    {
    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
		    public void run()
		    {
		    }
    	}
    	);
	 }
   
	class TakeoverTask extends TimerTask {
		public void run() {	
				takeoverCraftSync();
					

				timer.cancel();
				return;
		}
	}
	
   public void takeoverCraftSync()
    {
    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
		    public void run()
		    {
		    	if( craft.abandoned && player != null && player.isOnline() && craft.isOnCraft(player, false) )
		    	{
		    		craft.releaseCraft();
		    		player.sendMessage(ChatColor.GREEN + "Vehicle released! Take command.");
		    	}else
		    	{
		    		player.sendMessage(ChatColor.RED + "Takeover failed.");
		    	}
		    	
		    	
		    }
    	}
    	);
	 }
   
	class TakeoverCaptainTask extends TimerTask {
		public void run() {				

				takeoverCaptainCraftSync();
					

				timer.cancel();
				return;
		}
	}
	
   public void takeoverCaptainCraftSync()
    {
    	plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
		    public void run()
		    {
		    	if( craft.captainAbandoned && player != null && player.isOnline() && craft.isOnCraft(player, false) )
		    	{
		    		craft.releaseCraft();
		    		player.sendMessage(ChatColor.GREEN + "Vehicle released! Take command.");
		    	}else
		    	{
		    		player.sendMessage(ChatColor.RED + "Takeover failed.");
		    	}
		    	
		    	
		    }
    	}
    	);
    }
   
   //Shipyard initial Sign Loading
	public static void loadPlots() {
    	NavyCraft.instance.getServer().getScheduler().scheduleSyncDelayedTask(NavyCraft.instance, new Runnable(){
		    public void run()
		    {
	for (PlotType pt : Shipyard.plots) {
		World syworld = NavyCraft.instance.getServer().getWorld(cfgm.syConfig.getString("SHIP1World"));
		int startX = cfgm.syConfig.getInt("Types." + pt.name + ".SX");
		int endX = cfgm.syConfig.getInt("Types." + pt.name + ".EX");
		int widthX = cfgm.syConfig.getInt("Types." + pt.name + ".WX");
		int y = cfgm.syConfig.getInt("Types." + pt.name + ".Y");
		int startZ = cfgm.syConfig.getInt("Types." + pt.name + ".SZ");
		int endZ = cfgm.syConfig.getInt("Types." + pt.name + ".EZ");
		int widthZ = cfgm.syConfig.getInt("Types." + pt.name + ".WZ");
		for (int x = startX; x <= endX; x += widthX) {
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if (syworld.getBlockAt(x, y, z).getTypeId() == 63
						&& syworld.getBlockAt(x, y - 1, z + 1).getTypeId() == 68) {
					Block selectSignBlock = syworld.getBlockAt(x, y, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);
					
					if (signLine0.equalsIgnoreCase("*claim*")) {
						
						NavyCraft_FileListener.saveSign(pt.name, "shipyard", x, y, z);
						
					}
				}
			}
		}
	}
}
    	}
    	);
	}
@Override
public void run() {
}
}
