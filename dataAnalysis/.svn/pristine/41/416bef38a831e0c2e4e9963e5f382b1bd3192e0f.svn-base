var data;
choice();
function choice() {
    if($("#dataCh").text()==1){
        data = $("[name='datas']:checked").val();
    }else if($("#dataCh").text()==3){
        data = $("[name='choice']").val();
        if(data == '满减') {
            data = $("[name='choice1']").val();
            if(data == "全部"){
                data = "满减";
            }
        }
    }else {
        data = $("[name='dataChoice']").val();
    }
}

function change() {
    data = $("[name='choice']").val();
    if(data == "满减") {
        $("#data3").show();
        data = $("[name='choice1']").val();
        if(data == "全部"){
            data = "满减";
        }
    }else{
        $("#data3").hide();
    }
}

function dataChange(){
    data = $("[name='dataChoice']").val();
    getActivityData(startTime,endTime,data,activityId);
}
getActivityData(startTime,endTime,data,activityId);

//查询
$("#btnQuery").click(function() {
    startTime = $("#startTime").val();
    endTime = $("#endTime").val();
    activityId = $("#activityId").html();
    choice();
    getActivityData(startTime,endTime,data,activityId);
});

//查询全部
$("#btnQueryAll").click(function(){
    $("#startTime").val($("#start").val());
    $("#endTime").val($("#end").val());
    startTime = $("#startTime").val();
    endTime = $("#endTime").val();
    activityId = $("#activityId").html();
    if($("#dataCh").text()==1) {
        $("[name='datas']").eq(0).attr("checked","checked");
        data = $("[name='datas']:checked").val();
    }else if($("#dataCh").text()==3){
        $("[name='choice'] option:first").prop("selected", 'selected');
        data = $("[name='choice']").val();
        $("#data3").hide();
    }else {
        $("[name='dataChoice'] option:first").prop("selected", 'selected');
        data = $("[name='dataChoice']").val();
    }
    getActivityData(startTime,endTime,data,activityId);
});
function showInfo(obj){
    var content="";
    if(obj.id=="saleSPUCount"){
        content="活动销售SPU种类总数 = 活动期间，活动商品销售的SPU种类总数";
    }else if(obj.id=="saleSKUCount"){
        content="活动销售SKU种类总数 = 活动期间，活动商品销售的SKU种类总数";
    }else if(obj.id=="salesOrderNoMainTotal"){
        content="活动主订单总数=活动期间，购买活动商品所产生的主订单总数";
    }else if(obj.id=="salesOrderNoTotal"){
        content="活动子订单总数=活动期间，购买活动商品所产生的子订单总数";
    }else if(obj.id=="saleCash"){
        content="现金支付总金额=活动期间，购买活动商品的现金支付总金额";
    }else if(obj.id=="salePoint"){
        content="实际支付总积分=活动期间，购买活动商品的实际支付总积分";
    }else if(obj.id=="saleSpecialPoint"){
        content="福利券支付总积分=活动期间，购买活动商品的福利券支付总积分";
    }else if(obj.id=="enjoyTotal"){
        content="活动参与人数=活动期间，购买活动商品的总人数(排重)";
    }else if(obj.id=="repeatTotal"){
        content="重复参与人数=活动期间，购买活动商品两次以上的人数(排重)";
    }else if(obj.id=="addTotal"){
        content="新增会员数=活动期间，爱品选平台新增会员数";
    }else if(obj.id=="productCount") {
        content="活动期间销售子商品总销量";
    }else if(obj.id=="activityTotal") {
        content="活动期间，在活动页面注册的会员数量";
    }else if(obj.id=="registerPageTotal") {
        content="活动期间，进入活动注册页面的人数排重显示";
    }else if(obj.id=="activityPageTotal") {
        content="活动期间，活动页面的访问人数排重显示";
    }else if(obj.id=="participationData") {
        content="参与人次 = 活动期间，许愿池活动的参与人次<br/>参与人数 = 活动期间，许愿池活动的参与人数排重显示";
    }else if(obj.id=="prizeData") {
        content="中奖总人次 = 活动期间，许愿池活动的中奖总人数（非“谢谢”数据）<br/>中奖总人数 = 活动期间，许愿池活动的中奖总人数排重显示（非“谢谢”数据）";
    }else if(obj.id=="enjoyData") {
        content="分享总人次 = 活动期间，许愿池页面分享总人次数据<br/>分享人数据 = 活动期间，许愿池页面分享总人数排重显示";
    }else if(obj.id=="expendIntegrals") {
        content="许愿贺词消耗积分数 = 活动期间，使用20积分换取许愿池机会的积分数 ";
    }else if(obj.id=="couponGrantCount") {
        content="活动期间，发放的优惠券数量之和 ";
    }else if(obj.id=="couponUseCount") {
        content="优惠券有效期内，使用数量之和";
    }else if(obj.id=="couponGrantUserCount") {
        content="活动期间，优惠券发放总人数（排重显示） ";
    }else if(obj.id=="couponUseUserCount") {
        content="优惠券有效期内，使用优惠券的人数（排重显示）";
    }else if(obj.id=="couponPastCount") {
        content="优惠券未进行使用/失效的数量。 ";
    }else if(obj.id=="couponPastUserCount") {
        content="优惠券未进行使用/失效的数量。";
    }
    $("#mydiv").html(content);
    return content;
}

