package com.example.fightingstyles;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/** ไอเทมธรรมดา: ไม่มีดาเมจ วางไม่ได้ (ไม่ใช่ BlockItem) แต่เอ็นชาร์จได้ */
public class FightingStyleItem extends Item {
    public FightingStyleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true; // vanilla ต้องมี durability ถึงจะเอ็นชาร์จได้ จึงต้อง override
    }

    @Override
    public int getEnchantmentValue(ItemStack stack) {
        return 15;
    }
}
