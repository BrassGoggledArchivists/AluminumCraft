package aluminum.mod.entities;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.src.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityThermiteGrenade extends EntityThrowable
{
	public EntityThermiteGrenade(World world)
	{
		super(world);
	}

	public EntityThermiteGrenade(World world, EntityLiving entityliving)
	{
		super(world, entityliving);
	}

	public EntityThermiteGrenade(World world, double d, double d1, double d2)
	{
		super(world, d, d1, d2);
	}

	protected void onImpact(MovingObjectPosition movingobjectposition)
	{
		if(movingobjectposition.entityHit != null)
		{
			byte byte0 = 0;
			if(!movingobjectposition.entityHit.attackEntityFrom(DamageSource.generic, byte0));
			this.explode();
		}
		for(int i = 0; i < 8; i++) {}
		if(!worldObj.isRemote)
		{
			float f = 3F;
			worldObj.newExplosion(null, posX, posY, posZ, f, true, true);
			setDead();
		}
	}

	private void explode()
	{
		float f = 3F;
		worldObj.createExplosion(null, posX, posY, posZ, f, true);
	}
}