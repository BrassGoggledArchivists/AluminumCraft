package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ALItemAluminiumHoe extends ItemHoe implements ITextureProvider
{
    public ALItemAluminiumHoe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}
