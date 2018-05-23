package com.zhb.dataAnalysis.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.zhb.dataAnalysis.marketing.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhb.dataAnalysis.common.repository.database.model.ActivityModel;

@Controller
@RequestMapping("/marketing")
public class MarketingController {
	
	@Resource(name="hKMacalService")
	private HKMacaoService hKMacalService;
	
	@Resource(name="silkActivityService")
	private SilkActivityService silkActivityService;
	
	@Resource(name="exportUtilService")
	private ExportUtilService exportUtilService;
	
	@Resource(name="activityTemplateService")
	private IActivityTemplateService activityTemplateService;
	
	@Resource(name="wuChangRiceService")
	private IWuChangRiceService wuChangRiceService;

	@Resource(name = "oldInvitationUserActivityService")
	private OldInvitationUserActivityService oldInvitationUserActivityService;

	@RequestMapping("getActivity")
	@ResponseBody
	public Map<String,Object> getActivity(int rows,int page) {
		return hKMacalService.getActivity(rows,page);
	}
	
	@RequestMapping("toSilkRoad")
	public ModelAndView toSilkRoad(String activityId,String current){
		ModelAndView mav = new ModelAndView("aiPinXuan/center/marketing/silkRoad");
		ActivityModel activity = hKMacalService.getActivityInfo(activityId);
		mav.addObject("activity", activity);		
		mav.addObject("current", current);
		return mav;
	}

