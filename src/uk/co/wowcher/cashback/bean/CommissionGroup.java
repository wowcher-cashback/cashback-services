package uk.co.wowcher.cashback.bean;

import java.util.Date;

public class CommissionGroup {

	private int iCommissionGroupId;
	private String sCommissionGroupCode;
	private float fCommissionGroupRate;
	private RateType oCommissionGroupRateType;
	private Date dValidFrom;
	private Date dValidTo;
	public int getICommissionGroupId() {
		return iCommissionGroupId;
	}
	public void setICommissionGroupId(int iCommissionGroupId) {
		this.iCommissionGroupId = iCommissionGroupId;
	}
	public String getSCommissionGroupCode() {
		return sCommissionGroupCode;
	}
	public void setSCommissionGroupCode(String sCommissionGroupCode) {
		this.sCommissionGroupCode = sCommissionGroupCode;
	}
	public float getFCommissionGroupRate() {
		return fCommissionGroupRate;
	}
	public void setFCommissionGroupRate(float fCommissionGroupRate) {
		this.fCommissionGroupRate = fCommissionGroupRate;
	}
	public RateType getOCommissionGroupRateType() {
		return oCommissionGroupRateType;
	}
	public void setOCommissionGroupRateType(RateType oCommissionGroupRateType) {
		this.oCommissionGroupRateType = oCommissionGroupRateType;
	}
	public Date getDValidFrom() {
		return dValidFrom;
	}
	public void setDValidFrom(Date dValidFrom) {
		this.dValidFrom = dValidFrom;
	}
	public Date getDValidTo() {
		return dValidTo;
	}
	public void setDValidTo(Date dValidTo) {
		this.dValidTo = dValidTo;
	}

}
