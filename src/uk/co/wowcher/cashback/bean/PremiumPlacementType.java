package uk.co.wowcher.cashback.bean;

public class PremiumPlacementType {
	private int iPremiumPlacementTypeId;
	private String sPremiumPlacementTypeCode;
	private String sPremiumPlacementTypeName;
	private String sPremiumPlacementTypeDescription;
	private int iNoOfInventory;
	private InventoryUnitType oInventoryUnitType;
	private float fRateCardPrice;
	private float fMaxSingleDiscount;
	public int getIPremiumPlacementTypeId() {
		return iPremiumPlacementTypeId;
	}
	public void setIPremiumPlacementTypeId(int premiumPlacementTypeId) {
		iPremiumPlacementTypeId = premiumPlacementTypeId;
	}
	public String getSPremiumPlacementTypeCode() {
		return sPremiumPlacementTypeCode;
	}
	public void setSPremiumPlacementTypeCode(String premiumPlacementTypeCode) {
		sPremiumPlacementTypeCode = premiumPlacementTypeCode;
	}
	public String getSPremiumPlacementTypeName() {
		return sPremiumPlacementTypeName;
	}
	public void setSPremiumPlacementTypeName(String premiumPlacementTypeName) {
		sPremiumPlacementTypeName = premiumPlacementTypeName;
	}
	public String getSPremiumPlacementTypeDescription() {
		return sPremiumPlacementTypeDescription;
	}
	public void setSPremiumPlacementTypeDescription(
			String premiumPlacementTypeDescription) {
		sPremiumPlacementTypeDescription = premiumPlacementTypeDescription;
	}
	public int getINoOfInventory() {
		return iNoOfInventory;
	}
	public void setINoOfInventory(int noOfInventory) {
		iNoOfInventory = noOfInventory;
	}
	public InventoryUnitType getOInventoryUnitType() {
		return oInventoryUnitType;
	}
	public void setOInventoryUnitType(InventoryUnitType inventoryUnitType) {
		oInventoryUnitType = inventoryUnitType;
	}
	public float getFRateCardPrice() {
		return fRateCardPrice;
	}
	public void setFRateCardPrice(float rateCardPrice) {
		fRateCardPrice = rateCardPrice;
	}
	public float getFMaxSingleDiscount() {
		return fMaxSingleDiscount;
	}
	public void setFMaxSingleDiscount(float fMaxSingleDiscount) {
		this.fMaxSingleDiscount = fMaxSingleDiscount;
	}
}
