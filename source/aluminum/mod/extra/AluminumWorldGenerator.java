package aluminum.mod.extra;

import java.util.Random;

import aluminum.mod.common.AluminumMod;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import cpw.mods.fml.common.IWorldGenerator;

public class AluminumWorldGenerator implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.dimensionId) 
		{
		case -1:
			generateNether();
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd();
			break;
		}
	}

	public void generateNether() {}

	public void generateSurface(World world, Random random, int chunkX, int chunkZ) 
	{
		for(int i = 0; i < 8; i++)
        {
            int randPosX = chunkX + random.nextInt(16);
            int randPosY = random.nextInt(62);
            int randPosZ = chunkZ + random.nextInt(16);
            (new WorldGenMinable(AluminumMod.aluminumOre.blockID, 8)).generate(world, random, randPosX, randPosY, randPosZ);
        }
	}

	public void generateEnd() {}
}