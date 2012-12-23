package aluminum.mod.items;

import aluminum.mod.common.AluminumMod;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemAluminumAxe extends ItemAxe
{
    public ItemAluminumAxe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
        this.setCreativeTab(AluminumMod.tabAluminum);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
}
