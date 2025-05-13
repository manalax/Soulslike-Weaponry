package net.soulsweaponry.registry;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.soulsweaponry.SoulsWeaponry;
import net.soulsweaponry.config.ConfigConstructor;
import net.soulsweaponry.enchantments.*;
import net.soulsweaponry.items.gun.GunItem;

public class EnchantRegistry {

    public static final EnchantmentTarget GUN = EnchantmentTarget.create("gun", (item -> item instanceof GunItem));

    public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, SoulsWeaponry.ModId);

    public static final Enchantment FAST_HANDS = new FastHandsEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND);
    public static final Enchantment VISCERAL = new VisceralEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND);
    public static final Enchantment STAGGER = new StaggerEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND);
    public static final Enchantment ETHEREAL = new EtherealEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND);
    public static final Enchantment EXPLOSIVE_ROUNDS = new ExplosiveEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND);
    public static final Enchantment CHAIN_LIGHTNING = new ChainLightningEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND);
    public static final Enchantment MISFIRE_CURSE = new MisfireCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND);
    public static final Enchantment BLIGHT_CARRIER = new BlightCarrierEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND);
    public static final Enchantment BLIGHTED_BLADE = new BlightedBladeEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND);
    public static final Enchantment FROSTSILVER = new FrostsilverEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND);

    static {
        if (!ConfigConstructor.disable_all_enchantments) {
            if (!ConfigConstructor.disable_enchantment_fast_hands) registerEnchantment(FAST_HANDS, "fast_hands", true);
            if (!ConfigConstructor.disable_enchantment_posture_breaker) registerEnchantment(VISCERAL, "visceral", true);
            if (!ConfigConstructor.disable_enchantment_stagger) registerEnchantment(STAGGER, "stagger", false);
            if (!ConfigConstructor.disable_enchantment_ethereal_ammunition) registerEnchantment(ETHEREAL, "ethereal", true);
            if (!ConfigConstructor.disable_enchantment_explosive_rounds) registerEnchantment(EXPLOSIVE_ROUNDS, "explosive_rounds", true);
            if (!ConfigConstructor.disable_enchantment_chain_lightning) registerEnchantment(CHAIN_LIGHTNING, "chain_lightning", true);
            if (!ConfigConstructor.disable_enchantment_misfire_curse) registerEnchantment(MISFIRE_CURSE, "misfire_curse", true);
            if (!ConfigConstructor.disable_enchantment_blight_carrier) registerEnchantment(BLIGHT_CARRIER, "blight_carrier", true);
            if (!ConfigConstructor.disable_enchantment_blight_carrier) registerEnchantment(BLIGHTED_BLADE, "blighted_blade", true);
            if (!ConfigConstructor.disable_enchantment_frostsilver) registerEnchantment(FROSTSILVER, "frostsilver", true);
        }
    }

    public static void register(IEventBus bus) {
        ENCHANTS.register(bus);
    }
}
