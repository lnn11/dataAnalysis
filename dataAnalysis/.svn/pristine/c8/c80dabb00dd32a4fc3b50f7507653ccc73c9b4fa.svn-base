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
  data = $("[name='channel']").val();
  if(typeof(data)=="undefined") {
    data = "";
  }
  var activityName = $("#activityName").text();
  location.href = "marketing/exportExcel?startTime="+$("#startTime").val()+"&endTime="+$("#endTime").val()+"&data="+encodeURI(encodeURI(data))+"&activityId="+$("#activityId").text()+"&sign=wuChangRiceExport"+"&activityName="+encodeURI(encodeURI(activityName));
});




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

//============================================================
