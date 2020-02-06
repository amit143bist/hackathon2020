package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "authenticationMethod", "clientUserId", "email", "returnUrl", "userName", "xFrameOptions",
		"xFrameOptionsAllowFromUrl" })
public class RecipientTokenRequest {

	@JsonProperty("authenticationMethod")
	private String authenticationMethod;
	@JsonProperty("clientUserId")
	private String clientUserId;
	@JsonProperty("email")
	private String email;
	@JsonProperty("returnUrl")
	private String returnUrl;
	@JsonProperty("userName")
	private String userName;
	@JsonProperty("xFrameOptions")
	private String xFrameOptions;
	@JsonProperty("xFrameOptionsAllowFromUrl")
	private String xFrameOptionsAllowFromUrl;

	@JsonProperty("authenticationMethod")
	public String getAuthenticationMethod() {
		return authenticationMethod;
	}

	@JsonProperty("authenticationMethod")
	public void setAuthenticationMethod(String authenticationMethod) {
		this.authenticationMethod = authenticationMethod;
	}

	@JsonProperty("clientUserId")
	public String getClientUserId() {
		return clientUserId;
	}

	@JsonProperty("clientUserId")
	public void setClientUserId(String clientUserId) {
		this.clientUserId = clientUserId;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("returnUrl")
	public String getReturnUrl() {
		return returnUrl;
	}

	@JsonProperty("returnUrl")
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	@JsonProperty("userName")
	public String getUserName() {
		return userName;
	}

	@JsonProperty("userName")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonProperty("xFrameOptions")
	public String getXFrameOptions() {
		return xFrameOptions;
	}

	@JsonProperty("xFrameOptions")
	public void setXFrameOptions(String xFrameOptions) {
		this.xFrameOptions = xFrameOptions;
	}

	@JsonProperty("xFrameOptionsAllowFromUrl")
	public String getXFrameOptionsAllowFromUrl() {
		return xFrameOptionsAllowFromUrl;
	}

	@JsonProperty("xFrameOptionsAllowFromUrl")
	public void setXFrameOptionsAllowFromUrl(String xFrameOptionsAllowFromUrl) {
		this.xFrameOptionsAllowFromUrl = xFrameOptionsAllowFromUrl;
	}

}