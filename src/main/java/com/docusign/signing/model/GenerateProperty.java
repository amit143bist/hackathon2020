package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "base64DataJson", "generateTemplateDocumentId" })
public class GenerateProperty {

	@JsonProperty("base64DataJson")
	private String base64DataJson;
	@JsonProperty("generateTemplateDocumentId")
	private String generateTemplateDocumentId;

	public String getBase64DataJson() {
		return base64DataJson;
	}

	public void setBase64DataJson(String base64DataJson) {
		this.base64DataJson = base64DataJson;
	}

	public String getGenerateTemplateDocumentId() {
		return generateTemplateDocumentId;
	}

	public void setGenerateTemplateDocumentId(String generateTemplateDocumentId) {
		this.generateTemplateDocumentId = generateTemplateDocumentId;
	}

}