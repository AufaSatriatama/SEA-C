import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
import {initAdminAccount} from './globalVariable.js'

initAdminAccount();

createApp(App).use(router).mount('#app')
//createApp(App).mount('#app')