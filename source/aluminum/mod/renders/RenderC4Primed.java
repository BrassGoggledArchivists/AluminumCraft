package aluminum.mod.renders;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import aluminum.mod.common.AluminumMod;
import aluminum.mod.entities.EntityC4Primed;

import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class RenderC4Primed extends Render
{
    private RenderBlocks blockRenderer = new RenderBlocks();

    public RenderC4Primed()
    {
        this.shadowSize = 0.5F;
    }

    public void renderPrimedTNT(EntityC4Primed entityC4Primed, double d, double d2, double d3, float f, float f2)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d2, (float)d3);
        float f3;

        if((float)entityC4Primed.fuse - f2 + 1.0F < 10.0F)
        {
            f3 = 1.0F - ((float)entityC4Primed.fuse - f2 + 1.0F) / 10.0F;

            if(f3 < 0.0F)
            {
                f3 = 0.0F;
            }
            if(f3 > 1.0F)
            {
                f3 = 1.0F;
            }

            f3 *= f3;
            f3 *= f3;
            float var11 = 1.0F + f3 * 0.3F;
            GL11.glScalef(var11, var11, var11);
        }

        f3 = (1.0F - ((float)entityC4Primed.fuse - f2 + 1.0F) / 100.0F) * 0.8F;
        this.loadTexture("/Aluminium Mod/Blocks/terrain.png");
        this.blockRenderer.renderBlockAsItem(AluminumMod.C4, 0, entityC4Primed.getBrightness(f2));

        if(entityC4Primed.fuse / 5 % 2 == 0)
        {
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, f3);
            this.blockRenderer.renderBlockAsItem(AluminumMod.C4, 0, 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
        }
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d2, double d3, float f, float f2)
    {
        this.renderPrimedTNT((EntityC4Primed) entity, d, d2, d3, f, f2);
    }
}