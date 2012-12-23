package aluminum.mod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

import aluminum.mod.common.AluminumMod;
import aluminum.mod.entities.EntityAluminumGrenade;

public class ItemAluminumGrenade extends Item
{
	public ItemAluminumGrenade(int i)
	{
		super(i);
		maxStackSize = 64;
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Items/items.png";
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(!entityplayer.capabilities.isCreativeMode)
		{
			itemstack.stackSize--;
		}
		
		world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if(!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityAluminumGrenade(world, entityplayer));
		}
		return itemstack;
	}
}

