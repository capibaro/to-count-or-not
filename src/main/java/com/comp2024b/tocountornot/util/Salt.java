package com.comp2024b.tocountornot.util;

import java.util.Random;

public class Salt {
    private static final char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    public static String getSalt() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(44);
        for (int i = 0; i < sb.capacity(); i++) {
            sb.append(hex[random.nextInt(16)]);
        }
        return sb.toString();
    }
}
