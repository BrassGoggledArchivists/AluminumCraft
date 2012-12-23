package aluminum.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.world.World;

import java.util.Random;

import aluminum.mod.common.AluminumMod;
import aluminum.mod.entities.EntityC4Primed;

public class BlockC4 extends Block
{
	public BlockC4(int i, int j)
	{
		super(i, Material.tnt);
		blockIndexInTexture = j;
		this.setHardness(0.0F);
		this.setStepSound(Block.soundGrassFootstep);
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Blocks/terrain.png";
	}

	public int getBlockTextureFromSide(int i) 
	{
		if(i == 1) 
		{
			return blockIndexInTexture + 1;
		}
		if(i == 0)
		{
			return blockIndexInTexture + 2;
		}
		if(i == 3)
		{
			return blockIndexInTexture;
		} else
		{
			return blockIndexInTexture;
		}
	}

	public void onBlockAdded(World world, int i, int j, int k)
	{
		super.onBlockAdded(world, i, j, k);
		if(world.isBlockIndirectlyGettingPowered(i, j, k))
		{
			onBlockDestroyedByPlayer(world, i, j, k, 1);
			world.setBlockWithNotify(i, j, k, 0);
		}
	}

	public void onNeighborBlockChange(World world, int i, int j, int k, int l)
	{
		if(l > 0 && Block.blocksList[l].canProvidePower() && world.isBlockIndirectlyGettingPowered(i, j, k))
		{
			onBlockDestroyedByPlayer(world, i, j, k, 1);
			world.setBlockWithNotify(i, j, k, 0);
		}
	}

	public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
	{
		EntityC4Primed entityC4primed = new EntityC4Primed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
		entityC4primed.fuse = world.rand.nextInt(entityC4primed.fuse / 4) + entityC4primed.fuse / 8;
		world.spawnEntityInWorld(entityC4primed);
	}

	public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
	{
		if(world.isRemote)
		{
			return;
		}
		if((l & 1) == 0)
		{
			dropBlockAsItem_do(world, i, j, k, new ItemStack(AluminumMod.C4.blockID, 1, 0));
		} else
		{
			EntityC4Primed entityC4primed = new EntityC4Primed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
			world.spawnEntityInWorld(entityC4primed);
			world.playSoundAtEntity(entityC4primed, "random.fuse", 1.0F, 1.0F);
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		return super.onBlockActivated(world, i, j, k, player, par6, par7, par8, par9);
	}

	public int idDropped(int i, Random random)
	{
		return AluminumMod.C4.blockID;
	}
	
	public int quantityDropped(Random random)
	{
		return 0;
	} 
}