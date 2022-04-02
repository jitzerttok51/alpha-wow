package org.deathkiller.wow.alpha.dto;

public record RealmEntryDTO(
        String name,
        String hostname,
        int port,
        int players
) { }
