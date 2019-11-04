// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios';   /*使用axios*/
import store from './store/store.js'
import echarts from 'echarts'   /*使用echart*/
import Video from 'video.js'    /*视频播放*/
import 'video.js/dist/video-js.css'

Vue.prototype.$video = Video
Vue.prototype.$echarts = echarts
Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.prototype.axios= axios
axios.defaults.baseURL ='http://localhost:8080/'; //配置请求地址


//刷新保存状态
if (sessionStorage.getItem("store")) {
	store.replaceState(
		Object.assign(
			{},
			store.state,
			JSON.parse(sessionStorage.getItem("store"))
		)
	);
	sessionStorage.removeItem("store")
}
//监听，在页面刷新时将vuex里的信息保存到sessionStorage里
window.addEventListener("beforeunload", () => {
	sessionStorage.setItem("store", JSON.stringify(store.state));
});


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store: store,
  components: { App },
  template: '<App/>'
})
