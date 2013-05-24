package uk.co.wowcher.cashback.service.adapter.impl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.wowcher.cashback.bean.CashBackUser;
import uk.co.wowcher.cashback.bean.Category;
import uk.co.wowcher.cashback.bean.Merchant;
import uk.co.wowcher.cashback.bean.MerchantReview;
import uk.co.wowcher.cashback.bean.MerchantReviewStatus;
import uk.co.wowcher.cashback.bean.SubCategory;
import uk.co.wowcher.cashback.persistence.dao.CategoryDAO;
import uk.co.wowcher.cashback.persistence.dao.UserReviewDAO;





@Component("adapter")
public class AdapterImpl {
	
   
	   @Autowired
	   public CategoryDAO sampleDao;
	   
	   @Autowired
	   uk.co.wowcher.cashback.domain.beans.Category domainCategory;
	   
	   @Autowired
	   uk.co.wowcher.cashback.domain.beans.SubCategory domainSubCategory;
	   
	   @Autowired
	   uk.co.wowcher.cashback.domain.beans.Merchant domainMerchant;
	   
	   uk.co.wowcher.cashback.domain.beans.Category domainCategory1=new uk.co.wowcher.cashback.domain.beans.Category();
	   
	   @Autowired
	   public UserReviewDAO userReviewDAO;
	   
	   @Autowired
	   
	   uk.co.wowcher.cashback.domain.beans.MerchantReview domainMerchantReview;
	   
	   @Autowired
	   uk.co.wowcher.cashback.domain.beans.CashBackUser domainCashBackUser;
	   
	   @Autowired
	   uk.co.wowcher.cashback.domain.beans. MerchantReviewStatus domainMerchantReviewStatus;
	
	   
	/* ----------------Add new Category--------------
	 * @Param : domain category bean
	 * @return : categoryId
	 * */
	   
