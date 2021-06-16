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
        //String a = "{\"documento\":\"6\",\"primer_nombre\":\"JULIAN\",\"primer_apellido\":\"FULANO\",\"fecha_nacimiento\":\"2018-07-28\",\"clave\":\"123456\"}";
        String a = "{\"documento\":\"1231\",\"primer_nombre\":\"12312\",\"primer_apellido\":\"21312312\",\"fecha_nacimiento\":\"2021-06-02\",\"correo_electronico\":\"asdasd@wqeqweq\",\"clave\":\"1231231\"}";
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> data = mapper.readValue(a, Map.class);
        System.out.println(data.get("correo_electronico"));
//        PasswordManager pm = new PasswordManager();
//        System.out.println(pm.generateStrongPasswordHash(data.get("clave")));
    }
}
