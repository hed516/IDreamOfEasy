package me.bunnky.idreamofeasy.slimefun.setup;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import lombok.experimental.UtilityClass;
import me.bunnky.idreamofeasy.IDreamOfEasy;
import me.bunnky.idreamofeasy.slimefun.items.BiomeCompass;
import me.bunnky.idreamofeasy.slimefun.items.idols.TerranIdol;
import me.bunnky.idreamofeasy.slimefun.items.idols.FlameheartIdol;
import me.bunnky.idreamofeasy.slimefun.items.Jawn;
import me.bunnky.idreamofeasy.slimefun.items.LavaBoat;
import me.bunnky.idreamofeasy.slimefun.items.Magnetoid;
import me.bunnky.idreamofeasy.slimefun.items.idols.DivineIdol;
import me.bunnky.idreamofeasy.slimefun.items.idols.TorrentIdol;
import me.bunnky.idreamofeasy.slimefun.machines.PlayerHopper;
import me.bunnky.idreamofeasy.slimefun.machines.StackDispenser;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.BatRepeller;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.CreeperRepeller;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.EndermanRepeller;
import me.bunnky.idreamofeasy.slimefun.items.TrimVault;
import me.bunnky.idreamofeasy.slimefun.items.WisterShears;
import me.bunnky.idreamofeasy.slimefun.machines.multiblock.AdvancedTerrabore;
import me.bunnky.idreamofeasy.slimefun.machines.ElectricBlastFurnace;
import me.bunnky.idreamofeasy.slimefun.machines.ElectricLogStripper;
import me.bunnky.idreamofeasy.slimefun.machines.ElectricSmoker;
import me.bunnky.idreamofeasy.slimefun.machines.multiblock.EliteTerrabore;
import me.bunnky.idreamofeasy.slimefun.machines.RadiationAbsorber;
import me.bunnky.idreamofeasy.slimefun.machines.multiblock.Terrabore;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.SkeletonRepeller;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.SlimeRepeller;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.SpiderRepeller;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.WitchRepeller;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.ZombieRepeller;
import me.bunnky.idreamofeasy.slimefun.machines.repellers.ZombieVillagerRepeller;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@UtilityClass
public class Setup {
    private static final String TRIM_VAULT = "9d6f99f3c5d982ebde8da657d0652aa08064bf6d6b495fda23c6e47123c093e7";
    private static final String REPELLER = "10892dff2ad75e47b08bf637d8dd2d10ed767f80b8144d5eda5db4d2e18614d8";

