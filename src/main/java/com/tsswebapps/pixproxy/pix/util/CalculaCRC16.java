package com.tsswebapps.pixproxy.pix.util;

import java.nio.charset.StandardCharsets;

public class CalculaCRC16 {
    private static final int POLY = 0x1021;
    private static final int INITIAL_VALUE = 0xFFFF;

    public static int calculate(byte[] data) {
        int crc = INITIAL_VALUE;
        for (byte b : data) {
            crc ^= b << 8;
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ POLY;
                } else {
                    crc <<= 1;
                }
            }
        }
        return crc & 0xFFFF;
    }

    public static int calculateStr(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        int crc = INITIAL_VALUE;
        for (byte b : bytes) {
            crc ^= (b & 0xFF) << 8;
            for (int i = 0; i < 8; i++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ POLY;
                } else {
                    crc <<= 1;
                }
            }
        }
        return crc & 0xFFFF;
    }
}
