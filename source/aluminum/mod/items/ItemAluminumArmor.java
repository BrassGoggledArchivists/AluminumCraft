package aluminum.mod.items;

import aluminum.mod.common.AluminumMod;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemAluminumArmor extends ItemArmor implements IArmorTextureProvider
{
	public ItemAluminumArmor(int i, EnumArmorMaterial armorMaterial, int j, int k)
	{
		super(i, armorMaterial, j, k);
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Items/items.png";
	}

	public String getArmorTextureFile(ItemStack itemstack)
	{
		if(itemstack.itemID == AluminumMod.aluminumHelmet.shiftedIndex || itemstack.itemID == AluminumMod.aluminumChest.shiftedIndex || itemstack.itemID == AluminumMod.aluminumBoots.shiftedIndex)
		{
			return "/Aluminium Mod/Armor/aluminium_1.png";
		}
		if(itemstack.itemID == AluminumMod.aluminumLegs.shiftedIndex)
		{
			return "/Aluminium Mod/Armor/aluminium_2.png";
		}
		return "/Aluminium Mod/Armor/aluminium_1.png";
	}
}
