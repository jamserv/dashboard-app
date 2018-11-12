<template>
    <div id="app" class="dashboard">
        <nav class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega" role="navigation">
            <div class="navbar-header" style="background-color: #263238 !important;">
                <div class="navbar-brand navbar-brand-center site-gridmenu-toggle" data-toggle="gridmenu">
                    <img class="navbar-brand-logo" src="assets/images/logo.png" title="Accionese">
                    <span class="navbar-brand-text hidden-xs"> Acciones Especiales</span>
                </div>
                <button type="button" class="navbar-toggle collapsed" data-target="#site-navbar-search"
                        data-toggle="collapse">
                    <span class="sr-only">Toggle Search</span>
                    <i class="icon wb-search" aria-hidden="true"></i>
                </button>
            </div>
            <div class="navbar-container container-fluid">
                <!-- Navbar Collapse -->
                <div class="collapse navbar-collapse navbar-collapse-toolbar" id="site-navbar-collapse">
                    <!-- Navbar Toolbar -->
                    <ul class="nav navbar-toolbar">
                        <li class="hidden-float" id="toggleMenubar" @click="checkMenuStatus">
                            <a data-toggle="menubar" href="#" role="button">
                                <i class="icon hamburger hamburger-arrow-left">
                                    <span class="sr-only">Toggle menubar</span>
                                    <span class="hamburger-bar"></span>
                                </i>
                            </a>
                        </li>
                        <li class="hidden-xs" id="toggleFullscreen">
                            <a class="icon icon-fullscreen" data-toggle="fullscreen" href="#" role="button">
                                <span class="sr-only">Toggle fullscreen</span>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-toolbar navbar-right navbar-toolbar-right">
                        <li class="dropdown">

                        <li class="dropdown">
                            <a data-toggle="dropdown" href="javascript:void(0)" title="Notifications"
                               aria-expanded="false"
                               data-animation="scale-up" role="button">
                                <i class="icon wb-bell" aria-hidden="true"></i>
                                <span class="badge badge-danger up">1</span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right dropdown-menu-media" role="menu">
                                <li class="dropdown-menu-header" role="presentation">
                                    <h5>NOTIFICACIONES</h5>
                                    <span class="label label-round label-danger">Nuevas 1</span>
                                </li>
                                <li class="list-group" role="presentation">
                                    <div data-role="container">
                                        <div data-role="content">
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="media-left padding-right-10">
                                                        <i class="icon wb-order bg-red-600 white icon-circle"
                                                           aria-hidden="true"></i>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Tienes disponibles 11 nuevos
                                                            reportes</h6>
                                                        <time class="media-meta" datetime="2016-06-12T20:50:48+08:00">5
                                                            Horas
                                                            Nov
                                                        </time>
                                                    </div>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                </li>
                                <li class="dropdown-menu-footer" role="presentation">
                                    <a class="dropdown-menu-footer-btn" href="javascript:void(0)" role="button">
                                        <i class="icon wb-settings" aria-hidden="true"></i>
                                    </a>
                                    <a href="javascript:void(0)" role="menuitem">
                                        Todas las Notificaciones
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="navbar-avatar dropdown-toggle" data-toggle="dropdown" href="#"
                               aria-expanded="false"
                               data-animation="scale-up" role="button">
                                  <span class="avatar avatar-online">
                                      <img src="global/portraits/5.png" alt="...">
                                    <i></i>
                                  </span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation">
                                    <a href="javascript:void(0)" role="menuitem"><i class="icon wb-user"
                                                                                    aria-hidden="true"></i>
                                        Perfil</a>
                                </li>
                                <li role="presentation">
                                    <a href="javascript:void(0)" role="menuitem"><i class="icon wb-settings"
                                                                                    aria-hidden="true"></i> Ajustes</a>
                                </li>
                                <li class="divider" role="presentation"></li>
                                <li role="presentation">
                                    <a href="javascript:void(0)" role="menuitem"><i class="icon wb-power"
                                                                                    aria-hidden="true"></i> Cerrar
                                        Sesion</a>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
                <div class="collapse navbar-search-overlap" id="site-navbar-search">
                    <form role="search">
                        <div class="form-group">
                            <div class="input-search">
                                <i class="input-search-icon wb-search" aria-hidden="true"></i>
                                <input type="text" class="form-control" name="site-search" placeholder="Search...">
                                <button type="button" class="input-search-close icon wb-close"
                                        data-target="#site-navbar-search"
                                        data-toggle="collapse" aria-label="Close"></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </nav>
        <div class="site-menubar">
            <div class="site-menubar-body">
                <div>
                    <div>
                        <ul class="site-menu">
                            <li class="site-menu-category">General</li>
                            <li class="site-menu-item has-sub">
                                <a href="#/">
                                    <i class="site-menu-icon wb-pie-chart" aria-hidden="true"></i>
                                    <span class="site-menu-title">Dashboard</span>
                                    <div class="site-menu-badge">
                                        <span class="badge badge-success">11</span>
                                    </div>
                                </a>
                            </li>

                        </ul>
                        <div class="site-menubar-section" v-if="hideMenu">

                            <h5>Mes</h5>
                            <div class="form-group">

                                <multi-select v-model="month"
                                              searchPlaceholder="Buscar"
                                              :options="options"
                                              :btnLabel="btnLabel"
                                              :selectOptions="months"/>

                            </div>

                            <h5>Año</h5>
                            <div class="form-group">

                                <multi-select v-model="year"
                                              searchPlaceholder="Buscar"
                                              :options="options"
                                              :btnLabel="btnLabel"
                                              :selectOptions="years"/>

                            </div>

                            <h5>Ciudad</h5>
                            <div class="form-group">
                                <multi-select v-model="cities"
                                              search
                                              searchPlaceholder="Buscar"
                                              :options="options"
                                              :btnLabel="btnLabel"
                                              :selectOptions="allCities"/>
                            </div>

                            <h5>Marca</h5>
                            <div class="form-group">
                                <multi-select v-model="brand"
                                              search
                                              searchPlaceholder="Buscar"
                                              :options="options"
                                              :btnLabel="btnLabel"
                                              :selectOptions="brands"/>
                            </div>

                            <h5>Tipo</h5>
                            <div class="form-group">
                                <multi-select v-model="types"
                                              searchPlaceholder="Buscar"
                                              :options="options"
                                              :btnLabel="btnLabel"
                                              :selectOptions="alltypes"/>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <router-view></router-view>
    </div>

