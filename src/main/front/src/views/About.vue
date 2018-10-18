<template>
    <div>
        <div class="page">
            <div class="page-content padding-30 container-fluid">
                <div class="row">
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-warning">
                                    <i class="icon wb-shopping-cart"></i>
                                </button>
                                <span class="ml-15 font-weight-400">ORDERS</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-danger icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">399</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+45% From previous month</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-danger">
                                    <i class="icon wt-money"></i>
                                </button>
                                <span class="ml-15 font-weight-400">INCOM</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-success icon wb-triangle-down font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">$18,628</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+45% From previous month</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-success">
                                    <i class="icon wb-eye"></i>
                                </button>
                                <span class="ml-15 font-weight-400">VISITORS</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-danger icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">23,456</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+25% From previous month</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-primary">
                                    <i class="icon wb-user"></i>
                                </button>
                                <span class="ml-15 font-weight-400">CUSTOMERS</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-danger icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">4,367</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+25% From previous month</p>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br />
                        <br />
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversion Mensual</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="350" type="area" :options="chartOptionsg1" :series="serieg1"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br />
                        <br />
                        <p class="font-size-20 blue-grey-700">Inversion por Tipo de Soporte</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="350" type="bar" :options="chartOptionsg2" :series="serieg2"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br />
                        <br />
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversion Marca por Tipo Soporte</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="350" type="bar" :options="chartOptionsg3" :series="serieg3"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br />
                        <br />
                        <p class="font-size-20 blue-grey-700">Inversion por Ciudad</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="350" type="bar" :options="chartOptionsgInversionCity" :series="chartOptionsgInversionCity.series"></apexcharts>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</template>
<script>
    import VueApexCharts from 'vue-apexcharts'
    export default {
        components: {
            apexcharts: VueApexCharts,
        },
        name: 'about',
        mounted() {
            this.sa
        },
        data() {
            return {
                chartOptionsg1: {
                    chart: {
                        //background: '#f4f4f4',
                        type: 'area',
                        toolbar: {
                            show: true,
                            tools: {
                                download: false,
                                selection: false,
                                zoom: false,
                                zoomin: false,
                                zoomout: false,
                                pan: false,
                                reset: false
                            },
                            autoSelected: 'zoom'
                        },
                        animations: {
                            enabled: true,
                            easing: 'easeinout',
                            speed: 300,
                            animateGradually: {
                                enabled: true,
                                delay: 50
                            },
                            dynamicAnimation: {
                                enabled: true,
                                speed: 150
                            }
                        }
                    },
                    grid: {
                        show: true,
                        borderColor: '#e0e3e8'
                    },
                    dataLabels: {
                        enabled: false,
                        offsetX: 0
                    },
                    stroke: {
                        curve: 'smooth'
                    },
                    xaxis: {
                        type: 'datetime',
                        categories: ["2018-09-19T00:00:00", "2018-09-19T01:30:00", "2018-09-19T02:30:00", "2018-09-19T03:30:00", "2018-09-19T04:30:00", "2018-09-19T05:30:00", "2018-09-19T06:30:00"],
                    },
                    tooltip: {
                        x: {
                            format: 'dd/MM/yy HH:mm'
                        },
                    }
                },
                serieg1: [{
                    name: 'Transmilenio',
                    data: [31, 40, 28, -63, 42, 109, 100]
                }, {
                    name: 'Vallas',
                    data: [11, 32, 45, 32, 34, 52, 41]
                }, {
                        name: 'Paraderos',
                        data: [15, 56, 42, 23, 34, 56, 15]
                    }
                ],

                chartOptionsg2: {
                    chart: {
                        type: 'bar',
                        stacked: true,
                        stackType: '100%'
                    },
                    plotOptions: {
                        bar: {
                            horizontal: true,
                            dataLabels: {
                                position: 'top',
                            }
                        }
                    },
                    dataLabels: {
                        enabled: true,
                        style: {
                            fontSize: '12px',
                            colors: ['#fff']
                        }
                    },
                    stroke: {
                        show: true,
                        width: 1,
                        colors: ['#fff']
                    },
                    xaxis: {
                        categories: [2015, 2016]
                    },
                    tooltip: {
                        y: {
                            formatter: function(val) {
                                return val + "%"
                            }
                        }
                    }
                },
                serieg2: [{
                    name:'Transmilenio',
                    data: [13, 98]
                }, {
                    name:'Vallas',
                    data: [44, 75]
                }, {
                    name:'Paraderos',
                    data: [21, 32]
                }],

                chartOptionsg3: {
                    chart: {
                        height: 350,
                        type: 'bar',
                        stacked: true,
                        stackType: '100%'
                    },
                    responsive: [{
                        breakpoint: 700,
                        options: {
                            legend: {
                                position: 'bottom',
                                offsetX: -10,
                                offsetY: 0
                            }
                        }
                    }],
                    xaxis: {
                        categories: [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30],
                    },
                    fill: {
                        opacity: 1
                    },

                    legend: {
                        position: 'right',
                        verticalAlign: 'top',
                        offsetX: 0,
                        offsetY: 50
                    },
                },
                serieg3: [
                    {
                        name:'Transmilenio',
                        data: [44, 55, 41, 67, 22, 43, 21, 49,56,89,98,78,98,12,45,65,98,78,45,12,32,65,98,78,45,1,32,65,89,45]
                    },
                    {
                        name:'Vallas',
                        data: [15, 23, 20, 8, 13, 27, 33, 12,56,89,87,45,12,65,98,78,45,32,56,89,78,45,32,45,98,45,32,65,78,15]
                    },
                    {
                        name:'Paraderos',
                        data: [41, 17, 15, 15, 21, 14, 15, 13,45,89,45,12,65,78,45,32,64,79,15,35,65,89,78,15,45,32,65,98,78,15]
                    }
                    ],
                chartOptionsgInversionCity: {
                    chart: {
                        height: 400,
                        type: 'bar',
                    },
                    plotOptions: {
                        bar: {
                            //horizontal: false,
                            endingShape: 'rounded',
                            //columnWidth: '55%',
                        },
                    },
                    dataLabels: {
                        enabled: false
                    },
                    stroke: {
                        show: true,
                        width: 2,
                        //colors: ['transparent']
                    },
                    series: [{
                        name: '2015',
                        data: [44, 55, 87, 56, 61, 95, 63, 60, 66, 15]
                    }, {
                        name: '2016',
                        data: [76, 85, 100, 98, 12, 98, 91, 100, 94, 32]
                    }],
                    xaxis: {
                        categories: ['Armenia', 'Barranquilla', 'Bogotá', 'Bucaramanga', 'Cali', 'Cartagena', 'Envigado', 'Manizales', 'Medellin', 'Pereira'],
                    },
                    yaxis: {
                        title: {
                            text: 'Costo en Miles'
                        }
                    },
                    fill: {
                        //opacity: 1
                    },
                    tooltip: {
                        y: {
                            formatter: function (val) {
                                return val + "%"
                            }
                        }
                    }
                }




            }
        }
    }
</script>
