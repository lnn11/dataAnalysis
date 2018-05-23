package com.zhb.dataAnalysis.marketing.service;

import com.zhb.dataAnalysis.common.repository.database.marketing.OldInvitationUserActivityDao;
import com.zhb.dataAnalysis.marketing.api.OldInvitationUserActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LLC on 2017/11/23.
 */
@Service("oldInvitationUserActivityService")
public class OldInvitationUserActivityServiceImpl implements OldInvitationUserActivityService {

    @Resource(name="oldInvitationUserActivityDao")
    private OldInvitationUserActivityDao oldInvitationUserActivityDao;

    /**
     * 老用户邀请新用户活动统计
     * @param startTime
     * @param endTime
     * @param data
     * @param activityId
     * @return
     */
    @Override
    public Map<String,Object> getOldInvitationUserActivity(String startTime, String endTime,  String activityId) {
        Map<String,Object> finalMap=new HashMap<>();
        DecimalFormat    df   = new DecimalFormat("0.00");
        //领券数
        finalMap.put("coupons",oldInvitationUserActivityDao.getHcoupns());
        //活动期间注册人数
        finalMap.put("registUsers", oldInvitationUserActivityDao.getRegistUsers(startTime, endTime, activityId));
        //购买数和实际支付金额
            Map<String,Object>  orderMap=oldInvitationUserActivityDao.getOrdersAndrealPay(startTime,endTime,activityId);
        finalMap.put("orderTotal",orderMap.get("ORDERNUM"));
        finalMap.put("realPay", df.format(orderMap.get("REALPAY")));
        //活动期间被邀请人数
        finalMap.put("inviteCodeNum",oldInvitationUserActivityDao.getInviteCodeNum(startTime, endTime));
        //发起邀请人数
        finalMap.put("disInviteCodeNum",oldInvitationUserActivityDao.getDisInviteCodeNum(startTime, endTime));
        //邀请人满减使用
        finalMap.put("fullcutNum",oldInvitationUserActivityDao.getFullcutNum(startTime, endTime));
        //使用满减券商品总价
        Map<String,Object> productmap=oldInvitationUserActivityDao.getProductTotal(startTime, endTime);
        finalMap.put("productTotal",df.format(productmap.get("PRODUCTPOINTS")));
        //商品总价-供货价
        BigDecimal profit=new BigDecimal(productmap.get("PRODUCTPOINTS").toString()).subtract(new BigDecimal(productmap.get("PURCHASEPRICE").toString()));
        finalMap.put("profit", df.format(profit));
        //被邀请首单人数和首单总金额
        Map<String,Object> firstOrderMap=oldInvitationUserActivityDao.getFristOrder(startTime,endTime);
        finalMap.put("firstOrderTotal",firstOrderMap.get("ORDERCOUNT"));
        BigDecimal cashDivTotal=new BigDecimal(0.00);
        if(Double.valueOf(firstOrderMap.get("CASH").toString())>0&& Double.valueOf(firstOrderMap.get("ORDERCOUNT").toString())>0){
            cashDivTotal= new BigDecimal(firstOrderMap.get("CASH").toString()).divide(new BigDecimal(firstOrderMap.get("ORDERCOUNT").toString()),2, BigDecimal.ROUND_HALF_UP);
        }
        finalMap.put("cashDivTotal",cashDivTotal);
        //新人专区sku数
        finalMap.put("userSku",oldInvitationUserActivityDao.getSku("user",startTime,endTime));
        //新人专区spu数
        finalMap.put("userSpu",oldInvitationUserActivityDao.getSpu("user",startTime,endTime));
       //新人专区销售额
        Double userPayPush=oldInvitationUserActivityDao.getPayCash("user", startTime, endTime);
        finalMap.put("userPayCash",df.format(userPayPush));
        //一元专区sku
        finalMap.put("oneSku", oldInvitationUserActivityDao.getSku("one",startTime,endTime));
        //一元spu
        finalMap.put("oneSpu",oldInvitationUserActivityDao.getSpu("one",startTime,endTime));
        //一元专区销售额
        finalMap.put("onePayCash",oldInvitationUserActivityDao.getPayCash("one", startTime, endTime));
        //一元专区销售件数
        Integer productNum=oldInvitationUserActivityDao.getOneProductNum(startTime,endTime);
        //获客成本
        BigDecimal   getUserCost=new BigDecimal(0.00);
        Integer inviteCodeNum=Integer.parseInt(finalMap.get("inviteCodeNum").toString());
        if(productNum>0&&inviteCodeNum>0){
            getUserCost= new BigDecimal(productNum).multiply(new BigDecimal(10)).divide(new BigDecimal(finalMap.get("inviteCodeNum").toString()),2, BigDecimal.ROUND_HALF_UP);
        }
        finalMap.put("getUserCost",getUserCost);
      //活动成本
        finalMap.put("activityCost",productNum*10);
            return finalMap;
    }

}
