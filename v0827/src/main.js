import { createApp } from 'vue'

import App from './App.vue'
import routeConfig from './routers'
import { createPinia } from 'pinia'

import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle';
import BootstrapVue3 from 'bootstrap-vue-3';

createApp(App)
.use(routeConfig)
.use(createPinia())
.use(BootstrapVue3)
.mount('#app')