//导出数据
$("#export").click(function() {
    if($("#dataCh").text()==1) {
        data = $("[name='datas']:checked").val();
        if(typeof(data)=="undefined") {
            data = "";
        }
    }else if($("#dataCh").text()==3){
        data = $("[name='choice']").val();
        if(data == "满减") {
            data = $("[name='choice1']").val();
            if(data == "全部"){
                data = "满减";
            }
        }
    }else {
        data = $("[name='dataChoice']").val();
    }
    var activityName = $("#activityName").text();
    location.href = "marketing/exportExcel?startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&data="+encodeURI(encodeURI(data))+"&activityId="+$("#activityId").text()+"&sign=avtivityExport"+"&activityName="+encodeURI(encodeURI(activityName));
});

//加载数据
function getActivityData (startTime,endTime,data,activityId) {

    $.ajax({
        type:"post",
        url:"marketing/getActivitySpuSku",
        data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
        dataType:"json",
        success:function(data){
            getActivitySpuSku(data);
        },
        error:function(data){alert("网络开小差,请刷新重试!");}
    });
    $.ajax({
        type:"post",
        url:"marketing/getActivityTotal",
        data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
        dataType:"json",
        success:function(data){
            getActivityTotal(data);
        },
        error:function(data){alert("网络开小差,请刷新重试!");}
    });
    $.ajax({
        type:"post",
        url:"marketing/getActivityUserTotal",
        data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
        dataType:"json",
        success:function(data){
            getActivityUserTotal(data);
        },
        error:function(){alert("网络开小差,请刷新重试!");}
    });
    $.ajax({
        type:"post",
        url:"marketing/getActivityUserRepeat",
        data:{"startTime":startTime,"endTime":endTime,"data":data,"activityId":activityId},
        dataType:"json",
        success:function(data){
            getActivityUserRepeat(data);
        },
        error:function(){alert("网络开小差,请刷新重试!");}
    });
    $.ajax({
        type:"post",
        url:"marketing/getActivityUserAdd",
        data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
        dataType:"json",
        success:function(data){
            getActivityUserAdd(data);
        },
        error:function(){alert("网络开小差,请刷新重试!");}
    });

        $.ajax({
            url:"marketing/getActivityUserCount",
            data:{"startTime":startTime,"endTime":endTime,"activityId":""},
            dataType:"json",
            type:"post",
            success:function(data) {
                getActivityUserCount(data);
            },
            error:function(){alert("网络开小差,请刷新重试!");}
        })

            $.ajax({
                url:"marketing/getParticipationData",
                data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
                dataType:"json",
                type:"post",
                success:function(data) {
                    getParticipationData(data);
                },
                error:function(){alert("网络开小差,请刷新重试!");}
            })

            //优惠券  ==
            $.ajax({
                url:"marketing/getCouponAdvance",
                data:{"startTime":startTime,"endTime":endTime},
                dataType:"json",
                type:"post",
                success:function(data) {
                    getCoupon(data);
                    //alert(data.getCouponUseFiftyCount);
                },
                error:function(){alert("网络开小差,请刷新重试!");}
            })
            //中奖详情
            $.ajax({
                url:"marketing/getPrizeCountV2",
                data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
                dataType:"json",
                type:"post",
                success:function(data) {
                    getPrizeInterger(data);
                },
                error:function(){alert("网络开小差,请刷新重试!");}
            })
    $.ajax({
        url:"marketing/getPrizeData",
        data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
        dataType:"json",
        type:"post",
        success:function(data) {
            getPrizeData(data);
        },
        error:function(){alert("网络开小差,请刷新重试!");}
    })


        }


