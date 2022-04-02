package org.deathkiller.wow.alpha.handler;

import lombok.extern.slf4j.Slf4j;
import org.deathkiller.wow.alpha.network.packet.Opcode;
import org.deathkiller.wow.alpha.network.packet.PacketReader;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@Component
@Slf4j
public class HandlerManager {

    private final Map<Opcode, Handler> handlers = new HashMap<>();

    public static Handler create(Opcode opcode, BiConsumer<PacketReader, WorldSession> handle) {
        return new HandlerImpl(opcode, handle);
    }

    private record HandlerImpl(Opcode opcode, BiConsumer<PacketReader, WorldSession> handle) implements Handler {
        @Override
        public void handle(PacketReader packet, WorldSession session) {
            handle.accept(packet, session);
        }
    }

    public HandlerManager(List<Handler> handlers) {
        if(handlers !=null) {
            for(var handler : handlers) {
                this.handlers.put(handler.opcode(), handler);
            }
        }
    }

    public void handle(PacketReader packet, WorldSession session) {
        log.info("Received opcode {}", packet.opcode());
        if(!handlers.containsKey(packet.opcode())) {
            log.warn("No handler for opcode {}", packet.opcode());
            return;
        }
        handlers.get(packet.opcode()).handle(packet, session);
    }
}
