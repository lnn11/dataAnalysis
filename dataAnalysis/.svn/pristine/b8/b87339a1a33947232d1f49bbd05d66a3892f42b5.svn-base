<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<style type="text/css">
    .table1{
        border:solid #ADADAD; border-width:1px 0px 0px 0px;margin: 30px 30px 0px 0px;
        height: 80px;
    }
    .table1 td{border:solid #ADADAD; border-width:0px 1px 1px 0px;}
    .td2{width: 50px;background-color: #1E90FF;color: #FFF;}
    .tr1{background-color: #1E90FF;color: #FFF;}
</style>
<div id="mydiv" style="position:absolute;display:none;border:1px solid;background:#FFFB5A;"></div>
<table id="title1" style="width: 1110px;height: 35px;background-color: #FFFFFF;border:1px solid;margin: 10px 10px 10px 10px;">
    <tr style="width: 110px;height: 35px;">
        <td style="width: 110px;height: 35px;">用户关注数</td>
        <td style="width: 110px;height: 35px;">参与人数</td>
        <td style="width: 110px;height: 35px;">用户参与度</td>
        <td style="width: 110px;height: 35px;">分享次数</td>
        <td style="width: 110px;height: 35px;">销售金额</td>
        <td style="width: 110px;height: 35px;">积分</td>
        <td style="width: 110px;height: 35px;">福利券</td>
    </tr>
    <tr style="width: 110px;height: 35px;">
        <td style="width: 110px;height: 35px;">100</td>
        <td style="width: 110px;height: 35px;">200</td>
        <td style="width: 110px;height: 35px;">24.55%</td>
        <td style="width: 110px;height: 35px;">500</td>
        <td style="width: 110px;height: 35px;">4030</td>
        <td style="width: 110px;height: 35px;">34546</td>
        <td style="width: 110px;height: 35px;">332</td>
    </tr>
    <tr style="width: 110px;height: 35px;">
        <td style="width: 110px;height: 35px;">站平台用户比率：12%</td>
        <td style="width: 110px;height: 35px;">站平台用户比率：14%</td>
        <td style="width: 110px;height: 35px;"></td>
        <td style="width: 110px;height: 35px;">站平台比率：16%</td>
        <td style="width: 110px;height: 35px;">占平台现金支付比率:18%</td>
        <td style="width: 110px;height: 35px;">占平台积分支付比率:45%</td>
        <td style="width: 110px;height: 35px;">占平台福利券支付比率:54%</td>
    </tr>
</table>
<div id="1" style="border: 1px;background-color: #FFFFFF;border:1px red;width: 1000px;">
<div id="main" style="width: 48%;height:400px;float:left;border:1px solid;">
    <script type="text/javascript">
        var mainChart = echarts.init(document.getElementById('main'));
        //data
        var data = [220, 182, 191, 234, 190, 330, 310,50,200];
        var markLineData = [];
        for (var i = 1; i < data.length; i++) {
            markLineData.push([{
                xAxis: i - 1,
                yAxis: data[i - 1],
                value: (data[i] + data[i-1]).toFixed(2)
            }, {
                xAxis: i,
                yAxis: data[i]
            }]);
        }

        //option
        mainOption = {
            title: {
                text: '用户关注数'
            },
            tooltip : {
                trigger: 'axis'
            },
            xAxis: {
                data: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
            },
            yAxis: {},
            series: [{
                type: 'line',
                data:data,
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    smooth: true,
                    effect: {
                        show: true
                    },
                    distance: 10,
                    label: {
                        normal: {
                            position: 'middle'
                        }
                    },
                    symbol: ['none', 'none'],
                    data: markLineData
                }
            }]
        };
        mainChart.setOption(mainOption);
    </script>
</div>
<div id="ndge" style="width: 48%;height:400px;float:right;border:1px solid;">
    <script type="text/javascript">
        var ndgeChart=echarts.init(document.getElementById('ndge'));
        optionNdge = {
            title : {
                text: '',
                subtext: '',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                x : 'center',
                y : 'bottom',
                data:['rose1','rose2']
            },
            toolbox: {
                show : true,
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true,
                        type: ['pie', 'funnel']
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            series : [
                {
                    name:'面积模式',
                    type:'pie',
                    radius : [30, 110],
                    center : ['75%', '50%'],
                    roseType : 'area',
                    data:[
                        {value:10, name:'rose1'},
                        {value:5, name:'rose2'},
                        {value:15, name:'rose3'},
                        {value:25, name:'rose4'},
                        {value:20, name:'rose5'},
                        {value:35, name:'rose6'},
                        {value:30, name:'rose7'},
                        {value:40, name:'rose8'}
                    ]
                }
            ]
        };
        ndgeChart.setOption(optionNdge);
    </script>
</div>
</div>
<div style="border: 1px;background-color: #FFFFFF;border:1px red;width: 1000px;margin: 1px 1px 1px 1px;">
<div id="user" style="width: 60%;height:400px;float:left;border:1px solid;">
    <script type="text/javascript">
        var userChart=echarts.init(document.getElementById('user'));
        userChart.title = '环形图';
        labelTop = {
            normal : {
                label : {
                    show : true,
                    position : 'center',
                    formatter : '{b}',
                    textStyle: {
                        baseline : 'bottom'
                    }
                },
                labelLine : {
                    show : false
                }
            }
        };
        var labelFromatter = {
            normal : {
                label : {
                    formatter : function (params){
                        return 100 - params.value + '%'
                    },
                    textStyle: {
                        baseline : 'top'
                    }
                }
            }
        }
        var labelBottom = {
            normal : {
                color: '#ccc',
                label : {
                    show : true,
                    position : 'center'
                },
                labelLine : {
                    show : false
                }
            },
            emphasis: {
                color: 'rgba(0,0,0,0)'
            }
        };
        var radius = [40, 55];
        userOption = {
            legend: {
                x : 'center',
                y : 'center',
                data:[
                    '剧情', '奇幻', '爱情', '惊悚'
                ]
            },
            title : {
                text: '各类型电影中“好片”所占比重',
                subtext: '原始数据来自豆瓣',
                x: 'center'
            },
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    magicType : {
                        show: true,
                        type: ['pie', 'funnel'],
                        option: {
                            funnel: {
                                width: '20%',
                                height: '30%',
                                itemStyle : {
                                    normal : {
                                        label : {
                                            formatter : function (params){
                                                return 'other\n' + params.value + '%\n'
                                            },
                                            textStyle: {
                                                baseline : 'middle'
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    },
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            series : [
                {
                    type : 'pie',
                    center : ['10%', '30%'],
                    radius : radius,
                    x: '0%', // for funnel
                    itemStyle : labelFromatter,
                    data : [
                        {name:'other', value:75, itemStyle : labelBottom},
                        {name:'剧情', value:25,itemStyle : labelTop}
                    ]
                },
                {
                    type : 'pie',
                    center : ['30%', '30%'],
                    radius : radius,
                    x:'20%', // for funnel
                    itemStyle : labelFromatter,
                    data : [
                        {name:'other', value:76, itemStyle : labelBottom},
                        {name:'奇幻', value:24,itemStyle : labelTop}
                    ]
                },
                {
                    type : 'pie',
                    center : ['50%', '30%'],
                    radius : radius,
                    x:'40%', // for funnel
                    itemStyle : labelFromatter,
                    data : [
                        {name:'other', value:86, itemStyle : labelBottom},
                        {name:'爱情', value:14,itemStyle : labelTop}
                    ]
                },
                {
                    type : 'pie',
                    center : ['70%', '30%'],
                    radius : radius,
                    x:'60%', // for funnel
                    itemStyle : labelFromatter,
                    data : [
                        {name:'other', value:89, itemStyle : labelBottom},
                        {name:'惊悚', value:11,itemStyle : labelTop}
                    ]
                }
            ]
        };
        userChart.setOption(userOption);
    </script>
</div>
    <div  style="width: 35%;height:400px;float:right;border:1px solid;">
        <img src="images/tongjinannv.png" style="height: 200px;">
        <div>1111111111111111111</div>
    </div>
</div>
<h1>-----------------------------------5------------------------------</h1>
<div id="map" style="width: 600px;height:400px;">
    <script type="text/javascript">
        var mapChart=echarts.init(document.getElementById("map"));
        mapoption = {
            title : {
                text: 'iphone销量',
                subtext: '纯属虚构',
                x:'center'
            },
            tooltip : {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                x:'left',
                data:['iphone3','iphone4','iphone5']
            },
            dataRange: {
                min: 0,
                max: 2500,
                x: 'left',
                y: 'bottom',
                text:['高','低'],           // 文本，默认为数值文本
                calculable : true
            },
            toolbox: {
                show: true,
                orient : 'vertical',
                x: 'right',
                y: 'center',
                feature : {
                    mark : {show: true},
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            roamController: {
                show: true,
                x: 'right',
                mapTypeControl: {
                    'china': true
                }
            },
            series : [
                {
                    name: 'iphone3',
                    type: 'map',
                    mapType: 'china',
                    roam: false,
                    itemStyle:{
                        normal:{label:{show:true}},
                        emphasis:{label:{show:true}}
                    },
                    data:[
                        {name: '北京',value: Math.round(Math.random()*1000)},
                        {name: '天津',value: Math.round(Math.random()*1000)},
                        {name: '上海',value: Math.round(Math.random()*1000)},
                        {name: '重庆',value: Math.round(Math.random()*1000)},
                        {name: '河北',value: Math.round(Math.random()*1000)},
                        {name: '河南',value: Math.round(Math.random()*1000)},
                        {name: '云南',value: Math.round(Math.random()*1000)},
                        {name: '辽宁',value: Math.round(Math.random()*1000)},
                        {name: '黑龙江',value: Math.round(Math.random()*1000)},
                        {name: '湖南',value: Math.round(Math.random()*1000)},
                        {name: '安徽',value: Math.round(Math.random()*1000)},
                        {name: '山东',value: Math.round(Math.random()*1000)},
                        {name: '新疆',value: Math.round(Math.random()*1000)},
                        {name: '江苏',value: Math.round(Math.random()*1000)},
                        {name: '浙江',value: Math.round(Math.random()*1000)},
                        {name: '江西',value: Math.round(Math.random()*1000)},
                        {name: '湖北',value: Math.round(Math.random()*1000)},
                        {name: '广西',value: Math.round(Math.random()*1000)},
                        {name: '甘肃',value: Math.round(Math.random()*1000)},
                        {name: '山西',value: Math.round(Math.random()*1000)},
                        {name: '内蒙古',value: Math.round(Math.random()*1000)},
                        {name: '陕西',value: Math.round(Math.random()*1000)},
                        {name: '吉林',value: Math.round(Math.random()*1000)},
                        {name: '福建',value: Math.round(Math.random()*1000)},
                        {name: '贵州',value: Math.round(Math.random()*1000)},
                        {name: '广东',value: Math.round(Math.random()*1000)},
                        {name: '青海',value: Math.round(Math.random()*1000)},
                        {name: '西藏',value: Math.round(Math.random()*1000)},
                        {name: '四川',value: Math.round(Math.random()*1000)},
                        {name: '宁夏',value: Math.round(Math.random()*1000)},
                        {name: '海南',value: Math.round(Math.random()*1000)},
                        {name: '台湾',value: Math.round(Math.random()*1000)},
                        {name: '香港',value: Math.round(Math.random()*1000)},
                        {name: '澳门',value: Math.round(Math.random()*1000)}
                    ]
                },
                {
                    name: 'iphone4',
                    type: 'map',
                    mapType: 'china',
                    itemStyle:{
                        normal:{label:{show:true}},
                        emphasis:{label:{show:true}}
                    },
                    data:[
                        {name: '北京',value: Math.round(Math.random()*1000)},
                        {name: '天津',value: Math.round(Math.random()*1000)},
                        {name: '上海',value: Math.round(Math.random()*1000)},
                        {name: '重庆',value: Math.round(Math.random()*1000)},
                        {name: '河北',value: Math.round(Math.random()*1000)},
                        {name: '安徽',value: Math.round(Math.random()*1000)},
                        {name: '新疆',value: Math.round(Math.random()*1000)},
                        {name: '浙江',value: Math.round(Math.random()*1000)},
                        {name: '江西',value: Math.round(Math.random()*1000)},
                        {name: '山西',value: Math.round(Math.random()*1000)},
                        {name: '内蒙古',value: Math.round(Math.random()*1000)},
                        {name: '吉林',value: Math.round(Math.random()*1000)},
                        {name: '福建',value: Math.round(Math.random()*1000)},
                        {name: '广东',value: Math.round(Math.random()*1000)},
                        {name: '西藏',value: Math.round(Math.random()*1000)},
                        {name: '四川',value: Math.round(Math.random()*1000)},
                        {name: '宁夏',value: Math.round(Math.random()*1000)},
                        {name: '香港',value: Math.round(Math.random()*1000)},
                        {name: '澳门',value: Math.round(Math.random()*1000)}
                    ]
                },
                {
                    name: 'iphone5',
                    type: 'map',
                    mapType: 'china',
                    itemStyle:{
                        normal:{label:{show:true}},
                        emphasis:{label:{show:true}}
                    },
                    data:[
                        {name: '北京',value: Math.round(Math.random()*1000)},
                        {name: '天津',value: Math.round(Math.random()*1000)},
                        {name: '上海',value: Math.round(Math.random()*1000)},
                        {name: '广东',value: Math.round(Math.random()*1000)},
                        {name: '台湾',value: Math.round(Math.random()*1000)},
                        {name: '香港',value: Math.round(Math.random()*1000)},
                        {name: '澳门',value: Math.round(Math.random()*1000)}
                    ]
                }
            ]
        };
        mapChart.setOption(mapoption);
    </script>
</div>
<h1>------------------------------------6--------------------------------</h1>
<script type="text/javascript" src="js/aiPinXuan/center/marketing/activityComm.js"></script>
<script type="text/javascript" src="js/aiPinXuan/center/marketing/NewActivityStatisticsPage.js"></script>
</body>
</html>