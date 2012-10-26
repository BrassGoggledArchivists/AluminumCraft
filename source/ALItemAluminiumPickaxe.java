package net.minecraft.src;

import net.minecraft.src.forge.ITextureProvider;

public class ALItemAluminiumPickaxe extends ItemPickaxe implements ITextureProvider
{
    public ALItemAluminiumPickaxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}