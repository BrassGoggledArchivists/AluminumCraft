package net.minecraft.src;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.src.forge.*;

public class mod_Aluminium extends BaseMod
{
   @MLProp public static int OreID = 190;
   @MLProp public static int BlockID = 191;
   @MLProp public static int LandmineID = 192;
   @MLProp public static int C4ID = 193;
   @MLProp public static int RGlassID = 194;
   @MLProp public static int CrusherAID = 195;
   @MLProp public static int CrusherBID = 196;
   @MLProp public static int TrapdoorID = 197;
   
   @MLProp public static int pickID = 400, shovelID = 401, axeID = 402, hoeID = 403, swordID = 404;
   @MLProp public static int aluminaID = 405, sheetID = 406, ingotID = 407;
   @MLProp public static int canID = 408, canPorkID = 409, canFishID = 410, canChickenID = 411, canBeefID = 412;
   @MLProp public static int battery1ID = 413, battery2ID = 414, battery3ID = 415;
   @MLProp public static int drillTipID = 416, drillUnactiveID = 417, drill1ID = 418, drill2ID = 419, drill3ID = 420;
   @MLProp public static int ehoeTipID = 421, ehoeUnactiveID = 422, ehoe1ID = 423, ehoe2ID = 424, ehoe3ID = 425;
   @MLProp public static int chainsawTipID = 426, chainsawUnactiveID = 427, chainsaw1ID = 428, chainsaw2ID = 429, chainsaw3ID = 430;
   @MLProp public static int aluminiumPowderID = 431, ironPowderID = 432, thermiteID = 433, goldPowderID = 434, diamondPowderID = 435;
   @MLProp public static int bucketID = 449, bucketWID = 450, bucketLID = 451;
   @MLProp public static int robotHeadID = 436, robotArmID = 437, robotBaseID = 438, robotBodyID = 439, robotTredID = 440, robotID = 441;
   @MLProp public static int fuseID = 442, bombID = 443, fireBombID = 444;
   @MLProp public static int helmetID = 445, chestID = 446, legsID = 447, bootsID = 448;
    
   static EnumToolMaterial ALUMINIUM = EnumHelper.addToolMaterial("ALUMINIUM", 1, 200, 5F, 4, 4);
   static EnumToolMaterial SUPERTOOL1 = EnumHelper.addToolMaterial("SUPERTOOL1", 4, 2000, 14F, 8, 35);
   static EnumToolMaterial SUPERTOOL2 = EnumHelper.addToolMaterial("SUPERTOOL2", 5, 2500, 23F, 10, 45);
   static EnumToolMaterial SUPERTOOL3 = EnumHelper.addToolMaterial("SUPERTOOL3", 6, 3000, 30F, 12, 55);
   static EnumArmorMaterial ALUMINIUM_ARMOR = EnumHelper.addArmorMaterial("ALUMINIUM_ARMOR",  4, new int[] {2, 5, 4, 1}, 12);
    
   public static final Block AluminiumOre = new ALBlockAluminiumOre(OreID, 0).setHardness(3.5F).setResistance(2.0F).setBlockName("aluminiunOre");
   public static final Block Aluminium = new ALBlockAluminium(BlockID, 1).setHardness(2.734F).setResistance(5.0F).setBlockName("aluminiumBlock");
   public static final Block Landmine = new ALBlockLandmine(LandmineID, 2).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("smallbomb");
   public static final Block C4 = new ALBlockC4(C4ID, 5).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("C4");
   public static final Block RGlass = new ALBlockRGlass(RGlassID, 13, Material.glass, false).setHardness(5.0F).setResistance(2000.0F).setStepSound(Block.soundGlassFootstep).setBlockName("rGlass");
   public static final Block CrusherIdle = new ALBlockCrusher(CrusherAID, 8, false).setHardness(2.5F).setResistance(2.0F).setStepSound(Block.soundStoneFootstep).setBlockName("idle").setRequiresSelfNotify();; 
   public static final Block CrusherActive = new ALBlockCrusher(CrusherBID, 8, true).setLightValue(1.0F).setHardness(2.5F).setResistance(2.0F).setStepSound(Block.soundStoneFootstep).setBlockName("active").setRequiresSelfNotify();; 
   public static final Block AluminiumTrapdoor = new ALBlockAluminiumTrapdoor(TrapdoorID, 12, Material.iron).setStepSound(Block.soundMetalFootstep).setHardness(3.14F).setResistance(2000.0F).setBlockName("trapdoor");

