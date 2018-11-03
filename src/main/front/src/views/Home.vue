<template>
    <div>
        <div class="page">
            <div class="page-content padding-30 container-fluid">
                <div class="row">
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-warning">
                                    <i class="icon wb-check"></i>
                                </button>
                                <span class="ml-15 font-weight-400">VALLAS</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-success icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-26 font-weight-100">${{vallastotal}}</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">Inversión Total</p>
                                    <apexcharts height="80" type="pie" :options="chartTotalInvVallas"
                                                :series="chartTotalInvVallas.series"></apexcharts>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-danger">
                                    <i class="icon wb-check"></i>
                                </button>
                                <span class="ml-15 font-weight-400">PARADEROS</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-success icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-26 font-weight-100">${{paraderostotal}}</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">Inversión Total</p>
                                    <apexcharts height="80" type="pie" :options="chartTotalInvParaderos"
                                                :series="chartTotalInvParaderos.series"></apexcharts>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-success">
                                    <i class="icon wb-check"></i>
                                </button>
                                <span class="ml-15 font-weight-400">SITM</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-success icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-26 font-weight-100">${{sitmtotal}}</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">Inversión Total</p>
                                    <apexcharts height="80" type="pie" :options="chartTotalInvSitm"
                                                :series="chartTotalInvSitm.series"></apexcharts>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-2 col-md-3 info-panel">
                        <div class="card card-shadow">
                            <div class="card-block bg-white p-20">
                                <button type="button" class="btn btn-floating btn-sm btn-primary">
                                    <i class="icon wb-check"></i>
                                </button>
                                <span class="ml-15 font-weight-400">TOTAL</span>
                                <div class="content-text text-center mb-0">
                                    <i class="text-success icon wb-triangle-up font-size-20">
                                    </i>
                                    <span class="font-size-26 font-weight-100">${{invtotal}}</span>
                                    <p class="blue-grey-400 font-weight-100 m-0">Inversión Total</p>
                                    <apexcharts height="80" type="pie" :options="chartTotalInv"
                                                :series="chartTotalInv.series"></apexcharts>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row" v-show="chartOptionsg1">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversión Mensual</p>
                        <divrea>
                            <apexcharts height="350" type="area" :options="chartOptionsg1"
                                        :series="chartOptionsg1.series"></apexcharts>
                        </divrea>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsg2">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Inversión por Tipo de Soporte</p>
                        <div>
                            <apexcharts height="350" type="bar" :options="chartOptionsg2"
                                        :series="chartOptionsg2.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsg3">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversión Marca por Tipo Soporte</p>
                        <div>
                            <apexcharts height="500" type="bar" :options="chartOptionsg3"
                                        :series="chartOptionsg3.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsgInversionCity">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Inversión por Ciudad</p>
                        <div>
                            <apexcharts height="450" type="bar" :options="chartOptionsgInversionCity"
                                        :series="chartOptionsgInversionCity.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsgInversionSector">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversión por Sector</p>
                        <div>
                            <apexcharts height="600" type="bar" :options="chartOptionsgInversionSector"
                                        :series="chartOptionsgInversionSector.series"></apexcharts>
                        </div>
                    </div>
                </div>


                <div class="row" v-show="chartOptionsTopCampanas">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">TOP Campañas</p>
                        <div>
                            <apexcharts height="450" type="line" :options="chartOptionsTopCampanas"
                                        :series="chartOptionsTopCampanas.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsEvolutivoInvMarca">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversión por Marca</p>
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
    import {bus} from '../main';

    axios.defaults.baseURL = 'http://localhost:9898/api/dashboard';

    export default {
        components: {
            'apexcharts': VueApexCharts, VueElementLoading
        },
        name: 'about',
        mounted() {
            let self = this;
            bus.$on('updateParams', (filter) => {
                this.brands = '';
                this.years = filter.year;
                var count = 0;
                filter.brands.forEach(function (element) {
                    if (count > 0) {
                        self.brands += ' OR ' + element;
                    } else {
                        self.brands += element;
                    }
                    count++;
                });
                this.runAllRequest();
            });

            this.runAllRequest();
        },
        data() {
            return {
                isActive: true,
                years: '--',
                brands: '--',

                vallastotal: 0,
                paraderostotal: 0,
                sitmtotal: 0,
                invtotal: 0,

                chartTotalInvVallas: {
                    series: []
                },
                chartTotalInvParaderos: {
                    series: []
                },
                chartTotalInvSitm: {
                    series: []
                },
                chartTotalInv: {
                    series: []
                },
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
            runAllRequest() {
                this.buildTotalInversionVallas();
                this.buildTotalInversionParaderos();
                this.buildTotalInversionSitm();
                this.buildTotalInversion();
                this.buildEvolutiveInvMonths();
                this.buildInvSupportType();
                this.buildEvolutiveInvBranSupport();
                this.buildByInvCity();
                this.buildInvSector();
                this.buildTopCampanas();
                this.buildEvolutiveInvBran();
            },

            buildTotalInversionVallas() {
                this.isActive = true
                let self = this;
                axios.get('/getTotalInversmentVallas?years=' + this.years
                ).then(function (response) {
                    var data = response.data;
                    data.numericSeries.forEach(function (element) {
                        self.vallastotal += element;
                    });
                    self.vallastotal = self.formatPrice(self.vallastotal);
                    self.chartTotalInvVallas = {
                        chart: {
                            height: 100,
                            type: 'bar'
                        },
                        plotOptions: {
                            bar: {
                                horizontal: true,
                            }
                        },
                        series: [{
                            data: data.numericSeries
                        }],
                        xaxis: {
                            labels: {
                                show: false
                            },
                            categories: data.numericCategories,
                        },
                        dataLabels: {
                            enabled: false,
                            offsetX: 0
                        },
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildTotalInversionParaderos() {
                this.isActive = true
                let self = this;

                axios.get('/getTotalInversmentParaderos?years=' + this.years
                ).then(function (response) {
                    var data = response.data;
                    data.numericSeries.forEach(function (element) {
                        self.paraderostotal += element;
                    });
                    self.paraderostotal = self.formatPrice(self.paraderostotal);
                    self.chartTotalInvParaderos = {
                        chart: {
                            height: 100,
                            type: 'bar'
                        },
                        plotOptions: {
                            bar: {
                                horizontal: true,
                            }
                        },
                        series: [{
                            data: data.numericSeries
                        }],
                        xaxis: {
                            labels: {
                                show: false
                            },
                            categories: data.numericCategories,
                        },
                        dataLabels: {
                            enabled: false,
                            offsetX: 0
                        },
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildTotalInversionSitm() {
                this.isActive = true
                let self = this;

                axios.get('/getTotalInversmentSitm?years=' + this.years
                ).then(function (response) {
                    var data = response.data;
                    data.numericSeries.forEach(function (element) {
                        self.sitmtotal += element;
                    });
                    self.sitmtotal = self.formatPrice(self.sitmtotal);
                    self.chartTotalInvSitm = {
                        chart: {
                            height: 100,
                            type: 'bar'
                        },
                        plotOptions: {
                            bar: {
                                horizontal: true,
                            }
                        },
                        series: [{
                            data: data.numericSeries
                        }],
                        xaxis: {
                            labels: {
                                show: false
                            },
                            categories: data.numericCategories,
                        },
                        dataLabels: {
                            enabled: false,
                            offsetX: 0
                        },
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildTotalInversion() {
                this.isActive = true
                let self = this;

                axios.get('/getTotalInversment?years=' + this.years
                ).then(function (response) {
                    var data = response.data;
                    data.numericSeries.forEach(function (element) {
                        self.invtotal += element;
                    });
                    self.invtotal = self.formatPrice(self.invtotal);
                    self.chartTotalInv = {
                        chart: {
                            height: 100,
                            type: 'bar'
                        },
                        plotOptions: {
                            bar: {
                                horizontal: true,
                            }
                        },
                        series: [{
                            data: data.numericSeries
                        }],
                        xaxis: {
                            labels: {
                                show: false
                            },
                            categories: data.numericCategories,
                        },
                        dataLabels: {
                            enabled: false,
                            offsetX: 0
                        },
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },

            buildEvolutiveInvMonths() {
                this.isActive = true
                let self = this;

                axios.get('/getEvolutiveInvMonths?years=' + this.years + '&brands=' + this.brands
                ).then(function (response) {
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
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return self.formatPrice(val);
                                }
                            }
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
                axios.get('/getInvBySupportType?years=' + this.years).then(function (response) {
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
                                    return self.formatPrice(val);
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
                axios.get('/getEvolutiveInvertionBranBySupportTypeService?years=' + this.years + '&brands=' + this.brands).then(function (response) {
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
                                show: false
                            }
                        },
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return self.formatPrice(val);
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
                axios.get('/getInvestmentByCity?years=' + this.years).then(function (response) {
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
                                    return self.formatPrice(val);
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
                axios.get('/getEvolutiveInvestmentSector?years=' + this.years).then(function (response) {
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
                                show: false
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
                axios.get('/getInvestmentByTopCampaign?years=' + this.years + '&brands=' + this.brands).then(function (response) {
                    let data = response.data;
                    self.chartOptionsTopCampanas = {
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return self.formatPrice(val);
                                }
                            }
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
                axios.get('/getEvolutiveBrandAnnualInvestment?years=' + this.years + '&brands=' + this.brands).then(function (response) {
                    let data = response.data;
                    self.chartOptionsEvolutivoInvMarca = {
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return self.formatPrice(val);
                                }
                            }
                        },
                        chart: {
                            height: 600,
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
                        yaxis: {
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
            formatPrice(value) {
                let val = (value / 1).toFixed(2).replace('.', ',')
                return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
            }
        }
    }
</script>
