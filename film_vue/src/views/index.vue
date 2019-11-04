<template>
	<div>
		<el-container style="height: 710px; border: 1px solid #eee">
			<el-aside width="250px" style="background-color: rgb(238, 241, 246)">
				<el-menu :default-openeds="['1','2','3']"
						 :unique-opened="true" :router="true">

					<el-submenu index="1">
						<template slot="title"><i class="el-icon-s-home"></i>Welcome</template>
						<el-menu-item index="/index/welcome">欢迎页</el-menu-item>
					</el-submenu>

					<el-submenu index="2">
						<template slot="title"><i class="el-icon-chat-dot-square"></i>用户中心</template>
						<el-menu-item index="/index/userManage">用户管理</el-menu-item>
						<el-menu-item index="/index/home">个人中心</el-menu-item>
					</el-submenu>

					<el-submenu index="3">
						<template slot="title"><i class="el-icon-film"></i>影片中心</template>
						<el-menu-item index="/index/addFilm">添加影片</el-menu-item>
						<el-menu-item index="/index/filmManage">影片管理</el-menu-item>
						<el-menu-item index="/index/typeManage">类型管理</el-menu-item>
						<el-menu-item index="/index/filmChart">影片统计</el-menu-item>

					</el-submenu>

					<el-submenu index="4">
						<template slot="title"><i class="el-icon-setting"></i>导航三</template>
						<el-menu-item-group>
							<template slot="title">分组一</template>
							<el-menu-item index="4-1">选项1</el-menu-item>
							<el-menu-item index="4-2">选项2</el-menu-item>
						</el-menu-item-group>
						<el-menu-item-group title="分组2">
							<el-menu-item index="4-3">选项3</el-menu-item>
						</el-menu-item-group>
						<el-submenu index="3-4">
							<template slot="title">选项4</template>
							<el-menu-item index="4-4-1">选项4-1</el-menu-item>
						</el-submenu>
					</el-submenu>
				</el-menu>
			</el-aside>

			<el-container>
				<el-header style="text-align: right; font-size: 12px">
					<span style="margin-right: 470px;font-size: 30px;font-family: 楷体;color: #409EFF ">欢迎使用后台管理系统</span>
					<el-dropdown>
						<i class="el-icon-setting" style="margin-right: 15px"></i>
						<el-dropdown-menu slot="dropdown">
							<el-dropdown-item>
								<router-link :to="{path:'/index/home'}"> 个人信息</router-link>
							</el-dropdown-item>

							<el-dropdown-item @click.native="logOut">
								<!--<router-link :to="{path:'/login'}"> 退出登录</router-link>-->
								退出登录
							</el-dropdown-item>

						</el-dropdown-menu>
					</el-dropdown>
					<span>{{$store.getters.user.userName}}</span>
				</el-header>

				<el-main>
					<!--路由出口-->
					<router-view></router-view>
				</el-main>
			</el-container>
		</el-container>

	</div>
</template>

<script>
  export default {
    data () {
      return {}
    },
    methods: {
        logOut(){
            localStorage.removeItem('Flag');
            this.$router.push({path: '/login'})
		}
	},
    components: {},
    computed: {}
  }
</script>

<style>
	.el-header, .el-footer {
		background-color: #B3C0D1;
		color: #333;
		text-align: center;
		line-height: 60px;
	}

	.el-aside {
		background-color: #D3DCE6;
		color: #333;
		text-align: center;
		line-height: 200px;
	}

	.el-main {
		background-color: #E9EEF3;
		color: #333;
		text-align: center;
		line-height: 160px;
	}

	body > .el-container {
		margin-bottom: 40px;
	}

	.el-container:nth-child(5) .el-aside,
	.el-container:nth-child(6) .el-aside {
		line-height: 260px;
	}

	.el-container:nth-child(7) .el-aside {
		line-height: 320px;
	}
	a {
		text-decoration: none;
	}

	.router-link-active {
		text-decoration: none;
	}
</style>
