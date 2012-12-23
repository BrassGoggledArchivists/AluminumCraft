package aluminum.mod.gui;

import net.minecraft.src.*;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import org.lwjgl.opengl.GL11;


public class GuiCrusher extends GuiContainer
{
	private TileEntityCrusher crusherInventory;

	public GuiCrusher(InventoryPlayer inventoryplayer, TileEntityCrusher tileentitycrusher)
	{
		super(new ContainerCrusher(inventoryplayer, tileentitycrusher));
		crusherInventory = tileentitycrusher;
	}

	protected void drawGuiContainerForegroundLayer()
	{
		fontRenderer.drawString("Crusher", 60, 6, 0x404040);
		fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		int k = mc.renderEngine.getTexture("/Aluminium Mod/GUI/crusherGUI.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(k);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
		
		if(crusherInventory.isBurning())
		{
			int j1 = crusherInventory.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(l + 56, (i1 + 36 + 12) - j1, 176, 12 - j1, 14, j1 + 2);
		}
		
		int k1 = crusherInventory.getCookProgressScaled(24);
		drawTexturedModalRect(l + 79, i1 + 34, 176, 14, k1 + 1, 16);
	}
}