/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unal.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 *
 * @author migueldiaz
 */
public class HashSHA256 {
    

    static final Logger log = Logger.getLogger("Hash_log");
    private static String SALT="2da31fb51a0614beca71d95c1ae9ba33cdc499a48c5d87f722e959c03a27e1ef";
        
    public static String getHash(String plain) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String aux=plain+SALT;
            md.update(aux.getBytes());
            byte byteData[] = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            log.severe(ex.getLocalizedMessage());
            return null;
        }
    }

}
