package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "documentId", "pageNumber", "recipientId", "xPosition", "yPosition", "tabLabel", "value",
		"anchorString", "anchorXOffset", "anchorYOffset", "anchorHorizontalAlignment", "anchorIgnoreIfNotPresent" })
public class TextTab {

	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("pageNumber")
	private String pageNumber;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("xPosition")
	private String xPosition;
	@JsonProperty("yPosition")
	private String yPosition;
	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("value")
	private String value;
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

	@JsonProperty("documentId")
	public String getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	@JsonProperty("pageNumber")
	public String getPageNumber() {
		return pageNumber;
	}

	@JsonProperty("pageNumber")
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	@JsonProperty("recipientId")
	public String getRecipientId() {
		return recipientId;
	}

	@JsonProperty("recipientId")
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	@JsonProperty("xPosition")
	public String getXPosition() {
		return xPosition;
	}

	@JsonProperty("xPosition")
	public void setXPosition(String xPosition) {
		this.xPosition = xPosition;
	}

	@JsonProperty("yPosition")
	public String getYPosition() {
		return yPosition;
	}

	@JsonProperty("yPosition")
	public void setYPosition(String yPosition) {
		this.yPosition = yPosition;
	}

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
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