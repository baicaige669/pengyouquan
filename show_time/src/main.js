import { createApp } from 'vue'
import './style.css'
import ElementPlus from 'element-plus' //全局引入
import 'element-plus/dist/index.css'
import App from './App.vue'
import axios from "axios";
import router from "./router/router.js";
import {createPinia} from "pinia";
const app = createApp(App)
let Pinia=createPinia()
axios.defaults.baseURL='http://47.117.175.240:6904'
app.use(ElementPlus)
app.use(router)
app.use(Pinia)
app.mount('#app')