	/**
	 * 丝绸   活动销售SPU数  活动销售SKU总数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silkSPUSKUData")
	@ResponseBody
	public Map<String,Object> silkSPUSKUData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silkSPUSKUData(startTime,endTime,data,activityId);
	}
	
	/**
	 * 丝绸   活动主订单总数  活动子订单总数   活动参与总人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silkOrderData")
	@ResponseBody
	public Map<String,Object> silkOrderData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silkOrderData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 丝绸   现金支付总金额   实际支付总积分  福利券支付总积分   活动商品总销量
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silkPayData")
	@ResponseBody
	public Map<String,Object> silkPayData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silkPayData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 丝绸   重复参与人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silkRepeData")
	@ResponseBody
	public Map<String,Object> silkRepeData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silkRepeData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 丝绸   新增会员数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silkNewUserData")
	@ResponseBody
	public Map<String,Object> silkNewUserData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silkNewUserData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 丝绸   杭州三绝  活动销售SPU数  活动销售SKU总数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silksSPUSKUData")
	@ResponseBody
	public Map<String,Object> silksSPUSKUData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silksSPUSKUData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 丝绸   杭州三绝  活动主订单总数  活动子订单总数   活动参与总人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silksOrderData")
	@ResponseBody
	public Map<String,Object> silksOrderData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silksOrderData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 丝绸  杭州三绝   现金支付总金额   实际支付总积分  福利券支付总积分   活动商品总销量
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silksPayData")
	@ResponseBody
	public Map<String,Object> silksPayData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silksPayData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 丝绸  杭州三绝   重复参与人数
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@RequestMapping("silksRepeData")
	@ResponseBody
	public Map<String,Object> silksRepeData(String startTime,String endTime,String data,String activityId) {
		return silkActivityService.silksRepeData(startTime, endTime, data, activityId);
	}
	
	/**
	 * 数据导出
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("exportExcel")
	public void exportExcel(HttpServletResponse reponse,String startTime,String endTime,String data,String activityId,String sign,String activityName) {
		exportUtilService.exportExcel(reponse,startTime, endTime, data, activityId,sign,activityName);
	}
	
	@ResponseBody
	@RequestMapping("getHKMacaoData")
	public Map<String,Double> getHKMacaoData(String startTime,String endTime,String activityId){
		return hKMacalService.getHKMacaoData(startTime, endTime, activityId);
	}
	
	@ResponseBody
	@RequestMapping(value="getActivitySpuSku",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> getActivitySpuSku(String startTime,String endTime,String data,String activityId){
		Map<String,BigDecimal> map = new HashMap<String,BigDecimal>();
		map = activityTemplateService.getActivitySPU(startTime, endTime, data, activityId);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="getActivityTotal",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> getActivityTotal(String startTime,String endTime,String data,String activityId){
		Map<String,BigDecimal> map = new HashMap<String,BigDecimal>();
		map = activityTemplateService.getActivityTotal(startTime, endTime, data, activityId);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="getActivityUserTotal",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> getActivityUserTotal(String startTime,String endTime,String data,String activityId){
		Map<String,BigDecimal> map = new HashMap<String,BigDecimal>();
		map = activityTemplateService.getActivityUserTotal(startTime, endTime, data, activityId);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="getActivityUserRepeat",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> getActivityUserRepeat(String startTime,String endTime,String data,String activityId){
		Map<String,BigDecimal> map = new HashMap<String,BigDecimal>();
		map = activityTemplateService.getActivityUserRepeat(startTime, endTime, data, activityId);
		return map;
	}

	@ResponseBody
	@RequestMapping(value="getActivityUserAdd",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> getActivityUserAdd(String startTime,String endTime,String activityId){
		Map<String,BigDecimal> map = new HashMap<String,BigDecimal>();
		map = activityTemplateService.getActivityUserAdd(startTime, endTime);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="getWuChangRiceData",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, BigDecimal> getWuChangRiceData(String startTime,String endTime,String data,String activityId) {
		return wuChangRiceService.getWuChangRiceData(startTime, endTime, data, activityId);
	}
	@ResponseBody
	@RequestMapping(value="getChannel",method={RequestMethod.GET,RequestMethod.POST})
	public List<Map<String, String>> getChannel(String startTime,String endTime,String data,String activityId) {
		return wuChangRiceService.getChannel(startTime, endTime, data, activityId);
	}
	
	@ResponseBody
	@RequestMapping(value="getRedeemCode",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, BigDecimal> getRedeemCode(String startTime,String endTime,String data,String activityId) {
		return wuChangRiceService.getRedeemCode(startTime, endTime, data, activityId);
	}
	
	/**
	 * 老用户邀请新用户的优惠券
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getCouponUser",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, BigDecimal> getCouponUser() {
		return wuChangRiceService.getCouponUser();
	}
	
	@RequestMapping("toActivityViewUtil")
	public ModelAndView toActivityViewUtil(String activityId,String current){
		ModelAndView mav = new ModelAndView("aiPinXuan/center/marketing/activityTemplate");
		if(activityId.equals("ZHB20170402001-2")) {//杭州三绝
			String[] a = activityId.split("-");
			activityId = a[0];
		}
		ActivityModel activity = hKMacalService.getActivityInfo(activityId);
		mav.addObject("activity", activity);
		mav.addObject("current",current);
		
		if(activity.getStartTime().compareTo("2017-07-01 00:00:00") < 0) {
			if(activityId.equals("ZHB20170411001")) {//港澳游
				mav.addObject("temp","travel_HKMacao");
			}else if(activityId.equals("ZHB20170524001")) {//五常大米
				mav.addObject("temp", "wuChangRice");
				mav.addObject("data","2");
			}else{
				if(activityId.equals("ZHB20170419001")) {
					mav.addObject("mm","0");
				}
				if(activityId.equals("ZHB20170502001")) {//母婴活动
					mav.addObject("data","1");
					List<String> list = new ArrayList<String>();
					list.add("总数据");
					list.add("4.5折数据");
					list.add("普通数据");
					mav.addObject("list", list);
					mav.addObject("mm","0");
				}
				if(activityId.equals("ZHB20170503001")) {//端午节福利活动
					mav.addObject("data","1");
					List<String> list = new ArrayList<String>();
					list.add("总数据");
					list.add("超值礼包");
					list.add("大牌美粽");
					list.add("专场爆款");
					mav.addObject("list",list);
					mav.addObject("mm","0");
				}
				if(activityId.equals("ZHB20170523001")) {
					mav.addObject("data","1");
					List<String> list = new ArrayList<String>();
					list.add("总数据");
					list.add("满99");
					list.add("满199");
					list.add("满299");
					mav.addObject("list",list);
					mav.addObject("mm","0");
				}
				if(activityId.equals("ZHB20170523002")) {
					mav.addObject("data","3");
					List<String> list = new ArrayList<String>();
					list.add("满减");
					list.add("秒杀");
					mav.addObject("list",list);
					List<String> list1 = new ArrayList<String>();
					list1.add("满99减5元");
					list1.add("满199减15元");
					list1.add("满299减25元");
					mav.addObject("list1",list1);
					mav.addObject("mm","0");
				}
				if(activityId.equals("ZHB20170607001")) {
					mav.addObject("data","4");
					List<String> list = new ArrayList<String>();
					list.add("秒杀");
					list.add("直降");
					list.add("新品");
					list.add("折扣");
					mav.addObject("list2",list);
					mav.addObject("mm","0");
				}
				mav.addObject("temp", "activityTemplateView");
			}
		}else if(activity.getStartTime().compareTo("2017-07-01 00:00:00") > 0 && activity.getStartTime().compareTo("2017-07-23 00:00:00") < 0) {
			if(activityId.equals("ZHB20170620001")) {
				List<String> list = new ArrayList<String>();
				list.add("限时抢购");
				list.add("满减");
				list.add("直降");
				mav.addObject("list2",list);
				mav.addObject("mm","0");
			}else if(activityId.equals("ZHB20170703001")) {
				List<String> list = new ArrayList<String>();
				list.add("秒杀");
				list.add("直降");
				mav.addObject("list2",list);
				mav.addObject("mm","0");
			}
			mav.addObject("data","4");
			mav.addObject("temp", "activityTemplateViewN");
		}else if(activity.getStartTime().compareTo("2017-07-23 00:00:00") >= 0 && activity.getStartTime().compareTo("2017-08-02 00:00:00") < 0){
			if(activityId.equals("ZHB20170713001")) {
				List<String> list = new ArrayList<String>();
				list.add("限时秒杀");
				list.add("直降");
				list.add("团购");
				mav.addObject("list2",list);
				mav.addObject("mm","0");
			}
			mav.addObject("data","4");
			mav.addObject("temp", "activityTemplateViewN2");
		}else{
			if(activityId.equals("ZHB20170721001")) {
				List<String> list = new ArrayList<String>();
				list.add("限时秒杀");
				list.add("直降");
				mav.addObject("list2",list);
				mav.addObject("mm","0");
				mav.addObject("data","4");
				mav.addObject("temp", "schoolSeason");
			}else if(activityId.equals("ZHB20170909001") ) {
				mav.addObject("temp", "thousandYearsRice");
				mav.addObject("data","2");
			}else if(activityId.equals("ZHB20170001016")){
//				mav.addObject("temp", "NewActivityStatisticsPage");
				activity.setActivityName("老用户邀请新用户活动");
				mav.addObject("temp", "oldInvitationUserActivity");
			} else if (activityId.equals("ZHB20171123001")) {
				List<String> list = new ArrayList<String>();
				list.add("直降");
				mav.addObject("list2", list);
				mav.addObject("data","4");
				activity.setActivityName("双旦大促活动");
				mav.addObject("temp","activityChristmasAndNewYears");
			}
			else if(activityId.equals("ZHB20171212001")){
				List<String> list = new ArrayList<String>();
				list.add("直降");
				mav.addObject("list2", list);
				mav.addObject("data","4");
				activity.setActivityName("年货提前购");
				mav.addObject("temp","advanceConsumption");
			}else if(activityId.equals("ZHB20180212001")){
				List<String> list = new ArrayList<String>();
				list.add("直降");
				mav.addObject("list2", list);
				mav.addObject("data","4");
				activity.setActivityName("新春领红包活动");
				mav.addObject("temp","newSpringGetCollarRed");
			}else if(activityId.equals("ZHB20180306001")){
				List<String> list = new ArrayList<String>();
				list.add("直降");
				mav.addObject("list2", list);
				mav.addObject("data","4");
				activity.setActivityName("315小家电超级品牌春季盛典");
				mav.addObject("temp","315miniHouseEleAppliances");
			}else{
				if(activityId.equals("ZHB20170802001") || activityId.equals("ZHB20170828001") || activityId.equals("ZHB20170925001")) {
					List<String> list = new ArrayList<String>();
					list.add("限时抢购");
					list.add("直降");
					mav.addObject("list2",list);
				}else if(activityId.equals("ZHB20170815001")) {
					List<String> list = new ArrayList<String>();
					list.add("直降");
					list.add("团购");
					mav.addObject("list2",list);
				}else if(activityId.equals("ZHB20171017001")) {
					List<String> list = new ArrayList<String>();
					list.add("满减");
					mav.addObject("list2",list);
				} else {
					List<String> list = new ArrayList<String>();
					list.add("直降");
					mav.addObject("list2", list);
				}
				mav.addObject("mm", "0");
				mav.addObject("data","4");
				if(activity.getStartTime().compareTo("2017-08-02 00:00:00") >= 0 && activity.getStartTime().compareTo("2017-09-13 00:00:00") < 0) {
					mav.addObject("temp", "activityTemplateViewN3");
				}else {
					mav.addObject("temp", "activityTemplateView");
				}
			}
		}
		return mav;
	}
	
	@RequestMapping("toActivityData")
	public ModelAndView toActivityData(String current) {
		ModelAndView mav = new ModelAndView("aiPinXuan/center/marketing/activityData");
		mav.addObject("current", current);
		return mav;
	}
	
	/**
	 * 拉新会员数
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	@RequestMapping("getActivityUserCount")
	@ResponseBody
	public Map<String, BigDecimal> getActivityUserCount(String startTime, String endTime, String activityId) {
		return activityTemplateService.getActivityUserCount(startTime, endTime, activityId);
	}
	
	/**
	 * 大转盘参与人次 人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("getParticipationData")
	@ResponseBody
	public Map<String, BigDecimal> getParticipationData(String startTime, String endTime, String activityId){
		return activityTemplateService.getParticipationData(startTime, endTime, activityId);
	};
	
	/**
	 * 大转盘中奖人次 人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("getPrizeData")
	@ResponseBody
	public Map<String, BigDecimal> getPrizeData(String startTime, String endTime, String activityId) {
		return activityTemplateService.getPrizeData(startTime, endTime, activityId);
	}
	
	/**
	 * 大转盘分享人次
	 * @param startTime
	 * @param endTime
	 * @param activityId
	 * @return
	 */
	@RequestMapping("getEnjoyData")
	@ResponseBody
	public Map<String, BigDecimal> getEnjoyData(String startTime, String endTime, String activityId) {
		return activityTemplateService.getEnjoyData(startTime, endTime, activityId);
	}
	