function getActivitySpuSku(data) {
    $("#saleSpuTotal").html(data["saleSpuTotal"]);
    $("#saleSpuAppTotal").html(data["saleSpuAppTotal"]);
    $("#saleSpuWebChatTotal").html(data["saleSpuWebChatTotal"]);
    $("#saleSpuMicroTotal").html(data["saleSpuMicroTotal"]);
    $("#saleSpuMTotal").html(data["saleSpuMTotal"]);

    $("#saleSkuTotal").html(data["saleSkuTotal"]);
    $("#saleSkuAppTotal").html(data["saleSkuAppTotal"]);
    $("#saleSkuWebChatTotal").html(data["saleSkuWebChatTotal"]);
    $("#saleSkuMicroTotal").html(data["saleSkuMicroTotal"]);
    $("#saleSkuMTotal").html(data["saleSkuMTotal"]);
}

function getActivityTotal(data) {
    $("#saleProductTotal").html(data["saleProductTotal"]);
    $("#saleProductAppTotal").html(data["saleProductAppTotal"]);
    $("#saleProductWebChatTotal").html(data["saleProductWebChatTotal"]);
    $("#saleProductMicroTotal").html(data["saleProductMicroTotal"]);
    $("#saleProductMTotal").html(data["saleProductMTotal"]);

    $("#saleMainOrderTotal").html(data["saleMainOrderTotal"]);
    $("#saleMainOrderAppTotal").html(data["saleMainOrderAppTotal"]);
    $("#saleMainOrderWebChatTotal").html(data["saleMainOrderWebChatTotal"]);
    $("#saleMainOrderMicroTotal").html(data["saleMainOrderMicroTotal"]);
    $("#saleMainOrderMTotal").html(data["saleMainOrderMTotal"]);

    $("#saleSubOrderTotal").html(data["saleSubOrderTotal"]);
    $("#saleSubOrderAppTotal").html(data["saleSubOrderAppTotal"]);
    $("#saleSubOrderWebChatTotal").html(data["saleSubOrderWebChatTotal"]);
    $("#saleSubOrderMicroTotal").html(data["saleSubOrderMicroTotal"]);
    $("#saleSubOrderMTotal").html(data["saleSubOrderMTotal"]);

    $("#saleCashTotalSub").html(data["saleCashTotalSub"]);
    $("#saleCashTotalAppSub").html(data["saleCashTotalAppSub"]);
    $("#saleCashTotalWebChatSub").html(data["saleCashTotalWebChatSub"]);
    $("#saleCashTotalMicroSub").html(data["saleCashTotalMicroSub"]);
    $("#saleCashTotalMSub").html(data["saleCashTotalMSub"]);

    $("#actualPayPointTotal").html(data["actualPayPointTotal"]);
    $("#actualPayPointAppTotal").html(data["actualPayPointAppTotal"]);
    $("#actualPayPointWebChatTotal").html(data["actualPayPointWebChatTotal"]);
    $("#actualPayPointMicroTotal").html(data["actualPayPointMicroTotal"]);
    $("#actualPayPointMTotal").html(data["actualPayPointMTotal"]);

    $("#specialCashTotal").html(data["specialCashTotal"]);
    $("#specialCashAppTotal").html(data["specialCashAppTotal"]);
    $("#specialCashWebChatTotal").html(data["specialCashWebChatTotal"]);
    $("#specialCashMicroTotal").html(data["specialCashMicroTotal"]);
    $("#specialCashMTotal").html(data["specialCashMTotal"]);
}

function getActivityUserTotal(data) {
    $("#enjoyUserCount").html(data["travelUserCount"]);
    $("#enjoyUserAppCount").html(data["travelUserCountAPP"]);
    $("#enjoyUserMicroMallCount").html(data["travelUserCountMicroMall"]);
    $("#enjoyUserMicroCount").html(data["travelUserCountMicro"]);
    $("#enjoyUserMCount").html(data["travelUserCountM"]);
}

