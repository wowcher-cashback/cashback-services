package uk.co.wowcher.cashback.service.adapter.impl;

import java.util.List;

import uk.co.wowcher.cashback.bean.Merchant;
import uk.co.wowcher.cashback.bean.MerchantDeal;

public interface MerchantDealAdapter {
	
	public boolean addMerchantDeal(MerchantDeal merchantDeal);
	public List<MerchantDeal> getMerchantDeals(Merchant merchant,String merchantDealType_name);
	public boolean deleteMerchantDeal(MerchantDeal merchantDeal);
	public MerchantDeal getMerchantDeal(int merchantDealId);

}
