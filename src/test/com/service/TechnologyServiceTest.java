package com.service;

import com.robot.util.Constant;
import com.robot.util.Office2PDFUtil;
import com.robot.util.Pdf2htmlEXUtil;
import org.junit.Test;

import java.io.File;

/**
 * @author asce
 * @date 2018/9/26
 */
public class TechnologyServiceTest {

    String inPath = Constant.FILE_PATH+"office/docTest.doc";
    String outPath = Constant.FILE_PATH+"pdf/pdfTest.pdf";
    String htmlPath = Constant.FILE_PATH+"html/htmlTest.html";

    String pdfPath = "pdf/pdfTest.pdf";
    //String htmlPath = "html/htmlTest.pdf";

    @Test
    public void testOfficeCovertPdf(){
        Office2PDFUtil.office2PDF(inPath,outPath);
    }

    @Test
    public void testPdfCovertHtml(){
        Pdf2htmlEXUtil.pdf2html(outPath,htmlPath);
    }

    @Test
    public void testPath(){
        System.out.println(inPath);
        System.out.println(outPath);
    }
}
