package dev.qnix.Service.User.LocalStorage;

import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
public class LocalStorageService {
    public static String generateXid() {
        try {
            var uniqueId = UUID.randomUUID().toString();
            byte[] hashByteList = MessageDigest.getInstance("SHA-1").digest(uniqueId.getBytes());
            StringBuilder hexStringBuilder = new StringBuilder();

            for (byte b : hashByteList) {
                hexStringBuilder.append(String.format("%02x", b));
            }

            return hexStringBuilder.toString();
        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
}