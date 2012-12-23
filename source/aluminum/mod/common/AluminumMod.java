package aluminum.mod.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import aluminum.mod.blocks.*;
import aluminum.mod.entities.*;
import aluminum.mod.extra.FuelHandler;
import aluminum.mod.extra.ModData;
import aluminum.mod.extra.TabAluminum;
import aluminum.mod.gui.ServerPacketHandler;
import aluminum.mod.gui.TileEntityCrusher;
import aluminum.mod.items.*;
import aluminum.mod.renders.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Property;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * @author MrArcane111 (Johnny Eatmon)
 * Please use this code for educational purposes.
 * If you have questions, visit this mod's post.
 *
 */

@Mod(modid = "MrArcane111_Aluminum", name = "AluminumCraft", version = "3.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, serverPacketHandlerSpec =
@SidedPacketHandler(channels = {"AluminumMod"}, packetHandler = ServerPacketHandler.class))

public class AluminumMod
{
	@SidedProxy(clientSide = "aluminum.mod.client.ClientProxy", serverSide = "aluminum.mod.common.CommonProxy")
	public static CommonProxy proxy;
	@Instance("MrArcane111_Aluminum")
	public static AluminumMod instance;
	// Blocks
	public static int aluminumOreID;
	public static Block aluminumOre;
	public static int aluminumBlockID;
	public static Block aluminumBlock;
	public static int landmineID;
	public static Block landmine;
	public static int C4ID;
	public static Block C4;
	public static int glassID;
	public static Block glass;
	public static int crusherActiveID;
	public static Block crusherActive;
	public static int crusherIdleID;
	public static Block crusherIdle;
	public static int trapdoorID;
	public static Block trapdoor;
	// Items
	public static int pickID = 400, shovelID = 401, axeID = 402, hoeID = 403, swordID = 404;
	public static Item aluminumPick;
	public static Item aluminumShovel;
	public static Item aluminumAxe;
	public static Item aluminumHoe;
	public static Item aluminumSword;
	public static int aluminumOxideID = 405, sheetID = 406, aluminumIngotID = 407;
	public static Item aluminumOxide;
	public static Item aluminumSheet;
	public static Item aluminumIngot;
	public static int canID = 408, canPorkID = 409, canFishID = 410, canChickenID = 411, canBeefID = 412;
	public static Item aluminumCan;
	public static Item aluminumCanPork;
	public static Item aluminumCanFish;
	public static Item aluminumCanChicken;
	public static Item aluminumCanBeef;
	public static int battery1ID = 413, battery2ID = 414, battery3ID = 415;
	public static Item battery1;
	public static Item battery2;
	public static Item battery3;
	public static int drillTipID = 416, drillInactiveID = 417, drill1ID = 418, drill2ID = 419, drill3ID = 420;
	public static Item drillTip;
	public static Item drill1;
	public static Item drill2;
	public static Item drill3;
	public static Item drillInactive;
	public static int ehoeTipID = 421, ehoeInactiveID = 422, ehoe1ID = 423, ehoe2ID = 424, ehoe3ID = 425;
	public static Item eHoeTip;
	public static Item eHoe1;
	public static Item eHoe2;
	public static Item eHoe3;
	public static Item eHoeInactive;
	public static int chainsawTipID = 426, chainsawInactiveID = 427, chainsaw1ID = 428, chainsaw2ID = 429, chainsaw3ID = 430;
	public static Item chainsawTip;
	public static Item chainsawInactive;
	public static Item chainsaw1;
	public static Item chainsaw2;
	public static Item chainsaw3;
	public static int aluminumPowderID = 431, ironPowderID = 432, thermiteID = 433, goldPowderID = 434, diamondPowderID = 435;
	public static Item aluminumPowder;
	public static Item ironOxide;
	public static Item goldPowder;
	public static Item diamondDust;
	public static Item thermite;
	public static int bucketID = 449, bucketWID = 450, bucketLID = 451;
	public static Item aluminumBucket;
	public static Item aluminumBucketWater;
	public static Item aluminumBucketLava;
	public static int fuseID = 442, bombID = 443, fireBombID = 444;
	public static Item fuse;
	public static Item aluminumGrenade;
	public static Item thermiteGrenade;
	public static int helmetID = 445, chestID = 446, legsID = 447, bootsID = 448;
	public static Item aluminumHelmet;
	public static Item aluminumChest;
	public static Item aluminumLegs;
	public static Item aluminumBoots;
	// Tool Materials
	public static final EnumToolMaterial ALUMINUM = EnumHelper.addToolMaterial("ALUMINUM", 1, 200, 5F, 4, 4);
	public static final EnumToolMaterial SUPERTOOL1 = EnumHelper.addToolMaterial("SUPERTOOL1", 4, 2000, 14F, 8, 35);
	public static final EnumToolMaterial SUPERTOOL2 = EnumHelper.addToolMaterial("SUPERTOOL2", 5, 2500, 23F, 10, 45);
	public static final EnumToolMaterial SUPERTOOL3 = EnumHelper.addToolMaterial("SUPERTOOL3", 6, 3000, 30F, 12, 55);
	// Armor Material
	public static final EnumArmorMaterial ALUMINUM_ARMOR = EnumHelper.addArmorMaterial("ALUMINUM_ARMOR",  4, new int[] {2, 5, 4, 1}, 12);
	// Creative Tab
	public static CreativeTabs tabAluminum = new TabAluminum(CreativeTabs.getNextID(),"Aluminum"); 

