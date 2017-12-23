/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.est.encryption;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author estevam
 */
public class MD5 {

    public static String encodeMD5(String pass) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(pass.getBytes()));
        sen = hash.toString(16);
        pass = sen;
        return pass;
    }
}
