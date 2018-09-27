package com.maximuspayne.navycraft.craft;

public class Attribute {
	
	public String name;
	public String svalue;
	public short[] shvalue;
	public int ivalue;
	public boolean bvalue;
	
	public Attribute(String a, String v)
	{
		name = a;
		svalue = v;
	}
	public Attribute(String a, short[] v)
	{
		name = a;
		shvalue = v;
	}
	public Attribute(String a, int v)
	{
		name = a;
		ivalue = v;
	}
	public Attribute(String a, boolean v)
	{
		name = a;
		bvalue = v;
	}
	
}
