package aluminum.mod.extra;

import aluminum.mod.common.AluminumMod;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler 
{
	@Override
	public int getBurnTime(ItemStack itemStack) 
	{
		int item = itemStack.itemID;
		
		if(item == AluminumMod.thermite.shiftedIndex)
		{
			return 6400;
		} else if(item == AluminumMod.aluminumBucketLava.shiftedIndex)
		{
			return 20000;
		} else 
		{
			return 0;
		}
	}
}
