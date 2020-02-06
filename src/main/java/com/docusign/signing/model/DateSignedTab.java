package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "tabLabel", "documentId", "recipientId", "pageNumber", "anchorString", "anchorXOffset",
		"anchorYOffset", "anchorHorizontalAlignment", "anchorIgnoreIfNotPresent" })
public class DateSignedTab {

	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("pageNumber")
	private String pageNumber;
	@JsonProperty("anchorString")
	private String anchorString;
	@JsonProperty("anchorXOffset")
	private String anchorXOffset;
	@JsonProperty("anchorYOffset")
	private String anchorYOffset;
	@JsonProperty("anchorHorizontalAlignment")
	private String anchorHorizontalAlignment;
	@JsonProperty("anchorIgnoreIfNotPresent")
	private String anchorIgnoreIfNotPresent;

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}

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

	@JsonProperty("pageNumber")
	public String getPageNumber() {
		return pageNumber;
	}

	@JsonProperty("pageNumber")
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	@JsonProperty("anchorString")
	public String getAnchorString() {
		return anchorString;
	}

	@JsonProperty("anchorString")
	public void setAnchorString(String anchorString) {
		this.anchorString = anchorString;
	}

	@JsonProperty("anchorXOffset")
	public String getAnchorXOffset() {
		return anchorXOffset;
	}

	@JsonProperty("anchorXOffset")
	public void setAnchorXOffset(String anchorXOffset) {
		this.anchorXOffset = anchorXOffset;
	}

	@JsonProperty("anchorYOffset")
	public String getAnchorYOffset() {
		return anchorYOffset;
	}

	@JsonProperty("anchorYOffset")
	public void setAnchorYOffset(String anchorYOffset) {
		this.anchorYOffset = anchorYOffset;
	}

	@JsonProperty("anchorHorizontalAlignment")
	public String getAnchorHorizontalAlignment() {
		return anchorHorizontalAlignment;
	}

	@JsonProperty("anchorHorizontalAlignment")
	public void setAnchorHorizontalAlignment(String anchorHorizontalAlignment) {
		this.anchorHorizontalAlignment = anchorHorizontalAlignment;
	}

	@JsonProperty("anchorIgnoreIfNotPresent")
	public String getAnchorIgnoreIfNotPresent() {
		return anchorIgnoreIfNotPresent;
	}

	@JsonProperty("anchorIgnoreIfNotPresent")
	public void setAnchorIgnoreIfNotPresent(String anchorIgnoreIfNotPresent) {
		this.anchorIgnoreIfNotPresent = anchorIgnoreIfNotPresent;
	}
}