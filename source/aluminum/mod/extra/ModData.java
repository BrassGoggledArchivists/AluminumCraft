package aluminum.mod.extra;

import aluminum.mod.common.AluminumMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ModData 
{
	public static void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(AluminumMod.drillTip, 1), new Object[] 
				{
			"XXX", "XX ", "X X", ('X'), Item.diamond
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumHelmet, 1), new Object[] 
				{
			"XXX", "X X", ('X'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumChest, 1), new Object[] 
				{
			"X X", "XXX", "XXX", ('X'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumLegs, 1), new Object[] 
				{
			"XXX", "X X", "X X", ('X'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumBoots, 1), new Object[] 
				{
			"X X", "X X", ('X'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.drillInactive, 1), new Object[] 
				{
			"DIR", " IR", "  I", ('I'), AluminumMod.aluminumIngot, ('D'), AluminumMod.drillTip, ('R'), Item.redstone
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.glass, 4), new Object[] 
				{
			"IGI", "GGG", "IGI", ('I'), AluminumMod.aluminumIngot, ('G'), Block.glass
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.landmine, 1), new Object[] 
				{
			" D ", "III", "RRR", ('I'), AluminumMod.aluminumIngot, ('D'), Block.pressurePlateStone, ('R'), AluminumMod.aluminumPowder
				}); 
		GameRegistry.addRecipe(new ItemStack(AluminumMod.C4, 1), new Object[] 
				{
			"IPI", "PTP", "IPI", ('I'), AluminumMod.aluminumIngot, ('T'), Block.tnt, ('P'), AluminumMod.aluminumPowder
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumPick, 1), new Object[] 
				{
			"XXX", " | ", " | ", ('X'), AluminumMod.aluminumIngot, ('|'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumBlock, 1), new Object[] 
				{
			"XXX", "XXX", "XXX", ('X'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumIngot, 9), new Object[] 
				{
			"X", ('X'), AluminumMod.aluminumBlock
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumShovel, 1), new Object[] 
				{
			" X ", " | ", " | ", ('X'), AluminumMod.aluminumIngot, ('|'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumAxe, 1), new Object[] 
				{
			"XX ", "X| ", " | ", ('X'), AluminumMod.aluminumIngot, ('|'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumHoe, 1), new Object[] 
				{
			"XX ", " | ", " | ", ('X'), AluminumMod.aluminumIngot, ('|'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumSword, 1), new Object[]
				{
			" X ", " X ", " | ", ('X'), AluminumMod.aluminumIngot, ('|'), Item.stick
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumSheet, 6), new Object[] 
				{
			"###", ('#'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumCan, 1), new Object[] 
				{
			"X X", "X X", "XXX", ('X'), AluminumMod.aluminumSheet
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumCanPork, 1), new Object[] 
				{
			"X", "#", ('#'), AluminumMod.aluminumCan, ('X'), Item.porkCooked
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumCanFish, 1), new Object[] 
				{
			"X", "#", ('#'), AluminumMod.aluminumCan, ('X'), Item.fishCooked
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumCanChicken, 1), new Object[] 
				{
			"X", "#", ('#'), AluminumMod.aluminumCan, ('X'), Item.chickenCooked
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumCanBeef, 1), new Object[] 
				{
			"X", "#", ('#'), AluminumMod.aluminumCan, ('X'), Item.beefCooked
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.battery1, 1), new Object[] 
				{
			"X$X", "X@X", "X$X", ('X'), AluminumMod.aluminumSheet, ('@'), Item.redstone, ('$'), Item.ingotIron,
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.battery2, 1), new Object[] 
				{
			"X$X", "X@X", "X$X", ('X'), AluminumMod.aluminumSheet, ('@'), Item.redstone, ('$'), AluminumMod.aluminumIngot,
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.battery3, 1), new Object[] 
				{
			"X$X", "X@X", "X$X", ('X'), AluminumMod.aluminumSheet, ('@'), AluminumMod.goldPowder, ('$'), Item.ingotGold,
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumBucket, 1), new Object[] 
				{
			"I I", " I ", ('I'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(Item.shears, 1), new Object[]
				{
			"I ", " I", ('I'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(Item.shears, 1), new Object[] 
				{
			" I", "I ", ('I'), AluminumMod.aluminumIngot
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.crusherIdle, 1), new Object[] 
				{
			"IXI", "IPI", "III", ('I'), Block.cobblestone, ('X'), Item.redstone, ('P'), Block.pistonBase
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.aluminumGrenade, 1), new Object[] 
				{
			" X ", "IAI", "IAI", ('I'), AluminumMod.aluminumSheet, ('X'), AluminumMod.fuse, ('A'), AluminumMod.aluminumPowder
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.thermiteGrenade, 1), new Object[] 
				{
			" X ", "IAI", "IAI", ('I'), AluminumMod.aluminumSheet, ('X'), AluminumMod.fuse, ('A'), AluminumMod.thermite
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.trapdoor, 2), new Object[]
				{
			"III", "III", ('I'), AluminumMod.aluminumIngot
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.drill1, 1), new Object[] 
				{
			AluminumMod.battery1, new ItemStack(AluminumMod.drill1, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.drill2, 1), new Object[] 
				{
			AluminumMod.battery2, new ItemStack(AluminumMod.drill2, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.drill3, 1), new Object[] 
				{
			AluminumMod.battery3, new ItemStack(AluminumMod.drill3, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.drill1, 1), new Object[] 
				{
			AluminumMod.battery1, AluminumMod.drillInactive
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.drill2, 1), new Object[] 
				{
			AluminumMod.battery2, AluminumMod.drillInactive
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.drill3, 1), new Object[] 
				{
			AluminumMod.battery3, AluminumMod.drillInactive
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.fuse, 2), new Object[] 
				{
			Item.silk, AluminumMod.thermite
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.thermite, 1), new Object[]
				{
			AluminumMod.aluminumPowder, AluminumMod.ironOxide
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.eHoeInactive, 1), new Object[]
				{
			"DIR", " IR", "  I", ('I'), AluminumMod.aluminumIngot, ('D'), AluminumMod.eHoeTip, ('R'), Item.redstone
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.eHoeTip, 1), new Object[] 
				{
			"  X", "XXX", "X  ", ('X'), Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.eHoe1, 1), new Object[] 
				{
			AluminumMod.battery1, new ItemStack(AluminumMod.eHoe1, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.eHoe2, 1), new Object[]
				{
			AluminumMod.battery2, new ItemStack(AluminumMod.eHoe2, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.eHoe3, 1), new Object[] 
				{
			AluminumMod.battery3, new ItemStack(AluminumMod.eHoe3, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.eHoe1, 1), new Object[] 
				{
			AluminumMod.battery1, AluminumMod.eHoeInactive
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.eHoe2, 1), new Object[]
				{
			AluminumMod.battery2, AluminumMod.eHoeInactive
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.eHoe3, 1), new Object[] 
				{
			AluminumMod.battery3, AluminumMod.eHoeInactive
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.chainsawInactive, 1), new Object[] 
				{
			"D I", " IR", "IR ", ('I'), AluminumMod.aluminumIngot, ('D'), AluminumMod.chainsawTip, ('R'), Item.redstone
				});
		GameRegistry.addRecipe(new ItemStack(AluminumMod.chainsawTip, 1), new Object[] 
				{
			"XX ", "XX ", "  X", ('X'), Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.chainsaw1, 1), new Object[] 
				{
			AluminumMod.battery1, new ItemStack(AluminumMod.chainsaw1, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.chainsaw2, 1), new Object[] 
				{
			AluminumMod.battery2, new ItemStack(AluminumMod.chainsaw2, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.chainsaw3, 1), new Object[]
				{
			AluminumMod.battery3, new ItemStack(AluminumMod.chainsaw3, 1, -1), AluminumMod.aluminumIngot, Item.diamond
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.chainsaw1, 1), new Object[] 
				{
			AluminumMod.battery1, AluminumMod.chainsawInactive
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.chainsaw2, 1), new Object[] 
				{
			AluminumMod.battery2, AluminumMod.chainsawInactive
				});
		GameRegistry.addShapelessRecipe(new ItemStack(AluminumMod.chainsaw3, 1), new Object[] 
				{
			AluminumMod.battery3, AluminumMod.chainsawInactive
				});
	}
}
