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
                                <span class="ml-15 font-weight-400">VALLAS</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-danger icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">399</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+45% en desarrollo</p>
                                    <apexcharts height="80" type="area" :options="sparkLine1"
                                                :series="sparkLine1.series"></apexcharts>
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
                                <span class="ml-15 font-weight-400">PARADEROS</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-success icon wb-triangle-down font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">$18,628</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+45% en desarrollo</p>
                                    <apexcharts height="80" type="area" :options="sparkLine1"
                                                :series="sparkLine1.series"></apexcharts>
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
                                <span class="ml-15 font-weight-400">SITM</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-danger icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">23,456</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+45% en desarrollo</p>
                                    <apexcharts height="80" type="area" :options="sparkLine1"
                                                :series="sparkLine1.series"></apexcharts>
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
                                <span class="ml-15 font-weight-400">TOTAL</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-danger icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-40 font-weight-100">4,367</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">+45% en desarrollo</p>
                                    <apexcharts height="80" type="area" :options="sparkLine1"
                                                :series="sparkLine1.series"></apexcharts>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversion Mensual</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <divrea>
                            <apexcharts height="350" type="area" :options="chartOptionsg1"
                                        :series="chartOptionsg1.series"></apexcharts>
                        </divrea>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Inversion por Tipo de Soporte</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="350" type="bar" :options="chartOptionsg2"
                                        :series="chartOptionsg2.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversion Marca por Tipo Soporte</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="500" type="bar" :options="chartOptionsg3"
                                        :series="chartOptionsg3.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Inversion por Ciudad</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="450" type="bar" :options="chartOptionsgInversionCity"
                                        :series="chartOptionsgInversionCity.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversion por Sector</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="600" type="bar" :options="chartOptionsgInversionSector"
                                        :series="chartOptionsgInversionSector.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">TOP Campañas</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="350" type="line" :options="chartOptionsTopCampanas"
                                        :series="chartOptionsTopCampanas.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversion por Marca</p>
                        <p>Quisque volutpat condimentum velit. Class aptent taciti</p>
                        <div>
                            <apexcharts height="350" type="bar" :options="chartOptionsEvolutivoInvMarca"
                                        :series="chartOptionsEvolutivoInvMarca.series"></apexcharts>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</template>
