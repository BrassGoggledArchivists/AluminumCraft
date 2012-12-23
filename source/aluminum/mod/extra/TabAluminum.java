package aluminum.mod.extra;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import aluminum.mod.common.AluminumMod;

public class TabAluminum extends CreativeTabs 
{
	public TabAluminum(int position, String tabID) 
	{
		super(position, tabID); // The constructor for your tab
	}
	
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex() // The item it displays for your tab
	{
		return AluminumMod.aluminumIngot.shiftedIndex;
	}
	
	public String getTranslatedTabLabel()
	{
		return "Aluminum"; // The name of the tab in-game
	}
}
