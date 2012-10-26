package net.minecraft.src;
      
import org.lwjgl.opengl.GL11;

public class ALRenderRobot extends RenderLiving
{
    public ALRenderRobot(ALModelRobot modelrobot, float f)
    {
        super(modelrobot, f);
        
    }

    public void renderRobot(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entityliving, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderRobot(entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderRobot((EntityLiving)entity, d, d1, d2, f, f1);
    }
}
