package net.minecraft.src;

import java.util.Random; 
import net.minecraft.src.forge.ITextureProvider;

public class ALBlockAluminium extends Block implements ITextureProvider

{
    public String getTextureFile()
    {
        return "/Aluminium Mod/Blocks/terrain.png";
    }

    public ALBlockAluminium(int i, int j)
    {
        super(i, j, Material.ground); 
    }
    public int idDropped(int i, Random random)
    {
       return mod_Aluminium.Aluminium.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 1;
    } 
    
}