   public static boolean areBlocksAdded;
             
   public static final Item aluminiumPick = new ALItemAluminiumPickaxe(pickID, ALUMINIUM).setItemName("pickaxe").setIconCoord(0, 0);
   public static final Item aluminiumShovel = new ALItemAluminiumSpade(shovelID, ALUMINIUM).setItemName("shovel").setIconCoord(1, 0);
   public static final Item aluminiumAxe = new ALItemAluminiumAxe(axeID, ALUMINIUM).setItemName("axe").setIconCoord(2, 0);
   public static final Item aluminiumHoe = new ALItemAluminiumHoe(hoeID, ALUMINIUM).setItemName("hoe").setIconCoord(3, 0);
   public static final Item aluminiumSword = new ALItemAluminiumSword(swordID, ALUMINIUM).setItemName("sword").setIconCoord(0, 1);
   
   public static final Item alumina = new ALItem(aluminaID).setItemName("alumina").setIconCoord(4, 3);
   public static final Item aluminiumSheet = new ALItem(sheetID).setItemName("sheet").setIconCoord(6, 3);
   public static final Item aluminiumIngot = new ALItem(ingotID).setItemName("ingot").setIconCoord(5, 3);
   
   public static final Item aluminiumCan = new ALItem(canID).setItemName("can").setIconCoord(7, 0);
   public static final Item aluminiumCanPork = new ALItemCanFood(canPorkID, 12).setItemName("canPork").setIconCoord(11, 0).setContainerItem(aluminiumCan);
   public static final Item aluminiumCanFish = new ALItemCanFood(canFishID, 10).setItemName("canFish").setIconCoord(10, 0).setContainerItem(aluminiumCan);
   public static final Item aluminiumCanChicken = new ALItemCanFood(canChickenID, 10).setItemName("canChicken").setIconCoord(9, 0).setContainerItem(aluminiumCan);
   public static final Item aluminiumCanBeef = new ALItemCanFood(canBeefID, 12).setItemName("canBeef").setIconCoord(8, 0).setContainerItem(aluminiumCan);
   
   public static final Item battery1 = new ALItem(battery1ID).setItemName("battery1").setIconCoord(4, 0);
   public static final Item battery2 = new ALItem(battery2ID).setItemName("battery2").setIconCoord(5, 0);
   public static final Item battery3 = new ALItem(battery3ID).setItemName("battery3").setIconCoord(6, 0);
   
   public static final Item drillTip = new ALItem(drillTipID).setItemName("drilltip").setIconCoord(4, 4);
   public static final Item drill1 = new ALItemDrill(drill1ID, SUPERTOOL1).setItemName("drill").setIconCoord(13, 0);
   public static final Item drill2 = new ALItemDrill(drill2ID, SUPERTOOL2).setItemName("drill2").setIconCoord(14, 0);
   public static final Item drill3 = new ALItemDrill(drill3ID, SUPERTOOL3).setItemName("drill3").setIconCoord(15, 0);
   public static final Item drillUnactive = new ALItem(drillUnactiveID).setItemName("drillunactive").setIconCoord(12, 0);
   
   public static final Item eHoeTip = new ALItem(ehoeTipID).setItemName("ehoetip").setIconCoord(6, 4);
   public static final Item eHoeUnactive = new ALItem(ehoeUnactiveID).setItemName("ehoeunactive").setIconCoord(12, 2);
   public static final Item eHoe1 = new ALItemEHoe(ehoe1ID, SUPERTOOL1).setItemName("eHoe1").setIconCoord(13, 2);
   public static final Item eHoe2 = new ALItemEHoe(ehoe2ID, SUPERTOOL2).setItemName("eHoe2").setIconCoord(14, 2);
   public static final Item eHoe3 = new ALItemEHoe(ehoe3ID, SUPERTOOL3).setItemName("eHoe3").setIconCoord(15, 2);
   
