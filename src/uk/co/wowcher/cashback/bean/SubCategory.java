package uk.co.wowcher.cashback.bean;

public class SubCategory {
	private int iSubCategory;
	private String sName;
	private String sDescription;
	private Category oParentCategory;
	private Merchant_Deal_SubCategory_Assoc merchant_Deal_SubCategory_Assoc;
	public int getISubCategory() {
		return iSubCategory;
	}
	public void setISubCategory(int subCategory) {
		iSubCategory = subCategory;
	}
	public String getSName() {
		return sName;
	}
	public void setSName(String name) {
		sName = name;
	}
	public String getSDescription() {
		return sDescription;
	}
	public void setSDescription(String description) {
		sDescription = description;
	}
	public Category getOParentCategory() {
		return oParentCategory;
	}
	public void setOParentCategory(Category parentCategory) {
		oParentCategory = parentCategory;
	}
	public Merchant_Deal_SubCategory_Assoc getMerchant_Deal_SubCategory_Assoc() {
		return merchant_Deal_SubCategory_Assoc;
	}
	public void setMerchant_Deal_SubCategory_Assoc(
			Merchant_Deal_SubCategory_Assoc merchant_Deal_SubCategory_Assoc) {
		this.merchant_Deal_SubCategory_Assoc = merchant_Deal_SubCategory_Assoc;
	}
	
}
