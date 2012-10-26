package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.forge.ITextureProvider;

public class ALItemCanFood extends ItemFood implements ITextureProvider
{
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }

    public ALItemCanFood(int i, int j)
    {
        super(i, j, false);
        setMaxStackSize(1);
    }

    public ItemStack onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        super.onFoodEaten(itemstack, world, entityplayer);
        return new ItemStack(mod_Aluminium.aluminiumCan);
    }
}
