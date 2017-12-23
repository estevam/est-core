package com.est.security;

/**
 * * @author estevam
 */
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {

    /**
     * encoderMD5
     *
     * @param aPass
     * @return
     */
    public static String encoderMD5(String aPass) {

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {

        }
        if (md != null) {
            BigInteger hash = new BigInteger(1, md.digest(aPass.getBytes()));
            return hash.toString(16);
        } else {
            return null;
        }
    }

    /**
     * encoderSHA
     *
     * @param aPass
     * @param aCriptoType - SHA-256, SHA-384, SHA-512
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String encoderSHA(String aPass, String aCriptoType) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance(aCriptoType);
        md.update(aPass.getBytes());
        byte[] byteData = md.digest(aPass.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
