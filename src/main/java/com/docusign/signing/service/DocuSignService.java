package com.docusign.signing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.docusign.signing.model.EmbeddedResponse;
import com.docusign.signing.model.RecipientTokenRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DocuSignService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private HttpHeaders headers;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("${docusign.api.baserUrl}")
	private java.lang.String baserUrl;

	@Value("${docusign.api.account}")
	private java.lang.String accountId;

	private HttpHeaders prepareHTTPHeaders(String token) {

		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization", "Bearer" + " " + token);

		return headers;
	}

	public EmbeddedResponse createEmbeddedSigningURL(String envelopeId) {

		RecipientTokenRequest recipientTokenRequest = new RecipientTokenRequest();
		recipientTokenRequest.setAuthenticationMethod("Password");
		recipientTokenRequest.setClientUserId("12345");
		recipientTokenRequest.setEmail("docusign.sso+Signer3@gmail.com");
		recipientTokenRequest.setUserName("Signer3");
		recipientTokenRequest.setReturnUrl(
				"https://www.google.com?envelopeId=[[envelopeId]]&recipientEmail=[[recipientEmail]]&recipientName=[[recipientName]]");
		recipientTokenRequest.setXFrameOptions("allow_from");
		recipientTokenRequest.setXFrameOptionsAllowFromUrl("http://localhost:53134");

		try {

			String msgBody = objectMapper.writeValueAsString(recipientTokenRequest);

			HttpEntity<String> requestEntity = new HttpEntity<String>(msgBody,
					prepareHTTPHeaders("pvcqJmlK6Kbucx4TyVm4NT5OcUA="));
			
			System.out.println("requestEntity>>>>>> " + requestEntity);

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
				System.out.println(exp.getResponseBodyAsString());
				System.out.println(exp.getMostSpecificCause());
			}
		}

		return null;

	}
}