package com.zwaking.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author waking
 */
public class PdfUtils {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\waking\\Downloads\\2022AugMonthlySummary.pdf";
        try {
            PDDocument doc;
            RandomAccessRead read = new RandomAccessFile(new File(filePath), "r");
            PDFParser parser = new PDFParser(read);
            parser.parse();
            doc = parser.getPDDocument();
            System.out.println(doc.getNumberOfPages());
            System.out.println(doc.getPages().get(0));
            BufferedReader br = new BufferedReader(new InputStreamReader(doc.getPage(0).getContents()));
            System.out.println();
//            PDFTextStripper stripper = new PDFTextStripper();
//            String text = stripper.getText(doc);

//            System.out.println(doc);
//            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
