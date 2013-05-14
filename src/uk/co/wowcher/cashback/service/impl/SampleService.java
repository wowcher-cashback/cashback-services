package uk.co.wowcher.cashback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.uk.wowcher.cashback.bean.Category;


import uk.co.wowcher.cashback.persistence.dao.SampleDao;
import uk.co.wowcher.cashback.service.adapter.impl.SampleAdapter;

@Component("service")
public class SampleService {

	@Autowired
	SampleAdapter adapter;
	
	public List<Category> addCategory(Category domainCategory)
	{
		System.out.println("in sevice class");
		List<Category> lstCategory = adapter.addCategory(domainCategory);
		return lstCategory;
	}

}