   public static final Item chainsawTip = new ALItem(chainsawTipID).setItemName("chainsawtip").setIconCoord(5, 4);
   public static final Item chainsawUnactive = new ALItem(chainsawUnactiveID).setItemName("chainsawunactive").setIconCoord(12, 1);
   public static final Item chainsaw1 = new ALItemChainsaw(chainsaw1ID, SUPERTOOL1).setItemName("chainsaw1").setIconCoord(13, 1);
   public static final Item chainsaw2 = new ALItemChainsaw(chainsaw2ID, SUPERTOOL2).setItemName("chainsaw2").setIconCoord(14, 1);
   public static final Item chainsaw3 = new ALItemChainsaw(chainsaw3ID, SUPERTOOL3).setItemName("chainsaw3").setIconCoord(15, 1);
   
   public static final Item aluminiumPowder = new ALItem(aluminiumPowderID).setItemName("powder").setIconCoord(10, 1);
   public static final Item ironOxide = new ALItem(ironPowderID).setItemName("oxide").setIconCoord(9, 1);
   public static final Item goldPowder = new ALItem(goldPowderID).setItemName("goldPowder").setIconCoord(8, 1);
   public static final Item diamondDust = new ALItem(diamondPowderID).setItemName("diamondDust").setIconCoord(7, 1);
   public static final Item thermite = new ALItem(thermiteID).setItemName("thermite").setIconCoord(11, 1);

   public static final Item aluminiumBucket = new ALItemBucketAluminium(bucketID, 0).setItemName("bucket").setIconCoord(4, 1);
   public static final Item aluminiumBucketWater = new ALItemBucketAluminium(bucketWID, Block.waterMoving.blockID).setItemName("bucketWater").setIconCoord(5, 1);
   public static final Item aluminiumBucketLava = new ALItemBucketAluminium(bucketLID, Block.lavaMoving.blockID).setItemName("bucketLava").setIconCoord(6, 1);
   
   public static final Item robotHead = new ALItem(robotHeadID).setItemName("robotHead").setIconCoord(10, 2);
   public static final Item robotArm = new ALItem(robotArmID).setItemName("robotArm").setIconCoord(7, 2);
   public static final Item robotBody = new ALItem(robotBodyID).setItemName("robotBody").setIconCoord(9, 2);
   public static final Item robotBase = new ALItem(robotBaseID).setItemName("robotBase").setIconCoord(8, 2);
   public static final Item robotTred = new ALItem(robotTredID).setItemName("robotTred").setIconCoord(11, 2);
   public static final Item robot = new ALItemRobot(robotID).setItemName("robot").setIconCoord(7, 3);
   
   public static final Item fuse = new ALItem(fuseID).setItemName("fuse").setIconCoord(4, 2);
   public static final Item aluminiumGrenade = new ALItemAluminiumGrenade(bombID).setItemName("grenade").setIconCoord(5, 2);
   public static final Item thermiteGrenade = new ALItemThermiteGrenade(fireBombID).setItemName("thermiteGrenade").setIconCoord(6, 2);
   
   public static final Item aluminiumHelmet = new ALItemAluminiumArmor(helmetID, ALUMINIUM_ARMOR, 5, 0).setItemName("Helmet").setIconCoord(0, 2);
   public static final Item aluminiumChest = new ALItemAluminiumArmor(chestID, ALUMINIUM_ARMOR, 5, 1).setItemName("Chest").setIconCoord(1, 2);
   public static final Item aluminiumLegs = new ALItemAluminiumArmor(legsID, ALUMINIUM_ARMOR, 5, 2).setItemName("Legs").setIconCoord(2, 2);
   public static final Item aluminiumBoots = new ALItemAluminiumArmor(bootsID, ALUMINIUM_ARMOR, 5, 3).setItemName("Boots").setIconCoord(3, 2);

   public static final Achievement achMakeDrill = new Achievement(3450, "achMakeDrill", 8, 4, drill3, null).setSpecial().registerAchievement();

