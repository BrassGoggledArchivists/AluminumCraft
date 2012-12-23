package aluminum.mod.items;

import aluminum.mod.common.AluminumMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;
import net.minecraft.src.*;

public class ItemDrill extends ItemTool
{
	public ItemDrill(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, 2, enumtoolmaterial, blocksEffectiveAgainst);
        maxStackSize = 1;
        this.setCreativeTab(AluminumMod.tabAluminum);
    }
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }      

    public boolean canHarvestBlock(Block block)
    {
        if(block == Block.obsidian)
        {
            return toolMaterial.getHarvestLevel() == 3;
        }
        if(block == Block.snow)
        {
            return true;
        }
        if(block == Block.blockSnow)
        {
            return true;
        }
        //if(block == mod_Aluminium.ObsidianCrystal)
        //{
        //    return toolMaterial.getHarvestLevel() == 3;
        //}
        if(block == Block.blockDiamond || block == Block.oreDiamond)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockGold || block == Block.oreGold)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockSteel || block == Block.oreIron)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.blockLapis || block == Block.oreLapis)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == AluminumMod.aluminumOre)
        {
            return toolMaterial.getHarvestLevel() == 2;
        }
        if(block.blockMaterial == Material.rock)
        {
            return true;
        }
        return block.blockMaterial == Material.iron;
    }

    private static Block blocksEffectiveAgainst[];

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.cobblestone, Block.stairCompactCobblestone, Block.stairCompactPlanks, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, 
            Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, AluminumMod.aluminumOre, AluminumMod.aluminumBlock, Block.obsidian, Block.oreRedstone,
            Block.oreRedstoneGlowing, Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.leaves, Block.lever, Block.pressurePlateStone, Block.pressurePlatePlanks,
            Block.pistonBase, Block.pistonExtension, Block.pistonMoving, Block.pistonStickyBase, AluminumMod.crusherActive, AluminumMod.crusherIdle, AluminumMod.glass, Block.cactus, Block.mycelium, Block.rail, Block.railDetector,
            Block.railPowered, Block.dispenser, Block.doorSteel, AluminumMod.trapdoor
        });
    }    
}