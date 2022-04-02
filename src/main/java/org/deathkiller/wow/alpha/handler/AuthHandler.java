package org.deathkiller.wow.alpha.handler;

import org.deathkiller.wow.alpha.network.packet.AuthCodes;
import org.deathkiller.wow.alpha.network.packet.Opcode;
import org.deathkiller.wow.alpha.network.packet.PacketWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.deathkiller.wow.alpha.handler.HandlerManager.create;

@Configuration
public class AuthHandler {

    @Bean
    public Handler getAuthHandler() {
        return create(Opcode.CMSG_AUTH_SESSION, (packet, session) -> {
            PacketWriter writer = new PacketWriter(Opcode.SMSG_AUTH_RESPONSE);
            writer.writeUInt8(AuthCodes.AUTH_OK.code());
            session.send(writer);
        });
    }
}