    public static void setup() {

        IDreamOfEasy plugin = IDreamOfEasy.getInstance();

        ItemStack groupItem = new CustomItemStack(Material.CALIBRATED_SCULK_SENSOR, "&2I Dream of Easy", "", "I wish this worked!");
        NamespacedKey groupId = new NamespacedKey(IDreamOfEasy.getInstance(), "i_dream_of_easy");
        ItemGroup group = new ItemGroup(groupId, groupItem);

        //########################
        //  ITEMS
        //########################

        //////////////////////////////////////////////
        //////////////// MULTIBLOCK //////////////////
        //////////////////////////////////////////////

        SlimefunItemStack terrabore = new SlimefunItemStack(
            "IDOE_TERRABORE",
            Material.NETHERITE_SHOVEL,
            "&eTerrabore",
            "",
            "&fThis Multiblock will mine",
            "&ceverything &fin a 7x7 area",
            "&funderneath it.",
            "&fPlace coal or similar in its",
            "&fchest to fuel this machine.",
            ""
        );

        SlimefunItemStack terraboreAdvanced = new SlimefunItemStack(
            "IDOE_TERRABORE_ADVANCED",
            Material.NETHERITE_PICKAXE,
            "&eAdvanced Terrabore",
            "",
            "&fThis Multiblock will mine",
            "&ceverything except ores &fin",
            "&fa 11x11 area underneath it.",
            "&fPlace a bucket of fuel or lava in",
            "&fits chest to fuel this machine.",
            "",
            "&a+ Silk Touch"
        );

        SlimefunItemStack terraboreElite = new SlimefunItemStack(
            "IDOE_TERRABORE_ELITE",
            Material.NETHERITE_BLOCK,
            "&eAdvanced Terrabore",
            "",
            "&fThis Multiblock will mine",
            "&ceverything &fin a 21x21 area",
            "&funderneath it.",
            "&fPlace &auranium &fin its chest",
            "&fto fuel this machine.",
            "",
            "&a+ Silk Touch"
        );

        //////////////////////////////////////////////
        ///////////////// MACHINES ///////////////////
        //////////////////////////////////////////////
        SlimefunItemStack playerHopper = new SlimefunItemStack(
            "IDOE_HOPPER_PLAYER",
            Material.HOPPER,
            "&aPlayer Hopper",
            "",
            "&fStand on this to automatically",
            "&fpull items out of your inventory",
            "",
            "&8⇨ &4Ignores equipped items!",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(250)
        );

        SlimefunItemStack stackDispenser = new SlimefunItemStack(
            "IDOE_DISPENSER_STACK",
            Material.DISPENSER,
            "&aStack Dispenser",
            "",
            "&fTries to dispense whole",
            "&fstacks",
            ""
        );

        SlimefunItemStack radiationAbsorber = new SlimefunItemStack(
            "IDOE_RADIATION_ABSORBER",
            Material.GREEN_CONCRETE,
            "&aRadiation Absorber",
            "",
            LoreBuilder.range(2),
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(250)
        );

        SlimefunItemStack radiationAbsorber2 = new SlimefunItemStack(
            "IDOE_RADIATION_ABSORBER_2",
            Material.LIME_CONCRETE,
            "&aRadiation Absorber &7(&eII&7)",
            "",
            LoreBuilder.range(4),
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(750)
        );

        SlimefunItemStack radiationAbsorber3 = new SlimefunItemStack(
            "IDOE_RADIATION_ABSORBER_3",
            Material.SLIME_BLOCK,
            "&aRadiation Absorber &7(&eIII&7)",
            "",
            LoreBuilder.range(7),
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(1800)
        );

        SlimefunItemStack electricBlastFurnace = new SlimefunItemStack(
            "IDOE_ELECTRIC_BLASTFURNACE",
            Material.BLAST_FURNACE,
            "&aElectric Blast Furnace",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            LoreBuilder.speed(2),
            LoreBuilder.powerPerSecond(48)
        );

        SlimefunItemStack electricBlastFurnace2 = new SlimefunItemStack(
            "IDOE_ELECTRIC_BLASTFURNACE_2",
            Material.BLAST_FURNACE,
            "&aElectric Blast Furnace &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(80)
        );

        SlimefunItemStack electricBlastFurnace3 = new SlimefunItemStack(
            "IDOE_ELECTRIC_BLASTFURNACE_3",
            Material.BLAST_FURNACE,
            "&aElectric Blast Furnace &7(&eIII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(8),
            LoreBuilder.powerPerSecond(120)
        );

        SlimefunItemStack electricSmoker = new SlimefunItemStack(
            "IDOE_ELECTRIC_SMOKER",
            Material.SMOKER,
            "&aElectric Smoker",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            LoreBuilder.speed(2),
            LoreBuilder.powerPerSecond(48)
        );

        SlimefunItemStack electricSmoker2 = new SlimefunItemStack(
            "IDOE_ELECTRIC_SMOKER_2",
            Material.SMOKER,
            "&aElectric Smoker &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(80)
        );

        SlimefunItemStack electricSmoker3 = new SlimefunItemStack(
            "IDOE_ELECTRIC_SMOKER_3",
            Material.SMOKER,
            "&aElectric Smoker &7(&eIII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(8),
            LoreBuilder.powerPerSecond(120)
        );

        SlimefunItemStack electricLogStripper = new SlimefunItemStack(
            "IDOE_ELECTRIC_LOG_STRIPPER",
            Material.STONECUTTER,
            "&aElectric Log Stripper",
            "",
            LoreBuilder.machine(MachineTier.BASIC, MachineType.MACHINE),
            LoreBuilder.speed(2),
            LoreBuilder.powerPerSecond(48)
        );

        SlimefunItemStack electricLogStripper2 = new SlimefunItemStack(
            "IDOE_ELECTRIC_LOG_STRIPPER_2",
            Material.STONECUTTER,
            "&aElectric Log Stripper &7(&eII&7)",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.speed(4),
            LoreBuilder.powerPerSecond(80)
        );

        SlimefunItemStack electricLogStripper3 = new SlimefunItemStack(
            "IDOE_ELECTRIC_LOG_STRIPPER_3",
            Material.STONECUTTER,
            "&aElectric Log Stripper &7(&eIII&7)",
            "",
            LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
            LoreBuilder.speed(8),
            LoreBuilder.powerPerSecond(120)
        );

        SlimefunItemStack zombieRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_ZOMBIE",
            REPELLER,
            "&aZombie Repeller",
            "",
            "&fPlace this to repel all",
            "&fZombies in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(125)
        );

