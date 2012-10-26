package net.minecraft.src;

import net.minecraft.client.Minecraft;
import net.minecraft.src.forge.ITextureProvider;

public class ALItemRobot extends Item implements ITextureProvider
{

    public String getTextureFile()
    {
        return "/Aluminium Mod/Items/items.png";
    }

    public ALItemRobot(int i)
    {
        super(i);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) 
    {
	Vec3D vec3d = Vec3D.createVector(player.posX, player.posY, player.posZ);
	double vecX = -Math.sin(Math.toRadians(player.rotationYaw)) * Math.cos(Math.toRadians(player.rotationPitch)) * 5D;
	double vecY = -Math.sin(Math.toRadians(player.rotationPitch)) * 5D;
	double vecZ = Math.cos(Math.toRadians(player.rotationYaw)) * Math.cos(Math.toRadians(player.rotationPitch)) * 5D;
	Vec3D vec3d1 = vec3d.addVector(vecX, vecY, vecZ);
	MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do(vec3d, vec3d1, true);
		
	if(movingobjectposition != null && movingobjectposition.typeOfHit == EnumMovingObjectType.TILE) 
        {
            int x = movingobjectposition.blockX, y = movingobjectposition.blockY, z = movingobjectposition.blockZ;
            ALEntityRobotTame robotTame = new ALEntityRobotTame(world);
            robotTame.setLocationAndAngles(x+0.5, y+1+robotTame.yOffset, z+0.5, player.rotationYaw, player.rotationPitch);
            world.spawnEntityInWorld(robotTame);
            System.out.println("<EntitySpawner>: " + "Robot Spawned @ " + x + " x, " + y + " y, " + z + " z.");
            itemstack.stackSize--;
        }
    return itemstack;
    }
    
}