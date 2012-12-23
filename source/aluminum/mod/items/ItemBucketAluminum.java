package aluminum.mod.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;

import java.util.Random;

import aluminum.mod.common.AluminumMod;

public class ItemBucketAluminum extends Item
{
	private int isFull;

	public ItemBucketAluminum(int i, int j)
	{
		super(i);
		maxStackSize = 1;
		isFull = j;
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Items/items.png";
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		float f = 1.0F;
		double var5 = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
		double var7 = player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.62D - (double)player.yOffset;
		double var9 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
		boolean var11 = this.isFull == 0;
		MovingObjectPosition movingObject = this.getMovingObjectPositionFromPlayer(world, player, var11);

		if(movingObject == null)
		{
			return itemStack;
		} else
		{
			FillBucketEvent event = new FillBucketEvent(player, itemStack, world, movingObject);

			if(MinecraftForge.EVENT_BUS.post(event))
			{
				return itemStack;
			}
			if(event.getResult() == Event.Result.ALLOW)
			{
				if(player.capabilities.isCreativeMode)
				{
					return itemStack;
				}
				if(--itemStack.stackSize <= 0)
				{
					return event.result;
				}
				if(!player.inventory.addItemStackToInventory(event.result))
				{
					player.dropPlayerItem(event.result);
				}
				return itemStack;
			}
			if(movingObject.typeOfHit == EnumMovingObjectType.TILE)
			{
				int x = movingObject.blockX;
				int y = movingObject.blockY;
				int z = movingObject.blockZ;

				if(!world.canMineBlock(player, x, y, z))
				{
					return itemStack;
				}
				if(this.isFull == 0)
				{
					if(!player.canPlayerEdit(x, y, z, movingObject.sideHit, itemStack))
					{
						return itemStack;
					}
					if(world.getBlockMaterial(x, y, z) == Material.water && world.getBlockMetadata(x, y, z) == 0)
					{
						world.setBlockWithNotify(x, y, z, 0);

						if(player.capabilities.isCreativeMode)
						{
							return itemStack;
						}
						if(--itemStack.stackSize <= 0)
						{
							return new ItemStack(AluminumMod.aluminumBucketWater);
						}
						if(!player.inventory.addItemStackToInventory(new ItemStack(AluminumMod.aluminumBucketWater)))
						{
							player.dropPlayerItem(new ItemStack(AluminumMod.aluminumBucketWater.shiftedIndex, 1, 0));
						}
						return itemStack;
					}
					if(world.getBlockMaterial(x, y, z) == Material.lava && world.getBlockMetadata(x, y, z) == 0)
					{
						world.setBlockWithNotify(x, y, z, 0);

						if(player.capabilities.isCreativeMode)
						{
							return itemStack;
						}
						if(--itemStack.stackSize <= 0)
						{
							return new ItemStack(AluminumMod.aluminumBucketLava);
						}
						if(!player.inventory.addItemStackToInventory(new ItemStack(AluminumMod.aluminumBucketLava)))
						{
							player.dropPlayerItem(new ItemStack(AluminumMod.aluminumBucketLava.shiftedIndex, 1, 0));
						}
						return itemStack;
					}
				} else
				{
					if(this.isFull < 0)
					{
						return new ItemStack(AluminumMod.aluminumBucket);
					}
					if(movingObject.sideHit == 0)
					{
						--y;
					}
					if(movingObject.sideHit == 1)
					{
						++y;
					}
					if(movingObject.sideHit == 2)
					{
						--z;
					}
					if(movingObject.sideHit == 3)
					{
						++z;
					}
					if(movingObject.sideHit == 4)
					{
						--x;
					}
					if(movingObject.sideHit == 5)
					{
						++x;
					}
					if(!player.canPlayerEdit(x, y, z, movingObject.sideHit, itemStack))
					{
						return itemStack;
					}
					if(this.tryPlaceContainedLiquid(world, var5, var7, var9, x, y, z) && !player.capabilities.isCreativeMode)
					{
						return new ItemStack(AluminumMod.aluminumBucket);
					}
				}
			} 
		}
		if(isFull == 0 && (movingObject.entityHit instanceof EntityCow))
		{
			return null;
		}
		return itemStack; 
	}

	public boolean tryPlaceContainedLiquid(World world, double d, double d2, double d3, int i, int j, int k)
	{
		if(this.isFull <= 0)
		{
			return false;
		} else if(!world.isAirBlock(i, j, k) && world.getBlockMaterial(i, j, k).isSolid())
		{
			return false;
		} else
		{
			if(world.provider.isHellWorld && this.isFull == Block.waterMoving.blockID)
			{
				world.playSoundEffect(d + 0.5D, d2 + 0.5D, d3 + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

				for(int l = 0; l < 8; ++l)
				{
					world.spawnParticle("largesmoke", (double)i + Math.random(), (double)j + Math.random(), (double)k + Math.random(), 0.0D, 0.0D, 0.0D);
				}
			} else
			{
				world.setBlockAndMetadataWithNotify(i, j, k, this.isFull, 0);
			}
			return true;
		}
	}
}