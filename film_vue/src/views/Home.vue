<template>
	<div style="width: 600px;height: 400px">
		<table style="line-height: 50px">
			<tr>
				<td>用户名</td>
				<td>{{$store.getters.user.userName}}</td>
			</tr>
			<tr>
				<td>密码</td>
				<td>{{$store.getters.user.password}}</td>
			</tr>
			<tr>
				<td>手机号</td>
				<td>{{$store.getters.user.phone}}</td>
			</tr>
			<tr>
				<td>注册时间</td>
				<td>{{$store.getters.user.date}}</td>
			</tr>
			<tr>
				<td>账户状态</td>
				<td>{{$store.getters.user.state}}</td>
			</tr>

		</table>



		<!--
		<h1>个人中心</h1>
		<h2>用户名</h2>
		<p> {{$store.getters.user.userName}}</p>
		<h2>密码</h2>
		<p> {{$store.getters.user.password}}</p>
		<h2>手机号</h2>
		<p> {{$store.getters.user.phone}}</p>
		<h2>注册时间</h2>
		<p> {{$store.getters.user.date}}</p>
		<h2>账户状态</h2>
		<p> {{$store.getters.user.state}}</p>-->
	</div>
</template>

<script>
    export default {
        name: 'Home',
		data(){
            return{
                userInfo: {},
			}
		},
    }
</script>

<style scoped>

</style>
