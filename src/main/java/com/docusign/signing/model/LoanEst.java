package com.docusign.signing.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "DateIssued", "ApplicateName", "ApplicateAddress1", "ApplicateAddress2", "Property", "SalePrice",
		"LoanTerm", "Purpose", "LoanType", "LoanID", "RateLock", "LoanAmount", "InterestRate", "MonthlyPayment",
		"PrincipaleAndInterest", "MortgageInsurance", "EscrowAmount", "Estimates", "ClosingCost", "CashToClose",
		"completedFieldCount", "totalRequiredFieldCount", "tabContentList" })
public class LoanEst {

	@JsonProperty("DateIssued")
	private String dateIssued = "";
	@JsonProperty("ApplicateName")
	private String applicateName = "";
	@JsonProperty("ApplicateAddress1")
	private String applicateAddress1 = "";
	@JsonProperty("ApplicateAddress2")
	private String applicateAddress2 = "";
	@JsonProperty("Property")
	private String property = "";
	@JsonProperty("SalePrice")
	private String salePrice = "";
	@JsonProperty("LoanTerm")
	private String loanTerm = "";
	@JsonProperty("Purpose")
	private String purpose = "";
	@JsonProperty("LoanType")
	private String loanType = "";
	@JsonProperty("LoanID")
	private String loanID = "";
	@JsonProperty("RateLock")
	private String rateLock = "";
	@JsonProperty("LoanAmount")
	private String loanAmount = "";
	@JsonProperty("InterestRate")
	private String interestRate = "";
	@JsonProperty("MonthlyPayment")
	private String monthlyPayment = "";
	@JsonProperty("PrincipaleAndInterest")
	private String principaleAndInterest = "";
	@JsonProperty("MortgageInsurance")
	private String mortgageInsurance = "";
	@JsonProperty("EscrowAmount")
	private String escrowAmount = "";
	@JsonProperty("Estimates")
	private String estimates = "";
	@JsonProperty("ClosingCost")
	private String closingCost = "";
	@JsonProperty("CashToClose")
	private String cashToClose = "";
	@JsonProperty("completedFieldCount")
	private int completedFieldCount = 0;
	@JsonProperty("totalRequiredFieldCount")
	private int totalRequiredFieldCount = 0;
	@JsonProperty("tabContentList")
	private List<TabContent> tabContentList;

	@JsonProperty("completedFieldCount")
	public int getCompletedFieldCount() {
		return completedFieldCount;
	}

	@JsonProperty("completedFieldCount")
	public void setCompletedFieldCount(int completedFieldCount) {
		this.completedFieldCount = completedFieldCount;
	}

	@JsonProperty("totalRequiredFieldCount")
	public int getTotalRequiredFieldCount() {
		return totalRequiredFieldCount;
	}

	@JsonProperty("totalRequiredFieldCount")
	public void setTotalRequiredFieldCount(int totalRequiredFieldCount) {
		this.totalRequiredFieldCount = totalRequiredFieldCount;
	}

	@JsonProperty("DateIssued")
	public String getDateIssued() {
		return dateIssued;
	}

	@JsonProperty("DateIssued")
	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}

	@JsonProperty("ApplicateName")
	public String getApplicateName() {
		return applicateName;
	}

	@JsonProperty("ApplicateName")
	public void setApplicateName(String applicateName) {
		this.applicateName = applicateName;
	}

	@JsonProperty("ApplicateAddress1")
	public String getApplicateAddress1() {
		return applicateAddress1;
	}

	@JsonProperty("ApplicateAddress1")
	public void setApplicateAddress1(String applicateAddress1) {
		this.applicateAddress1 = applicateAddress1;
	}

	@JsonProperty("ApplicateAddress2")
	public String getApplicateAddress2() {
		return applicateAddress2;
	}

	@JsonProperty("ApplicateAddress2")
	public void setApplicateAddress2(String applicateAddress2) {
		this.applicateAddress2 = applicateAddress2;
	}

	@JsonProperty("Property")
	public String getProperty() {
		return property;
	}

	@JsonProperty("Property")
	public void setProperty(String property) {
		this.property = property;
	}

	@JsonProperty("SalePrice")
	public String getSalePrice() {
		return salePrice;
	}

	@JsonProperty("SalePrice")
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	@JsonProperty("LoanTerm")
	public String getLoanTerm() {
		return loanTerm;
	}

	@JsonProperty("LoanTerm")
	public void setLoanTerm(String loanTerm) {
		this.loanTerm = loanTerm;
	}

	@JsonProperty("Purpose")
	public String getPurpose() {
		return purpose;
	}

	@JsonProperty("Purpose")
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@JsonProperty("LoanType")
	public String getLoanType() {
		return loanType;
	}

	@JsonProperty("LoanType")
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	@JsonProperty("LoanID")
	public String getLoanID() {
		return loanID;
	}

	@JsonProperty("LoanID")
	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}

	@JsonProperty("RateLock")
	public String getRateLock() {
		return rateLock;
	}

	@JsonProperty("RateLock")
	public void setRateLock(String rateLock) {
		this.rateLock = rateLock;
	}

	@JsonProperty("LoanAmount")
	public String getLoanAmount() {
		return loanAmount;
	}

	@JsonProperty("LoanAmount")
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	@JsonProperty("InterestRate")
	public String getInterestRate() {
		return interestRate;
	}

	@JsonProperty("InterestRate")
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	@JsonProperty("MonthlyPayment")
	public String getMonthlyPayment() {
		return monthlyPayment;
	}

	@JsonProperty("MonthlyPayment")
	public void setMonthlyPayment(String monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	@JsonProperty("PrincipaleAndInterest")
	public String getPrincipaleAndInterest() {
		return principaleAndInterest;
	}

	@JsonProperty("PrincipaleAndInterest")
	public void setPrincipaleAndInterest(String principaleAndInterest) {
		this.principaleAndInterest = principaleAndInterest;
	}

	@JsonProperty("MortgageInsurance")
	public String getMortgageInsurance() {
		return mortgageInsurance;
	}

	@JsonProperty("MortgageInsurance")
	public void setMortgageInsurance(String mortgageInsurance) {
		this.mortgageInsurance = mortgageInsurance;
	}

	@JsonProperty("EscrowAmount")
	public String getEscrowAmount() {
		return escrowAmount;
	}

	@JsonProperty("EscrowAmount")
	public void setEscrowAmount(String escrowAmount) {
		this.escrowAmount = escrowAmount;
	}

	@JsonProperty("Estimates")
	public String getEstimates() {
		return estimates;
	}

	@JsonProperty("Estimates")
	public void setEstimates(String estimates) {
		this.estimates = estimates;
	}

	@JsonProperty("ClosingCost")
	public String getClosingCost() {
		return closingCost;
	}

	@JsonProperty("ClosingCost")
	public void setClosingCost(String closingCost) {
		this.closingCost = closingCost;
	}

	@JsonProperty("CashToClose")
	public String getCashToClose() {
		return cashToClose;
	}

	@JsonProperty("CashToClose")
	public void setCashToClose(String cashToClose) {
		this.cashToClose = cashToClose;
	}

	@JsonProperty("tabContentList")
	public List<TabContent> getTabContentList() {
		return tabContentList;
	}

	@JsonProperty("tabContentList")
	public void setTabContentList(List<TabContent> tabContentList) {
		this.tabContentList = tabContentList;
	}

}