package aluminum.mod.renders;

import aluminum.mod.client.ClientProxy;
import aluminum.mod.common.*;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.potion.PotionHelper;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class RenderExplosiveThrowable extends Render
{
	public int itemIconIndex;

	public RenderExplosiveThrowable(int i) 
	{
		this.itemIconIndex = i;
	}

	public void doRender(Entity entity, double d, double d2, double d3, float f, float f2)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d, (float)d2, (float)d3);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		this.loadTexture("/Aluminium Mod/Items/items.png");
		Tessellator tessellator = Tessellator.instance;

		if(itemIconIndex == 154)
		{
			int i = PotionHelper.func_77915_a(((EntityPotion) entity).getPotionDamage(), false);
			float f3 = (float)(i >> 16 & 255) / 255.0F;
			float f4 = (float)(i >> 8 & 255) / 255.0F;
			float f5 = (float)(i & 255) / 255.0F;
			GL11.glColor3f(f3, f4, f5);
			GL11.glPushMatrix();
			this.func_77026_a(tessellator, this.itemIconIndex);
			GL11.glPopMatrix();
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
		}

		this.func_77026_a(tessellator, this.itemIconIndex);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	private void func_77026_a(Tessellator tessellator, int i)
	{
		float var3 = (float)(i % 16 * 16 + 0) / 256.0F;
		float var4 = (float)(i % 16 * 16 + 16) / 256.0F;
		float var5 = (float)(i / 16 * 16 + 0) / 256.0F;
		float var6 = (float)(i / 16 * 16 + 16) / 256.0F;
		float var7 = 1.0F;
		float var8 = 0.5F;
		float var9 = 0.25F;
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV((double)(0.0F - var8), (double)(0.0F - var9), 0.0D, (double)var3, (double)var6);
		tessellator.addVertexWithUV((double)(var7 - var8), (double)(0.0F - var9), 0.0D, (double)var4, (double)var6);
		tessellator.addVertexWithUV((double)(var7 - var8), (double)(var7 - var9), 0.0D, (double)var4, (double)var5);
		tessellator.addVertexWithUV((double)(0.0F - var8), (double)(var7 - var9), 0.0D, (double)var3, (double)var5);
		tessellator.draw();
	}
}