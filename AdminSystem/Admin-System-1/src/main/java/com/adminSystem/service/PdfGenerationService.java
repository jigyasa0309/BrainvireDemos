package com.adminSystem.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.adminSystem.entity.OTSEntity; 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfGenerationService {

    public byte[] generatePdf(OTSEntity record) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();

        document.add(new Paragraph("ID: " + record.getId()));
        document.add(new Paragraph("Accounts: " + record.getAccounts()));
        document.add(new Paragraph("Customer Name: " + record.getCustomerName()));
        document.add(new Paragraph("OTS Amount: " + record.getOtsAmount()));
        document.add(new Paragraph("Sanction Date: " + record.getSanctionDate()));
        document.add(new Paragraph("Expiry Date: " + record.getExpiryDate()));
        document.add(new Paragraph("Updated By: " + record.getUpdatedBy()));
        document.add(new Paragraph("Creation Time: " + record.getCreationTime()));

        document.close();

        return baos.toByteArray();
    }
}
