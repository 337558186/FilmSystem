import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import Registered from '../views/Registered'
import Index from '../views/Index'
import FIndex from '../views/front/index'

Vue.use(Router)

const router = new Router({
	routes: [
		{
			path: '/',
			name: 'login',
			component: Login
		}, {
			path: '/login',
			name: 'login',
			redirect: '/'  /*重定向*/
		},
		{
			path: '/registered',
			name: 'registered',
			component: Registered
		},
		{
			path: '/index',
			name: 'index',
			component: Index,
			meta:{
				isLogin:true    // 添加该字段，表示进入这个路由是需要登录的
			},
			children: [
				{
					path: 'userManage',
					name: 'userManage',
					component: () => import('../views/userManage.vue')
				}, {
					path: 'welcome',
					name: 'welcome',
					component: () => import('../views/Welcome')
				}, {
					path: 'home',
					name: 'home',
					component: () => import('../views/Home')
				}, {
					path: 'addFilm',
					name: 'addFilm',
					component: () => import('../views/AddFilm')
				}, {
					path: 'filmManage',
					name: 'filmManage',
					component: () => import('../views/FilmManage')
				}, {
					path: 'typeManage',
					name: 'typeManage',
					component: () => import('../views/TypeManage')
				},{
					path: 'filmChart',
					name: 'filmChart',
					component: ()=> import("../views/FilmChart")
				}
			]
		},
		{
			path: '/findex',
			name: 'findex',
			component: FIndex,
			children:[{
				path: 'allFilm',
				name: 'allFilm',
				component : ()=>import('../views/front/AllFilm')
			},{
				path: 'home',
				name: 'home',
				component : ()=>import('../views/front/Home')
			},{
				path: 'watch',
				name: 'watch',
				component : ()=>import('../views/front/Watch')
			},{
				path: 'welcome',
				name: 'welcome',
				component : ()=>import('../views/front/Welcome')
			}
			]
		}
	]
})

router.beforeEach((to,from,next)=>{
	if(to.matched.some(res=>res.meta.isLogin)){//判断是否需要登录
		if (localStorage['Flag']) {
			next();
		}else{
			next({
				path:"/login",
				query:{
					redirect:to.fullPath
				}
			});
		}

	}else{
		next()
	}
});



export default router