function getActivityUserRepeat (data) {
    $("#repeatUserCount").html(data["travelRepeUserCount"]);
    $("#repeatUserAppCount").html(data["travelRepeUserCountAPP"]);
    $("#repeatUserMicroMallCount").html(data["travelRepeUserCountMicroMall"]);
    $("#repeatUserMicroCount").html(data["travelRepeUserCountMicro"]);
    $("#repeatUserMCount").html(data["travelRepeUserCountM"]);
}

function getActivityUserAdd (data) {
    $("#addUserCount").html(data["USERTOTAL"]);
}
//拉新会员数
//拉新会员数
function getActivityUserCount(data){
    $("#activityUserApp").html(data["activityUserApp"]);
    $("#activityMicroMallTotal").html(data["activityMicroMallTotal"]);
    $("#activityUserCountW").html(data["activityUserCountW"]);
}
//参与数据
function getParticipationData(data) {
    $("#participationDataTimes").html(data["PARTICIPATIONDATATIMES"]);
    $("#participationDataNumber").html(data["PARTICIPATIONDATANUMBER"]);
}

//中奖数据
function getPrizeData(data) {
    $("#prizeDataTimes").html(data["PRIZEDATATIMES"]);
    $("#prizeDataNumber").html(data["PRIZEDATANUMBER"]);
}

//积分的奖励值  人次  人数
function getPrizeInterger(data) {
    $("#twentyCount").html(data["twentyCount"]);
    $("#oneHundredCount").html(data["oneHundredCount"]);
    $("#twoHundredCount").html(data["twoHundredCount"]);
    $("#fiveHundredCount").html(data["fiveHundredCount"]);
    $("#fiveCount").html(data["fiveCount"]);
    $("#twentysCount").html(data["twentysCount"]);
    $("#fiftyCount").html(data["fiftyCount"]);

    $("#thanksCountTimes").html(data["thanksCountTimes"]);

    $("#oneHundredCountTimes").html(data["oneHundredCountTimes"]);
    $("#fiveHundredCountTimes").html(data["fiveHundredCountTimes"]);
    $("#fiveCountTimes").html(data["fiveCountTimes"]);
    $("#twentysCountTimes").html(data["twentysCountTimes"]);
    $("#fiftyCountTimes").html(data["fiftyCountTimes"]);

    $("#thanksCountNumber").html(data["thanksCountNumber"]);
    $("#thirtyCountNumber").html(data["thirtyCountNumber"]);
    $("#oneHundredCountNumber").html(data["oneHundredCountNumber"]);
    $("#fiveHundredCountNumber").html(data["fiveHundredCountNumber"]);
    $("#fiveCountNumber").html(data["fiveCountNumber"]);
    $("#twentysCountNumber").html(data["twentysCountNumber"]);
    $("#fiftyCountNumber").html(data["fiftyCountNumber"]);
}

