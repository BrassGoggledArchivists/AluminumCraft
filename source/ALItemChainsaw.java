package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ALItemChainsaw extends ItemAxe implements ITextureProvider
{
    public ALItemChainsaw(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}
