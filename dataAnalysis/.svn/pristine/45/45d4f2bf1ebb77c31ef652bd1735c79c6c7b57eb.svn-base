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
    if(startTime > "2017-08-02 00:00:00") {
        $.ajax({
            url:"marketing/getActivityUserCount",
            data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
            dataType:"json",
            type:"post",
            success:function(data) {
                getActivityUserCount(data);
            },
            error:function(){alert("网络开小差,请刷新重试!");}
        })
        //优惠券
        $.ajax({
            url:"marketing/query315miniHouseEleAppliances",
            data:{"startTime":startTime,"endTime":endTime},
            dataType:"json",
            type:"post",
            success:function(data) {
                getCoupon(data);
            },
            error:function(){alert("网络开小差,请刷新重试!");}
        })
        $.ajax({
            url:"marketing/getPrizeInterger",
            data:{"startTime":startTime,"endTime":endTime},
            dataType:"json",
            type:"post",
            success:function(data) {
                getPrizeInterger(data);
            },
            error:function(){alert("网络开小差,请刷新重试!");}
        })
        $.ajax({
            url:"marketing/getOtherCount",
            data:{"startTime":startTime,"endTime":endTime,"activityId":activityId},
            dataType:"json",
            type:"post",
            success:function(data) {
                getOtherCount(data);
            },
            error:function(){alert("网络开小差,请刷新重试!");}
        })

    }
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




//优惠券
function getCoupon(data) {
    //发放数量 人数
    $("#couponCountAdvanceCounts").html(data["couponCountAdvanceCounts"]);
    $("#couponAdvanceGrantUserCounts").html(data["couponAdvanceGrantUserCounts"]);

    $("#getCouponFiveAdvanceCount").html(data["getCouponFiveAdvanceCount"]);
    $("#couponGrantFifteenAdvanceCounts").html(data["couponGrantFifteenAdvanceCounts"]);
    $("#getCouponTwentyAdvanceCount").html(data["getCouponTwentyAdvanceCount"]);
    $("#getCouponFiftyAdvanceCount").html(data["getCouponFiftyAdvanceCount"]);

    $("#couponUseUserFiveAdvanceCounts").html(data["couponUseUserFiveAdvanceCounts"]);
    $("#couponUseUseFifteenAdvancerCounts").html(data["couponUseUseFifteenAdvancerCounts"]);
    $("#couponUseUserTwentyAdvanceCounts").html(data["couponUseUserTwentyAdvanceCounts"]);
    $("#couponUseUseFiftyAdvanceCounts").html(data["couponUseUseFiftyAdvanceCounts"]);

    //重复使用 变为中奖数量

    $("#getCouponFiveAdvanceCountLuck").html(data["getCouponFiveAdvanceCount"]);
    $("#couponGrantFifteenAdvanceCountsLuck").html(data["couponGrantFifteenAdvanceCounts"]);
    $("#getCouponTwentyAdvanceCountLuck").html(data["getCouponTwentyAdvanceCount"]);
    $("#getCouponFiftyAdvanceCountLuck").html(data["getCouponFiftyAdvanceCount"]);

    $("#couponUseUserFiveAdvanceCountsLuck").html(data["couponUseUserFiveAdvanceCounts"]);
    $("#couponUseUseFifteenAdvancerCountsLuck").html(data["couponUseUseFifteenAdvancerCounts"]);
    $("#couponUseUserTwentyAdvanceCountsLuck").html(data["couponUseUserTwentyAdvanceCounts"]);
    $("#couponUseUseFiftyAdvanceCountsLuck").html(data["couponUseUseFiftyAdvanceCounts"]);


    //使用数量人数

    $("#couponUseCounts").html(data["couponUseCounts"]);
    $("#couponUseUserCounts").html(data["couponUseUserCounts"]);

    $("#getCouponUseFiveCount").html(data["getCouponUseFiveCount"]);
    $("#getCouponUseFifteenCount").html(data["getCouponUseFifteenCount"]);
    $("#getCouponUseTwentyCount").html(data["getCouponUseTwentyCount"]);
    $("#getCouponUseFiftyCount").html(data["getCouponUseFiftyCount"]);

    $("#couponUseUserFiveCounts").html(data["couponUseUserFiveCounts"]);
    $("#couponUseUserFifteenCounts").html(data["couponUseUserFifteenCounts"]);
    $("#couponUseUserTwentyCounts").html(data["couponUseUserTwentyCounts"]);
    $("#couponUseUseFiftyCounts").html(data["couponUseUseFiftyCounts"]);

    //过期优惠券
    $("#getCouponPast").html(data["getCouponPast"]);
    $("#couponPastUser").html(data["couponPastUser"]);


    $("#getCouponPastFiveCount").html(data["getCouponPastFiveCount"]);
    $("#couponPastFifteenCounts").html(data["couponPastFifteenCounts"]);
    $("#getCouponPastTwentyCount").html(data["getCouponPastTwentyCount"]);
    $("#getCouponPastFiftyCount").html(data["getCouponPastFiftyCount"]);

    $("#couponPastUserFiveCounts").html(data["couponPastUserFiveCounts"]);
    $("#couponPastUserFifteenCounts").html(data["couponPastUserFifteenCounts"]);
    $("#couponPastUserTwentyCounts").html(data["couponPastUserTwentyCounts"]);
    $("#couponPastUserFiftyCounts").html(data["couponPastUserFiftyCounts"]);

    //订单金额优惠券
    $("#getOrderCouponPastPrice").html(data["getOrderCouponPastPrice"]);
    $("#orderCouponPastFivePrice").html(data["orderCouponPastFivePrice"]);
    $("#getOrderCouponPastFifteenPrice").html(data["getOrderCouponPastFifteenPrice"]);
    $("#getOrderCouponPastTwentyPrice").html(data["getOrderCouponPastTwentyPrice"]);
    $("#getOrderCouponPastFiftyPrice").html(data["getOrderCouponPastFiftyPrice"]);



}
