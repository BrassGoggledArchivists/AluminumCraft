// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityThrowable, MovingObjectPosition, EntityBlaze, DamageSource, 
//            Entity, World, EntityLiving

public class ALEntityAluminiumGrenade extends EntityThrowable
{

    public ALEntityAluminiumGrenade(World world)
    {
        super(world);
    }

    public ALEntityAluminiumGrenade(World world, EntityLiving entityliving)
    {
        super(world, entityliving);
    }

    public ALEntityAluminiumGrenade(World world, double d, double d1, double d2)
    {
        super(world, d, d1, d2);
    }

    protected void onThrowableCollision(MovingObjectPosition movingobjectposition)
    {
        if(movingobjectposition.entityHit != null)
        {
            byte byte0 = 0;
            if(!movingobjectposition.entityHit.attackEntityFrom(DamageSource.cactus, byte0));
			this.explode();
        }
        for(int i = 0; i < 8; i++)
        {
        }

        if(!worldObj.isRemote)
        {
            this.explode();
            setEntityDead();
        }
    }

    private void explode()
    {
        float f = 5F;
        worldObj.createExplosion(null, posX, posY, posZ, f);
    }
}
