package aluminum.mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

import aluminum.mod.common.AluminumMod;

public class ItemCanFood extends ItemFood 
{
	public ItemCanFood(int i, int j)
	{
		super(i, j, false);
		setMaxStackSize(1);
		this.setContainerItem(AluminumMod.aluminumCan);
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Items/items.png";
	}

	public ItemStack onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		super.onFoodEaten(itemstack, world, entityplayer);
		return new ItemStack(AluminumMod.aluminumCan);
	}
}

