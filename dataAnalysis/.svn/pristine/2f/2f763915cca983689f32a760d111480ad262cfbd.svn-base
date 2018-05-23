var page = $("#current").text();
if(page == "" || page == null) {
	page=parseInt(page); 
	page=1;
}else{
	page=parseInt(page); 
}


/**
 * 列表加载数据
 */
$('#activityDataTable').datagrid({
    url:'marketing/getActivity',
    fitColumns:true,
    singleSelect:true,
    rownumbers:true,
    method: 'post',
	loadMsg:'正在加载,请稍等...',
    pagination:true,
    pageSize:10,
	pageNumber:page,
    pageList:[10,15,20,30,40,50,60,70,80,90,100],
    nowrap:false,
    remoteSort:false,
    columns:[[
//			{field:'index',title:'序号',width:38, align: 'center',formatter:function(val,row,index){
//			    var options = $("#activityDataTable").datagrid('getPager').data("pagination").options;
//			    var currentPage = options.pageNumber;
//			    var pageSize = options.pageSize;
//			    return (pageSize * (currentPage -1))+(index+1);
//			}},
        {field:'activityId',title:'活动编号',width:100,sortable:true,align:'center',halign:'center'},    
        {field:'activityName',title:'活动名称',width:100,sortable:true,align:'center',halign:'center'},    
        {field:'status',title:'活动状态',width:100,sortable:true,align:'center',halign:'center',formatter:function(value,row,index){
				if(value =="1"){
					return "待开启";
				}else if(value =="2"){
					return "进行中";
				}else if(value =="3"){
					return "已结束";
				}
        	}
        },
        {field:'startTime',title:'活动开始时间',width:100,sortable:true,align:'center',halign:'center',formatter:function(value,row,index){
        	ary = value.split(" ");
        	a = ary[0].split("-");
        	a1 = ary[1].split(":");
        	a1[2] = a1[2].substr(0,2);
            return a[0] + '年' + a[1] + '月' + a[2] + '日   ' + a1[0] + ':' + a1[1] + ':' +a1[2];
        }},
        {field:'endTime',title:'活动结束时间',width:100,sortable:true,align:'center',halign:'center',formatter:function(value,row,index){
        	ary = value.split(" ");
        	a = ary[0].split("-");
        	a1 = ary[1].split(":");
        	a1[2] = a1[2].substr(0,2);
            return a[0] + '年' + a[1] + '月' + a[2] + '日   ' + a1[0] + ':' + a1[1] + ':' +a1[2];
        }},
        {field:'XX',title:'查看详情',width:30,sortable:true,align:'center',halign:'center',formatter:function(value,row,index){
			if(row) {
				return "<img onclick='find(this)' style='cursor:pointer;' name='"+row.activityId+"' src='images/search.png'>";
			}
		}}
        /**{field:'XXX',title:'查看数据',width:30,sortable:true,align:'center',halign:'center'}*/
    ]]
});

function find(obj) {
	var id = $(obj).attr("name");

	var grid = $('#activityDataTable');  
	var options = grid.datagrid('getPager').data("pagination").options;  
	var curr = options.pageNumber;  //获得当前页 
	
	if(id=='ZHB20170402001') {//丝绸之路
		$("#centerMarketing").panel({
			href:'marketing/toSilkRoad',
			queryParams:{
				activityId:id,
				current:curr
			}
		});
	}else{
		$("#centerMarketing").panel({
			href:'marketing/toActivityViewUtil',
			queryParams:{
				activityId:id,
				current:curr
			}
		});
	}
}