        SlimefunItemStack spiderRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_SPIDER",
            REPELLER,
            "&aSpider Repeller",
            "",
            "&fPlace this to repel all",
            "&fSpiders in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(125)
        );

        SlimefunItemStack skeletonRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_SKELETON",
            REPELLER,
            "&aSkeleton Repeller",
            "",
            "&fPlace this to repel all",
            "&fSkeletons in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(125)
        );

        SlimefunItemStack creeperRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_CREEPER",
            REPELLER,
            "&aCreeper Repeller",
            "",
            "&fPlace this to repel all",
            "&fCreepers in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(125)
        );

        SlimefunItemStack slimeRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_SLIME",
            REPELLER,
            "&aSlime Repeller",
            "",
            "&fPlace this to repel all",
            "&fSlimes in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(175)
        );

        SlimefunItemStack zombieVillagerRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_ZOMBIE_VILLAGER",
            REPELLER,
            "&aZombie Villager Repeller",
            "",
            "&fPlace this to repel all",
            "&fZombie Villagers in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(125)
        );

        SlimefunItemStack batRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_BAT",
            REPELLER,
            "&aBat Repeller",
            "",
            "&fPlace this to repel all",
            "&fBats in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(75)
        );

        SlimefunItemStack endermanRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_ENDERMAN",
            REPELLER,
            "&aEnderman Repeller",
            "",
            "&fPlace this to repel all",
            "&fEnderman in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(125)
        );

        SlimefunItemStack witchRepeller = new SlimefunItemStack(
            "IDOE_REPELLER_WITCH",
            REPELLER,
            "&aWitch Repeller",
            "",
            "&fPlace this to repel all",
            "&fWitches in a chunk",
            "",
            LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
            LoreBuilder.powerPerSecond(125)
        );

        //////////////////////////////////////////////
        /////////////////// TOOLS ////////////////////
        //////////////////////////////////////////////

        SlimefunItemStack magnetoid = new SlimefunItemStack(
            "IDOE_MAGNETOID",
            Material.ECHO_SHARD,
            "&aMagnetoid",
            "",
            "&fMagnetoids attract nearby items",
            "",
            LoreBuilder.powerCharged(0, 50),
            LoreBuilder.range(8),
            "",
            "&eOffhand &7to use"
        );

        SlimefunItemStack jawn = new SlimefunItemStack(
            "IDOE_JAWN",
            Material.BONE,
            "&aJawn",
            "",
            "&fInstantly break any head",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE
        );

        SlimefunItemStack lavaBoat = new SlimefunItemStack(
            "IDOE_LAVABOAT",
            Material.DARK_OAK_BOAT,
            "&aLava Boat",
            "",
            "&fPlace a fire proof boat",
            "&fat your feet to traverse",
            "&fover lava",
            "",
            "&8⇨ &4Not buoyant in water!",
            "&8⇨ &4Hot!",
            "",
            LoreBuilder.RIGHT_CLICK_TO_USE
        );

        SlimefunItemStack trimVault = new SlimefunItemStack(
            "IDOE_TRIM_VAULT",
            TRIM_VAULT,
            "&aTrim Vault",
            "",
            "&fBreak to receive a random",
            "&fSmithing Template",
            ""
        );

        SlimefunItemStack wisterShears = new SlimefunItemStack(
            "IDOE_WISTER_SHEARS",
            Material.SHEARS,
            "&aWister Shears",
            "",
            "&fShear all the things",
            "",
            "&8⇨ &aIndestructible!",
            "",
            "&eLeft Click&7 to use on leaves/grass",
            "&eRight Click&7 to use on mobs"
        );

        ItemMeta wistermeta = wisterShears.getItemMeta();
        wistermeta.setUnbreakable(true);
        wistermeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        wisterShears.setItemMeta(wistermeta);

        SlimefunItemStack biomeCompass = new SlimefunItemStack(
            "IDOE_BIOMECOMPASS",
            Material.COMPASS,
            "&aBiome Compass",
            "",
            "&fFind a biome within " + BiomeCompass.getRange(),
            "&fblocks. Prioritizes new areas.",
            "",
            "&8⇨ &aRemembers locations!",
            "",
            "&eSneak + R-Click AIR&7 Next Biome",
            "&eSneak + R-Click BLOCK&7 Prev. Biome",
            "&eR-Click &7to search for Biome"
        );

        SlimefunItemStack flameheartIdol = new SlimefunItemStack(
            "IDOE_IDOL_FLAMEHEART",
            Material.BLAZE_POWDER,
            "&c&lFlameheart Idol",
            "&eNever consumed!",
            "",
            "&8⇨ &aLava Walker: &720%",
            "&8⇨ &aFirefighter: &720%",
            "&8⇨ &aWarrior: &720%",
            "&8⇨ &aKnight: &730%",
            "",
            "&eRight Click &7to toggle messages",
            "&cFireproof"
        );

        SlimefunItemStack torrentIdol = new SlimefunItemStack(
            "IDOE_IDOL_TORRENT",
            Material.HEART_OF_THE_SEA,
            "&b&lTorrent Idol",
            "&eNever consumed!",
            "",
            "&8⇨ &aWater: &720%",
            "&8⇨ &aAngel: &775%",
            "&8⇨ &aWhirlwind: &760%",
            "&8⇨ &aTraveller: &760%",
            "",
            "&eRight Click &7to toggle messages",
            "&cFireproof"
        );

        SlimefunItemStack terranIdol = new SlimefunItemStack(
            "IDOE_IDOL_TERRAN",
            Material.HONEYCOMB,
            "&a&lTerran Idol",
            "&eNever consumed!",
            "",
            "&8⇨ &aCaveman: &750%",
            "&8⇨ &aMiner: &720%",
            "&8⇨ &aFarmer: &720%",
            "&8⇨ &aHunter: &720%",
            "",
            "&eRight Click &7to toggle messages",
            "&cFireproof"
        );

        SlimefunItemStack divineIdol = new SlimefunItemStack(
            "IDOE_IDOL_DIVINE",
            Material.AMETHYST_SHARD,
            "&d&lDivine Idol",
            "&eNever consumed!",
            "",
            "&8⇨ &aMagician: &780%",
            "&8⇨ &aWizard: &720%",
            "&8⇨ &aWise: &720%",
            "&8⇨ &aAnvil: &720%",
            "",
            "&eRight Click &7to toggle messages",
            "&cFireproof"
        );

        //########################
        //  RECIPES
        //########################

        //////////////////////////////////////////////
        ///////////////// MACHINES ///////////////////
        //////////////////////////////////////////////
        ItemStack[] playerHopperRecipe = {
            SlimefunItems.ENERGY_CONNECTOR, SlimefunItems.EARTH_RUNE, SlimefunItems.INFUSED_MAGNET,
            SlimefunItems.ENDER_RUNE, SlimefunItems.INFUSED_HOPPER, SlimefunItems.ENDER_RUNE,
            SlimefunItems.INFUSED_MAGNET, SlimefunItems.EARTH_RUNE, SlimefunItems.ENERGY_CONNECTOR
        };

        ItemStack[] stackDispenserRecipe = {
            SlimefunItems.STEEL_PLATE, SlimefunItems.BATTERY, SlimefunItems.STEEL_PLATE,
            SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.BLOCK_PLACER, SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.STEEL_PLATE, SlimefunItems.BATTERY, SlimefunItems.STEEL_PLATE
        };

        ItemStack[] radiationAbsorberRecipe = {
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.HEATING_COIL, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.HEATING_COIL,
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.REINFORCED_PLATE
        };

        ItemStack[] radiationAbsorber2Recipe = {
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.HEATING_COIL, radiationAbsorber, SlimefunItems.HEATING_COIL,
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.REINFORCED_PLATE
        };

        ItemStack[] radiationAbsorber3Recipe = {
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.HEATING_COIL, radiationAbsorber2, SlimefunItems.HEATING_COIL,
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.REINFORCED_PLATE
        };


        ItemStack[] electricBlastFurnaceRecipe = {
            null, SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.BLAST_FURNACE), SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.HEATING_COIL
        };

        ItemStack[] electricBlastFurnaceRecipe2 = {
            null, SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, electricBlastFurnace, SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.HEATING_COIL
        };

        ItemStack[] electricBlastFurnaceRecipe3 = {
            null, SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, electricBlastFurnace2, SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.HEATING_COIL
        };

        ItemStack[] electricSmokerRecipe = {
            new ItemStack(Material.FLINT_AND_STEEL), SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.SMOKER), SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.IGNITION_CHAMBER
        };

        ItemStack[] electricSmokerRecipe2 = {
            new ItemStack(Material.FLINT_AND_STEEL), SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, electricSmoker, SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.IGNITION_CHAMBER
        };

        ItemStack[] electricSmokerRecipe3 = {
            new ItemStack(Material.FLINT_AND_STEEL), SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, electricSmoker2, SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.IGNITION_CHAMBER
        };

        ItemStack[] electricLogStripperRecipe = {
            SlimefunItems.LUMBER_AXE, SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.STONECUTTER), SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.COPPER_WIRE, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COPPER_WIRE
        };

        ItemStack[] electricLogStripperRecipe2 = {
            SlimefunItems.LUMBER_AXE, SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, electricLogStripper, SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.COPPER_WIRE, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COPPER_WIRE
        };

        ItemStack[] electricLogStripperRecipe3 = {
            SlimefunItems.LUMBER_AXE, SlimefunItems.BATTERY, null,
            SlimefunItems.ELECTRIC_MOTOR, electricLogStripper2, SlimefunItems.ELECTRIC_MOTOR,
            SlimefunItems.COPPER_WIRE, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COPPER_WIRE
        };

        ItemStack[] zombieRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.ZOMBIE_HEAD), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] spiderRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.SPIDER_EYE), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] skeletonRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.SKELETON_SKULL), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] creeperRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.CREEPER_HEAD), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] slimeRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.SLIME_BLOCK), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] zombieVillagerRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.ROTTEN_FLESH), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] batRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.APPLE), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] endermanRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.ENDER_EYE), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        ItemStack[] witchRepellerRecipe = {
            new ItemStack(Material.NETHERITE_SWORD), new ItemStack(Material.GLOWSTONE_DUST), SlimefunItems.GRAPPLING_HOOK,
            SlimefunItems.MAGICAL_GLASS, SlimefunItems.NECROTIC_SKULL, SlimefunItems.MAGICAL_GLASS,
            SlimefunItems.TRASH_CAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.NEPTUNIUM
        };

        //////////////////////////////////////////////
        /////////////////// TOOLS ////////////////////
        //////////////////////////////////////////////
        ItemStack[] magnetoidRecipe = {
            null, SlimefunItems.GRAPPLING_HOOK, null,
            SlimefunItems.REDSTONE_ALLOY, SlimefunItems.INFUSED_MAGNET, SlimefunItems.REDSTONE_ALLOY,
            null, SlimefunItems.ELECTRIC_MOTOR, null
        };

        ItemStack[] jawnRecipe = {
            SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.ENCHANTMENT_RUNE,
            SlimefunItems.ENCHANTMENT_RUNE, new ItemStack(Material.BONE), SlimefunItems.ENCHANTMENT_RUNE,
            SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.ENCHANTMENT_RUNE, SlimefunItems.ENCHANTMENT_RUNE
        };

        ItemStack[] lavaBoatRecipe = {
            null, null, null,
            new ItemStack(Material.OBSIDIAN), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.OBSIDIAN),
            new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN)
        };

        ItemStack[] trimVaultRecipe = {
            SlimefunItems.PLASTIC_SHEET, SlimefunItems.SALT, SlimefunItems.PLASTIC_SHEET,
            SlimefunItems.STEEL_PLATE, new ItemStack(Material.NETHERITE_INGOT), SlimefunItems.STEEL_PLATE,
            SlimefunItems.PLASTIC_SHEET, SlimefunItems.OUTPUT_CHEST, SlimefunItems.PLASTIC_SHEET
        };

        ItemStack[] wisterShearsRecipe = {
            SlimefunItems.EARTH_RUNE, new ItemStack(Material.SHORT_GRASS), SlimefunItems.EARTH_RUNE,
            SlimefunItems.EARTH_RUNE, new ItemStack(Material.SHEARS), SlimefunItems.EARTH_RUNE,
            SlimefunItems.EARTH_RUNE, new ItemStack(Material.OAK_LEAVES), SlimefunItems.EARTH_RUNE
        };

        ItemStack[] biomeCompassRecipe = {
            new ItemStack(Material.ICE), new ItemStack(Material.GRASS_BLOCK), new ItemStack(Material.MAGMA_BLOCK),
            new ItemStack(Material.PHANTOM_MEMBRANE), new ItemStack(Material.COMPASS), new ItemStack(Material.SPYGLASS),
            new ItemStack(Material.CRIMSON_FUNGUS), new ItemStack(Material.SCULK), new ItemStack(Material.END_STONE)
        };

        ItemStack[] flamheartIdolRecipe = {
            SlimefunItem.getById("ENDER_LAVA_TALISMAN").getItem(), SlimefunItems.TALISMAN_LAVA, SlimefunItem.getById("ENDER_WARRIOR_TALISMAN").getItem(),
            SlimefunItems.TALISMAN_WARRIOR, SlimefunItems.BOOSTED_URANIUM, SlimefunItems.TALISMAN_KNIGHT,
            SlimefunItem.getById("ENDER_KNIGHT_TALISMAN").getItem(), SlimefunItems.TALISMAN_FIRE, SlimefunItem.getById("ENDER_FIRE_TALISMAN").getItem()
        };

        ItemStack[] torrentIdolRecipe = {
            SlimefunItem.getById("ENDER_WATER_TALISMAN").getItem(), SlimefunItems.TALISMAN_WATER, SlimefunItem.getById("ENDER_ANGEL_TALISMAN").getItem(),
            SlimefunItems.TALISMAN_ANGEL, SlimefunItems.BOOSTED_URANIUM, SlimefunItems.TALISMAN_WHIRLWIND,
            SlimefunItem.getById("ENDER_WHIRLWIND_TALISMAN").getItem(), SlimefunItems.TALISMAN_TRAVELLER, SlimefunItem.getById("ENDER_TRAVELLER_TALISMAN").getItem()
        };

        ItemStack[] terranIdolRecipe = {
            SlimefunItem.getById("ENDER_CAVEMAN_TALISMAN").getItem(), SlimefunItems.TALISMAN_CAVEMAN, SlimefunItem.getById("ENDER_MINER_TALISMAN").getItem(),
            SlimefunItems.TALISMAN_MINER, SlimefunItems.BOOSTED_URANIUM, SlimefunItems.TALISMAN_FARMER,
            SlimefunItem.getById("ENDER_FARMER_TALISMAN").getItem(), SlimefunItems.TALISMAN_HUNTER, SlimefunItem.getById("ENDER_HUNTER_TALISMAN").getItem()
        };

        ItemStack[] divineIdolRecipe = {
            SlimefunItem.getById("ENDER_MAGICIAN_TALISMAN").getItem(), SlimefunItems.TALISMAN_MAGICIAN, SlimefunItem.getById("ENDER_WIZARD_TALISMAN").getItem(),
            SlimefunItems.TALISMAN_WIZARD, SlimefunItems.BOOSTED_URANIUM, SlimefunItems.TALISMAN_WISE,
            SlimefunItem.getById("ENDER_WISE_TALISMAN").getItem(), SlimefunItems.TALISMAN_ANVIL, SlimefunItem.getById("ENDER_ANVIL_TALISMAN").getItem()
        };

        //########################
        //  INSTANTIATE
        //########################

        SlimefunItem playerHopperItem = new PlayerHopper(group, playerHopper, RecipeType.MAGIC_WORKBENCH, playerHopperRecipe, 500, 5000);
        SlimefunItem stackDispenserItem = new StackDispenser(group, stackDispenser, RecipeType.MAGIC_WORKBENCH, stackDispenserRecipe);

        SlimefunItem radiationabsorber = new RadiationAbsorber(group, radiationAbsorber, RecipeType.ENHANCED_CRAFTING_TABLE, radiationAbsorberRecipe, 250, 1600, 2);
        SlimefunItem radiationabsorber2 = new RadiationAbsorber(group, radiationAbsorber2, RecipeType.ENHANCED_CRAFTING_TABLE, radiationAbsorber2Recipe, 750, 3800, 4);
        SlimefunItem radiationabsorber3 = new RadiationAbsorber(group, radiationAbsorber3, RecipeType.ENHANCED_CRAFTING_TABLE, radiationAbsorber3Recipe, 1800, 12300, 7);

        SlimefunItem electricBlastFurnaceItem = new ElectricBlastFurnace(group, electricBlastFurnace, RecipeType.ENHANCED_CRAFTING_TABLE, electricBlastFurnaceRecipe).setCapacity(1024).setEnergyConsumption(24).setProcessingSpeed(2);
        SlimefunItem electricBlastFurnaceItem2 = new ElectricBlastFurnace(group, electricBlastFurnace2, RecipeType.ENHANCED_CRAFTING_TABLE, electricBlastFurnaceRecipe2).setCapacity(1024).setEnergyConsumption(48).setProcessingSpeed(4);
        SlimefunItem electricBlastFurnaceItem3 = new ElectricBlastFurnace(group, electricBlastFurnace3, RecipeType.ENHANCED_CRAFTING_TABLE, electricBlastFurnaceRecipe3).setCapacity(1024).setEnergyConsumption(60).setProcessingSpeed(8);

        SlimefunItem electricSmokerItem = new ElectricSmoker(group, electricSmoker, RecipeType.ENHANCED_CRAFTING_TABLE, electricSmokerRecipe).setCapacity(1024).setEnergyConsumption(24).setProcessingSpeed(2);
        SlimefunItem electricSmokerItem2 = new ElectricSmoker(group, electricSmoker2, RecipeType.ENHANCED_CRAFTING_TABLE, electricSmokerRecipe2).setCapacity(1024).setEnergyConsumption(48).setProcessingSpeed(4);
        SlimefunItem electricSmokerItem3 = new ElectricSmoker(group, electricSmoker3, RecipeType.ENHANCED_CRAFTING_TABLE, electricSmokerRecipe3).setCapacity(1024).setEnergyConsumption(60).setProcessingSpeed(8);

        SlimefunItem electricLogStripperItem = new ElectricLogStripper(group, electricLogStripper, RecipeType.ENHANCED_CRAFTING_TABLE, electricLogStripperRecipe).setCapacity(1024).setEnergyConsumption(24).setProcessingSpeed(2);
        SlimefunItem electricLogStripperItem2 = new ElectricLogStripper(group, electricLogStripper2, RecipeType.ENHANCED_CRAFTING_TABLE, electricLogStripperRecipe2).setCapacity(1024).setEnergyConsumption(48).setProcessingSpeed(4);
        SlimefunItem electricLogStripperItem3 = new ElectricLogStripper(group, electricLogStripper3, RecipeType.ENHANCED_CRAFTING_TABLE, electricLogStripperRecipe3).setCapacity(1024).setEnergyConsumption(60).setProcessingSpeed(8);

        SlimefunItem zombieRepellerItem = new ZombieRepeller(group, zombieRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, zombieRepellerRecipe, 250, 1200);
        SlimefunItem spiderRepellerItem = new SpiderRepeller(group, spiderRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, spiderRepellerRecipe, 250, 1200);
        SlimefunItem skeletonRepellerItem = new SkeletonRepeller(group, skeletonRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, skeletonRepellerRecipe, 250, 1200);
        SlimefunItem creeperRepellerItem = new CreeperRepeller(group, creeperRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, creeperRepellerRecipe, 250, 1200);
        SlimefunItem slimeRepellerItem = new SlimeRepeller(group, slimeRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, slimeRepellerRecipe, 350, 1200);
        SlimefunItem zombieVillagerRepellerItem = new ZombieVillagerRepeller(group, zombieVillagerRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, zombieVillagerRepellerRecipe, 350, 1200);
        SlimefunItem batRepellerItem = new BatRepeller(group, batRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, batRepellerRecipe, 150, 1200);
        SlimefunItem endermanRepellerItem = new EndermanRepeller(group, endermanRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, endermanRepellerRecipe, 250, 1200);
        SlimefunItem witchRepellerItem = new WitchRepeller(group, witchRepeller, RecipeType.ENHANCED_CRAFTING_TABLE, witchRepellerRecipe, 250, 1200);

        SlimefunItem magnetoidItem = new Magnetoid(group, magnetoid, RecipeType.MAGIC_WORKBENCH, magnetoidRecipe, 50);
        SlimefunItem jawnItem = new Jawn(group, jawn, RecipeType.MAGIC_WORKBENCH, jawnRecipe);
        SlimefunItem lavaBoatItem = new LavaBoat(group, lavaBoat, RecipeType.MAGIC_WORKBENCH, lavaBoatRecipe);
        SlimefunItem trimVaultItem = new TrimVault(group, trimVault, RecipeType.MAGIC_WORKBENCH, trimVaultRecipe);
        SlimefunItem wisterShearsItem = new WisterShears(group, wisterShears, RecipeType.MAGIC_WORKBENCH, wisterShearsRecipe);
        SlimefunItem biomeCompassItem = new BiomeCompass(group, biomeCompass, RecipeType.MAGIC_WORKBENCH, biomeCompassRecipe);

        SlimefunItem flameheartIdolItem = new FlameheartIdol(group, flameheartIdol, RecipeType.MAGIC_WORKBENCH, flamheartIdolRecipe);
        SlimefunItem torrentIdolItem = new TorrentIdol(group, torrentIdol, RecipeType.MAGIC_WORKBENCH, torrentIdolRecipe);
        SlimefunItem terranIdolItem = new TerranIdol(group, terranIdol, RecipeType.MAGIC_WORKBENCH, terranIdolRecipe);
        SlimefunItem divineIdolItem = new DivineIdol(group, divineIdol, RecipeType.MAGIC_WORKBENCH, divineIdolRecipe);


        //########################
        //  REGISTER
        //########################

        new Terrabore(group, terrabore).register(plugin);
        new AdvancedTerrabore(group, terraboreAdvanced).register(plugin);
        new EliteTerrabore(group, terraboreElite).register(plugin);

        stackDispenserItem.register(plugin);
        playerHopperItem.register(plugin);

        flameheartIdolItem.register(plugin);
        torrentIdolItem.register(plugin);
        terranIdolItem.register(plugin);
        divineIdolItem.register(plugin);

        magnetoidItem.register(plugin);
        jawnItem.register(plugin);
        lavaBoatItem.register(plugin);
        trimVaultItem.register(plugin);
        wisterShearsItem.register(plugin);
        biomeCompassItem.register(plugin);

        radiationabsorber.register(plugin);
        radiationabsorber2.register(plugin);
        radiationabsorber3.register(plugin);

        electricBlastFurnaceItem.register(plugin);
        electricBlastFurnaceItem2.register(plugin);
        electricBlastFurnaceItem3.register(plugin);

        electricSmokerItem.register(plugin);
        electricSmokerItem2.register(plugin);
        electricSmokerItem3.register(plugin);

        electricLogStripperItem.register(plugin);
        electricLogStripperItem2.register(plugin);
        electricLogStripperItem3.register(plugin);

        zombieRepellerItem.register(plugin);
        spiderRepellerItem.register(plugin);
        skeletonRepellerItem.register(plugin);
        creeperRepellerItem.register(plugin);
        slimeRepellerItem.register(plugin);
        zombieVillagerRepellerItem.register(plugin);
        batRepellerItem.register(plugin);
        endermanRepellerItem.register(plugin);
        witchRepellerItem.register(plugin);
    }
}
