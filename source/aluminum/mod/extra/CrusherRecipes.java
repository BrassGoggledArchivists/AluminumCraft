package aluminum.mod.extra;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

import aluminum.mod.common.AluminumMod;

public class CrusherRecipes
{
	private static final CrusherRecipes smeltingBase = new CrusherRecipes();
	private Map smeltingList;

	public CrusherRecipes()
	{
		smeltingList = new HashMap();
		addCrushing(Item.ingotGold.shiftedIndex, new ItemStack(AluminumMod.goldPowder));
		addCrushing(AluminumMod.aluminumIngot.shiftedIndex, new ItemStack(AluminumMod.aluminumPowder));
		addCrushing(Item.diamond.shiftedIndex, new ItemStack(AluminumMod.diamondDust));
		addCrushing(Item.ingotIron.shiftedIndex, new ItemStack(AluminumMod.ironOxide));
	}

	public static final CrusherRecipes smelting()
	{
		return smeltingBase;
	}

	public void addCrushing(int i, ItemStack itemstack)
	{
		smeltingList.put(Integer.valueOf(i), itemstack);
	}

	public ItemStack getSmeltingResult(int i)
	{
		return (ItemStack) smeltingList.get(Integer.valueOf(i));
	}

	public Map getSmeltingList()
	{
		return smeltingList;
	}
}