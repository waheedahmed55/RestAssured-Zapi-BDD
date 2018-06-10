package com.restassured.pojo;

public class UnacceptableAddBuilder {
	
	private Integer addressTypeCd;
	private boolean entirePostalCodeInd= false;
	private String postalCode= null ;
	private String provinceCode= null;
	private String municipality=null;
	private Integer streetNbr=null;
	private String streetNbrSuffix= null;
	private String streetName=null;
	private Integer streetTypeCd= null;
	private Integer streetDirectionCd= null;
	private Integer poBoxNbr=null;
	private Integer ruralIdentifierCd=null;
	private String routeName=null;
	private boolean entireUnitRangeInd=false;
	private String unitNbr=null;
	private String toUnitNbr=null;
	private Integer site=null;
	private Integer compartment=null;
	private Integer lot=null;
	private Integer concession=null;
	private String installationName=null;
	private String notes= null;
	private Integer unacceptableAddressId;

	public UnacceptableAddBuilder UnAcceptableAddressId(Integer unacceptableAddressId) {
		this.unacceptableAddressId = unacceptableAddressId;
		return this;
	}
	
	public UnacceptableAddBuilder StreetNbrSuffix(String streetNbrSuffix) {
		this.streetNbrSuffix = streetNbrSuffix;
		return this;
	}
	public UnacceptableAddBuilder StreetTypeCd(Integer streetTypeCd) {
		this.streetTypeCd = streetTypeCd;
		return this;
	}
	public UnacceptableAddBuilder StreetDirectionCd(Integer streetDirectionCd) {
		this.streetDirectionCd = streetDirectionCd;
		return this;
	}
	public UnacceptableAddBuilder PoBoxNbr(Integer poBoxNbr) {
		this.poBoxNbr = poBoxNbr;
		return this;
	}
	public UnacceptableAddBuilder EntireUnitRangeInd(boolean entireUnitRangeInd) {
		this.entireUnitRangeInd = entireUnitRangeInd;
		return this;
	}
	public UnacceptableAddBuilder UnitNbr(String unitNbr) {
		this.unitNbr = unitNbr;
		return this;
	}
	public UnacceptableAddBuilder ToUnitNbr(String toUnitNbr) {
		this.toUnitNbr = toUnitNbr;
		return this;
	}
	public UnacceptableAddBuilder Site(Integer site) {
		this.site = site;
		return this;
	}
	public UnacceptableAddBuilder Compartment(Integer compartment) {
		this.compartment = compartment;
		return this;
	}
	public UnacceptableAddBuilder Lot(Integer lot) {
		this.lot = lot;
		return this;
	}
	public UnacceptableAddBuilder Concession(Integer concession) {
		this.concession = concession;
		return this;
	}
	public UnacceptableAddBuilder InstallationName(String installationName) {
		this.installationName = installationName;
		return this;
	}
	
	
	public UnacceptableAddBuilder addresstypecode(Integer addressTypeCd) {
		this.addressTypeCd=addressTypeCd;
		return this;
	}
	public UnacceptableAddBuilder entirepostalcodeInd(boolean entirePostalCodeInd) {
		this.entirePostalCodeInd=entirePostalCodeInd;
		return this;
	}
	public UnacceptableAddBuilder postalcode(String postalCode) {
		this.postalCode=postalCode;
		return this;
	}
	public UnacceptableAddBuilder provincecode(String provinceCode) {
		this.provinceCode=provinceCode;
		return this;
	}
	public UnacceptableAddBuilder municipalityname(String municipality) {
		this.municipality=municipality;
		return this;
	}
	public UnacceptableAddBuilder streetnbr(Integer streetNbr) {
		this.streetNbr=streetNbr;
		return this;
	}
	public UnacceptableAddBuilder streetname(String streetName) {
		this.streetName=streetName;
		return this;
	}
	public UnacceptableAddBuilder note(String notes) {
		this.notes=notes;
		return this;
	}
	public UnacceptableAddBuilder routename(String routeName) {
		this.routeName=routeName;
		return this;
	}
	public UnacceptableAddBuilder ruralidentifiercd(int ruralIdentifierCdi) {
		this.ruralIdentifierCd=ruralIdentifierCdi;
		return this;
	}
	public UnacceptableAddPojo build() {
		
		UnacceptableAddPojo pojo = new UnacceptableAddPojo();
		pojo.setAddressTypeCd(addressTypeCd);
		pojo.setEntirePostalCodeInd(entirePostalCodeInd);
		pojo.setPostalCode(postalCode);
		pojo.setProvinceCode(provinceCode);
		pojo.setMunicipality(municipality);
		pojo.setStreetNbr(streetNbr);
		pojo.setStreetName(streetName);
		pojo.setNotes(notes);
		pojo.setRouteName(routeName);
		pojo.setRuralIdentifierCd(ruralIdentifierCd);
		pojo.setStreetNbrSuffix(streetNbrSuffix);
		pojo.setStreetTypeCd(streetTypeCd);
		pojo.setStreetDirectionCd(streetDirectionCd);
		pojo.setPoBoxNbr(poBoxNbr);
		pojo.setEntireUnitRangeInd(entireUnitRangeInd);
		pojo.setUnitNbr(unitNbr);
		pojo.setToUnitNbr(toUnitNbr);
		pojo.setSite(site);
		pojo.setLot(lot);
		pojo.setCompartment(compartment);
		pojo.setConcession(concession);
		pojo.setInstallationName(installationName);
		pojo.setUnacceptableAddressId(unacceptableAddressId);
		return pojo;
		
	}
	
	
    
}
