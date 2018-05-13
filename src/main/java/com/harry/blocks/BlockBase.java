package com.harry.blocks;

import com.harry.MyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block {
    public BlockBase(String name, Material mat, CreativeTabs tab, float hardness, float resistance, String tool, int harvest) {
        this(name, mat, tab, hardness, resistance);
        setHarvestLevel(tool, harvest);
    }
    public BlockBase(String name, Material mat, CreativeTabs tab, float hardness, float resistance, float light) {
        this(name, mat, tab, hardness, resistance);
        setLightLevel(light);
    }
    public BlockBase(String name, Material mat, CreativeTabs tab, float hardness, float resistance) {
        super(mat);
        setUnlocalizedName(name);
        setRegistryName(new ResourceLocation(MyMod.MODID, name));
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(tab);
    }
}
