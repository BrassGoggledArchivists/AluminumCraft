package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.forge.ITextureProvider;

public class ALItemThermiteGrenade extends Item implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }

    public ALItemThermiteGrenade(int i)
    {
        super(i);
        maxStackSize = 64;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        if(!entityplayer.capabilities.depleteBuckets)
        {
            itemstack.stackSize--;
        }
        world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if(!world.isRemote)
        {
            world.spawnEntityInWorld(new ALEntityThermiteGrenade(world, entityplayer));
        }
        return itemstack;
    }
}