   public void load() 
   {
       
        MinecraftForge.setBlockHarvestLevel(AluminiumOre, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(Aluminium, "pickaxe", 0);
        MinecraftForge.setBlockHarvestLevel(CrusherActive, "pickaxe", 0);
        MinecraftForge.setBlockHarvestLevel(CrusherIdle, "pickaxe", 0);
        MinecraftForge.setBlockHarvestLevel(AluminiumTrapdoor, "pickaxe", 0);
        MinecraftForge.setBlockHarvestLevel(RGlass, "sword", 0);
       
        MinecraftForgeClient.preloadTexture("/Aluminium Mod/Blocks/terrain.png");
        MinecraftForgeClient.preloadTexture("/Aluminium Mod/Items/items.png");
       
        ModLoader.RegisterEntityID(ALEntityRobot.class, "Robot", ModLoader.getUniqueEntityId()); 
        ModLoader.RegisterEntityID(ALEntityRobotTame.class, "RobotTame", ModLoader.getUniqueEntityId()); 
                
        ModLoader.AddSpawn(ALEntityRobot.class, 1, 2, 3, EnumCreatureType.monster);

        ModLoader.RegisterTileEntity(net.minecraft.src.ALTileEntityCrusher.class, "Crusher");

        ModLoader.RegisterBlock(AluminiumOre);
        ModLoader.RegisterBlock(Aluminium);
        ModLoader.RegisterBlock(Landmine);
        ModLoader.RegisterBlock(C4);
        ModLoader.RegisterBlock(RGlass);      
        ModLoader.RegisterBlock(CrusherIdle); 
        ModLoader.RegisterBlock(CrusherActive); 
        ModLoader.RegisterBlock(AluminiumTrapdoor); 
                
        ModLoader.SetInGUIHook(this, true, true);
	ModLoader.SetInGameHook(this, true, true);
		
	ModLoader.AddAchievementDesc(achMakeDrill, "Time to Mine with Drills", "Craft and power a drill!");     
        
   	ModLoader.AddName(AluminiumOre, "Bauxite");
   	ModLoader.AddName(Aluminium, "Block of Aluminium");
   	ModLoader.AddName(Landmine, "Landmine");
   	ModLoader.AddName(C4, "C4");
   	ModLoader.AddName(RGlass, "Reinforced Glass");
        ModLoader.AddName(CrusherIdle, "Crusher");
        ModLoader.AddName(CrusherActive, "Crusher");
        ModLoader.AddName(AluminiumTrapdoor, "AluminiumTrapdoor");
   		
   	ModLoader.AddName(aluminiumSheet, "Aluminium Sheet");
   	ModLoader.AddName(aluminiumPick, "Aluminium Pickaxe");
   	ModLoader.AddName(aluminiumShovel, "Aluminium Shovel");
   	ModLoader.AddName(aluminiumAxe, "Aluminium Axe");
   	ModLoader.AddName(aluminiumHoe, "Aluminium Hoe");
   	ModLoader.AddName(aluminiumSword, "Aluminium Sword");
   	ModLoader.AddName(aluminiumIngot, "Aluminium Ingot");
   	ModLoader.AddName(aluminiumCan, "Can");
   	ModLoader.AddName(aluminiumCanPork, "Canned Pork");
   	ModLoader.AddName(aluminiumCanFish, "Canned Fish");
   	ModLoader.AddName(aluminiumCanChicken, "Canned Chicken");
   	ModLoader.AddName(aluminiumCanBeef, "Canned Steak");  		
   	ModLoader.AddName(battery1, "1.5V Battery");
        ModLoader.AddName(battery2, "3V Battery");
        ModLoader.AddName(battery3, "9V Battery");
   	ModLoader.AddName(drill1, "\u00a7cPowered Drill");
        ModLoader.AddName(drill2, "\u00a7cPowered Drill");
        ModLoader.AddName(drill3, "\u00a76Powered Drill");
   	ModLoader.AddName(drillUnactive, "\u00a74Un-Powered Drill");
   	ModLoader.AddName(drillTip, "Drill Tip");
   	ModLoader.AddName(aluminiumPowder, "Aluminium Powder");
   	ModLoader.AddName(ironOxide, "Iron Oxide");
   	ModLoader.AddName(thermite, "Thermite");
        ModLoader.AddName(goldPowder, "Gold Powder");
        ModLoader.AddName(diamondDust, "Diamond Dust");
   	ModLoader.AddName(alumina, "Aluminium Oxide");
        ModLoader.AddName(fuse, "Fuse");
        ModLoader.AddName(aluminiumGrenade, "Bomb");
        ModLoader.AddName(thermiteGrenade, "Thermite Bomb");  		
   	ModLoader.AddName(aluminiumBucket, "Bucket");
   	ModLoader.AddName(aluminiumBucketWater, "Bucket of Water");
   	ModLoader.AddName(aluminiumBucketLava, "Bucket of Lava");   		
   	ModLoader.AddName(robotHead, "Robot Head");
   	ModLoader.AddName(robotArm, "Robot Arm");
   	ModLoader.AddName(robotBody, "Robot Body");
   	ModLoader.AddName(robotBase, "Robot Base");
   	ModLoader.AddName(robotTred, "Tred");
   	ModLoader.AddName(robot, "Robot");      
        ModLoader.AddName(aluminiumHelmet, "Aluminium Helmet");
        ModLoader.AddName(aluminiumChest, "Aluminium Chestplate");
        ModLoader.AddName(aluminiumLegs, "Aluminium Leggings");
        ModLoader.AddName(aluminiumBoots, "Aluminium Boots");
        
        ModLoader.AddName(eHoe1, "\u00a7cPowered E-Hoe");
        ModLoader.AddName(eHoe2, "\u00a7cPowered E-Hoe");
        ModLoader.AddName(eHoe3, "\u00a76Powered E-Hoe");
        
        
        ModLoader.AddName(chainsaw1, "\u00a7cPowered Chainsaw");
        ModLoader.AddName(chainsaw2, "\u00a7cPowered Chainsaw");
        ModLoader.AddName(chainsaw3, "\u00a76Powered Chainsaw");
        
        ModLoader.AddName(eHoeTip, "E-Hoe Tip");
        ModLoader.AddName(chainsawTip, "Chainsaw Tip");
   
        ModLoader.AddName(eHoeUnactive, "\u00a74Un-Powered E-Hoe");
        ModLoader.AddName(chainsawUnactive, "\u00a74Un-Powered Chainsaw");
        
        ModLoader.AddRecipe(new ItemStack(drillTip, 1), new Object[] {
   			"XXX", "XX ", "X X", Character.valueOf('X'), Item.diamond
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumHelmet, 1), new Object[] {
   			"XXX", "X X", Character.valueOf('X'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumChest, 1), new Object[] {
   			"X X", "XXX", "XXX", Character.valueOf('X'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumLegs, 1), new Object[] {
   			"XXX", "X X", "X X", Character.valueOf('X'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumBoots, 1), new Object[] {
   			"X X", "X X", Character.valueOf('X'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(drillUnactive, 1), new Object[] {
   			"DIR", " IR", "  I", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('D'), mod_Aluminium.drillTip, Character.valueOf('R'), Item.redstone
   		});
        ModLoader.AddRecipe(new ItemStack(RGlass, 4), new Object[] {
   			"IGI", "GGG", "IGI", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('G'), Block.glass
   		});
        ModLoader.AddRecipe(new ItemStack(Landmine, 1), new Object[] {
   			" D ", "III", "RRR", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('D'), Block.pressurePlateStone, Character.valueOf('R'), mod_Aluminium.aluminiumPowder
   		}); 
        ModLoader.AddRecipe(new ItemStack(C4, 1), new Object[] {
   			"IPI", "PTP", "IPI", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('T'), Block.tnt, Character.valueOf('P'), mod_Aluminium.aluminiumPowder
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumPick, 1), new Object[] {
            "XXX", " | ", " | ", Character.valueOf('X'), mod_Aluminium.aluminiumIngot, Character.valueOf('|'), Item.stick
                });
        ModLoader.AddRecipe(new ItemStack(Aluminium, 1), new Object[] {
            "XXX", "XXX", "XXX", Character.valueOf('X'), mod_Aluminium.aluminiumIngot
                });
        ModLoader.AddRecipe(new ItemStack(aluminiumIngot, 9), new Object[] {
            "X", Character.valueOf('X'), mod_Aluminium.Aluminium
                });
        ModLoader.AddRecipe(new ItemStack(aluminiumShovel, 1), new Object[] {
            " X ", " | ", " | ", Character.valueOf('X'), mod_Aluminium.aluminiumIngot, Character.valueOf('|'), Item.stick
                });
        ModLoader.AddRecipe(new ItemStack(aluminiumAxe, 1), new Object[] {
            "XX ", "X| ", " | ", Character.valueOf('X'), mod_Aluminium.aluminiumIngot, Character.valueOf('|'), Item.stick
                });
        ModLoader.AddRecipe(new ItemStack(aluminiumHoe, 1), new Object[] {
            "XX ", " | ", " | ", Character.valueOf('X'), mod_Aluminium.aluminiumIngot, Character.valueOf('|'), Item.stick
                });
        ModLoader.AddRecipe(new ItemStack(aluminiumSword, 1), new Object[] {
            " X ", " X ", " | ", Character.valueOf('X'), mod_Aluminium.aluminiumIngot, Character.valueOf('|'), Item.stick
                });
        ModLoader.AddRecipe(new ItemStack(aluminiumSheet, 6), new Object[] {
            "###", Character.valueOf('#'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumCan, 1), new Object[] {
            "X X", "X X", "XXX", Character.valueOf('X'), mod_Aluminium.aluminiumSheet
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumCanPork, 1), new Object[] {
            "X", "#", Character.valueOf('#'), mod_Aluminium.aluminiumCan, Character.valueOf('X'), Item.porkCooked
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumCanFish, 1), new Object[] {
            "X", "#", Character.valueOf('#'), mod_Aluminium.aluminiumCan, Character.valueOf('X'), Item.fishCooked
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumCanChicken, 1), new Object[] {
            "X", "#", Character.valueOf('#'), mod_Aluminium.aluminiumCan, Character.valueOf('X'), Item.chickenCooked
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumCanBeef, 1), new Object[] {
            "X", "#", Character.valueOf('#'), mod_Aluminium.aluminiumCan, Character.valueOf('X'), Item.beefCooked
   		});
        ModLoader.AddRecipe(new ItemStack(robot, 1), new Object[] {
            " H ", "ABA", "TST", Character.valueOf('H'), mod_Aluminium.robotHead, Character.valueOf('A'), mod_Aluminium.robotArm, Character.valueOf('B'), mod_Aluminium.robotBody, Character.valueOf('S'), mod_Aluminium.robotBase, Character.valueOf('T'), mod_Aluminium.robotTred
   		});
        ModLoader.AddRecipe(new ItemStack(battery1, 1), new Object[] {
            "X$X", "X@X", "X$X", Character.valueOf('X'), mod_Aluminium.aluminiumSheet, Character.valueOf('@'), Item.redstone, Character.valueOf('$'), Item.ingotIron,
   		});
        ModLoader.AddRecipe(new ItemStack(battery2, 1), new Object[] {
            "X$X", "X@X", "X$X", Character.valueOf('X'), mod_Aluminium.aluminiumSheet, Character.valueOf('@'), Item.redstone, Character.valueOf('$'), mod_Aluminium.aluminiumIngot,
   		});
        ModLoader.AddRecipe(new ItemStack(battery3, 1), new Object[] {
            "X$X", "X@X", "X$X", Character.valueOf('X'), mod_Aluminium.aluminiumSheet, Character.valueOf('@'), mod_Aluminium.goldPowder, Character.valueOf('$'), Item.ingotGold,
   		});
        ModLoader.AddRecipe(new ItemStack(robotHead, 1), new Object[] {
            "SSS", "SLS", "SRS", Character.valueOf('S'), mod_Aluminium.aluminiumSheet, Character.valueOf('R'), Item.redstone, Character.valueOf('L'), new ItemStack(Item.dyePowder, 1, 4)
   		});
        ModLoader.AddRecipe(new ItemStack(robotArm, 1), new Object[] {
            "I  ", " S ", "  S", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('S'), mod_Aluminium.aluminiumSheet
   		});
        ModLoader.AddRecipe(new ItemStack(robotArm, 2), new Object[] {
            "S  ", " S ", "  I", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('S'), mod_Aluminium.aluminiumSheet
   		});
        ModLoader.AddRecipe(new ItemStack(robotBody, 1), new Object[] {
            "SRS", "SBS", "SRS", Character.valueOf('S'), mod_Aluminium.aluminiumSheet, Character.valueOf('B'), mod_Aluminium.battery3, Character.valueOf('R'), Item.redstone 
   		});
        ModLoader.AddRecipe(new ItemStack(robotBase, 1), new Object[] {
            "SRS", "RRR", "SSS", Character.valueOf('S'), mod_Aluminium.aluminiumSheet, Character.valueOf('R'), Item.redstone 
   		});
        ModLoader.AddRecipe(new ItemStack(robotBase, 1), new Object[] {
            "SRS", "RRR", "SSS", Character.valueOf('S'), mod_Aluminium.aluminiumSheet, Character.valueOf('R'), Item.redstone 
   		});
        ModLoader.AddRecipe(new ItemStack(robotTred, 1), new Object[] {
            " S ", "SRS", " S ", Character.valueOf('S'), mod_Aluminium.aluminiumSheet, Character.valueOf('R'), Item.redstone 
   		});
        ModLoader.AddRecipe(new ItemStack(aluminiumBucket, 1), new Object[] {
            "I I", " I ", Character.valueOf('I'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(Item.shears, 1), new Object[] {
            "I ", " I", Character.valueOf('I'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(Item.shears, 1), new Object[] {
            " I", "I ", Character.valueOf('I'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddRecipe(new ItemStack(mod_Aluminium.CrusherIdle, 1), new Object[] {
            "IXI", "IPI", "III", Character.valueOf('I'), Block.cobblestone, Character.valueOf('X'), Item.redstone, Character.valueOf('P'), Block.pistonBase
   		});
        ModLoader.AddRecipe(new ItemStack(mod_Aluminium.aluminiumGrenade, 1), new Object[] {
            " X ", "IAI", "IAI", Character.valueOf('I'), mod_Aluminium.aluminiumSheet, Character.valueOf('X'), mod_Aluminium.fuse, Character.valueOf('A'), mod_Aluminium.aluminiumPowder
   		});
        ModLoader.AddRecipe(new ItemStack(mod_Aluminium.thermiteGrenade, 1), new Object[] {
            " X ", "IAI", "IAI", Character.valueOf('I'), mod_Aluminium.aluminiumSheet, Character.valueOf('X'), mod_Aluminium.fuse, Character.valueOf('A'), mod_Aluminium.thermite
   		});
        ModLoader.AddRecipe(new ItemStack(mod_Aluminium.AluminiumTrapdoor, 2), new Object[] {
            "III", "III", Character.valueOf('I'), mod_Aluminium.aluminiumIngot
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(drill1, 1), new Object[] {
            mod_Aluminium.battery1, new ItemStack(drill1, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(drill2, 1), new Object[] {
            mod_Aluminium.battery2, new ItemStack(drill2, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(drill3, 1), new Object[] {
            mod_Aluminium.battery3, new ItemStack(drill3, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(drill1, 1), new Object[] {
            mod_Aluminium.battery1, mod_Aluminium.drillUnactive
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(drill2, 1), new Object[] {
            mod_Aluminium.battery2, mod_Aluminium.drillUnactive
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(drill3, 1), new Object[] {
            mod_Aluminium.battery3, mod_Aluminium.drillUnactive
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(fuse, 2), new Object[] {
            Item.silk, mod_Aluminium.thermite
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(thermite, 1), new Object[] {
            mod_Aluminium.aluminiumPowder, mod_Aluminium.ironOxide
                });
        ModLoader.AddRecipe(new ItemStack(eHoeUnactive, 1), new Object[] {
            "DIR", " IR", "  I", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('D'), mod_Aluminium.eHoeTip, Character.valueOf('R'), Item.redstone
   		});
        ModLoader.AddRecipe(new ItemStack(eHoeTip, 1), new Object[] {
            "  X", "XXX", "X  ", Character.valueOf('X'), Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(eHoe1, 1), new Object[] {
            mod_Aluminium.battery1, new ItemStack(eHoe1, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(eHoe2, 1), new Object[] {
            mod_Aluminium.battery2, new ItemStack(eHoe2, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(eHoe3, 1), new Object[] {
            mod_Aluminium.battery3, new ItemStack(eHoe3, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(eHoe1, 1), new Object[] {
            mod_Aluminium.battery1, mod_Aluminium.eHoeUnactive
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(eHoe2, 1), new Object[] {
            mod_Aluminium.battery2, mod_Aluminium.eHoeUnactive
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(eHoe3, 1), new Object[] {
            mod_Aluminium.battery3, mod_Aluminium.eHoeUnactive
   		});
        ModLoader.AddRecipe(new ItemStack(chainsawUnactive, 1), new Object[] {
            "D I", " IR", "IR ", Character.valueOf('I'), mod_Aluminium.aluminiumIngot, Character.valueOf('D'), mod_Aluminium.chainsawTip, Character.valueOf('R'), Item.redstone
   		});
        ModLoader.AddRecipe(new ItemStack(chainsawTip, 1), new Object[] {
            "XX ", "XX ", "  X", Character.valueOf('X'), Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(chainsaw1, 1), new Object[] {
            mod_Aluminium.battery1, new ItemStack(chainsaw1, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(chainsaw2, 1), new Object[] {
            mod_Aluminium.battery2, new ItemStack(chainsaw2, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(chainsaw3, 1), new Object[] {
            mod_Aluminium.battery3, new ItemStack(chainsaw3, 1, -1), mod_Aluminium.aluminiumIngot, Item.diamond
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(chainsaw1, 1), new Object[] {
            mod_Aluminium.battery1, mod_Aluminium.chainsawUnactive
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(chainsaw2, 1), new Object[] {
            mod_Aluminium.battery2, mod_Aluminium.chainsawUnactive
   		});
        ModLoader.AddShapelessRecipe(new ItemStack(chainsaw3, 1), new Object[] {
            mod_Aluminium.battery3, mod_Aluminium.chainsawUnactive
   		});
        
        ModLoader.SetInGameHook(this, true, false);
   
        ModLoader.AddSmelting (
                AluminiumOre.blockID, new ItemStack(mod_Aluminium.alumina
                ));	
        ModLoader.AddSmelting (
                alumina.shiftedIndex, new ItemStack(mod_Aluminium.aluminiumIngot
                ));
        
    }

    public boolean OnTickInGame(float f, Minecraft minecraft)
    {
        if(minecraft.currentScreen == null)
        {
            areBlocksAdded = false;
        } 
        return true;
    }
   
    public boolean OnTickInGUI(float f, Minecraft minecraft, GuiScreen guiscreen)
    {
        if((guiscreen instanceof GuiContainerCreative) && !minecraft.theWorld.isRemote)
        {
            if(areBlocksAdded == false)
            {
            Container container = ((GuiContainer)guiscreen).inventorySlots;
            List list = ((ContainerCreative)container).itemList;

                list.add(new ItemStack(AluminiumOre));
                list.add(new ItemStack(Aluminium));
                list.add(new ItemStack(Landmine));
                list.add(new ItemStack(C4));
                list.add(new ItemStack(RGlass));
                list.add(new ItemStack(CrusherIdle));
                list.add(new ItemStack(AluminiumTrapdoor));

            }
            areBlocksAdded = true;
        }
        return true;
    }
    
    public void TakenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
    {
        if(itemstack.itemID == drill1.shiftedIndex || itemstack.itemID == drill2.shiftedIndex || itemstack.itemID == drill3.shiftedIndex)
        {
                entityplayer.addStat(achMakeDrill, 1);
        }
    }

    public void AddRenderer(Map map) 
    { 
        map.put(ALEntityLandminePrimed.class, new ALRenderLandminePrimed());
        map.put(ALEntityC4Primed.class, new ALRenderC4Primed());
        map.put(net.minecraft.src.ALEntityAluminiumGrenade.class, new ALRenderAluminiumGrenade(mod_Aluminium.aluminiumGrenade.getIconFromDamage(0)));
        map.put(net.minecraft.src.ALEntityThermiteGrenade.class, new ALRenderThermiteGrenade(mod_Aluminium.thermiteGrenade.getIconFromDamage(0)));
        map.put(ALEntityRobot.class, new ALRenderRobot(new ALModelRobot(), 0.5F)); 
        map.put(ALEntityRobotTame.class, new ALRenderRobot(new ALModelRobot(), 0.5F)); 
    } 
   
    public int AddFuel(int i, int j)
    {
        if(i == mod_Aluminium.aluminiumBucketLava.shiftedIndex) 
        {                       
            return 20000;
        }
        if(i == mod_Aluminium.thermite.shiftedIndex)
        {
            return 6400;
        }
        return 0;
    }      
    
    public void GenerateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        for(int i = 0; i < 8; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(62);
            int randPosZ = chunkZ + rand.nextInt(16);
            (new WorldGenMinable(mod_Aluminium.AluminiumOre.blockID, 8)).generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }
    
    public String getVersion() 
    {
        return "Aluminium Mod v3.0";
    }

}   