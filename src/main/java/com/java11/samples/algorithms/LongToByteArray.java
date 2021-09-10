package com.java11.samples.algorithms;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class LongToByteArray {

    public static void main(String [] args) {
        System.out.println("Testing");
        byte[] bytes = longToBytes(513);
        for (byte b : bytes) {
            System.out.println(b);
        }
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }
}
