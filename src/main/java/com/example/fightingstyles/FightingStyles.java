package com.example.fightingstyles;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(FightingStyles.MOD_ID)
public class FightingStyles {
    public static final String MOD_ID = "new";

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final List<DeferredItem<FightingStyleItem>> STYLES = new ArrayList<>();

    static {
        for (int i = 1; i <= 15; i++) {
            STYLES.add(ITEMS.registerItem("fight_" + i, FightingStyleItem::new,
                    new Item.Properties().stacksTo(1)));
        }
        TABS.register("fighting_styles", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.new.fighting_styles"))
                .icon(() -> new ItemStack(STYLES.get(0).get()))
                .displayItems((params, output) -> STYLES.forEach(i -> output.accept(i.get())))
                .build());
    }

    public FightingStyles(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
    }
}
