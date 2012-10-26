package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class ALEntityRobot extends EntityMob
{

        public ALEntityRobot(World world)
        {
                super(world);
                texture = "/Aluminium Mod/Mobs/robot.png";
                moveSpeed = 1.1F;
                attackStrength = 6;
                isImmuneToFire = true;
                health = 10;
        }
        public int getMaxHealth()
    {
        return 10;
    }
        
        public boolean canBreatheUnderwater()
        {
                return true;
        }
        protected boolean canDespawn()
        {
                return true;
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
        
        public boolean interact(EntityPlayer entityplayer) {
        ItemStack item = entityplayer.getCurrentEquippedItem();
        if (item != null && item.itemID == mod_Aluminium.battery1.shiftedIndex || item.itemID == mod_Aluminium.battery2.shiftedIndex || item.itemID == mod_Aluminium.battery3.shiftedIndex)
        {
            if(!this.worldObj.isRemote) 
            {
                ALEntityRobotTame robotTame = new ALEntityRobotTame(this.worldObj);            
                robotTame.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);	
                this.worldObj.spawnEntityInWorld(robotTame);
                this.setEntityDead();
                if(item.itemID == mod_Aluminium.battery1.shiftedIndex)
                {
                    entityplayer.inventory.consumeInventoryItem(mod_Aluminium.battery1.shiftedIndex);
                }
                if(item.itemID == mod_Aluminium.battery2.shiftedIndex)
                {
                    entityplayer.inventory.consumeInventoryItem(mod_Aluminium.battery2.shiftedIndex);
                }
                if(item.itemID == mod_Aluminium.battery3.shiftedIndex)
                {
                    entityplayer.inventory.consumeInventoryItem(mod_Aluminium.battery3.shiftedIndex);
                }
            }  
            return true;
         }else
         {
         return false;
         }
   	}
   private int amountTaken = 0;
        
}