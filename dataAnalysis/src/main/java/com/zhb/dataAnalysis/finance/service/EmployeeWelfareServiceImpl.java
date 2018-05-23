package com.zhb.dataAnalysis.finance.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.common.repository.database.customerService.EmployeeWelfareDao;
import com.zhb.dataAnalysis.common.repository.database.model.EmployeeWelfare;
import com.zhb.dataAnalysis.finance.api.EmployeeWelfareService;

/**
 * @author chunjie.huo
 * @time 2017年3月29日 下午3:45:07
 * 作用:员工福利对账单
 */
@Service("employeeWelfareService")
public class EmployeeWelfareServiceImpl implements EmployeeWelfareService {

	
	private final int SMALLNUM = 4;
	
	
	@Resource(name = "employeeWelfareDao")
	private EmployeeWelfareDao employeeWelfareDao;
	
	
	@Override
	public List<Map<String, String>> getEmployeeGift() {
		return employeeWelfareDao.getEmployeeGift();
	}
	
	@Override
	public Map<String, Object> getWelfareLisit(String startDate,String endDate,int currentPage,int pageSize,String employeeNmae,String welfareIndex){
		Map<String,Object> ma = new HashMap<String, Object>();
		if(welfareIndex.equals("所有专属福利")) {
			welfareIndex = "";
		}
		Map<String, Object> sumList = employeeWelfareDao.getEmploySumList(startDate,endDate,employeeNmae,welfareIndex);
//		Map<String, Object> sumSpecial = employeeWelfareDao.getSumSpecial(startDate,endDate);
		List<EmployeeWelfare> list = employeeWelfareDao.getEmployeeWelfare(startDate,endDate,employeeNmae,welfareIndex,currentPage,pageSize);
//		List<EmployeeWelfare> list = employeeWelfareDao.getEmployeeWelfareExport(startDate,endDate,employeeNmae,welfareIndex);
//		List<EmployeeWelfare> fareList = new ArrayList<EmployeeWelfare>();
		BigDecimal sumNum = ((BigDecimal) sumList.get("SUMPRODUCTNUM")).setScale(SMALLNUM, BigDecimal.ROUND_HALF_UP);
		BigDecimal sumPoints = BigDecimal.valueOf(0);
//		if(welfareIndex == "" && employeeNmae == "") {
//			sumPoints = ((BigDecimal) sumSpecial.get("SUMPOINTS")).setScale(SMALLNUM, BigDecimal.ROUND_HALF_UP);
//		}else{
			sumPoints = ((BigDecimal) sumList.get("SUMPOINTS")).setScale(SMALLNUM, BigDecimal.ROUND_HALF_UP);
//		}
		
		BigDecimal sumMoney = ((BigDecimal) sumList.get("SUMMONEY")).setScale(SMALLNUM, BigDecimal.ROUND_HALF_UP);
		BigDecimal count = (BigDecimal) sumList.get("COUNT");


		if(list != null && list.size() > 0) {
			ma.put("total", count);
			ma.put("rows", list);
			ma.put("sumProductNum", sumNum);
			ma.put("sumPoints", sumPoints);
			ma.put("sumMoney", sumMoney);
		}else{
			ma.put("total", 1);
			ma.put("rows", list);
			ma.put("sumProductNum", sumNum);
			ma.put("sumPoints", sumPoints);
			ma.put("sumMoney", sumMoney);
		}
		return ma;
	}
	
	@Override
	public List<Map<String, String>> getEmployeeGift1(String startDate,String endDate,int currentPage,int pageSize,String employeeNmae,String welfareIndex) {
		if(welfareIndex.equals("所有专属福利")) {
			welfareIndex = "";
		}
		return employeeWelfareDao.getEmployeeGift1(startDate,endDate,employeeNmae,welfareIndex,currentPage,pageSize);
	}
	
	@Override
	public void queryEmployee(String startDate, String endDate) {
		employeeWelfareDao.queryEmployee(startDate, endDate);
	}
	
	@Override
	public void deleteEmployee(String startDate, String endDate) {
		employeeWelfareDao.deleteEmployee(startDate, endDate);
	}
	
	/**
	 * 中秋、春节、元宵员工福利查询业务处理
	 */
	private final BigDecimal MIDDLE_AUTUMN_FESTIVAL_GIFT_2016 = BigDecimal.valueOf(40000); // 中秋福利积分
	
	private final BigDecimal SPRING_FESTIVAL_GIFT_2017 = BigDecimal.valueOf(100000); // 春节福利积分
	
	private final BigDecimal MIDDLE_SPRINGYEAR_GIFT = SPRING_FESTIVAL_GIFT_2017.add(MIDDLE_AUTUMN_FESTIVAL_GIFT_2016); // 春节加中秋福利总积分
	
