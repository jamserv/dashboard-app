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
                                    <i class="site-menu-icon wb-pie-chart" aria-hidden="true"></i>
                                    <span class="site-menu-title">Dashboard</span>
                                    <div class="site-menu-badge">
                                        <span class="badge badge-success">11</span>
                                    </div>
                                </a>
                            </li>

                        </ul>
                        <div class="site-menubar-section" v-if="hideMenu">

                            <h5>Año</h5>
                            <div class="form-group">

                                <select @change="applyFilter" v-model="years" class="form-control">
                                    <option>--</option>
                                    <option>2015</option>
                                    <option>2016</option>
                                    <option>2017</option>
                                </select>

                            </div>

                            <h5>Marca</h5>
                            <div class="form-group">
                                <multiselect v-model="brand" :options="brands"
                                             :multiple="true"
                                             placeholder=" -- Todas -- "
                                             selectLabel=""
                                             selectedLabel=""
                                             deselectLabel=""
                                             showLabels="false"
                                             :taggable="true"
                                             @remove="applyFilter"
                                             @select="applyFilter"
                                             @tag="addTag">
                                </multiselect>
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
    import Multiselect from 'vue-multiselect'

    export default {
        name: 'app',
        components: {
            Multiselect
        },
        mounted() {
            this.getBrands();
        },
        data() {
            return {
                brand: [],
                brands:[],
                years:[],
                hideMenu: true,
            }
        },
        methods: {
            addTag (newTag) {
                const tag = {
                    name: newTag,
                    code: newTag.substring(0, 2) + Math.floor((Math.random() * 10000000))
                }
                this.brands.push(tag)
                this.brand.push(tag)
            },
            getBrands() {
                let self = this;
                axios.get('/getAllBrands',
                ).then(function (response) {
                    var values = response.data;
                    values.forEach(function(element) {
                        self.brands.push(element.key);
                    });
                }).catch(function (error) {
                    return error;
                });
            },
            applyFilter() {
                bus.$emit('updateParams', this.years);
            },
            checkMenuStatus() {
                if (this.hideMenu) {
                    this.hideMenu = false;
                } else {
                    this.hideMenu = true;
                }
            }
        }
    }
</script>

