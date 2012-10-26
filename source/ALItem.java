package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ALItem extends Item implements ITextureProvider
{
    public ALItem(int i)
    {
        super(i);
    }  

    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
    
}