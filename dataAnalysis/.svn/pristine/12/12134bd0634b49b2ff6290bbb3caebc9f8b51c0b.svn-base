package com.zhb.dataAnalysis.marketing.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.zhb.dataAnalysis.common.utils.ExportExcelUtil;
import org.springframework.stereotype.Service;

import com.zhb.dataAnalysis.marketing.api.ExportUtilService;
import com.zhb.dataAnalysis.marketing.api.HKMacaoService;
import com.zhb.dataAnalysis.marketing.api.IActivityTemplateService;
import com.zhb.dataAnalysis.marketing.api.IWuChangRiceService;
import com.zhb.dataAnalysis.marketing.api.SilkActivityService;

@Service("exportUtilService")
@SuppressWarnings("unchecked")
public class ExportUtilServiceImpl implements ExportUtilService{
	
	@Resource(name="silkActivityService")
	private SilkActivityService silkActivityService; 
	
	@Resource(name="hKMacalService")
	private HKMacaoService hKMacalService;
	
	@Resource(name="activityTemplateService")
	private IActivityTemplateService activityTemplateService;
	
	@Resource(name="wuChangRiceService")
	private IWuChangRiceService wuChangRiceService;
	
	
	private void generateExcel(HttpServletResponse response, String spuCount,String spuAPP,String spuMicroMall,String spuMicro,
			String skuCount,String skuAPP,String skuMicroMall,String skuMicro,
			String productDetailCount,String productDetailAPP,String productDetailMicroMall,String productDetailMicro,
			String orderMainCounts,String orderMainApp,String orderMainMicroMall,String orderMainMicro,
			String ordercounts,String orderApp,String orderMicroMall,String orderMicro,
			String cashCounts,String cashCountAPP,String cashCountMicroMall,String cashCountMicro,
			String scoreCounts,String scoreCountAPP,String scoreCountMicroMall,String scoreCountMicro,
			String giftScoreCounts,String giftScoreCountAPP,String giftScoreCountMicroMall,String giftScoreCountMicro,
			String userCounts,String userCountAPP,String userCountMicroMall,String userCountMicro,
			String repeatUserCounts,String repeatUserCountAPP,String repeatUserCountMicroMall,String repeatUserCountMicro,
			String newUserCounts,
			String[] title,String[] sheetName,String fileName) {
		String[] rowsName = new String[]{"销售数据","活动销售SPU种类总数","活动销售SKU种类总数","活动商品总销量","活动主订单总数","活动子订单总数"};
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		Object[] obj = new Object[]{"总数据",spuCount,skuCount,productDetailCount,orderMainCounts,ordercounts};
		Object[] obj1 = new Object[]{"APP",spuAPP,skuAPP,productDetailAPP,orderMainApp,orderApp};
		Object[] obj2 = new Object[]{"微网站",spuMicroMall,skuMicroMall,productDetailMicroMall,orderMainMicroMall,orderMicroMall};
		Object[] obj3 = new Object[]{"微匠",spuMicro,skuMicro,productDetailMicro,orderMainMicro,orderMicro};
		Object[] obj4 = new Object[]{" "," "," "," "};
		Object[] obj5 = new Object[]{"支付数据","现金支付总金额","实际支付总积分","福利券支付总积分"};
		Object[] obj6 = new Object[]{"总数据",cashCounts,scoreCounts,giftScoreCounts};
		Object[] obj7 = new Object[]{"APP",cashCountAPP,scoreCountAPP,giftScoreCountAPP};
		Object[] obj8 = new Object[]{"微网站",cashCountMicroMall,scoreCountMicroMall,giftScoreCountMicroMall};
		Object[] obj9 = new Object[]{"微匠",cashCountMicro,scoreCountMicro,giftScoreCountMicro};
		Object[] obj10 = new Object[]{" "," "," "," "};
		Object[] obj11 = new Object[]{"参与数据","活动参与总人数","重复参与人数","新增会员数"};
		Object[] obj12 = new Object[]{"总数据",userCounts,repeatUserCounts,newUserCounts};
		Object[] obj13 = new Object[]{"APP",userCountAPP,repeatUserCountAPP,"--"};
		Object[] obj14 = new Object[]{"微网站",userCountMicroMall,repeatUserCountMicroMall,"--"};
		Object[] obj15 = new Object[]{"微匠",userCountMicro,repeatUserCountMicro,"--"};
		dataList1.add(obj);
		dataList1.add(obj1);
		dataList1.add(obj2);
		dataList1.add(obj3);
		dataList1.add(obj4);
		dataList1.add(obj5);
		dataList1.add(obj6);
		dataList1.add(obj7);
		dataList1.add(obj8);
		dataList1.add(obj9);
		dataList1.add(obj10);
		dataList1.add(obj11);
		dataList1.add(obj12);
		dataList1.add(obj13);
		dataList1.add(obj14);
		dataList1.add(obj15);
		dataList.add(dataList1);		
		ExportExcelUtil ex = new ExportExcelUtil(response,title, rowsName, dataList,sheetName, fileName,"0");
		ex.export();
	}
	private void generateExcelN(HttpServletResponse response, String spuCount,String spuAPP,String spuMicroMall,String spuMicro,String spuM,
			String skuCount,String skuAPP,String skuMicroMall,String skuMicro,String skuM,
			String productDetailCount,String productDetailAPP,String productDetailMicroMall,String productDetailMicro,String productDetailM,
			String orderMainCounts,String orderMainApp,String orderMainMicroMall,String orderMainMicro,String orderMainM,
			String ordercounts,String orderApp,String orderMicroMall,String orderMicro,String orderM,
			String cashCounts,String cashCountAPP,String cashCountMicroMall,String cashCountMicro,String cashCountM,
			String scoreCounts,String scoreCountAPP,String scoreCountMicroMall,String scoreCountMicro,String scoreCountM,
			String giftScoreCounts,String giftScoreCountAPP,String giftScoreCountMicroMall,String giftScoreCountMicro,String giftScoreCountM,
			String userCounts,String userCountAPP,String userCountMicroMall,String userCountMicro,String userCountM,
			String repeatUserCounts,String repeatUserCountAPP,String repeatUserCountMicroMall,String repeatUserCountMicro,String repeatUserCountM,
			String newUserCounts,
			String[] title,String[] sheetName,String fileName) {
		String[] rowsName = new String[]{"销售数据","活动销售SPU种类总数","活动销售SKU种类总数","活动商品总销量","活动主订单总数","活动子订单总数"};
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		Object[] obj = new Object[]{"总数据",spuCount,skuCount,productDetailCount,orderMainCounts,ordercounts};
		Object[] obj1 = new Object[]{"APP",spuAPP,skuAPP,productDetailAPP,orderMainApp,orderApp};
		Object[] obj2 = new Object[]{"微网站",spuMicroMall,skuMicroMall,productDetailMicroMall,orderMainMicroMall,orderMicroMall};
		Object[] obj3 = new Object[]{"微匠",spuMicro,skuMicro,productDetailMicro,orderMainMicro,orderMicro};
		Object[] obj16 = new Object[]{"M站",spuM,skuM,productDetailM,orderMainM,orderM};
		Object[] obj4 = new Object[]{" "," "," "," "};
		Object[] obj5 = new Object[]{"支付数据","现金支付总金额","实际支付总积分","福利券支付总积分"};
		Object[] obj6 = new Object[]{"总数据",cashCounts,scoreCounts,giftScoreCounts};
		Object[] obj7 = new Object[]{"APP",cashCountAPP,scoreCountAPP,giftScoreCountAPP};
		Object[] obj8 = new Object[]{"微网站",cashCountMicroMall,scoreCountMicroMall,giftScoreCountMicroMall};
		Object[] obj9 = new Object[]{"微匠",cashCountMicro,scoreCountMicro,giftScoreCountMicro};
		Object[] obj17 = new Object[]{"M站",cashCountM,scoreCountM,giftScoreCountM};
		Object[] obj10 = new Object[]{" "," "," "," "};
		Object[] obj11 = new Object[]{"参与数据","活动参与总人数","重复参与人数","新增会员数"};
		Object[] obj12 = new Object[]{"总数据",userCounts,repeatUserCounts,newUserCounts};
		Object[] obj13 = new Object[]{"APP",userCountAPP,repeatUserCountAPP,"--"};
		Object[] obj14 = new Object[]{"微网站",userCountMicroMall,repeatUserCountMicroMall,"--"};
		Object[] obj15 = new Object[]{"微匠",userCountMicro,repeatUserCountMicro,"--"};
		Object[] obj18 = new Object[]{"M站",userCountM,repeatUserCountM,"--"};
		dataList1.add(obj);
		dataList1.add(obj1);
		dataList1.add(obj2);
		dataList1.add(obj3);
		dataList1.add(obj16);
		dataList1.add(obj4);
		dataList1.add(obj5);
		dataList1.add(obj6);
		dataList1.add(obj7);
		dataList1.add(obj8);
		dataList1.add(obj9);
		dataList1.add(obj17);
		dataList1.add(obj10);
		dataList1.add(obj11);
		dataList1.add(obj12);
		dataList1.add(obj13);
		dataList1.add(obj14);
		dataList1.add(obj15);
		dataList1.add(obj18);
		dataList.add(dataList1);		
		ExportExcelUtil ex = new ExportExcelUtil(response,title, rowsName, dataList,sheetName, fileName,"0"); 
		ex.export();
	}
	private void generateExcelN2(HttpServletResponse response, String spuCount,String spuAPP,String spuMicroMall,String spuMicro,String spuM,
			String skuCount,String skuAPP,String skuMicroMall,String skuMicro,String skuM,
			String productDetailCount,String productDetailAPP,String productDetailMicroMall,String productDetailMicro,String productDetailM,
			String orderMainCounts,String orderMainApp,String orderMainMicroMall,String orderMainMicro,String orderMainM,
			String ordercounts,String orderApp,String orderMicroMall,String orderMicro,String orderM,
			String cashCounts,String cashCountAPP,String cashCountMicroMall,String cashCountMicro,String cashCountM,
			String scoreCounts,String scoreCountAPP,String scoreCountMicroMall,String scoreCountMicro,String scoreCountM,
			String giftScoreCounts,String giftScoreCountAPP,String giftScoreCountMicroMall,String giftScoreCountMicro,String giftScoreCountM,
			String userCounts,String userCountAPP,String userCountMicroMall,String userCountMicro,String userCountM,
			String repeatUserCounts,String repeatUserCountAPP,String repeatUserCountMicroMall,String repeatUserCountMicro,String repeatUserCountM,
			String newUserCounts,
			String[] title,String[] sheetName,String fileName) {
		String[] rowsName = new String[]{"销售数据","活动销售SPU种类总数","活动销售SKU种类总数","活动商品总销量","活动主订单总数","活动子订单总数"," "};
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		Object[] obj = new Object[]{"总数据",spuCount,skuCount,productDetailCount,orderMainCounts,ordercounts};
		Object[] obj1 = new Object[]{"APP",spuAPP,skuAPP,productDetailAPP,orderMainApp,orderApp};
		Object[] obj2 = new Object[]{"微网站",spuMicroMall,skuMicroMall,productDetailMicroMall,orderMainMicroMall,orderMicroMall};
		Object[] obj3 = new Object[]{"微匠",spuMicro,skuMicro,productDetailMicro,orderMainMicro,orderMicro};
		Object[] obj16 = new Object[]{"M站",spuM,skuM,productDetailM,orderMainM,orderM};
		Object[] obj4 = new Object[]{" "," "," "," "};
		Object[] obj5 = new Object[]{"支付数据","现金支付总金额","实际支付总积分","福利券支付总积分"};
		Object[] obj6 = new Object[]{"总数据",cashCounts,scoreCounts,giftScoreCounts};
		Object[] obj7 = new Object[]{"APP",cashCountAPP,scoreCountAPP,giftScoreCountAPP};
		Object[] obj8 = new Object[]{"微网站",cashCountMicroMall,scoreCountMicroMall,giftScoreCountMicroMall};
		Object[] obj9 = new Object[]{"微匠",cashCountMicro,scoreCountMicro,giftScoreCountMicro};
		Object[] obj17 = new Object[]{"M站",cashCountM,scoreCountM,giftScoreCountM};
		Object[] obj10 = new Object[]{" "," "," "," "};
		Object[] obj11 = new Object[]{"参与数据","活动参与总人数","重复参与人数","新增会员数","拉新会员数","注册页面访问人数","活动页面访问人数"};
		Object[] obj12 = new Object[]{"总数据",userCounts,repeatUserCounts,newUserCounts,"--","--","--"};
		Object[] obj13 = new Object[]{"APP",userCountAPP,repeatUserCountAPP,"--","--","--","--"};
		Object[] obj14 = new Object[]{"微网站",userCountMicroMall,repeatUserCountMicroMall,"--","--","--","--"};
		Object[] obj15 = new Object[]{"微匠",userCountMicro,repeatUserCountMicro,"--","--","--","--"};
		Object[] obj18 = new Object[]{"M站",userCountM,repeatUserCountM,"--","--","--","--"};
		dataList1.add(obj);
		dataList1.add(obj1);
		dataList1.add(obj2);
		dataList1.add(obj3);
		dataList1.add(obj16);
		dataList1.add(obj4);
		dataList1.add(obj5);
		dataList1.add(obj6);
		dataList1.add(obj7);
		dataList1.add(obj8);
		dataList1.add(obj9);
		dataList1.add(obj17);
		dataList1.add(obj10);
		dataList1.add(obj11);
		dataList1.add(obj12);
		dataList1.add(obj13);
		dataList1.add(obj14);
		dataList1.add(obj15);
		dataList1.add(obj18);
		dataList.add(dataList1);		
		ExportExcelUtil ex = new ExportExcelUtil(response,title, rowsName, dataList,sheetName, fileName,"0"); 
		ex.export();
	}
	
