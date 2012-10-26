package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.forge.ITextureProvider;

public class ALBlockAluminiumOre extends Block implements ITextureProvider

{
    public String getTextureFile()
    {
        return "/Aluminium Mod/Blocks/terrain.png";
    }
    
    public ALBlockAluminiumOre(int i, int j)
    {
        super(i, Material.ground);  
    }

    public int idDropped(int i, Random random)
    {
       return mod_Aluminium.AluminiumOre.blockID;
    }

}
