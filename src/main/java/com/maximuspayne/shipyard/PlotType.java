package com.maximuspayne.shipyard;

import java.util.ArrayList;
import java.util.List;

import com.maximuspayne.navycraft.ConfigManager;

public class PlotType {
	public static ConfigManager cfgm;
	public int bfr;
	public int sizeX;
	public int sizeY;
	public int sizeZ;
	public int originX;
	public int originY;
	public int originZ;
	public boolean doFix;
	public boolean dontSelect;
	public String name;
	
	public PlotType(String n)
	{
		name = n;
		sizeX = cfgm.getsyConfig().getInt("Types." + n + ".SZX");
		sizeY = cfgm.getsyConfig().getInt("Types." + n + ".SZY");
		sizeZ = cfgm.getsyConfig().getInt("Types." + n + ".SZZ");
		originX= cfgm.getsyConfig().getInt("Types." + n + ".OX");
		originY = cfgm.getsyConfig().getInt("Types." + n + ".OYX");
		originZ = cfgm.getsyConfig().getInt("Types." + n + ".OZX");
		bfr = cfgm.getsyConfig().getInt("Types." + n + ".BFR");
		doFix = cfgm.getsyConfig().getBoolean("Types." + n + ".doFix");
		dontSelect = cfgm.getsyConfig().getBoolean("Types." + n + ".dontSelect");
	}
	
	public static void initialize() {
		List<String> list = new ArrayList<String>(cfgm.getsyConfig().getConfigurationSection("Types").getKeys(false));
		for (String num : list) {
			PlotType Plot = new PlotType(num);
			Shipyard.plots.add(Plot);
		}
	}
}
