package com.harry.util;

import com.harry.MyMod;
import com.harry.blocks.Blocks;
import com.harry.entity.EntityBullet;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.harry.items.Items.ITEMS;

@Mod.EventBusSubscriber(modid=MyMod.MODID)
public class Events {
    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(Blocks.BLOCKS);
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        for (int i = 0; i < Blocks.BLOCKS.length; i++) {
            event.getRegistry().register(new ItemBlock(Blocks.BLOCKS[i]).setRegistryName(Blocks.BLOCKS[i].getRegistryName()));
        }
        event.getRegistry().registerAll(ITEMS);
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        EntityEntry entry = EntityEntryBuilder.create()
                .entity(EntityBullet.class)
                .id(new ResourceLocation("testmod", "EntityBullet"), 1)
                .name("EntityBullet")
                .build();
        event.getRegistry().register(entry);
    }

    @SideOnly(Side.CLIENT)
    public static void initClient(ItemModelMesher mesher) {
        Item item = Item.getItemFromBlock(Blocks.BLOCKS[0]);
        ModelResourceLocation model = new ModelResourceLocation("testmod:" + "TestBlock");
        ModelLoader.registerItemVariants(item, model);
        mesher.register(item, 0, model);
        Item item2 = ITEMS[0];
        ModelResourceLocation model2 = new ModelResourceLocation("testmod:" + "TestItem");
        ModelLoader.registerItemVariants(item2, model2);
        mesher.register(item2, 0, model2);
        Item item3 = ITEMS[1];
        ModelResourceLocation model3 = new ModelResourceLocation("testmod:" + "AssaultRifle");
        ModelLoader.registerItemVariants(item3, model3);
        mesher.register(item3,0, model3);
    }
}
