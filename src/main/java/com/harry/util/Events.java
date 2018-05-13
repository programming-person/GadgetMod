package com.harry.util;

import com.harry.MyMod;
import com.harry.blocks.Blocks;
import com.harry.blocks.TestBlock;
import com.harry.items.Items;
import com.harry.items.TestItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
        event.getRegistry().registerAll(Items.ITEMS);
    }

    @SideOnly(Side.CLIENT)
    public static void initClient(ItemModelMesher mesher) {
        Item item = Item.getItemFromBlock(Blocks.BLOCKS[0]);
        ModelResourceLocation model = new ModelResourceLocation("testmod:" + "TestBlock", "normal");
        ModelLoader.registerItemVariants(item, model);
        mesher.register(item, 0, model);
        Item item2 = Items.ITEMS[0];
        ModelResourceLocation model2 = new ModelResourceLocation("testmod:" + "TestItem");
        ModelLoader.registerItemVariants(item2, model2);
        mesher.register(item2, 0, model2);
    }
}
