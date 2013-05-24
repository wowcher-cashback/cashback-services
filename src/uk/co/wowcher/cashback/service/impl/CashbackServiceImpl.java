package uk.co.wowcher.cashback.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;









import uk.co.wowcher.cashback.bean.Category;
import uk.co.wowcher.cashback.bean.Merchant;
import uk.co.wowcher.cashback.bean.MerchantReview;
import uk.co.wowcher.cashback.bean.SubCategory;
import uk.co.wowcher.cashback.service.adapter.impl.AdapterImpl;

@Component("service")
 public class CashbackServiceImpl {
 
   @Autowired
   AdapterImpl adapter;
   

public void addCategory(Category domain) throws Exception
   {
     System.out.println("in sevice class");
     System.out.println(adapter);
      adapter.addCategory(domain);
     
   }


public void addSubCategory(SubCategory subCategory) throws Exception
{
	System.out.println("inside adapter");
	adapter.addSubCategory(subCategory)  ;
	
	   
}

public Category getSubCategories(int categoryId) throws Exception 
{
	   System.out.println("inside adapter");
	   Category category=   adapter.getSubCategories(categoryId)  ;
	   return category;  
}
  
public List<Category> getCategories() throws Exception 
{
	   System.out.println("inside adapter");
	   
	List<Category> categoryList=   adapter.getCategories() ;
	System.out.println("list size...in service"+categoryList.size());
	Iterator< Category> catgoryItr=categoryList.iterator();
	while(catgoryItr.hasNext())
	{
		Category cat=catgoryItr.next();
		System.out.println("cat in service"+cat);
	}
	
			return categoryList;  
}


public boolean deleteCategory(int categoryId) throws Exception {
	
	boolean status=adapter.deleteCategory(categoryId);
	
	return status;
}


public List<Category> getMerchantCount() throws Exception {
	 
	 List<Category> list=adapter.getMerchantCount();
	 Iterator< Category> catgoryItr=list.iterator();
		while(catgoryItr.hasNext())
		{
			Category cat=catgoryItr.next();
			System.out.println("cat in service"+cat);
		}
	 
	 return list;
	
	  }

public boolean deleteSubCategory(int subCategoryId) throws Exception {
	 
	 adapter.deleteSubCategory(subCategoryId);
	 return true;
}

public List<Merchant> getMerchant(String id) throws Exception {
	List<Merchant> merchantList=adapter.getMerchant(id);
	 Iterator< Merchant> merchantItr=merchantList.iterator();
		while(merchantItr.hasNext())
		{
			Merchant merchant=merchantItr.next();
			System.out.println("merchant in service"+merchant);
		}
	return merchantList;
	
}


public List<MerchantReview> getallReviewComments() throws Exception
{
	List<MerchantReview> merchantReviewsList= adapter.getallReviewComments();
	
	Iterator< MerchantReview> iterator=merchantReviewsList.iterator();
	while(iterator.hasNext())
	{
		MerchantReview merchantReview=iterator.next();
		System.out.println("merchant review in service"+merchantReview);
	}
	
	return merchantReviewsList;
}

public void getFilterValuesforReview(String merchantName, String userName,
		String reviewStatus) throws Exception {

	adapter.getFilterValuesforReview(merchantName, userName, reviewStatus) ;
 

}

public  List<MerchantReview> getFilterReviews(int merchantId, int userId,
		int reviewId) throws Exception {
 

	List<MerchantReview> merchantReviewsList= adapter.getFilterReviews(merchantId, userId, reviewId);
	Iterator< MerchantReview> iterator=merchantReviewsList.iterator();
	while(iterator.hasNext())
	{
		MerchantReview merchantReview=iterator.next();
		System.out.println("merchant review in service"+merchantReview);
	}
  
	return merchantReviewsList;
 }

}