	private void schoolSeason(HttpServletResponse response, String spuCount,String spuAPP,String spuMicroMall,String spuMicro,String spuM,
			String skuCount,String skuAPP,String skuMicroMall,String skuMicro,String skuM,
			String productDetailCount,String productDetailAPP,String productDetailMicroMall,String productDetailMicro,String productDetailM,
			String orderMainCounts,String orderMainApp,String orderMainMicroMall,String orderMainMicro,String orderMainM,
			String ordercounts,String orderApp,String orderMicroMall,String orderMicro,String orderM,
			String cashCounts,String cashCountAPP,String cashCountMicroMall,String cashCountMicro,String cashCountM,
			String scoreCounts,String scoreCountAPP,String scoreCountMicroMall,String scoreCountMicro,String scoreCountM,
			String giftScoreCounts,String giftScoreCountAPP,String giftScoreCountMicroMall,String giftScoreCountMicro,String giftScoreCountM,
			String userCounts,String userCountAPP,String userCountMicroMall,String userCountMicro,String userCountM,
			String repeatUserCounts,String repeatUserCountAPP,String repeatUserCountMicroMall,String repeatUserCountMicro,String repeatUserCountM,
			String newUserCounts,
			String activityTotals,String activityMicroMallTotal,String activityMTotal,
			String participationDataTimes,String participationDataNumber,
			String prizeDataTimes, String prizeDataNumber,
			String enjoyDataTimes,
			String expendIntegral,
			String thanksCountTimes, String thanksCountNumber,
			String thirtyCount, String thirtyCountTimes, String thirtyCountNumber,
			String hundredCount, String hundredCountTimes, String hundredCountNumber,
			String twoHundredCount, String twoHundredCountTimes, String twoHundredCountNumber,
			String FiveHundredCount, String FiveHundredCountTimes, String FiveHundredCountNumber,
			String weileCount, String weileCountTimes, String weileCountNumber,
			String summerCount, String summerCountTimes, String summerCountNumber,
			String iPadCount,String iPadCountTimes, String iPadCountNumber,
			String[] title,String[] sheetName,String fileName) {
		String[] rowsName = new String[]{"销售数据","活动销售SPU种类总数","活动销售SKU种类总数","活动商品总销量","活动主订单总数","活动子订单总数"," "," "," "};
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		Object[] obj = new Object[]{"总数据",spuCount,skuCount,productDetailCount,orderMainCounts,ordercounts};
		Object[] obj1 = new Object[]{"APP",spuAPP,skuAPP,productDetailAPP,orderMainApp,orderApp};
		Object[] obj2 = new Object[]{"微网站",spuMicroMall,skuMicroMall,productDetailMicroMall,orderMainMicroMall,orderMicroMall};
		Object[] obj3 = new Object[]{"微匠",spuMicro,skuMicro,productDetailMicro,orderMainMicro,orderMicro};
		Object[] obj16 = new Object[]{"M站",spuM,skuM,productDetailM,orderMainM,orderM};
		Object[] obj4 = new Object[]{" "," "," "," "};
		Object[] obj5 = new Object[]{"支付数据","现金支付总金额","实际支付总积分","福利券支付总积分"};
		Object[] obj6 = new Object[]{"总数据",cashCounts,scoreCounts,giftScoreCounts};
		Object[] obj7 = new Object[]{"APP",cashCountAPP,scoreCountAPP,giftScoreCountAPP};
		Object[] obj8 = new Object[]{"微网站",cashCountMicroMall,scoreCountMicroMall,giftScoreCountMicroMall};
		Object[] obj9 = new Object[]{"微匠",cashCountMicro,scoreCountMicro,giftScoreCountMicro};
		Object[] obj17 = new Object[]{"M站",cashCountM,scoreCountM,giftScoreCountM};
		Object[] obj10 = new Object[]{" "," "," "," "};
		Object[] obj11 = new Object[]{"参与数据","活动参与总人数","重复参与人数","新增会员数","拉新会员数"};
		Object[] obj12 = new Object[]{"总数据",userCounts,repeatUserCounts,newUserCounts,activityTotals};
		Object[] obj13 = new Object[]{"APP",userCountAPP,repeatUserCountAPP,"--","--"};
		Object[] obj14 = new Object[]{"微网站",userCountMicroMall,repeatUserCountMicroMall,"--",activityMicroMallTotal};
		Object[] obj15 = new Object[]{"微匠",userCountMicro,repeatUserCountMicro,"--","--"};
		Object[] obj18 = new Object[]{"M站",userCountM,repeatUserCountM,"--",activityMTotal};
		Object[] obj19 = new Object[]{" "," "," "," "};
		Object[] obj20 = new Object[]{"参与数据","参与数据","中奖数据","分享数据","大转盘消耗积分数"};
		Object[] obj21 = new Object[]{"人次",participationDataTimes,prizeDataTimes,enjoyDataTimes,expendIntegral};
		Object[] obj22 = new Object[]{"人数",participationDataNumber,prizeDataNumber,"--"," "};
		Object[] obj23 = new Object[]{" "," "," "," "};
		Object[] obj24 = new Object[]{"中奖数据","谢谢1","30积分","100积分","200积分","500积分","维乐夫菊粉（件）","夏季凉被（件）","iPad（台）"};
		Object[] obj25 = new Object[]{"奖励值","0",thirtyCount,hundredCount,twoHundredCount,FiveHundredCount,weileCount,summerCount,iPadCount};
		Object[] obj26 = new Object[]{"人次",thanksCountTimes,thirtyCountTimes,hundredCountTimes,twoHundredCountTimes,FiveHundredCountTimes,weileCountTimes,summerCountTimes,iPadCountTimes};
		Object[] obj27 = new Object[]{"人数",thanksCountNumber,thirtyCountNumber,hundredCountNumber,twoHundredCountNumber,FiveHundredCountNumber,weileCountNumber,summerCountNumber,iPadCountNumber};
		dataList1.add(obj);
		dataList1.add(obj1);
		dataList1.add(obj2);
		dataList1.add(obj3);
		dataList1.add(obj16);
		dataList1.add(obj4);
		dataList1.add(obj5);
		dataList1.add(obj6);
		dataList1.add(obj7);
		dataList1.add(obj8);
		dataList1.add(obj9);
		dataList1.add(obj17);
		dataList1.add(obj10);
		dataList1.add(obj11);
		dataList1.add(obj12);
		dataList1.add(obj13);
		dataList1.add(obj14);
		dataList1.add(obj15);
		dataList1.add(obj18);
		dataList1.add(obj19);
		dataList1.add(obj20);
		dataList1.add(obj21);
		dataList1.add(obj22);
		dataList1.add(obj23);
		dataList1.add(obj24);
		dataList1.add(obj25);
		dataList1.add(obj26);
		dataList1.add(obj27);
		dataList.add(dataList1);		
		ExportExcelUtil ex = new ExportExcelUtil(response,title, rowsName, dataList,sheetName, fileName,"0"); 
		ex.export();
	}
	private void generateExcelN3(HttpServletResponse response, String spuCount,String spuAPP,String spuMicroMall,String spuMicro,String spuM,
			String skuCount,String skuAPP,String skuMicroMall,String skuMicro,String skuM,
			String productDetailCount,String productDetailAPP,String productDetailMicroMall,String productDetailMicro,String productDetailM,
			String orderMainCounts,String orderMainApp,String orderMainMicroMall,String orderMainMicro,String orderMainM,
			String ordercounts,String orderApp,String orderMicroMall,String orderMicro,String orderM,
			String cashCounts,String cashCountAPP,String cashCountMicroMall,String cashCountMicro,String cashCountM,
			String scoreCounts,String scoreCountAPP,String scoreCountMicroMall,String scoreCountMicro,String scoreCountM,
			String giftScoreCounts,String giftScoreCountAPP,String giftScoreCountMicroMall,String giftScoreCountMicro,String giftScoreCountM,
			String userCounts,String userCountAPP,String userCountMicroMall,String userCountMicro,String userCountM,
			String repeatUserCounts,String repeatUserCountAPP,String repeatUserCountMicroMall,String repeatUserCountMicro,String repeatUserCountM,
			String newUserCounts,
			String activityTotals,String activityMicroMallTotal,String activityMTotal,
			String[] title,String[] sheetName,String fileName) {
		String[] rowsName = new String[]{"销售数据","活动销售SPU种类总数","活动销售SKU种类总数","活动商品总销量","活动主订单总数","活动子订单总数"};
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		Object[] obj = new Object[]{"总数据",spuCount,skuCount,productDetailCount,orderMainCounts,ordercounts};
		Object[] obj1 = new Object[]{"APP",spuAPP,skuAPP,productDetailAPP,orderMainApp,orderApp};
		Object[] obj2 = new Object[]{"微网站",spuMicroMall,skuMicroMall,productDetailMicroMall,orderMainMicroMall,orderMicroMall};
		Object[] obj3 = new Object[]{"微匠",spuMicro,skuMicro,productDetailMicro,orderMainMicro,orderMicro};
		Object[] obj16 = new Object[]{"M站",spuM,skuM,productDetailM,orderMainM,orderM};
		Object[] obj4 = new Object[]{" "," "," "," "};
		Object[] obj5 = new Object[]{"支付数据","现金支付总金额","实际支付总积分","福利券支付总积分"};
		Object[] obj6 = new Object[]{"总数据",cashCounts,scoreCounts,giftScoreCounts};
		Object[] obj7 = new Object[]{"APP",cashCountAPP,scoreCountAPP,giftScoreCountAPP};
		Object[] obj8 = new Object[]{"微网站",cashCountMicroMall,scoreCountMicroMall,giftScoreCountMicroMall};
		Object[] obj9 = new Object[]{"微匠",cashCountMicro,scoreCountMicro,giftScoreCountMicro};
		Object[] obj17 = new Object[]{"M站",cashCountM,scoreCountM,giftScoreCountM};
		Object[] obj10 = new Object[]{" "," "," "," "};
		Object[] obj11 = new Object[]{"参与数据","活动参与总人数","重复参与人数","新增会员数","拉新会员数"};
		Object[] obj12 = new Object[]{"总数据",userCounts,repeatUserCounts,newUserCounts,activityTotals};
		Object[] obj13 = new Object[]{"APP",userCountAPP,repeatUserCountAPP,"--","--"};
		Object[] obj14 = new Object[]{"微网站",userCountMicroMall,repeatUserCountMicroMall,"--",activityMicroMallTotal};
		Object[] obj15 = new Object[]{"微匠",userCountMicro,repeatUserCountMicro,"--","--"};
		Object[] obj18 = new Object[]{"M站",userCountM,repeatUserCountM,"--",activityMTotal};
		dataList1.add(obj);
		dataList1.add(obj1);
		dataList1.add(obj2);
		dataList1.add(obj3);
		dataList1.add(obj16);
		dataList1.add(obj4);
		dataList1.add(obj5);
		dataList1.add(obj6);
		dataList1.add(obj7);
		dataList1.add(obj8);
		dataList1.add(obj9);
		dataList1.add(obj17);
		dataList1.add(obj10);
		dataList1.add(obj11);
		dataList1.add(obj12);
		dataList1.add(obj13);
		dataList1.add(obj14);
		dataList1.add(obj15);
		dataList1.add(obj18);
		dataList.add(dataList1);		
		ExportExcelUtil ex = new ExportExcelUtil(response,title, rowsName, dataList,sheetName, fileName,"0"); 
		ex.export();
	}
	