	   public void  addCategory(Category category) throws Exception
	   {
	     System.out.println("In adapter class");
        domainCategory.setiCategoryId(category.getiCategoryId());
        domainCategory.setsDescription(category.getsDescription());
        domainCategory.setsName(category.getsName());
        try {
			sampleDao.addCategory(domainCategory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	  
	   }
	   
  /********** add sub category******************************/	 
	   
	   public void addSubCategory(SubCategory subCategory) throws Exception
	   {
		  
		 Category category=subCategory.getoParentCategory();
		 domainCategory1.setiCategoryId(category.getiCategoryId());
		 
		 System.out.println("subcatgory"+subCategory);
		 
	
		   domainSubCategory.setoParentCategory(domainCategory1);
		   domainSubCategory.setsName(subCategory.getsName());
		   domainSubCategory.setsDescription(subCategory.getsDescription());
		   System.out.println("domain...."+domainSubCategory);
		 try
		 {
	         sampleDao.addSubCategory(domainSubCategory)  ;
		 }
		 catch(Exception exception)
		 {
			 exception.printStackTrace();
			 throw exception;
		 }
		
		   
	   }
	   
	   
/*****************delete category*******************************************/
	   
	   public boolean deleteCategory(int categoryId) throws Exception {
		   
		   boolean status=false;
		   try
		   {
			   status=sampleDao.deleteCategory(categoryId);
		   }
		   catch(Exception exception)
		   {
			   exception.printStackTrace();
			   throw exception;
		   }
			 return status;
			  }
        
	   
	   
/*****************delete sub category*****************************************/
	   
	   public boolean deleteSubCategory(int subCategoryId) throws Exception{
			try
			{
			 sampleDao.deleteSubCategory(subCategoryId);
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
				throw exception;
			}
			 return true;
		 }
	   

	   
	   /****************************get all categories and sub categories**********************************/
	   
	   
	   public List<Category> getCategories() throws Exception
	   {
		 System.out.println("inside adapter");
		 List<Category> list=new ArrayList<Category>();
		try
		{
		 List<uk.co.wowcher.cashback.domain.beans.Category> categoryList=   sampleDao.getCategories() ;
	     Iterator< uk.co.wowcher.cashback.domain.beans.Category> iterator=categoryList.iterator();
	    	while(iterator.hasNext())
	 	     {
	 		uk.co.wowcher.cashback.domain.beans.Category category1=iterator.next();
	 		System.out.println("inside adapter..after call."+category1);
	        Category category2=new Category();
	        category2.setiCategoryId(category1.getiCategoryId());
	        category2.setsName(category1.getsName());
	        category2.setsDescription(category1.getsDescription());
	        System.out.println("list"+category1.getSubCategoryList().size());
	        List<SubCategory> subList=new ArrayList<SubCategory>();
	        Iterator<uk.co.wowcher.cashback.domain.beans.SubCategory> iterator2=category1.getSubCategoryList().iterator();
	        while(iterator2.hasNext())
	        {
	        	uk.co.wowcher.cashback.domain.beans.SubCategory subCategory=iterator2.next();
	        	SubCategory subCategory2=new SubCategory();	
	        	subCategory2.setiSubCategoryId(subCategory.getiSubCategoryId());
	        	subCategory2.setsDescription(subCategory.getsDescription());
	        	subCategory2.setsName(subCategory.getsName());
	        	subList.add(subCategory2);
	        	
	        	
	        }
	         category2.setSubCategoryList(subList);
	        list.add(category2);
	 		
	 		
	 	}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw exception;
		}
		return list;
	 } 
	  
	
	   
	   
  public Category getSubCategories(int categoryId) throws Exception
	   {
		   System.out.println("inside adapter");
		uk.co.wowcher.cashback.domain.beans.Category category=   sampleDao.getSubCategories(categoryId)  ;
		Category category2=null;
			return category2;  
	   }
	 	
	 
	
 public List<Category> getMerchantCount() throws Exception{
	 
	 System.out.println("inside adapter");
	 List<Category> list=new ArrayList<Category>();
	try
	{
	 List<uk.co.wowcher.cashback.domain.beans.Category> categoryList=   sampleDao.getMerchantCount() ;
     Iterator< uk.co.wowcher.cashback.domain.beans.Category> iterator=categoryList.iterator();
    	while(iterator.hasNext())
 	     {
 		uk.co.wowcher.cashback.domain.beans.Category category1=iterator.next();
 		System.out.println("inside adapter..after call."+category1);
        Category category2=new Category();
        category2.setiCategoryId(category1.getiCategoryId());
        category2.setsName(category1.getsName());
        category2.setsDescription(category1.getsDescription());
        category2.setiMerchantCount(category1.getiAssociatedMerchantCount());
        System.out.println("list"+category1.getSubCategoryList().size());
        List<SubCategory> subList=new ArrayList<SubCategory>();
        Iterator<uk.co.wowcher.cashback.domain.beans.SubCategory> iterator2=category1.getSubCategoryList().iterator();
        while(iterator2.hasNext())
        {
        	uk.co.wowcher.cashback.domain.beans.SubCategory subCategory=iterator2.next();
        	SubCategory subCategory2=new SubCategory();	
        	subCategory2.setiSubCategoryId(subCategory.getiSubCategoryId());
        	subCategory2.setsDescription(subCategory.getsDescription());
        	subCategory2.setsName(subCategory.getsName());
        	subCategory2.setiMerchantCount(subCategory.getiAssociatedMerchantCount());
        	subList.add(subCategory2);
        	
        	
        }
         category2.setSubCategoryList(subList);
        list.add(category2);
 		
 		
 	}

	}
	catch(Exception exception)
	{
		exception.printStackTrace();
		throw exception;
	}
	return list;
	  }
 
 public List<Merchant> getMerchant(String id1) throws Exception{
	
	List<Merchant>merchantLists=new ArrayList<Merchant>();
	try
	{
	List<uk.co.wowcher.cashback.domain.beans.Merchant> merchantList=sampleDao.getMerchant(id1);
	Iterator<uk.co.wowcher.cashback.domain.beans.Merchant> merchantItr=merchantList.iterator();
	while(merchantItr.hasNext())
	{
		uk.co.wowcher.cashback.domain.beans.Merchant merchant=merchantItr.next();
		
		Merchant merchantObj=new Merchant();
		
		merchantObj.setiMerchantId(merchant.getiMerchantId());
		
		merchantObj.setsName(merchant.getsName());

		merchantObj.setiMerchantCode(merchant.getiMerchantCode());

		merchantObj.setsUrl(merchant.getsUrl());

		merchantObj.setsDescription(merchant.getsDescription());

		merchantObj.setsLogoUrl(merchant.getsLogoUrl());

		merchantObj.setsTerms(merchant.getsTerms());

		merchantObj.setbIsActive(merchant.isbIsActive());
		
		merchantObj.setsTermsAndConditions(merchant.getsTermsAndConditions());
		
		merchantObj.setsSpecialBonus(merchant.getsSpecialBonus());

        merchantLists.add(merchantObj);
		
	}
	System.out.println("size in adapter.........."+merchantLists.size());
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
		throw exception;
	}
	return merchantLists;
		
	}
 
 
 
/*****************************GET USER REVIEW COMMENTS*****************************************/
 
 public List<MerchantReview> getallReviewComments() throws Exception
 {
	 
	 List<MerchantReview> merchantReviewList=new ArrayList<MerchantReview>();
	 try
	 {
  List<uk.co.wowcher.cashback.domain.beans.MerchantReview>	merchantReviewDomainList= userReviewDAO.getAllUserComments();
	
	 Iterator<uk.co.wowcher.cashback.domain.beans.MerchantReview> iterator=merchantReviewDomainList.iterator();
	 while(iterator.hasNext())
	 {
		 MerchantReview merchantReviewObj=new MerchantReview();
		 Merchant merchant=new Merchant();
		 CashBackUser cashBackUser=new CashBackUser();
		 MerchantReviewStatus merchantReviewStatus=new MerchantReviewStatus();
		 
		 domainMerchantReview=iterator.next();
		 merchantReviewObj.setdReviewDate(domainMerchantReview.getdReviewDate());
		 merchantReviewObj.setfRating(domainMerchantReview.getfRating());
		 merchantReviewObj.setsComment(domainMerchantReview.getsComment());
		 merchantReviewObj.setiMerchantReviewId(domainMerchantReview.getiMerchantReviewId());
		 
		 domainMerchant=domainMerchantReview.getoMerchant();
		 merchant.setsName(domainMerchant.getsName());
		 merchant.setiMerchantId(domainMerchant.getiMerchantId());
		 merchantReviewObj.setoMerchant(merchant);
		 
		 
		 domainCashBackUser=domainMerchantReview.getoCashBackUser();
		 cashBackUser.setiCashBackUserId(domainCashBackUser.getiCashBackUserId());
		 cashBackUser.setsUserName(domainCashBackUser.getsUserName());
		 merchantReviewObj.setoCashBackUser(cashBackUser);
		 
		 domainMerchantReviewStatus=domainMerchantReview.getoStatus();
		 merchantReviewStatus.setiMerchantReviewStatusId(domainMerchantReviewStatus.getiMerchantReviewStatusId());
		 merchantReviewStatus.setsMerchantReviewStatusName(domainMerchantReviewStatus.getsMerchantReviewStatusName());
		 merchantReviewObj.setoStatus(merchantReviewStatus);
		 
		 
		 merchantReviewList.add(merchantReviewObj);
		 
	 }
	 
	 }
	 catch(Exception exception)
	 {
		 exception.printStackTrace();
		 throw exception;
	 }
	 return merchantReviewList;
 }
 
 
 
 
 /***********************GET FILTER VALUES*************************************/
 
 @SuppressWarnings({ "unchecked", "rawtypes" })
public List getFilterValuesforReview(String merchantName, String userName,
			String reviewStatus) throws Exception {
	 
	 List filterValuesList=new ArrayList();
	 try
	 {
			if (merchantName != null) {
			List<uk.co.wowcher.cashback.domain.beans.Merchant>	filterValuesMerchant = userReviewDAO.getFilterValuesforReview(
						merchantName, userName, reviewStatus);
				
				Iterator<uk.co.wowcher.cashback.domain.beans.Merchant> iterator = filterValuesMerchant
						.iterator();
				while (iterator.hasNext()) {
					Merchant merchant = new Merchant();
					domainMerchant = iterator.next();
					merchant.setiMerchantId(domainMerchant.getiMerchantId());
					merchant.setsName(domainMerchant.getsName());
					filterValuesList.add(merchant);
					System.out.println("merchant in adapter....."+merchant);

				}
			}
			else if(userName!=null)
			{
			List<uk.co.wowcher.cashback.domain.beans.CashBackUser>	filterValuesUser = userReviewDAO.getFilterValuesforReview(
						merchantName, userName, reviewStatus);
				
				Iterator<uk.co.wowcher.cashback.domain.beans.CashBackUser> iterator = filterValuesUser
						.iterator();
				while (iterator.hasNext()) {
					CashBackUser cashBackUser = new CashBackUser();
					domainCashBackUser = iterator.next();
					cashBackUser.setiCashBackUserId(domainCashBackUser.getiCashBackUserId());
					cashBackUser.setsUserName(domainCashBackUser.getsUserName());
					filterValuesList.add(cashBackUser);
					System.out.println("cashbackuser in adapter---------"+cashBackUser);
			     }
			}
			
			else 
			{
				List<uk.co.wowcher.cashback.domain.beans.MerchantReviewStatus>filterValuesReviewStatus = userReviewDAO.getFilterValuesforReview(
						merchantName, userName, reviewStatus);
				
				Iterator<uk.co.wowcher.cashback.domain.beans.MerchantReviewStatus> iterator = filterValuesReviewStatus
						.iterator();
				while (iterator.hasNext()) {
					MerchantReviewStatus merchantReviewStatus = new MerchantReviewStatus();
					domainMerchantReviewStatus = iterator.next();
					merchantReviewStatus.setiMerchantReviewStatusId(domainMerchantReviewStatus.getiMerchantReviewStatusId());
					merchantReviewStatus.setsMerchantReviewStatusName(domainMerchantReviewStatus.getsMerchantReviewStatusName());
					filterValuesList.add(merchantReviewStatus);
					System.out.println("mechant review status in adapter......."+merchantReviewStatus);
			     }
			}
	 }
	 catch(Exception exception)
	 {
		 throw exception;
	 }
	 
 return filterValuesList;
 }
 
 
 public List<MerchantReview> getFilterReviews(int merchantId, int userId,
			int reviewId) throws Exception {
	 
	 List<MerchantReview> merchantReviewList=new ArrayList<MerchantReview>();
	 try
	 {
       List<uk.co.wowcher.cashback.domain.beans.MerchantReview>	merchantReviewDomainList=
    		            userReviewDAO.getFilterReviews(merchantId, userId, reviewId);
	
	 Iterator<uk.co.wowcher.cashback.domain.beans.MerchantReview> iterator=merchantReviewDomainList.iterator();
	 while(iterator.hasNext())
	 {
		 MerchantReview merchantReviewObj=new MerchantReview();
		 Merchant merchant=new Merchant();
		 CashBackUser cashBackUser=new CashBackUser();
		 MerchantReviewStatus merchantReviewStatus=new MerchantReviewStatus();
		 
		 domainMerchantReview=iterator.next();
		 merchantReviewObj.setdReviewDate(domainMerchantReview.getdReviewDate());
		 merchantReviewObj.setfRating(domainMerchantReview.getfRating());
		 merchantReviewObj.setsComment(domainMerchantReview.getsComment());
		 merchantReviewObj.setiMerchantReviewId(domainMerchantReview.getiMerchantReviewId());
		 
		 domainMerchant=domainMerchantReview.getoMerchant();
		 merchant.setsName(domainMerchant.getsName());
		 merchant.setiMerchantId(domainMerchant.getiMerchantId());
		 merchantReviewObj.setoMerchant(merchant);
		 
		 
		 domainCashBackUser=domainMerchantReview.getoCashBackUser();
		 cashBackUser.setiCashBackUserId(domainCashBackUser.getiCashBackUserId());
		 cashBackUser.setsUserName(domainCashBackUser.getsUserName());
		 merchantReviewObj.setoCashBackUser(cashBackUser);
		 
		 domainMerchantReviewStatus=domainMerchantReview.getoStatus();
		 merchantReviewStatus.setiMerchantReviewStatusId(domainMerchantReviewStatus.getiMerchantReviewStatusId());
		 merchantReviewStatus.setsMerchantReviewStatusName(domainMerchantReviewStatus.getsMerchantReviewStatusName());
		 merchantReviewObj.setoStatus(merchantReviewStatus);
		 
		 
		 merchantReviewList.add(merchantReviewObj);
		 
	 }
	 }
	 
	 catch(Exception exception)
	 {
		 
	 }
	 return merchantReviewList;
 }
 
 
 public boolean updateReviewStatus(MerchantReview merchantReviewObj) throws Exception{
		
		boolean status=false;
		try
		{
		
		 Merchant merchant=new Merchant();
		 
		 domainMerchantReview.setdReviewDate(merchantReviewObj.getdReviewDate());
		 domainMerchantReview.setfRating(merchantReviewObj.getfRating());
		 domainMerchantReview.setiMerchantReviewId(merchantReviewObj.getiMerchantReviewId());
		 domainMerchantReview.setsComment(merchantReviewObj.getsComment());
		 
		 merchant=merchantReviewObj.getoMerchant();
		 domainMerchant.setiMerchantId(merchant.getiMerchantId());
		  
	      userReviewDAO.updateReviewStatus(domainMerchantReview);
	       status=true;
		}
		catch(Exception exception)
		{
			throw exception;
		}
		
		return status;
	}
}