	private final BigDecimal LANTERN_FESTIVAL_GIFT_2017 = BigDecimal.valueOf(10000); // 元宵福利积分
	
	private final BigDecimal SPRING_LARTEN_GIFT = SPRING_FESTIVAL_GIFT_2017.add(LANTERN_FESTIVAL_GIFT_2017); // 春节加元宵福利总积分
	
	private final BigDecimal MIDDLE_SPRINGYEAR_LANTERN_GIFT = MIDDLE_AUTUMN_FESTIVAL_GIFT_2016.add(SPRING_FESTIVAL_GIFT_2017).add(LANTERN_FESTIVAL_GIFT_2017); //中秋加春节加元宵福利
	
	private final String MIDDLE_NAME = "中秋专属福利";
	private final String NEWYEAR_NAME = "春节专属福利";
	private final String LARTEN_NAME = "元宵专属福利";
	
	/**
	 * 中秋、春节、元宵员工福利查询业务处理
	 */
	@Override
	public Map<String, Object> getCompanyProducts(String startDate,String endDate,int currentPage,int pageSize,String employeeNmae,String welfareIndex) {
		int i = 0;
		Map<String,EmployeeWelfare> welfareMap = new HashMap<String, EmployeeWelfare>();
		List<Map<String, Object>> orders = employeeWelfareDao.getEmployeeTotalPoints(startDate,endDate);
		BigDecimal productNum = BigDecimal.valueOf(0);
		BigDecimal specialPoints = BigDecimal.ZERO;
		String currentUser = "";
		if(orders != null && orders.size() > 0) {
			for (Map<String, Object> map : orders) {
				String employeeNo = "";
				String employeeName = "";
				String company = "";
				BigDecimal beforePoints  = BigDecimal.ZERO;
				String userId = (String) map.get("USERID") ;
				String orderNo = (String) map.get("ORDERNO");
				BigDecimal totalPoints = new BigDecimal(String.valueOf(map.get("TOTALPOINTS")));
				String createTime =  map.get("CREATETIME").toString();
				if(StringUtils.isNotBlank(createTime)){
					int index = createTime.lastIndexOf(".");
					if(index != -1)
						createTime = createTime.substring(0,index);
				}
				if(totalPoints.compareTo(this.MIDDLE_AUTUMN_FESTIVAL_GIFT_2016) == 0) {// 只领中秋礼包积分
					i = 1;
				}else if(totalPoints.compareTo(this.SPRING_FESTIVAL_GIFT_2017) == 0){ // 只领春节礼包积分
					i = 2;
				}else if(totalPoints.compareTo(this.LANTERN_FESTIVAL_GIFT_2017) == 0){ // 只领元宵节礼包积分
					i = 3;
				}else if(totalPoints.compareTo(this.MIDDLE_SPRINGYEAR_GIFT) == 0){ // 只领中秋节礼包积分和春节礼包积分
					i = 4;
				}else if(totalPoints.compareTo(this.MIDDLE_SPRINGYEAR_LANTERN_GIFT) == 0){ // 只领中秋、春节、元宵福利
					i = 5;
				}else if(totalPoints.compareTo(SPRING_LARTEN_GIFT) == 0){ // 只领春节、元宵福利
					i = 6;
				}
				Map<String, Object> employeeInfo = employeeWelfareDao.getEmployeeInfo(userId, i, employeeNmae);
				if(employeeInfo != null && employeeInfo.size() > 0) {
					employeeNo = ((String) employeeInfo.get("EMPLOYEENO")).trim();
					employeeName = ((String) employeeInfo.get("EMPLOYEENAME")).trim();
					company = ((String) employeeInfo.get("COMPANY")).trim();
					
					if(StringUtils.isNotBlank(startDate)){
						// 第二步: 如果有开始时间,则根据开始时间查询该员工的历史订单消费的福利积分
						List<BigDecimal> historyUsedPoint = employeeWelfareDao.getHistoryUsedPoint(createTime, employeeNo);
						if(historyUsedPoint != null && historyUsedPoint.size() > 0){
							beforePoints = historyUsedPoint.get(0); // 赋值给当前用户的历史积分临时变量
						}
					}
					EmployeeWelfare welfare = new EmployeeWelfare();
					String productName = ((String) map.get("PRODUCTNAME")).trim();
					BigDecimal singlePoints =  new BigDecimal(String.valueOf(map.get("SINGLEPOINTS")));
					BigDecimal exchangeRate =  new BigDecimal(String.valueOf(map.get("RATE")));
					BigDecimal specimalPoints =  new BigDecimal(String.valueOf(map.get("SPECIALPOINTS")));
					BigDecimal price = singlePoints.divide(exchangeRate, SMALLNUM, BigDecimal.ROUND_HALF_EVEN);
					BigDecimal sellMoney = specimalPoints.divide(exchangeRate, SMALLNUM, BigDecimal.ROUND_HALF_EVEN);
					productNum = specimalPoints.divide(singlePoints, SMALLNUM, BigDecimal.ROUND_HALF_EVEN);
					String key = (employeeNo+"@"+employeeName+"@"+orderNo).trim();
					if(!currentUser.equals(employeeNo)) {
						currentUser = employeeNo;
						specialPoints = BigDecimal.ZERO;
					}
					if(welfareMap.containsKey(key)){ // map中包含当前key做累加操作
						welfare = welfareMap.get(key);
						specialPoints = specialPoints.add(welfareMap.get(key).getSumSpecialPoints());
						beforePoints = beforePoints.add(specialPoints);
						welfare.setEmployeeName(employeeName);
						welfare.setEmployeeNumber(employeeNo);
						welfare.setCompany(company);
						welfare.setPrice(price);
						welfare.setCreateTime(createTime);
						welfare.setProductName(productName);
						welfare.setProductNum(productNum);
						welfare.setSumSpecialMoney(sellMoney);
						welfare.setSumSpecialPoints(specimalPoints);
					}else{
						welfare.setCompany(company);
						welfare.setEmployeeName(employeeName);
						welfare.setEmployeeNumber(employeeNo);
						welfare.setPrice(price);
						welfare.setProductName(productName);
						welfare.setProductNum(productNum);
						welfare.setSumSpecialMoney(sellMoney);
						welfare.setSumSpecialPoints(specimalPoints);
						welfare.setCreateTime(createTime);
					}
					// 第三步: 判断当前用户领取了哪些福利,并针对商品添加消费的福利名称 
					if(i == 1){ // 只领中秋礼包积分
						this.getWelfareName(welfare, MIDDLE_NAME);
					}else if(i == 2){ // 只领春节礼包积分
						this.getWelfareName(welfare, NEWYEAR_NAME);
					}else if(i == 3){ // 只领元宵节礼包积分
						this.getWelfareName(welfare, LARTEN_NAME);
					}else if(i == 4){ // 只领中秋节礼包积分和春节礼包积分
						
						// 消费的历史福利积分小于等于4万积分
						if(beforePoints.compareTo(MIDDLE_AUTUMN_FESTIVAL_GIFT_2016) <= 0){
							//历史订单积分加本次订单积分小于等于40000则本次订单所用积分是中秋积分
							if(beforePoints.add(specimalPoints).compareTo(new BigDecimal(40000)) <= 0){
								this.getWelfareName(welfare, MIDDLE_NAME);
							}else if(beforePoints.add(specimalPoints).compareTo(new BigDecimal(140000)) <= 0){ // 历史订单积分加上本次订单积分大于40000小于等于140000
								if(beforePoints.compareTo(new BigDecimal(40000)) < 0){
									this.getWelfareName(welfare, MIDDLE_NAME);
									this.getWelfareName(welfare, NEWYEAR_NAME);
								}else if(beforePoints.compareTo(new BigDecimal(40000)) >= 0){
									this.getWelfareName(welfare, NEWYEAR_NAME);
								}
							}
						}else{ //历史订单积分数大于40000则表示现在所下订单均为春节礼包
							this.getWelfareName(welfare, NEWYEAR_NAME);
						}
					}else if(i ==  5){// 只领中秋、春节、元宵福利
						if(beforePoints.add(specimalPoints).compareTo(MIDDLE_AUTUMN_FESTIVAL_GIFT_2016) <= 0){ // 历史订单积分加本次订单积分小于等于40000则本次订单所用积分是中秋积分
							this.getWelfareName(welfare, MIDDLE_NAME);
						}else if(beforePoints.add(specimalPoints).compareTo(MIDDLE_SPRINGYEAR_GIFT) <= 0){ // 历史订单积分加上本次订单积分大于40000小于等于140000
							if(beforePoints.compareTo(MIDDLE_AUTUMN_FESTIVAL_GIFT_2016) < 0){
								this.getWelfareName(welfare, MIDDLE_NAME);
								this.getWelfareName(welfare, NEWYEAR_NAME);
							}else if(beforePoints.compareTo(MIDDLE_AUTUMN_FESTIVAL_GIFT_2016) >= 0){
								this.getWelfareName(welfare, NEWYEAR_NAME);
							}
						}
						else if(beforePoints.add(specimalPoints).compareTo(MIDDLE_SPRINGYEAR_LANTERN_GIFT) <= 0){ //历史订单积分加上本次订单积分大于140000小于等于150000
							if(beforePoints.compareTo(MIDDLE_AUTUMN_FESTIVAL_GIFT_2016) < 0){ // 历史订单积分小于 4万积分
								this.getWelfareName(welfare, MIDDLE_NAME);
								this.getWelfareName(welfare, NEWYEAR_NAME);
								this.getWelfareName(welfare, LARTEN_NAME);
							}else if(beforePoints.compareTo(MIDDLE_SPRINGYEAR_GIFT) < 0){ // 历史订单积分小于 14万积分
								this.getWelfareName(welfare, NEWYEAR_NAME);
								this.getWelfareName(welfare, LARTEN_NAME);
							}else{
								this.getWelfareName(welfare, LARTEN_NAME);
							}
						}
					}else if(i == 6){ // 只领春节、元宵福利
						if(beforePoints.add(specimalPoints).compareTo(SPRING_FESTIVAL_GIFT_2017) <= 0) { //历史订单加本次小于等于10万积分
							this.getWelfareName(welfare, NEWYEAR_NAME);
						}else if(beforePoints.add(specimalPoints).compareTo(SPRING_LARTEN_GIFT) <= 0) { //历史订单加本次积分大于10万积分小于等于11万
							if(beforePoints.compareTo(SPRING_FESTIVAL_GIFT_2017)<0) {   //历史订单小于等于10万积分
								this.getWelfareName(welfare, NEWYEAR_NAME);
								this.getWelfareName(welfare, LARTEN_NAME);
							}else {
								this.getWelfareName(welfare, LARTEN_NAME);
							}
						}
					}
					//添加新表
//					employeeWelfareDao.insertEmployeeWelfare(welfare); 
					EmployeeWelfare employeeWelfares = welfareMap.get(key);
					if(employeeWelfares == null){
						welfareMap.put(key.trim(), welfare);
					}else{
						String oldKey = employeeWelfares.getEmployeeNumber()+"@"+employeeWelfares.getEmployeeName()+"@"+orderNo;
						if(oldKey.trim().equals(key.trim()) && welfareMap.containsKey(key)){
							welfareMap.put(key.trim(), welfare);
						}
					}
				}
			}
		}
//		return this.getWelfareLisit(welfareMap, currentPage, pageSize,welfareIndex);
		return null;
	}
	/**
	 * 中秋、春节、元宵员工福利查询业务处理
	 * @param welfareMap
	 * @param currentPage
	 * @param pageSize
	 * @param welfareIndex
	 * @return
	 */
	public Map<String, Object> getWelfareLisit1(String startDate,String endDate,int currentPage,int pageSize,String employeeNmae,String welfareIndex){
		Map<String,Object> map = new HashMap<String, Object>();
//		String welfareName = "";
		BigDecimal sumNum = BigDecimal.valueOf(0);
		BigDecimal sumPoints = BigDecimal.valueOf(0);
		BigDecimal sumMoney = BigDecimal.valueOf(0);
		if(welfareIndex.equals("所有专属福利")) {
			welfareIndex = "";
		}
//		if(welfareIndex == 1){
//			welfareName = MIDDLE_NAME;
//		}else if(welfareIndex == 2){
//			welfareName = NEWYEAR_NAME;
//		}else if(welfareIndex == 3){
//			welfareName = LARTEN_NAME;
//		}
		List<EmployeeWelfare> list = employeeWelfareDao.getEmployeeWelfareList(startDate,endDate,employeeNmae,welfareIndex);
		if(list != null && list.size() > 0) {
			for (EmployeeWelfare employeeWelfare : list) {
				BigDecimal num = employeeWelfare.getProductNum();
				BigDecimal points = employeeWelfare.getSumSpecialPoints();
				BigDecimal money = employeeWelfare.getSumSpecialMoney();
				sumNum = sumNum.add(num);
				sumPoints = sumPoints.add(points);
				sumMoney = sumMoney.add(money);
			}
			map.put("total", list.size());
			if(currentPage > 0 && pageSize > 0){
				int lastIndex = currentPage*pageSize;
				int index = (currentPage-1)*pageSize;
				int size = list.size();
				if (lastIndex <= size) {
					list = list.subList(index, lastIndex);
				} else {
					list = list.subList(index, size);
				}
			}
			map.put("rows", list);
			map.put("sumProductNum", sumNum);
			map.put("sumPoints", sumPoints);
			map.put("sumMoney", sumMoney);
		}else{
			map.put("total", 1);
			map.put("rows", list);
			map.put("sumProductNum", sumNum);
			map.put("sumPoints", sumPoints);
			map.put("sumMoney", sumMoney);
		}
		return map;
	}
	/**
	 * 中秋、春节、元宵员工福利查询业务处理
	 * @param welfare
	 * @param name
	 * @return
	 */
	public String getWelfareName(EmployeeWelfare welfare,String name){
		if(StringUtils.isNotBlank(welfare.getWelfareName()) && !welfare.getWelfareName().contains(name)){
			welfare.setWelfareName(welfare.getWelfareName()+","+name);
		}else{
			welfare.setWelfareName(name);
		}
		return welfare.getWelfareName();
	}

}
