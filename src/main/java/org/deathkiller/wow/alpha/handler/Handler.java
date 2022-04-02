package org.deathkiller.wow.alpha.handler;

import org.deathkiller.wow.alpha.network.packet.Opcode;
import org.deathkiller.wow.alpha.network.packet.PacketReader;

public interface Handler {

    Opcode opcode();

    void handle(PacketReader packet, WorldSession session);
}