//优惠券
function getCoupon(data) {
    //许愿池消耗积分
    $("#SCOREBOARD").html(data["SCOREBOARD"]);
    //分享
    $("#shareCount").html(data["shareCount"]);
    $("#shareDisCount").html(data["shareDisCount"]);

    $("#couponGrantCounts").html(data["couponGrantCounts"]);
    $("#couponGrantCounts1").html(data["couponGrantCounts1"]);

    $("#getCouponFiveCount").html(data["getCouponFiveCount"]);
    $("#getCouponTwentyCount").html(data["getCouponTwentyCount"]);
    $("#getCouponFiftyCount").html(data["getCouponFiftyCount"]);

    $("#couponGrantUserCounts").html(data["couponGrantUserCounts"]);
    $("#couponGrantUserCounts1").html(data["couponGrantUserCounts1"]);

    $("#couponGrantUserFiveCounts").html(data["couponGrantUserFiveCounts"]);
    $("#couponGrantUserTwentyCounts").html(data["couponGrantUserTwentyCounts"]);
    $("#couponGrantUserFiftyCounts").html(data["couponGrantUserFiftyCounts"]);



    $("#couponUseCounts").html(data["couponUseCounts"]);
    $("#getCouponUseFiveCount").html(data["getCouponUseFiveCount"]);
    $("#getCouponUseTwentyCount").html(data["getCouponUseTwentyCount"]);
    $("#getCouponUseFiftyCount").html(data["getCouponUseFiftyCount"]);

    $("#couponUseUserCounts").html(data["couponUseUserCounts"]);
    $("#couponUseUserFiveCounts").html(data["couponUseUserFiveCounts"]);
    $("#couponUseUserTwentyCounts").html(data["couponUseUserTwentyCounts"]);
    $("#couponUseUseFiftyCounts").html(data["couponUseUseFiftyCounts"]);

    //
    $("#couponGrantAdvanceCounts").html(data["couponGrantAdvanceCounts"]);
    $("#getCouponFiveAdvanceCount").html(data["getCouponFiveAdvanceCount"]);
    $("#getCouponTwentyAdvanceCount").html(data["getCouponTwentyAdvanceCount"]);
    $("#getCouponFiftyAdvanceCount").html(data["getCouponFiftyAdvanceCount"]);

    $("#couponUseUseAdvancerCounts").html(data["couponUseUseAdvancerCounts"]);
    $("#couponUseUserFiveAdvanceCounts").html(data["couponUseUserFiveAdvanceCounts"]);
    $("#couponUseUserTwentyAdvanceCounts").html(data["couponUseUserTwentyAdvanceCounts"]);
    $("#couponUseUseFiftyAdvanceCounts").html(data["couponUseUseFiftyAdvanceCounts"]);


    $("#couponPastCounts").html(data["couponPastCounts"]);
    $("#getCouponPastFiveCount").html(data["getCouponPastFiveCount"]);
    $("#getCouponPastTwentyCount").html(data["getCouponPastTwentyCount"]);
    $("#getCouponPastFiftyCount").html(data["getCouponPastFiftyCount"]);

    $("#couponPastUserCounts").html(data["couponPastUserCounts"]);
    $("#couponPastUserFiveCounts").html(data["couponPastUserFiveCounts"]);
    $("#couponPastUserTwentyCounts").html(data["couponPastUserTwentyCounts"]);
    $("#couponPastUserFiftyCounts").html(data["couponPastUserFiftyCounts"]);

    $("#orderCouponPastPrice").html(data["orderCouponPastPrice"]);
    $("#getOrderCouponPastFivePrice").html(data["getOrderCouponPastFivePrice"]);
    $("#getOrderCouponPastTwentyPrice").html(data["getOrderCouponPastTwentyPrice"]);
    $("#getOrderCouponPastFiftyPrice").html(data["getOrderCouponPastFiftyPrice"]);


    $("#thanksCount").html(data["thanksCount"]);
    $("#thanksCount1").html(data["thanksCount"]);

    $("#thanksCountNumber").html(data["thanksCountNumber"]);
    $("#thirtyCountTimes").html(data["thirtyCountTimes"]);
    $("#oneHundredCountTimes").html(data["oneHundredCountTimes"]);
    $("#fiveHundredCountTimes").html(data["fiveHundredCountTimes"]);
    $("#fiveCountTimes").html(data["fiveCountTimes"]);
    $("#twentysCountTimes").html(data["twentysCountTimes"]);
    $("#fiftyCountTimes").html(data["fiftyCountTimes"]);

    $("#thanksCountNumber").html(data["thanksCountNumber"]);
    $("#thirtyCountNumber").html(data["thirtyCountNumber"]);
    $("#oneHundredCountNumber").html(data["oneHundredCountNumber"]);
    $("#fiveHundredCountNumber").html(data["fiveHundredCountNumber"]);
    $("#fiveCountNumber").html(data["fiveCountNumber"]);
    $("#twentysCountNumber").html(data["twentysCountNumber"]);
    $("#fiftyCountNumber").html(data["fiftyCountNumber"]);

    $("#2018count").html(data["2018count"]);
    $("#2018DisCount").html(data["2018DisCount"]);

    $("#cash2018").html(data["cash2018"]);

}

function getChannel() {
    $.ajax({
        url:'marketing/getChannel',
        data:{startTime:startTime,endTime:endTime,data:data,activityId:activityId},
        dataType:"json",
        type:"post",
        success:function(data) {
            for(var i in data) {
                $("[name='channel']").append("<option value="+data[i].CHANNELID+">"+data[i].CHANNELNAME+"</option>");
            }
        },
        error:function() {
            alert("获取数据失败");
        }
    });





}