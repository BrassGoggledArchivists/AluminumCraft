package aluminum.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

import aluminum.mod.common.AluminumMod;
import aluminum.mod.gui.GuiCrusher;
import aluminum.mod.gui.TileEntityCrusher;

public class BlockCrusher extends BlockContainer
{
	private Random crusherRand;
	private final boolean isActive;
	private static boolean keepCrusherInventory = false;

	public BlockCrusher(int i, int j, boolean flag)
	{
		super(i, Material.rock);
		this.setTickRandomly(true);
		this.isActive = flag;
		this.crusherRand = new Random();
		this.blockIndexInTexture = j;
		this.setHardness(2.5F);
		this.setResistance(2.0F);
		this.setStepSound(Block.soundStoneFootstep);
		this.setRequiresSelfNotify();
		if(this.blockID == AluminumMod.crusherActiveID)
		{
			this.setCreativeTab(null);
			this.setLightValue(1.0F);
		}
		if(this.blockID == AluminumMod.crusherIdleID)
		{
			this.setCreativeTab(AluminumMod.tabAluminum);
		}
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Blocks/terrain.png";
	}

	public int idDropped(int i, Random random)
	{
		return AluminumMod.crusherIdle.blockID;
	}

	public void onBlockAdded(World world, int i, int j, int k)
	{
		super.onBlockAdded(world, i, j, k);
		setDefaultDirection(world, i, j, k);
	}

	private void setDefaultDirection(World world, int i, int j, int k)
	{
		if(world.isRemote)
		{
			return;
		}

		int l = world.getBlockId(i, j, k - 1);
		int i1 = world.getBlockId(i, j, k + 1);
		int j1 = world.getBlockId(i - 1, j, k);
		int k1 = world.getBlockId(i + 1, j, k);
		byte byte0 = 3;

		if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
		{
			byte0 = 3;
		}
		if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
		{
			byte0 = 2;
		}
		if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
		{
			byte0 = 5;
		}
		if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
		{
			byte0 = 4;
		}
		world.setBlockMetadataWithNotify(i, j, k, byte0);
	}

	public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
		int i1 = iblockaccess.getBlockMetadata(i, j, k);

		if(l == 1 || l == 0)
		{
			return blockIndexInTexture + 3;
		}
		if(l != i1)
		{
			return blockIndexInTexture + 2;
		}
		if(isActive)
		{
			return blockIndexInTexture + 1;
		} else
		{
			return blockIndexInTexture;
		}
	}

	public void randomDisplayTick(World world, int i, int j, int k, Random random)
	{
		if(!isActive)
		{
			return;
		}

		int l = world.getBlockMetadata(i, j, k);
		float f = (float)i + 0.5F;
		float f1 = (float)j + 0.0F + (random.nextFloat() * 6F) / 16F;
		float f2 = (float)k + 0.5F;
		float f3 = 0.52F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;

		if(l == 4)
		{
			world.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("reddust", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
		} else if(l == 5)
		{
			world.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("reddust", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
		} else if(l == 2)
		{
			world.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("reddust", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
		} else if(l == 3)
		{
			world.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
			world.spawnParticle("reddust", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
		}
	}

	public int getBlockTextureFromSide(int i)
	{
		if(i == 1)
		{
			return blockIndexInTexture + 3;
		}
		if(i == 0)
		{
			return blockIndexInTexture + 3;
		}
		if(i == 3)
		{
			return blockIndexInTexture;
		} else
		{
			return blockIndexInTexture + 2;
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		if(world.isRemote)
		{
			return true;
		} else
		{
			TileEntityCrusher tileentitycrusher = (TileEntityCrusher)world.getBlockTileEntity(i, j, k);
			// ModLoader.openGUI(player, new GuiCrusher(player.inventory, tileentitycrusher));
			player.openGui(AluminumMod.instance, 0, world, i, j, k);
			return true;
		}
	}

	public static void updateCrusherBlockState(boolean flag, World world, int i, int j, int k)
	{
		int l = world.getBlockMetadata(i, j, k);
		TileEntity tileentity = world.getBlockTileEntity(i, j, k);
		keepCrusherInventory = true;

		if(flag)
		{
			world.setBlockWithNotify(i, j, k, AluminumMod.crusherActive.blockID);
		} else
		{
			world.setBlockWithNotify(i, j, k, AluminumMod.crusherIdle.blockID);
		}

		keepCrusherInventory = false;
		world.setBlockMetadataWithNotify(i, j, k, l);
		if(tileentity != null)
		{
			tileentity.validate();
			world.setBlockTileEntity(i, j, k, tileentity);
		}
	}

	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{
		int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;

		if(l == 0)
		{
			world.setBlockMetadataWithNotify(i, j, k, 2);
		}
		if(l == 1)
		{
			world.setBlockMetadataWithNotify(i, j, k, 5);
		}
		if(l == 2)
		{
			world.setBlockMetadataWithNotify(i, j, k, 3);
		}
		if(l == 3)
		{
			world.setBlockMetadataWithNotify(i, j, k, 4);
		}
	}

	public void breakBlock(World world, int i, int j, int k, int par5, int par6)
	{
		if(!keepCrusherInventory)
		{
			TileEntityCrusher tileentitycrusher = (TileEntityCrusher) world.getBlockTileEntity(i, j, k);
			label0:
				for(int l = 0; l < tileentitycrusher.getSizeInventory(); l++)
				{
					ItemStack itemstack = tileentitycrusher.getStackInSlot(l);

					if(itemstack == null)
					{
						continue;
					}

					float f = crusherRand.nextFloat() * 0.8F + 0.1F;
					float f1 = crusherRand.nextFloat() * 0.8F + 0.1F;
					float f2 = crusherRand.nextFloat() * 0.8F + 0.1F;

					do
					{
						if(itemstack.stackSize <= 0)
						{
							continue label0;
						}

						int i1 = crusherRand.nextInt(21) + 10;

						if(i1 > itemstack.stackSize)
						{
							i1 = itemstack.stackSize;
						}

						itemstack.stackSize -= i1;
						EntityItem entityitem = new EntityItem(world, (float)i + f, (float)j + f1, (float)k + f2, new ItemStack(itemstack.itemID, i1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (float)crusherRand.nextGaussian() * f3;
						entityitem.motionY = (float)crusherRand.nextGaussian() * f3 + 0.2F;
						entityitem.motionZ = (float)crusherRand.nextGaussian() * f3;
						world.spawnEntityInWorld(entityitem);
					} while(true);
				}
		}
		super.breakBlock(world, i, j, k, par5, par6 );
	}

	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityCrusher();
	}
}