package org.deathkiller.wow.alpha.handler;

import org.deathkiller.wow.alpha.network.packet.Opcode;
import org.deathkiller.wow.alpha.network.packet.PacketWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.deathkiller.wow.alpha.handler.HandlerManager.create;

@Configuration
public class PingHandler {

    @Bean
    public Handler getPingHandler() {
        return create(Opcode.CMSG_PING, (packet, session) -> {
           var writer = new PacketWriter(Opcode.SMSG_PONG)
                   .writeUInt32(packet.readInt32());
           session.send(writer);
        });
    }
}
