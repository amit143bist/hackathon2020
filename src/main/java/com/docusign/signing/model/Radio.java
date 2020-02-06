package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "pageNumber", "xPosition", "yPosition", "value", "selected", "tabId", "required", "locked", "font",
		"bold", "italic", "underline", "fontColor", "fontSize" })
public class Radio {

	@JsonProperty("pageNumber")
	private String pageNumber;
	@JsonProperty("xPosition")
	private String xPosition;
	@JsonProperty("yPosition")
	private String yPosition;
	@JsonProperty("value")
	private String value;
	@JsonProperty("selected")
	private String selected;
	@JsonProperty("tabId")
	private String tabId;
	@JsonProperty("required")
	private String required;
	@JsonProperty("locked")
	private String locked;
	@JsonProperty("font")
	private String font;
	@JsonProperty("bold")
	private String bold;
	@JsonProperty("italic")
	private String italic;
	@JsonProperty("underline")
	private String underline;
	@JsonProperty("fontColor")
	private String fontColor;
	@JsonProperty("fontSize")
	private String fontSize;

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

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

	@JsonProperty("selected")
	public String getSelected() {
		return selected;
	}

	@JsonProperty("selected")
	public void setSelected(String selected) {
		this.selected = selected;
	}

	@JsonProperty("tabId")
	public String getTabId() {
		return tabId;
	}

	@JsonProperty("tabId")
	public void setTabId(String tabId) {
		this.tabId = tabId;
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

	@JsonProperty("font")
	public String getFont() {
		return font;
	}

	@JsonProperty("font")
	public void setFont(String font) {
		this.font = font;
	}

	@JsonProperty("bold")
	public String getBold() {
		return bold;
	}

	@JsonProperty("bold")
	public void setBold(String bold) {
		this.bold = bold;
	}

	@JsonProperty("italic")
	public String getItalic() {
		return italic;
	}

	@JsonProperty("italic")
	public void setItalic(String italic) {
		this.italic = italic;
	}

	@JsonProperty("underline")
	public String getUnderline() {
		return underline;
	}

	@JsonProperty("underline")
	public void setUnderline(String underline) {
		this.underline = underline;
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

}