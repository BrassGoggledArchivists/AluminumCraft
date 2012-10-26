package net.minecraft.src;

import net.minecraft.src.forge.*;

public class ALItemAluminiumArmor extends ItemArmor implements ITextureProvider, IArmorTextureProvider
{

    public ALItemAluminiumArmor(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
    
    public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == mod_Aluminium.aluminiumHelmet.shiftedIndex || itemstack.itemID == mod_Aluminium.aluminiumChest.shiftedIndex || itemstack.itemID == mod_Aluminium.aluminiumBoots.shiftedIndex)
        {
                return "/Aluminium Mod/Armor/aluminium_1.png";
        }
        if(itemstack.itemID == mod_Aluminium.aluminiumLegs.shiftedIndex)
        {
                return "/Aluminium Mod/Armor/aluminium_2.png";
        }
        return "/Aluminium Mod/Armor/aluminium_1.png";
    }

}