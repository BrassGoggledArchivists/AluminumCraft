package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ALItemAluminiumAxe extends ItemAxe implements ITextureProvider
{
    public ALItemAluminiumAxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}
