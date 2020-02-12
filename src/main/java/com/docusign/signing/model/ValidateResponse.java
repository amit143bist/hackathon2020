package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status", "errorMessage", "redirectUrl", "LoanEst" })
public class ValidateResponse {

	@JsonProperty("status")
	private String status;
	@JsonProperty("errorMessage")
	private String errorMessage;
	@JsonProperty("redirectUrl")
	private String redirectUrl;
	@JsonProperty("LoanEst")
	private LoanEst loanEst;

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("errorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	@JsonProperty("errorMessage")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@JsonProperty("redirectUrl")
	public String getRedirectUrl() {
		return redirectUrl;
	}

	@JsonProperty("redirectUrl")
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	@JsonProperty("LoanEst")
	public LoanEst getLoanEst() {
		return loanEst;
	}

	@JsonProperty("LoanEst")
	public void setLoanEst(LoanEst loanEst) {
		this.loanEst = loanEst;
	}

}