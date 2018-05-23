package com.zhb.dataAnalysis.finance.service;

import com.zhb.dataAnalysis.common.repository.database.customerService.EmployeeWelfareDao;
import com.zhb.dataAnalysis.common.repository.database.finance.SupplierBillDao;
import com.zhb.dataAnalysis.common.repository.database.model.*;
import com.zhb.dataAnalysis.common.utils.ExportExcelUtil;
import com.zhb.dataAnalysis.finance.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("financeExportService")
public class FinanceExportUtilsSerciecImpl implements FinanceExportUtilsService{
	
	@Resource(name="supplierBillServiceImpl")
	private SupplierBillService supplierBillServiceImpl;
	
	@Resource(name = "employeeWelfareService")
	private EmployeeWelfareService employeeWelfareService;
	
	@Resource(name = "customerService")
	private CustomerService customerService;
	
	@Resource(name="payPlatformService")
	private PayPlatformService payPlatformService;

	@Resource(name = "employeeWelfareDao")
	private EmployeeWelfareDao employeeWelfareDao;

	@Resource(name="supplierBillDao")
	private SupplierBillDao supplierBillDao;
	
	private final static Logger logger = LoggerFactory.getLogger(FinanceExportUtilsService.class);

	@Override
	public void downWelfareExcel(HttpServletResponse reponse, HttpServletRequest request, String startDate, String endDate, String employeeNmae, String welfareIndex) {
		logger.info("================="+employeeNmae+"============"+welfareIndex);
		welfareIndex=welfareIndex.trim();
		if(welfareIndex.equals("所有专属福利")) {
			welfareIndex="";
		}
		List<EmployeeWelfare> list = employeeWelfareDao.getEmployeeWelfareExport(startDate,endDate,employeeNmae,welfareIndex);
//		计算===========================================================================
		//大金融和金信发一张券才计算
		for (EmployeeWelfare e: list) {
			e.setProductNum(e.getProductNum().setScale(4, BigDecimal.ROUND_HALF_UP));
			String welfareName=e.getWelfareName();
			if(welfareName.equals("投资产品体验奖励")){
//				本次积分使用数
				BigDecimal sumPoint=e.getSumSpecialPoints();
//				查询此前已用福利券积分
				int usePointByJxOrDjr=employeeWelfareDao.getOldUsePoint(e.getTimestampTime(), e.getEmployeeNumber(), welfareName,e.getNumbers());
				//已知员工编号可查出此券共多少积分 大金融+金信各多少积分
				String employeeNo=e.getEmployeeNumber();
				Map<String,BigDecimal> pointTotalandBuJxDjr=employeeWelfareDao.getEmActivityLog(employeeNo, welfareName);
				int djrPoint=pointTotalandBuJxDjr.get("DJR_POINTS").intValue();
				int jxPoint=pointTotalandBuJxDjr.get("JX_POINTS").intValue();
				//分配积分  大金融优先分配
				/**
				 * 1:首先用券的djr部分积分减去已用积分  如果相等则本次分配jx
				 * 如果大于则先分配差值 如果小于则与jx相加，相加后等于或小于0则本次不分配积分，如果大于则分配本次积分
				 */
				int  djrPointAl=djrPoint-usePointByJxOrDjr;
				if(djrPointAl<=0){
					e.setDjrPoints(0);
					jxPoint=jxPoint+djrPointAl;
					if(jxPoint<=0){
						e.setJxPoints(0);
					}else {
						int  jxPointd=jxPoint-sumPoint.intValue();
						if(jxPointd<=0){
							e.setJxPoints(jxPoint);
						}else if(jxPoint>0){
							e.setJxPoints(sumPoint.intValue());
						}
					}
				}else if(djrPointAl>0){
					int djrPointDe=djrPointAl-sumPoint.intValue();
					if(djrPointDe<=0){
						e.setDjrPoints(djrPointAl);
						int jxPointDe=jxPoint+djrPointDe;
//							jxPoint=jxPoint-sumPoint.intValue();
						if(jxPointDe<=0){
							e.setJxPoints(jxPoint);
						}else {
							e.setJxPoints(0-djrPointDe);
						}
					} else {
						e.setDjrPoints(sumPoint.intValue());
						e.setJxPoints(0);
					}
				}


			}
		}
//		计算结束==================================================================
		List<Map<String, String>> employeeGift = new ArrayList<Map<String, String>>();
		if(list.size() != 0){
			employeeGift = employeeWelfareService.getEmployeeGift1(startDate, endDate, 0, 0, employeeNmae, welfareIndex);
		}
		int size = employeeGift.size()+1;
		String[] sheetName = new String[size];
		
		List<Object[]> arrayList1 = null;
		Object[] objs1 = null;
		
		List<List<Object[]>>  dataList1 = new ArrayList<List<Object[]>>();
		if(welfareIndex.equals("")){
			welfareIndex="所有专属福利";
		}
		if(!welfareIndex.equals("所有专属福利")){
			sheetName = new String[]{welfareIndex};
			arrayList1 = new ArrayList<Object[]>();
		}else{
			for(int i = 0; i < sheetName.length; i++) {
				if(i == 0) {
					sheetName[i] = "所有专属福利";
				}
				else {
					for (Map<String, String> map : employeeGift) {
						sheetName[i] = map.get("GIFTNAME");
						i++;
			        }
				}
			}
		}
		String[] rowsName = new String[]{"序号","公司名称","员工姓名","员工编号","商品名称","商品规格","数量","实际销售单价（元）","福利券支付积分","福利券支付金额（元）","税率","税收分类编码","投资产品体验奖励-信和大金融","投资产品体验奖励-金信网"};
		if(!welfareIndex.equals("所有专属福利")){
			for (int i = 0; i < list.size(); i++) {
				EmployeeWelfare welfare = list.get(i);
				objs1 = new Object[rowsName.length];
				objs1[0] = i+1;
				objs1[1] = welfare.getCompany();
				objs1[2] = welfare.getEmployeeName();
				objs1[3] = welfare.getEmployeeNumber();
				objs1[4] = welfare.getProductName();
				objs1[5] = welfare.getNormInfo();
				objs1[6] = welfare.getProductNum();
				objs1[7] = welfare.getPrice();
				objs1[8] = welfare.getSumSpecialPoints();
				objs1[9] = welfare.getSumSpecialMoney();
				if(welfare.getTaxRate() != null){
					objs1[10] = welfare.getTaxRate().multiply(new BigDecimal(100)) + "%";
				}else{
					objs1[10] = welfare.getTaxRate();
				}
				objs1[11] = welfare.getTaxTypeCode();
				if(welfareIndex.equals("投资产品体验奖励")) {
					objs1[12] = welfare.getDjrPoints();
					objs1[13] = welfare.getJxPoints();
				}
				arrayList1.add(objs1);
			}
			dataList1.add(arrayList1);
		}else{
			for(int j = 0; j <sheetName.length; j++) {
				List<Object[]> arrayList = new ArrayList<Object[]>();
				Object[] objs = null;
				if(sheetName[j].equals("所有专属福利")) {
					for (int i = 0; i < list.size(); i++) {
						EmployeeWelfare welfare = list.get(i);
						System.out.println("rowsName.length=====" + rowsName.length);
							objs = new Object[rowsName.length];
							objs[0] = i + 1;
							objs[1] = welfare.getCompany();
							objs[2] = welfare.getEmployeeName();
							objs[3] = welfare.getEmployeeNumber();
							objs[4] = welfare.getProductName();
							objs[5] = welfare.getNormInfo();
							objs[6] = welfare.getProductNum();
							objs[7] = welfare.getPrice();
							objs[8] = welfare.getSumSpecialPoints();
							objs[9] = welfare.getSumSpecialMoney();
							if (welfare.getTaxRate() != null) {
								objs[10] = welfare.getTaxRate().multiply(new BigDecimal(100)) + "%";
							} else {
								objs[10] = welfare.getTaxRate();
							}
							objs[11] = welfare.getTaxTypeCode();
							if (welfare.getEmployeeName().equals("投资产品体验奖励")) {
							objs[12] = welfare.getDjrPoints();
							objs[13] = welfare.getJxPoints();
						}
							arrayList.add(objs);
						}
				}else if(sheetName[j].equals("投资产品体验奖励")) {
					int a=0;
					for (int i = 0; i < list.size(); i++) {
						EmployeeWelfare welfare = list.get(i);
						if (welfare.getWelfareName().equals("投资产品体验奖励")) {
							a+=1;
							objs = new Object[rowsName.length];
							objs[0] =a;
							objs[1] = welfare.getCompany();
							objs[2] = welfare.getEmployeeName();
							objs[3] = welfare.getEmployeeNumber();
							objs[4] = welfare.getProductName();
							objs[5] = welfare.getNormInfo();
							objs[6] = welfare.getProductNum();
							objs[7] = welfare.getPrice();
							objs[8] = welfare.getSumSpecialPoints();
							objs[9] = welfare.getSumSpecialMoney();
							if (welfare.getTaxRate() != null) {
								objs[10] = welfare.getTaxRate().multiply(new BigDecimal(100)) + "%";
							} else {
								objs[10] = welfare.getTaxRate();
							}
							objs[11] = welfare.getTaxTypeCode();
							objs[12] = welfare.getDjrPoints();
							objs[13] = welfare.getJxPoints();
							arrayList.add(objs);
						}
					}
				}
				else{
					List<EmployeeWelfare> list1 = employeeWelfareDao.getEmployeeWelfareExport(startDate,endDate,employeeNmae,sheetName[j]);
					for (int k = 0; k < list1.size(); k++) {
						EmployeeWelfare welfare1 = list1.get(k);
						welfare1.setProductNum(welfare1.getProductNum().setScale(4, BigDecimal.ROUND_HALF_UP));
						objs = new Object[rowsName.length];
						objs[0] = k+1;
						objs[1] = welfare1.getCompany();
						objs[2] = welfare1.getEmployeeName();
						objs[3] = welfare1.getEmployeeNumber();
						objs[4] = welfare1.getProductName();
						objs[5] = welfare1.getNormInfo();
						objs[6] = welfare1.getProductNum();
						objs[7] = welfare1.getPrice();
						objs[8] = welfare1.getSumSpecialPoints();
						objs[9] = welfare1.getSumSpecialMoney();
						if(welfare1.getTaxRate() != null){
							objs[10] = welfare1.getTaxRate().multiply(new BigDecimal(100)) + "%";
						}else{
							objs[10] = welfare1.getTaxRate();
						}
						objs[11] = welfare1.getTaxTypeCode();
						arrayList.add(objs);
					}
				}
				dataList1.add(arrayList);
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(reponse, null, rowsName, dataList1, sheetName,  "福利券对账单"+startDate+"~"+endDate,"0");
		ex.export();
		Cookie[] cookie = request.getCookies();
		String username = "";
		for (int i = 0; i < cookie.length; i++) {
			Cookie cook = cookie[i];
			if(cook.getName().equals("username")) {
				username = cook.getValue();
			}
		}
		logger.info(username + "导出福利券对账单成功     "+startDate+"~"+endDate);		
	}

	@Override
	public void downCustomerServiceExcel(HttpServletResponse reponse, String startTime, String endTime, String company) throws UnsupportedEncodingException {

		Object[] objs1 = null;
		String string = new String(company.getBytes("ISO-8859-1"), "UTF-8");
		Map<String, Object> map = customerService.getAccountStatement(startTime, endTime, 0, 0, string);
		@SuppressWarnings("unchecked")
		List<CustomerServiceBean> list = (List<CustomerServiceBean>) map.get("rows");
		if(list != null && list.size() > 0){
			String[] sheetName = new String[]{"四大合作平台-客户服务对账单"};
			List<Object[]> arrayList1 = new ArrayList<Object[]>();
			List<List<Object[]>>  dataList1 = new ArrayList<List<Object[]>>();
			String[] rowsName = new String[]{"序号","公司名称","商品名称","数量","实际销售单价（元）","实际支付总积分","实际支付总积分对应总金额（元）"};
			for (int i = 0; i < list.size(); i++) {
				CustomerServiceBean bean = list.get(i);
				objs1 = new Object[rowsName.length];
				objs1[0] = i+1;
				String companyName = bean.getCompanyName();
				if(companyName.equals("XH_DJR")){
					objs1[1] = "信和大金融";
				}else if(companyName.equals("XH_JX")){
					objs1[1] = "金信网";
				}else if(companyName.equals("XH_CF")){
					objs1[1] = "信和财富";
				}else if(companyName.equals("XH_JK")){
					objs1[1] = "信和汇金";
				}
				objs1[2] = bean.getGoodsName();
				objs1[3] = bean.getNum();
				objs1[4] = bean.getActualSellPrice();
				objs1[5] = bean.getActualPayPoints();
				objs1[6] = bean.getActualPayMoney();
				arrayList1.add(objs1);
			}
			dataList1.add(arrayList1);
			ExportExcelUtil util = new ExportExcelUtil(reponse, null, rowsName, dataList1, sheetName, "四大合作平台-客户服务对账单", "0");
			util.export();
		}
		
	}

	@Override
	public void exportSupplierBill(HttpServletResponse reponse, HttpServletRequest request, String supplierBillPrev, String supplierBillNext, String shortName, String activity, int data,boolean payBox) throws UnsupportedEncodingException {

		if(shortName==null){
			shortName="";
		}
		shortName = URLDecoder.decode(shortName,"UTF-8");
		activity = URLDecoder.decode(activity,"UTF-8");
		int sumNum = 0;
		double sumMoney = 0.00;
		int sumNum1 = 0;
		double sumMoney1 = 0.00;
		double sumReturnCash=0.00;
		double sumReturnCash1=0.00;
		List<SupplierBill> list = supplierBillServiceImpl.getSupplierBillList(supplierBillPrev, supplierBillNext, shortName, activity, data,payBox);

		String[] title = null;
		String[] rowsName =null;
		if(payBox){
			//查询
			 title=	new String[]{"普通商品订单"};
			rowsName = new String[]{"序号","货物（劳务)名称","规格","单位","数量","单价","金额","费率","费率编码"};
		} else {
			title=	new String[]{"活动商品销售明细","非活动商品销售明细"};
			rowsName = new String[]{"序号","供应商简称","商品名称","数量","实际供货价","供货金额"};
		}
		DecimalFormat df = new DecimalFormat("0.0000");
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		List<Object[]> dataList2 = new ArrayList<Object[]>();
		Object[] objs = null; 
		int j = 1;
		int k = 1;
		String[] sheetName=null;
		if(payBox){
			for (int i = 0; i < list.size(); i++) {
					objs = new Object[rowsName.length];
					objs[0] = j;
					objs[1] = list.get(i).getName();
				    objs[2] = list.get(i).getPsize();
					objs[3] = list.get(i).getStandard();
					objs[4] = df.format(list.get(i).getUsedCash() / list.get(i).getSinglePoints());
					objs[5] = list.get(i).getSinglePoints();
					objs[6] =list.get(i).getUsedCash();
					objs[7]=list.get(i).getTaxRete();
					objs[8]= list.get(i).getTaxTypeCode();
//					sumNum += list.get(i).getNum();
//					sumMoney += list.get(i).getMoney();
//				sumReturnCash+= list.get(i).getReturnCash();
					dataList1.add(objs);
					j++;
			}
			/**
			 * 查询往期退款
			 * 在筛选范围时间内，产生退款（取消订单成功与退货成功）且订单成功下单时间非当前筛选范围时间内的订单礼品卡支付金额之和
			 */

		 	sumReturnCash=supplierBillDao.getSumReturnCash(supplierBillPrev,supplierBillNext);
			sumReturnCash=sumReturnCash==0?0.0000:sumReturnCash;
			Object[] obj1 = new Object[]{"往期退款金额","","","","","",df.format(sumReturnCash),"",""};;
			dataList1.add(obj1);
			sheetName = new String[]{"普通商品订单"};
			dataList.add(dataList1);
		}else {
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getActivity().equals("活动类")) {
					objs = new Object[rowsName.length];
					objs[0] = j;
					objs[1] = list.get(i).getShortName();
					objs[2] = list.get(i).getName();
					objs[3] = list.get(i).getNum();
					objs[4] = list.get(i).getPrice();
					objs[5] = list.get(i).getMoney();
//				objs[6]=list.get(i).getTaxRete();
//				objs[7]= list.get(i).getTaxTypeCode();
					sumNum += list.get(i).getNum();
					sumMoney += list.get(i).getMoney();
//				sumReturnCash+= list.get(i).getReturnCash();
					dataList1.add(objs);
					j++;
				}else if(list.get(i).getActivity().equals("非活动类")){
					objs = new Object[rowsName.length];
					objs[0] = k;
					objs[1] = list.get(i).getShortName();
					objs[2] = list.get(i).getName();
					objs[3] = list.get(i).getNum();
					objs[4] = list.get(i).getPrice();
					objs[5] = list.get(i).getMoney();
//				objs[6]=list.get(i).getTaxRete();
//				objs[7]=list.get(i).getTaxTypeCode();
					sumNum1 += list.get(i).getNum();
					sumMoney1 += list.get(i).getMoney()==null?0:list.get(i).getMoney();
//				sumReturnCash1+=list.get(i).getReturnCash();
					dataList2.add(objs);
					k++;
				}
			}
			Object[] obj = new Object[]{"","","",sumNum,"",df.format(sumMoney)};
			Object[] obj1 = new Object[]{"","","",sumNum1,"",df.format(sumMoney1)};
			dataList1.add(obj);
			dataList2.add(obj1);
			dataList.add(dataList1);
			dataList.add(dataList2);
			 sheetName = new String[]{"活动商品对账单","非活动商品账单"};
		}
		ExportExcelUtil ex = new ExportExcelUtil(reponse,title, rowsName, dataList,sheetName, "供应商对账单","1"); 
		ex.export();
		Cookie[] cookie = request.getCookies();
		String username = "";
		for (int i = 0; i < cookie.length; i++) {
			Cookie cook = cookie[i];
			if(cook.getName().equals("username")) {
				username = cook.getValue();
			}
		}
		logger.info(username + "导出供应商对账单成功     "+supplierBillPrev+"~"+supplierBillNext);
	}

