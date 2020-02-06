package com.docusign.signing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "generateProperties", "recipients", "status", "emailSubject" })
public class GenSendDefinition {

	@JsonProperty("generateProperties")
	private List<GenerateProperty> generateProperties = null;
	@JsonProperty("recipients")
	private Recipients recipients;
	@JsonProperty("status")
	private String status;
	@JsonProperty("emailSubject")
	private String emailSubject;

	@JsonProperty("generateProperties")
	public List<GenerateProperty> getGenerateProperties() {
		return generateProperties;
	}

	@JsonProperty("generateProperties")
	public void setGenerateProperties(List<GenerateProperty> generateProperties) {
		this.generateProperties = generateProperties;
	}

	@JsonProperty("recipients")
	public Recipients getRecipients() {
		return recipients;
	}

	@JsonProperty("recipients")
	public void setRecipients(Recipients recipients) {
		this.recipients = recipients;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("emailSubject")
	public String getEmailSubject() {
		return emailSubject;
	}

	@JsonProperty("emailSubject")
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

}