</template>
<script>
    import axios from 'axios'
    import {bus} from './main';

    import multiSelect from 'vue-multi-select'
    import 'vue-multi-select/dist/lib/vue-multi-select.min.css'

    export default {
        name: 'app',
        components: {
            multiSelect
        },
        mounted() {
            this.getBrands();
            this.getCities();
        },
        data() {
            return {
                btnLabel: '-- Todas --',
                options: {
                    multi: true,
                    cssSelected: option => (option.selected ? {'background-color': '#41b883'} : ''),
                },
                brand: [],
                brands: [],

                year: [],
                years: [2015, 2016, 2017],

                month: [],
                months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],

                cities: [],
                allCities: [],

                types: [],
                alltypes: ['Vallas', 'Paraderos', 'Transmilenio'],

                hideMenu: true,
                filter: {}
            }
        },
        methods: {
            getBrands() {
                let self = this;
                axios.get('/getAllBrands',
                ).then(function (response) {
                    var values = response.data;
                    values.forEach(function (element) {
                        self.brands.push(element.key);
                    });
                }).catch(function (error) {
                    return error;
                });
            },
            getCities() {
                let self = this;
                axios.get('/getCities',
                ).then(function (response) {
                    var values = response.data;
                    values.forEach(function (element) {
                        self.allCities.push(element.key);
                    });
                }).catch(function (error) {
                    return error;
                });
            },
            applyFilter() {
                let self = this;
                self.filter = {
                    months: self.month,
                    years: self.year,
                    cities: self.cities,
                    brands: self.brand,
                    types: self.types
                }
                bus.$emit('updateParams', self.filter);
            },
            checkMenuStatus() {
                if (this.hideMenu) {
                    this.hideMenu = false;
                } else {
                    this.hideMenu = true;
                }
            }
        },
        watch: {
            month: function (newval) {
                let s = parseInt(newval.toString().length);
                if (s >= 1) {
                    this.applyFilter();
                }
            },
            year: function (newval) {
                let s = parseInt(newval.toString().length);
                if (s >= 1) {
                    this.applyFilter();
                }
            },
            cities: function (newval) {
                let s = parseInt(newval.toString().length);
                if (s >= 1) {
                    this.applyFilter();
                }
            },
            brand: function (newval) {
                let s = parseInt(newval.toString().length);
                if (s >= 1) {
                    this.applyFilter();
                }
            },
            types: function (newval) {
                let s = parseInt(newval.toString().length);
                if (s >= 1) {
                    this.applyFilter();
                }
            }
        }
    }
</script>