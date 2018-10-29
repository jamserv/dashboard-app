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
                            <apexcharts height="450" type="line" :options="chartOptionsTopCampanas"
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
                            <apexcharts height="600" type="bar" :options="chartOptionsEvolutivoInvMarca"
                                        :series="chartOptionsEvolutivoInvMarca.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <vue-element-loading :active="isActive" :is-full-screen="true"/>


            </div>
        </div>
    </div>
</template>
<script>
    import VueApexCharts from 'vue-apexcharts'
    import axios from 'axios'
    import VueElementLoading from 'vue-element-loading'

    axios.defaults.baseURL = 'http://localhost:9898/api/dashboard';

    export default {
        components: {
            'apexcharts': VueApexCharts, VueElementLoading
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
        },
        data() {
            return {
                isActive: true,

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
            buildSparkLine() {
                this.sparkLine1 = {
                    tooltip: {
                        theme: 'dark'
                    },
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
                this.isActive = true
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
                        dataLabels: {
                            enabled: false,
                            offsetX: 0
                        },
                        stroke: {
                            curve: 'smooth',
                            width: 3
                        },
                        xaxis: {
                            labels: {
                                show: false
                            },
                            categories: data.categories
                        },
                        series: data.series,
                        tooltip: {
                            theme: 'dark'
                        }
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildInvSupportType() {
                this.isActive = true
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
                        stroke: {
                            show: true,
                            width: 1,
                            colors: ['#fff']
                        },
                        xaxis: {
                            labels: {
                                show: false
                            },
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
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return '$' + val.toFixed(2);
                                }
                            }
                        },
                        series: data.series
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildEvolutiveInvBranSupport() {
                this.isActive = true
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
                            labels: {
                                show: false
                            },
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
                                    return '$' + val.toFixed(2);
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
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildByInvCity() {
                this.isActive = true
                let self = this;
                axios.get('/getInvestmentByCity', {
                    params: null
                }).then(function (response) {
                    let data = response.data;
                    self.chartOptionsgInversionCity = {
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
                            labels: {
                                show: false
                            },
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
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return '$' + val.toFixed(2);
                                }
                            }
                        },
                        series: data.series
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildInvSector() {
                this.isActive = true
                let self = this;
                axios.get('/getEvolutiveInvestmentSector', {
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
                        series: data.series,
                        xaxis: {
                            labels: {
                                show: false
                            },
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
                            theme: 'dark',
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
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildTopCampanas() {
                this.isActive = true
                let self = this;
                axios.get('/getInvestmentByTopCampaign', {
                    params: null
                }).then(function (response) {
                    let data = response.data;
                    self.chartOptionsTopCampanas = {
                        tooltip: {
                            theme: 'dark'
                        },
                        chart: {
                            type: 'line'
                        },
                        dataLabels: {
                            enabled: false
                        },
                        series: data.series,
                        markers: {
                            size: 0,
                            style: 'full',
                        },
                        yaxis: {
                            labels: {
                                formatter: function (val) {
                                    return val.toFixed(2);
                                },
                            }
                        },
                        stroke: {
                            curve: 'smooth',
                            show: true,
                            width: 3
                        },
                        xaxis: {
                            categories: data.categories,
                            labels: {
                                show: false
                            }
                        },
                        legend: {
                            position: 'bottom',
                            horizontalAlign: 'center'
                        }
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildEvolutiveInvBran() {
                this.isActive = true
                let self = this;
                axios.get('/getEvolutiveBrandAnnualInvestment', {
                    params: null
                }).then(function (response) {
                    let data = response.data;
                    self.chartOptionsEvolutivoInvMarca = {
                        tooltip: {
                            theme: 'dark'
                        },
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
                            labels: {
                                show: false
                            },
                            categories: data.categories,
                        },
                        series: data.series,
                        fill: {
                            opacity: 1
                        },

                        legend: {
                            position: 'bottom',
                            horizontalAlign: 'center'
                        }
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            }
        }
    }
</script>
