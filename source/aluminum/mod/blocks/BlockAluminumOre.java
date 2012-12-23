package aluminum.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.Random;

import aluminum.mod.common.AluminumMod;

public class BlockAluminumOre extends Block
{
	public BlockAluminumOre(int i, int j)
	{
		super(i, Material.ground);
		this.setHardness(3.5F);
		this.setResistance(2.0F);
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Blocks/terrain.png";
	}

	public int idDropped(int i, Random random)
	{
		return AluminumMod.aluminumOre.blockID;
	}
}

