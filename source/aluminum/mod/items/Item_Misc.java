package aluminum.mod.items;

import aluminum.mod.common.AluminumMod;
import net.minecraft.item.Item;

public class Item_Misc extends Item 
{
	public Item_Misc(int i)
	{
		super(i);
		this.setCreativeTab(AluminumMod.tabAluminum);
	}  

	public String getTextureFile()
	{
		return "/Aluminium Mod/Items/items.png";
	}
}
