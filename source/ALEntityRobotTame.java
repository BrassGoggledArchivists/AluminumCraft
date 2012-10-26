package net.minecraft.src;

import java.util.*;
import net.minecraft.client.Minecraft;

public class ALEntityRobotTame extends ALEntityMobRobot
{
        public ALEntityRobotTame(World world)
        {
                super(world);
                texture = "/Aluminium Mod/Mobs/robotTame.png";
                moveSpeed = 1.5F;
                isImmuneToFire = true;
                health = 20;
                attackStrength = 10;
        }
        public int getMaxHealth()
        {
            return 20;
        }
        
        public boolean canBreatheUnderwater()
        {
            return true;
        }
        protected boolean canDespawn()
        {
            return false;
        }
        protected String getLivingSound()
    	{
            return null; 
   	}

    	protected String getHurtSound()
    	{
            return null;
    	}

    	protected String getDeathSound()
    	{
            return null;
    	}

    	protected float getSoundVolume()
    	{
            return 0.4F;
    	}
        
        protected int getDropItemId()
        {
            return mod_Aluminium.aluminiumIngot.shiftedIndex;
        }
        
        public void onLivingUpdate()
        {
            super.onLivingUpdate();
            Minecraft mc = ModLoader.getMinecraftInstance();
            EntityPlayer player = mc.thePlayer;
            PathEntity pathentity;
            if(player != null)
            {
                float f = player.getDistanceToEntity(this);
                if(f > 5F && f < 18F)
                {
                    pathentity = worldObj.getPathToEntity(this, player, 16F);
                }   
                else
                {
                    pathentity = null;
                }   
                setPathToEntity(pathentity);
            }
        }
        
    	protected void updateEntityActionState()
	{
            super.updateEntityActionState();
            if(entityToAttack == null && !hasPath() && worldObj.rand.nextInt(100) == 0)
            {
            	List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityMob.class, AxisAlignedBB.getBoundingBoxFromPool(posX, posY, posZ, posX + 16.0D, posY + 16.0D, posZ + 16.0D).expand(16D, 16D, 16D));           	
            	if(!list.isEmpty())
            	{
                    setEntityToAttack((Entity)list.get(worldObj.rand.nextInt(list.size())));
            	}
            }     	
    	}
        
        public boolean interact(EntityPlayer entityplayer) 
        {
            ItemStack item = entityplayer.getCurrentEquippedItem();
            if (item != null && item.itemID == mod_Aluminium.battery1.shiftedIndex)
            {
                item.stackSize--;
                if(!this.worldObj.isRemote) 
                {
                    System.out.println("Health = " + health);
                    health = health + 2;
                    System.out.println("Health is now = " + health);
                    entityplayer.inventory.consumeInventoryItem(mod_Aluminium.battery1.shiftedIndex);
                }
                
            }
            if (item != null && item.itemID == mod_Aluminium.battery2.shiftedIndex)
            {
                if(!this.worldObj.isRemote) 
                {
                    System.out.println("Health = " + health);
                    health = health + 4;
                    System.out.println("Health is now = " + health);
                    entityplayer.inventory.consumeInventoryItem(mod_Aluminium.battery2.shiftedIndex);
                }
                
            }
            if (item != null && item.itemID == mod_Aluminium.battery3.shiftedIndex)
            {
                if(!this.worldObj.isRemote) 
                {
                    System.out.println("Health = " + health);
                    health = health + 8;
                    System.out.println("Health is now = " + health);
                    entityplayer.inventory.consumeInventoryItem(mod_Aluminium.battery3.shiftedIndex);
                }
                
            }
            return true;
        }
        
        private void getPathOrWalkableBlock(Entity entity, float f)
        {
            PathEntity pathentity = worldObj.getPathToEntity(this, entity, 16F);
            if (pathentity == null && f > 12F)
            {
                int i = MathHelper.floor_double(entity.posX) - 2;
                int j = MathHelper.floor_double(entity.posZ) - 2;
                int k = MathHelper.floor_double(entity.boundingBox.minY);
                for (int l = 0; l <= 4; l++)
                {
                    for (int i1 = 0; i1 <= 4; i1++)
                    {
                        if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && worldObj.isBlockNormalCube(i + l, k - 1, j + i1) && !worldObj.isBlockNormalCube(i + l, k, j + i1) && !worldObj.isBlockNormalCube(i + l, k + 1, j + i1))
                        {
                            setLocationAndAngles((float)(i + l) + 0.5F, k, (float)(j + i1) + 0.5F, rotationYaw, rotationPitch);
                            return;
                        }
                    }
                }
            }
            else
            {   
                setPathToEntity(pathentity);
            }
        }
    }