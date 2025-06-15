package com.phasetranscrystal.ark_thermodynamics.network;

import com.phasetranscrystal.ark_thermodynamics.ArkThermodynamics;
import com.phasetranscrystal.ark_thermodynamics.helper.ContainerHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;

public class SynMenuSlotClick {
    public record Pack(ResourceLocation menuType, int slotIndex, int mouseButtonIndex) implements CustomPacketPayload {

        public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(ArkThermodynamics.MODID, "gui/click");

        public Pack(FriendlyByteBuf byteBuf) {
            this(ResourceLocation.parse(byteBuf.readUtf()), byteBuf.readInt(), byteBuf.readInt());
        }

        @Override
        public void write(FriendlyByteBuf pBuffer) {
            pBuffer.writeUtf(menuType.toString());
            pBuffer.writeInt(slotIndex);
            pBuffer.writeInt(mouseButtonIndex);
        }

        @Override
        public ResourceLocation id() {
            return ID;
        }
    }

    public static void send(MenuType<?> menuType, int slotIndex, int mouseButtonIndex) {
        PacketDistributor.sendToServer(new Pack(BuiltInRegistries.MENU.getKey(menuType), slotIndex, mouseButtonIndex));
    }

    public static void handle(Pack pack, PlayPayloadContext context) {
        context.workHandler().execute(() -> context.player().ifPresent(player -> {
            AbstractContainerMenu menu = player.containerMenu;
            if (BuiltInRegistries.MENU.getKey(menu.getType()).equals(pack.menuType)) {
                ContainerHelper.handleSlotClick(pack.mouseButtonIndex, pack.slotIndex, player, menu);
            }
        }));
    }


}
