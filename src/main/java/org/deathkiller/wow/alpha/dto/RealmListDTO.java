package org.deathkiller.wow.alpha.dto;

import org.deathkiller.wow.alpha.network.packet.PacketWriter;

import java.util.ArrayList;
import java.util.List;

public class RealmListDTO {

    private final List<RealmEntryDTO> realms;

    public RealmListDTO(List<RealmEntryDTO> realms) {
        this.realms = realms;
    }

    public static class Builder {
        private final List<RealmEntryDTO> realms = new ArrayList<>();
        private String hostname = "localhost";

        public Builder() {

        }

        public Builder(String hostname) {
            this.hostname = hostname;
        }

        public Builder addRealm(RealmEntryDTO entry) {
            realms.add(entry);
            return this;
        }

        public Builder addRealm(String name, String hostname, int port, int players) {
            return addRealm(new RealmEntryDTO(name, hostname, port, players));
        }

        public Builder addRealm(String name, int port, int players) {
            return addRealm(name, hostname, port, players);
        }

        public RealmListDTO build() {
            return new RealmListDTO(realms);
        }
    }

    public List<RealmEntryDTO> getRealms() {
        return realms;
    }

    public PacketWriter write() {
        var writer = new PacketWriter();
        writer.writeUInt8((byte) realms.size());
        for(var realm : realms) {
            writer.writeString(realm.name())
                .writeString(realm.hostname()+":"+realm.port())
                .writeUInt32(realm.players());
        }
        return writer;
    }
}
