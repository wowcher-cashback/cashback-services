package uk.co.wowcher.cashback.service.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import uk.co.wowcher.cashback.bean.Category;
import uk.co.wowcher.cashback.persistence.dao.SampleDao;
import uk.co.wowcher.cashback.service.impl.SampleService;

@Component("adapterservice")
public class SampleAdapter {

	
	SampleService service;
	
	@Autowired
	public SampleDao sampleDao;
	
	@Autowired
	uk.co.wowcher.cashback.domain.beans.Category domainCategory;
	
	public List<Category> addCategory(Category category)
	{
		System.out.println("In adapter class");
		
		domainCategory.setiCategoryId(category.getiCategoryId());
		domainCategory.setsName(category.getsName());
		domainCategory.setsDescription(category.getsDescription());
		
		
		
		List<uk.co.wowcher.cashback.domain.beans.Category> lstCategory = sampleDao.addCategory(domainCategory);
		
		List<Category> lstCategories = new ArrayList<Category>();
		Category category2 = null;
		for(uk.co.wowcher.cashback.domain.beans.Category categoryDomain:lstCategory)
		{
			category2 = new Category();
			category2.setiCategoryId(categoryDomain.getiCategoryId());
			category2.setsDescription(categoryDomain.getsDescription());
			category2.setsName(categoryDomain.getsName());
			lstCategories.add(category2);
		}
		
		return lstCategories;
	}
	
	

}
