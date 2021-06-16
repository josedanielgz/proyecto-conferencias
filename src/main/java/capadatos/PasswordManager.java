/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capadatos.dao.UsuarioDAO;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import modelo.Usuario;

/**
 *
 * @author anyusername
 */
public class PasswordManager {

    // https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
    private static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        /*
        String  originalPassword = "password";
        String generatedSecuredPasswordHash = generateStorngPasswordHash(originalPassword);
        System.out.println(generatedSecuredPasswordHash);
         
        boolean matched = validatePassword("password", generatedSecuredPasswordHash);
        System.out.println(matched);
         
        matched = validatePassword("password1", generatedSecuredPasswordHash);
        System.out.println(matched);
        
        Usuario a = new Usuario();
        a.setDocumento(4);
        a.setPrimer_nombre("MANUEL");
        a.setPrimer_apellido("OBRADOR");
        a.setFecha_nacimiento(LocalDate.of(1986, Month.MARCH, 12));
        a.setClave_acceso(generateStrongPasswordHash("Manuelito_xd"));
        
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.betaInsertarUsuario(a);
            Usuario b = dao.buscaUsuario(4);
            System.out.println(validatePassword("Manuelito_xd", b.getClave_acceso()));
        } catch (SQLException ex) {
            Logger.getLogger(PasswordManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }
    
    public PasswordManager(){}

    public String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return toHex(salt) + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    public boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {

        int iterations = 1000;
        byte[] salt = fromHex(storedPassword.substring(0, 32));
        byte[] hash = fromHex(storedPassword.substring(32));

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for (int i = 0; i < hash.length && i < testHash.length; i++) {
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
