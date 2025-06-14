package com.phasetranscrystal.ark_thermodynamics.module.blockentity.container;

import com.google.common.collect.HashMultimap;
import com.phasetranscrystal.ark_thermodynamics.module.menu.ISlotTypeExpansion;
import com.phasetranscrystal.ark_thermodynamics.module.menu.SlotType;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.UnknownNullability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;

public class ExpandedContainer extends SimpleContainer implements ISlotTypeExpansion, IWrappedContainer {
    public final int length;
    public final List<SlotType> typeList;
    private HashMultimap<SlotType, Integer> indexMap;

    public ExpandedContainer(int length) {
        this(length, SlotType.ITEM);
    }

    public ExpandedContainer(int length, SlotType type) {
        super(length);
        this.length = length;
        this.typeList = Collections.nCopies(length, type);
    }

    public ExpandedContainer(int length, IntFunction<SlotType> typeProvider) {
        super(length);
        this.length = length;
        typeList = new ArrayList<>(length);
        for (int i = 0; i < length; i++){
            typeList.set(0,typeProvider.apply(i));
        }
    }

    public ExpandedContainer(List<SlotType> types) {
        super(types.size());
        this.length = types.size();
        this.typeList = types;
    }

    public ExpandedContainer(SlotType... types) {
        super(types.length);
        this.length = types.length;
        this.typeList = List.of(types);
    }

    public HashMultimap<SlotType, Integer> getOrCreateIndexMap() {
        if (indexMap == null) {
            indexMap = HashMultimap.create();
            for (int i = 0; i < length; i++) {
                indexMap.put(typeList.get(i), i);
            }
        }
        return indexMap;
    }

    public Set<Integer> indexesForType(SlotType type) {
        return getOrCreateIndexMap().get(type);
    }

    @Override
    public SlotType getSlotType(int index) {
        return typeList.get(index);
    }

    @Override
    public int getSlots() {
        return length;
    }

    @Override
    public @NotNull ItemStack getStackInSlot(int slot) {
        return getItem(slot);
    }


    @Override
    public void setStackInSlot(int slot, @NotNull ItemStack stack) {
        setItem(slot,stack);
    }

    @Override
    public void onContentsChanged(int slot) {
        ISlotTypeExpansion.super.onContentsChanged(slot);
        setChanged();
    }

    @Override
    public Container getContainer() {
        return this;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return null;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {

    }
}
