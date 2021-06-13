/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author anyusername
 */
public class PruebaPDF {

    public static void main(String args[]) throws Exception {
        // Creating a PdfDocument object   
        String dest = "tmp.pdf";
        File f = new File(dest);
        FileOutputStream archivo = new FileOutputStream(f);
        PdfWriter writer = new PdfWriter(archivo);

        // Creating a PdfDocument object      
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document object       
        Document doc = new Document(pdf);

        // Creating a table       
        float[] pointColumnWidths = {150F, 150F, 150F};
        Table table = new Table(pointColumnWidths);

        // Adding cells to the table       
        table.addCell(new Cell().add("Name"));
        table.addCell(new Cell().add("Raju"));
        table.addCell(new Cell().add("Id"));
        table.addCell(new Cell().add("1001"));
        table.addCell(new Cell().add("Designation"));
        table.addCell(new Cell().add("Programmer"));

        // Adding Table to document        
        doc.add(table);

        // Closing the document       
        doc.close();
        System.out.println("Table created successfully..");
    }

}
