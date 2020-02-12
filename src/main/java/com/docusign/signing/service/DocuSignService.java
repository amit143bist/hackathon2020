package com.docusign.signing.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.docusign.signing.model.AbstractTab;
import com.docusign.signing.model.CompositeTemplate;
import com.docusign.signing.model.DateTab;
import com.docusign.signing.model.EmailTab;
import com.docusign.signing.model.EmbeddedResponse;
import com.docusign.signing.model.EnvelopeDefinition;
import com.docusign.signing.model.EnvelopeResponse;
import com.docusign.signing.model.GenSendDefinition;
import com.docusign.signing.model.GenerateProperty;
import com.docusign.signing.model.InlineTemplate;
import com.docusign.signing.model.LoanEst;
import com.docusign.signing.model.LoanEstimateDefinition;
import com.docusign.signing.model.Radio;
import com.docusign.signing.model.RadioGroupTab;
import com.docusign.signing.model.RecipientTokenRequest;
import com.docusign.signing.model.Recipients;
import com.docusign.signing.model.ServerTemplate;
import com.docusign.signing.model.SignHereTab;
import com.docusign.signing.model.Signer;
import com.docusign.signing.model.TabContent;
import com.docusign.signing.model.Tabs;
import com.docusign.signing.model.TextTab;
import com.docusign.signing.model.ValidateResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DocuSignService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${docusign.api.baserUrl}")
	private String baserUrl;

	@Value("${docusign.api.account}")
	private String accountId;

	@Value("${docusign.api.radiogrouptabs}")
	private String radioGroupTabs;

	@Value("${docusign.api.texttabs}")
	private String textTabs;

	@Value("${docusign.api.datetabs}")
	private String dateTabs;

	@Value("${docusign.api.emailtabs}")
	private String emailTabs;

	private HttpHeaders prepareHTTPHeaders(String token) {

		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
//		headers.set("Authorization", "Bearer" + " " + token);
		headers.set("X-DocuSign-Authentication",
				"<DocuSignCredentials><Username>{{UserName}}</Username><Password>{{Password}}</Password><IntegratorKey>{{IntegratorKey}}</IntegratorKey></DocuSignCredentials>");

		return headers;
	}

	public EmbeddedResponse createEmbeddedSigningURL(String envelopeId, String applicationId, String applicantName) {

		RecipientTokenRequest recipientTokenRequest = new RecipientTokenRequest();
		recipientTokenRequest.setAuthenticationMethod("Password");
		recipientTokenRequest.setClientUserId(applicationId);
		recipientTokenRequest.setEmail(applicationId + "@dummy.com");
		recipientTokenRequest.setUserName(applicantName);

		if (applicationId.equalsIgnoreCase(applicantName)) {

			recipientTokenRequest.setReturnUrl(
					"http://localhost:53134/genandloadform?envelopeId=[[envelopeId]]&recipientEmail=[[recipientEmail]]&recipientName=[[recipientName]]");
		}
		recipientTokenRequest.setReturnUrl(
				"http://localhost:53134/loanestimatesubmitted?envelopeId=[[envelopeId]]&recipientEmail=[[recipientEmail]]&recipientName=[[recipientName]]");
		recipientTokenRequest.setXFrameOptions("allow_from");
		recipientTokenRequest.setXFrameOptionsAllowFromUrl("http://localhost:53134");

		try {

			String msgBody = objectMapper.writeValueAsString(recipientTokenRequest);

			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody,
					prepareHTTPHeaders("pvcqJmlK6Kbucx4TyVm4NT5OcUA="));

			log.info("requestEntity>>>>>> " + requestEntity);

			return Optional.ofNullable(
					restTemplate.exchange(baserUrl + "/accounts/{accountId}/envelopes/{envelopeId}/views/recipient",
							HttpMethod.POST, requestEntity, EmbeddedResponse.class, accountId, envelopeId))
					.map(response -> {

						Assert.notNull(response.getBody().getUrl(), "URL is null for enevelopeId " + envelopeId);
						Assert.isTrue(response.getStatusCode().is2xxSuccessful(),
								" embedded response did not return 200 status code");

						return response.getBody();
					}).orElseThrow(() -> new RuntimeException("URL not created for envelopeId " + envelopeId));

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				log.info(exp.getResponseBodyAsString());
				log.info(exp.getMostSpecificCause().toString());
			}
		}

		return null;

	}

	public String createEnvelope(String applicationId) {

		EnvelopeDefinition request = new EnvelopeDefinition();
		List<CompositeTemplate> compositeTemplateList = new ArrayList<CompositeTemplate>();
		compositeTemplateList.add(createCompositeTemplate(applicationId));

		request.setCompositeTemplates(compositeTemplateList);
		request.setStatus("sent");
		request.setUseDisclosure("false");

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		String envelopeId = null;
		try {

			String msgBody = objectMapper.writeValueAsString(request);

			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody,
					prepareHTTPHeaders("pvcqJmlK6Kbucx4TyVm4NT5OcUA="));

			log.info("EnvelopeService.createEnvelope() " + requestEntity);

			envelopeId = restTemplate.exchange(baserUrl + "/accounts/{accountId}/envelopes", HttpMethod.POST,
					requestEntity, EnvelopeResponse.class, accountId).getBody().getEnvelopeId();

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				log.info(exp.getResponseBodyAsString());
				log.info(exp.getMostSpecificCause().toString());
			}
		}

		return envelopeId;
	}

	/**
	 * @param applicationId
	 * @return
	 */
	private CompositeTemplate createCompositeTemplate(String applicationId) {
		Recipients recipients = createRecipient(applicationId, false, null);

		InlineTemplate inlineTemplate = new InlineTemplate();
		inlineTemplate.setRecipients(recipients);
		inlineTemplate.setSequence("2");

		ServerTemplate serverTemplate = new ServerTemplate();
		serverTemplate.setTemplateId("9e46bad4-7689-4f04-abcd-b8e9bb06f998");
		serverTemplate.setSequence("1");

		List<ServerTemplate> serverTemplateList = new ArrayList<ServerTemplate>();
		serverTemplateList.add(serverTemplate);

		List<InlineTemplate> inlineTemplateList = new ArrayList<InlineTemplate>();
		inlineTemplateList.add(inlineTemplate);

		CompositeTemplate compositeTemplate = new CompositeTemplate();
		compositeTemplate.setServerTemplates(serverTemplateList);
		compositeTemplate.setInlineTemplates(inlineTemplateList);
		return compositeTemplate;
	}

	private Tabs readTabData(String envelopeId) {

		try {
			Thread.sleep(7000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		log.info("DocuSignService.readTabData() for envelopeId: {}", envelopeId);

		HttpEntity<String> requestEntity = new HttpEntity<String>(prepareHTTPHeaders("pvcqJmlK6Kbucx4TyVm4NT5OcUA="));
		Tabs tabs = restTemplate.exchange(baserUrl + "/accounts/{accountId}/envelopes/{envelopeId}/recipients/1/tabs",
				HttpMethod.GET, requestEntity, Tabs.class, accountId, envelopeId).getBody();

		return tabs;
	}

	public LoanEstimateDefinition calculateLoanEstimateDefinition(String envelopeId) {

		Tabs tabs = readTabData(envelopeId);

		LoanEstimateDefinition loanEstimateDefinition = new LoanEstimateDefinition();
		loanEstimateDefinition.setLoanEst(populateLoanEst(tabs));

		return loanEstimateDefinition;
	}

	/**
	 * @param tabs
	 * @return
	 */
	private LoanEst populateLoanEst(Tabs tabs) {
		Map<String, String> radioGroupsMap = Pattern.compile("\\s*,\\s*").splitAsStream(radioGroupTabs.trim())
				.map(s -> s.split(",")).collect(Collectors.toMap(a -> a[0], a -> ""));

		Map<String, String> textTabsMap = Pattern.compile("\\s*,\\s*").splitAsStream(textTabs.trim())
				.map(s -> s.split(",")).collect(Collectors.toMap(a -> a[0], a -> ""));

		Map<String, String> dateTabsMap = Pattern.compile("\\s*,\\s*").splitAsStream(dateTabs.trim())
				.map(s -> s.split(",")).collect(Collectors.toMap(a -> a[0], a -> ""));

		Map<String, String> emailTabsMap = Pattern.compile("\\s*,\\s*").splitAsStream(emailTabs.trim())
				.map(s -> s.split(",")).collect(Collectors.toMap(a -> a[0], a -> ""));

		int completedFieldCount = 0;

		List<TabContent> tabContentList = new ArrayList<TabContent>();

		completedFieldCount = calculateCompletedCount(tabs, radioGroupsMap, textTabsMap, dateTabsMap, emailTabsMap,
				completedFieldCount, tabContentList);

		LoanEst loanEst = new LoanEst();

		loanEst.setPurpose(radioGroupsMap.get("Property_Use"));
		loanEst.setLoanType(radioGroupsMap.get("Loan_Type"));
		loanEst.setLoanID(UUID.randomUUID().toString());
		loanEst.setRateLock("Yes");

		loanEst.setApplicateName(textTabsMap.get("Borrower_Name"));
		loanEst.setApplicateAddress1(textTabsMap.get("Borrower_Address"));
		loanEst.setApplicateAddress2(textTabsMap.get("Borrower_City") + "," + textTabsMap.get("Borrower_State") + ","
				+ textTabsMap.get("Borrower_Zip"));

		populateLoanEstData(loanEst, radioGroupsMap.get("Finance_OPtion"), textTabsMap.get("Loan_Amount"));

		log.info("TotalRequiredFieldCount is {} and completedFieldCount is {}", tabContentList.size(),
				completedFieldCount);

		loanEst.setTotalRequiredFieldCount(tabContentList.size());
		loanEst.setCompletedFieldCount(completedFieldCount);
		loanEst.setTabContentList(tabContentList);
		return loanEst;
	}

	/**
	 * @param tabs
	 * @param radioGroupsMap
	 * @param completedFieldCount
	 * @param tabContentList
	 * @return
	 */
	private int calculateCompletedCount(Tabs tabs, Map<String, String> radioGroupsMap, Map<String, String> textTabsMap,
			Map<String, String> dateTabsMap, Map<String, String> emailTabsMap, int completedFieldCount,
			List<TabContent> tabContentList) {

		List<RadioGroupTab> radioGroupTabs = tabs.getRadioGroupTabs();
		for (RadioGroupTab radioTab : radioGroupTabs) {

			for (Map.Entry<String, String> radioEntry : radioGroupsMap.entrySet()) {

				if (radioEntry.getKey().equalsIgnoreCase(radioTab.getGroupName())) {

					TabContent tabContent = new TabContent();
					tabContent.setTabIdName(radioTab.getGroupName());

					List<Radio> radioValues = radioTab.getRadios();
					for (Radio radio : radioValues) {
						if ("true".equalsIgnoreCase(radio.getSelected())) {

							tabContent.setTabComplete("true");
							completedFieldCount++;
							radioEntry.setValue(radio.getValue());
							break;
						}
					}

					tabContentList.add(tabContent);

				}

			}

		}

		for (TextTab textTab : tabs.getTextTabs()) {

			for (Map.Entry<String, String> textEntry : textTabsMap.entrySet()) {

				if (textEntry.getKey().equalsIgnoreCase(textTab.getTabLabel())) {

					completedFieldCount = countAndCreateTabContent(completedFieldCount, tabContentList, textTab,
							textEntry);
				}

			}

		}

		for (DateTab dateTab : tabs.getDateTabs()) {

			for (Map.Entry<String, String> dateTabEntry : dateTabsMap.entrySet()) {

				if (dateTabEntry.getKey().equalsIgnoreCase(dateTab.getTabLabel())) {

					completedFieldCount = countAndCreateTabContent(completedFieldCount, tabContentList, dateTab,
							dateTabEntry);
				}
			}

		}

		for (EmailTab emailTab : tabs.getEmailTabs()) {

			for (Map.Entry<String, String> emailTabEntry : emailTabsMap.entrySet()) {

				if (emailTabEntry.getKey().equalsIgnoreCase(emailTab.getTabLabel())) {

					completedFieldCount = countAndCreateTabContent(completedFieldCount, tabContentList, emailTab,
							emailTabEntry);
				}
			}

		}

		return completedFieldCount;
	}

	/**
	 * @param completedFieldCount
	 * @param tabContentList
	 * @param emailTab
	 * @return
	 */
	private int countAndCreateTabContent(int completedFieldCount, List<TabContent> tabContentList,
			AbstractTab abstractTab, Map.Entry<String, String> textEntry) {
		TabContent tabContent = new TabContent();
		tabContent.setTabIdName(abstractTab.getTabLabel());

		if (!StringUtils.isEmpty(abstractTab.getValue())) {

			completedFieldCount++;
			tabContent.setTabComplete("true");

			textEntry.setValue(abstractTab.getValue());
		}

		tabContentList.add(tabContent);
		return completedFieldCount;
	}

	/**
	 * @param loanEst
	 * @param loanTenure
	 * @param loanAmount
	 */
	private void populateLoanEstData(LoanEst loanEst, String loanTenure, String loanAmount) {

		loanEst.setDateIssued("02-05-2020");
		loanEst.setProperty("80118-4264");

		if (!StringUtils.isEmpty(loanAmount)) {

			if (loanAmount.contains("200000")) {

				if (loanTenure.contains("10")) {

					loanEst.setLoanAmount(loanAmount);
					loanEst.setInterestRate("3.65");
					loanEst.setLoanTerm("10");
					loanEst.setMonthlyPayment("2500");
					loanEst.setPrincipaleAndInterest("1992");
					loanEst.setMortgageInsurance("10");
					loanEst.setEscrowAmount("4100");
					loanEst.setEstimates("450");
					loanEst.setClosingCost("48000");
					loanEst.setCashToClose("53000");

				} else if (loanTenure.contains("15")) {

					loanEst.setLoanAmount(loanAmount);
					loanEst.setInterestRate("3.75");
					loanEst.setLoanTerm("15");
					loanEst.setMonthlyPayment("1954");
					loanEst.setPrincipaleAndInterest("1454");
					loanEst.setMortgageInsurance("10");
					loanEst.setEscrowAmount("4100");
					loanEst.setEstimates("450");
					loanEst.setClosingCost("48000");
					loanEst.setCashToClose("53000");

				} else if (loanTenure.contains("30")) {

					loanEst.setLoanAmount(loanAmount);
					loanEst.setInterestRate("3.99");
					loanEst.setLoanTerm("30");
					loanEst.setMonthlyPayment("1453");
					loanEst.setPrincipaleAndInterest("954");
					loanEst.setMortgageInsurance("10");
					loanEst.setEscrowAmount("4100");
					loanEst.setEstimates("450");
					loanEst.setClosingCost("48000");
					loanEst.setCashToClose("53000");

				}
			} else if (loanAmount.contains("250000")) {

				if (loanTenure.contains("10")) {

					loanEst.setLoanAmount(loanAmount);
					loanEst.setInterestRate("3.65");
					loanEst.setLoanTerm("10");
					loanEst.setMonthlyPayment("2990");
					loanEst.setPrincipaleAndInterest("2490");
					loanEst.setMortgageInsurance("10");
					loanEst.setEscrowAmount("4100");
					loanEst.setEstimates("450");
					loanEst.setClosingCost("52000");
					loanEst.setCashToClose("59000");

				} else if (loanTenure.contains("15")) {

					loanEst.setLoanAmount(loanAmount);
					loanEst.setInterestRate("3.75");
					loanEst.setLoanTerm("15");
					loanEst.setMonthlyPayment("2318");
					loanEst.setPrincipaleAndInterest("1818");
					loanEst.setMortgageInsurance("10");
					loanEst.setEscrowAmount("4100");
					loanEst.setEstimates("450");
					loanEst.setClosingCost("52000");
					loanEst.setCashToClose("59000");

				} else if (loanTenure.contains("30")) {

					loanEst.setLoanAmount(loanAmount);
					loanEst.setInterestRate("3.65");
					loanEst.setLoanTerm("30");
					loanEst.setMonthlyPayment("1692");
					loanEst.setPrincipaleAndInterest("1192");
					loanEst.setMortgageInsurance("10");
					loanEst.setEscrowAmount("4100");
					loanEst.setEstimates("450");
					loanEst.setClosingCost("52000");
					loanEst.setCashToClose("59000");
				}
			} else {

				loanEst.setLoanAmount(loanAmount);
				loanEst.setInterestRate("3.65");
				loanEst.setLoanTerm("30");
				loanEst.setMonthlyPayment("1692");
				loanEst.setPrincipaleAndInterest("1192");
				loanEst.setMortgageInsurance("10");
				loanEst.setEscrowAmount("4100");
				loanEst.setEstimates("450");
				loanEst.setClosingCost("52000");
				loanEst.setCashToClose("59000");
			}
		}
	}

	public ValidateResponse validateData(String envelopeId, String applicationId) {

		Tabs tabs = readTabData(envelopeId);

		String applicationCity = null;
		String applicationState = null;
		String applicationZip = null;

		List<TextTab> textTabList = tabs.getTextTabs();
		for (TextTab textTab : textTabList) {

			if ("Borrower_State".equalsIgnoreCase(textTab.getTabLabel())) {

				if (!StringUtils.isEmpty(textTab.getValue())) {

					applicationState = textTab.getValue();
				}
			}

			if ("Borrower_City".equalsIgnoreCase(textTab.getTabLabel())) {

				if (!StringUtils.isEmpty(textTab.getValue())) {

					applicationCity = textTab.getValue();
				}
			}

			if ("Borrower_Zip".equalsIgnoreCase(textTab.getTabLabel())) {

				if (!StringUtils.isEmpty(textTab.getValue())) {

					applicationZip = textTab.getValue();
				}
			}
		}

		String xmlData = "<CityStateLookupRequest USERID=\"935USTGL7449\">" + "<ZipCode>" + "<Zip5>" + applicationZip
				+ "</Zip5>" + "</ZipCode>" + "</CityStateLookupRequest>";

		HttpEntity<String> requestEntity = new HttpEntity<>(null);
		String response = restTemplate
				.exchange("https://secure.shippingapis.com/shippingapi.dll?API=CityStateLookup&XML=" + xmlData,
						HttpMethod.POST, requestEntity, String.class)
				.getBody();

		ValidateResponse validateResponse = new ValidateResponse();
		if (!StringUtils.isEmpty(applicationCity) && !response.contains(applicationCity.toUpperCase())) {

			validateResponse.setStatus("failure");
			validateResponse.setErrorMessage("City " + applicationCity + " not valid for Zip " + applicationZip);

			return validateResponse;
		}

		if (!StringUtils.isEmpty(applicationState) && !response.contains(applicationState.toUpperCase())) {

			validateResponse.setStatus("failure");
			validateResponse.setErrorMessage("State " + applicationState + " not valid for Zip " + applicationZip);

			return validateResponse;
		}

		validateResponse.setLoanEst(populateLoanEst(tabs));
		validateResponse.setStatus("success");
		validateResponse.setRedirectUrl(
				"/genAndSubmitSpringCMData?envelopeId=" + envelopeId + "&applicationId=" + applicationId);

		return validateResponse;
	}

	public String generateAndSendSpringEnvelope(String envelopeId, String applicationId) {

		GenerateProperty generateProperty = new GenerateProperty();

		LoanEstimateDefinition loanEstimateDefinition = calculateLoanEstimateDefinition(envelopeId);
		try {
			generateProperty.setBase64DataJson(Base64.getEncoder()
					.encodeToString(objectMapper.writeValueAsString(loanEstimateDefinition).getBytes()));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		generateProperty.setGenerateTemplateDocumentId("30d41056-cd07-ea11-9c2b-3ca82a1e3f41");
		List<GenerateProperty> generateProperties = new ArrayList<GenerateProperty>();
		generateProperties.add(generateProperty);

		GenSendDefinition genSendDefinition = new GenSendDefinition();
		genSendDefinition.setGenerateProperties(generateProperties);

		Recipients recipients = createRecipient(applicationId, true,
				loanEstimateDefinition.getLoanEst().getApplicateName());
		genSendDefinition.setRecipients(recipients);

		genSendDefinition.setStatus("sent");
		genSendDefinition.setEmailSubject("Loan Estimate");

		String springEnvelopeId = null;
		try {

			String msgBody = objectMapper.writeValueAsString(genSendDefinition);

			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody,
					prepareHTTPHeaders("pvcqJmlK6Kbucx4TyVm4NT5OcUA="));

			log.info("EnvelopeService.generateAndSendSpringEnvelope() " + requestEntity);

			springEnvelopeId = restTemplate.exchange(baserUrl + "/accounts/{accountId}/envelopes/generate_and_send",
					HttpMethod.POST, requestEntity, EnvelopeResponse.class, accountId).getBody().getEnvelopeId();

		} catch (Exception e) {
			e.printStackTrace();

			if (e instanceof HttpClientErrorException) {

				HttpClientErrorException exp = (HttpClientErrorException) e;
				log.info(exp.getResponseBodyAsString());
				log.info(exp.getMostSpecificCause().toString());
			}
		}

		return createEmbeddedSigningURL(springEnvelopeId, applicationId,
				loanEstimateDefinition.getLoanEst().getApplicateName()).getUrl();
	}

	/**
	 * @param postMessage
	 * @param submitterName
	 * @return
	 */
	private Recipients createRecipient(String applicationId, boolean forSpringAPI, String applicantName) {

		Recipients recipients = new Recipients();
		Signer signer = new Signer();
		signer.setRecipientId("1");
		signer.setRoleName("Signer");
		signer.setClientUserId(applicationId);
		signer.setEmail(applicationId + "@dummy.com");

		Tabs signerTabs = new Tabs();
		if (forSpringAPI) {

			signer.setName(applicantName);

			SignHereTab signHereTab = new SignHereTab();
			signHereTab.setAnchorString("$si1$");
			signHereTab.setAnchorHorizontalAlignment("Right");

			List<SignHereTab> signHereTabList = new ArrayList<SignHereTab>();
			signHereTabList.add(signHereTab);

			signerTabs.setSignHereTabs(signHereTabList);
		} else {

			signer.setName(applicationId);

			TextTab postMessageTab = new TextTab();
			postMessageTab.setTabLabel("Appication_ID");
			postMessageTab.setValue(applicationId);

			List<TextTab> textTabList = new ArrayList<TextTab>();
			textTabList.add(postMessageTab);

			signerTabs.setTextTabs(textTabList);
		}

		signer.setTabs(signerTabs);

		List<Signer> signerList = new ArrayList<Signer>();
		signerList.add(signer);

		recipients.setSigners(signerList);
		return recipients;
	}
}