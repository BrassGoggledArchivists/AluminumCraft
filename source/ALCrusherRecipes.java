// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package net.minecraft.src:
//            Block, ItemStack, Item, mod_Uranium

public class ALCrusherRecipes
{

    public static final ALCrusherRecipes smelting()
    {
        return smeltingBase;
    }

    public ALCrusherRecipes()
    {
        smeltingList = new HashMap();
        addCrushing(Item.ingotGold.shiftedIndex, new ItemStack(mod_Aluminium.goldPowder));
        addCrushing(mod_Aluminium.aluminiumIngot.shiftedIndex, new ItemStack(mod_Aluminium.aluminiumPowder));
        addCrushing(Item.diamond.shiftedIndex, new ItemStack(mod_Aluminium.diamondDust));
        addCrushing(Item.ingotIron.shiftedIndex, new ItemStack(mod_Aluminium.ironOxide));
    }

    public void addCrushing(int i, ItemStack itemstack)
    {
        smeltingList.put(Integer.valueOf(i), itemstack);
    }

    public ItemStack getSmeltingResult(int i)
    {
        return (ItemStack)smeltingList.get(Integer.valueOf(i));
    }

    public Map getSmeltingList()
    {
        return smeltingList;
    }

    private static final ALCrusherRecipes smeltingBase = new ALCrusherRecipes();
    private Map smeltingList;

}
