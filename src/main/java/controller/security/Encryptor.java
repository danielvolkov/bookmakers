package controller.security;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by daniel on 1/21/17.
 */
public class Encryptor {

    private static final Logger logger = Logger.getLogger(Encryptor.class);

    public static final String MD5 = "MD5";
    public static final int RADIX = 16;
    public static final int SUFFIX = 0xff;
    public static final int PREFIX = 0x100;

    public static String encrypt(String inputPassword){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.update(inputPassword.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < digest.length; i++){
                stringBuilder.append(Integer.toString((digest[i] & SUFFIX) + PREFIX, RADIX).substring(1));
            }
            String passwordHash = stringBuilder.toString();

            return passwordHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
