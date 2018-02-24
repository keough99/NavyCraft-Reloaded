package com.maximuspayne.navycraft.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

import com.maximuspayne.navycraft.NavyCraft;

@SuppressWarnings("deprecation")
public class NavyCraft_ShipyardSignLoader {
	
	private static NavyCraft plugin;
	
	public static void loadSHIP1Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=601; x<=1567; x+=14 )
		// for( int x=16; x<=1286; x+=14 )
		int startX = 601;
		int endX = 1567;
		int widthX = 14;
		int startZ = -408;
		int endZ = -852;
		int widthZ = 37;
		for (int x = startX; x <= endX; x += widthX) {

			// for( int z=-408; z>=-852; z-=37 )
			// for( int z=-18; z>=-462; z-=37 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0);
					String sign2Line2 = selectSign2.getLine(2);

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerSHIP1Signs.containsKey(playerName)) {
							NavyCraft.playerSHIP1Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerSHIP1Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerSHIP1Signs.get(playerName).add(selectSign);
						NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}

	public static Block findSHIP1Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=601; x<=1567; x+=14 )
		// for( int x=16; x<=1286; x+=14 )
		int startX = 601;
		int endX = 1567;
		int widthX = 14;
		int startZ = -408;
		int endZ = -852;
		int widthZ = 37;
		for (int x = startX; x <= endX; x += widthX) {

			// for( int z=-408; z>=-852; z-=37 )
			// for( int z=-18; z>=-462; z-=37 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}

	public static void loadSHIP2Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=601; x<=1421; x+=10 )
		// for( int x=16; x<=1296; x+=10 )
		int startX = 601;
		int endX = 1421;
		int widthX = 10;
		int startZ = -356;
		int endZ = -148;
		int widthZ = 52;
		for (int x = startX; x <= endX; x += widthX) {

			// for( int z=-356; z<=-148; z+=52 )
			// for( int z=33; z<=241; z+=52 )
			for (int z = startZ; z <= endZ; z += widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0);
					String sign2Line2 = selectSign2.getLine(2);

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerSHIP2Signs.containsKey(playerName)) {
							NavyCraft.playerSHIP2Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerSHIP2Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerSHIP2Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}

	public static Block findSHIP2Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=601; x<=1421; x+=10 )
		// for( int x=16; x<=1296; x+=10 )
		int startX = 601;
		int endX = 1421;
		int widthX = 10;
		int startZ = -356;
		int endZ = -148;
		int widthZ = 52;
		for (int x = startX; x <= endX; x += widthX) {

			// for( int z=-356; z<=-148; z+=52 )
			// for( int z=33; z<=241; z+=52 )
			for (int z = startZ; z <= endZ; z += widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}

	public static void loadSHIP3Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=549; x>=21; x-=12 )
		// for( int x=-35; x>=-1091; x-=12 )
		int startX = 549;
		int endX = 21;
		int widthX = 12;
		int startZ = -329;
		int endZ = -92;
		int widthZ = 79;
		for (int x = startX; x >= endX; x -= widthX) {

			// for( int z=-329; z<=-92; z+=79 )
			// for( int z=60; z<=297; z+=79 )
			for (int z = startZ; z <= endZ; z += widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0);
					String sign2Line2 = selectSign2.getLine(2);

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerSHIP3Signs.containsKey(playerName)) {
							NavyCraft.playerSHIP3Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerSHIP3Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerSHIP3Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}

	public static Block findSHIP3Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=549; x>=21; x-=12 )
		// for( int x=-35; x>=-1091; x-=12 )
		int startX = 549;
		int endX = 21;
		int widthX = 12;
		int startZ = -329;
		int endZ = -92;
		int widthZ = 79;
		for (int x = startX; x >= endX; x -= widthX) {
			// for( int z=-329; z<=-92; z+=79 )
			// for( int z=60; z<=297; z+=79 )
			for (int z = startZ; z <= endZ; z += widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}

	public static void loadSHIP4Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=543; x>=21; x-=18 )
		// for( int x=-41; x>=-1085; x-=18 )
		int startX = 543;
		int endX = 21;
		int widthX = 18;
		int startZ = -408;
		int endZ = -600;
		int widthZ = 64;
		for (int x = startX; x >= endX; x -= widthX) {

			// for( int z=-408; z>=-600; z-=64 )
			// for( int z=-18; z>=-210; z-=64 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
					String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerSHIP4Signs.containsKey(playerName)) {
							NavyCraft.playerSHIP4Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerSHIP4Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerSHIP4Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}

	public static Block findSHIP4Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=543; x>=21; x-=18 )
		// for( int x=-41; x>=-1085; x-=18 )
		int startX = 543;
		int endX = 21;
		int widthX = 18;
		int startZ = -408;
		int endZ = -600;
		int widthZ = 64;
		for (int x = startX; x >= endX; x -= widthX) {

			// for( int z=-408; z>=-600; z-=64 )
			// for( int z=-18; z>=-210; z-=64 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}

	public static void loadSHIP5Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=1404; x>=656; x-=22 )
		// for( int x=1270; x>=16; x-=22 )
		int startX = 656;
		int endX = 1426;
		int widthX = 18;
		int startZ = 142;
		int endZ = 37;
		int widthZ = 105;
		for (int x = startX; x <= endX; x += widthX) {

			// for( int z=37; z<=142; z+=105 )
			// for( int z=349; z<=454; z+=105 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
					String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerSHIP5Signs.containsKey(playerName)) {
							NavyCraft.playerSHIP5Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerSHIP5Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerSHIP5Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}

	public static Block findSHIP5Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=1404; x>=656; x-=22 )
		// for( int x=1270; x>=16; x-=22 )
		int startX = 656;
		int endX = 1426;
		int widthX = 18;
		int startZ = 142;
		int endZ = 37;
		int widthZ = 105;
		for (int x = startX; x <= endX; x += widthX) {
			// for( int z=37; z<=142; z+=105 )
			// for( int z=349; z<=454; z+=105 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}

	public static void loadHANGAR1Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=553; x>=-137; x-=23 )
		// for( int x=-31; x>=-1067; x-=23 )
		int startX = 553;
		int endX = -137;
		int widthX = 23;
		int startZ = -766;
		int endZ = -1191;
		int widthZ = 25;
		for (int x = startX; x >= endX; x -= widthX) {

			// for( int z=-766; z>=-1191; z-=25 )
			// for( int z=-278; z>=-828; z-=25 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 65, z);
					Block selectSignBlock2 = syworld.getBlockAt(x + 1, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
					String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerHANGAR1Signs.containsKey(playerName)) {
							NavyCraft.playerHANGAR1Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerHANGAR1Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerHANGAR1Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}

	public static Block findHANGAR1Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=553; x>=-137; x-=23 )
		// for( int x=-31; x>=-1067; x-=23 )
		int startX = 553;
		int endX = -137;
		int widthX = 23;
		int startZ = -766;
		int endZ = -1191;
		int widthZ = 25;
		for (int x = startX; x >= endX; x -= widthX) {

			// for( int z=-766; z>=-1191; z-=25 )
			// for( int z=-278; z>=-828; z-=25 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 65, z);
					syworld.getBlockAt(x + 1, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}

	public static void loadHANGAR2Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=553; x>=-137; x-=23 )
		// for( int x=-31; x>=-1067; x-=23 )
		int startX = -99;
		int endX = -1177;
		int widthX = 49;
		int startZ = 67;
		int endZ = -117;
		int widthZ = 46;
		for (int x = startX; x >= endX; x -= widthX) {

			// for( int z=-766; z>=-1191; z-=25 )
			// for( int z=-278; z>=-828; z-=25 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 65, z);
					Block selectSignBlock2 = syworld.getBlockAt(x + 1, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
					String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerHANGAR2Signs.containsKey(playerName)) {
							NavyCraft.playerHANGAR2Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerHANGAR2Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerHANGAR2Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}

	public static Block findHANGAR2Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=553; x>=-137; x-=23 )
		// for( int x=-31; x>=-1067; x-=23 )
		int startX = -99;
		int endX = -1177;
		int widthX = 49;
		int startZ = 67;
		int endZ = -117;
		int widthZ = 46;
		for (int x = startX; x >= endX; x -= widthX) {

			// for( int z=-766; z>=-1191; z-=25 )
			// for( int z=-278; z>=-828; z-=25 )
			for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 65, z);
					syworld.getBlockAt(x + 1, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}

	public static void loadTANK1Signs() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=602; x<=908; x+=18 )
		// for( int x=22; x<=832; x+=18 )
		int startX = 602;
		int endX = 926;
		int widthX = 18;
		int startZ = -953;
		int endZ = -1385;
		int widthZ = 24;
		for (int x = startX; x <= endX; x += widthX) {
		for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 65, z);
					Block selectSignBlock2 = syworld.getBlockAt(x + 1, 64, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					Sign selectSign2 = (Sign) selectSignBlock2.getState();
					String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
					String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

					if (signLine0.equalsIgnoreCase("*select*")) {
						String playerName = selectSign.getLine(1);
						String playerName2 = selectSign.getLine(2);

						if ((playerName2 != null) && !playerName2.isEmpty()) {
							playerName = playerName + playerName2;
						}

						if (playerName == null) {
							continue;
						}

						int idNum = -1;
						try {
							idNum = Integer.parseInt(sign2Line2);
						} catch (NumberFormatException nfe) {
							continue;
						}
						if (idNum == -1) {
							continue;
						}

						if (!NavyCraft.playerTANK1Signs.containsKey(playerName)) {
							NavyCraft.playerTANK1Signs.put(playerName, new ArrayList<Sign>());
							NavyCraft.playerTANK1Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						} else {
							NavyCraft.playerTANK1Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
						}

					}
				}
			}
		}
	}


	public static Block findTANK1Open() {
		World syworld = plugin.getServer().getWorld("shipyard");
		// for( int x=602; x<=908; x+=18 )
		// for( int x=22; x<=832; x+=18 )
		int startX = 602;
		int endX = 926;
		int widthX = 18;
		int startZ = -953;
		int endZ = -1385;
		int widthZ = 24;
		for (int x = startX; x <= endX; x += widthX) {
		for (int z = startZ; z >= endZ; z -= widthZ) {
				if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
					Block selectSignBlock = syworld.getBlockAt(x, 65, z);
					Sign selectSign = (Sign) selectSignBlock.getState();
					String signLine0 = selectSign.getLine(0);

					if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
				}
			}
		}
		return null;
	}
		public static void loadTANK2Signs() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=602; x<=908; x+=18 )
			// for( int x=22; x<=832; x+=18 )
			int startX = 960;
			int endX = 1436;
			int widthX = 34;
			int startZ = -920;
			int endZ = -1361;
			int widthZ = 44;
			for (int x = startX; x <= endX; x += widthX) {
			for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 65, z);
						Block selectSignBlock2 = syworld.getBlockAt(x + 1, 64, z);
						Sign selectSign = (Sign) selectSignBlock.getState();
						Sign selectSign2 = (Sign) selectSignBlock2.getState();
						String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
						String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

						if (signLine0.equalsIgnoreCase("*select*")) {
							String playerName = selectSign.getLine(1);
							String playerName2 = selectSign.getLine(2);

							if ((playerName2 != null) && !playerName2.isEmpty()) {
								playerName = playerName + playerName2;
							}

							if (playerName == null) {
								continue;
							}

							int idNum = -1;
							try {
								idNum = Integer.parseInt(sign2Line2);
							} catch (NumberFormatException nfe) {
								continue;
							}
							if (idNum == -1) {
								continue;
							}

							if (!NavyCraft.playerTANK2Signs.containsKey(playerName)) {
								NavyCraft.playerTANK2Signs.put(playerName, new ArrayList<Sign>());
								NavyCraft.playerTANK2Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							} else {
								NavyCraft.playerTANK2Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							}

						}
					}
				}
			}
		}

		public static Block findTANK2Open() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=602; x<=908; x+=18 )
			// for( int x=22; x<=832; x+=18 )
			int startX = 960;
			int endX = 1436;
			int widthX = 34;
			int startZ = -920;
			int endZ = -1361;
			int widthZ = 44;
			for (int x = startX; x <= endX; x += widthX) {
			for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 65, z).getTypeId() == 63) && (syworld.getBlockAt(x + 1, 64, z).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 65, z);
						Sign selectSign = (Sign) selectSignBlock.getState();
						String signLine0 = selectSign.getLine(0);

						if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
					}
				}
			}
		return null;
	}
		
		public static void loadMAP1Signs() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=601; x<=1567; x+=14 )
			// for( int x=16; x<=1286; x+=14 )
			int startX = 601;
			int endX = 1567;
			int widthX = 14;
			int startZ = -408;
			int endZ = -852;
			int widthZ = 37;
			for (int x = startX; x <= endX; x += widthX) {

				// for( int z=-408; z>=-852; z-=37 )
				// for( int z=-18; z>=-462; z-=37 )
				for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
						Sign selectSign = (Sign) selectSignBlock.getState();
						Sign selectSign2 = (Sign) selectSignBlock2.getState();
						String signLine0 = selectSign.getLine(0);
						String sign2Line2 = selectSign2.getLine(2);

						if (signLine0.equalsIgnoreCase("*select*")) {
							String playerName = selectSign.getLine(1);
							String playerName2 = selectSign.getLine(2);

							if ((playerName2 != null) && !playerName2.isEmpty()) {
								playerName = playerName + playerName2;
							}

							if (playerName == null) {
								continue;
							}

							int idNum = -1;
							try {
								idNum = Integer.parseInt(sign2Line2);
							} catch (NumberFormatException nfe) {
								continue;
							}
							if (idNum == -1) {
								continue;
							}

							if (!NavyCraft.playerMAP1Signs.containsKey(playerName)) {
								NavyCraft.playerMAP1Signs.put(playerName, new ArrayList<Sign>());
								NavyCraft.playerMAP1Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							} else {
								NavyCraft.playerMAP1Signs.get(playerName).add(selectSign);
							NavyCraft.playerSignIndex.put(selectSign, idNum);
							}

						}
					}
				}
			}
		}

		public static Block findMAP1Open() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=601; x<=1567; x+=14 )
			// for( int x=16; x<=1286; x+=14 )
			int startX = 601;
			int endX = 1567;
			int widthX = 14;
			int startZ = -408;
			int endZ = -852;
			int widthZ = 37;
			for (int x = startX; x <= endX; x += widthX) {

				// for( int z=-408; z>=-852; z-=37 )
				// for( int z=-18; z>=-462; z-=37 )
				for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Sign selectSign = (Sign) selectSignBlock.getState();
						String signLine0 = selectSign.getLine(0);

						if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
					}
				}
			}
			return null;
		}

		public static void loadMAP2Signs() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=601; x<=1421; x+=10 )
			// for( int x=16; x<=1296; x+=10 )
			int startX = 601;
			int endX = 1421;
			int widthX = 10;
			int startZ = -356;
			int endZ = -148;
			int widthZ = 52;
			for (int x = startX; x <= endX; x += widthX) {

				// for( int z=-356; z<=-148; z+=52 )
				// for( int z=33; z<=241; z+=52 )
				for (int z = startZ; z <= endZ; z += widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
						Sign selectSign = (Sign) selectSignBlock.getState();
						Sign selectSign2 = (Sign) selectSignBlock2.getState();
						String signLine0 = selectSign.getLine(0);
						String sign2Line2 = selectSign2.getLine(2);

						if (signLine0.equalsIgnoreCase("*select*")) {
							String playerName = selectSign.getLine(1);
							String playerName2 = selectSign.getLine(2);

							if ((playerName2 != null) && !playerName2.isEmpty()) {
								playerName = playerName + playerName2;
							}

							if (playerName == null) {
								continue;
							}

							int idNum = -1;
							try {
								idNum = Integer.parseInt(sign2Line2);
							} catch (NumberFormatException nfe) {
								continue;
							}
							if (idNum == -1) {
								continue;
							}

							if (!NavyCraft.playerMAP2Signs.containsKey(playerName)) {
								NavyCraft.playerMAP2Signs.put(playerName, new ArrayList<Sign>());
								NavyCraft.playerMAP2Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							} else {
								NavyCraft.playerMAP2Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							}

						}
					}
				}
			}
		}

		public static Block findMAP2Open() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=601; x<=1421; x+=10 )
			// for( int x=16; x<=1296; x+=10 )
			int startX = 601;
			int endX = 1421;
			int widthX = 10;
			int startZ = -356;
			int endZ = -148;
			int widthZ = 52;
			for (int x = startX; x <= endX; x += widthX) {

				// for( int z=-356; z<=-148; z+=52 )
				// for( int z=33; z<=241; z+=52 )
				for (int z = startZ; z <= endZ; z += widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Sign selectSign = (Sign) selectSignBlock.getState();
						String signLine0 = selectSign.getLine(0);

						if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
					}
				}
			}
			return null;
		}

		public static void loadMAP3Signs() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=549; x>=21; x-=12 )
			// for( int x=-35; x>=-1091; x-=12 )
			int startX = 549;
			int endX = 21;
			int widthX = 12;
			int startZ = -329;
			int endZ = -92;
			int widthZ = 79;
			for (int x = startX; x >= endX; x -= widthX) {

				// for( int z=-329; z<=-92; z+=79 )
				// for( int z=60; z<=297; z+=79 )
				for (int z = startZ; z <= endZ; z += widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
						Sign selectSign = (Sign) selectSignBlock.getState();
						Sign selectSign2 = (Sign) selectSignBlock2.getState();
						String signLine0 = selectSign.getLine(0);
						String sign2Line2 = selectSign2.getLine(2);

						if (signLine0.equalsIgnoreCase("*select*")) {
							String playerName = selectSign.getLine(1);
							String playerName2 = selectSign.getLine(2);

							if ((playerName2 != null) && !playerName2.isEmpty()) {
								playerName = playerName + playerName2;
							}

							if (playerName == null) {
								continue;
							}

							int idNum = -1;
							try {
								idNum = Integer.parseInt(sign2Line2);
							} catch (NumberFormatException nfe) {
								continue;
							}
							if (idNum == -1) {
								continue;
							}

							if (!NavyCraft.playerMAP3Signs.containsKey(playerName)) {
								NavyCraft.playerMAP3Signs.put(playerName, new ArrayList<Sign>());
								NavyCraft.playerMAP3Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							} else {
								NavyCraft.playerMAP3Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							}

						}
					}
				}
			}
		}

		public static Block findMAP3Open() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=549; x>=21; x-=12 )
			// for( int x=-35; x>=-1091; x-=12 )
			int startX = 549;
			int endX = 21;
			int widthX = 12;
			int startZ = -329;
			int endZ = -92;
			int widthZ = 79;
			for (int x = startX; x >= endX; x -= widthX) {
				// for( int z=-329; z<=-92; z+=79 )
				// for( int z=60; z<=297; z+=79 )
				for (int z = startZ; z <= endZ; z += widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Sign selectSign = (Sign) selectSignBlock.getState();
						String signLine0 = selectSign.getLine(0);

						if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
					}
				}
			}
			return null;
		}

		public static void loadMAP4Signs() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=543; x>=21; x-=18 )
			// for( int x=-41; x>=-1085; x-=18 )
			int startX = 543;
			int endX = 21;
			int widthX = 18;
			int startZ = -408;
			int endZ = -600;
			int widthZ = 64;
			for (int x = startX; x >= endX; x -= widthX) {

				// for( int z=-408; z>=-600; z-=64 )
				// for( int z=-18; z>=-210; z-=64 )
				for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
						Sign selectSign = (Sign) selectSignBlock.getState();
						Sign selectSign2 = (Sign) selectSignBlock2.getState();
						String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
						String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

						if (signLine0.equalsIgnoreCase("*select*")) {
							String playerName = selectSign.getLine(1);
							String playerName2 = selectSign.getLine(2);

							if ((playerName2 != null) && !playerName2.isEmpty()) {
								playerName = playerName + playerName2;
							}

							if (playerName == null) {
								continue;
							}

							int idNum = -1;
							try {
								idNum = Integer.parseInt(sign2Line2);
							} catch (NumberFormatException nfe) {
								continue;
							}
							if (idNum == -1) {
								continue;
							}

							if (!NavyCraft.playerMAP4Signs.containsKey(playerName)) {
								NavyCraft.playerMAP4Signs.put(playerName, new ArrayList<Sign>());
								NavyCraft.playerMAP4Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							} else {
								NavyCraft.playerMAP4Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							}

						}
					}
				}
			}
		}

		public static Block findMAP4Open() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=543; x>=21; x-=18 )
			// for( int x=-41; x>=-1085; x-=18 )
			int startX = 543;
			int endX = 21;
			int widthX = 18;
			int startZ = -408;
			int endZ = -600;
			int widthZ = 64;
			for (int x = startX; x >= endX; x -= widthX) {

				// for( int z=-408; z>=-600; z-=64 )
				// for( int z=-18; z>=-210; z-=64 )
				for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Sign selectSign = (Sign) selectSignBlock.getState();
						String signLine0 = selectSign.getLine(0);

						if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
					}
				}
			}
			return null;
		}

		public static void loadMAP5Signs() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=1404; x>=656; x-=22 )
			// for( int x=1270; x>=16; x-=22 )
			int startX = 656;
			int endX = 1426;
			int widthX = 18;
			int startZ = 142;
			int endZ = 37;
			int widthZ = 105;
			for (int x = startX; x <= endX; x += widthX) {

				// for( int z=37; z<=142; z+=105 )
				// for( int z=349; z<=454; z+=105 )
				for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Block selectSignBlock2 = syworld.getBlockAt(x, 63, z + 1);
						Sign selectSign = (Sign) selectSignBlock.getState();
						Sign selectSign2 = (Sign) selectSignBlock2.getState();
						String signLine0 = selectSign.getLine(0).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");
						String sign2Line2 = selectSign2.getLine(2).trim().toLowerCase().replaceAll(ChatColor.BLUE.toString(), "");

						if (signLine0.equalsIgnoreCase("*select*")) {
							String playerName = selectSign.getLine(1);
							String playerName2 = selectSign.getLine(2);

							if ((playerName2 != null) && !playerName2.isEmpty()) {
								playerName = playerName + playerName2;
							}

							if (playerName == null) {
								continue;
							}

							int idNum = -1;
							try {
								idNum = Integer.parseInt(sign2Line2);
							} catch (NumberFormatException nfe) {
								continue;
							}
							if (idNum == -1) {
								continue;
							}

							if (!NavyCraft.playerMAP5Signs.containsKey(playerName)) {
								NavyCraft.playerMAP5Signs.put(playerName, new ArrayList<Sign>());
								NavyCraft.playerMAP5Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							} else {
								NavyCraft.playerMAP5Signs.get(playerName).add(selectSign);
								NavyCraft.playerSignIndex.put(selectSign, idNum);
							}

						}
					}
				}
			}
		}

		public static Block findMAP5Open() {
			World syworld = plugin.getServer().getWorld("shipyard");
			// for( int x=1404; x>=656; x-=22 )
			// for( int x=1270; x>=16; x-=22 )
			int startX = 656;
			int endX = 1426;
			int widthX = 18;
			int startZ = 142;
			int endZ = 37;
			int widthZ = 105;
			for (int x = startX; x <= endX; x += widthX) {
				// for( int z=37; z<=142; z+=105 )
				// for( int z=349; z<=454; z+=105 )
				for (int z = startZ; z >= endZ; z -= widthZ) {
					if ((syworld.getBlockAt(x, 64, z).getTypeId() == 63) && (syworld.getBlockAt(x, 63, z + 1).getTypeId() == 68)) {
						Block selectSignBlock = syworld.getBlockAt(x, 64, z);
						Sign selectSign = (Sign) selectSignBlock.getState();
						String signLine0 = selectSign.getLine(0);

						if (signLine0.equalsIgnoreCase("*claim*")) { return selectSignBlock; }
					}
				}
			}
			return null;
		}
	
}
