package com.docusign.signing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentId", "recipientId", "templateLocked", "templateRequired", "groupName", "radios", "shared",
		"requireInitialOnSharedChange", "requireAll", "tabType" })
public class RadioGroupTab {

	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("templateLocked")
	private String templateLocked;
	@JsonProperty("templateRequired")
	private String templateRequired;
	@JsonProperty("groupName")
	private String groupName;
	@JsonProperty("radios")
	private List<Radio> radios = null;
	@JsonProperty("shared")
	private String shared;
	@JsonProperty("requireInitialOnSharedChange")
	private String requireInitialOnSharedChange;
	@JsonProperty("requireAll")
	private String requireAll;
	@JsonProperty("tabType")
	private String tabType;

	@JsonProperty("documentId")
	public String getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	@JsonProperty("recipientId")
	public String getRecipientId() {
		return recipientId;
	}

	@JsonProperty("recipientId")
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	@JsonProperty("templateLocked")
	public String getTemplateLocked() {
		return templateLocked;
	}

	@JsonProperty("templateLocked")
	public void setTemplateLocked(String templateLocked) {
		this.templateLocked = templateLocked;
	}

	@JsonProperty("templateRequired")
	public String getTemplateRequired() {
		return templateRequired;
	}

	@JsonProperty("templateRequired")
	public void setTemplateRequired(String templateRequired) {
		this.templateRequired = templateRequired;
	}

	@JsonProperty("groupName")
	public String getGroupName() {
		return groupName;
	}

	@JsonProperty("groupName")
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@JsonProperty("radios")
	public List<Radio> getRadios() {
		return radios;
	}

	@JsonProperty("radios")
	public void setRadios(List<Radio> radios) {
		this.radios = radios;
	}

	@JsonProperty("shared")
	public String getShared() {
		return shared;
	}

	@JsonProperty("shared")
	public void setShared(String shared) {
		this.shared = shared;
	}

	@JsonProperty("requireInitialOnSharedChange")
	public String getRequireInitialOnSharedChange() {
		return requireInitialOnSharedChange;
	}

	@JsonProperty("requireInitialOnSharedChange")
	public void setRequireInitialOnSharedChange(String requireInitialOnSharedChange) {
		this.requireInitialOnSharedChange = requireInitialOnSharedChange;
	}

	@JsonProperty("requireAll")
	public String getRequireAll() {
		return requireAll;
	}

	@JsonProperty("requireAll")
	public void setRequireAll(String requireAll) {
		this.requireAll = requireAll;
	}

	@JsonProperty("tabType")
	public String getTabType() {
		return tabType;
	}

	@JsonProperty("tabType")
	public void setTabType(String tabType) {
		this.tabType = tabType;
	}

}