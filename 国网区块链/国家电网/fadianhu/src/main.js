// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import api from './common/Api.js'// 引用API文件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'

Vue.use(ElementUI)
Vue.prototype.$api = api// 将API方法绑定到全局
Vue.config.productionTip = false

/*router.beforeEach((to, from, next) => {
  // alert(sessionStorage.getItem('accessToken'))
  //    console.log(to);
  if ((to.path!='/login')&&(!sessionStorage.getItem('accessToken') || sessionStorage.getItem('accessToken')=='undefined')) {
    next({
      path: '/login',
      // query: { redirect: to.fullPath }
    })
  } else {
    next()
  }
})*/

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
