package org.deathkiller.wow.alpha.handler;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetSocket;
import lombok.RequiredArgsConstructor;
import org.deathkiller.wow.alpha.network.packet.Opcode;
import org.deathkiller.wow.alpha.network.packet.PacketReader;
import org.deathkiller.wow.alpha.network.packet.PacketWriter;

@RequiredArgsConstructor
public class WorldSession {

    private final NetSocket socket;
    private final HandlerManager handlerManager;

    public void start() {
        var writer = new PacketWriter(Opcode.SMSG_AUTH_CHALLENGE);
        writer.writeUInt8((byte) 0);
        writer.writeUInt8((byte) 0);
        writer.writeUInt8((byte) 0);
        writer.writeUInt8((byte) 0);
        writer.writeUInt8((byte) 0);
        writer.writeUInt8((byte) 0);
        send(writer);
        socket.handler(this::handle);
    }

    private void handle(Buffer buffer) {
        var packet = new PacketReader(buffer);
        handlerManager.handle(packet, this);
    }

    public void send(PacketWriter writer) {
        socket.write(writer.buffer());
    }
}
