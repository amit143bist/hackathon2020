package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "validationPattern", "validationMessage", "shared", "requireInitialOnSharedChange", "requireAll",
		"value", "width", "required", "locked", "concealValueOnDocument", "disableAutoSize", "maxLength", "tabLabel",
		"font", "fontColor", "fontSize", "documentId", "recipientId", "pageNumber", "xPosition", "yPosition", "tabId",
		"templateLocked", "templateRequired", "anchorString", "anchorXOffset", "anchorYOffset",
		"anchorHorizontalAlignment", "anchorIgnoreIfNotPresent" })
public class TextTab extends AbstractTab {

}