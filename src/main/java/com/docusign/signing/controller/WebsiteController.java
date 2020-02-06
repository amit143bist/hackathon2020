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
import com.docusign.signing.model.LoanEstimateDefinition;
import com.docusign.signing.model.ValidateResponse;
import com.docusign.signing.service.DocuSignService;

@Controller
public class WebsiteController {

	@Autowired
	DocuSignService docuSignService;

	@RequestMapping(value = "/readImage", method = RequestMethod.GET)
	public String readimage(Model model) {

		System.out.println("WebsiteController.readimage() ");
		return "capture-qrimage";
	}

	@RequestMapping(value = "/saveProfileData", method = RequestMethod.POST)
	public String saveProfileData(HttpServletRequest request, HttpServletResponse response, Model model) {

		System.out.println("WebsiteController.saveProfileData() ");

		String envelopeId = null;
		String applicationId = null;
		try {

			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
			String url = QRCodeReader.decodeQRCodeFromStream(fileContent);

			String[] urlArr = url.split("applicationId=");
			applicationId = urlArr[1];

			System.out.println("WebsiteController.saveProfileData() applicationId " + applicationId);

			envelopeId = docuSignService.createEnvelope(applicationId);

			System.out.println("WebsiteController.saveProfileData() envelopeId " + envelopeId);

			model.addAttribute("envelopeId", envelopeId);
			model.addAttribute("applicationId", applicationId);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "redirect:renderSignatureScreen?envelopeId=" + envelopeId + "&applicationId=" + applicationId;
	}

	@RequestMapping(value = "/renderSignatureScreen", method = RequestMethod.GET)
	public String renderAuditReport(@RequestParam(value = "envelopeId", required = true) String envelopeId,
			@RequestParam(value = "applicationId", required = true) String applicationId, Model model) {

		System.out.println("WebsiteController.renderAuditReport() " + envelopeId + " applicationId " + applicationId);

		model.addAttribute("envelopeId", envelopeId);
		model.addAttribute("applicationId", applicationId);
		return "oracle-signature";
	}

	@RequestMapping(value = "/loadAppData", method = RequestMethod.GET)
	public @ResponseBody LoanEstimateDefinition loadAppData(
			@RequestParam(value = "envelopeId", required = true) String envelopeId,
			@RequestParam(value = "applicationId", required = true) String applicationId, Model model) {

		System.out.println("WebsiteController.loadAppData() " + envelopeId + " applicationId " + applicationId);

		model.addAttribute("envelopeId", envelopeId);
		model.addAttribute("applicationId", applicationId);

		return docuSignService.calculateLoanEstimateDefinition(envelopeId);
	}

	@RequestMapping(value = "/validateData", method = RequestMethod.POST)
	public @ResponseBody ValidateResponse validateData(
			@RequestParam(value = "envelopeId", required = true) String envelopeId,
			@RequestParam(value = "applicationId", required = true) String applicationId, Model model) {

		System.out.println("WebsiteController.validateData() " + envelopeId + " applicationId " + applicationId);

		model.addAttribute("envelopeId", envelopeId);
		model.addAttribute("applicationId", applicationId);

		return docuSignService.validateData(envelopeId, applicationId);
	}

	@RequestMapping(value = "/genAndSubmitSpringCMData", method = RequestMethod.GET)
	public String genAndSubmitSpringCMData(@RequestParam(value = "envelopeId", required = true) String envelopeId,
			@RequestParam(value = "applicationId", required = true) String applicationId, Model model) {

		System.out.println(
				"WebsiteController.genAndSubmitSpringCMData() " + envelopeId + " applicationId " + applicationId);

		model.addAttribute("envelopeId", envelopeId);
		model.addAttribute("applicationId", applicationId);

		return "redirect:" + docuSignService.generateAndSendSpringEnvelope(envelopeId, applicationId);
	}

	@RequestMapping(value = "/fetchEmbeddedUrl", method = RequestMethod.GET)
	public @ResponseBody EmbeddedResponse fetchEmbeddedUrl(
			@RequestParam(value = "envelopeId", required = true) String envelopeId,
			@RequestParam(value = "applicationId", required = true) String applicationId, Model model) {

		System.out.println("WebsiteController.fetchEmbeddedUrl () " + model.getAttribute("envelopeId")
				+ " applicationId " + model.getAttribute("applicationId"));

		return docuSignService.createEmbeddedSigningURL(envelopeId, applicationId, applicationId);
	}
}