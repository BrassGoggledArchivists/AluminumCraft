// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            TileEntity, IInventory, ItemStack, NBTTagCompound, 
//            NBTTagList, World, Item, BlockReactor, 
//            ReactorRecipes, mod_Uranium, ModLoader, EntityPlayer

public class ALTileEntityCrusher extends TileEntity
    implements IInventory
{

    private ItemStack crusherItemStacks[];
    public int crusherBurnTime;
    public int currentItemBurnTime;
    public int crusherCookTime;

    public ALTileEntityCrusher()
    {
        crusherItemStacks = new ItemStack[3];
        crusherBurnTime = 0;
        currentItemBurnTime = 0;
        crusherCookTime = 0;
    }

    public int getSizeInventory()
    {
        return crusherItemStacks.length;
    }

    public ItemStack getStackInSlot(int i)
    {
        return crusherItemStacks[i];
    }

    public ItemStack decrStackSize(int i, int j)
    {
        if(crusherItemStacks[i] != null)
        {
            if(crusherItemStacks[i].stackSize <= j)
            {
                ItemStack itemstack = crusherItemStacks[i];
                crusherItemStacks[i] = null;
                return itemstack;
            }
            ItemStack itemstack1 = crusherItemStacks[i].splitStack(j);
            if(crusherItemStacks[i].stackSize == 0)
            {
                crusherItemStacks[i] = null;
            }
            return itemstack1;
        } else
        {
            return null;
        }
    }

    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        crusherItemStacks[i] = itemstack;
        if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }
    }

    public String getInvName()
    {
        return "Crusher";
    }

    public void readFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readFromNBT(nbttagcompound);
        NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
        crusherItemStacks = new ItemStack[getSizeInventory()];
        for(int i = 0; i < nbttaglist.tagCount(); i++)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
            byte byte0 = nbttagcompound1.getByte("Slot");
            if(byte0 >= 0 && byte0 < crusherItemStacks.length)
            {
                crusherItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        crusherBurnTime = nbttagcompound.getShort("BurnTime");
        crusherCookTime = nbttagcompound.getShort("CookTime");
        currentItemBurnTime = getItemBurnTime(crusherItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("BurnTime", (short)crusherBurnTime);
        nbttagcompound.setShort("CookTime", (short)crusherCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for(int i = 0; i < crusherItemStacks.length; i++)
        {
            if(crusherItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                crusherItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.setTag(nbttagcompound1);
            }
        }

        nbttagcompound.setTag("Items", nbttaglist);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int i)
    {
        return (crusherCookTime * i) / 800;
    }

    public int getBurnTimeRemainingScaled(int i)
    {
        if(currentItemBurnTime == 0)
        {
            currentItemBurnTime = 800;
        }
        return (crusherBurnTime * i) / currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return crusherBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = crusherBurnTime > 0;
        boolean flag1 = false;
        if(crusherBurnTime > 0)
        {
            crusherBurnTime--;
        }
        if(!worldObj.isRemote)
        {
            if(crusherBurnTime == 0 && canSmelt())
            {
                currentItemBurnTime = crusherBurnTime = getItemBurnTime(crusherItemStacks[1]);
                if(crusherBurnTime > 0)
                {
                    flag1 = true;
                    if(crusherItemStacks[1] != null)
                    {
                        if(crusherItemStacks[1].getItem().hasContainerItem())
                        {
                            crusherItemStacks[1] = new ItemStack(crusherItemStacks[1].getItem().getContainerItem());
                        } else
                        {
                            crusherItemStacks[1].stackSize--;
                        }
                        if(crusherItemStacks[1].stackSize == 0)
                        {
                            crusherItemStacks[1] = null;
                        }
                    }
                }
            }
            if(isBurning() && canSmelt())
            {
                crusherCookTime++;
                if(crusherCookTime == 800)
                {
                    crusherCookTime = 0;
                    smeltItem();
                    flag1 = true;
                }
            } else
            {
                crusherCookTime = 0;
            }
            if(flag != (crusherBurnTime > 0))
            {
                flag1 = true;
                ALBlockCrusher.updateCrusherBlockState(crusherBurnTime > 0, worldObj, xCoord, yCoord, zCoord);
            }
        }
        if(flag1)
        {
            onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
        if(crusherItemStacks[0] == null)
        {
            return false;
        }
        ItemStack itemstack = ALCrusherRecipes.smelting().getSmeltingResult(crusherItemStacks[0].getItem().shiftedIndex);
        if(itemstack == null)
        {
            return false;
        }
        if(crusherItemStacks[2] == null)
        {
            return true;
        }
        if(!crusherItemStacks[2].isItemEqual(itemstack))
        {
            return false;
        }
        if(crusherItemStacks[2].stackSize < getInventoryStackLimit() && crusherItemStacks[2].stackSize < crusherItemStacks[2].getMaxStackSize())
        {
            return true;
        }
        return crusherItemStacks[2].stackSize < itemstack.getMaxStackSize();
    }

    public void smeltItem()
    {
        if(!canSmelt())
        {
            return;
        }
        ItemStack itemstack = ALCrusherRecipes.smelting().getSmeltingResult(crusherItemStacks[0].getItem().shiftedIndex);
        if(crusherItemStacks[2] == null)
        {
            crusherItemStacks[2] = itemstack.copy();
        } else
        if(crusherItemStacks[2].itemID == itemstack.itemID)
        {
            crusherItemStacks[2].stackSize++;
        }
        if(crusherItemStacks[0].getItem().hasContainerItem())
        {
            crusherItemStacks[0] = new ItemStack(crusherItemStacks[0].getItem().getContainerItem());
        } else
        {
            crusherItemStacks[0].stackSize--;
        }
        if(crusherItemStacks[0].stackSize <= 0)
        {
            crusherItemStacks[0] = null;
        }
    }

    private int getItemBurnTime(ItemStack itemstack)
    {
        if(itemstack == null)
        {
            return 0;
        }
        int i = itemstack.getItem().shiftedIndex;
        if(i == Item.redstone.shiftedIndex)
        {
            return 1600;
        }
        if(i == mod_Aluminium.battery1.shiftedIndex)
        {
            return 6400;
        }
        if(i == mod_Aluminium.battery2.shiftedIndex)
        {
            return 12800;
        }
        if(i == mod_Aluminium.battery3.shiftedIndex)
        {
            return 25600;
        }else
        {
            return 0;
        }
    }

    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this)
        {
            return false;
        }
        return entityplayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64D;
    }
	
    public void openChest()
    {
    }

    public void closeChest()
    {
    }

}
