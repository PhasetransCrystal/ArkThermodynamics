package com.phasetranscrystal.ark_thermodynamics.module.network;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.Arrays;

public interface IServerCustomPacketPayload extends IDecoratedCustomPacketPayload {
    default void send(Player... players) {
        if (players == null || players.length == 0) {
            PacketDistributor.sendToAllPlayers(this);
        } else {
            Arrays.stream(players).filter(player -> player instanceof ServerPlayer).forEach(player -> PacketDistributor.sendToPlayer((ServerPlayer) player,this));
        }
    }
}
