package com.docusign.signing.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.docusign.signing.QRCodeReader;
import com.docusign.signing.model.EmbeddedResponse;
import com.docusign.signing.service.DocuSignService;

@Controller
public class WebsiteController {

	@Autowired
	DocuSignService docuSignService;

	@RequestMapping(value = "/readimage", method = RequestMethod.GET)
	public String readimage(@RequestParam(value = "envelopeId", required = true) String envelopeId, Model model) {

		model.addAttribute("envelopeId", envelopeId);
		return "capture-qrimage";
	}

	@ResponseBody
	@RequestMapping(value = "/saveProfileData", method = RequestMethod.POST)
	public String saveProfileData(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("WebsiteController.saveProfileData() ");

		try {

			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
			String url = QRCodeReader.decodeQRCodeFromStream(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// int i = code for save profile data.
		return "success";
	}

	@RequestMapping(value = "/renderSignatureScreen", method = RequestMethod.GET)
	public String renderAuditReport(@RequestParam(value = "envelopeId", required = true) String envelopeId,
			Model model) {

		model.addAttribute("envelopeId", envelopeId);
		return "oracle-signature";
	}

	@RequestMapping(value = "/fetchEmbeddedUrl", method = RequestMethod.GET)
	public @ResponseBody EmbeddedResponse fetchEmbeddedUrl(
			@RequestParam(value = "envelopeId", required = true) String envelopeId) {

		return docuSignService.createEmbeddedSigningURL(envelopeId);
	}
}