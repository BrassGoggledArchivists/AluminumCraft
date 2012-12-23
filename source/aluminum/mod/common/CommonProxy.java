package aluminum.mod.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import aluminum.mod.gui.ContainerCrusher;
import aluminum.mod.gui.GuiCrusher;
import aluminum.mod.gui.TileEntityCrusher;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public void registerRenderInformation() {}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int i, int j, int k) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(i, j, k);

		if(tileEntity instanceof TileEntityCrusher)
		{
			return new ContainerCrusher(player.inventory, (TileEntityCrusher) tileEntity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int i, int j, int k) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(i, j, k);

		if(tileEntity instanceof TileEntityCrusher)
		{
			return new GuiCrusher(player.inventory, (TileEntityCrusher) tileEntity);
		}
		return null;
	}
}
