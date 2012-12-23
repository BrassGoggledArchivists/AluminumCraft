package aluminum.mod.blocks;

import java.util.Random; 

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import aluminum.mod.common.*;

public class BlockAluminum extends Block
{
	public BlockAluminum(int i, int j)
	{
		super(i, j, Material.iron); 
		this.setHardness(2.734F);
		this.setResistance(5.0F);
		this.setCreativeTab(AluminumMod.tabAluminum);
	}
	
	public String getTextureFile()
	{
		return "/Aluminium Mod/Blocks/terrain.png";
	}

	public int idDropped(int i, Random random)
	{
		return AluminumMod.aluminumBlock.blockID;
	}
	
	public int quantityDropped(Random random)
	{
		return 1;
	} 
}
