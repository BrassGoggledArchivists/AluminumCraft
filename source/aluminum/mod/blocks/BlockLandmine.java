package aluminum.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

import aluminum.mod.common.AluminumMod;
import aluminum.mod.entities.EntityLandminePrimed;

public class BlockLandmine extends Block 
{
	public BlockLandmine(int i, int j)
	{
		super(i, j, Material.tnt);
		setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.3F, 0.9F);
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
			return blockIndexInTexture;
		}
		if(i == 0)
		{
			return blockIndexInTexture + 1;
		} else
		{
			return blockIndexInTexture + 2;
		}
	}

	public boolean canPlaceBlockAt(World world, int i, int j, int k)
	{
		if(world.getBlockId(i, j - 1, k) == blockID)
		{
			return true;
		}
		if(!world.getBlockMaterial(i, j - 1, k).isSolid())
		{
			return false;
		} else
		{
			return super.canPlaceBlockAt(world, i, j, k);
		}
	}

	public boolean isOpaqueCube()
	{
		return false;
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

	public int quantityDropped(Random random)
	{
		return 0;
	}

	public void onBlockDestroyedByExplosion(World world, int i, int j, int k)
	{
		EntityLandminePrimed entitysmallbombprimed = new EntityLandminePrimed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
		entitysmallbombprimed.fuse = world.rand.nextInt(entitysmallbombprimed.fuse / 10) + entitysmallbombprimed.fuse / 10;
		world.spawnEntityInWorld(entitysmallbombprimed);
	}

	public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
	{
		if(world.isRemote)
		{
			return;
		}
		if((l & 1) == 0)
		{
			dropBlockAsItem_do(world, i, j, k, new ItemStack(AluminumMod.landmine.blockID, 1, 0));
		} else
		{
			EntityLandminePrimed entitysmallbombprimed = new EntityLandminePrimed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
			world.spawnEntityInWorld(entitysmallbombprimed);
			world.playSoundAtEntity(entitysmallbombprimed, "random.fuse", 1.0F, 1.0F);
		}
	}

	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
		if(world.isRemote)
		{
			return;
		} else
		{
			world.createExplosion(null, i, j, k, 0.2F, true);
			return;
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		return super.onBlockActivated(world, i, j, k, player, par6, par7, par8, par9);
	}
}