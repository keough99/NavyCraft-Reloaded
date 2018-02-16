package com.maximuspayne.navycraft.listeners;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.craft.Craft;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class NavyCraft_Timer extends BukkitRunnable {
	
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
	
   
   public static void loadShipyard()
   {
   	NavyCraft.instance.getServer().getScheduler().scheduleSyncDelayedTask(NavyCraft.instance, new Runnable(){
		    public void run() {
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
		NavyCraft_BlockListener.loadSHIP1Signs();
		NavyCraft_BlockListener.loadSHIP2Signs();
		NavyCraft_BlockListener.loadSHIP3Signs();
		NavyCraft_BlockListener.loadSHIP4Signs();
		NavyCraft_BlockListener.loadSHIP5Signs();
		NavyCraft_BlockListener.loadHANGAR1Signs();
		NavyCraft_BlockListener.loadHANGAR2Signs();
		NavyCraft_BlockListener.loadTANK1Signs();
		NavyCraft_BlockListener.loadTANK2Signs();
		NavyCraft_BlockListener.loadMAP1Signs();
		NavyCraft_BlockListener.loadMAP2Signs();
		NavyCraft_BlockListener.loadMAP3Signs();
		NavyCraft_BlockListener.loadMAP4Signs();
		NavyCraft_BlockListener.loadMAP5Signs();
	}
   	} 
   	);
   }

@Override
public void run() {
}
}
