package aluminum.mod.items;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import aluminum.mod.common.AluminumMod;

public class ItemAluminumPickaxe extends ItemPickaxe
{
    public ItemAluminumPickaxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
        this.setCreativeTab(AluminumMod.tabAluminum);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}
