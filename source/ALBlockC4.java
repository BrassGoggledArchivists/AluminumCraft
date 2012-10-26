package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.forge.ITextureProvider;

public class ALBlockC4 extends Block implements ITextureProvider
{
    public String getTextureFile()
    {
        return "/Aluminium Mod/Blocks/terrain.png";
    }
    
    public ALBlockC4(int i, int j)
    {
        super(i, Material.tnt);
        blockIndexInTexture = j;
        
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
        ALEntityC4Primed entityC4primed = new ALEntityC4Primed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
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
            dropBlockAsItem_do(world, i, j, k, new ItemStack(mod_Aluminium.C4.blockID, 1, 0));
        } else
        {
            ALEntityC4Primed entityC4primed = new ALEntityC4Primed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
            world.spawnEntityInWorld(entityC4primed);
            world.playSoundAtEntity(entityC4primed, "random.fuse", 1.0F, 1.0F);
        }
    }
    
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return super.blockActivated(world, i, j, k, entityplayer);
    }
    
    public int idDropped(int i, Random random)
    {
       return mod_Aluminium.C4.blockID;
    }
    public int quantityDropped(Random random)
    {
            return 0;
    } 
}