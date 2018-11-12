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
                        <div>
                            <apexcharts height="350" type="area" :options="chartOptionsg1"
                                        :series="chartOptionsg1.series"></apexcharts>
                        </div>
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

                        <button type="button" @click="changeStatusGraph('graph1')" class="btn btn-outline btn-default">
                            Ver
                            esta Gráfica
                        </button>

                        <div>
                            <apexcharts v-if="vg1" height="500" type="bar" :options="chartOptionsg3"
                                        :series="chartOptionsg3.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsgInversionCity">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Inversión por Ciudad</p>
                        <button type="button" @click="changeStatusGraph('graph2')" class="btn btn-outline btn-default">
                            Ver
                            esta Gráfica
                        </button>
                        <div>
                            <apexcharts v-if="vg2" height="450" type="bar" :options="chartOptionsgInversionCity"
                                        :series="chartOptionsgInversionCity.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsgInversionSector">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversión por Sector</p>
                        <button type="button" @click="changeStatusGraph('graph3')" class="btn btn-outline btn-default">
                            Ver
                            esta Gráfica
                        </button>
                        <div>
                            <apexcharts v-if="vg3" height="600" type="bar" :options="chartOptionsgInversionSector"
                                        :series="chartOptionsgInversionSector.series"></apexcharts>
                        </div>
                    </div>
                </div>


                <div class="row" v-show="chartOptionsTopCampanas">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">TOP Campañas</p>
                        <button type="button" @click="changeStatusGraph('graph4')" class="btn btn-outline btn-default">
                            Ver
                            esta Gráfica
                        </button>
                        <div>
                            <apexcharts v-if="vg4" height="450" type="line" :options="chartOptionsTopCampanas"
                                        :series="chartOptionsTopCampanas.series"></apexcharts>
                        </div>
                    </div>
                </div>

                <div class="row" v-show="chartOptionsEvolutivoInvMarca">
                    <div class="col-md-12 info-panel">
                        <br/>
                        <br/>
                        <p class="font-size-20 blue-grey-700">Evolutivo Inversión por Marca</p>
                        <button type="button" @click="changeStatusGraph('graph5')" class="btn btn-outline btn-default">
                            Ver
                            esta Gráfica
                        </button>
                        <div>
                            <apexcharts v-if="vg5" height="600" type="bar" :options="chartOptionsEvolutivoInvMarca"
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

    //axios.defaults.baseURL = 'http://104.237.159.49:9898/api/dashboard';
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
                this.years = '';
                this.months = '';
                this.cities = '';
                this.types = '';
                var count = 0;
                filter.brands.forEach(function (element) {
                    if (count > 0) {
                        self.brands += ' OR ' + element;
                    } else {
                        self.brands += element;
                    }
                    count++;
                });
                count = 0;
                filter.years.forEach(function (element) {
                    if (count > 0) {
                        self.years += ' OR ' + element;
                    } else {
                        self.years += element;
                    }
                    count++;
                });
                count = 0;
                filter.months.forEach(function (element) {
                    if (count > 0) {
                        self.months += ' OR ' + element;
                    } else {
                        self.months += element;
                    }
                    count++;
                });
                count = 0;
                filter.cities.forEach(function (element) {
                    if (count > 0) {
                        self.cities += ' OR ' + element;
                    } else {
                        self.cities += element;
                    }
                    count++;
                });
                count = 0;
                filter.types.forEach(function (element) {
                    if (count > 0) {
                        self.types += ' OR ' + element;
                    } else {
                        self.types += element;
                    }
                    count++;
                });
                this.runAllRequest();
            });

            this.runAllRequest();
        },
        data() {
            return {
                vg1: false,
                vg2: false,
                vg3: false,
                vg4: false,
                vg5: false,

                isActive: true,

                months: '--',
                years: '--',
                cities: '--',
                brands: '--',
                types: '--',

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
                    series: []
                },
                chartOptionsg1: {
                    series: []
                },
                chartOptionsg2: {
                    series: []
                },
                chartOptionsg3: {
                    series: []
                },
                chartOptionsgInversionCity: {
                    series: []
                },
                chartOptionsgInversionSector: {
                    series: []
                },
                chartOptionsTopCampanas: {
                    series: []
                },
                chartOptionsEvolutivoInvMarca: {
                    series: []
                }
            }
        },
        methods: {
            changeStatusGraph(graphic) {
                switch (graphic) {
                    case 'graph1':
                        if (this.vg1) {
                            this.vg1 = false;
                        } else {
                            this.vg1 = true;
                            //this.buildEvolutiveInvBranSupport();
                        }
                        break;
                    case 'graph2':
                        if (this.vg2) {
                            this.vg2 = false;
                        } else {
                            this.vg2 = true;
                            //this.buildByInvCity();
                        }
                        break;
                    case 'graph3':
                        if (this.vg3) {
                            this.vg3 = false;
                        } else {
                            this.vg3 = true;
                            //this.buildInvSector();
                        }
                        break;
                    case 'graph4':
                        if (this.vg4) {
                            this.vg4 = false;
                        } else {
                            this.vg4 = true;
                            //this.buildTopCampanas();
                        }
                        break;
                    case 'graph5':
                        if (this.vg5) {
                            this.vg5 = false;
                        } else {
                            this.vg5 = true;
                            //this.buildEvolutiveInvBran();
                        }
                        break;
                }
            },
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
                axios.get('/getTotalInversmentVallas' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                ).then(function (response) {
                    var data = response.data;
                    self.vallastotal = 0;
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
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return '$' + self.formatPrice(val);
                                }
                            }
                        }
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildTotalInversionParaderos() {
                this.isActive = true
                let self = this;

                axios.get('/getTotalInversmentParaderos' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                ).then(function (response) {
                    var data = response.data;
                    self.paraderostotal = 0;
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
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return '$' + self.formatPrice(val);
                                }
                            }
                        }
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildTotalInversionSitm() {
                this.isActive = true
                let self = this;
                axios.get('/getTotalInversmentSitm' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                ).then(function (response) {
                    var data = response.data;
                    self.sitmtotal = 0;
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
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return '$' + self.formatPrice(val);
                                }
                            }
                        }
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },
            buildTotalInversion() {
                this.isActive = true
                let self = this;

                axios.get('/getTotalInversment' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                ).then(function (response) {
                    var data = response.data;
                    self.invtotal = 0;
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
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return '$' + self.formatPrice(val);
                                }
                            }
                        }
                    }
                    self.isActive = false
                }).catch(function (error) {
                    return error;
                });
            },

            buildEvolutiveInvMonths() {
                this.isActive = true
                let self = this;

                axios.get('/getEvolutiveInvMonths' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                    + '&types=' + this.types
                ).then(function (response) {
                    var data = response.data;
                    self.chartOptionsg1 = {
                        chart: {
                            type: 'area',
                            toolbar: {
                                show: false
                            },
                        },
                        dataLabels: {
                            enabled: false
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
                                    return '$' + self.formatPrice(val);
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
                axios.get('/getInvBySupportType' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                    + '&types=' + this.types).then(function (response) {
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
                                }
                            }
                        },
                        tooltip: {
                            theme: 'dark',
                            y: {
                                formatter: function (val) {
                                    return '$' + self.formatPrice(val);
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
                axios.get('/getEvolutiveInvertionBranBySupportTypeService' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                    + '&types=' + this.types).then(function (response) {
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
                axios.get('/getInvestmentByCity' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&types=' + this.types).then(function (response) {
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
                                    return '$' + self.formatPrice(val);
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
                axios.get('/getEvolutiveInvestmentSector' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                    + '&types=' + this.types).then(function (response) {
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
                axios.get('/getInvestmentByTopCampaign' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                    + '&types=' + this.types).then(function (response) {
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
                axios.get('/getEvolutiveBrandAnnualInvestment' +
                    '?years=' + this.years
                    + '&months=' + this.months
                    + '&cities=' + this.cities
                    + '&brands=' + this.brands
                    + '&types=' + this.types).then(function (response) {
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
