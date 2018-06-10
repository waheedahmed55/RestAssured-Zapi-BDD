package com.restassured.pojo;

import com.restassured.common.CommonAdd;
import com.restassured.common.CommonRecord;

public class UnacceptableAddPojo implements UnacceptableSpecific, CommonAdd, CommonRecord {
	
	private Integer addressTypeCd;
	private boolean entirePostalCodeInd;
	private String postalCode;
	private String provinceCode;
	private String municipality;
	private Integer streetNbr;
	private String streetNbrSuffix;
	private String streetName;
	private Integer streetTypeCd;
	private Integer streetDirectionCd;
	private Integer poBoxNbr;
	private Integer ruralIdentifierCd;
	private String routeName;
	private boolean entireUnitRangeInd;
	private String unitNbr;
	private String toUnitNbr;
	private Integer compartment;	   
	private Integer site;
    private Integer lot;
	private Integer concession;
	private String installationName;
	private String notes;
	private Integer unacceptableAddressId;
	private String createdUserId;
	private String modifiedTms;
	private String createdTms;
	private String modifiedUserId;
	public UnacceptableAddPojo() {
		
	}
	public UnacceptableAddPojo(Integer addressTypeCd, boolean entirePostalCodeInd, String postalCode, String provinceCode, String municipality,
			Integer streetNbr, String streetNbrSuffix, String streetName, Integer streetTypeCd,
			Integer streetDirectionCd, Integer poBoxNbr, Integer ruralIdentifierCd, String routeName,
			boolean entireUnitRangeInd, String unitNbr, String toUnitNbr, Integer compartment, Integer site,
			Integer lot, Integer concession, String installationName, String notes) {
		
		this.entirePostalCodeInd = entirePostalCodeInd;
		this.postalCode = postalCode;
		this.provinceCode = provinceCode;
		this.municipality = municipality;
		this.streetNbr = streetNbr;
		this.streetNbrSuffix = streetNbrSuffix;
		this.streetName = streetName;
		this.streetTypeCd = streetTypeCd;
		this.streetDirectionCd = streetDirectionCd;
		this.poBoxNbr = poBoxNbr;
		this.ruralIdentifierCd = ruralIdentifierCd;
		this.routeName = routeName;
		this.entireUnitRangeInd = entireUnitRangeInd;
		this.unitNbr = unitNbr;
		this.toUnitNbr = toUnitNbr;
		this.compartment = compartment;
		this.site = site;
		this.lot = lot;
		this.concession = concession;
		this.installationName = installationName;
		this.notes = notes;
		this.addressTypeCd = addressTypeCd;
	}
	public Integer getAddressTypeCd() {
		return addressTypeCd;
	}
	public void setAddressTypeCd(Integer addressTypeCd) {
		this.addressTypeCd = addressTypeCd;
	}
	public boolean isEntirePostalCodeInd() {
		return entirePostalCodeInd;
	}
	public void setEntirePostalCodeInd(boolean entirePostalCodeInd) {
		this.entirePostalCodeInd = entirePostalCodeInd;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public Integer getStreetNbr() {
		return streetNbr;
	}
	public void setStreetNbr(Integer streetNbr) {
		this.streetNbr = streetNbr;
	}
	public String getStreetNbrSuffix() {
		return streetNbrSuffix;
	}
	public void setStreetNbrSuffix(String streetNbrSuffix) {
		this.streetNbrSuffix = streetNbrSuffix;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public Integer getStreetTypeCd() {
		return streetTypeCd;
	}
	public void setStreetTypeCd(Integer streetTypeCd) {
		this.streetTypeCd = streetTypeCd;
	}
	public Integer getStreetDirectionCd() {
		return streetDirectionCd;
	}
	public void setStreetDirectionCd(Integer streetDirectionCd) {
		this.streetDirectionCd = streetDirectionCd;
	}
	public Integer getPoBoxNbr() {
		return poBoxNbr;
	}
	public void setPoBoxNbr(Integer poBoxNbr) {
		this.poBoxNbr = poBoxNbr;
	}
	public Integer getRuralIdentifierCd() {
		return ruralIdentifierCd;
	}
	public void setRuralIdentifierCd(Integer ruralIdentifierCd) {
		this.ruralIdentifierCd = ruralIdentifierCd;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	public boolean isEntireUnitRangeInd() {
		return entireUnitRangeInd;
	}
	public void setEntireUnitRangeInd(boolean entireUnitRangeInd) {
		this.entireUnitRangeInd = entireUnitRangeInd;
	}
	public String getUnitNbr() {
		return unitNbr;
	}
	public void setUnitNbr(String unitNbr) {
		this.unitNbr = unitNbr;
	}
	public String getToUnitNbr() {
		return toUnitNbr;
	}
	public void setToUnitNbr(String toUnitNbr) {
		this.toUnitNbr = toUnitNbr;
	}
	public Integer getCompartment() {
		return compartment;
	}
	public void setCompartment(Integer compartment) {
		this.compartment = compartment;
	}
	public Integer getSite() {
		return site;
	}
	public void setSite(Integer site) {
		this.site = site;
	}
	public Integer getLot() {
		return lot;
	}
	public void setLot(Integer lot) {
		this.lot = lot;
	}
	public Integer getConcession() {
		return concession;
	}
	public void setConcession(Integer concession) {
		this.concession = concession;
	}
	public String getInstallationName() {
		return installationName;
	}
	public void setInstallationName(String installationName) {
		this.installationName = installationName;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getUnacceptableAddressId() {
		return unacceptableAddressId;
	}
	public void setUnacceptableAddressId(Integer unacceptableAddressId) {
		this.unacceptableAddressId = unacceptableAddressId;
	}


	public String getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}

	public String getCreatedTms() {
		return createdTms;
	}

	public void setCreatedTms(String createdTms) {
		this.createdTms = createdTms;
	}

	public String getModifiedUserId() {
		return modifiedUserId;
	}

	public void setModifiedUserId(String modifiedUserId) {
		this.modifiedUserId = modifiedUserId;
	}

	public String getModifiedTms() {
		return modifiedTms;
	}

	public void setModifiedTms(String modifiedTms) {
		this.modifiedTms = modifiedTms;
	}

	
		     
		

}
