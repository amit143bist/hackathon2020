package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "validationPattern", "validationMessage", "shared", "requireInitialOnSharedChange", "requireAll",
		"value", "width", "required", "locked", "concealValueOnDocument", "disableAutoSize", "maxLength", "tabLabel",
		"font", "fontColor", "fontSize", "documentId", "recipientId", "pageNumber", "xPosition", "yPosition", "tabId",
		"templateLocked", "templateRequired", "anchorString", "anchorXOffset", "anchorYOffset",
		"anchorHorizontalAlignment", "anchorIgnoreIfNotPresent" })
public abstract class AbstractTab {

	@JsonProperty("validationPattern")
	private String validationPattern;
	@JsonProperty("validationMessage")
	private String validationMessage;
	@JsonProperty("shared")
	private String shared;
	@JsonProperty("requireInitialOnSharedChange")
	private String requireInitialOnSharedChange;
	@JsonProperty("requireAll")
	private String requireAll;
	@JsonProperty("value")
	private String value;
	@JsonProperty("width")
	private Integer width;
	@JsonProperty("required")
	private String required;
	@JsonProperty("locked")
	private String locked;
	@JsonProperty("concealValueOnDocument")
	private String concealValueOnDocument;
	@JsonProperty("disableAutoSize")
	private String disableAutoSize;
	@JsonProperty("maxLength")
	private Integer maxLength;
	@JsonProperty("tabLabel")
	private String tabLabel;
	@JsonProperty("font")
	private String font;
	@JsonProperty("fontColor")
	private String fontColor;
	@JsonProperty("fontSize")
	private String fontSize;
	@JsonProperty("documentId")
	private String documentId;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("pageNumber")
	private String pageNumber;
	@JsonProperty("xPosition")
	private String xPosition;
	@JsonProperty("yPosition")
	private String yPosition;
	@JsonProperty("tabId")
	private String tabId;
	@JsonProperty("templateLocked")
	private String templateLocked;
	@JsonProperty("templateRequired")
	private String templateRequired;
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

	@JsonProperty("validationPattern")
	public String getValidationPattern() {
		return validationPattern;
	}

	@JsonProperty("validationPattern")
	public void setValidationPattern(String validationPattern) {
		this.validationPattern = validationPattern;
	}

	@JsonProperty("validationMessage")
	public String getValidationMessage() {
		return validationMessage;
	}

	@JsonProperty("validationMessage")
	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
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

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("width")
	public Integer getWidth() {
		return width;
	}

	@JsonProperty("width")
	public void setWidth(Integer width) {
		this.width = width;
	}

	@JsonProperty("required")
	public String getRequired() {
		return required;
	}

	@JsonProperty("required")
	public void setRequired(String required) {
		this.required = required;
	}

	@JsonProperty("locked")
	public String getLocked() {
		return locked;
	}

	@JsonProperty("locked")
	public void setLocked(String locked) {
		this.locked = locked;
	}

	@JsonProperty("concealValueOnDocument")
	public String getConcealValueOnDocument() {
		return concealValueOnDocument;
	}

	@JsonProperty("concealValueOnDocument")
	public void setConcealValueOnDocument(String concealValueOnDocument) {
		this.concealValueOnDocument = concealValueOnDocument;
	}

	@JsonProperty("disableAutoSize")
	public String getDisableAutoSize() {
		return disableAutoSize;
	}

	@JsonProperty("disableAutoSize")
	public void setDisableAutoSize(String disableAutoSize) {
		this.disableAutoSize = disableAutoSize;
	}

	@JsonProperty("maxLength")
	public Integer getMaxLength() {
		return maxLength;
	}

	@JsonProperty("maxLength")
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	@JsonProperty("tabLabel")
	public String getTabLabel() {
		return tabLabel;
	}

	@JsonProperty("tabLabel")
	public void setTabLabel(String tabLabel) {
		this.tabLabel = tabLabel;
	}

	@JsonProperty("font")
	public String getFont() {
		return font;
	}

	@JsonProperty("font")
	public void setFont(String font) {
		this.font = font;
	}

	@JsonProperty("fontColor")
	public String getFontColor() {
		return fontColor;
	}

	@JsonProperty("fontColor")
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	@JsonProperty("fontSize")
	public String getFontSize() {
		return fontSize;
	}

	@JsonProperty("fontSize")
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
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

	@JsonProperty("tabId")
	public String getTabId() {
		return tabId;
	}

	@JsonProperty("tabId")
	public void setTabId(String tabId) {
		this.tabId = tabId;
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