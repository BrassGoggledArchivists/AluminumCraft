package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.forge.ITextureProvider;

public class ALBlockRGlass extends BlockBreakable implements ITextureProvider

{
    public String getTextureFile()
    {
        return "/Aluminium Mod/Blocks/terrain.png";
    }

    public ALBlockRGlass(int i, int j, Material material, boolean flag)
    {
        super(i, j, material, flag);
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public int getRenderBlockPass()
    {
        return 0;
    }  
    
}