package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ALItemAluminiumSword extends ItemSword implements ITextureProvider
{
    public ALItemAluminiumSword(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}
