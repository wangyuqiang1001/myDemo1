$(function () {
//初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));
    var option = {
        title: {
            text: '某地区蒸发量和降水量',
            subtext: '纯属虚构'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['蒸发量']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '蒸发量',
                type: 'bar',
                data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
                markPoint: {
                    data: [
                        {type: 'max', name: '最大值'},
                        {type: 'min', name: '最小值'}
                    ]
                },
                markLine: {
                    data: [
                        {
                            name: '最小值',
                            label: {
                                show: true,
                                position: 'end',
                                formatter: '{b}: {c}'

                            },
                            type: 'min'
                        },
                        {
                            name: '平均值',
                            label: {
                                show: true,
                                position: 'end',
                                formatter: '{b}: {c}'

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
                        }]
                }
            }
        ]
    };


    var option2 = {
        backgroundColor: '#FFFFFF',
        title: {
            x: "center",
            text: "某地降水量",
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
            name: '吨'
        }],
        series: [{
            "name": '吨',
            "type": "bar",
            stack: 'sum',
            barCategoryGap: '40%',
            itemStyle: {// 系列级个性化
                normal: {
                    color: '#2EC7C9'
                }
            },
            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            markLine: {
                itemStyle : {
                    normal: {
                        lineStyle: {
                            type: 'dashed',
                            color:'#C23531',
                        },
                    }
                },
                data: [
                    {
                        name: '平均值',
                        label: {
                            show: true,
                            position: 'end',
                            formatter: '{b}: {c}'
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
                            formatter: '{b}: {c}'
                        },
                        type: 'min'
                    }]
            }
        }
        ]
    };


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
            // splitLine:{show: false},
            data:
                // ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
            [],
        }],
        yAxis: [{
            type: 'value',
            splitLine:{show: false},
            name: "dun"
        }],
        series: [{
            "name": "",
            "type": "bar",
            // stack: 'sum',多组数据堆叠时使用
            barCategoryGap: '40%',
            itemStyle: {// 系列级个性化
                normal: {
                    color: '#2EC7C9'
                }
            },
            data:
                // [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3],
            [],
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
                            formatter: '{b}: {c}'
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
                            formatter: '{b}: {c}'
                        },
                        type: 'min'
                    }]
            }
        }]
    };




//使用制定的配置项和数据显示图表
    myChart.setOption(option3);

})
