package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tabIdName", "tabComplete" })
public class TabContent {

	@JsonProperty("tabIdName")
	private String tabIdName;
	@JsonProperty("tabComplete")
	private String tabComplete = "false";

	@JsonProperty("tabIdName")
	public String getTabIdName() {
		return tabIdName;
	}

	@JsonProperty("tabIdName")
	public void setTabIdName(String tabIdName) {
		this.tabIdName = tabIdName;
	}

	@JsonProperty("tabComplete")
	public String getTabComplete() {
		return tabComplete;
	}

	@JsonProperty("tabComplete")
	public void setTabComplete(String tabComplete) {
		this.tabComplete = tabComplete;
	}
}