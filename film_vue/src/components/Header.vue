<template>
    <div>
		<router-link :to="{path:'/findex'}"> 主页</router-link>
		<router-link :to="{path:'/findex/allFilm'}"> 全部电影</router-link>
		<router-link :to="{path:'/index/home'}"> 个人信息</router-link>
	</div>
</template>

<script>
    export default {
        name: 'Header'
    }
</script>

<style scoped>

</style>
