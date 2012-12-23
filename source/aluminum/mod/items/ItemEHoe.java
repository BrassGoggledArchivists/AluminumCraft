package aluminum.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import aluminum.mod.common.AluminumMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemEHoe extends Item
{
	public EntityPlayer inventory;
	
	public ItemEHoe(int i, EnumToolMaterial enumtoolmaterial)
	{
		super(i);
		maxStackSize = 1;
		setMaxDamage(enumtoolmaterial.getMaxUses());
		this.setCreativeTab(AluminumMod.tabAluminum);
	}

	public String getTextureFile()
	{
		return "/Aluminium Mod/Items/items.png";
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int i, int j, int k, int l, float par8, float par9, float par10)
	{
		if (!player.canPlayerEdit(i, j, k, l, itemStack))
		{
			return false;
		} else
		{
			UseHoeEvent event = new UseHoeEvent(player, itemStack, world, i, j, k);

			if (MinecraftForge.EVENT_BUS.post(event))
			{
				return false;
			}

			if(event.getResult() == Result.ALLOW)
			{
				itemStack.damageItem(1, player);
				return true;
			}

			int i1 = world.getBlockId(i, j, k);
			int j1 = world.getBlockId(i, j + 1, k);

			if (l != 0 && j1 == 0 && i1 == Block.grass.blockID || i1 == Block.dirt.blockID)
			{
				Block block = Block.tilledField;
				world.playSoundEffect((double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

				if (world.isRemote)
				{
					return true;
				} else
				{
					for(int x = -1; x < 2; x++)
					{
						for(int y = -1; y < 2; y++)
						{
							if(world.getBlockId(i + x, j, k + y) == Block.dirt.blockID || world.getBlockId(i + x, j, k + y) == Block.grass.blockID && world.getBlockId(i + x, j + 1, k + y) == 0)
							{
								world.setBlockWithNotify(i + x, j, k + y, block.blockID);
								itemStack.damageItem(1, player);
								if(player.inventory.hasItem(Item.seeds.shiftedIndex) && world.getBlockId(i + x, j + 1, k + y) == 0)
								{
									world.setBlockWithNotify(i + x, j + 1, k + y, Block.crops.blockID);
									player.inventory.consumeInventoryItem(Item.seeds.shiftedIndex);
								}
							}
							if(world.getBlockId(i + x, j, k + y) == block.blockID && world.getBlockId(i + x, j + 1, k + y) == 0)
							{
								itemStack.damageItem(1, player);
								if(player.inventory.hasItem(Item.seeds.shiftedIndex) && world.getBlockId(i + x, j + 1, k + y) == 0)
								{
									world.setBlockWithNotify(i + x, j + 1, k + y, Block.crops.blockID);
									player.inventory.consumeInventoryItem(Item.seeds.shiftedIndex);
									//par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.shiftedIndex);
								}
							}
						}
					}   
				}
			}
			if (l != 0 && j1 == 0 && i1 == Block.tilledField.blockID)
			{
				Block block = Block.tilledField;
				world.playSoundEffect((double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
				if (world.isRemote)
				{
					return true;
				}
				else
				{
					for(int x = -1; x < 2; x++)
					{
						for(int y = -1; y < 2; y++)
						{
							if(world.getBlockId(i + x, j, k + y) == block.blockID && world.getBlockId(i + x, j + 1, k + y) == 0)
							{
								if(player.inventory.hasItem(Item.seeds.shiftedIndex) && world.getBlockId(i + x, j + 1, k + y) == 0)
								{
									world.setBlockWithNotify(i + x, j + 1, k + y, Block.crops.blockID);
									player.inventory.consumeInventoryItem(Item.seeds.shiftedIndex);
									itemStack.damageItem(1, player);
								}
							}
						}
					}    
				}
			}
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
}