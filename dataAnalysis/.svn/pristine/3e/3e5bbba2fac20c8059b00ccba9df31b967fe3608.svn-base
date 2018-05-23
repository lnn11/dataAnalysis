function getSaleData(startTime,overTime,pageIndex,isC){
	arrayList = [];
	arrayList = toGetSupplier(startTime,overTime,pageIndex,isC);
};
function toGetSupplier(startTime,overTime,pageNum,isC){
	var toUrl;
	var list = [];
	var pageSize = 6;
	if(pageNum == null){
		pageNum = 1;
		toUrl = "supplier/getSupplierSalesVoles";
	}else{
		toUrl = "supplier/getSupplierSalesVoles";
	}
	$.ajax({
		type:"post",
		url:toUrl,
		data:{"currentPage":pageNum,"pageSize":pageSize,"startTime":startTime,"overTime":overTime,"C":isC},
		dataType:"json",
		async:false,
		success:function(supplierData){
			if(null != supplierData){
				list = supplierData;
			}else{list = 0};
		},
		error:function(){alert("登录超时，请重新登录！");},
	});
	return list;
};