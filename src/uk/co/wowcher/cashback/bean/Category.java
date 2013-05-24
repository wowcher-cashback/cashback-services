package uk.co.wowcher.cashback.bean;

import java.util.List;

public class Category {
 
   
 
  
private int iCategoryId;
   private String sName;
   private String sDescription;
   private boolean blsSpecialBonusAvailable;
   private float sSpecialBonus;
   private int iMerchantCount;
   private int iSortOrder;
   
   
   
   public int getiSortOrder() {
	return iSortOrder;
}
public void setiSortOrder(int iSortOrder) {
	this.iSortOrder = iSortOrder;
}
   public int getiMerchantCount() {
	return iMerchantCount;
}
public void setiMerchantCount(int iMerchantCount) {
	this.iMerchantCount = iMerchantCount;
}
private List<SubCategory> subCategoryList;
   
   
public int getiCategoryId() {
	return iCategoryId;
}
public void setiCategoryId(int iCategoryId) {
	this.iCategoryId = iCategoryId;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public String getsDescription() {
	return sDescription;
}
public void setsDescription(String sDescription) {
	this.sDescription = sDescription;
}
public boolean isBlsSpecialBonusAvailable() {
	return blsSpecialBonusAvailable;
}
public void setBlsSpecialBonusAvailable(boolean blsSpecialBonusAvailable) {
	this.blsSpecialBonusAvailable = blsSpecialBonusAvailable;
}
public float getsSpecialBonus() {
	return sSpecialBonus;
}
public void setsSpecialBonus(float sSpecialBonus) {
	this.sSpecialBonus = sSpecialBonus;
}
public List<SubCategory> getSubCategoryList() {
	return subCategoryList;
}
public void setSubCategoryList(List<SubCategory> subCategoryList) {
	this.subCategoryList = subCategoryList;
}
@Override
public String toString() {
	return "Category [iCategoryId=" + iCategoryId + ", sName=" + sName
			+ ", sDescription=" + sDescription + ", blsSpecialBonusAvailable="
			+ blsSpecialBonusAvailable + ", sSpecialBonus=" + sSpecialBonus
			+ ", iMerchantCount=" + iMerchantCount + ", subCategoryList="
			+ subCategoryList + "]";
}
   
   
 } 