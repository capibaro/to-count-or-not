package com.comp2024b.tocountornot.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Digest {
    private static final Base64.Encoder encoder = Base64.getEncoder();
    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String hash(String Password, String salt) {
        return encoder.encodeToString(md.digest((Password+salt).getBytes(StandardCharsets.UTF_8)));
    }
}
