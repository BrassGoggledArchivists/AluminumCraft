package aluminum.mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;

import aluminum.mod.common.AluminumMod;

public class BlockRGlass extends BlockGlass
{
	public BlockRGlass(int i, int j, Material material, boolean flag)
	{
		super(i, j, material, flag);
		this.setHardness(5.0F);
		this.setResistance(2000.0F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Blocks/terrain.png";
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
