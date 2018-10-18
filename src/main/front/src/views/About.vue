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
                }]


            }
        }
    }
</script>
