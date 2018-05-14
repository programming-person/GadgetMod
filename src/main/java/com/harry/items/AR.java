package com.harry.items;

import com.harry.MyMod;
import com.harry.entity.EntityBullet;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AR extends ItemBase {
    public AR(String name) {
        super(name, CreativeTabs.COMBAT);
    }
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        Entity entity = player;
        ResourceLocation location = new ResourceLocation("testmod", "gun");
        SoundEvent event = new SoundEvent(location);
        entity.playSound(event, 1.0F, 1.0F);
        if (!worldIn.isRemote)
        {
            worldIn.spawnEntity(new EntityBullet(worldIn, player));
        }
        return EnumActionResult.SUCCESS;
    }
}
