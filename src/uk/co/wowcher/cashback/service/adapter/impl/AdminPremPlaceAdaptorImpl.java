package uk.co.wowcher.cashback.service.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.wowcher.cashback.bean.PremiumPlacementType;
import uk.co.wowcher.cashback.persistence.dao.AdminPremPlaceDAO;

@Component("adminPremPlaceAdaptor")
public class AdminPremPlaceAdaptorImpl implements AdminPremPlaceAdaptor{

	@Autowired
	private AdminPremPlaceDAO adminPremPlaceDAO;
	
	@Override
	public List<PremiumPlacementType> getPremPlaceList() {
		// TODO Auto-generated method stub
		
		List<PremiumPlacementType> lstUiPlacementTypes = new ArrayList<PremiumPlacementType>();
		
		PremiumPlacementType uiPlacementType = null;
		
		List<uk.co.wowcher.cashback.domain.beans.PremiumPlacementType> lstDomainPlacementTypes = adminPremPlaceDAO.getPremPlaceList();
		
		for(uk.co.wowcher.cashback.domain.beans.PremiumPlacementType placementType:lstDomainPlacementTypes)
		{
			uiPlacementType = new PremiumPlacementType();
			uiPlacementType.setFRateCardPrice(placementType.getfRateCardPrice());
			uiPlacementType.setINoOfInventory(placementType.getiNoOfInventory());
			uiPlacementType.setIPremiumPlacementTypeId(placementType.getiPremiumPlacementTypeId());
			uiPlacementType.setFMaxSingleDiscount(placementType.getfMaxSingleDiscount());
			uiPlacementType.setSPremiumPlacementTypeCode(placementType.getsPremiumPlacementTypeCode());
			uiPlacementType.setSPremiumPlacementTypeDescription(placementType.getsPremiumPlacementTypeDescription());
			uiPlacementType.setSPremiumPlacementTypeName(placementType.getsPremiumPlacementTypeName());
			lstUiPlacementTypes.add(uiPlacementType);
		}
		
		return lstUiPlacementTypes;
	}

}
