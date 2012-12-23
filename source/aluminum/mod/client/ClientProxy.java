package aluminum.mod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import aluminum.mod.common.*;
import aluminum.mod.entities.*;
import aluminum.mod.renders.*;

import net.minecraftforge.client.MinecraftForgeClient;

// This is important, you Client Proxy HAS to extend your CommonProxy
public class ClientProxy extends CommonProxy 
{
	// All rendering information will be placed in the Client proxy, as no rendering is done on the Server side (CommonProxy)
	@Override
	public void registerRenderInformation() 
	{ 
		MinecraftForgeClient.preloadTexture("/Aluminium Mod/Blocks/terrain.png");
		MinecraftForgeClient.preloadTexture("/Aluminium Mod/Items/items.png");
		// The Render information for explosives
		RenderingRegistry.registerEntityRenderingHandler(EntityAluminumGrenade.class, new RenderExplosiveThrowable(AluminumMod.aluminumGrenade.getIconFromDamage(0)));
		RenderingRegistry.registerEntityRenderingHandler(EntityThermiteGrenade.class, new RenderExplosiveThrowable(AluminumMod.thermiteGrenade.getIconFromDamage(0)));
		RenderingRegistry.registerEntityRenderingHandler(EntityC4Primed.class, new RenderC4Primed());
		RenderingRegistry.registerEntityRenderingHandler(EntityLandminePrimed.class, new RenderLandminePrimed());
	}
}
