package aluminum.mod.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

import java.util.List;


public class ContainerCrusher extends Container
{
	private TileEntityCrusher crusher;
	private int lastCookTime;
	private int lastBurnTime;
	private int lastItemBurnTime;

	public ContainerCrusher(InventoryPlayer inventoryplayer, TileEntityCrusher tileentitycrusher)
	{
		lastCookTime = 0;
		lastBurnTime = 0;
		lastItemBurnTime = 0;
		crusher = tileentitycrusher;
		addSlotToContainer(new Slot(tileentitycrusher, 0, 56, 17));
		addSlotToContainer(new Slot(tileentitycrusher, 1, 56, 53));
		addSlotToContainer(new SlotFurnace(inventoryplayer.player, tileentitycrusher, 2, 116, 35));

		for(int i = 0; i < 3; i++)
		{
			for(int k = 0; k < 9; k++)
			{
				addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
			}
		}
		for(int j = 0; j < 9; j++)
		{
			addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
		}
	}

	public void updateCraftingResults()
	{
		super.updateCraftingResults();

		for(int i = 0; i < crafters.size(); i++)
		{
			ICrafting icrafting = (ICrafting)crafters.get(i);
			if(lastCookTime != crusher.crusherCookTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, crusher.crusherCookTime);
			}
			if(lastBurnTime != crusher.crusherBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, crusher.crusherBurnTime);
			}
			if(lastItemBurnTime != crusher.currentItemBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 2, crusher.currentItemBurnTime);
			}
		}
		lastCookTime = crusher.crusherCookTime;
		lastBurnTime = crusher.crusherBurnTime;
		lastItemBurnTime = crusher.currentItemBurnTime;
	}

	public void updateProgressBar(int i, int j)
	{
		if(i == 0)
		{
			crusher.crusherCookTime = j;
		}
		if(i == 1)
		{
			crusher.crusherBurnTime = j;
		}
		if(i == 2)
		{
			crusher.currentItemBurnTime = j;
		}
	}

	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return crusher.isUseableByPlayer(entityplayer);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int i)
    {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(i);

		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(i == 2)
			{
				if(!mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}
			} else if(i >= 3 && i < 30)
			{
				if(!mergeItemStack(itemstack1, 30, 39, false))
				{
					return null;
				}
			} else if(i >= 30 && i < 39)
			{
				if(!mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			} else if(!mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}
			if(itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			} else
			{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize != itemstack.stackSize)
			{
				slot.onPickupFromSlot(player, itemstack1);
			} else
			{
				return null;
			}
		}
		return itemstack;
	}
}