	/**
	 * 大转盘消耗积分
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("getExpendIntegral")
	@ResponseBody
	public Map<String, BigDecimal> getExpendIntegral(String startTime, String endTime, String activityId){
		return activityTemplateService.getExpendIntegral(startTime, endTime, activityId);
	}
	
	/**
	 * 积分奖励值 人次 人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("getPrizeInterger")
	@ResponseBody
	public Map<String, BigDecimal> getPrizeInterger(String startTime, String endTime) {
		return activityTemplateService.getPrizeInterger(startTime, endTime);
	}

	/**
	 * V2
	 * 积分奖励值 人次 人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
//	@RequestMapping("getPrizeIntergerV2")
//	@ResponseBody
//	public Map<String, BigDecimal> getPrizeIntergerV2(String startTime, String endTime) {
//		return activityTemplateService.getPrizeIntergerV2(startTime, endTime);
//	}
	
	/**
	 * （谢谢） 人次 人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("getThanksCount")
	@ResponseBody
	public Map<String, BigDecimal> getThanksCount(String startTime, String endTime, String activityId) {
		return activityTemplateService.getThanksCount(startTime, endTime, activityId);
	}
	
	/**
	 * 非谢谢 非积分 奖励值 人次 人数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("getOtherCount")
	@ResponseBody
	public Map<String, BigDecimal> getOtherCount(String startTime, String endTime, String activityId) {
		return activityTemplateService.getOtherCount(startTime, endTime, activityId);
	}
	
	/**
	 * 优惠券
	 */
	@RequestMapping("getCoupon")
	@ResponseBody
	public Map<String, BigDecimal> getCoupon(String startTime, String endTime) {
		return activityTemplateService.getCoupon(startTime, endTime);
	}

