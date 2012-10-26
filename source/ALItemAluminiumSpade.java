package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ALItemAluminiumSpade extends ItemSpade implements ITextureProvider
{
    public ALItemAluminiumSpade(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}
