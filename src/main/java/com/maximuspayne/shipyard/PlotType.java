package com.maximuspayne.shipyard;

import com.maximuspayne.navycraft.ConfigManager;

public class PlotType {
	private ConfigManager cfgm;
	int bfr;
	int sizeX;
	int sizeY;
	int sizeZ;
	int originX;
	int originY;
	int originZ;
	String name;
	
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
	}
}
