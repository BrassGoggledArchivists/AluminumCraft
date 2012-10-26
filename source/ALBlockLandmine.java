package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.forge.ITextureProvider;

public class ALBlockLandmine extends Block implements ITextureProvider
{
    public String getTextureFile()
    {
        return "/Aluminium Mod/Blocks/terrain.png";
    }

    public ALBlockLandmine(int i, int j)
    {
        super(i, j, Material.tnt);
        setBlockBounds(0.1F, 0F, 0.1F, 0.9F, 0.3F, 0.9F);
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
        }else
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
        ALEntityLandminePrimed entitysmallbombprimed = new ALEntityLandminePrimed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
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
            dropBlockAsItem_do(world, i, j, k, new ItemStack(mod_Aluminium.Landmine.blockID, 1, 0));
        } else
        {
            ALEntityLandminePrimed entitysmallbombprimed = new ALEntityLandminePrimed(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
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
            world.createExplosion(null, i, j, k, 0.2F);
            return;
        }
    }

    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
        return super.blockActivated(world, i, j, k, entityplayer);
    }
}