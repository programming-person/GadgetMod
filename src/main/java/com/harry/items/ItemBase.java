package com.harry.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import scala.sys.CreatorImpl;

public class ItemBase extends Item {
    public ItemBase(String name, CreativeTabs tab) {
        this(name, tab, 64);
    }
    public ItemBase(String name, CreativeTabs tab, int maxSize) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);
        setMaxStackSize(maxSize);
    }
}
