package com.harry;

import com.harry.proxy.ClientProxy;
import com.harry.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = MyMod.MODID, name = MyMod.NAME, version = MyMod.VERSION)
public class MyMod {
    public static final String MODID = "testmod";
    public static final String NAME = "test mod";
    public static final String VERSION = "1.0";
    @SidedProxy(clientSide = "com.harry.proxy.ClientProxy", serverSide = "com.harry.proxy.CommonProxy")
    public static CommonProxy proxy;
    @SidedProxy(clientSide = "com.harry.proxy.ClientProxy", serverSide = "com.harry.proxy.CommonProxy")
    public static ClientProxy proxy2;
    @Mod.Instance
    public static MyMod mod;
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    @EventHandler
    @SideOnly(Side.CLIENT)
    public void clientInit(FMLInitializationEvent event) {
        proxy2.init(event);
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
