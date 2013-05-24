package uk.co.wowcher.cashback.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uk.co.wowcher.cashback.bean.Merchant;
import uk.co.wowcher.cashback.bean.MerchantDeal;
import uk.co.wowcher.cashback.service.adapter.impl.MerchantDealAdapter;

@Component("merchantDealService")
public class MerchantDealServiceImpl implements MerchantDealService {

	@Autowired
	private MerchantDealAdapter merchantDealAdapter;
	
	@Override
	public boolean addOfferToMerchant(MerchantDeal merchantDeal) {
		
		return merchantDealAdapter.addMerchantDeal(merchantDeal);
	}
	
	public List<MerchantDeal> getMerchantDeals(Merchant merchant,String merchantDealType_name)
	{
		
		return merchantDealAdapter.getMerchantDeals(merchant,merchantDealType_name);
	}
	
	public boolean deleteMerchantDeal(MerchantDeal merchantDeal)
	{
		return merchantDealAdapter.deleteMerchantDeal(merchantDeal);
	}
	
	public MerchantDeal getMerchantDeal(int merchantDealId)
	{
		return merchantDealAdapter.getMerchantDeal(merchantDealId);
	}

}
