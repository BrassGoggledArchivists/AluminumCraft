package aluminum.mod.items;

import aluminum.mod.common.AluminumMod;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.src.*;

public class ItemAluminumHoe extends ItemHoe
{
    public ItemAluminumHoe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
        this.setCreativeTab(AluminumMod.tabAluminum);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}

