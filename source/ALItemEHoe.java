package net.minecraft.src;

import net.minecraft.src.forge.ForgeHooks;
import net.minecraft.src.forge.ITextureProvider;

public class ALItemEHoe extends Item implements ITextureProvider
{
    
    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }
    
    public ALItemEHoe(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(enumtoolmaterial.getMaxUses());
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        if (!entityplayer.canPlayerEdit(i, j, k))
        {
            return false;
        }
        if(ForgeHooks.onUseHoe(itemstack, entityplayer, world, i, j, k)) 
        {
        	itemstack.damageItem(1, entityplayer);
        	return true;
    	}
        int i1 = world.getBlockId(i, j, k);
        int j1 = world.getBlockId(i, j + 1, k);
        if (l != 0 && j1 == 0 && i1 == Block.grass.blockID || i1 == Block.dirt.blockID)
        {
            Block block = Block.tilledField;
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.stepSoundDir2(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
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
                        if(world.getBlockId(i + x, j, k + y) == Block.dirt.blockID || world.getBlockId(i + x, j, k + y) == Block.grass.blockID && world.getBlockId(i + x, j + 1, k + y) == 0)
                        {
                            world.setBlockWithNotify(i + x, j, k + y, block.blockID);
                            itemstack.damageItem(1, entityplayer);
                            if(entityplayer.inventory.hasItem(Item.seeds.shiftedIndex) && world.getBlockId(i + x, j + 1, k + y) == 0)
                            {
                                world.setBlockWithNotify(i + x, j + 1, k + y, Block.crops.blockID);
                                entityplayer.inventory.consumeInventoryItem(Item.seeds.shiftedIndex);
                                itemstack.damageItem(1, entityplayer);
                            }
                        }
                        if(world.getBlockId(i + x, j, k + y) == block.blockID && world.getBlockId(i + x, j + 1, k + y) == 0)
                        {
                            if(entityplayer.inventory.hasItem(Item.seeds.shiftedIndex) && world.getBlockId(i + x, j + 1, k + y) == 0)
                            {
                                world.setBlockWithNotify(i + x, j + 1, k + y, Block.crops.blockID);
                                entityplayer.inventory.consumeInventoryItem(Item.seeds.shiftedIndex);
                                itemstack.damageItem(1, entityplayer);
                            }
                        }
                    }
                }   
            }
        }
        if (l != 0 && j1 == 0 && i1 == Block.tilledField.blockID)
        {
            Block block = Block.tilledField;
            world.playSoundEffect((float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F, block.stepSound.stepSoundDir2(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
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
                            if(entityplayer.inventory.hasItem(Item.seeds.shiftedIndex) && world.getBlockId(i + x, j + 1, k + y) == 0)
                            {
                                world.setBlockWithNotify(i + x, j + 1, k + y, Block.crops.blockID);
                                entityplayer.inventory.consumeInventoryItem(Item.seeds.shiftedIndex);
                                itemstack.damageItem(1, entityplayer);
                            }
                        }
                    }
                }    
            }
        }
        return true;
    }
    
    public boolean isItemStackDamageable()
    {
        return true;
    }

    public boolean isFull3D()
    {
        return true;
    }
    
                            
}