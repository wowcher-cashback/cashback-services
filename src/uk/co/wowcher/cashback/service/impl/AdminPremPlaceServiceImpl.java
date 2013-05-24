package uk.co.wowcher.cashback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.wowcher.cashback.bean.PremiumPlacementType;
import uk.co.wowcher.cashback.service.adapter.impl.AdminPremPlaceAdaptor;

@Component("adminPremPlaceService")
public class AdminPremPlaceServiceImpl implements AdminPremPlaceService{

	@Autowired
	private AdminPremPlaceAdaptor adminPremPlaceAdaptor;
	
	@Override
	public List<PremiumPlacementType> getPremPlaceList() {
		// TODO Auto-generated method stub
		
		return adminPremPlaceAdaptor.getPremPlaceList();
	}

}
