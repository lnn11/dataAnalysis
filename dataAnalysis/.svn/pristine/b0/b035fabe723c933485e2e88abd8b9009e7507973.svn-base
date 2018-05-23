package com.zhb.dataAnalysis.commodity.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.commodity.api.IOperate;
import com.zhb.dataAnalysis.common.repository.database.operate.OperateDao;

@Service("operateService")
public class OperateService implements IOperate {

	@Resource(name="operateDao")
	private OperateDao operateDao;
	
	@Override
	public Map<String, BigDecimal> getProductSPU(String startDate, String endDate) {
		Map<String,BigDecimal> map = new HashMap<String, BigDecimal>();
		List<BigDecimal> productSPU = operateDao.getProductSPU(startDate, endDate);
		if(null != productSPU && productSPU.size() > 0){
			map.put("onSaleProductNum", productSPU.get(0));
			map.put("saledProductNum", productSPU.get(1));
		}
		return map;
	}

	@Override
	public Map<String, BigDecimal> getRechargeOrderNum(String startDate,String endDate) {
		Map<String,BigDecimal> map = new HashMap<String, BigDecimal>();
		List<BigDecimal> orderNum = operateDao.getRechargeOrderNum(startDate, endDate);
		if(null != orderNum && orderNum.size() > 0){
			map.put("phoneOrderNum", orderNum.get(0));
			map.put("flowOrderNum", orderNum.get(1));
			map.put("fuelCardOrderNum", orderNum.get(2));
			map.put("rechargeOrderNum", orderNum.get(0).add(orderNum.get(1)).add(orderNum.get(2)));
		}
		return map;
	}

	@Override
	public Map<String, Map<String, BigDecimal>> getRechargeOrderNumByStatus(String startDate, String endDate) {
		Map<String,Map<String,BigDecimal>> map = new HashMap<String, Map<String,BigDecimal>>();
		List<Map<String,BigDecimal>> list = operateDao.getRechargeOrderNumByStatus(startDate, endDate);
		if(null != list && list.size() > 0){	//一个map的顺序分别为话费/流量/加油卡
			map.put("phone", list.get(0));
			map.put("flow", list.get(1));
			map.put("fuelCard", list.get(2));
		}
		return map;
	}

	@Override
	public Map<String,Map<String,BigDecimal>> getRechargeSaleIndex(String startDate,String endDate) {
		Map<String,Map<String,BigDecimal>> map = new HashMap<String, Map<String,BigDecimal>>();
		List<Map<String,BigDecimal>> list = operateDao.getRechargeSaleIndex(startDate, endDate);//一个map的顺序分别为话费/流量/加油卡
		if(null != list && list.size() > 0){
			map.put("phoneSaleMoney", list.get(0));
			map.put("flowSaleMoney", list.get(1));
			map.put("fuelCardSaleMoney", list.get(2));
		}
		return map;
	}

}
