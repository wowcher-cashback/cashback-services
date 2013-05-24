package uk.co.wowcher.cashback.service.adapter.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.wowcher.cashback.bean.CommissionGroup;
import uk.co.wowcher.cashback.bean.Merchant;
import uk.co.wowcher.cashback.bean.MerchantDeal;
import uk.co.wowcher.cashback.domain.beans.MerchantDealType;
import uk.co.wowcher.cashback.persistence.dao.MerchantDealDao;

@Component("merchantDealAdapter")
public class MerchantDealAdapterImpl implements MerchantDealAdapter {

	@Autowired
	private MerchantDealDao merchantDealDao;
	
	@Autowired
	private uk.co.wowcher.cashback.domain.beans.MerchantDeal domainMerchantDeal;
	
	@Autowired
	private uk.co.wowcher.cashback.domain.beans.Merchant domainMerchant;
	
	@Autowired
	private uk.co.wowcher.cashback.domain.beans.CommissionGroup domainCommissionGroup;
	
	@Override
	public boolean addMerchantDeal(MerchantDeal merchantDeal) {
		
		
		domainCommissionGroup.setsCommissionGroupCode(merchantDeal.getOCommissionGroup().getSCommissionGroupCode());
		MerchantDealType merchantDealType = new MerchantDealType();
		domainMerchant.setiMerchantId(merchantDeal.getMerchant().getIMerchantId());
		merchantDealType.setiMerchantDealTypeId(merchantDeal.getOMerchantDealType().getIMerchantDealTypeId());
		domainMerchantDeal.setMerchant(domainMerchant);
		domainMerchantDeal.setoMerchantDealType(merchantDealType);
		domainMerchantDeal.setsMerchantDealUrl(merchantDeal.getSMerchantDealUrl());
		domainMerchantDeal.setsDescription(merchantDeal.getSDescription());
		domainMerchantDeal.setdValidFrom(merchantDeal.getDValidFrom());
		domainMerchantDeal.setdValidTo(merchantDeal.getDValidTo());
		domainMerchantDeal.setbToShow(merchantDeal.isBToShow());
		domainMerchantDeal.setsOfferTitle(merchantDeal.getSOfferTitle());
		domainMerchantDeal.setbIsPrintable(merchantDeal.isBIsPrintable());
		domainMerchantDeal.setsTerms(merchantDeal.getSTerms());
		domainMerchantDeal.setbIsWithCashBack(merchantDeal.isBIsWithCashBack());
		domainMerchantDeal.setbDeleteFlag(false);
		domainMerchantDeal.setsVoucherCode(merchantDeal.getSVoucherCode());
		domainMerchantDeal.setbIsExclusive(merchantDeal.isBIsExclusive());
		domainMerchantDeal.setoCommissionGroup(domainCommissionGroup);
		return merchantDealDao.addMerchantDeal(domainMerchantDeal);
	}
	
	public List<MerchantDeal> getMerchantDeals(Merchant merchant,String merchantDealType_name)
	{
		domainMerchant.setiMerchantId(merchant.getIMerchantId());
		List<uk.co.wowcher.cashback.domain.beans.MerchantDeal> lstMerchantDeals = merchantDealDao.getMerchantDeals(domainMerchant, merchantDealType_name);
		List<MerchantDeal> lstUiMerchantDeals = new ArrayList<MerchantDeal>();
		MerchantDeal uiMerchantDeal = null;
		CommissionGroup group = null;
		for(uk.co.wowcher.cashback.domain.beans.MerchantDeal merchantDeal:lstMerchantDeals)
		{
			group = new CommissionGroup();
			uiMerchantDeal = new MerchantDeal();
			uiMerchantDeal.setSOfferTitle(merchantDeal.getsOfferTitle());
			uiMerchantDeal.setDValidTo(merchantDeal.getdValidTo());
			uiMerchantDeal.setDValidFrom(merchantDeal.getdValidFrom());
			uiMerchantDeal.setBIsExclusive(merchantDeal.isbIsExclusive());
			uiMerchantDeal.setSVoucherCode(merchantDeal.getsDescription());
			uiMerchantDeal.setBIsPrintable(merchantDeal.isbIsPrintable());
			uiMerchantDeal.setBIsWithCashBack(merchantDeal.isbIsWithCashBack());
			uiMerchantDeal.setIMerchantDealId(merchantDeal.getiMerchantDealId());
			uiMerchantDeal.setSMerchantDealUrl(merchantDeal.getsMerchantDealUrl());
			uiMerchantDeal.setSDescription(merchantDeal.getsDescription());
			uiMerchantDeal.setSTerms(merchantDeal.getsTerms());
			group.setICommissionGroupId(merchantDeal.getoCommissionGroup().getiCommissionGroupId());
			group.setSCommissionGroupCode(merchantDeal.getoCommissionGroup().getsCommissionGroupCode());
			uiMerchantDeal.setOCommissionGroup(group);
			lstUiMerchantDeals.add(uiMerchantDeal);
		}
		return lstUiMerchantDeals;
	}
	
	public boolean deleteMerchantDeal(MerchantDeal merchantDeal)
	{
		domainMerchantDeal.setiMerchantDealId(merchantDeal.getIMerchantDealId());
		domainMerchantDeal.setbDeleteFlag(true);
		return merchantDealDao.deleteMerchantDeal(domainMerchantDeal);
	}
	
	public MerchantDeal getMerchantDeal(int merchantDealId)
	{
		
		uk.co.wowcher.cashback.domain.beans.MerchantDeal deal = merchantDealDao.getMerchantDeal(merchantDealId);
		
		MerchantDeal merchantDeal = new MerchantDeal();
		
		Merchant merchant = new Merchant();
		System.out.println("In getMerchantDeal");
		merchantDeal.setBIsExclusive(deal.isbIsExclusive());
		merchantDeal.setBIsPrintable(deal.isbIsPrintable());
		merchantDeal.setBIsWithCashBack(deal.isbIsWithCashBack());
		merchantDeal.setBToShow(deal.isbToShow());
		merchantDeal.setDValidFrom(deal.getdValidFrom());
		merchantDeal.setDValidTo(deal.getdValidTo());
		merchantDeal.setFCashBackRate(deal.getfCashBackRate());
		merchantDeal.setIMerchantDealId(deal.getiMerchantDealId());
		merchantDeal.setIProductId(deal.getiProductId());
		
		merchant.setIMerchantId(deal.getMerchant().getiMerchantId());
		merchantDeal.setMerchant(merchant);
		
		merchantDeal.setSDescription(deal.getsDescription());
		merchantDeal.setSMerchantDealUrl(deal.getsMerchantDealUrl());
		merchantDeal.setSOfferTitle(deal.getsOfferTitle());
		merchantDeal.setSTerms(deal.getsTerms());
		merchantDeal.setSVoucherCode(deal.getsVoucherCode());
		
		
		
		return merchantDeal;
		
	}
	

}
