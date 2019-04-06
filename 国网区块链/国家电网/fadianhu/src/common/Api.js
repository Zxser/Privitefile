import Vue from 'vue'
import VueResource from 'vue-resource'

Vue.use(VueResource);
// 配置API接口地址
var root = process.env.API_ROOT

// 每次将token传给后台
Vue.http.headers.common['Authorization'] = sessionStorage.getItem('accessToken');
Vue.http.headers.common['Accept'] = 'application/json'
Vue.http.headers.common['Access-Control-Allow-Origin'] = 'http://echarts.baidu.com,http://localhost:8082'

Vue.http.options.credentials = true;
Vue.http.options.emulateHTTP = true;

// 返回在vue模板中的调用接口
export default {
  rootImage:process.env.API_IMAGE,
  root : process.env.API_ROOT,
  get: function(url, params, success, failure) {
    return Vue.http.get( root + '/' + url, params, success, failure);
  },
  get2: function(url, params, success, failure) {
    return Vue.http.get( url, params, success, failure)
  },
  post: function(url, params, success, failure) {
    // params = JSON.stringify(params);
    return Vue.http.post( root + '/' + url, params).then(function(res){
      // Vue.http.headers.common['Authorization'] = sessionStorage.getItem('accessToken');
      if(res.body.token){
        Vue.http.headers.common['Authorization'] = res.body.token;
      }
      success(res);
    }, failure)

  },
  put: function(url, params, success, failure) {
    return Vue.http.put(root + '/' + url, params, success, failure)
  },
  delete: function(url, params, success, failure) {
    return Vue.http.delete( root + '/' + url, params, success, failure)
  },
  setToken(){
    Vue.http.headers.common['Authorization'] = sessionStorage.getItem('accessToken');
  }
}