	/**
	 * v2 双旦活动
	 * 优惠券
	 */
	@RequestMapping("getCouponV2")
	@ResponseBody
	public Map<String, BigDecimal> getCouponV2(String startTime, String endTime) {
		return activityTemplateService.getCouponV2(startTime, endTime);
	}


	/**
	 * 年货提前购活动
	 * 优惠券
	 */
	@RequestMapping("getCouponAdvance")
	@ResponseBody
	public Map<String, BigDecimal> getCouponAdvance(String startTime, String endTime) {
		return activityTemplateService.getCouponAdvance(startTime, endTime);
	}
	/**
	 * 中奖详情
	 */
	@RequestMapping("getPrizeCount")
	@ResponseBody
	public Map<String, BigDecimal> getPrizeCount(String startTime, String endTime, String activityId) {
		return activityTemplateService.getPrizeCount(startTime, endTime);
	}

	/**
	 * v2
	 * 中奖详情
	 */
	@RequestMapping("getPrizeCountV2")
	@ResponseBody
	public Map<String, BigDecimal> getPrizeCountV2(String startTime, String endTime, String activityId) {
		return activityTemplateService.getPrizeCountV2(startTime, endTime);
	}


	/**
	 * 老用户邀请新用户活动统计
	 * @param startTime
	 * @param endTime
	 * @param data
	 * @param activityId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getOldInvitationUserActivity",method={RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> getOldInvitationUserActivity(String startTime,String endTime,String activityId) {
		return oldInvitationUserActivityService.getOldInvitationUserActivity(startTime, endTime, activityId);
	}

	@ResponseBody
	@RequestMapping(value = "getLuckDrawCount",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String,Object> getLuckDrawCount(String startTime,String endTime,String activityId){
		return  activityTemplateService.getLuckDrawCount(startTime, endTime, activityId);
	}

	@ResponseBody
	@RequestMapping(value = "newSpringGetCollarRed",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> newSpringGetCollarRed(String startTime,String endTime,String activityId){
		return  activityTemplateService.newSpringGetCollarRed(startTime, endTime, activityId);
	}
	@ResponseBody
	@RequestMapping(value = "query315miniHouseEleAppliances",method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String,BigDecimal> query315miniHouseEleAppliances(String startTime,String endTime,String activityId){
		return  activityTemplateService.query315miniHouseEleAppliances(startTime, endTime, activityId);
	}

}
