
$(function () {



    // 路径配置
    require.config({
        paths: {
            // echarts: '../static/echarts-2.2.7/build/dist'
            echarts: '../static/echarts'
        }
    });

    // 使用
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line'
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = ec.init(document.getElementById('main'));

            var option3 = {
                backgroundColor: '#FFFFFF',
                title: {
                    x: "center",
                    text: "title3",
                    textStyle: {
                        fontSize: 18,
                        fontWeight: 'bolder',
                        color: '#333',
                        align: 'center'
                    }
                },
                tooltip: {
                    trigger: 'axis'
                },
                xAxis: [{
                    type: 'category',
                    data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                }],
                yAxis: [{
                    type: 'value',
                    name: "dun"
                }],
                series: [{
                    "name": "",
                    "type": "bar",
                    stack: 'sum',//多组数据堆叠时使用
                    barCategoryGap: '40%',
                    itemStyle: {// 系列级个性化
                        normal: {
                            color: '#2EC7C9'
                        }
                    },
                    data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                    markLine: {
                        itemStyle: {
                            normal: {
                                lineStyle: {
                                    type: 'dashed',
                                    color: '#C23531',
                                },
                            }
                        },
                        data: [
                            {
                                name: '平均值',
                                label: {
                                    show: true,
                                    position: 'end',
                                    formatter: '{a}: {b}'
                                },
                                type: 'average'
                            },
                            {
                                name: '最大值',
                                label: {
                                    show: true,
                                    position: 'end',
                                    formatter: '{b}: {c}'
                                },
                                type: 'max'
                            },
                            {
                                name: '最小值',
                                label: {
                                    show: true,
                                    position: 'end',
                                    formatter: '{c}: {d}'
                                },
                                type: 'min'
                            }]
                    }
                }]
            };
            window.onresize = myChart.resize;
            // 为echarts对象加载数据
            myChart.setOption(option3);
        }
    );

})