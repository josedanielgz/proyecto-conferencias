/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

/**
 *
 * @author anyusername
 */
public class PruebaJSON {

    public static void main(String[] args) throws JsonProcessingException, NoSuchAlgorithmException, InvalidKeySpecException {
        String a = "{\"documento\":\"6\",\"primer_nombre\":\"JULIAN\",\"primer_apellido\":\"FULANO\",\"fecha_nacimiento\":\"2018-07-28\",\"clave\":\"123456\"}";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = mapper.readValue(a, Map.class);
        PasswordManager pm = new PasswordManager();
        System.out.println(pm.generateStrongPasswordHash(data.get("clave")));
    }
}
