package com.zwaking.common.utils;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.annotations.PdfTextMarkupAnnotationType;
import com.spire.pdf.graphics.PdfTextLayout;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *
 * @author waking
 */
public class PdfUtils {

    public static void spirePdf(String filePath) {
        PdfDocument pdf = new PdfDocument(filePath);

        PdfTableExtractor extractor = new PdfTableExtractor(pdf);
//        System.out.println(pdf.getPages().getCount());
        PdfPageBase pdfpage = pdf.getPages().get(0);
        System.out.println(pdfpage.extractText());
//        System.out.println(pdfpage.extractText());
    }

    public static void pdfBox(String filePath) {
        try {
            PDDocument doc;
            RandomAccessRead read = new RandomAccessFile(new File(filePath), "r");
            PDFParser parser = new PDFParser(read);
            parser.parse();
            doc = parser.getPDDocument();
//            System.out.println(doc.getNumberOfPages());
//            System.out.println(doc.getPages().get(0));
//            BufferedReader br = new BufferedReader(new InputStreamReader(doc.getPage(0).getContents()));
//            br.lines().forEach(string -> System.out.println(string));
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setWordSeparator("|");
            String text = stripper.getText(doc);
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Administrator\\Downloads\\2022AugMonthlySummary.pdf";
        PdfUtils.pdfBox(filePath);
//        PdfUtils.spirePdf(filePath);
    }
}
