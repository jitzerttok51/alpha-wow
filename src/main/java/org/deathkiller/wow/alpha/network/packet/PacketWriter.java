package org.deathkiller.wow.alpha.network.packet;

import io.vertx.core.buffer.Buffer;

import java.nio.charset.StandardCharsets;

public class PacketWriter {

    private final Buffer buffer = Buffer.buffer();

    public PacketWriter(Opcode opcode) {
        writeUInt8((byte) 0);
        writeUInt8((byte) 0);

        writeUInt8((byte)(opcode.getCode() % 0x100));
        writeUInt8((byte)(opcode.getCode() / 0x100));

        if(opcode != Opcode.SMSG_AUTH_CHALLENGE) {
            writeUInt8((byte) 0);
            writeUInt8((byte) 0);
        }
    }

    public PacketWriter() {

    }

    public PacketWriter writeInt8(byte v) {
        buffer.appendByte(v);
        return this;
    }

    public PacketWriter writeInt16(short v) {
        buffer.appendShortLE(v);
        return this;
    }

    public PacketWriter writeInt32(int v) {
        buffer.appendIntLE(v);
        return this;
    }

    public PacketWriter writeInt64(long v) {
        buffer.appendLongLE(v);
        return this;
    }

    public PacketWriter writeUInt8(byte v) {
        buffer.appendUnsignedByte(v);
        return this;
    }

    public PacketWriter writeUInt16(short v) {
        buffer.appendUnsignedShortLE(v);
        return this;
    }

    public PacketWriter writeUInt32(int v) {
        buffer.appendUnsignedIntLE(v);
        return this;
    }

    public PacketWriter writeUInt64(long v) {
        byte[] bytes = new byte[8];
        for(int i = 0; i<8; i++) {
            bytes[i] = (byte) ((v >> i*8) & 0xFF);
        }
        buffer.appendBytes(bytes);
        return this;
    }

    public PacketWriter writeString(String v) {
        buffer.appendBytes(v.getBytes(StandardCharsets.US_ASCII)).appendByte((byte) 0);
        return this;
    }

    public PacketWriter writeBytes(byte[] v) {
        buffer.appendBytes(v);
        return this;
    }

    public Buffer buffer() {
        int len = buffer.length() - 2;
        buffer.setByte(0, (byte)(len / 0x100));
        buffer.setByte(1, (byte)(len % 0x100));
        return buffer;
    }

    public Buffer bufferAuth() {
        return buffer;
    }
}
