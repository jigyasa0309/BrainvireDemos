package com.adminSystem.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adminSystem.entity.OTSEntity;
import com.adminSystem.service.OTSService;
import com.adminSystem.service.PdfGenerationService;
import com.itextpdf.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PdfController {

	@Autowired
	private PdfGenerationService pdfGenerationService;

	@Autowired
	private OTSService otsService;

	@RequestMapping("/generatePdf/{id}")
	public void generatePdf(@PathVariable("id") Long id, HttpServletResponse response)
			throws IOException, DocumentException {
		OTSEntity record = otsService.getEntryById(id);

		byte[] pdfBytes = pdfGenerationService.generatePdf(record);

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"record_" + id + ".pdf\"");
		response.getOutputStream().write(pdfBytes);
	}
}
