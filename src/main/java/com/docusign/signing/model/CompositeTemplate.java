package com.docusign.signing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "inlineTemplates", "serverTemplates" })
public class CompositeTemplate {

	@JsonProperty("inlineTemplates")
	private List<InlineTemplate> inlineTemplates = null;
	@JsonProperty("serverTemplates")
	private List<ServerTemplate> serverTemplates = null;

	@JsonProperty("inlineTemplates")
	public List<InlineTemplate> getInlineTemplates() {
		return inlineTemplates;
	}

	@JsonProperty("inlineTemplates")
	public void setInlineTemplates(List<InlineTemplate> inlineTemplates) {
		this.inlineTemplates = inlineTemplates;
	}

	@JsonProperty("serverTemplates")
	public List<ServerTemplate> getServerTemplates() {
		return serverTemplates;
	}

	@JsonProperty("serverTemplates")
	public void setServerTemplates(List<ServerTemplate> serverTemplates) {
		this.serverTemplates = serverTemplates;
	}

}