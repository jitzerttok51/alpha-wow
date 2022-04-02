package org.deathkiller.wow.alpha.network.packet;

public enum AuthCodes {

    AUTH_OK                     ((byte)0x0C),
    AUTH_FAILED                 ((byte)0x0D),
    AUTH_REJECT                 ((byte)0x0E),
    AUTH_BAD_SERVER_PROOF       ((byte)0x0F),
    AUTH_UNAVAILABLE            ((byte)0x10),
    AUTH_SYSTEM_ERROR           ((byte)0x11),
    AUTH_BILLING_ERROR          ((byte)0x12),
    AUTH_BILLING_EXPIRED        ((byte)0x13),
    AUTH_VERSION_MISMATCH       ((byte)0x14),
    AUTH_UNKNOWN_ACCOUNT        ((byte)0x15),
    AUTH_INCORRECT_PASSWORD     ((byte)0x16),
    AUTH_SESSION_EXPIRED        ((byte)0x17),
    AUTH_SERVER_SHUTTING_DOWN   ((byte)0x18),
    AUTH_ALREADY_LOGGING_IN     ((byte)0x19),
    AUTH_LOGIN_SERVER_NOT_FOUND ((byte)0x1A),
    AUTH_WAIT_QUEUE             ((byte)0x1B),
    AUTH_BANNED                 ((byte)0x1C),
    AUTH_ALREADY_ONLINE         ((byte)0x1D),
    AUTH_NO_TIME                ((byte)0x1E),
    AUTH_DB_BUSY                ((byte)0x1F),
    AUTH_SUSPENDED              ((byte)0x20),
    AUTH_PARENTAL_CONTROL       ((byte)0x21),
    AUTH_LOCKED_ENFORCED        ((byte)0x22);
    
    private final byte code;

    AuthCodes(byte code) {
        this.code = code;
    }

    public byte code() {
        return code;
    }
}
