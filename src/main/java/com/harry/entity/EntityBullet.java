package com.harry.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;

public class EntityBullet extends EntityThrowable {
    public EntityBullet(World world, EntityLivingBase entity) {
        super(world, entity);
    }

    @Override
    protected float getGravityVelocity()
    {
        return 0.005F;
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (result.entityHit == null) {
            return;
        }
        result.entityHit.attackEntityFrom(DamageSource.GENERIC, 1.0F);
    }
}