	@Override
	public void downPayPlatFormExport(HttpServletResponse reponse,HttpServletRequest request, PayPlatForm pay) {
		Object[] objs1 = null;
		Map<String, Object> map = payPlatformService.getPayPlatform(pay);
		List<PayPlatformModel> list = (List<PayPlatformModel>) map.get("rows");
		if(list != null && list.size() > 0){
			String[] sheetName = new String[]{"支付平台对账单"};
			List<Object[]> arrayList1 = new ArrayList<Object[]>();
			List<List<Object[]>>  dataList1 = new ArrayList<List<Object[]>>();
			String[] rowsName = new String[]{"序号","日期","主订单号","支付平台流水号","渠道","支付方式","支付金额（元）","退款金额（元）","手续费金额（元）","实际收入金额（元）","费率"};
			for (int i = 0; i < list.size(); i++) {
				PayPlatformModel bean = list.get(i);
				objs1 = new Object[rowsName.length];
				objs1[0] = i+1;
				objs1[1] = bean.getCreateTime();
				objs1[2] = bean.getOrderMain();
				objs1[3] = bean.getPayID();
				String channel = bean.getChannel();
				if(channel.equals("1") || channel.equals("2") || channel.equals("4")){
					objs1[4] = "爱品选";
				}else if(channel.equals("app") || channel.equals("h5") || channel.equals("WX")) {
					objs1[4] = "爱品选";
        		}else if(channel.equals("3")){
					objs1[4] = "微匠";
				}else{
					objs1[4] = channel;
				}
				String orderS = bean.getPaySourse();
				if(orderS.equals("1")){
					objs1[5] = "微信支付（普通）";
				}else if(orderS.equals("3")){
					objs1[5] = "微信支付（公众号）";
				}else if(orderS.equals("4")){
					objs1[5] = "支付宝支付";
				}else if(orderS.equals("6")){
					objs1[5] = "微信支付（H5）";
				}
				objs1[6] = bean.getPayCash1();
				String returnCash = bean.getReturnCash1();
				if(returnCash.equals("0.00")) {
					objs1[7] = returnCash;
				}else{
					objs1[7] = "-"+ returnCash;
				}
				String serviceCash = bean.getServiceCash1();
				if(serviceCash.equals("0.00")) {
					objs1[8] = serviceCash;
				}else{
					objs1[8] = "-"+ serviceCash;
				}
				objs1[9] = bean.getCash1();
				objs1[10] = bean.getRate1()+"%";
				arrayList1.add(objs1);
			}
			dataList1.add(arrayList1);
			ExportExcelUtil util = new ExportExcelUtil(reponse, null, rowsName, dataList1, sheetName, "支付平台对账单", "0");
			util.export();
			Cookie[] cookie = request.getCookies();
			String username = "";
			for (int i = 0; i < cookie.length; i++) {
				Cookie cook = cookie[i];
				if(cook.getName().equals("username")) {
					username = cook.getValue();
				}
			}
			logger.info(username + "导出支付平台对账单成功     "+pay.getStartDate()+"~"+pay.getEndDate());
		}
	}


}
