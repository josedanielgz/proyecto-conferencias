/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author anyusername
 */
public class PruebaCSV {

    public static void main(String[] args) throws IOException {

        // set correct directory as output
        File csvOutputFile = new File("./files/test.csv");

        Usuario a = new Usuario(1, "JOSE", "DANIEL", LocalDate.of(1998, Month.MARCH, 19));
        Usuario b = new Usuario(2, "JESE", "D", LocalDate.of(1991, Month.MARCH, 11));

        List<Usuario> list = new ArrayList<>(Arrays.asList(a, b));
        
        // Solución a un problema específico https://stackoverflow.com/a/62261734
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        mapper.registerModule(new JavaTimeModule());

        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("documento")
                .addColumn("primer_nombre")
                .addColumn("primer_apellido")
                .addColumn("fecha_nacimiento")
                .build();

        ObjectWriter writer = mapper.writerFor(Usuario.class).with(schema);

        writer.writeValues(csvOutputFile).writeAll(list);

        System.out.println("Users saved to csv file under path: ");
        System.out.println(csvOutputFile);
    }
}
