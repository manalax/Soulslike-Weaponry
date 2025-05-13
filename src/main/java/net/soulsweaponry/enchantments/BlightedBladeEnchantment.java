package net.soulsweaponry.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.soulsweaponry.config.ConfigConstructor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.soulsweaponry.registry.EffectRegistry;
import net.minecraft.item.SwordItem;

public class BlightedBladeEnchantment extends Enchantment {

    public BlightedBladeEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.WEAPON, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 10 + level * 10;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity) {
            int amp = ((LivingEntity) target).getStatusEffect(EffectRegistry.BLIGHT).getAmplifier();
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(EffectRegistry.BLIGHT, ConfigConstructor.blight_carrier_enchant_blight_duration, amp + 1));
        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem;
    }
}
