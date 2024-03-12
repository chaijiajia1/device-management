import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store/index'
import 'leaflet/dist/leaflet.css';
Vue.use(ElementUI,{size:"small"});

//插件配置
const axios = require('axios') //引入axios模块。将值赋给变量axios
axios.defaults.baseURL= 'http://localhost:8443/api' //设置代理。默认请求地址为后端服务器的API地址
Vue.prototype.$axios = axios //在Vue.js的原型对象上添加$axios属性，将axios对象赋值给该属性，这样在Vue.js实力中就可以通过this.$axios访问axios对象， 不用在每个组件中引入axios模块
Vue.prototype.$store = store
Vue.config.productionTip = false

//若访问路径需要登录，判断store里有没有储存user，没有的话跳转登录页面，并储存访问的路径，以便登录后跳转
router.beforeEach((to,from,next) => {
  //console.log("111")
  if(to.meta.requireAuth===true &&store.state.user.username===''){
    next({
      path: 'login',
      query:{redirect:to.fullPath}
    })//调用next函数进行跳转
  }
  else{ next() }//不跳转
}
)

new Vue({
  router,
  render: h => h(App),
  store
}).$mount('#app')
