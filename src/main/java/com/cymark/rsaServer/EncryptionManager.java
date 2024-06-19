package com.cymark.rsaServer;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

//public class EncryptionManager {
//    private PublicKey publicKey;
//
//    private static final String PUBLIC_KEY_STRING =  "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2zO36L1rCgW7qfhovAoAyazu/DP4zsBy9RmNc5aGoeJY1dFfas5BHgibFsc7ZlOSbNyI+lOquJ8jrdIfXa9V/DqmiS6UDboTYZIf7DF7HSpsjtzkLaHZqOK8wUySKE+GZsxGy1xtmZFVGenVDBa1eCKHlQVD5zkrpEcgalrewJQIDAQAB";
//
//
//    public void initFromStrings(){
//        try{
//            X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(decode(PUBLIC_KEY_STRING));
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            publicKey = keyFactory.generatePublic(keySpecPublic);
//        }catch (Exception ignored){}
//    }
//
//    private static String encode(byte[] data) {
//        return Base64.getEncoder().encodeToString(data);
//    }
//    private static byte[] decode(String data) {
//        return Base64.getDecoder().decode(data);
//    }
//
//    public String encrypt(String message) throws Exception {
//        byte[] messageToBytes = message.getBytes();
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
//        return encode(encryptedBytes);
//    }
//}


public class EncryptionManager {
    private PublicKey publicKey;

    private static final String PUBLIC_KEY_STRING = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCZMo2WU6p8dQtAZP2lHje4P1WXZabOGmEkrw52S0lNQbd8TYqy5+51z/ZmL7v71f67XgDE0oE3jNRWoxHoSL5zksKkO2DZZkVK7OtYv1kpBdv7GM+ql+0kkAegUvwPTb1JumBREe3KxBScRIDGHFRKrQRu5iYuE4AOlQ+Qva6d9wIDAQAB";

    public void initFromStrings() throws Exception {
        X509EncodedKeySpec keySpecPublic = new X509EncodedKeySpec(Base64.getDecoder().decode(PUBLIC_KEY_STRING));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        publicKey = keyFactory.generatePublic(keySpecPublic);
    }

    public String encrypt(String message) throws Exception {
        byte[] messageToBytes = message.getBytes();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = cipher.doFinal(messageToBytes);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}