package com.phasetranscrystal.ark_thermodynamics.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.TextColor;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RenderHelper {
    public static void spawnParticles(Level world, BlockPos pos, ParticleOptions particle, int count) {
        RandomSource random = world.getRandom();
        for (int i = 0; i < count; i++) {
            //TODO
            double x = pos.getX() + 0.5 + random.nextGaussian() * 0.6;
            double y = pos.getY() + 0.5 + random.nextGaussian() * 0.6;
            double z = pos.getZ() + 0.5 + random.nextGaussian() * 0.6;
            world.addParticle(particle, x, y, z, 0,0,0);
        }
    }

    public static int itemStackDisplayNameColor(ItemStack stack) {
        if (stack == null || stack.isEmpty()) return 0xFFFFFFFF;
        TextColor color = stack.getDisplayName().getStyle().getColor();
        return color == null ? 0xFFFFFFFF : color.getValue();
    }
}
