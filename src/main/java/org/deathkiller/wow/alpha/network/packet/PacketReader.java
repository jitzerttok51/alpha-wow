package org.deathkiller.wow.alpha.network.packet;

import io.vertx.core.buffer.Buffer;

public class PacketReader {

    private final Opcode opcode;
    private final short size;
    private final Buffer buffer;

    private int pos = 0;

    public PacketReader(Buffer buffer, boolean worldPacket) {
        this.buffer = buffer;
        if(worldPacket) {
            size = (short) ((readUInt16() / 0x100) - 4);
            short op = readUInt16();
            opcode = Opcode.findOpcode(op);
            readUInt16();
            return;
        }
        opcode = Opcode.UNKOWN;
        size = 0;
    }

    public byte readInt8() {
        byte x = buffer.getByte(pos);
        pos += 1;
        return x;
    }

    public short readInt16() {
        short x = buffer.getShortLE(pos);
        pos += 2;
        return x;
    }

    public int readInt32() {
        int x = buffer.getIntLE(pos);
        pos += 4;
        return x;
    }

    public long readInt64() {
        long x = buffer.getLongLE(pos);
        pos += 8;
        return x;
    }

    public byte readUInt8() {
        byte x = (byte) buffer.getUnsignedByte(pos);
        pos += 1;
        return x;
    }

    public short readUInt16() {
        short x = (short) buffer.getUnsignedShortLE(pos);
        pos += 2;
        return x;
    }

    public int readUInt32() {
        int x = (int) buffer.getUnsignedIntLE(pos);
        pos += 4;
        return x;
    }

    public PacketReader(Buffer buffer) {
        this(buffer, true);
    }

    public Opcode opcode() {
        return opcode;
    }

    public int pos() {
        return pos;
    }

    public short size() {
        return size;
    }
}