<script>
    import VueApexCharts from 'vue-apexcharts'
    import axios from 'axios'

    axios.defaults.baseURL = 'http://localhost:9898/api/dashboard';

    export default {
        components: {
            'apexcharts': VueApexCharts
        },
        name: 'about',
        mounted() {
            this.buildSparkLine();
            this.buildEvolutiveInvMonths();
            this.buildInvSupportType();
            this.buildEvolutiveInvBranSupport();
            this.buildByInvCity();
            this.buildInvSector();
            this.buildTopCampanas();
            this.buildEvolutiveInvBran();
            this.buildGeneralRequest();
        },
        data() {
            return {
                color: '#1A237E',
                color1: '#4527A0',
                size: '45px',
                margin: '2px',
                radius: '2px',
                loading: false,

                sparkLine1: {
                    series: null
                },
                chartOptionsg1: {
                    series: null
                },
                chartOptionsg2: {
                    series: null
                },
                chartOptionsg3: {
                    series: null
                },
                chartOptionsgInversionCity: {
                    series: null
                },
                chartOptionsgInversionSector: {
                    series: null
                },
                chartOptionsTopCampanas: {
                    series: null
                },
                chartOptionsEvolutivoInvMarca: {
                    series: null
                }
            }
        },
        methods: {
            buildGeneralRequest(type, params) {
                if (type === 'eim') {
                    axios.get('/getEvolutiveInvMonths', {
                        params: params
                    }).then(function (response) {
                        return response;
                    }).catch(function (error) {
                        return error;
                    });
                }
            },
            buildSparkLine() {
                this.sparkLine1 = {
                    chart: {
                        type: 'area',
                        height: 80,
                        sparkline: {
                            enabled: true
                        },
                    },
                    stroke: {
                        curve: 'straight'
                    },
                    fill: {
                        opacity: 0.3,
                        gradient: {
                            enabled: false
                        }
                    },
                    series: [{
                        data: [83, 45, 54, 38, 56, 24, 65, 31, 37, 39, 62, 51, 35, 41, 35, 27, 93, 53, 61, 98, 75, 32],
                    }],
                    yaxis: {
                        min: 0
                    },
                    colors: ['#DCE6EC'],
                    title: {
                        offsetX: 0,
                        style: {
                            fontSize: '24px',
                            cssClass: 'apexcharts-yaxis-title'
                        }
                    },
                    subtitle: {
                        offsetX: 0,
                        style: {
                            fontSize: '14px',
                            cssClass: 'apexcharts-yaxis-title'
                        }
                    }
                }
            },
            buildEvolutiveInvMonths() {
                let self = this;
                axios.get('/getEvolutiveInvMonths', {
                    params: null
                }).then(function (response) {
                    var data = response.data;
                    self.chartOptionsg1 = {
                        chart: {
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
                            curve: 'smooth',
                            width: 3
                        },
                        xaxis: {
                            //type: 'datetime',
                            categories: data.categories
                        },
                        series: data.series,
                        tooltip: {
                            x: {
                                format: 'dd/MM/yy HH:mm'
                            },
                        }
                    }
                }).catch(function (error) {
                    return error;
                });
            },
            buildInvSupportType() {
                let self = this;
                axios.get('/getInvBySupportType', {
                    params: null
                }).then(function (response) {
                    let data = response.data;
                    self.chartOptionsg2 = {
                        chart: {
                            type: 'bar',
                            stacked: true,
                            stackType: '100%'
                        },
                        plotOptions: {
                            bar: {
                                horizontal: true
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
                            categories: data.numericCategories
                        },
                        yaxis: {
                            labels: {
                                style: {
                                    color: '#8e8da4',
                                },
                                offsetX: 0,
                                formatter: function (val) {
                                    return val.toFixed(0);
                                },
                            }
                        },
                        tooltip: {
                            y: {
                                formatter: function (val) {
                                    return val.toFixed(2) + "%"
                                }
                            }
                        },
                        series: data.series
                    }
                }).catch(function (error) {
                    return error;
                });
            },
            buildEvolutiveInvBranSupport() {
                let self = this;
                axios.get('/getEvolutiveInvertionBranBySupportTypeService', {
                    params: null
                }).then(function (response) {
                    let data = response.data;
                    self.chartOptionsg3 = {
                        chart: {
                            height: 450,
                            type: 'bar',
                            stacked: true,
                            stackType: '100%'
                        },
                        responsive: [{
                            breakpoint: 700,
                            options: {
                                legend: {
                                    position: 'right',
                                    offsetX: -10,
                                    offsetY: 0
                                }
                            }
                        }],

                        xaxis: {
                            categories: data.categories
                        },
                        series: data.series,
                        fill: {
                            opacity: 1
                        },
                        legend: {
                            position: 'bottom',
                            horizontalAlign: 'center'
                        },
                        yaxis: {
                            labels: {
                                style: {
                                    color: '#8e8da4',
                                },
                                offsetX: 0,
                                formatter: function (val) {
                                    return val.toFixed(0) + "%";
                                },
                            }
                        },
                        tooltip: {
                            theme: 'dark',
                            x: {
                                show: true
                            },
                            y: {
                                title: {
                                    formatter: function () {
                                        return ''
                                    }
                                }
                            }
                        }
                    }
                }).catch(function (error) {
                    return error;
                });
            },
            buildByInvCity() {
                let self = this;
                axios.get('/getInvestmentByCity', {
                    params: null
                }).then(function (response) {
                    let data = response.data;
                    self.chartOptionsgInversionCity = {
                        chart: {
                            height: 400,
                            type: 'bar',
                            stacked: true,
                            //stackType: '100%'
                        },
                        plotOptions: {
                            bar: {
                                endingShape: 'rounded'
                            },
                        },
                        dataLabels: {
                            enabled: false
                        },
                        stroke: {
                            show: true,
                            width: 2,
                        },
                        yaxis: {
                            labels: {
                                style: {
                                    color: '#8e8da4',
                                },
                                offsetX: 0,
                                formatter: function (val) {
                                    return val.toFixed(0);
                                },
                            }
                        },
                        series: data.series,
                        xaxis: {
                            categories: data.categories
                        },
                        tooltip: {
                            y: {
                                formatter: function (val) {
                                    return val.toFixed(2) + "%";
                                }
                            }
                        }
                    }
                }).catch(function (error) {
                    return error;
                });
            },
            buildInvSector() {
                let self = this;
                axios.get('/getEvolutiveInvestmentSetor', {
                    params: null
                }).then(function (response) {
                    let data = response.data;
                    self.chartOptionsgInversionSector = {
                        chart: {
                            height: 450,
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
                        series: data.series,
                        xaxis: {
                            categories: data.categories
                        },
                        fill: {
                            opacity: 1
                        },
                        legend: {
                            position: 'bottom',
                            horizontalAlign: 'center'
                        },
                        tooltip: {
                            y: {
                                formatter: function (val) {
                                    return '$' + val.toFixed(2)
                                }
                            }
                        },
                        yaxis: {
                            labels: {
                                style: {
                                    color: '#8e8da4',
                                },
                                offsetX: 0,
                                formatter: function (val) {
                                    return val.toFixed(0) + "%";
                                },
                            }
                        }
                    }
                }).catch(function (error) {
                    return error;
                });
            },
            buildTopCampanas() {
                this.chartOptionsTopCampanas = {
                    chart: {
                        type: 'line',
                        height: 350
                    },
                    plotOptions: {
                        line: {
                            curve: 'smooth',
                        }
                    },
                    dataLabels: {
                        enabled: false
                    },
                    series: [
                        {
                            name: "Desktops  0 ",
                            data: [57, 83, 89, 84, 41, 92, 72, 6, 57, 70]
                        },
                        {
                            name: "Desktops  1 ",
                            data: [59, 92, 90, 80, 58, 28, 23, 18, 87, 86]
                        },
                        {
                            name: "Desktops  2 ",
                            data: [8, 70, 96, 81, 35, 54, 70, 8, 65, 21]
                        },
                        {
                            name: "Desktops  3 ",
                            data: [25, 50, 27, 49, 43, 73, 71, 32, 21, 8]
                        },
                        {
                            name: "Desktops  4 ",
                            data: [49, 52, 5, 93, 67, 4, 6, 93, 71, 14]
                        },
                        {
                            name: "Desktops  5 ",
                            data: [87, 9, 53, 99, 34, 66, 57, 81, 57, 19]
                        },
                        {
                            name: "Desktops  6 ",
                            data: [17, 90, 49, 45, 48, 57, 31, 350, 85, 25]
                        },
                        {
                            name: "Desktops  7 ",
                            data: [19, 44, 14, 80, 44, 21, 99, 47, 92, 57]
                        },
                        {
                            name: "Desktops  8 ",
                            data: [73, 57, 99, 6, 8, 46, 15, 82, 89, 45]
                        },
                        {
                            name: "Desktops  9 ",
                            data: [85, 83, 8, 22, 23, 65, 92, 88, 56, 80]
                        },
                    ],
                    markers: {
                        size: 0,
                        style: 'full',
                    },
                    yaxis: {

                        labels: {
                            style: {
                                color: '#8e8da4',
                            },
                            offsetX: 0,
                            formatter: function (val) {
                                return val.toFixed(2);
                            },
                        },
                        axisBorder: {
                            show: false,
                        },

                        axisTicks: {
                            show: false
                        }
                    },
                    stroke: {
                        curve: 'smooth',
                        show: true,
                        width: 3
                    },
                    xaxis: {
                        //type: 'datetime',
                        categories: ['2015 Ene', '2015 Mar', '2015 Abr', 'Bucaramanga', 'Cali', 'Cartagena', 'Envigado', 'Manizales', 'Medellin', 'Pereira'],
                        //min: 0,
                        //max: 100,
                        labels: {
                            formatter: function (val) {
                                return val
                            }
                        }
                    },
                    tooltip: {
                        shared: true
                    },
                    legend: {
                        position: 'bottom',
                        horizontalAlign: 'center'
                    }
                }
            },
            buildEvolutiveInvBran() {
                this.chartOptionsEvolutivoInvMarca = {
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
                                position: 'right',
                                offsetX: -10,
                                offsetY: 0
                            }
                        }
                    }],

                    xaxis: {
                        categories: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30],
                    },
                    series: [
                        {
                            name: 'Transmilenio',
                            data: [44, 55, 41, 67, 22, 43, 21, 49, 56, 89, 98, 78, 98, 12, 45, 65, 98, 78, 45, 12, 32, 65, 98, 78, 45, 1, 32, 65, 89, 45]
                        },
                        {
                            name: 'Vallas',
                            data: [15, 23, 20, 8, 13, 27, 33, 12, 56, 89, 87, 45, 12, 65, 98, 78, 45, 32, 56, 89, 78, 45, 32, 45, 98, 45, 32, 65, 78, 15]
                        },
                        {
                            name: 'Paraderos',
                            data: [41, 17, 15, 15, 21, 14, 15, 13, 45, 89, 45, 12, 65, 78, 45, 32, 64, 79, 15, 35, 65, 89, 78, 15, 45, 32, 65, 98, 78, 15]
                        }
                    ],
                    fill: {
                        opacity: 1
                    },

                    legend: {
                        position: 'bottom',
                        horizontalAlign: 'center'
                    }
                }
            }

        }
    }
</script>
