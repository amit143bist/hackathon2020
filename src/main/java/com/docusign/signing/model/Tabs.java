package com.docusign.signing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "signHereTabs", "textTabs", "initialHereTabs", "dateSignedTabs", "radioGroupTabs" })
public class Tabs {

	@JsonProperty("signHereTabs")
	private List<SignHereTab> signHereTabs = null;
	@JsonProperty("textTabs")
	private List<TextTab> textTabs = null;
	@JsonProperty("initialHereTabs")
	private List<InitialHereTab> initialHereTabs = null;
	@JsonProperty("dateSignedTabs")
	private List<DateSignedTab> dateSignedTabs = null;
	@JsonProperty("radioGroupTabs")
	private List<RadioGroupTab> radioGroupTabs = null;

	@JsonProperty("signHereTabs")
	public List<SignHereTab> getSignHereTabs() {
		return signHereTabs;
	}

	@JsonProperty("signHereTabs")
	public void setSignHereTabs(List<SignHereTab> signHereTabs) {
		this.signHereTabs = signHereTabs;
	}

	@JsonProperty("textTabs")
	public List<TextTab> getTextTabs() {
		return textTabs;
	}

	@JsonProperty("textTabs")
	public void setTextTabs(List<TextTab> textTabs) {
		this.textTabs = textTabs;
	}

	@JsonProperty("initialHereTabs")
	public List<InitialHereTab> getInitialHereTabs() {
		return initialHereTabs;
	}

	@JsonProperty("initialHereTabs")
	public void setInitialHereTabs(List<InitialHereTab> initialHereTabs) {
		this.initialHereTabs = initialHereTabs;
	}

	@JsonProperty("dateSignedTabs")
	public List<DateSignedTab> getDateSignedTabs() {
		return dateSignedTabs;
	}

	@JsonProperty("dateSignedTabs")
	public void setDateSignedTabs(List<DateSignedTab> dateSignedTabs) {
		this.dateSignedTabs = dateSignedTabs;
	}

	@JsonProperty("radioGroupTabs")
	public List<RadioGroupTab> getRadioGroupTabs() {
		return radioGroupTabs;
	}

	@JsonProperty("radioGroupTabs")
	public void setRadioGroupTabs(List<RadioGroupTab> radioGroupTabs) {
		this.radioGroupTabs = radioGroupTabs;
	}
}