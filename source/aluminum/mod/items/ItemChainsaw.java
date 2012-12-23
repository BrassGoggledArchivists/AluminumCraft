package aluminum.mod.items;

import aluminum.mod.common.AluminumMod;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.src.*;

public class ItemChainsaw extends ItemAxe 
{
    public ItemChainsaw(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
        this.setCreativeTab(AluminumMod.tabAluminum);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}