	@Init
	public void init(FMLInitializationEvent event)
	{
		// Blocks
		aluminumOre = new BlockAluminumOre(aluminumOreID, 0).setBlockName("aluminumOre");
		aluminumBlock = new BlockAluminum(aluminumBlockID, 1).setBlockName("aluminumBlock");
		landmine = new BlockLandmine(landmineID, 2).setBlockName("smallbomb");
		C4 = new BlockC4(C4ID, 5).setBlockName("C4");
		glass = new BlockRGlass(glassID, 13, Material.glass, false).setBlockName("rGlass");
		crusherIdle = new BlockCrusher(crusherIdleID, 8, false).setBlockName("idle"); 
		crusherActive = new BlockCrusher(crusherActiveID, 8, true).setBlockName("active"); 
		trapdoor = new BlockTrapdoor(trapdoorID, 12, Material.iron).setBlockName("trapdoor");
		// Items
		aluminumPick = new ItemAluminumPickaxe(pickID, ALUMINUM).setItemName("pickaxe").setIconCoord(0, 0);
		aluminumShovel = new ItemAluminumShovel(shovelID, ALUMINUM).setItemName("shovel").setIconCoord(1, 0);
		aluminumAxe = new ItemAluminumAxe(axeID, ALUMINUM).setItemName("axe").setIconCoord(2, 0);
		aluminumHoe = new ItemAluminumHoe(hoeID, ALUMINUM).setItemName("hoe").setIconCoord(3, 0);
		aluminumSword = new ItemAluminumSword(swordID, ALUMINUM).setItemName("sword").setIconCoord(0, 1);
		aluminumOxide = new Item_Misc(aluminumOxideID).setItemName("alumina").setIconCoord(4, 3);
		aluminumSheet = new Item_Misc(sheetID).setItemName("sheet").setIconCoord(6, 3);
		aluminumIngot = new Item_Misc(aluminumIngotID).setItemName("ingot").setIconCoord(5, 3);
		aluminumCan = new Item_Misc(canID).setItemName("can").setIconCoord(7, 0);
		aluminumCanPork = new ItemCanFood(canPorkID, 12).setItemName("canPork").setIconCoord(11, 0);
		aluminumCanFish = new ItemCanFood(canFishID, 10).setItemName("canFish").setIconCoord(10, 0);
		aluminumCanChicken = new ItemCanFood(canChickenID, 10).setItemName("canChicken").setIconCoord(9, 0);
		aluminumCanBeef = new ItemCanFood(canBeefID, 12).setItemName("canBeef").setIconCoord(8, 0);
		battery1 = new Item_Misc(battery1ID).setItemName("battery1").setIconCoord(4, 0);
		battery2 = new Item_Misc(battery2ID).setItemName("battery2").setIconCoord(5, 0);
		battery3 = new Item_Misc(battery3ID).setItemName("battery3").setIconCoord(6, 0);
		drillTip = new Item_Misc(drillTipID).setItemName("drilltip").setIconCoord(4, 4);
		drill1 = new ItemDrill(drill1ID, SUPERTOOL1).setItemName("drill").setIconCoord(13, 0);
		drill2 = new ItemDrill(drill2ID, SUPERTOOL2).setItemName("drill2").setIconCoord(14, 0);
		drill3 = new ItemDrill(drill3ID, SUPERTOOL3).setItemName("drill3").setIconCoord(15, 0);
		drillInactive = new Item_Misc(drillInactiveID).setItemName("drillunactive").setIconCoord(12, 0);
		eHoeTip = new Item_Misc(ehoeTipID).setItemName("ehoetip").setIconCoord(6, 4);
		eHoeInactive = new Item_Misc(ehoeInactiveID).setItemName("ehoeunactive").setIconCoord(12, 2);
		eHoe1 = new ItemEHoe(ehoe1ID, SUPERTOOL1).setItemName("eHoe1").setIconCoord(13, 2);
		eHoe2 = new ItemEHoe(ehoe2ID, SUPERTOOL2).setItemName("eHoe2").setIconCoord(14, 2);
		eHoe3 = new ItemEHoe(ehoe3ID, SUPERTOOL3).setItemName("eHoe3").setIconCoord(15, 2);
		chainsawTip = new Item_Misc(chainsawTipID).setItemName("chainsawtip").setIconCoord(5, 4);
		chainsawInactive = new Item_Misc(chainsawInactiveID).setItemName("chainsawunactive").setIconCoord(12, 1);
		chainsaw1 = new ItemChainsaw(chainsaw1ID, SUPERTOOL1).setItemName("chainsaw1").setIconCoord(13, 1);
		chainsaw2 = new ItemChainsaw(chainsaw2ID, SUPERTOOL2).setItemName("chainsaw2").setIconCoord(14, 1);
		chainsaw3 = new ItemChainsaw(chainsaw3ID, SUPERTOOL3).setItemName("chainsaw3").setIconCoord(15, 1);
		aluminumPowder = new Item_Misc(aluminumPowderID).setItemName("powder").setIconCoord(10, 1);
		ironOxide = new Item_Misc(ironPowderID).setItemName("oxide").setIconCoord(9, 1);
		goldPowder = new Item_Misc(goldPowderID).setItemName("goldPowder").setIconCoord(8, 1);
		diamondDust = new Item_Misc(diamondPowderID).setItemName("diamondDust").setIconCoord(7, 1);
		thermite = new Item_Misc(thermiteID).setItemName("thermite").setIconCoord(11, 1);
		aluminumBucket = new ItemBucketAluminum(bucketID, 0).setItemName("bucket").setIconCoord(4, 1);
		aluminumBucketWater = new ItemBucketAluminum(bucketWID, Block.waterMoving.blockID).setItemName("bucketWater").setIconCoord(5, 1);
		aluminumBucketLava = new ItemBucketAluminum(bucketLID, Block.lavaMoving.blockID).setItemName("bucketLava").setIconCoord(6, 1);
		fuse = new Item_Misc(fuseID).setItemName("fuse").setIconCoord(4, 2);
		aluminumGrenade = new ItemAluminumGrenade(bombID).setItemName("grenade").setIconCoord(5, 2);
		thermiteGrenade = new ItemThermiteGrenade(fireBombID).setItemName("thermiteGrenade").setIconCoord(6, 2);
		aluminumHelmet = new ItemAluminumArmor(helmetID, ALUMINUM_ARMOR, 0, 0).setItemName("helmet").setIconCoord(0, 2);
		aluminumChest = new ItemAluminumArmor(chestID, ALUMINUM_ARMOR, 0, 1).setItemName("chest").setIconCoord(1, 2);
		aluminumLegs = new ItemAluminumArmor(legsID, ALUMINUM_ARMOR, 0, 2).setItemName("legs").setIconCoord(2, 2);
		aluminumBoots = new ItemAluminumArmor(bootsID, ALUMINUM_ARMOR, 0, 3).setItemName("boots").setIconCoord(3, 2);
		// Load
		this.setBlockHarvestLevels();
		this.registerEntities();
		this.registerBlocks();
		this.addNames();
		this.addSmelting();
		ModData.addRecipes();
		proxy.registerRenderInformation();
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			config.load();
			// Blocks
			aluminumOreID = Integer.parseInt(config.getBlock("Aluminum Ore Block ID", 190).value);
			aluminumBlockID = Integer.parseInt(config.getBlock("Aluminum Block ID", 191).value);
			landmineID = Integer.parseInt(config.getBlock("Landmine Block ID", 192).value);
			C4ID = Integer.parseInt(config.getBlock("C4 Block ID", 193).value);
			glassID = Integer.parseInt(config.getBlock("Reinforced Glass Block ID", 194).value);
			crusherActiveID = Integer.parseInt(config.getBlock("Crusher Active Block ID", 195).value);
			crusherIdleID = Integer.parseInt(config.getBlock("Crusher Inactive Block ID", 196).value);
			trapdoorID = Integer.parseInt(config.getBlock("Aluminum Trapdoor Block ID", 197).value);
			// Items
			pickID = Integer.parseInt(config.getItem("Aluminum Pickaxe Item ID", 400).value);
			shovelID = Integer.parseInt(config.getItem("Aluminum Shovel Item ID", 401).value);
			axeID = Integer.parseInt(config.getItem("Aluminum Axe Item ID", 402).value);
			hoeID = Integer.parseInt(config.getItem("Aluminum Hoe Item ID", 403).value);
			swordID = Integer.parseInt(config.getItem("Aluminum Sword Item ID", 404).value);
			aluminumOxideID = Integer.parseInt(config.getItem("Aluminum Oxide Item ID", 405).value);
			sheetID = Integer.parseInt(config.getItem("Aluminum Sheet Item ID", 406).value);
			aluminumIngotID = Integer.parseInt(config.getItem("Aluminum Ingot Item ID", 407).value);
			canID = Integer.parseInt(config.getItem("Aluminum Can Item ID", 408).value);
			canPorkID = Integer.parseInt(config.getItem("Canned Pork Item ID", 409).value);
			canFishID = Integer.parseInt(config.getItem("Canned Fish Item ID", 410).value);
			canChickenID = Integer.parseInt(config.getItem("Canned Chicken Item ID", 411).value);
			canBeefID = Integer.parseInt(config.getItem("Canned Beef Item ID", 412).value);
			battery1ID = Integer.parseInt(config.getItem("Battery 1 Item ID", 413).value);
			battery2ID = Integer.parseInt(config.getItem("Battery 2 Item ID", 414).value);
			battery3ID = Integer.parseInt(config.getItem("Battery 3 Item ID", 415).value);
			drillTipID = Integer.parseInt(config.getItem("Drill Tip Item ID", 416).value);
			drillInactiveID = Integer.parseInt(config.getItem("Drill Inactive Item ID", 417).value);
			drill1ID = Integer.parseInt(config.getItem("Drill 1 Item ID", 418).value);
			drill2ID = Integer.parseInt(config.getItem("Drill 2 Item ID", 419).value);
			drill3ID = Integer.parseInt(config.getItem("Drill 3 Item ID", 420).value);
			ehoeTipID = Integer.parseInt(config.getItem("E-Hoe Tip Item ID", 421).value);
			ehoeInactiveID = Integer.parseInt(config.getItem("E-Hoe Inactive Item ID", 422).value);
			ehoe1ID = Integer.parseInt(config.getItem("E-Hoe 1 Item ID", 423).value);
			ehoe2ID = Integer.parseInt(config.getItem("E-Hoe 2 Item ID", 424).value);
			ehoe3ID = Integer.parseInt(config.getItem("E-Hoe 3 Item ID", 425).value);
			chainsawTipID = Integer.parseInt(config.getItem("Chainsaw Tip Item ID", 426).value);
			chainsawInactiveID = Integer.parseInt(config.getItem("Chainsaw Inactive Item ID", 427).value);
			chainsaw1ID = Integer.parseInt(config.getItem("Chainsaw 1 Item ID", 428).value);
			chainsaw2ID = Integer.parseInt(config.getItem("Chainsaw 2 Item ID", 429).value);
			chainsaw3ID = Integer.parseInt(config.getItem("Chainsaw 3 Item ID", 430).value);
			aluminumPowderID = Integer.parseInt(config.getItem("Aluminum Powder Item ID", 431).value);
			ironPowderID = Integer.parseInt(config.getItem("Iron Powder Item ID", 432).value);
			thermiteID = Integer.parseInt(config.getItem("Thermite Item ID", 433).value);
			goldPowderID = Integer.parseInt(config.getItem("Gold Powder Item ID", 434).value);
			diamondPowderID = Integer.parseInt(config.getItem("Diamond Powder Item ID", 435).value);
			bucketID = Integer.parseInt(config.getItem("Aluminum Bucket Item ID", 436).value);
			bucketWID = Integer.parseInt(config.getItem("Aluminum Water Bucket Item ID", 437).value);
			bucketLID = Integer.parseInt(config.getItem("Aluminum Lava Bucket Item ID", 438).value);
			fuseID = Integer.parseInt(config.getItem("Fuse Item ID", 439).value);
			bombID = Integer.parseInt(config.getItem("Aluminum Grenade Item ID", 440).value);
			fireBombID = Integer.parseInt(config.getItem("Thermite Grenade Item ID", 441).value);
			helmetID = Integer.parseInt(config.getItem("Aluminum Helmet Item ID", 442).value);
			chestID = Integer.parseInt(config.getItem("Aluminum Chestplate Item ID", 443).value);
			legsID = Integer.parseInt(config.getItem("Aluminum Leggings Item ID", 444).value);
			bootsID = Integer.parseInt(config.getItem("Aluminum Boots Item ID", 445).value);
		} catch(Exception e)
		{
			e.printStackTrace();
		} finally
		{
			config.save();
		}
	}    

	public static void addSmelting()
	{
		GameRegistry.addSmelting(aluminumOre.blockID, new ItemStack(AluminumMod.aluminumOxide), aluminumOxideID);	
		GameRegistry.addSmelting(aluminumOxide.shiftedIndex, new ItemStack(AluminumMod.aluminumIngot), aluminumIngotID);
		GameRegistry.registerFuelHandler(new FuelHandler());
	}

	private void addNames()
	{
		// Blocks
		LanguageRegistry.addName(aluminumOre, "Bauxite Ore");
		LanguageRegistry.addName(aluminumBlock, "Aluminum Block");
		LanguageRegistry.addName(landmine, "Landmine");
		LanguageRegistry.addName(C4, "C4");
		LanguageRegistry.addName(glass, "Reinforced Glass");
		LanguageRegistry.addName(crusherIdle, "Crusher");
		LanguageRegistry.addName(crusherActive, "Crusher Active");
		LanguageRegistry.addName(trapdoor, "Aluminum Trapdoor");
		// Items
		LanguageRegistry.addName(aluminumSheet, "Aluminum Sheet");
		LanguageRegistry.addName(aluminumPick, "Aluminum Pickaxe");
		LanguageRegistry.addName(aluminumShovel, "Aluminum Shovel");
		LanguageRegistry.addName(aluminumAxe, "Aluminum Axe");
		LanguageRegistry.addName(aluminumHoe, "Aluminum Hoe");
		LanguageRegistry.addName(aluminumSword, "Aluminum Sword");
		LanguageRegistry.addName(aluminumIngot, "Aluminum Ingot");
		LanguageRegistry.addName(aluminumCan, "Aluminum Can");
		LanguageRegistry.addName(aluminumCanPork, "Canned Pork");
		LanguageRegistry.addName(aluminumCanFish, "Canned Fish");
		LanguageRegistry.addName(aluminumCanChicken, "Canned Chicken");
		LanguageRegistry.addName(aluminumCanBeef, "Canned Steak");  		
		LanguageRegistry.addName(battery1, "1.5V Battery");
		LanguageRegistry.addName(battery2, "3V Battery");
		LanguageRegistry.addName(battery3, "9V Battery");
		LanguageRegistry.addName(drill1, "\u00a7cPowered Drill");
		LanguageRegistry.addName(drill2, "\u00a7cPowered Drill");
		LanguageRegistry.addName(drill3, "\u00a76Powered Drill");
		LanguageRegistry.addName(drillInactive, "\u00a74Un-Powered Drill");
		LanguageRegistry.addName(drillTip, "Drill Tip");
		LanguageRegistry.addName(aluminumPowder, "Aluminum Powder");
		LanguageRegistry.addName(ironOxide, "Iron Oxide");
		LanguageRegistry.addName(thermite, "Thermite");
		LanguageRegistry.addName(goldPowder, "Gold Powder");
		LanguageRegistry.addName(diamondDust, "Diamond Dust");
		LanguageRegistry.addName(aluminumOxide, "Aluminum Oxide");
		LanguageRegistry.addName(fuse, "Fuse");
		LanguageRegistry.addName(aluminumGrenade, "Aluminum Grenade");
		LanguageRegistry.addName(thermiteGrenade, "Thermite Grenade");  		
		LanguageRegistry.addName(aluminumBucket, "Bucket");
		LanguageRegistry.addName(aluminumBucketWater, "Bucket of Water");
		LanguageRegistry.addName(aluminumBucketLava, "Bucket of Lava");   		     
		LanguageRegistry.addName(aluminumHelmet, "Aluminum Helmet");
		LanguageRegistry.addName(aluminumChest, "Aluminum Chestplate");
		LanguageRegistry.addName(aluminumLegs, "Aluminum Leggings");
		LanguageRegistry.addName(aluminumBoots, "Aluminum Boots");
		LanguageRegistry.addName(eHoe1, "\u00a7cPowered E-Hoe");
		LanguageRegistry.addName(eHoe2, "\u00a7cPowered E-Hoe");
		LanguageRegistry.addName(eHoe3, "\u00a76Powered E-Hoe");
		LanguageRegistry.addName(chainsaw1, "\u00a7cPowered Chainsaw");
		LanguageRegistry.addName(chainsaw2, "\u00a7cPowered Chainsaw");
		LanguageRegistry.addName(chainsaw3, "\u00a76Powered Chainsaw");
		LanguageRegistry.addName(eHoeTip, "E-Hoe Tip");
		LanguageRegistry.addName(chainsawTip, "Chainsaw Tip");
		LanguageRegistry.addName(eHoeInactive, "\u00a74Un-Powered E-Hoe");
		LanguageRegistry.addName(chainsawInactive, "\u00a74Un-Powered Chainsaw");
	}

	private void registerEntities()
	{
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		GameRegistry.registerTileEntity(TileEntityCrusher.class, "Crusher");
		EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityAluminumGrenade.class, "Aluminum Grenade", 31);
		EntityRegistry.registerGlobalEntityID(EntityThermiteGrenade.class, "Thermite Grenade", 32);
		EntityRegistry.registerGlobalEntityID(EntityC4Primed.class, "C4", 33);
		EntityRegistry.registerGlobalEntityID(EntityLandminePrimed.class, "Landmine", 34);
		EntityRegistry.registerModEntity(EntityAluminumGrenade.class, "Aluminum Grenade", 0, this, 16, 1, false);
		EntityRegistry.registerModEntity(EntityThermiteGrenade.class, "Thermite Grenade", 1, this, 16, 1, false);
		EntityRegistry.registerModEntity(EntityC4Primed.class, "C4", 2, this, 16, 1, false);
		EntityRegistry.registerModEntity(EntityLandminePrimed.class, "Landmine", 3, this, 16, 1, false);
	}

	private void registerBlocks()
	{
		GameRegistry.registerBlock(aluminumOre, "Bauxite Ore");
		GameRegistry.registerBlock(aluminumBlock, "Aluminum Block");
		GameRegistry.registerBlock(landmine, "Landmine");
		GameRegistry.registerBlock(C4, "C4");
		GameRegistry.registerBlock(glass, "Reinforced Glass");      
		GameRegistry.registerBlock(crusherIdle, "Crusher"); 
		GameRegistry.registerBlock(crusherActive, "Crusher: Active"); 
		GameRegistry.registerBlock(trapdoor, "Aluminum Trapdoor"); 
	}

	private void setBlockHarvestLevels() 
	{
		//Level 0 = Wood, Level 1 = Stone and Gold, Level 2 = Iron, Level 3 = Diamond
		MinecraftForge.setBlockHarvestLevel(aluminumOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(aluminumBlock, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(crusherActive, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(crusherIdle, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(trapdoor, "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(glass, "sword", 0);
	}
}