<style>
    fieldset[disabled] .multiselect{pointer-events:none}.multiselect__spinner{position:absolute;right:1px;top:1px;width:48px;height:35px;background:#fff;display:block}.multiselect__spinner:after,.multiselect__spinner:before{position:absolute;content:"";top:50%;left:50%;margin:-8px 0 0 -8px;width:16px;height:16px;border-radius:100%;border-color:#41b883 transparent transparent;border-style:solid;border-width:2px;box-shadow:0 0 0 1px transparent}.multiselect__spinner:before{animation:a 2.4s cubic-bezier(.41,.26,.2,.62);animation-iteration-count:infinite}.multiselect__spinner:after{animation:a 2.4s cubic-bezier(.51,.09,.21,.8);animation-iteration-count:infinite}.multiselect__loading-enter-active,.multiselect__loading-leave-active{transition:opacity .4s ease-in-out;opacity:1}.multiselect__loading-enter,.multiselect__loading-leave-active{opacity:0}.multiselect,.multiselect__input,.multiselect__single{font-family:inherit;font-size:12px;-ms-touch-action:manipulation;touch-action:manipulation}.multiselect{box-sizing:content-box;display:block;position:relative;width:100%;min-height:40px;text-align:left;color:#35495e}.multiselect *{box-sizing:border-box}.multiselect:focus{outline:0}.multiselect--active{z-index:1}.multiselect--active:not(.multiselect--above) .multiselect__current,.multiselect--active:not(.multiselect--above) .multiselect__input,.multiselect--active:not(.multiselect--above) .multiselect__tags{border-bottom-left-radius:0;border-bottom-right-radius:0}.multiselect--active .multiselect__select{transform:rotate(180deg)}.multiselect--above.multiselect--active .multiselect__current,.multiselect--above.multiselect--active .multiselect__input,.multiselect--above.multiselect--active .multiselect__tags{border-top-left-radius:0;border-top-right-radius:0}.multiselect__input,.multiselect__single{position:relative;display:inline-block;min-height:35px;line-height:20px;border:5px;border-radius:5px;background:#fff;padding:0 0 0 5px;width:100%;transition:border .1s ease;box-sizing:border-box;margin-bottom:8px;vertical-align:top}.multiselect__input::-webkit-input-placeholder{color:#35495e}.multiselect__input:-ms-input-placeholder{color:#35495e}.multiselect__input::placeholder{color:#35495e}.multiselect__tag~.multiselect__input,.multiselect__tag~.multiselect__single{width:auto}.multiselect__input:hover,.multiselect__single:hover{border-color:#cfcfcf}.multiselect__input:focus,.multiselect__single:focus{border-color:#a8a8a8;outline:0}.multiselect__single{padding-left:5px;margin-bottom:8px}.multiselect__tags-wrap{display:inline}.multiselect__tags{min-height:40px;display:block;padding:8px 40px 0 8px;border-radius:5px;font-size:14px}.multiselect__tag{position:relative;display:inline-block;padding:4px 26px 4px 10px;border-radius:5px;margin-right:10px;color:#fff;line-height:1;background:#41b883;margin-bottom:5px;white-space:nowrap;overflow:hidden;max-width:100%;text-overflow:ellipsis}.multiselect__tag-icon{cursor:pointer;margin-left:7px;position:absolute;right:0;top:0;bottom:0;font-weight:700;font-style:normal;width:22px;text-align:center;line-height:22px;transition:all .2s ease;border-radius:5px}.multiselect__tag-icon:after{content:"\D7";color:#266d4d;font-size:14px}.multiselect__tag-icon:focus,.multiselect__tag-icon:hover{background:#369a6e}.multiselect__tag-icon:focus:after,.multiselect__tag-icon:hover:after{color:#fff}.multiselect__current{min-height:40px;overflow:hidden;padding:8px 30px 0 12px;white-space:nowrap;border-radius:5px;border:1px solid #e8e8e8}.multiselect__current,.multiselect__select{line-height:16px;box-sizing:border-box;display:block;margin:0;text-decoration:none;cursor:pointer}.multiselect__select{position:absolute;width:40px;height:38px;right:1px;top:1px;padding:4px 8px;text-align:center;transition:transform .2s ease}[dir=rtl] .multiselect,[dir=rtl] .multiselect__content{text-align:right}.multiselect__select:before{position:relative;right:0;top:65%;color:#999;margin-top:4px;border-style:solid;border-width:5px 5px 0;border-color:#999 transparent transparent;content:""}.multiselect__placeholder{color:#adadad;display:inline-block;margin-bottom:10px;padding-top:2px}.multiselect--active .multiselect__placeholder{display:none}.multiselect__content-wrapper{background:#fff;width:100%;overflow:auto;border:1px solid #e8e8e8;border-top:none;border-bottom-left-radius:5px;border-bottom-right-radius:5px;z-index:1;-webkit-overflow-scrolling:touch}.multiselect__content{list-style:none;display:inline-block;padding:0;margin:0;min-width:100%;vertical-align:top}.multiselect--above .multiselect__content-wrapper{bottom:100%;border-bottom:none;border-top:1px solid #e8e8e8;border-radius:5px 5px 0 0}.multiselect__content::webkit-scrollbar{display:none}.multiselect__element{display:block}.multiselect__option{display:block;padding:12px;min-height:30px;line-height:16px;text-decoration:none;text-transform:none;vertical-align:middle;position:relative;cursor:pointer;white-space:nowrap}.multiselect__option:after{top:0;right:0;position:absolute;line-height:40px;padding-right:12px;padding-left:20px;font-size:13px}.multiselect__option--highlight{background:#41b883;outline:0;color:#fff}.multiselect__option--highlight:after{content:attr(data-select);background:#41b883;color:#fff}.multiselect__option--selected{background:#f3f3f3;color:#35495e;font-weight:700}.multiselect__option--selected:after{content:attr(data-selected);color:silver}.multiselect__option--selected.multiselect__option--highlight{background:#ff6a6a;color:#fff}.multiselect__option--selected.multiselect__option--highlight:after{background:#ff6a6a;content:attr(data-deselect);color:#fff}.multiselect--disabled{opacity:.6;background:#ededed;pointer-events:none}.multiselect--disabled .multiselect__current,.multiselect--disabled .multiselect__select,.multiselect__option--disabled{background:#ededed;color:#a6a6a6}.multiselect__option--disabled{cursor:text;pointer-events:none}.multiselect__option--group{background:#ededed;color:#35495e}.multiselect__option--group.multiselect__option--highlight{background:#35495e;color:#fff}.multiselect__option--group.multiselect__option--highlight:after{background:#35495e}.multiselect__option--disabled.multiselect__option--highlight{background:#dedede}.multiselect__option--group-selected.multiselect__option--highlight{background:#ff6a6a;color:#fff}.multiselect__option--group-selected.multiselect__option--highlight:after{background:#ff6a6a;content:attr(data-deselect);color:#fff}.multiselect-enter-active,.multiselect-leave-active{transition:all .15s ease}.multiselect-enter,.multiselect-leave-active{opacity:0}.multiselect__strong{margin-bottom:8px;line-height:20px;display:inline-block;vertical-align:top}[dir=rtl] .multiselect__select{right:auto;left:1px}[dir=rtl] .multiselect__tags{padding:8px 8px 0 40px}[dir=rtl] .multiselect__option:after{right:auto;left:0}[dir=rtl] .multiselect__clear{right:auto;left:12px}[dir=rtl] .multiselect__spinner{right:auto;left:1px}@keyframes a{0%{transform:rotate(0)}to{transform:rotate(2turn)}}
</style>