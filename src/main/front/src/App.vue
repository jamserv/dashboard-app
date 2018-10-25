<template>
    <div id="app" class="dashboard">
        <nav class="site-navbar navbar navbar-default navbar-fixed-top navbar-mega" role="navigation">
            <div class="navbar-header" style="background-color: #263238 !important;">
                <div class="navbar-brand navbar-brand-center site-gridmenu-toggle" data-toggle="gridmenu">
                    <img class="navbar-brand-logo" src="assets/images/logo.png" title="Accionese">
                    <span class="navbar-brand-text hidden-xs"> Accionese</span>
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
                                <span class="badge badge-danger up">5</span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right dropdown-menu-media" role="menu">
                                <li class="dropdown-menu-header" role="presentation">
                                    <h5>NOTIFICACIONES</h5>
                                    <span class="label label-round label-danger">New 5</span>
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
                                                        <h6 class="media-heading">A new order has been placed</h6>
                                                        <time class="media-meta" datetime="2016-06-12T20:50:48+08:00">5
                                                            hours
                                                            ago
                                                        </time>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="media-left padding-right-10">
                                                        <i class="icon wb-user bg-green-600 white icon-circle"
                                                           aria-hidden="true"></i>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Completed the task</h6>
                                                        <time class="media-meta" datetime="2016-06-11T18:29:20+08:00">2
                                                            days
                                                            ago
                                                        </time>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="media-left padding-right-10">
                                                        <i class="icon wb-settings bg-red-600 white icon-circle"
                                                           aria-hidden="true"></i>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Settings updated</h6>
                                                        <time class="media-meta" datetime="2016-06-11T14:05:00+08:00">2
                                                            days
                                                            ago
                                                        </time>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="media-left padding-right-10">
                                                        <i class="icon wb-calendar bg-blue-600 white icon-circle"
                                                           aria-hidden="true"></i>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Event started</h6>
                                                        <time class="media-meta" datetime="2016-06-10T13:50:18+08:00">3
                                                            days
                                                            ago
                                                        </time>
                                                    </div>
                                                </div>
                                            </a>
                                            <a class="list-group-item" href="javascript:void(0)" role="menuitem">
                                                <div class="media">
                                                    <div class="media-left padding-right-10">
                                                        <i class="icon wb-chat bg-orange-600 white icon-circle"
                                                           aria-hidden="true"></i>
                                                    </div>
                                                    <div class="media-body">
                                                        <h6 class="media-heading">Message received</h6>
                                                        <time class="media-meta" datetime="2016-06-10T12:34:48+08:00">3
                                                            days
                                                            ago
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
                                        All notifications
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="navbar-avatar dropdown-toggle" data-toggle="dropdown" href="#"
                               aria-expanded="false"
                               data-animation="scale-up" role="button">
                                  <span class="avatar avatar-online">
                                      <img src="global/portraits/5.jpg" alt="...">
                                    <i></i>
                                  </span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li role="presentation">
                                    <a href="javascript:void(0)" role="menuitem"><i class="icon wb-user"
                                                                                    aria-hidden="true"></i>
                                        Profile</a>
                                </li>
                                <li role="presentation">
                                    <a href="javascript:void(0)" role="menuitem"><i class="icon wb-settings"
                                                                                    aria-hidden="true"></i> Settings</a>
                                </li>
                                <li class="divider" role="presentation"></li>
                                <li role="presentation">
                                    <a href="javascript:void(0)" role="menuitem"><i class="icon wb-power"
                                                                                    aria-hidden="true"></i> Logout</a>
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
                                    <i class="site-menu-icon wb-home" aria-hidden="true"></i>
                                    <span class="site-menu-title">Inicio</span>
                                    <div class="site-menu-badge">
                                        <span class="badge badge-success">3</span>
                                    </div>
                                </a>
                            </li>
                            <li class="site-menu-item has-sub">
                                <a href="#/about">
                                    <i class="site-menu-icon wb-pie-chart" aria-hidden="true"></i>
                                    <span class="site-menu-title">Dashboard</span>
                                    <span class="site-menu-arrow"></span>
                                </a>
                                <ul class="site-menu-sub">
                                    <li class="site-menu-item">
                                        <a class="animsition-link" href="#/home">
                                            <span class="site-menu-title">Chart.js</span>
                                        </a>
                                    </li>
                                    <li class="site-menu-item">
                                        <a class="animsition-link" href="#/home">
                                            <span class="site-menu-title">Gauges</span>
                                        </a>
                                    </li>
                                    <li class="site-menu-item">
                                        <a class="animsition-link" href="#/home">
                                            <span class="site-menu-title">Flot</span>
                                        </a>
                                    </li>
                                </ul>
                            </li>

                        </ul>
                        <div class="site-menubar-section" v-if="hideMenu">

                            <h5>Año</h5>
                            <div class="form-group">
                                <select class="form-control">
                                    <option>-</option>
                                    <option>2016</option>
                                    <option>2017</option>
                                </select>
                            </div>

                            <h5>Mes</h5>
                            <div class="form-group">
                                <select class="form-control">
                                    <option>-</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>

                            <h5>Marca</h5>
                            <div class="form-group">
                                <div class="input-search">
                                    <button type="submit" class="input-search-btn"><i class="icon wb-search"
                                                                                      aria-hidden="true"></i></button>
                                    <input class="form-control" name="" placeholder="Search..." type="text">
                                </div>
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
    export default {
        name: 'app',
        mounted() {
        },
        data() {
            return {
                hideMenu: true
            }
        },
        methods: {
            checkMenuStatus() {
                if(this.hideMenu) {
                    this.hideMenu = false;
                } else {
                    this.hideMenu = true;
                }
            }
        }
    }
</script>
