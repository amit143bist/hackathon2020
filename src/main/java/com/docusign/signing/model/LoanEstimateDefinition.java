package com.docusign.signing.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "LoanEst" })
public class LoanEstimateDefinition {

	@JsonProperty("LoanEst")
	private LoanEst loanEst;

	@JsonProperty("LoanEst")
	public LoanEst getLoanEst() {
		return loanEst;
	}

	@JsonProperty("LoanEst")
	public void setLoanEst(LoanEst loanEst) {
		this.loanEst = loanEst;
	}

}