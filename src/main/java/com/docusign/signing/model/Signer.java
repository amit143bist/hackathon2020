package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "email", "name", "recipientId", "roleName", "clientUserId", "tabs" })
public class Signer {

	@JsonProperty("email")
	private String email;
	@JsonProperty("name")
	private String name;
	@JsonProperty("recipientId")
	private String recipientId;
	@JsonProperty("roleName")
	private String roleName;
	@JsonProperty("clientUserId")
	private String clientUserId;
	@JsonProperty("tabs")
	private Tabs tabs;

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("recipientId")
	public String getRecipientId() {
		return recipientId;
	}

	@JsonProperty("recipientId")
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	@JsonProperty("roleName")
	public String getRoleName() {
		return roleName;
	}

	@JsonProperty("roleName")
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@JsonProperty("clientUserId")
	public String getClientUserId() {
		return clientUserId;
	}

	@JsonProperty("clientUserId")
	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
	}

	@JsonProperty("tabs")
	public Tabs getTabs() {
		return tabs;
	}

	@JsonProperty("tabs")
	public void setTabs(Tabs tabs) {
		this.tabs = tabs;
	}

}