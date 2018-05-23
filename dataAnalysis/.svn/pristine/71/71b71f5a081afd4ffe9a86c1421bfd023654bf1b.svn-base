$(function(){
	var tables=document.getElementsByTagName("table");
	for(var i=0;i<tables.length;i++){
		if(tables[i].className=='table1'){
			tables[i].rows[0].cells[0].width="3%";
			var width=97/(tables[i].rows[0].cells.length-1);
			for(var j=1;j<tables[i].rows[0].cells.length;j++){
				tables[i].rows[0].cells[j].width=1115*width/100+"px";
				tables[i].rows[0].cells[j].onmouseover=function(){
					show(this);
				};
				tables[i].rows[0].cells[j].onmouseout=function(){
					hide(this);
				};
			}
		}
	}
})
$("#dataCh").hide();
$("#data").hide();
$("#data1").hide();
$("#data2").hide();
$("#data3").hide();
$("#data4").hide();


$("[name='datas']").eq(0).attr("checked","checked");

if($("#dataCh").text()==1) {
	$("#data").show();
}else if($("#dataCh").text()==2) {
	$("#data1").show();
}else if($("#dataCh").text()==3) {
	$("#data2").show();
}else if($("#dataCh").text()==4) {
	$("#data4").show();
}

$("#startTime").val($("#start").val());
$("#endTime").val($("#end").val());
var startTime = $("#startTime").val();
var endTime = $("#endTime").val();
var array = startTime.split(" ");
var a = array[0].split("-");
var a3 = array[1].split(":");
var array1 = endTime.split(" ");
var a1 = array1[0].split("-");
var a2 = array1[1].split(":");
$("#time").text(a[0]+"年"+a[1]+"月"+a[2]+"日  "+a3[0]+":"+a3[1]+":"+a3[2]+" 至 "+a1[0]+"年"+a1[1]+"月"+a1[2]+"日  "+a2[0]+":"+a2[1]+":"+a2[2]);

if(startTime > '2017-08-31 00:00:00') {
	$("#export").hide();
}


var activityId = $("#activityId").text();

if(startTime >= '2017-09-13 00:00:00') {
	$("#activityTotal").show();
	$("#activityTotals").show();
	$("#activityMicroApp").show();
	$("#activityMicroMallTotal").show();
	$("#activityMicroMall").show();
}

if(activityId == 'ZHB20170904001') {
	$("#coupon").show();
	$("#part").show();
	$("#prize").show();
}




function show(obj){
	var content=showInfo(obj);
	if(content!=""){
		var objDiv=$("#mydiv");
		var offset=$(obj).offset();
		console.log(offset);
		$(objDiv).css("display","block");
		$(objDiv).css("left",offset.left-200);
		$(objDiv).css("top",offset.top-$(objDiv).height()-105);
		$(objDiv).css("width",obj.width-30);
	}
}

function hide(obj){
	var objDiv=$("#mydiv");
	if(objDiv.innerHTML!=""){
		$(objDiv).css("display","none");
	}
}
//		href:'aiPinXuan/center/marketing/activityData',

function back() {
	var curr = $("#curr").text();
	$("#centerMarketing").panel({
		href:'marketing/toActivityData',
		queryParams:{
			current:curr
		}
	})
}