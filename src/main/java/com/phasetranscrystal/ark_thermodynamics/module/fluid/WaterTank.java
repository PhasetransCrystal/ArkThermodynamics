package com.phasetranscrystal.ark_thermodynamics.module.fluid;

import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class WaterTank extends FluidTank {
    public WaterTank(int capacity) {
        super(capacity, s -> s.is(Fluids.WATER));
    }
}
