/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class SaltEncoder {
    public static String salt(){
        Random rd = new SecureRandom();
        byte[] salt = new byte[32];
        rd.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