	@Override
	public void exportExcel(HttpServletResponse response, String startTime, String endTime, String data, String activityId,String sign,String activityName) {
		if(sign.equals("silk")){
			exportSilk(response, startTime, endTime, data, activityId, activityName);
		}else if(sign.equals("silkHangZhou")){
			exportSilkHangZhou(response,startTime, endTime, data, activityId, activityName);
		}else if(sign.equals("HkMacao")){
			exportHkMacao(response,startTime, endTime, activityId, activityName);
		}else if(sign.equals("avtivityExport")){
			exportAvtivityExport(response, startTime, endTime, data, activityId, activityName);
		}else if(sign.equals("wuChangRiceExport")){
			exportWuChangRice(response, startTime, endTime, data, activityId, activityName);
		}
	}

	/**
	 * 五常大米拉新数据导出
	 * @param response
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @param activityName
	 */
	private void exportWuChangRice(HttpServletResponse response,String startTime, String endTime, String data, String activityId,String activityName) {
		try {
			data = URLDecoder.decode(data,"UTF-8");
			activityName = URLDecoder.decode(activityName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		Map<String, BigDecimal> wuChangRiceData = wuChangRiceService.getWuChangRiceData(startTime, endTime, data, activityId);
		String[] rowsName = new String[]{"页面数据","渠道覆盖数量","领券数量","注册用户","购买数","实际支付金额"};
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		Object[] obj = new Object[]{"总数据",wuChangRiceData.get("channelCount"),wuChangRiceData.get("ticketCount"),wuChangRiceData.get("registerUser"),wuChangRiceData.get("buyNum"),wuChangRiceData.get("payCash")};
		if(!data.equals("兑换码")) {
			data = wuChangRiceService.getChannelName(data);
		}
		if(data == null) {
			data = "";
		}
		dataList1.add(obj);
		dataList.add(dataList1);
		String[] title = new String[]{activityName + data}; 
		String[] sheetName = new String[]{activityName + data};
		ExportExcelUtil ex = new ExportExcelUtil(response,title, rowsName, dataList,sheetName, activityName + data,"0"); 
		ex.export();
	}

	/**
	 * 南瓜姑娘合作平台数据导出
	 * @param response
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param activityName 
	 */
	public void exportAvtivityExport(HttpServletResponse response, String startTime, String endTime, String data, String activityId, String activityName){
		try {
			data = URLDecoder.decode(data,"UTF-8");
			activityName = URLDecoder.decode(activityName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,BigDecimal> spuMap = activityTemplateService.getActivitySPU(startTime, endTime, data, activityId);
		Map<String,BigDecimal> totalMap = activityTemplateService.getActivityTotal(startTime, endTime, data, activityId);
		Map<String,BigDecimal> userTotalMap = activityTemplateService.getActivityUserTotal(startTime, endTime, data, activityId);
		Map<String,BigDecimal> userRepeatMap = activityTemplateService.getActivityUserRepeat(startTime, endTime, data, activityId);
		Map<String,BigDecimal> userAddMap = activityTemplateService.getActivityUserAdd(startTime, endTime);
		Map<String, BigDecimal> activityUserCount = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> participationData = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> prizeData = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> enjoyData = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> expendIntegral = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> thanksCount = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> prizeInterger = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> otherCount = new HashMap<String, BigDecimal>();
		if(startTime.compareTo("2017-08-02 00:00:00") > 0) {
			activityUserCount = activityTemplateService.getActivityUserCount(startTime, endTime, activityId);
			if(activityId.equals("ZHB20170721001")) {
				participationData = activityTemplateService.getParticipationData(startTime, endTime, activityId);
				prizeData = activityTemplateService.getPrizeData(startTime, endTime, activityId);
				enjoyData = activityTemplateService.getEnjoyData(startTime, endTime, activityId);
				expendIntegral = activityTemplateService.getExpendIntegral(startTime, endTime, activityId);
				thanksCount = activityTemplateService.getThanksCount(startTime, endTime, activityId);
				prizeInterger = activityTemplateService.getPrizeInterger(startTime, endTime);
				otherCount = activityTemplateService.getOtherCount(startTime, endTime, activityId);
			}
		}
		String[] title = null;
		String[] sheetName = null;
		String fileName = null;
		String date = "";
		if(data.equals("总数据") || data.equals("全部")) {
			date = "";
		}else{
			date = data;
		}
		title = new String[]{activityName+date}; 
		sheetName = new String[]{activityName+date};		
		fileName = activityName+date;
		
		if(startTime.compareTo("2017-07-01 00:00:00") < 0) {
			generateExcel(response, spuMap.get("saleSpuTotal").toString(),spuMap.get("saleSpuAppTotal").toString(),spuMap.get("saleSpuWebChatTotal").toString(),spuMap.get("saleSpuMicroTotal").toString(), 
					spuMap.get("saleSkuTotal").toString(),spuMap.get("saleSkuAppTotal").toString(),spuMap.get("saleSkuWebChatTotal").toString(),spuMap.get("saleSkuMicroTotal").toString(), 
					totalMap.get("saleProductTotal").toString(),totalMap.get("saleProductAppTotal").toString(),totalMap.get("saleProductWebChatTotal").toString(),totalMap.get("saleProductMicroTotal").toString(), 
					totalMap.get("saleMainOrderTotal").toString(),totalMap.get("saleMainOrderAppTotal").toString(),totalMap.get("saleMainOrderWebChatTotal").toString(),totalMap.get("saleMainOrderMicroTotal").toString(), 
					totalMap.get("saleSubOrderTotal").toString(),totalMap.get("saleSubOrderAppTotal").toString(),totalMap.get("saleSubOrderWebChatTotal").toString(),totalMap.get("saleSubOrderMicroTotal").toString(), 
					totalMap.get("saleCashTotalSub").toString(),totalMap.get("saleCashTotalAppSub").toString(),totalMap.get("saleCashTotalWebChatSub").toString(),totalMap.get("saleCashTotalMicroSub").toString(), 
					totalMap.get("actualPayPointTotal").toString(),totalMap.get("actualPayPointAppTotal").toString(),totalMap.get("actualPayPointWebChatTotal").toString(),totalMap.get("actualPayPointMicroTotal").toString(), 
					totalMap.get("specialCashTotal").toString(),totalMap.get("specialCashAppTotal").toString(),totalMap.get("specialCashWebChatTotal").toString(),totalMap.get("specialCashMicroTotal").toString(), 
					userTotalMap.get("travelUserCount").toString(),userTotalMap.get("travelUserCountAPP").toString(),userTotalMap.get("travelUserCountMicroMall").toString(),userTotalMap.get("travelUserCountMicro").toString(), 
					userRepeatMap.get("travelRepeUserCount").toString(),userRepeatMap.get("travelRepeUserCountAPP").toString(),userRepeatMap.get("travelRepeUserCountMicroMall").toString(),userRepeatMap.get("travelRepeUserCountMicro").toString(), 
					userAddMap.get("USERTOTAL").toString(), title, sheetName, fileName);
		}else if(startTime.compareTo("2017-07-01 00:00:00") > 0 && startTime.compareTo("2017-07-23 00:00:00") < 0){
			generateExcelN(response, spuMap.get("saleSpuTotal").toString(),spuMap.get("saleSpuAppTotal").toString(),spuMap.get("saleSpuWebChatTotal").toString(),spuMap.get("saleSpuMicroTotal").toString(),spuMap.get("saleSpuMTotal").toString(),
					spuMap.get("saleSkuTotal").toString(),spuMap.get("saleSkuAppTotal").toString(),spuMap.get("saleSkuWebChatTotal").toString(),spuMap.get("saleSkuMicroTotal").toString(),spuMap.get("saleSkuMTotal").toString(),
					totalMap.get("saleProductTotal").toString(),totalMap.get("saleProductAppTotal").toString(),totalMap.get("saleProductWebChatTotal").toString(),totalMap.get("saleProductMicroTotal").toString(),totalMap.get("saleProductMTotal").toString(), 
					totalMap.get("saleMainOrderTotal").toString(),totalMap.get("saleMainOrderAppTotal").toString(),totalMap.get("saleMainOrderWebChatTotal").toString(),totalMap.get("saleMainOrderMicroTotal").toString(),totalMap.get("saleMainOrderMTotal").toString(), 
					totalMap.get("saleSubOrderTotal").toString(),totalMap.get("saleSubOrderAppTotal").toString(),totalMap.get("saleSubOrderWebChatTotal").toString(),totalMap.get("saleSubOrderMicroTotal").toString(),totalMap.get("saleSubOrderMTotal").toString(), 
					totalMap.get("saleCashTotalSub").toString(),totalMap.get("saleCashTotalAppSub").toString(),totalMap.get("saleCashTotalWebChatSub").toString(),totalMap.get("saleCashTotalMicroSub").toString(),totalMap.get("saleCashTotalMSub").toString(), 
					totalMap.get("actualPayPointTotal").toString(),totalMap.get("actualPayPointAppTotal").toString(),totalMap.get("actualPayPointWebChatTotal").toString(),totalMap.get("actualPayPointMicroTotal").toString(),totalMap.get("actualPayPointMTotal").toString(), 
					totalMap.get("specialCashTotal").toString(),totalMap.get("specialCashAppTotal").toString(),totalMap.get("specialCashWebChatTotal").toString(),totalMap.get("specialCashMicroTotal").toString(),totalMap.get("specialCashMTotal").toString(), 
					userTotalMap.get("travelUserCount").toString(),userTotalMap.get("travelUserCountAPP").toString(),userTotalMap.get("travelUserCountMicroMall").toString(),userTotalMap.get("travelUserCountMicro").toString(),userTotalMap.get("travelUserCountM").toString(), 
					userRepeatMap.get("travelRepeUserCount").toString(),userRepeatMap.get("travelRepeUserCountAPP").toString(),userRepeatMap.get("travelRepeUserCountMicroMall").toString(),userRepeatMap.get("travelRepeUserCountMicro").toString(),userRepeatMap.get("travelRepeUserCountM").toString(), 
					userAddMap.get("USERTOTAL").toString(), title, sheetName, fileName);
		}else if(startTime.compareTo("2017-07-23 00:00:00") > 0 && startTime.compareTo("2017-08-02 00:00:00") < 0) {
			generateExcelN2(response, spuMap.get("saleSpuTotal").toString(),spuMap.get("saleSpuAppTotal").toString(),spuMap.get("saleSpuWebChatTotal").toString(),spuMap.get("saleSpuMicroTotal").toString(),spuMap.get("saleSpuMTotal").toString(),
					spuMap.get("saleSkuTotal").toString(),spuMap.get("saleSkuAppTotal").toString(),spuMap.get("saleSkuWebChatTotal").toString(),spuMap.get("saleSkuMicroTotal").toString(),spuMap.get("saleSkuMTotal").toString(),
					totalMap.get("saleProductTotal").toString(),totalMap.get("saleProductAppTotal").toString(),totalMap.get("saleProductWebChatTotal").toString(),totalMap.get("saleProductMicroTotal").toString(),totalMap.get("saleProductMTotal").toString(), 
					totalMap.get("saleMainOrderTotal").toString(),totalMap.get("saleMainOrderAppTotal").toString(),totalMap.get("saleMainOrderWebChatTotal").toString(),totalMap.get("saleMainOrderMicroTotal").toString(),totalMap.get("saleMainOrderMTotal").toString(), 
					totalMap.get("saleSubOrderTotal").toString(),totalMap.get("saleSubOrderAppTotal").toString(),totalMap.get("saleSubOrderWebChatTotal").toString(),totalMap.get("saleSubOrderMicroTotal").toString(),totalMap.get("saleSubOrderMTotal").toString(), 
					totalMap.get("saleCashTotalSub").toString(),totalMap.get("saleCashTotalAppSub").toString(),totalMap.get("saleCashTotalWebChatSub").toString(),totalMap.get("saleCashTotalMicroSub").toString(),totalMap.get("saleCashTotalMSub").toString(), 
					totalMap.get("actualPayPointTotal").toString(),totalMap.get("actualPayPointAppTotal").toString(),totalMap.get("actualPayPointWebChatTotal").toString(),totalMap.get("actualPayPointMicroTotal").toString(),totalMap.get("actualPayPointMTotal").toString(), 
					totalMap.get("specialCashTotal").toString(),totalMap.get("specialCashAppTotal").toString(),totalMap.get("specialCashWebChatTotal").toString(),totalMap.get("specialCashMicroTotal").toString(),totalMap.get("specialCashMTotal").toString(), 
					userTotalMap.get("travelUserCount").toString(),userTotalMap.get("travelUserCountAPP").toString(),userTotalMap.get("travelUserCountMicroMall").toString(),userTotalMap.get("travelUserCountMicro").toString(),userTotalMap.get("travelUserCountM").toString(), 
					userRepeatMap.get("travelRepeUserCount").toString(),userRepeatMap.get("travelRepeUserCountAPP").toString(),userRepeatMap.get("travelRepeUserCountMicroMall").toString(),userRepeatMap.get("travelRepeUserCountMicro").toString(),userRepeatMap.get("travelRepeUserCountM").toString(), 
					userAddMap.get("USERTOTAL").toString(), title, sheetName, fileName);
		}else{
			if(activityId.equals("ZHB20170721001")) {
				schoolSeason(response, spuMap.get("saleSpuTotal").toString(),spuMap.get("saleSpuAppTotal").toString(),spuMap.get("saleSpuWebChatTotal").toString(),spuMap.get("saleSpuMicroTotal").toString(),spuMap.get("saleSpuMTotal").toString(),
						spuMap.get("saleSkuTotal").toString(),spuMap.get("saleSkuAppTotal").toString(),spuMap.get("saleSkuWebChatTotal").toString(),spuMap.get("saleSkuMicroTotal").toString(),spuMap.get("saleSkuMTotal").toString(),
						totalMap.get("saleProductTotal").toString(),totalMap.get("saleProductAppTotal").toString(),totalMap.get("saleProductWebChatTotal").toString(),totalMap.get("saleProductMicroTotal").toString(),totalMap.get("saleProductMTotal").toString(), 
						totalMap.get("saleMainOrderTotal").toString(),totalMap.get("saleMainOrderAppTotal").toString(),totalMap.get("saleMainOrderWebChatTotal").toString(),totalMap.get("saleMainOrderMicroTotal").toString(),totalMap.get("saleMainOrderMTotal").toString(), 
						totalMap.get("saleSubOrderTotal").toString(),totalMap.get("saleSubOrderAppTotal").toString(),totalMap.get("saleSubOrderWebChatTotal").toString(),totalMap.get("saleSubOrderMicroTotal").toString(),totalMap.get("saleSubOrderMTotal").toString(), 
						totalMap.get("saleCashTotalSub").toString(),totalMap.get("saleCashTotalAppSub").toString(),totalMap.get("saleCashTotalWebChatSub").toString(),totalMap.get("saleCashTotalMicroSub").toString(),totalMap.get("saleCashTotalMSub").toString(), 
						totalMap.get("actualPayPointTotal").toString(),totalMap.get("actualPayPointAppTotal").toString(),totalMap.get("actualPayPointWebChatTotal").toString(),totalMap.get("actualPayPointMicroTotal").toString(),totalMap.get("actualPayPointMTotal").toString(), 
						totalMap.get("specialCashTotal").toString(),totalMap.get("specialCashAppTotal").toString(),totalMap.get("specialCashWebChatTotal").toString(),totalMap.get("specialCashMicroTotal").toString(),totalMap.get("specialCashMTotal").toString(), 
						userTotalMap.get("travelUserCount").toString(),userTotalMap.get("travelUserCountAPP").toString(),userTotalMap.get("travelUserCountMicroMall").toString(),userTotalMap.get("travelUserCountMicro").toString(),userTotalMap.get("travelUserCountM").toString(), 
						userRepeatMap.get("travelRepeUserCount").toString(),userRepeatMap.get("travelRepeUserCountAPP").toString(),userRepeatMap.get("travelRepeUserCountMicroMall").toString(),userRepeatMap.get("travelRepeUserCountMicro").toString(),userRepeatMap.get("travelRepeUserCountM").toString(), 
						userAddMap.get("USERTOTAL").toString(), 
						activityUserCount.get("activityTotals").toString(),activityUserCount.get("activityMicroMallTotal").toString(),activityUserCount.get("activityMTotal").toString(),
						participationData.get("PARTICIPATIONDATATIMES").toString(),participationData.get("PARTICIPATIONDATANUMBER").toString(),
						prizeData.get("PRIZEDATATIMES").toString(),prizeData.get("PRIZEDATANUMBER").toString(),
						enjoyData.get("ENJOYDATATIMES").toString(),
						expendIntegral.get("EXPENDINTEGRAL").toString(),
						thanksCount.get("THANKSCOUNTTIMES").toString(),thanksCount.get("THANKSCOUNTNUMBER").toString(),
						prizeInterger.get("thirtyCount").toString(),prizeInterger.get("thirtyCountTimes").toString(),prizeInterger.get("thirtyCountNumber").toString(),
						prizeInterger.get("hundredCount").toString(),prizeInterger.get("hundredCountTimes").toString(),prizeInterger.get("hundredCountNumber").toString(),
						prizeInterger.get("twoHundredCount").toString(),prizeInterger.get("twoHundredCountTimes").toString(),prizeInterger.get("twoHundredCountNumber").toString(),
						prizeInterger.get("FiveHundredCount").toString(),prizeInterger.get("FiveHundredCountTimes").toString(),prizeInterger.get("FiveHundredCountNumber").toString(),
						otherCount.get("weileCount").toString(),otherCount.get("weileCountTimes").toString(),otherCount.get("weileCountNumber").toString(),
						otherCount.get("summerCount").toString(),otherCount.get("summerCountTimes").toString(),otherCount.get("summerCountNumber").toString(),
						otherCount.get("iPadCount").toString(),otherCount.get("iPadCountTimes").toString(),otherCount.get("iPadCountNumber").toString(),
						title, sheetName, fileName);
			}else{
				generateExcelN3(response, spuMap.get("saleSpuTotal").toString(),spuMap.get("saleSpuAppTotal").toString(),spuMap.get("saleSpuWebChatTotal").toString(),spuMap.get("saleSpuMicroTotal").toString(),spuMap.get("saleSpuMTotal").toString(),
						spuMap.get("saleSkuTotal").toString(),spuMap.get("saleSkuAppTotal").toString(),spuMap.get("saleSkuWebChatTotal").toString(),spuMap.get("saleSkuMicroTotal").toString(),spuMap.get("saleSkuMTotal").toString(),
						totalMap.get("saleProductTotal").toString(),totalMap.get("saleProductAppTotal").toString(),totalMap.get("saleProductWebChatTotal").toString(),totalMap.get("saleProductMicroTotal").toString(),totalMap.get("saleProductMTotal").toString(), 
						totalMap.get("saleMainOrderTotal").toString(),totalMap.get("saleMainOrderAppTotal").toString(),totalMap.get("saleMainOrderWebChatTotal").toString(),totalMap.get("saleMainOrderMicroTotal").toString(),totalMap.get("saleMainOrderMTotal").toString(), 
						totalMap.get("saleSubOrderTotal").toString(),totalMap.get("saleSubOrderAppTotal").toString(),totalMap.get("saleSubOrderWebChatTotal").toString(),totalMap.get("saleSubOrderMicroTotal").toString(),totalMap.get("saleSubOrderMTotal").toString(), 
						totalMap.get("saleCashTotalSub").toString(),totalMap.get("saleCashTotalAppSub").toString(),totalMap.get("saleCashTotalWebChatSub").toString(),totalMap.get("saleCashTotalMicroSub").toString(),totalMap.get("saleCashTotalMSub").toString(), 
						totalMap.get("actualPayPointTotal").toString(),totalMap.get("actualPayPointAppTotal").toString(),totalMap.get("actualPayPointWebChatTotal").toString(),totalMap.get("actualPayPointMicroTotal").toString(),totalMap.get("actualPayPointMTotal").toString(), 
						totalMap.get("specialCashTotal").toString(),totalMap.get("specialCashAppTotal").toString(),totalMap.get("specialCashWebChatTotal").toString(),totalMap.get("specialCashMicroTotal").toString(),totalMap.get("specialCashMTotal").toString(), 
						userTotalMap.get("travelUserCount").toString(),userTotalMap.get("travelUserCountAPP").toString(),userTotalMap.get("travelUserCountMicroMall").toString(),userTotalMap.get("travelUserCountMicro").toString(),userTotalMap.get("travelUserCountM").toString(), 
						userRepeatMap.get("travelRepeUserCount").toString(),userRepeatMap.get("travelRepeUserCountAPP").toString(),userRepeatMap.get("travelRepeUserCountMicroMall").toString(),userRepeatMap.get("travelRepeUserCountMicro").toString(),userRepeatMap.get("travelRepeUserCountM").toString(), 
						userAddMap.get("USERTOTAL").toString(), 
						activityUserCount.get("activityTotals").toString(),activityUserCount.get("activityMicroMallTotal").toString(),activityUserCount.get("activityMTotal").toString(),
						title, sheetName, fileName);
			}
		}
	}
	
	
	/**
	 * 丝绸之路 丝路情深
	 * @param response
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @param activityName 
	 */
	public void exportSilk(HttpServletResponse response,String startTime, String endTime, String data, String activityId, String activityName) {
		String spuCount = "";
		String skuCount = "";
		String spuAPP = "";
		String skuAPP = "";
		String spuMicroMall = "";
		String skuMicroMall = "";
		String spuMicro = "";
		String skuMicro = "";
		Map<String, Object> silkSPUSKUData = silkActivityService.silkSPUSKUData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkSPUSKUData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkSPUSKUData")) {
				spuCount = value.get("PRODUCTID").toString();
				skuCount = value.get("PRODUCTDETAILID").toString();
			}else if(key.equals("silkSPUSKUDataAPP")) {
				spuAPP = value.get("PRODUCTID").toString();
				skuAPP = value.get("PRODUCTDETAILID").toString();
			}else if(key.equals("silkSPUSKUDataMicroMall")) {
				spuMicroMall = value.get("PRODUCTID").toString();
				skuMicroMall = value.get("PRODUCTDETAILID").toString();
			}else if(key.equals("silkSPUSKUDataMicro")) {
				spuMicro = value.get("PRODUCTID").toString();
				skuMicro = value.get("PRODUCTDETAILID").toString();
			}
		}
		String orderMainCounts = "";
		String ordercounts = "";
		String userCounts = "";
		String orderMainApp = "";
		String orderApp = "";
		String userCountAPP = "";
		String orderMainMicroMall = "";
		String orderMicroMall = "";
		String userCountMicroMall = "";
		String orderMainMicro = "";
		String orderMicro = "";
		String userCountMicro = "";
		Map<String, Object> silkOrderData = silkActivityService.silkOrderData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkOrderData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkOrderData")) {
				orderMainCounts = value.get("ORDERNOMAIN").toString();
				ordercounts = value.get("ORDERNO").toString();
				userCounts = value.get("USERID").toString();
			}else if(key.equals("silkOrderDataAPP")) {
				orderMainApp = value.get("ORDERNOMAIN").toString();
				orderApp = value.get("ORDERNO").toString();
				userCountAPP = value.get("USERID").toString();
			}else if(key.equals("silkOrderDataMicroMall")) {
				orderMainMicroMall = value.get("ORDERNOMAIN").toString();
				orderMicroMall = value.get("ORDERNO").toString();
				userCountMicroMall = value.get("USERID").toString();
			}else if(key.equals("silkOrderDataMicro")) {
				orderMainMicro = value.get("ORDERNOMAIN").toString();
				orderMicro = value.get("ORDERNO").toString();
				userCountMicro = value.get("USERID").toString();
			}
		}
		String cashCounts = "";
		String scoreCounts = "";
		String giftScoreCounts = "";
		String productDetailCount = "";
		String cashCountAPP = "";
		String scoreCountAPP = "";
		String giftScoreCountAPP = "";
		String productDetailAPP = "";
		String cashCountMicroMall = "";
		String scoreCountMicroMall = "";
		String giftScoreCountMicroMall = "";
		String productDetailMicroMall = "";
		String cashCountMicro = "";
		String scoreCountMicro = "";
		String giftScoreCountMicro = "";
		String productDetailMicro = "";
		Map<String, Object> silkPayData = silkActivityService.silkPayData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkPayData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkPayData")) {
				cashCounts = value.get("PAYCASH").toString();
				scoreCounts = value.get("PAYPOINTS").toString();
				giftScoreCounts = value.get("SPECIALPOINTS").toString();
				productDetailCount = value.get("BUYNUM").toString();
			}else if(key.equals("silkPayDataAPP")) {
				cashCountAPP = value.get("PAYCASH").toString();
				scoreCountAPP = value.get("PAYPOINTS").toString();
				giftScoreCountAPP = value.get("SPECIALPOINTS").toString();
				productDetailAPP = value.get("BUYNUM").toString();
			}else if(key.equals("silkPayDataMicroMall")) {
				cashCountMicroMall = value.get("PAYCASH").toString();
				scoreCountMicroMall = value.get("PAYPOINTS").toString();
				giftScoreCountMicroMall = value.get("SPECIALPOINTS").toString();
				productDetailMicroMall = value.get("BUYNUM").toString();
			}else if(key.equals("silkPayDataMicro")) {
				cashCountMicro = value.get("PAYCASH").toString();
				scoreCountMicro = value.get("PAYPOINTS").toString();
				giftScoreCountMicro = value.get("SPECIALPOINTS").toString();
				productDetailMicro = value.get("BUYNUM").toString();
			}
		}
		String repeatUserCounts = "";
		String repeatUserCountAPP = "";
		String repeatUserCountMicroMall = "";
		String repeatUserCountMicro = "";
		Map<String, Object> silkRepeData = silkActivityService.silkRepeData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkRepeData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkRepeData")) {
				repeatUserCounts = value.get("USERNUM").toString();
			}else if(key.equals("silkRepeDataAPP")) {
				repeatUserCountAPP = value.get("USERNUM").toString();
			}else if(key.equals("silkRepeDataMicroMall")) {
				repeatUserCountMicroMall = value.get("USERNUM").toString();
			}else if(key.equals("silkRepeDataMicro")) {
				repeatUserCountMicro = value.get("USERNUM").toString();
			}
		}
		String newUserCounts = "";
		Map<String, Object> silkNewUserData = silkActivityService.silkNewUserData(startTime,endTime,data,activityId);
		newUserCounts = silkNewUserData.get("TUIID").toString();
		String date = "";
		if(data.equals("1")) {
			date = "";
		}else if(data.equals("2")){
			date = "六折数据";
		}else if(data.equals("3")){
			date = "五折数据";
		}
		String[] title = new String[]{"万事利丝绸活动-丝路情深 "+date}; 
		String[] sheetName = new String[]{"万事利丝绸活动-丝路情深 "+date};
		String fileName = "万事利丝绸活动-丝路情深 "+date;
		
		generateExcel(response, spuCount, spuAPP, spuMicroMall, spuMicro, 
				skuCount, skuAPP, skuMicroMall, skuMicro, 
				productDetailCount, productDetailAPP, productDetailMicroMall, productDetailMicro, 
				orderMainCounts, orderMainApp, orderMainMicroMall, orderMainMicro, 
				ordercounts, orderApp, orderMicroMall, orderMicro, 
				cashCounts, cashCountAPP, cashCountMicroMall, cashCountMicro, 
				scoreCounts, scoreCountAPP, scoreCountMicroMall, scoreCountMicro, 
				giftScoreCounts, giftScoreCountAPP, giftScoreCountMicroMall, giftScoreCountMicro, 
				userCounts, userCountAPP, userCountMicroMall, userCountMicro, 
				repeatUserCounts, repeatUserCountAPP, repeatUserCountMicroMall, repeatUserCountMicro, 
				newUserCounts, title, sheetName, fileName);
	}

	/**
	 * 丝绸之路 杭州三绝
	 * @param response
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @param activityName 
	 */
	public void exportSilkHangZhou(HttpServletResponse response, String startTime, String endTime, String data, String activityId, String activityName) {
		String spuCount = "";
		String skuCount = "";
		String spuAPP = "";
		String skuAPP = "";
		String spuMicroMall = "";
		String skuMicroMall = "";
		String spuMicro = "";
		String skuMicro = "";
		String spuM = "";
		String skuM = "";
		try {
			activityName = URLDecoder.decode(activityName,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> silkSPUSKUData = silkActivityService.silksSPUSKUData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkSPUSKUData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkSPUSKUData")) {
				spuCount = value.get("PRODUCTID").toString();
				skuCount = value.get("PRODUCTDETAILID").toString();
			}else if(key.equals("silkSPUSKUDataAPP")) {
				spuAPP = value.get("PRODUCTID").toString();
				skuAPP = value.get("PRODUCTDETAILID").toString();
			}else if(key.equals("silkSPUSKUDataMicroMall")) {
				spuMicroMall = value.get("PRODUCTID").toString();
				skuMicroMall = value.get("PRODUCTDETAILID").toString();
			}else if(key.equals("silkSPUSKUDataMicro")) {
				spuMicro = value.get("PRODUCTID").toString();
				skuMicro = value.get("PRODUCTDETAILID").toString();
			}
			if(startTime.compareTo("2017-07-01 00:00:00") > 0) {
				if(key.equals("silkSPUSKUDataM")) {
					spuM = value.get("PRODUCTID").toString();
					skuM = value.get("PRODUCTDETAILID").toString();
				}
			}
		}
		String orderMainCounts = "";
		String ordercounts = "";
		String userCounts = "";
		String orderMainApp = "";
		String orderApp = "";
		String userCountAPP = "";
		String orderMainMicroMall = "";
		String orderMicroMall = "";
		String userCountMicroMall = "";
		String orderMainMicro = "";
		String orderMicro = "";
		String userCountMicro = "";
		String orderMainM = "";
		String orderM = "";
		String userCountM = "";
		Map<String, Object> silkOrderData = silkActivityService.silksOrderData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkOrderData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkOrderData")) {
				orderMainCounts = value.get("ORDERNOMAIN").toString();
				ordercounts = value.get("ORDERNO").toString();
				userCounts = value.get("USERID").toString();
			}else if(key.equals("silkOrderDataAPP")) {
				orderMainApp = value.get("ORDERNOMAIN").toString();
				orderApp = value.get("ORDERNO").toString();
				userCountAPP = value.get("USERID").toString();
			}else if(key.equals("silkOrderDataMicroMall")) {
				orderMainMicroMall = value.get("ORDERNOMAIN").toString();
				orderMicroMall = value.get("ORDERNO").toString();
				userCountMicroMall = value.get("USERID").toString();
			}else if(key.equals("silkOrderDataMicro")) {
				orderMainMicro = value.get("ORDERNOMAIN").toString();
				orderMicro = value.get("ORDERNO").toString();
				userCountMicro = value.get("USERID").toString();
			}
			if(startTime.compareTo("2017-07-01 00:00:00") > 0) {
				if(key.equals("siklOrderDataM")) {
					orderMainM = value.get("ORDERNOMAIN").toString();
					orderM = value.get("ORDERNO").toString();
					userCountM = value.get("USERID").toString();
				}
			}
		}
		String cashCounts = "";
		String scoreCounts = "";
		String giftScoreCounts = "";
		String productDetailCount = "";
		String cashCountAPP = "";
		String scoreCountAPP = "";
		String giftScoreCountAPP = "";
		String productDetailAPP = "";
		String cashCountMicroMall = "";
		String scoreCountMicroMall = "";
		String giftScoreCountMicroMall = "";
		String productDetailMicroMall = "";
		String cashCountMicro = "";
		String scoreCountMicro = "";
		String giftScoreCountMicro = "";
		String productDetailMicro = "";
		String cashCountM = "";
		String scoreCountM = "";
		String giftScoreCountM = "";
		String productDetailM = "";
		Map<String, Object> silkPayData = silkActivityService.silksPayData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkPayData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkPayData")) {
				cashCounts = value.get("PAYCASH").toString();
				scoreCounts = value.get("PAYPOINTS").toString();
				giftScoreCounts = value.get("SPECIALPOINTS").toString();
				productDetailCount = value.get("BUYNUM").toString();
			}else if(key.equals("silkPayDataAPP")) {
				cashCountAPP = value.get("PAYCASH").toString();
				scoreCountAPP = value.get("PAYPOINTS").toString();
				giftScoreCountAPP = value.get("SPECIALPOINTS").toString();
				productDetailAPP = value.get("BUYNUM").toString();
			}else if(key.equals("silkPayDataMicroMall")) {
				cashCountMicroMall = value.get("PAYCASH").toString();
				scoreCountMicroMall = value.get("PAYPOINTS").toString();
				giftScoreCountMicroMall = value.get("SPECIALPOINTS").toString();
				productDetailMicroMall = value.get("BUYNUM").toString();
			}else if(key.equals("silkPayDataMicro")) {
				cashCountMicro = value.get("PAYCASH").toString();
				scoreCountMicro = value.get("PAYPOINTS").toString();
				giftScoreCountMicro = value.get("SPECIALPOINTS").toString();
				productDetailMicro = value.get("BUYNUM").toString();
			}
			if(startTime.compareTo("2017-07-01 00:00:00") > 0) {
				if(key.equals("silkPayDataM")) {
					cashCountM = value.get("PAYCASH").toString();
					scoreCountM = value.get("PAYPOINTS").toString();
					giftScoreCountM = value.get("SPECIALPOINTS").toString();
					productDetailM = value.get("BUYNUM").toString();
				}
			}
		}
		String repeatUserCounts = "";
		String repeatUserCountAPP = "";
		String repeatUserCountMicroMall = "";
		String repeatUserCountMicro = "";
		String repeatUserCountM = "";
		Map<String, Object> silkRepeData = silkActivityService.silksRepeData(startTime,endTime,data,activityId);
		for(Map.Entry<String, Object> entry: silkRepeData.entrySet()) { 
			String key = entry.getKey();
			Map<String,Object> value = (Map<String, Object>) entry.getValue();
			if(key.equals("silkRepeData")) {
				repeatUserCounts = value.get("USERNUM").toString();
			}else if(key.equals("silkRepeDataAPP")) {
				repeatUserCountAPP = value.get("USERNUM").toString();
			}else if(key.equals("silkRepeDataMicroMall")) {
				repeatUserCountMicroMall = value.get("USERNUM").toString();
			}else if(key.equals("silkRepeDataMicro")) {
				repeatUserCountMicro = value.get("USERNUM").toString();
			}
			if(startTime.compareTo("2017-07-01 00:00:00") > 0) {
				if(key.equals("silkRepeDataM")) {
					repeatUserCountM = value.get("USERNUM").toString();
				}
			}
		}
		String newUserCounts = "";
		Map<String, Object> silkNewUserData = silkActivityService.silkNewUserData(startTime,endTime,data,activityId);
		newUserCounts = silkNewUserData.get("TUIID").toString();
		
		String[] title = null;
		String[] sheetName = null;
		String fileName = null;
		title = new String[]{activityName}; 
		sheetName = new String[]{activityName};
		fileName = activityName;
		if(startTime.compareTo("2017-07-01 00:00:00") < 0) {
			generateExcel(response, spuCount, spuAPP, spuMicroMall, spuMicro, 
					skuCount, skuAPP, skuMicroMall, skuMicro, 
					productDetailCount, productDetailAPP, productDetailMicroMall, productDetailMicro, 
					orderMainCounts, orderMainApp, orderMainMicroMall, orderMainMicro, 
					ordercounts, orderApp, orderMicroMall, orderMicro, 
					cashCounts, cashCountAPP, cashCountMicroMall, cashCountMicro, 
					scoreCounts, scoreCountAPP, scoreCountMicroMall, scoreCountMicro, 
					giftScoreCounts, giftScoreCountAPP, giftScoreCountMicroMall, giftScoreCountMicro, 
					userCounts, userCountAPP, userCountMicroMall, userCountMicro, 
					repeatUserCounts, repeatUserCountAPP, repeatUserCountMicroMall, repeatUserCountMicro, 
					newUserCounts, title, sheetName, fileName);
		}else if(startTime.compareTo("2017-07-01 00:00:00") > 0 && startTime.compareTo("2017-07-23 00:00:00") < 0){
			generateExcelN(response, spuCount, spuAPP, spuMicroMall, spuMicro, spuM,
					skuCount, skuAPP, skuMicroMall, skuMicro, skuM,
					productDetailCount, productDetailAPP, productDetailMicroMall, productDetailMicro, productDetailM,
					orderMainCounts, orderMainApp, orderMainMicroMall, orderMainMicro, orderMainM, 
					ordercounts, orderApp, orderMicroMall, orderMicro, orderM, 
					cashCounts, cashCountAPP, cashCountMicroMall, cashCountMicro, cashCountM, 
					scoreCounts, scoreCountAPP, scoreCountMicroMall, scoreCountMicro, scoreCountM, 
					giftScoreCounts, giftScoreCountAPP, giftScoreCountMicroMall, giftScoreCountMicro, giftScoreCountM, 
					userCounts, userCountAPP, userCountMicroMall, userCountMicro, userCountM, 
					repeatUserCounts, repeatUserCountAPP, repeatUserCountMicroMall, repeatUserCountMicro, repeatUserCountM, 
					newUserCounts, title, sheetName, fileName);
		}else{
			generateExcelN2(response, spuCount, spuAPP, spuMicroMall, spuMicro, spuM,
					skuCount, skuAPP, skuMicroMall, skuMicro, skuM,
					productDetailCount, productDetailAPP, productDetailMicroMall, productDetailMicro, productDetailM,
					orderMainCounts, orderMainApp, orderMainMicroMall, orderMainMicro, orderMainM, 
					ordercounts, orderApp, orderMicroMall, orderMicro, orderM, 
					cashCounts, cashCountAPP, cashCountMicroMall, cashCountMicro, cashCountM, 
					scoreCounts, scoreCountAPP, scoreCountMicroMall, scoreCountMicro, scoreCountM, 
					giftScoreCounts, giftScoreCountAPP, giftScoreCountMicroMall, giftScoreCountMicro, giftScoreCountM, 
					userCounts, userCountAPP, userCountMicroMall, userCountMicro, userCountM, 
					repeatUserCounts, repeatUserCountAPP, repeatUserCountMicroMall, repeatUserCountMicro, repeatUserCountM, 
					newUserCounts, title, sheetName, fileName);
		}
	}
	/**
	 * 港奥台活动
	 * @param response
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @param activityName 
	 */
	public void exportHkMacao(HttpServletResponse response, String startTime, String endTime, String activityId, String activityName) {
		Map<String, Double> hkMacaoData = hKMacalService.getHKMacaoData(startTime, endTime, activityId);
		String[] rowsName = new String[]{"销售数据","销售额","活动销售SPU种类总数","活动销售SKU种类总数","活动商品总销量","现金满额销售额","现金满额销售SPU种类总数","现金满额销售SKU种类总数","现金满额总销量","活动订单总数","活动子订单总数","现金满额订单总数","现金满额子订单总数"};
		List<List<Object[]>>  dataList = new ArrayList<List<Object[]>>();
		List<Object[]> dataList1 = new ArrayList<Object[]>();
		Object[] obj = new Object[]{"总数据",hkMacaoData.get("saleTotal"),hkMacaoData.get("saleSpuTotal"),hkMacaoData.get("saleSkuTotal"),hkMacaoData.get("productTotal"),hkMacaoData.get("saleCashTotal"),hkMacaoData.get("saleSpuCashTotal"),hkMacaoData.get("saleSkuCashTotal"),hkMacaoData.get("saleCashTotalSub"),hkMacaoData.get("orderMainTotal"),hkMacaoData.get("orderSubTotal"),hkMacaoData.get("orderMainCashTotal"),hkMacaoData.get("orderSubCashTotal")};
		Object[] obj1 = new Object[]{"APP",hkMacaoData.get("saleAppTotal"),hkMacaoData.get("saleSpuAppTotal"),hkMacaoData.get("saleSkuAppTotal"),hkMacaoData.get("productAppTotal"),hkMacaoData.get("saleCashAppTotal"),hkMacaoData.get("saleSpuCashAppTotal"),hkMacaoData.get("saleSkuCashAppTotal"),hkMacaoData.get("saleCashTotalAppSub"),hkMacaoData.get("orderMainAppTotal"),hkMacaoData.get("orderSubAppTotal"),hkMacaoData.get("orderMainCashAppTotal"),hkMacaoData.get("orderSubCashAppTotal")};
		Object[] obj2 = new Object[]{"微网站",hkMacaoData.get("saleWebChatTotal"),hkMacaoData.get("saleSpuWebChatTotal"),hkMacaoData.get("saleSkuWebChatTotal"),hkMacaoData.get("productWebChatTotal"),hkMacaoData.get("saleCashWebChatTotal"),hkMacaoData.get("saleSpuCashWebChatTotal"),hkMacaoData.get("saleSkuCashWebChatTotal"),hkMacaoData.get("saleCashTotalWebChatSub"),hkMacaoData.get("orderMainWebChatTotal"),hkMacaoData.get("orderSubWebChatTotal"),hkMacaoData.get("orderMainCashWebChatTotal"),hkMacaoData.get("orderSubCashWebChatTotal")};
		Object[] obj3 = new Object[]{"微匠",hkMacaoData.get("saleMicroTotal"),hkMacaoData.get("saleSpuMicroTotal"),hkMacaoData.get("saleSkuMicroTotal"),hkMacaoData.get("productMicroTotal"),hkMacaoData.get("saleCashMicroTotal"),hkMacaoData.get("saleSpuCashMicroTotal"),hkMacaoData.get("saleSkuCashMicroTotal"),hkMacaoData.get("saleCashTotalMicroSub"),hkMacaoData.get("orderMainMicroTotal"),hkMacaoData.get("orderSubMicroTotal"),hkMacaoData.get("orderMainCashMicroTotal"),hkMacaoData.get("orderSubCashMircoTotal")};
		Object[] obj4 = new Object[]{" "," "," "," "," "," "," "," "," "};
		Object[] obj5 = new Object[]{"支付数据","现金支付总金额","现金满额现金支付总金额","实际支付总积分","现金满额实际支付总积分","福利券支付总积分","现金满额福利券支付总积分","客单价","现金满额客单价"};
		Object[] obj6 = new Object[]{"总数据",hkMacaoData.get("payTotal"),hkMacaoData.get("buyCardPayTotal"),hkMacaoData.get("actualPayTotalPoint"),hkMacaoData.get("buyCardPayTotalPoint"),hkMacaoData.get("specialPointTotal"),hkMacaoData.get("buyCardSpecialTotal"),hkMacaoData.get("custSingleTotal"),hkMacaoData.get("cashSingle")};
		Object[] obj7 = new Object[]{"APP",hkMacaoData.get("payTotalApp"),hkMacaoData.get("buyCardPayTotalApp"),hkMacaoData.get("actualPayTotalPointApp"),hkMacaoData.get("buyCardPayTotalPointApp"),hkMacaoData.get("specialPointAppTotal"),hkMacaoData.get("buyCardSpecialAppTotal"),hkMacaoData.get("custSingleAppTotal"),hkMacaoData.get("cashSingleApp")};
		Object[] obj8 = new Object[]{"微网站",hkMacaoData.get("payTotalWebChat"),hkMacaoData.get("buyCardPayTotalWebChat"),hkMacaoData.get("actualPayTotalPointWebChat"),hkMacaoData.get("buyCardPayTotalPointWebChat"),hkMacaoData.get("specialPointWebChatTotal"),hkMacaoData.get("buyCardSpecialWebChatTotal"),hkMacaoData.get("custSingleWebChatTotal"),hkMacaoData.get("cashSingleWebChat")};
		Object[] obj9 = new Object[]{"微匠",hkMacaoData.get("payTotalMicro"),hkMacaoData.get("buyCardPayTotalMicro"),hkMacaoData.get("actualPayTotalPointMicro"),hkMacaoData.get("buyCardPayTotalPointMicro"),hkMacaoData.get("specialPointMicroTotal"),hkMacaoData.get("buyCardSpecialMicroTotal"),hkMacaoData.get("custSingleMicroTotal"),hkMacaoData.get("cashSingleMicro")};
		Object[] obj10 = new Object[]{" "," "," "," "};
		Object[] obj11 = new Object[]{"参与数据","活动参与总人数","重复参与人数","新增会员数"};
		Object[] obj12 = new Object[]{"总数据",hkMacaoData.get("travelUserCount"),hkMacaoData.get("travelRepeUserCount"),hkMacaoData.get("travelNewUserCount")};
		Object[] obj13 = new Object[]{"APP",hkMacaoData.get("travelUserCountAPP"),hkMacaoData.get("travelRepeUserCountAPP"),"--"};
		Object[] obj14 = new Object[]{"微网站",hkMacaoData.get("travelUserCountMicroMall"),hkMacaoData.get("travelRepeUserCountMicroMall"),"--"};
		Object[] obj15 = new Object[]{"微匠",hkMacaoData.get("travelUserCountMicro"),hkMacaoData.get("travelRepeUserCountMicro"),"--"};
		dataList1.add(obj);
		dataList1.add(obj1);
		dataList1.add(obj2);
		dataList1.add(obj3);
		dataList1.add(obj4);
		dataList1.add(obj5);
		dataList1.add(obj6);
		dataList1.add(obj7);
		dataList1.add(obj8);
		dataList1.add(obj9);
		dataList1.add(obj10);
		dataList1.add(obj11);
		dataList1.add(obj12);
		dataList1.add(obj13);
		dataList1.add(obj14);
		dataList1.add(obj15);
		dataList.add(dataList1);
		String[] title = new String[]{"港澳游活动"}; 
		String[] sheetName = new String[]{"港澳游活动"};
		ExportExcelUtil ex = new ExportExcelUtil(response,title, rowsName, dataList,sheetName, "港澳游活动","0"); 
		ex.export();
	}

}
