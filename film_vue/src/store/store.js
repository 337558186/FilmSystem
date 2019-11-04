import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const actions = {}
const mutations = {
	handleUser: (state, user) => {
		state.user = user
		// 把登录的用户的名保存到localStorage中，防止页面刷新，导致vuex重新启动，用户名就成为初始值（初始值为空）的情况
		localStorage.setItem('user', user)
		localStorage.setItem('Flag', 'isLogin')
	},
	/*点击观看将电影信息存储*/
	handleFilm: (state, film) => {
		state.film = film
		localStorage.setItem('film', film)
	},
}
const state = {
	user: '' || localStorage.getItem('user'),
	film: '' || localStorage.getItem('film')
}
// getters 只会依赖 state 中的成员去更新
const getters = {
	user: (state) => state.user,
	film: (state) =>state.film
}

const store = new Vuex.Store({
	actions,
	mutations,
	state,
	getters
})

export default store
