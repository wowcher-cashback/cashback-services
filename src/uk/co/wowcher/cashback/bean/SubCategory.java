package uk.co.wowcher.cashback.bean;





 public class SubCategory {
 
   
   private int iSubCategoryId;
   private String sName;
   private String sDescription;
   private int iMerchantCount;
   private  Category oParentCategory;
   

public int getiMerchantCount() {
	return iMerchantCount;
}
public void setiMerchantCount(int iMerchantCount) {
	this.iMerchantCount = iMerchantCount;
}
public int getiSubCategoryId() {
	return iSubCategoryId;
}
public void setiSubCategoryId(int iSubCategoryId) {
	this.iSubCategoryId = iSubCategoryId;
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

public Category getoParentCategory() {
	return oParentCategory;
}
public void setoParentCategory(Category oParentCategory) {
	this.oParentCategory = oParentCategory;
}
@Override
public String toString() {
	return "SubCategory [iSubCategoryId=" + iSubCategoryId + ", sName=" + sName
			+ ", sDescription=" + sDescription + ", iMerchantCount="
			+ iMerchantCount + "]";
}
     

  
 } 