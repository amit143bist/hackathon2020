package com.docusign.signing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "compositeTemplates", "status", "useDisclosure" })
public class EnvelopeDefinition {

	@JsonProperty("compositeTemplates")
	private List<CompositeTemplate> compositeTemplates = null;
	@JsonProperty("status")
	private String status;
	@JsonProperty("useDisclosure")
	private String useDisclosure;

	@JsonProperty("compositeTemplates")
	public List<CompositeTemplate> getCompositeTemplates() {
		return compositeTemplates;
	}

	@JsonProperty("compositeTemplates")
	public void setCompositeTemplates(List<CompositeTemplate> compositeTemplates) {
		this.compositeTemplates = compositeTemplates;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("useDisclosure")
	public String getUseDisclosure() {
		return useDisclosure;
	}

	@JsonProperty("useDisclosure")
	public void setUseDisclosure(String useDisclosure) {
		this.useDisclosure = useDisclosure;
	}

}