package com.maximuspayne.aimcannon;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.maximuspayne.navycraft.NavyCraft;
import com.maximuspayne.navycraft.craft.CraftMover;
@SuppressWarnings("deprecation")
public class ciwsFire extends BukkitRunnable
{
   private Player player;

   public ciwsFire(Player p)
   {
       player = p;
   }

   @Override
   public void run()
   {
		Egg newEgg = player.launchProjectile(Egg.class);
		newEgg.setVelocity(newEgg.getVelocity().multiply(2.0f));
		NavyCraft.explosiveEggsList.add(newEgg);
		player.getWorld().playEffect(player.getLocation(), Effect.SMOKE, 0);
		CraftMover.playWeaponSound(player.getLocation(), Sound.ENTITY_ZOMBIE_BREAK_DOOR_WOOD, 5.0f,1.70f);	
   }

public static void fireCIWS(Player player)
   {
	new Thread() {
	    @Override
	    public void run()
	    {
	    	
		setPriority(Thread.MIN_PRIORITY);
			try
			{
				while(NavyCraft.ciwsFiringList.contains(player))
				{
			         NavyCraft.instance.getServer().getScheduler().scheduleSyncDelayedTask(NavyCraft.instance, new ciwsFire(player));
					sleep(125);
				}
				
			} catch (InterruptedException e) 
			{
			}
	    }
	}.start();
  }
}