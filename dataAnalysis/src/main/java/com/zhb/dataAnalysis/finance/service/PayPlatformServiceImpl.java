package com.zhb.dataAnalysis.finance.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.channelanalysis.ChannelAnalysisDao;
import com.zhb.dataAnalysis.common.repository.database.finance.PayPlatformDao;
import com.zhb.dataAnalysis.common.repository.database.model.PayPlatForm;
import com.zhb.dataAnalysis.common.repository.database.model.PayPlatformModel;
import com.zhb.dataAnalysis.finance.api.PayPlatformService;

@Service("payPlatformService")
public class PayPlatformServiceImpl implements PayPlatformService{
	
	@Resource(name="payPlatformDao")
	private PayPlatformDao payPlatformDao;
	
	@Resource(name="channelAnalysisDao")
	private ChannelAnalysisDao channelAnalysisDao;
	
	private final static Logger logger = LoggerFactory.getLogger(PayPlatformServiceImpl.class);
	
	private final int SMALLNUM = 2;

	/**
	 * payPlatformDao
	 */
	@Override
	public List<Map<String, String>> getChannelList() {
		return channelAnalysisDao.getChannelAll();
	}

	@Override
	public Map<String, Object> getPayPlatform(PayPlatForm pay) {
		try {
			DecimalFormat df = new DecimalFormat("0.00");
			//收入总金额
			BigDecimal income = new BigDecimal("0");BigDecimal incomeAlipay = new BigDecimal("0"); BigDecimal incomeCommon = new BigDecimal("0"); BigDecimal incomePublic = new BigDecimal("0"); BigDecimal incomeH5 = new BigDecimal("0");
			//支出总金额
			BigDecimal payCash = new BigDecimal("0");BigDecimal payCashAlipay = new BigDecimal("0"); BigDecimal payCashCommon = new BigDecimal("0"); BigDecimal payCashPublic = new BigDecimal("0"); BigDecimal payCashH5 = new BigDecimal("0");
			//实际收入总金额
			BigDecimal realIncome = new BigDecimal("0"); BigDecimal realIncomeAlipay = new BigDecimal("0"); BigDecimal realIncomeCommon = new BigDecimal("0"); BigDecimal realIncomePublic = new BigDecimal("0"); BigDecimal realIncomeH5 = new BigDecimal("0");
			//手续费收入总金额
			BigDecimal serviceIncome = new BigDecimal("0"); BigDecimal serviceAlipay = new BigDecimal("0"); BigDecimal serviceIncomeCommon = new BigDecimal("0"); BigDecimal serviceIncomePublic = new BigDecimal("0"); BigDecimal serviceIncomeH5 = new BigDecimal("0");
			//手续费支出总金额
			BigDecimal servicePay = new BigDecimal("0"); BigDecimal servicePayAlipay = new BigDecimal("0"); BigDecimal servicePayCommon = new BigDecimal("0"); BigDecimal servicePayPublic = new BigDecimal("0"); BigDecimal servicePayH5 = new BigDecimal("0");
			//实际手续费支出总金额
			BigDecimal realServicePay = new BigDecimal("0");; BigDecimal realServicePayAlipay = new BigDecimal("0"); BigDecimal realServicePayCommon = new BigDecimal("0"); BigDecimal realServicePayPublic = new BigDecimal("0"); BigDecimal realServicePayH5 = new BigDecimal("0");
			Map<String, Object> map = new HashMap<String, Object>();
			List<PayPlatformModel> list = new ArrayList<PayPlatformModel>();
			List<PayPlatformModel> payPlatform = new ArrayList<PayPlatformModel>();
			List<PayPlatformModel> payPlatform2 = new ArrayList<PayPlatformModel>();
			//充值 流量  加油卡
			List<PayPlatformModel> payPlatform4 = new ArrayList<PayPlatformModel>();//
			
			
			
			if(pay.getStartDate().compareTo("2017-12-31 23:59:59") <= 0){
					payPlatform = payPlatformDao.getPayPlatform(pay);
					payPlatform4 = payPlatformDao.getPayPlatformCharge(pay);
					for (PayPlatformModel payPlatformModel : payPlatform) {
						list.add(payPlatformModel);
					}
					for (PayPlatformModel payPlatformModel : payPlatform4) {
						list.add(payPlatformModel);
					}
			}else{
				payPlatform4 = payPlatformDao.getPayPlatformCharge(pay);//充值
				payPlatform2 = payPlatformDao.getPayPlatform(pay);
				for (PayPlatformModel payPlatformModel : payPlatform2) {
					list.add(payPlatformModel);
				}
				for (PayPlatformModel payPlatformModel : payPlatform4) {
					list.add(payPlatformModel);
				}
			}
			
			
			
			Collections.sort(list);
			
			String orderMainNo = ""; BigDecimal payCash1 = null;BigDecimal returnCash = null;//BigDecimal serviceCash = null;BigDecimal cash = null;
			List<PayPlatformModel> list1 = new ArrayList<PayPlatformModel>();
			for (PayPlatformModel payPlatformModel : list) {
				if(payPlatformModel.getOrderMain().equals(orderMainNo)) {
					for (PayPlatformModel payPlatformModel1 : list1) {
						if(payPlatformModel1.getOrderMain().equals(orderMainNo)) {
							payPlatformModel1.setPayCash(payPlatformModel.getPayCash().add(payCash1));
//							payPlatformModel1.setReturnCash(payPlatformModel.getReturnCash().add(returnCash));
//							payPlatformModel1.setServiceCash(payPlatformModel.getServiceCash().add(serviceCash));
//							payPlatformModel1.setCash(payPlatformModel.getCash().add(cash));
						}
					}
				}else{
					list1.add(payPlatformModel);
				}
				orderMainNo = payPlatformModel.getOrderMain();
				payCash1 = payPlatformModel.getPayCash();
				returnCash = payPlatformModel.getReturnCash();
//				serviceCash = payPlatformModel.getServiceCash();
//				cash = payPlatformModel.getCash();
			}
			
			
			for (PayPlatformModel payPlat : list1) {
//				String create = payPlatformDao.getPayPlatCreateTime(payPlat.getOrderMain());
//				payPlat.setCreateTime(create);
				payPlat.setReturnCash1(df.format(payPlat.getReturnCash()));
				payPlat.setPayCash1(df.format(payPlat.getPayCash()));
//				payPlat.setServiceCash1(df.format(payPlat.getServiceCash()));
//				payPlat.setCash1(df.format(payPlat.getCash()));
				if(pay.getChannel().equals("")) {
					if(payPlat.getBussinesschannel() == null || payPlat.getBussinesschannel() == "" || payPlat.getBussinesschannel().indexOf("ZHB") != 1) {
						payPlat.setChannel(payPlat.getOrderSource());
					}else{
						payPlat.setChannel(payPlat.getBussinesschannel());
					}
				}else if(pay.getChannel().equals("aiPinXuan")) {
					payPlat.setChannel(payPlat.getOrderSource());
				}else{
					payPlat.setChannel(payPlat.getBussinesschannel());
				}
				if(payPlat.getCreateTime().compareTo("2017-12-31 23:59:59") <= 0) {
					if(payPlat.getPaySourse().equals("4")) {
						payPlat.setRate(new BigDecimal("0.0055"));
						payPlat.setRate1(df.format(payPlat.getRate().multiply(new BigDecimal("100"))));
						payPlat.setServiceCash(payPlat.getPayCash().multiply(payPlat.getRate()).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setServiceCash1(df.format(payPlat.getServiceCash()));
						payPlat.setCash(payPlat.getPayCash().subtract(payPlat.getReturnCash()).subtract(payPlat.getPayCash().multiply(payPlat.getRate())).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setCash1(df.format(payPlat.getCash()));
					}else{
						payPlat.setRate(new BigDecimal("0.0060"));
						payPlat.setRate1(df.format(payPlat.getRate().multiply(new BigDecimal("100"))));
						payPlat.setServiceCash((payPlat.getPayCash().subtract(payPlat.getReturnCash())).multiply(payPlat.getRate()).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setServiceCash1(df.format(payPlat.getServiceCash()));
						payPlat.setCash(payPlat.getPayCash().subtract(payPlat.getReturnCash()).subtract((payPlat.getPayCash().subtract(payPlat.getReturnCash())).multiply(payPlat.getRate())).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setCash1(df.format(payPlat.getCash()));
					}
				}else {
					payPlat.setRate(new BigDecimal("0.0060"));
					payPlat.setRate1(df.format(payPlat.getRate().multiply(new BigDecimal("100"))));
					if(payPlat.getPaySourse().equals("4")) {
						payPlat.setServiceCash(payPlat.getPayCash().multiply(payPlat.getRate()).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setServiceCash1(df.format(payPlat.getServiceCash()));
						payPlat.setCash(payPlat.getPayCash().subtract(payPlat.getReturnCash()).subtract(payPlat.getPayCash().multiply(payPlat.getRate())).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setCash1(df.format(payPlat.getCash()));
					}else{
						payPlat.setServiceCash((payPlat.getPayCash().subtract(payPlat.getReturnCash())).multiply(payPlat.getRate()).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setServiceCash1(df.format(payPlat.getServiceCash()));
						payPlat.setCash(payPlat.getPayCash().subtract(payPlat.getReturnCash()).subtract((payPlat.getPayCash().subtract(payPlat.getReturnCash())).multiply(payPlat.getRate())).setScale(2,BigDecimal.ROUND_HALF_UP));
						payPlat.setCash1(df.format(payPlat.getCash()));
					}
				}
				
//				payPlat.setServiceCash1(df.format((payPlat.getPayCash().subtract(payPlat.getReturnCash())).multiply(payPlat.getRate())));
//				payPlat.setCash1(df.format(payPlat.getPayCash().subtract(payPlat.getReturnCash()).subtract((payPlat.getPayCash().subtract(payPlat.getReturnCash())).multiply(payPlat.getRate()))));
				
			}
			
			List<PayPlatformModel> list2 = new ArrayList<PayPlatformModel>();
			
			for (PayPlatformModel payP : list1) {
				if(pay.getPayCashStart() != null || pay.getPayCashsEnd() != null) {
					if(pay.getPayCashStart() != null&&pay.getPayCashsEnd() == null){
						if(pay.getPayCashStart().compareTo(payP.getPayCash())==-1 || pay.getPayCashStart().compareTo(payP.getPayCash())==0) {
							list2.add(payP);
						}
					}else if(pay.getPayCashsEnd() != null && pay.getPayCashStart() == null){
						if(pay.getPayCashsEnd().compareTo(payP.getPayCash())==1) {
							list2.add(payP);
						}
					}else if(pay.getPayCashStart() != null && pay.getPayCashsEnd() != null) {
						if(pay.getPayCashsEnd().compareTo(payP.getPayCash())==1 && pay.getPayCashStart().compareTo(payP.getPayCash())==-1 || pay.getPayCashStart().compareTo(payP.getPayCash())==0) {
							list2.add(payP);
						}
					}
				}else if(pay.getCashStart() != null || pay.getCashEnd() != null) {
					if(pay.getCashEnd() == null && pay.getCashStart() != null) {
						if(pay.getCashStart().compareTo(payP.getCash())==1 || pay.getCashStart().compareTo(payP.getCash())==0) {
							list2.add(payP);
						}
					}else if(pay.getCashStart() == null && pay.getCashEnd() != null) {
						if(pay.getCashEnd().compareTo(payP.getCash())==1) {
							list2.add(payP);
						}
					}else if(pay.getCashStart() != null && pay.getCashEnd() != null) {
						if(pay.getCashEnd().compareTo(payP.getCash())==1 && pay.getCashStart().compareTo(payP.getCash())==-1 || pay.getCashStart().compareTo(payP.getCash())==0) {
							list2.add(payP);
						}
					}
				}else if(pay.getReturnCashStart() != null || pay.getReturnCashEnd() != null) {
					if(pay.getReturnCashStart() != null && pay.getReturnCashEnd() == null) {
						if(pay.getReturnCashStart().compareTo(payP.getReturnCash())==-1 || pay.getReturnCashStart().compareTo(payP.getReturnCash())==0) {
							list2.add(payP);
						}
					}else if(pay.getReturnCashEnd() != null && pay.getReturnCashStart() == null) {
						if(pay.getReturnCashEnd().compareTo(payP.getReturnCash())==1) {
							list2.add(payP);
						}
					}else if(pay.getReturnCashStart() != null && pay.getReturnCashEnd() != null) {
						if(pay.getReturnCashEnd().compareTo(payP.getReturnCash())==1 && pay.getReturnCashStart().compareTo(payP.getReturnCash())==-1|| pay.getReturnCashStart().compareTo(payP.getReturnCash())==0) {
							list2.add(payP);
						}
					}
				}else if(pay.getServiceCashStart() != null || pay.getServiceCashEnd() != null){
					if(pay.getServiceCashStart() != null && pay.getServiceCashEnd() == null) {
						if(pay.getServiceCashStart().compareTo(payP.getServiceCash())==-1 || pay.getServiceCashStart().compareTo(payP.getServiceCash())==0) {
							list2.add(payP);
						}
					}else if(pay.getServiceCashEnd() != null && pay.getServiceCashStart() == null){
						if(pay.getServiceCashEnd().compareTo(payP.getServiceCash())==1) {
							list2.add(payP);
						}
					}else if(pay.getServiceCashStart() != null && pay.getServiceCashEnd() != null) {
						if(pay.getServiceCashEnd().compareTo(payP.getServiceCash())==1&&pay.getServiceCashStart().compareTo(payP.getServiceCash())==-1 || pay.getServiceCashStart().compareTo(payP.getServiceCash())==0) {
							list2.add(payP);
						}
					}
				}else{
						list2.add(payP);
				}
			}
			
			for (PayPlatformModel payPlat : list2) {
				BigDecimal ret = new BigDecimal("0");
				BigDecimal pa = new BigDecimal("0");
				if(!payPlat.getPaySourse().equals("4")) {
					ret = payPlat.getReturnCash().multiply(new BigDecimal("0.006")).setScale(SMALLNUM, BigDecimal.ROUND_HALF_UP);
					pa = (payPlat.getPayCash().subtract(payPlat.getReturnCash())).multiply(payPlat.getRate()).setScale(SMALLNUM, BigDecimal.ROUND_HALF_UP);
				}else{
					pa = payPlat.getPayCash().multiply(payPlat.getRate()).setScale(SMALLNUM, BigDecimal.ROUND_HALF_UP);
				}
				
				
				if(payPlat.getPaySourse().equals("1")) {//微信（普通）
					incomeCommon = incomeCommon.add(payPlat.getPayCash());
					payCashCommon = payCashCommon.add(payPlat.getReturnCash());
					realIncomeCommon = incomeCommon.subtract(payCashCommon);
					serviceIncomeCommon = serviceIncomeCommon.add(ret);
					realServicePayCommon = realServicePayCommon.add(pa);
					servicePayCommon = servicePayCommon.add(ret.add(pa));
				}else if(payPlat.getPaySourse().equals("3")) {//微信（公众）
					incomePublic = incomePublic.add(payPlat.getPayCash());
					payCashPublic = payCashPublic.add(payPlat.getReturnCash());
					realIncomePublic = incomePublic.subtract(payCashPublic);
					serviceIncomePublic = serviceIncomePublic.add(ret);
					realServicePayPublic = realServicePayPublic.add(pa);
					servicePayPublic = servicePayPublic.add(ret.add(pa));
				}else if(payPlat.getPaySourse().equals("4")) {//支付宝
					incomeAlipay = incomeAlipay.add(payPlat.getPayCash());
					payCashAlipay = payCashAlipay.add(payPlat.getReturnCash());
					realIncomeAlipay = incomeAlipay.subtract(payCashAlipay);
					realServicePayAlipay = realServicePayAlipay.add(pa);
					servicePayAlipay = servicePayAlipay.add(pa);
				}else if(payPlat.getPaySourse().equals("6")) {//微信（h5）
					incomeH5 = incomeH5.add(payPlat.getPayCash());
					payCashH5 = payCashH5.add(payPlat.getReturnCash());
					realIncomeH5 = incomeH5.subtract(payCashH5);
					serviceIncomeH5 = serviceIncomeH5.add(ret);
					realServicePayH5 = realServicePayH5.add(pa);
					servicePayH5 = servicePayH5.add(ret.add(pa));
				}
				income = income.add(payPlat.getPayCash());
				payCash = payCash.add(payPlat.getReturnCash());
				realIncome = income.subtract(payCash);
				serviceIncome = serviceIncome.add(ret);
				realServicePay = realServicePay.add(pa);
				servicePay = servicePay.add(ret.add(pa));
			}
			
			map.put("income", df.format(income)); map.put("incomeAlipay", df.format(incomeAlipay)); map.put("incomeCommon", df.format(incomeCommon)); map.put("incomePublic", df.format(incomePublic)); map.put("incomeH5", df.format(incomeH5));
			if(payCash.compareTo(new BigDecimal("0"))>0) {map.put("payCash", "-"+df.format(payCash));}else{map.put("payCash", df.format(payCash));}
			if(payCashAlipay.compareTo(new BigDecimal("0"))>0) {map.put("payCashAlipay", "-"+df.format(payCashAlipay));}else{map.put("payCashAlipay", df.format(payCashAlipay));}
			if(payCashCommon.compareTo(new BigDecimal("0"))>0) {map.put("payCashCommon", "-"+df.format(payCashCommon));}else{map.put("payCashCommon", df.format(payCashCommon));}
			if(payCashPublic.compareTo(new BigDecimal("0"))>0) {map.put("payCashPublic", "-"+df.format(payCashPublic));}else{map.put("payCashPublic", df.format(payCashPublic));}
			if(payCashH5.compareTo(new BigDecimal("0"))>0) {map.put("payCashH5", "-"+df.format(payCashH5));}else{map.put("payCashH5", df.format(payCashH5));}
			map.put("realIncome", df.format(realIncome)); map.put("realIncomeAlipay", df.format(realIncomeAlipay)); map.put("realIncomeCommon", df.format(realIncomeCommon)); map.put("realIncomePublic", df.format(realIncomePublic)); map.put("realIncomeH5", df.format(realIncomeH5));
			map.put("serviceIncome", df.format(serviceIncome)); map.put("serviceAlipay", df.format(serviceAlipay)); map.put("serviceIncomeCommon", df.format(serviceIncomeCommon)); map.put("serviceIncomePublic", df.format(serviceIncomePublic)); map.put("serviceIncomeH5", df.format(serviceIncomeH5));
			if(servicePay.compareTo(new BigDecimal("0"))>0) {map.put("servicePay", "-"+df.format(servicePay));}else{map.put("servicePay", df.format(servicePay));}
			if(servicePayAlipay.compareTo(new BigDecimal("0"))>0) {map.put("servicePayAlipay", "-"+df.format(servicePayAlipay));}else{map.put("servicePayAlipay", df.format(servicePayAlipay));}
			if(servicePayCommon.compareTo(new BigDecimal("0"))>0) {map.put("servicePayCommon", "-"+df.format(servicePayCommon));}else{map.put("servicePayCommon", df.format(servicePayCommon));}
			if(servicePayPublic.compareTo(new BigDecimal("0"))>0) {map.put("servicePayPublic", "-"+df.format(servicePayPublic));}else{map.put("servicePayPublic", df.format(servicePayPublic));}
			if(servicePayH5.compareTo(new BigDecimal("0"))>0) {map.put("servicePayH5", "-"+df.format(servicePayH5));}else{map.put("servicePayH5", df.format(servicePayH5));}
			
			if(realServicePay.compareTo(new BigDecimal("0"))>0) {map.put("realServicePay", "-"+df.format(realServicePay));}else{map.put("realServicePay", df.format(realServicePay));}
			if(realServicePayAlipay.compareTo(new BigDecimal("0"))>0) {map.put("realServicePayAlipay", "-"+df.format(realServicePayAlipay));}else{map.put("realServicePayAlipay", df.format(realServicePayAlipay));}
			if(realServicePayCommon.compareTo(new BigDecimal("0"))>0) {map.put("realServicePayCommon", "-"+df.format(realServicePayCommon));}else{map.put("realServicePayCommon", df.format(realServicePayCommon));}
			if(realServicePayPublic.compareTo(new BigDecimal("0"))>0) {map.put("realServicePayPublic", "-"+df.format(realServicePayPublic));}else{map.put("realServicePayPublic", df.format(realServicePayPublic));}
			if(realServicePayH5.compareTo(new BigDecimal("0"))>0) {map.put("realServicePayH5", "-"+df.format(realServicePayH5));}else{map.put("realServicePayH5", df.format(realServicePayH5));}
			
			map.put("total", list2.size());
			if(pay.getRows() > 0 && pay.getPage() > 0){
				int lastIndex = pay.getRows()*pay.getPage();
				int index = (pay.getPage()-1)*pay.getRows();
				int size = list2.size();
				if (lastIndex <= size) {
					list2 = list2.subList(index, lastIndex);
				} else {
					list2 = list2.subList(index, size);
				}
			}
			map.put("rows", list2);
			return  map;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("支付对账单参数传递有误:{%}", e.getMessage());
		}
		return null;
	}
}
